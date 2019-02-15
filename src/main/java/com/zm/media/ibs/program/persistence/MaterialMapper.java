package com.zm.media.ibs.program.persistence;

import com.zm.media.ibs.program.entity.Material;
import com.zm.media.ibs.program.entity.MaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialMapper {
    int countByExample(MaterialExample example);

    int deleteByExample(MaterialExample example);

    int deleteByPrimaryKey(Long materialId);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(Long materialId);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}