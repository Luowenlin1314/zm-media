package com.zm.media.ibs.device.service.impl;

import com.zm.media.ibs.device.entity.DeviceCorp;
import com.zm.media.ibs.device.persistence.DeviceCorpMapper;
import com.zm.media.ibs.device.service.DeviceCorpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by USERA on 2019/2/14.
 */
@Service
public class DeviceCorpServiceImpl implements DeviceCorpService {

    @Resource
    private DeviceCorpMapper deviceCorpMapper;

    @Override
    public int addDeviceCorp(DeviceCorp deviceCorp) {
        return deviceCorpMapper.insertSelective(deviceCorp);
    }
}
