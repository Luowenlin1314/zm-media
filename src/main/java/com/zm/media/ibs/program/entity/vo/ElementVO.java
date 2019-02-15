package com.zm.media.ibs.program.entity.vo;

import com.zm.media.ibs.program.entity.Element;
import com.zm.media.ibs.program.entity.Material;

import java.util.List;

/**
 * Created by USERA on 2019/2/15.
 */
public class ElementVO extends Element {

    //元素素材列表
    private List<Material> materialList;

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }
}
