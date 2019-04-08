package com.cdgit.loan.csm.po;

import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbBizFrzhtzApprovePo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String tzzhh;

    private String tzzhmc;

    private String tzcxqx;

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

    public String getTzzhh() {
        return tzzhh;
    }

    public void setTzzhh(String tzzhh) {
        this.tzzhh = tzzhh == null ? null : tzzhh.trim();
    }

    public String getTzzhmc() {
        return tzzhmc;
    }

    public void setTzzhmc(String tzzhmc) {
        this.tzzhmc = tzzhmc == null ? null : tzzhmc.trim();
    }

    public String getTzcxqx() {
        return tzcxqx;
    }

    public void setTzcxqx(String tzcxqx) {
        this.tzcxqx = tzcxqx == null ? null : tzcxqx.trim();
    }
}