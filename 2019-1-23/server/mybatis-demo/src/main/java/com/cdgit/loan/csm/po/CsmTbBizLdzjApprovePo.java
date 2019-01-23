package com.cdgit.loan.csm.po;

import java.util.Date;

public class CsmTbBizLdzjApprovePo {
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String swjsftg;

    private String jmrhsx;

    private String sfjmrhsx;

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

    public String getSwjsftg() {
        return swjsftg;
    }

    public void setSwjsftg(String swjsftg) {
        this.swjsftg = swjsftg == null ? null : swjsftg.trim();
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
}