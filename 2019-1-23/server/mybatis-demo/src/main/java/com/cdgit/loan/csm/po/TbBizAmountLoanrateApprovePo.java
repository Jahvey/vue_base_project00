package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class TbBizAmountLoanrateApprovePo {
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
		public String toString() {
			return "TbBizAmountLoanrateApprovePo [loanrateId=" + loanrateId + ", createTime=" + createTime
					+ ", updateTime=" + updateTime + ", rateType=" + rateType + ", interestCollectType="
					+ interestCollectType + ", irUpdateFrequency=" + irUpdateFrequency + ", baseRateValue="
					+ baseRateValue + ", overdueRateUpProportion=" + overdueRateUpProportion + ", amountDetailId="
					+ amountDetailId + ", floatType=" + floatType + ", floatWay=" + floatWay + ", gracePeriodDay="
					+ gracePeriodDay + ", gracePeriodType=" + gracePeriodType + ", graceCountIntFlag="
					+ graceCountIntFlag + ", holidayFlg=" + holidayFlg + ", holidayIntFlg=" + holidayIntFlg
					+ ", feeFlag=" + feeFlag + ", discFlag=" + discFlag + "]";
		}
	    
	
}
