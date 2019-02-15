package com.zm.media.ibs.program.entity.vo;

import com.zm.media.ibs.program.entity.Program;

import java.util.List;

/**
 * Created by USERA on 2019/2/15.
 */
public class ProgramVO extends Program{

    //主题元素
    List<ElementVO> elementList;

    public List<ElementVO> getElementList() {
        return elementList;
    }

    public void setElementList(List<ElementVO> elementList) {
        this.elementList = elementList;
    }
}
