package com.zm.media.ibs.program.entity.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by USERA on 2019/2/18.
 */
public class MaterialVO {

    //元素类型
    private Integer materialType;
    //临时保存路径
    private String tempPath;
    //上传人
    private Long createBy;

    public String getTempPath() {
        return tempPath;
    }

    public void setTempPath(String tempPath) {
        this.tempPath = tempPath;
    }

    public Integer getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Integer materialType) {
        this.materialType = materialType;
    }
    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
}
