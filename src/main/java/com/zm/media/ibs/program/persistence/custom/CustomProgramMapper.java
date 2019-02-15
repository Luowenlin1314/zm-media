package com.zm.media.ibs.program.persistence.custom;

import com.zm.media.ibs.program.entity.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by USERA on 2019/2/15.
 */
public interface CustomProgramMapper {

    /**
     * 根据元素id获取元素对应的素材
     * @param elementId
     * @return
     */
    List<Material> selectElementMaterials(@Param("elementId") Long elementId);

}
