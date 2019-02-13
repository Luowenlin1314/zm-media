package com.zm.media.ibs.program.persistence;

import com.zm.media.ibs.program.entity.ElementMaterial;
import com.zm.media.ibs.program.entity.ElementMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElementMaterialMapper {
    int countByExample(ElementMaterialExample example);

    int deleteByExample(ElementMaterialExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ElementMaterial record);

    int insertSelective(ElementMaterial record);

    List<ElementMaterial> selectByExample(ElementMaterialExample example);

    ElementMaterial selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ElementMaterial record, @Param("example") ElementMaterialExample example);

    int updateByExample(@Param("record") ElementMaterial record, @Param("example") ElementMaterialExample example);

    int updateByPrimaryKeySelective(ElementMaterial record);

    int updateByPrimaryKey(ElementMaterial record);
}