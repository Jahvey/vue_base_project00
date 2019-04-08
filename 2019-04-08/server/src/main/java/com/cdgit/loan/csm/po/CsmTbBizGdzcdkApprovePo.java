package com.cdgit.loan.csm.po;

import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbBizGdzcdkApprovePo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String jmrhsx;

    private String sfjmrhsx;

    private String applyType;

    private String whetherZftdcbjgdk;

    private String dckfdkType;

    private String ajgcType;

    private String ajgcDetailType;

    public String getApplyDetailId() {
        return applyDetailId;
    }

    public void setApplyDetailId(String applyDetailId) {
        this.applyDetailId = applyDetailId == null ? null : applyDetailId.trim();
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

    public String getAmountDetailId() {
        return amountDetailId;
    }

    public void setAmountDetailId(String amountDetailId) {
        this.amountDetailId = amountDetailId == null ? null : amountDetailId.trim();
    }

    public String getJmrhsx() {
        return jmrhsx;
    }

    public void setJmrhsx(String jmrhsx) {
        this.jmrhsx = jmrhsx == null ? null : jmrhsx.trim();
    }

    public String getSfjmrhsx() {
        return sfjmrhsx;
    }

    public void setSfjmrhsx(String sfjmrhsx) {
        this.sfjmrhsx = sfjmrhsx == null ? null : sfjmrhsx.trim();
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    public String getWhetherZftdcbjgdk() {
        return whetherZftdcbjgdk;
    }

    public void setWhetherZftdcbjgdk(String whetherZftdcbjgdk) {
        this.whetherZftdcbjgdk = whetherZftdcbjgdk == null ? null : whetherZftdcbjgdk.trim();
    }

    public String getDckfdkType() {
        return dckfdkType;
    }

    public void setDckfdkType(String dckfdkType) {
        this.dckfdkType = dckfdkType == null ? null : dckfdkType.trim();
    }

    public String getAjgcType() {
        return ajgcType;
    }

    public void setAjgcType(String ajgcType) {
        this.ajgcType = ajgcType == null ? null : ajgcType.trim();
    }

    public String getAjgcDetailType() {
        return ajgcDetailType;
    }

    public void setAjgcDetailType(String ajgcDetailType) {
        this.ajgcDetailType = ajgcDetailType == null ? null : ajgcDetailType.trim();
    }
}