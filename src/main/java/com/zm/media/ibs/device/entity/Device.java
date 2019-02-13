package com.zm.media.ibs.device.entity;

import java.util.Date;

public class Device {
    private String deviceId;

    private String deviceCode;

    private Integer netType;

    private String netIP;

    private String netMac;

    private String resolution;

    private String version;

    private String remark;

    private Date createTime;

    private Date updateTime;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    public Integer getNetType() {
        return netType;
    }

    public void setNetType(Integer netType) {
        this.netType = netType;
    }

    public String getNetIP() {
        return netIP;
    }

    public void setNetIP(String netIP) {
        this.netIP = netIP == null ? null : netIP.trim();
    }

    public String getNetMac() {
        return netMac;
    }

    public void setNetMac(String netMac) {
        this.netMac = netMac == null ? null : netMac.trim();
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution == null ? null : resolution.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}