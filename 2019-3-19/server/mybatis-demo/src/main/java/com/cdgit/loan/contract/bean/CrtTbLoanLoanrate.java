package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * tb_loan_loanrate 记录合同的业务利率结构
 * @author Administrator
 *
 */
public class CrtTbLoanLoanrate {
	
    private String loanrateId;							//主键

    private Date createTime;							//创建时间

    private Date updateTime;							//更新时间

    private String rateType;							//利率类型(:XD_SXCD1016)

    private String interestCollectType;					//结息周期(:XD_SXCD1018)

    private BigDecimal rateFloatProportion;				//上下浮动百分比

    private String irUpdateFrequency;					//利率调整方式(:XD_SXCD1148)

    private BigDecimal baseRateValue;					//基准利率

    private BigDecimal rateFloatMember;					//浮动值

    private String overdueRateUpProportion;				//罚息率

    private BigDecimal yearRate;						//申请利率

    private String floatType;							//浮动形式

    private String floatWay;							//浮动方式(:XD_SXCD1147)

    private Integer gracePeriodDay;						//宽限期天数

    private String gracePeriodType;						//宽限期方式(:XD_SXYW0210)

    private String graceCountIntFlag;					//宽限期计息标志(:XD_SXYW0234)

    private String contractId;							//合同id

    private String loanId;								//放款id

    private String summaryId;							//借据ID

    private String holidayFlg;							//节假日顺延标志(:XD_0002)

    private String holidayIntFlg;						//节假日利息处理方式(:XD_SXYW0234)

    private String feeFlag;								//费用收取标识(:XD_FYSQ001)

    private String discFlag;							//贴息标志(:XD_TXBZ001)

    private BigDecimal newBaseRateValue;				//新基准利率

    private BigDecimal newYearRate;						//新执行利率(申请利率)

    private String validDate;							//新利率执行日期

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

    public BigDecimal getBaseRateValue() {
        return baseRateValue;
    }

    public void setBaseRateValue(BigDecimal baseRateValue) {
        this.baseRateValue = baseRateValue;
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

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

    public String getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(String summaryId) {
        this.summaryId = summaryId == null ? null : summaryId.trim();
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

    public BigDecimal getNewBaseRateValue() {
        return newBaseRateValue;
    }

    public void setNewBaseRateValue(BigDecimal newBaseRateValue) {
        this.newBaseRateValue = newBaseRateValue;
    }

    public BigDecimal getNewYearRate() {
        return newYearRate;
    }

    public void setNewYearRate(BigDecimal newYearRate) {
        this.newYearRate = newYearRate;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate == null ? null : validDate.trim();
    }
}