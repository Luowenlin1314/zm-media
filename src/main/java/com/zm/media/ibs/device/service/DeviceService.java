package com.zm.media.ibs.device.service;

import com.zm.media.ibs.device.entity.Device;

/**
 * Created by USERA on 2019/2/14.
 */
public interface DeviceService {

    /**
     * 添加设备
     * @param device
     * @return
     */
    int addDevice(Device device);

    /**
     * 通过设备唯一编码获取设备
     * @param deviceCode
     * @return
     */
    Device getByDeviceCode(String deviceCode);

}
