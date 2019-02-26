package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class TbBizAmountApprovePo {
	
    private String amountId;

    private String guarantyType;

    private String partyId;

    private String amountClassify;

    private String creditType;

    private BigDecimal creditAmount;

    private Integer creditTerm;

    private String applyDesc;

    private Date createTime;

    private Date updateTime;

    private String cycleUnit;

    private String statusCd;

    private String currencyCd;

    private String mainGuarantyType;

    private String approveId;

    private BigDecimal creditAvi;

    private BigDecimal creditUsed;

    private String frzNum;

    private BigDecimal frzAmt;

    private String operFlag;

    private String frzEndDate;

    private String frzType;

    private String frzStatus;

    private String frzReason;

    public String getAmountId() {
        return amountId;
    }

    public void setAmountId(String amountId) {
        this.amountId = amountId == null ? null : amountId.trim();
    }

    public String getGuarantyType() {
        return guarantyType;
    }

    public void setGuarantyType(String guarantyType) {
        this.guarantyType = guarantyType == null ? null : guarantyType.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getAmountClassify() {
        return amountClassify;
    }

    public void setAmountClassify(String amountClassify) {
        this.amountClassify = amountClassify == null ? null : amountClassify.trim();
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType == null ? null : creditType.trim();
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Integer getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(Integer creditTerm) {
        this.creditTerm = creditTerm;
    }

    public String getApplyDesc() {
        return applyDesc;
    }

    public void setApplyDesc(String applyDesc) {
        this.applyDesc = applyDesc == null ? null : applyDesc.trim();
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

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit == null ? null : cycleUnit.trim();
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd == null ? null : statusCd.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public String getMainGuarantyType() {
        return mainGuarantyType;
    }

    public void setMainGuarantyType(String mainGuarantyType) {
        this.mainGuarantyType = mainGuarantyType == null ? null : mainGuarantyType.trim();
    }

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId == null ? null : approveId.trim();
    }

    public BigDecimal getCreditAvi() {
        return creditAvi;
    }

    public void setCreditAvi(BigDecimal creditAvi) {
        this.creditAvi = creditAvi;
    }

    public BigDecimal getCreditUsed() {
        return creditUsed;
    }

    public void setCreditUsed(BigDecimal creditUsed) {
        this.creditUsed = creditUsed;
    }

    public String getFrzNum() {
        return frzNum;
    }

    public void setFrzNum(String frzNum) {
        this.frzNum = frzNum == null ? null : frzNum.trim();
    }

    public BigDecimal getFrzAmt() {
        return frzAmt;
    }

    public void setFrzAmt(BigDecimal frzAmt) {
        this.frzAmt = frzAmt;
    }

    public String getOperFlag() {
        return operFlag;
    }

    public void setOperFlag(String operFlag) {
        this.operFlag = operFlag == null ? null : operFlag.trim();
    }

    public String getFrzEndDate() {
        return frzEndDate;
    }

    public void setFrzEndDate(String frzEndDate) {
        this.frzEndDate = frzEndDate == null ? null : frzEndDate.trim();
    }

    public String getFrzType() {
        return frzType;
    }

    public void setFrzType(String frzType) {
        this.frzType = frzType == null ? null : frzType.trim();
    }

    public String getFrzStatus() {
        return frzStatus;
    }

    public void setFrzStatus(String frzStatus) {
        this.frzStatus = frzStatus == null ? null : frzStatus.trim();
    }

    public String getFrzReason() {
        return frzReason;
    }

    public void setFrzReason(String frzReason) {
        this.frzReason = frzReason == null ? null : frzReason.trim();
    }

	@Override
	public String toString() {
		return "TbBizAmountApprovePo [amountId=" + amountId + ", guarantyType=" + guarantyType + ", partyId=" + partyId
				+ ", amountClassify=" + amountClassify + ", creditType=" + creditType + ", creditAmount=" + creditAmount
				+ ", creditTerm=" + creditTerm + ", applyDesc=" + applyDesc + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", cycleUnit=" + cycleUnit + ", statusCd=" + statusCd + ", currencyCd="
				+ currencyCd + ", mainGuarantyType=" + mainGuarantyType + ", approveId=" + approveId + ", creditAvi="
				+ creditAvi + ", creditUsed=" + creditUsed + ", frzNum=" + frzNum + ", frzAmt=" + frzAmt + ", operFlag="
				+ operFlag + ", frzEndDate=" + frzEndDate + ", frzType=" + frzType + ", frzStatus=" + frzStatus
				+ ", frzReason=" + frzReason + "]";
	}
    
    


}
