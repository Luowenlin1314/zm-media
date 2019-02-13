package com.zm.media.ibs.program.persistence;

import com.zm.media.ibs.program.entity.Element;
import com.zm.media.ibs.program.entity.ElementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElementMapper {
    int countByExample(ElementExample example);

    int deleteByExample(ElementExample example);

    int deleteByPrimaryKey(String elementId);

    int insert(Element record);

    int insertSelective(Element record);

    List<Element> selectByExample(ElementExample example);

    Element selectByPrimaryKey(String elementId);

    int updateByExampleSelective(@Param("record") Element record, @Param("example") ElementExample example);

    int updateByExample(@Param("record") Element record, @Param("example") ElementExample example);

    int updateByPrimaryKeySelective(Element record);

    int updateByPrimaryKey(Element record);
}