package com.cdgit.loan.csm.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbCrdDetailApprove {
    private String crdDtlId;

    private String crdId;

    private String creditMode;

    private String productType;

    private String currencyCd;

    private BigDecimal exchangeRate;

    private Date exchangeRateDate;

    private BigDecimal dtlAmt;

    private BigDecimal rmbAmt;

    private BigDecimal boUse;

    private BigDecimal noUse;

    private Date applyDate;

    private String termNum;

    private String termUnit;

    private Date updateTime;

    private String cycleInd;

    private String creditStatus;

    private Date endDate;

    private Date beginDate;

    private BigDecimal assurePer;

    public String getCrdDtlId() {
        return crdDtlId;
    }

    public void setCrdDtlId(String crdDtlId) {
        this.crdDtlId = crdDtlId == null ? null : crdDtlId.trim();
    }

    public String getCrdId() {
        return crdId;
    }

    public void setCrdId(String crdId) {
        this.crdId = crdId == null ? null : crdId.trim();
    }

    public String getCreditMode() {
        return creditMode;
    }

    public void setCreditMode(String creditMode) {
        this.creditMode = creditMode == null ? null : creditMode.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Date getExchangeRateDate() {
        return exchangeRateDate;
    }

    public void setExchangeRateDate(Date exchangeRateDate) {
        this.exchangeRateDate = exchangeRateDate;
    }

    public BigDecimal getDtlAmt() {
        return dtlAmt;
    }

    public void setDtlAmt(BigDecimal dtlAmt) {
        this.dtlAmt = dtlAmt;
    }

    public BigDecimal getRmbAmt() {
        return rmbAmt;
    }

    public void setRmbAmt(BigDecimal rmbAmt) {
        this.rmbAmt = rmbAmt;
    }

    public BigDecimal getBoUse() {
        return boUse;
    }

    public void setBoUse(BigDecimal boUse) {
        this.boUse = boUse;
    }

    public BigDecimal getNoUse() {
        return noUse;
    }

    public void setNoUse(BigDecimal noUse) {
        this.noUse = noUse;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getTermNum() {
        return termNum;
    }

    public void setTermNum(String termNum) {
        this.termNum = termNum == null ? null : termNum.trim();
    }

    public String getTermUnit() {
        return termUnit;
    }

    public void setTermUnit(String termUnit) {
        this.termUnit = termUnit == null ? null : termUnit.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCycleInd() {
        return cycleInd;
    }

    public void setCycleInd(String cycleInd) {
        this.cycleInd = cycleInd == null ? null : cycleInd.trim();
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus == null ? null : creditStatus.trim();
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public BigDecimal getAssurePer() {
        return assurePer;
    }

    public void setAssurePer(BigDecimal assurePer) {
        this.assurePer = assurePer;
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
        CsmTbCrdDetailApprove other = (CsmTbCrdDetailApprove) that;
        return (this.getCrdDtlId() == null ? other.getCrdDtlId() == null : this.getCrdDtlId().equals(other.getCrdDtlId()))
            && (this.getCrdId() == null ? other.getCrdId() == null : this.getCrdId().equals(other.getCrdId()))
            && (this.getCreditMode() == null ? other.getCreditMode() == null : this.getCreditMode().equals(other.getCreditMode()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getExchangeRate() == null ? other.getExchangeRate() == null : this.getExchangeRate().equals(other.getExchangeRate()))
            && (this.getExchangeRateDate() == null ? other.getExchangeRateDate() == null : this.getExchangeRateDate().equals(other.getExchangeRateDate()))
            && (this.getDtlAmt() == null ? other.getDtlAmt() == null : this.getDtlAmt().equals(other.getDtlAmt()))
            && (this.getRmbAmt() == null ? other.getRmbAmt() == null : this.getRmbAmt().equals(other.getRmbAmt()))
            && (this.getBoUse() == null ? other.getBoUse() == null : this.getBoUse().equals(other.getBoUse()))
            && (this.getNoUse() == null ? other.getNoUse() == null : this.getNoUse().equals(other.getNoUse()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()))
            && (this.getTermNum() == null ? other.getTermNum() == null : this.getTermNum().equals(other.getTermNum()))
            && (this.getTermUnit() == null ? other.getTermUnit() == null : this.getTermUnit().equals(other.getTermUnit()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCycleInd() == null ? other.getCycleInd() == null : this.getCycleInd().equals(other.getCycleInd()))
            && (this.getCreditStatus() == null ? other.getCreditStatus() == null : this.getCreditStatus().equals(other.getCreditStatus()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
            && (this.getAssurePer() == null ? other.getAssurePer() == null : this.getAssurePer().equals(other.getAssurePer()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCrdDtlId() == null) ? 0 : getCrdDtlId().hashCode());
        result = prime * result + ((getCrdId() == null) ? 0 : getCrdId().hashCode());
        result = prime * result + ((getCreditMode() == null) ? 0 : getCreditMode().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getExchangeRate() == null) ? 0 : getExchangeRate().hashCode());
        result = prime * result + ((getExchangeRateDate() == null) ? 0 : getExchangeRateDate().hashCode());
        result = prime * result + ((getDtlAmt() == null) ? 0 : getDtlAmt().hashCode());
        result = prime * result + ((getRmbAmt() == null) ? 0 : getRmbAmt().hashCode());
        result = prime * result + ((getBoUse() == null) ? 0 : getBoUse().hashCode());
        result = prime * result + ((getNoUse() == null) ? 0 : getNoUse().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getTermNum() == null) ? 0 : getTermNum().hashCode());
        result = prime * result + ((getTermUnit() == null) ? 0 : getTermUnit().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCycleInd() == null) ? 0 : getCycleInd().hashCode());
        result = prime * result + ((getCreditStatus() == null) ? 0 : getCreditStatus().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
        result = prime * result + ((getAssurePer() == null) ? 0 : getAssurePer().hashCode());
        return result;
    }
}