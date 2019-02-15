package com.zm.media.ibs.device.entity;

import java.util.Date;

public class DeviceGroup {
    private Long id;

    private Long deviceId;

    private Long dgroupId;

    private Long createBy;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getDgroupId() {
        return dgroupId;
    }

    public void setDgroupId(Long dgroupId) {
        this.dgroupId = dgroupId;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}