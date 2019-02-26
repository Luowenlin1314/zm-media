package com.zm.media.ibs.program.enums;

import com.zm.media.common.util.JacksonUtils;
import com.zm.media.ibs.program.entity.Material;
import com.zm.media.ibs.program.entity.vo.ElementVO;
import com.zm.media.ibs.program.entity.vo.ProgramVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by USERA on 2019/2/18.
 * 元素类型
 */
public enum MaterialType {

    IMAGE(1,"图片"),
    VIDEO(2,"视频");

    private Integer type;
    private String msg;

    MaterialType(Integer type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public static void main(String[] args) {
        ProgramVO programvo = new ProgramVO();
        programvo.setProgramId(1l);
        programvo.setProgramName("test");
        programvo.setCreateTime(new Date());
        programvo.setCorpId(100l);
        programvo.setDuration(10000);
        programvo.setPsize(500000d);
        programvo.setPtype(1);
        programvo.setStatus(1);

        List<ElementVO> elementList = new ArrayList<>();
        ElementVO elementVO = new ElementVO();
        elementVO.setElementId(1l);
        elementVO.setElementName("tp");
        elementVO.setEtype(1);
        elementVO.setProgramId(1l);
        elementVO.setDuration(5000);
        elementVO.setEffect(1);
        elementVO.setEheight(50);
        elementVO.setEwidth(50);
        elementVO.setEleft(0);
        elementVO.setEtop(0);
        elementVO.setEindex(1);
        elementVO.setEmode(1);

        ElementVO elementVO2 = new ElementVO();
        elementVO2.setElementId(2l);
        elementVO2.setElementName("tp2");
        elementVO2.setEtype(2);
        elementVO2.setProgramId(1l);
        elementVO2.setDuration(5000);
        elementVO2.setEffect(1);
        elementVO2.setEheight(50);
        elementVO2.setEwidth(50);
        elementVO2.setEleft(50);
        elementVO2.setEtop(50);
        elementVO2.setEindex(1);
        elementVO2.setEmode(1);

        List<Material> materialList = new ArrayList<>();
        Material material = new Material();
        material.setMaterialId(1l);
        material.setMaterialName("tp1");
        material.setDuration(5000l);
        material.setRelativePath("/materials/image/tp1.jpg");
        materialList.add(material);

        Material material2 = new Material();
        material2.setMaterialId(2l);
        material2.setMaterialName("tp2");
        material2.setDuration(5000l);
        material2.setRelativePath("/materials/image/tp2.jpg");
        materialList.add(material2);

        List<Material> materialList2 = new ArrayList<>();
        Material material3 = new Material();
        material3.setMaterialId(3l);
        material3.setMaterialName("sp1");
        material3.setDuration(5000l);
        material3.setRelativePath("/materials/video/sp1.mp4");
        materialList2.add(material3);

        Material material4 = new Material();
        material4.setMaterialId(4l);
        material4.setMaterialName("sp2");
        material4.setDuration(5000l);
        material4.setRelativePath("/materials/video/sp2.mp4");
        materialList2.add(material4);

        elementVO.setMaterialList(materialList);
        elementVO2.setMaterialList(materialList2);
        elementList.add(elementVO);
//        elementList.add(elementVO2);

        programvo.setElementList(elementList);

        String json = JacksonUtils.pojo2Json(programvo);
        System.out.println(json);
    }

}
