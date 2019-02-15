package com.zm.media.ibs.program.service;

import com.zm.media.ibs.program.entity.Program;
import com.zm.media.ibs.program.entity.ProgramExample;
import com.zm.media.ibs.program.entity.vo.ProgramVO;

import java.util.List;

/**
 * Created by USERA on 2019/2/15.
 */
public interface ProgramService {

    /**
     * 创建主题
     * @param programVO
     * @return
     */
    int addProgram(ProgramVO programVO);

    /**
     * 删除主题
     * @param programId
     * @return
     */
    int deleteProgram(Long programId);


    /**
     * 通过id获取
     * @param programId
     * @return
     */
    Program getById(Long programId);

    /**
     * 通过id获取详细信息
     * @param programId
     * @return
     */
    ProgramVO getDetailById(Long programId);

    /**
     * 通过i公司id获取
     * @param corpId
     * @return
     */
    List<Program> getByCorpId(Long corpId);

    /**
     * 通过条件获取
     * @param example
     * @return
     */
    List<Program> getByExample(ProgramExample example);
}
