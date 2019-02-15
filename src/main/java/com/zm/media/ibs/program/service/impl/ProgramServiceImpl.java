package com.zm.media.ibs.program.service.impl;

import com.zm.media.common.util.SnowflakeIdWorker;
import com.zm.media.ibs.program.entity.*;
import com.zm.media.ibs.program.entity.vo.ElementVO;
import com.zm.media.ibs.program.entity.vo.ProgramVO;
import com.zm.media.ibs.program.persistence.ElementMapper;
import com.zm.media.ibs.program.persistence.ElementMaterialMapper;
import com.zm.media.ibs.program.persistence.MaterialMapper;
import com.zm.media.ibs.program.persistence.ProgramMapper;
import com.zm.media.ibs.program.persistence.custom.CustomProgramMapper;
import com.zm.media.ibs.program.service.ProgramService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by USERA on 2019/2/15.
 */
@Service
@Transactional
public class ProgramServiceImpl implements ProgramService {

    @Resource
    private ProgramMapper programMapper;
    @Resource
    private ElementMapper elementMapper;
    @Resource
    private ElementMaterialMapper elementMaterialMapper;
    @Resource
    private CustomProgramMapper customProgramMapper;

    private SnowflakeIdWorker idWorker = new SnowflakeIdWorker();

    @Override
    public int addProgram(ProgramVO programVO) {
        //保存主题基本信息
        Program program = new Program();
        BeanUtils.copyProperties(programVO,program);
        program.setCreateTime(new Date());
        program.setProgramId(idWorker.nextId());
        programMapper.insertSelective(program);

        //保存元素
        List<ElementVO> elementVOList = programVO.getElementList();
        for (ElementVO elementVO : elementVOList) {
            Element element = new Element();
            BeanUtils.copyProperties(elementVO,element);
            element.setProgramId(program.getProgramId());
            element.setElementId(idWorker.nextId());
            elementMapper.insertSelective(element);

            //保存元素素材
            List<Material> materialList = elementVO.getMaterialList();
            for (Material material : materialList) {
                ElementMaterial elementMaterial = new ElementMaterial();
                elementMaterial.setElementId(element.getElementId());
                elementMaterial.setMaterialId(material.getMaterialId());
                elementMaterial.setCreateBy(program.getCreateBy());
                elementMaterial.setCreateTime(new Date());
                elementMaterialMapper.insertSelective(elementMaterial);
            }
        }
        return 1;
    }

    @Override
    public int deleteProgram(Long programId) {
        return programMapper.deleteByPrimaryKey(programId);
    }

    @Override
    public Program getById(Long programId) {
        return programMapper.selectByPrimaryKey(programId);
    }

    @Override
    public ProgramVO getDetailById(Long programId) {
        //获取主题
        Program program = programMapper.selectByPrimaryKey(programId);

        //获取元素
        ElementExample elementExample = new ElementExample();
        elementExample.or().andProgramIdEqualTo(program.getProgramId());
        List<Element> elementList = elementMapper.selectByExample(elementExample);

        //获取元素素材
        List<ElementVO> elementVOList = new ArrayList<>();
        for (Element element : elementList) {
            List<Material> materialList = customProgramMapper.selectElementMaterials(element.getElementId());
            ElementVO elementVO = new ElementVO();
            BeanUtils.copyProperties(element,elementVO);
            elementVO.setMaterialList(materialList);
            elementVOList.add(elementVO);
        }

        ProgramVO programVO = new ProgramVO();
        BeanUtils.copyProperties(program,programVO);
        programVO.setElementList(elementVOList);

        return programVO;
    }

    @Override
    public List<Program> getByCorpId(Long corpId) {
        ProgramExample programExample = new ProgramExample();
        programExample.or().andCorpIdEqualTo(corpId);
        return programMapper.selectByExample(programExample);
    }

    @Override
    public List<Program> getByExample(ProgramExample example) {
        return programMapper.selectByExample(example);
    }
}
