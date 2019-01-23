package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbBizXwApprovePo {
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String gtjkr;

    private BigDecimal applyXwAmt;

    private Integer applyXwTerm;

    private String cycleUnitXw;

    private String wtr;

    private String wtrlx;

    private String wtdkxz;

    private String wtxmId;

    private Date applyDate;

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

    public String getGtjkr() {
        return gtjkr;
    }

    public void setGtjkr(String gtjkr) {
        this.gtjkr = gtjkr == null ? null : gtjkr.trim();
    }

    public BigDecimal getApplyXwAmt() {
        return applyXwAmt;
    }

    public void setApplyXwAmt(BigDecimal applyXwAmt) {
        this.applyXwAmt = applyXwAmt;
    }

    public Integer getApplyXwTerm() {
        return applyXwTerm;
    }

    public void setApplyXwTerm(Integer applyXwTerm) {
        this.applyXwTerm = applyXwTerm;
    }

    public String getCycleUnitXw() {
        return cycleUnitXw;
    }

    public void setCycleUnitXw(String cycleUnitXw) {
        this.cycleUnitXw = cycleUnitXw == null ? null : cycleUnitXw.trim();
    }

    public String getWtr() {
        return wtr;
    }

    public void setWtr(String wtr) {
        this.wtr = wtr == null ? null : wtr.trim();
    }

    public String getWtrlx() {
        return wtrlx;
    }

    public void setWtrlx(String wtrlx) {
        this.wtrlx = wtrlx == null ? null : wtrlx.trim();
    }

    public String getWtdkxz() {
        return wtdkxz;
    }

    public void setWtdkxz(String wtdkxz) {
        this.wtdkxz = wtdkxz == null ? null : wtdkxz.trim();
    }

    public String getWtxmId() {
        return wtxmId;
    }

    public void setWtxmId(String wtxmId) {
        this.wtxmId = wtxmId == null ? null : wtxmId.trim();
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
}