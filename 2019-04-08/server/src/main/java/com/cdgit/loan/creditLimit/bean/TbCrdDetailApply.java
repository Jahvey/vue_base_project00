package com.cdgit.loan.creditLimit.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbCrdDetailApply {
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

    private String termNum;

    private String termUnit;

    private Date updateTime;

    private String cycleInd;

    private String oldCrdDtlId;

    private Date beginDate;

    private Date endDate;

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

    public String getOldCrdDtlId() {
        return oldCrdDtlId;
    }

    public void setOldCrdDtlId(String oldCrdDtlId) {
        this.oldCrdDtlId = oldCrdDtlId == null ? null : oldCrdDtlId.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getAssurePer() {
        return assurePer;
    }

    public void setAssurePer(BigDecimal assurePer) {
        this.assurePer = assurePer;
    }
}