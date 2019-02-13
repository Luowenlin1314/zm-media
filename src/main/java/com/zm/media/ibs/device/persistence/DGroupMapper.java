package com.zm.media.ibs.device.persistence;

import com.zm.media.ibs.device.entity.DGroup;
import com.zm.media.ibs.device.entity.DGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DGroupMapper {
    int countByExample(DGroupExample example);

    int deleteByExample(DGroupExample example);

    int deleteByPrimaryKey(String dgroupId);

    int insert(DGroup record);

    int insertSelective(DGroup record);

    List<DGroup> selectByExample(DGroupExample example);

    DGroup selectByPrimaryKey(String dgroupId);

    int updateByExampleSelective(@Param("record") DGroup record, @Param("example") DGroupExample example);

    int updateByExample(@Param("record") DGroup record, @Param("example") DGroupExample example);

    int updateByPrimaryKeySelective(DGroup record);

    int updateByPrimaryKey(DGroup record);
}