package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbBizGjfftApprovePo {
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String ywbh;

    private BigDecimal dkll;

    private String cplx;

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

    public String getYwbh() {
        return ywbh;
    }

    public void setYwbh(String ywbh) {
        this.ywbh = ywbh == null ? null : ywbh.trim();
    }

    public BigDecimal getDkll() {
        return dkll;
    }

    public void setDkll(BigDecimal dkll) {
        this.dkll = dkll;
    }

    public String getCplx() {
        return cplx;
    }

    public void setCplx(String cplx) {
        this.cplx = cplx == null ? null : cplx.trim();
    }
}