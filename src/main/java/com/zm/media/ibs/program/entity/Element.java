package com.zm.media.ibs.program.entity;

public class Element {
    private Long elementId;

    private Long programId;

    private String elementName;

    private Integer etype;

    private String background;

    private Integer eleft;

    private Integer etop;

    private Integer ewidth;

    private Integer eheight;

    private Integer eindex;

    private Integer duration;

    private Integer effect;

    private Integer emode;

    private String remark;

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName == null ? null : elementName.trim();
    }

    public Integer getEtype() {
        return etype;
    }

    public void setEtype(Integer etype) {
        this.etype = etype;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background == null ? null : background.trim();
    }

    public Integer getEleft() {
        return eleft;
    }

    public void setEleft(Integer eleft) {
        this.eleft = eleft;
    }

    public Integer getEtop() {
        return etop;
    }

    public void setEtop(Integer etop) {
        this.etop = etop;
    }

    public Integer getEwidth() {
        return ewidth;
    }

    public void setEwidth(Integer ewidth) {
        this.ewidth = ewidth;
    }

    public Integer getEheight() {
        return eheight;
    }

    public void setEheight(Integer eheight) {
        this.eheight = eheight;
    }

    public Integer getEindex() {
        return eindex;
    }

    public void setEindex(Integer eindex) {
        this.eindex = eindex;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getEffect() {
        return effect;
    }

    public void setEffect(Integer effect) {
        this.effect = effect;
    }

    public Integer getEmode() {
        return emode;
    }

    public void setEmode(Integer emode) {
        this.emode = emode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}