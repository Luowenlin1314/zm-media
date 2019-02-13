package com.zm.media.ibs.device.persistence;

import com.zm.media.ibs.device.entity.DeviceCorp;
import com.zm.media.ibs.device.entity.DeviceCorpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceCorpMapper {
    int countByExample(DeviceCorpExample example);

    int deleteByExample(DeviceCorpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeviceCorp record);

    int insertSelective(DeviceCorp record);

    List<DeviceCorp> selectByExample(DeviceCorpExample example);

    DeviceCorp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeviceCorp record, @Param("example") DeviceCorpExample example);

    int updateByExample(@Param("record") DeviceCorp record, @Param("example") DeviceCorpExample example);

    int updateByPrimaryKeySelective(DeviceCorp record);

    int updateByPrimaryKey(DeviceCorp record);
}