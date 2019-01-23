package com.cdgit.loan.business.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbBizAmountApprove {
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
        TbBizAmountApprove other = (TbBizAmountApprove) that;
        return (this.getAmountId() == null ? other.getAmountId() == null : this.getAmountId().equals(other.getAmountId()))
            && (this.getGuarantyType() == null ? other.getGuarantyType() == null : this.getGuarantyType().equals(other.getGuarantyType()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getAmountClassify() == null ? other.getAmountClassify() == null : this.getAmountClassify().equals(other.getAmountClassify()))
            && (this.getCreditType() == null ? other.getCreditType() == null : this.getCreditType().equals(other.getCreditType()))
            && (this.getCreditAmount() == null ? other.getCreditAmount() == null : this.getCreditAmount().equals(other.getCreditAmount()))
            && (this.getCreditTerm() == null ? other.getCreditTerm() == null : this.getCreditTerm().equals(other.getCreditTerm()))
            && (this.getApplyDesc() == null ? other.getApplyDesc() == null : this.getApplyDesc().equals(other.getApplyDesc()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCycleUnit() == null ? other.getCycleUnit() == null : this.getCycleUnit().equals(other.getCycleUnit()))
            && (this.getStatusCd() == null ? other.getStatusCd() == null : this.getStatusCd().equals(other.getStatusCd()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getMainGuarantyType() == null ? other.getMainGuarantyType() == null : this.getMainGuarantyType().equals(other.getMainGuarantyType()))
            && (this.getApproveId() == null ? other.getApproveId() == null : this.getApproveId().equals(other.getApproveId()))
            && (this.getCreditAvi() == null ? other.getCreditAvi() == null : this.getCreditAvi().equals(other.getCreditAvi()))
            && (this.getCreditUsed() == null ? other.getCreditUsed() == null : this.getCreditUsed().equals(other.getCreditUsed()))
            && (this.getFrzNum() == null ? other.getFrzNum() == null : this.getFrzNum().equals(other.getFrzNum()))
            && (this.getFrzAmt() == null ? other.getFrzAmt() == null : this.getFrzAmt().equals(other.getFrzAmt()))
            && (this.getOperFlag() == null ? other.getOperFlag() == null : this.getOperFlag().equals(other.getOperFlag()))
            && (this.getFrzEndDate() == null ? other.getFrzEndDate() == null : this.getFrzEndDate().equals(other.getFrzEndDate()))
            && (this.getFrzType() == null ? other.getFrzType() == null : this.getFrzType().equals(other.getFrzType()))
            && (this.getFrzStatus() == null ? other.getFrzStatus() == null : this.getFrzStatus().equals(other.getFrzStatus()))
            && (this.getFrzReason() == null ? other.getFrzReason() == null : this.getFrzReason().equals(other.getFrzReason()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAmountId() == null) ? 0 : getAmountId().hashCode());
        result = prime * result + ((getGuarantyType() == null) ? 0 : getGuarantyType().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getAmountClassify() == null) ? 0 : getAmountClassify().hashCode());
        result = prime * result + ((getCreditType() == null) ? 0 : getCreditType().hashCode());
        result = prime * result + ((getCreditAmount() == null) ? 0 : getCreditAmount().hashCode());
        result = prime * result + ((getCreditTerm() == null) ? 0 : getCreditTerm().hashCode());
        result = prime * result + ((getApplyDesc() == null) ? 0 : getApplyDesc().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCycleUnit() == null) ? 0 : getCycleUnit().hashCode());
        result = prime * result + ((getStatusCd() == null) ? 0 : getStatusCd().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getMainGuarantyType() == null) ? 0 : getMainGuarantyType().hashCode());
        result = prime * result + ((getApproveId() == null) ? 0 : getApproveId().hashCode());
        result = prime * result + ((getCreditAvi() == null) ? 0 : getCreditAvi().hashCode());
        result = prime * result + ((getCreditUsed() == null) ? 0 : getCreditUsed().hashCode());
        result = prime * result + ((getFrzNum() == null) ? 0 : getFrzNum().hashCode());
        result = prime * result + ((getFrzAmt() == null) ? 0 : getFrzAmt().hashCode());
        result = prime * result + ((getOperFlag() == null) ? 0 : getOperFlag().hashCode());
        result = prime * result + ((getFrzEndDate() == null) ? 0 : getFrzEndDate().hashCode());
        result = prime * result + ((getFrzType() == null) ? 0 : getFrzType().hashCode());
        result = prime * result + ((getFrzStatus() == null) ? 0 : getFrzStatus().hashCode());
        result = prime * result + ((getFrzReason() == null) ? 0 : getFrzReason().hashCode());
        return result;
    }
}