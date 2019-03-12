package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbBizGnblApprovePo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String bllx;

    private String sfyzsq;

    private String bltffs;

    private BigDecimal dkll;

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

    public String getBllx() {
        return bllx;
    }

    public void setBllx(String bllx) {
        this.bllx = bllx == null ? null : bllx.trim();
    }

    public String getSfyzsq() {
        return sfyzsq;
    }

    public void setSfyzsq(String sfyzsq) {
        this.sfyzsq = sfyzsq == null ? null : sfyzsq.trim();
    }

    public String getBltffs() {
        return bltffs;
    }

    public void setBltffs(String bltffs) {
        this.bltffs = bltffs == null ? null : bltffs.trim();
    }

    public BigDecimal getDkll() {
        return dkll;
    }

    public void setDkll(BigDecimal dkll) {
        this.dkll = dkll;
    }
}