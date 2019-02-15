package com.zm.media.ibs.device.service.impl;

import com.zm.media.common.util.SnowflakeIdWorker;
import com.zm.media.ibs.device.entity.Device;
import com.zm.media.ibs.device.entity.DeviceExample;
import com.zm.media.ibs.device.persistence.DeviceMapper;
import com.zm.media.ibs.device.service.DeviceService;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by USERA on 2019/2/14.
 */
@Service
public class DevcieServiceImpl implements DeviceService {

    @Resource
    private DeviceMapper deviceMapper;

    @Override
    public int addDevice(Device device) {
        return deviceMapper.insertSelective(device);
    }

    @Override
    public Device getByDeviceCode(String deviceCode) {
        DeviceExample deviceExample = new DeviceExample();
        deviceExample.or().andDeviceCodeEqualTo(deviceCode);
        List<Device> deviceList = deviceMapper.selectByExample(deviceExample);
        if(deviceList != null && deviceList.size() > 0){
            return deviceList.get(0);
        }
        return null;
    }

}
