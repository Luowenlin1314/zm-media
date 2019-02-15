package com.zm.media.ibs.device.service;

import com.zm.media.ibs.device.entity.DeviceCorp;

/**
 * Created by USERA on 2019/2/14.
 * 设备-公司
 */
public interface DeviceCorpService {

    /**
     * 公司添加设备
     * @param deviceCorp
     * @return
     */
    int addDeviceCorp(DeviceCorp deviceCorp);

}
