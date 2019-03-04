package com.cdgit.loan.business.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbBizAmountLoanrateApprove {
    private String loanrateId;

    private Date createTime;

    private Date updateTime;

    private String rateType;

    private String interestCollectType;

    private BigDecimal rateFloatProportion;

    private String irUpdateFrequency;

    private String baseRateValue;

    private BigDecimal rateFloatMember;

    private String overdueRateUpProportion;

    private BigDecimal yearRate;

    private String amountDetailId;

    private String floatType;

    private String floatWay;

    private Integer gracePeriodDay;

    private String gracePeriodType;

    private String graceCountIntFlag;

    private String holidayFlg;

    private String holidayIntFlg;

    private String feeFlag;

    private String discFlag;

    public String getLoanrateId() {
        return loanrateId;
    }

    public void setLoanrateId(String loanrateId) {
        this.loanrateId = loanrateId == null ? null : loanrateId.trim();
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

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType == null ? null : rateType.trim();
    }

    public String getInterestCollectType() {
        return interestCollectType;
    }

    public void setInterestCollectType(String interestCollectType) {
        this.interestCollectType = interestCollectType == null ? null : interestCollectType.trim();
    }

    public BigDecimal getRateFloatProportion() {
        return rateFloatProportion;
    }

    public void setRateFloatProportion(BigDecimal rateFloatProportion) {
        this.rateFloatProportion = rateFloatProportion;
    }

    public String getIrUpdateFrequency() {
        return irUpdateFrequency;
    }

    public void setIrUpdateFrequency(String irUpdateFrequency) {
        this.irUpdateFrequency = irUpdateFrequency == null ? null : irUpdateFrequency.trim();
    }

    public String getBaseRateValue() {
        return baseRateValue;
    }

    public void setBaseRateValue(String baseRateValue) {
        this.baseRateValue = baseRateValue == null ? null : baseRateValue.trim();
    }

    public BigDecimal getRateFloatMember() {
        return rateFloatMember;
    }

    public void setRateFloatMember(BigDecimal rateFloatMember) {
        this.rateFloatMember = rateFloatMember;
    }

    public String getOverdueRateUpProportion() {
        return overdueRateUpProportion;
    }

    public void setOverdueRateUpProportion(String overdueRateUpProportion) {
        this.overdueRateUpProportion = overdueRateUpProportion == null ? null : overdueRateUpProportion.trim();
    }

    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }

    public String getAmountDetailId() {
        return amountDetailId;
    }

    public void setAmountDetailId(String amountDetailId) {
        this.amountDetailId = amountDetailId == null ? null : amountDetailId.trim();
    }

    public String getFloatType() {
        return floatType;
    }

    public void setFloatType(String floatType) {
        this.floatType = floatType == null ? null : floatType.trim();
    }

    public String getFloatWay() {
        return floatWay;
    }

    public void setFloatWay(String floatWay) {
        this.floatWay = floatWay == null ? null : floatWay.trim();
    }

    public Integer getGracePeriodDay() {
        return gracePeriodDay;
    }

    public void setGracePeriodDay(Integer gracePeriodDay) {
        this.gracePeriodDay = gracePeriodDay;
    }

    public String getGracePeriodType() {
        return gracePeriodType;
    }

    public void setGracePeriodType(String gracePeriodType) {
        this.gracePeriodType = gracePeriodType == null ? null : gracePeriodType.trim();
    }

    public String getGraceCountIntFlag() {
        return graceCountIntFlag;
    }

    public void setGraceCountIntFlag(String graceCountIntFlag) {
        this.graceCountIntFlag = graceCountIntFlag == null ? null : graceCountIntFlag.trim();
    }

    public String getHolidayFlg() {
        return holidayFlg;
    }

    public void setHolidayFlg(String holidayFlg) {
        this.holidayFlg = holidayFlg == null ? null : holidayFlg.trim();
    }

    public String getHolidayIntFlg() {
        return holidayIntFlg;
    }

    public void setHolidayIntFlg(String holidayIntFlg) {
        this.holidayIntFlg = holidayIntFlg == null ? null : holidayIntFlg.trim();
    }

    public String getFeeFlag() {
        return feeFlag;
    }

    public void setFeeFlag(String feeFlag) {
        this.feeFlag = feeFlag == null ? null : feeFlag.trim();
    }

    public String getDiscFlag() {
        return discFlag;
    }

    public void setDiscFlag(String discFlag) {
        this.discFlag = discFlag == null ? null : discFlag.trim();
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
        TbBizAmountLoanrateApprove other = (TbBizAmountLoanrateApprove) that;
        return (this.getLoanrateId() == null ? other.getLoanrateId() == null : this.getLoanrateId().equals(other.getLoanrateId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRateType() == null ? other.getRateType() == null : this.getRateType().equals(other.getRateType()))
            && (this.getInterestCollectType() == null ? other.getInterestCollectType() == null : this.getInterestCollectType().equals(other.getInterestCollectType()))
            && (this.getRateFloatProportion() == null ? other.getRateFloatProportion() == null : this.getRateFloatProportion().equals(other.getRateFloatProportion()))
            && (this.getIrUpdateFrequency() == null ? other.getIrUpdateFrequency() == null : this.getIrUpdateFrequency().equals(other.getIrUpdateFrequency()))
            && (this.getBaseRateValue() == null ? other.getBaseRateValue() == null : this.getBaseRateValue().equals(other.getBaseRateValue()))
            && (this.getRateFloatMember() == null ? other.getRateFloatMember() == null : this.getRateFloatMember().equals(other.getRateFloatMember()))
            && (this.getOverdueRateUpProportion() == null ? other.getOverdueRateUpProportion() == null : this.getOverdueRateUpProportion().equals(other.getOverdueRateUpProportion()))
            && (this.getYearRate() == null ? other.getYearRate() == null : this.getYearRate().equals(other.getYearRate()))
            && (this.getAmountDetailId() == null ? other.getAmountDetailId() == null : this.getAmountDetailId().equals(other.getAmountDetailId()))
            && (this.getFloatType() == null ? other.getFloatType() == null : this.getFloatType().equals(other.getFloatType()))
            && (this.getFloatWay() == null ? other.getFloatWay() == null : this.getFloatWay().equals(other.getFloatWay()))
            && (this.getGracePeriodDay() == null ? other.getGracePeriodDay() == null : this.getGracePeriodDay().equals(other.getGracePeriodDay()))
            && (this.getGracePeriodType() == null ? other.getGracePeriodType() == null : this.getGracePeriodType().equals(other.getGracePeriodType()))
            && (this.getGraceCountIntFlag() == null ? other.getGraceCountIntFlag() == null : this.getGraceCountIntFlag().equals(other.getGraceCountIntFlag()))
            && (this.getHolidayFlg() == null ? other.getHolidayFlg() == null : this.getHolidayFlg().equals(other.getHolidayFlg()))
            && (this.getHolidayIntFlg() == null ? other.getHolidayIntFlg() == null : this.getHolidayIntFlg().equals(other.getHolidayIntFlg()))
            && (this.getFeeFlag() == null ? other.getFeeFlag() == null : this.getFeeFlag().equals(other.getFeeFlag()))
            && (this.getDiscFlag() == null ? other.getDiscFlag() == null : this.getDiscFlag().equals(other.getDiscFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLoanrateId() == null) ? 0 : getLoanrateId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRateType() == null) ? 0 : getRateType().hashCode());
        result = prime * result + ((getInterestCollectType() == null) ? 0 : getInterestCollectType().hashCode());
        result = prime * result + ((getRateFloatProportion() == null) ? 0 : getRateFloatProportion().hashCode());
        result = prime * result + ((getIrUpdateFrequency() == null) ? 0 : getIrUpdateFrequency().hashCode());
        result = prime * result + ((getBaseRateValue() == null) ? 0 : getBaseRateValue().hashCode());
        result = prime * result + ((getRateFloatMember() == null) ? 0 : getRateFloatMember().hashCode());
        result = prime * result + ((getOverdueRateUpProportion() == null) ? 0 : getOverdueRateUpProportion().hashCode());
        result = prime * result + ((getYearRate() == null) ? 0 : getYearRate().hashCode());
        result = prime * result + ((getAmountDetailId() == null) ? 0 : getAmountDetailId().hashCode());
        result = prime * result + ((getFloatType() == null) ? 0 : getFloatType().hashCode());
        result = prime * result + ((getFloatWay() == null) ? 0 : getFloatWay().hashCode());
        result = prime * result + ((getGracePeriodDay() == null) ? 0 : getGracePeriodDay().hashCode());
        result = prime * result + ((getGracePeriodType() == null) ? 0 : getGracePeriodType().hashCode());
        result = prime * result + ((getGraceCountIntFlag() == null) ? 0 : getGraceCountIntFlag().hashCode());
        result = prime * result + ((getHolidayFlg() == null) ? 0 : getHolidayFlg().hashCode());
        result = prime * result + ((getHolidayIntFlg() == null) ? 0 : getHolidayIntFlg().hashCode());
        result = prime * result + ((getFeeFlag() == null) ? 0 : getFeeFlag().hashCode());
        result = prime * result + ((getDiscFlag() == null) ? 0 : getDiscFlag().hashCode());
        return result;
    }
}