package com.zm.media.ibs.device.entity;

import java.util.Date;

public class DeviceGroup {
    private Long id;

    private String deviceId;

    private String dgroupId;

    private String createBy;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDgroupId() {
        return dgroupId;
    }

    public void setDgroupId(String dgroupId) {
        this.dgroupId = dgroupId == null ? null : dgroupId.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}