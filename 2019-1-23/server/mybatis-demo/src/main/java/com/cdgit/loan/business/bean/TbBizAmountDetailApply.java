package com.cdgit.loan.business.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbBizAmountDetailApply {
    private String amountDetailId;

    private String productType;

    private String currencyCd;

    private BigDecimal exchangeRate;

    private String cycleUnit;

    private Integer creditTerm;

    private String loanUse;

    private String repaymentType;

    private String cycleInd;

    private Short broadCycle;

    private String broadCycleUnit;

    private Date createTime;

    private Date updateTime;

    private Date exchangeRateDate;

    private String oldDetailId;

    private BigDecimal detailAmt;

    private String amountId;

    private String payment;

    private String prepaymentPenalty;

    private BigDecimal rmbAmt;

    private String cycleIndCon;

    private String oldApplyId;

    private String holidayFlg;

    private String firstRepayTerm;

    private Date endDate;

    private String applyId;

    private String crdDtlId;

    private String creditMode;

    private Date beginDate;

    private BigDecimal assurePer;

    public String getAmountDetailId() {
        return amountDetailId;
    }

    public void setAmountDetailId(String amountDetailId) {
        this.amountDetailId = amountDetailId == null ? null : amountDetailId.trim();
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

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit == null ? null : cycleUnit.trim();
    }

    public Integer getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(Integer creditTerm) {
        this.creditTerm = creditTerm;
    }

    public String getLoanUse() {
        return loanUse;
    }

    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse == null ? null : loanUse.trim();
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType == null ? null : repaymentType.trim();
    }

    public String getCycleInd() {
        return cycleInd;
    }

    public void setCycleInd(String cycleInd) {
        this.cycleInd = cycleInd == null ? null : cycleInd.trim();
    }

    public Short getBroadCycle() {
        return broadCycle;
    }

    public void setBroadCycle(Short broadCycle) {
        this.broadCycle = broadCycle;
    }

    public String getBroadCycleUnit() {
        return broadCycleUnit;
    }

    public void setBroadCycleUnit(String broadCycleUnit) {
        this.broadCycleUnit = broadCycleUnit == null ? null : broadCycleUnit.trim();
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

    public Date getExchangeRateDate() {
        return exchangeRateDate;
    }

    public void setExchangeRateDate(Date exchangeRateDate) {
        this.exchangeRateDate = exchangeRateDate;
    }

    public String getOldDetailId() {
        return oldDetailId;
    }

    public void setOldDetailId(String oldDetailId) {
        this.oldDetailId = oldDetailId == null ? null : oldDetailId.trim();
    }

    public BigDecimal getDetailAmt() {
        return detailAmt;
    }

    public void setDetailAmt(BigDecimal detailAmt) {
        this.detailAmt = detailAmt;
    }

    public String getAmountId() {
        return amountId;
    }

    public void setAmountId(String amountId) {
        this.amountId = amountId == null ? null : amountId.trim();
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    public String getPrepaymentPenalty() {
        return prepaymentPenalty;
    }

    public void setPrepaymentPenalty(String prepaymentPenalty) {
        this.prepaymentPenalty = prepaymentPenalty == null ? null : prepaymentPenalty.trim();
    }

    public BigDecimal getRmbAmt() {
        return rmbAmt;
    }

    public void setRmbAmt(BigDecimal rmbAmt) {
        this.rmbAmt = rmbAmt;
    }

    public String getCycleIndCon() {
        return cycleIndCon;
    }

    public void setCycleIndCon(String cycleIndCon) {
        this.cycleIndCon = cycleIndCon == null ? null : cycleIndCon.trim();
    }

    public String getOldApplyId() {
        return oldApplyId;
    }

    public void setOldApplyId(String oldApplyId) {
        this.oldApplyId = oldApplyId == null ? null : oldApplyId.trim();
    }

    public String getHolidayFlg() {
        return holidayFlg;
    }

    public void setHolidayFlg(String holidayFlg) {
        this.holidayFlg = holidayFlg == null ? null : holidayFlg.trim();
    }

    public String getFirstRepayTerm() {
        return firstRepayTerm;
    }

    public void setFirstRepayTerm(String firstRepayTerm) {
        this.firstRepayTerm = firstRepayTerm == null ? null : firstRepayTerm.trim();
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getCrdDtlId() {
        return crdDtlId;
    }

    public void setCrdDtlId(String crdDtlId) {
        this.crdDtlId = crdDtlId == null ? null : crdDtlId.trim();
    }

    public String getCreditMode() {
        return creditMode;
    }

    public void setCreditMode(String creditMode) {
        this.creditMode = creditMode == null ? null : creditMode.trim();
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
        TbBizAmountDetailApply other = (TbBizAmountDetailApply) that;
        return (this.getAmountDetailId() == null ? other.getAmountDetailId() == null : this.getAmountDetailId().equals(other.getAmountDetailId()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getExchangeRate() == null ? other.getExchangeRate() == null : this.getExchangeRate().equals(other.getExchangeRate()))
            && (this.getCycleUnit() == null ? other.getCycleUnit() == null : this.getCycleUnit().equals(other.getCycleUnit()))
            && (this.getCreditTerm() == null ? other.getCreditTerm() == null : this.getCreditTerm().equals(other.getCreditTerm()))
            && (this.getLoanUse() == null ? other.getLoanUse() == null : this.getLoanUse().equals(other.getLoanUse()))
            && (this.getRepaymentType() == null ? other.getRepaymentType() == null : this.getRepaymentType().equals(other.getRepaymentType()))
            && (this.getCycleInd() == null ? other.getCycleInd() == null : this.getCycleInd().equals(other.getCycleInd()))
            && (this.getBroadCycle() == null ? other.getBroadCycle() == null : this.getBroadCycle().equals(other.getBroadCycle()))
            && (this.getBroadCycleUnit() == null ? other.getBroadCycleUnit() == null : this.getBroadCycleUnit().equals(other.getBroadCycleUnit()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getExchangeRateDate() == null ? other.getExchangeRateDate() == null : this.getExchangeRateDate().equals(other.getExchangeRateDate()))
            && (this.getOldDetailId() == null ? other.getOldDetailId() == null : this.getOldDetailId().equals(other.getOldDetailId()))
            && (this.getDetailAmt() == null ? other.getDetailAmt() == null : this.getDetailAmt().equals(other.getDetailAmt()))
            && (this.getAmountId() == null ? other.getAmountId() == null : this.getAmountId().equals(other.getAmountId()))
            && (this.getPayment() == null ? other.getPayment() == null : this.getPayment().equals(other.getPayment()))
            && (this.getPrepaymentPenalty() == null ? other.getPrepaymentPenalty() == null : this.getPrepaymentPenalty().equals(other.getPrepaymentPenalty()))
            && (this.getRmbAmt() == null ? other.getRmbAmt() == null : this.getRmbAmt().equals(other.getRmbAmt()))
            && (this.getCycleIndCon() == null ? other.getCycleIndCon() == null : this.getCycleIndCon().equals(other.getCycleIndCon()))
            && (this.getOldApplyId() == null ? other.getOldApplyId() == null : this.getOldApplyId().equals(other.getOldApplyId()))
            && (this.getHolidayFlg() == null ? other.getHolidayFlg() == null : this.getHolidayFlg().equals(other.getHolidayFlg()))
            && (this.getFirstRepayTerm() == null ? other.getFirstRepayTerm() == null : this.getFirstRepayTerm().equals(other.getFirstRepayTerm()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()))
            && (this.getCrdDtlId() == null ? other.getCrdDtlId() == null : this.getCrdDtlId().equals(other.getCrdDtlId()))
            && (this.getCreditMode() == null ? other.getCreditMode() == null : this.getCreditMode().equals(other.getCreditMode()))
            && (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
            && (this.getAssurePer() == null ? other.getAssurePer() == null : this.getAssurePer().equals(other.getAssurePer()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAmountDetailId() == null) ? 0 : getAmountDetailId().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getExchangeRate() == null) ? 0 : getExchangeRate().hashCode());
        result = prime * result + ((getCycleUnit() == null) ? 0 : getCycleUnit().hashCode());
        result = prime * result + ((getCreditTerm() == null) ? 0 : getCreditTerm().hashCode());
        result = prime * result + ((getLoanUse() == null) ? 0 : getLoanUse().hashCode());
        result = prime * result + ((getRepaymentType() == null) ? 0 : getRepaymentType().hashCode());
        result = prime * result + ((getCycleInd() == null) ? 0 : getCycleInd().hashCode());
        result = prime * result + ((getBroadCycle() == null) ? 0 : getBroadCycle().hashCode());
        result = prime * result + ((getBroadCycleUnit() == null) ? 0 : getBroadCycleUnit().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getExchangeRateDate() == null) ? 0 : getExchangeRateDate().hashCode());
        result = prime * result + ((getOldDetailId() == null) ? 0 : getOldDetailId().hashCode());
        result = prime * result + ((getDetailAmt() == null) ? 0 : getDetailAmt().hashCode());
        result = prime * result + ((getAmountId() == null) ? 0 : getAmountId().hashCode());
        result = prime * result + ((getPayment() == null) ? 0 : getPayment().hashCode());
        result = prime * result + ((getPrepaymentPenalty() == null) ? 0 : getPrepaymentPenalty().hashCode());
        result = prime * result + ((getRmbAmt() == null) ? 0 : getRmbAmt().hashCode());
        result = prime * result + ((getCycleIndCon() == null) ? 0 : getCycleIndCon().hashCode());
        result = prime * result + ((getOldApplyId() == null) ? 0 : getOldApplyId().hashCode());
        result = prime * result + ((getHolidayFlg() == null) ? 0 : getHolidayFlg().hashCode());
        result = prime * result + ((getFirstRepayTerm() == null) ? 0 : getFirstRepayTerm().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        result = prime * result + ((getCrdDtlId() == null) ? 0 : getCrdDtlId().hashCode());
        result = prime * result + ((getCreditMode() == null) ? 0 : getCreditMode().hashCode());
        result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
        result = prime * result + ((getAssurePer() == null) ? 0 : getAssurePer().hashCode());
        return result;
    }
}