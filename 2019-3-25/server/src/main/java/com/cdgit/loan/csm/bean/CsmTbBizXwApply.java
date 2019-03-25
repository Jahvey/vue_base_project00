package com.cdgit.loan.csm.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbBizXwApply {
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CsmTbBizXwApply other = (CsmTbBizXwApply) that;
        return (this.getApplyDetailId() == null ? other.getApplyDetailId() == null : this.getApplyDetailId().equals(other.getApplyDetailId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getAmountDetailId() == null ? other.getAmountDetailId() == null : this.getAmountDetailId().equals(other.getAmountDetailId()))
            && (this.getGtjkr() == null ? other.getGtjkr() == null : this.getGtjkr().equals(other.getGtjkr()))
            && (this.getApplyXwAmt() == null ? other.getApplyXwAmt() == null : this.getApplyXwAmt().equals(other.getApplyXwAmt()))
            && (this.getApplyXwTerm() == null ? other.getApplyXwTerm() == null : this.getApplyXwTerm().equals(other.getApplyXwTerm()))
            && (this.getCycleUnitXw() == null ? other.getCycleUnitXw() == null : this.getCycleUnitXw().equals(other.getCycleUnitXw()))
            && (this.getWtr() == null ? other.getWtr() == null : this.getWtr().equals(other.getWtr()))
            && (this.getWtrlx() == null ? other.getWtrlx() == null : this.getWtrlx().equals(other.getWtrlx()))
            && (this.getWtdkxz() == null ? other.getWtdkxz() == null : this.getWtdkxz().equals(other.getWtdkxz()))
            && (this.getWtxmId() == null ? other.getWtxmId() == null : this.getWtxmId().equals(other.getWtxmId()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getApplyDetailId() == null) ? 0 : getApplyDetailId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getAmountDetailId() == null) ? 0 : getAmountDetailId().hashCode());
        result = prime * result + ((getGtjkr() == null) ? 0 : getGtjkr().hashCode());
        result = prime * result + ((getApplyXwAmt() == null) ? 0 : getApplyXwAmt().hashCode());
        result = prime * result + ((getApplyXwTerm() == null) ? 0 : getApplyXwTerm().hashCode());
        result = prime * result + ((getCycleUnitXw() == null) ? 0 : getCycleUnitXw().hashCode());
        result = prime * result + ((getWtr() == null) ? 0 : getWtr().hashCode());
        result = prime * result + ((getWtrlx() == null) ? 0 : getWtrlx().hashCode());
        result = prime * result + ((getWtdkxz() == null) ? 0 : getWtdkxz().hashCode());
        result = prime * result + ((getWtxmId() == null) ? 0 : getWtxmId().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        return result;
    }
}