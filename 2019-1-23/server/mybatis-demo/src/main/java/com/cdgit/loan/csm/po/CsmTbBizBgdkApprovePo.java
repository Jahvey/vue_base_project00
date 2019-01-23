package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbBizBgdkApprovePo {
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String bgfs;

    private BigDecimal bgjyje;

    private String bbgf;

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

    public String getBgfs() {
        return bgfs;
    }

    public void setBgfs(String bgfs) {
        this.bgfs = bgfs == null ? null : bgfs.trim();
    }

    public BigDecimal getBgjyje() {
        return bgjyje;
    }

    public void setBgjyje(BigDecimal bgjyje) {
        this.bgjyje = bgjyje;
    }

    public String getBbgf() {
        return bbgf;
    }

    public void setBbgf(String bbgf) {
        this.bbgf = bbgf == null ? null : bbgf.trim();
    }
}