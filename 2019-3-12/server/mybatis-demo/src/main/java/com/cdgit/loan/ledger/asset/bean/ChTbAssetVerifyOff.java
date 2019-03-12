package com.cdgit.loan.ledger.asset.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ChTbAssetVerifyOff {
    private String id;

    private String settle;

    private BigDecimal cancelAmt;

    private BigDecimal cancelNormalItr;

    private BigDecimal cancelArrearItr;

    private BigDecimal cancelPunishItr;

    private String pursue;

    private BigDecimal cancelCapitalAmt;

    private String summaryId;

    private Date updateDate;

    private String updateUserId;

    private String repayNum;

    private String interestCollectType;

    private BigDecimal sumPunishItr;

    private BigDecimal sumArrearItr;

    private BigDecimal sumNormalItr;

    private Date sumEndDate;

    private Date sumBeginDate;

    private BigDecimal summaryBal;

    private BigDecimal summaryAmt;

    private String repayName;

    private String repaymentType;

    private BigDecimal yearRate;

    private String status;

    private String rcnStan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSettle() {
        return settle;
    }

    public void setSettle(String settle) {
        this.settle = settle == null ? null : settle.trim();
    }

    public BigDecimal getCancelAmt() {
        return cancelAmt;
    }

    public void setCancelAmt(BigDecimal cancelAmt) {
        this.cancelAmt = cancelAmt;
    }

    public BigDecimal getCancelNormalItr() {
        return cancelNormalItr;
    }

    public void setCancelNormalItr(BigDecimal cancelNormalItr) {
        this.cancelNormalItr = cancelNormalItr;
    }

    public BigDecimal getCancelArrearItr() {
        return cancelArrearItr;
    }

    public void setCancelArrearItr(BigDecimal cancelArrearItr) {
        this.cancelArrearItr = cancelArrearItr;
    }

    public BigDecimal getCancelPunishItr() {
        return cancelPunishItr;
    }

    public void setCancelPunishItr(BigDecimal cancelPunishItr) {
        this.cancelPunishItr = cancelPunishItr;
    }

    public String getPursue() {
        return pursue;
    }

    public void setPursue(String pursue) {
        this.pursue = pursue == null ? null : pursue.trim();
    }

    public BigDecimal getCancelCapitalAmt() {
        return cancelCapitalAmt;
    }

    public void setCancelCapitalAmt(BigDecimal cancelCapitalAmt) {
        this.cancelCapitalAmt = cancelCapitalAmt;
    }

    public String getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(String summaryId) {
        this.summaryId = summaryId == null ? null : summaryId.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public String getRepayNum() {
        return repayNum;
    }

    public void setRepayNum(String repayNum) {
        this.repayNum = repayNum == null ? null : repayNum.trim();
    }

    public String getInterestCollectType() {
        return interestCollectType;
    }

    public void setInterestCollectType(String interestCollectType) {
        this.interestCollectType = interestCollectType == null ? null : interestCollectType.trim();
    }

    public BigDecimal getSumPunishItr() {
        return sumPunishItr;
    }

    public void setSumPunishItr(BigDecimal sumPunishItr) {
        this.sumPunishItr = sumPunishItr;
    }

    public BigDecimal getSumArrearItr() {
        return sumArrearItr;
    }

    public void setSumArrearItr(BigDecimal sumArrearItr) {
        this.sumArrearItr = sumArrearItr;
    }

    public BigDecimal getSumNormalItr() {
        return sumNormalItr;
    }

    public void setSumNormalItr(BigDecimal sumNormalItr) {
        this.sumNormalItr = sumNormalItr;
    }

    public Date getSumEndDate() {
        return sumEndDate;
    }

    public void setSumEndDate(Date sumEndDate) {
        this.sumEndDate = sumEndDate;
    }

    public Date getSumBeginDate() {
        return sumBeginDate;
    }

    public void setSumBeginDate(Date sumBeginDate) {
        this.sumBeginDate = sumBeginDate;
    }

    public BigDecimal getSummaryBal() {
        return summaryBal;
    }

    public void setSummaryBal(BigDecimal summaryBal) {
        this.summaryBal = summaryBal;
    }

    public BigDecimal getSummaryAmt() {
        return summaryAmt;
    }

    public void setSummaryAmt(BigDecimal summaryAmt) {
        this.summaryAmt = summaryAmt;
    }

    public String getRepayName() {
        return repayName;
    }

    public void setRepayName(String repayName) {
        this.repayName = repayName == null ? null : repayName.trim();
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType == null ? null : repaymentType.trim();
    }

    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRcnStan() {
        return rcnStan;
    }

    public void setRcnStan(String rcnStan) {
        this.rcnStan = rcnStan == null ? null : rcnStan.trim();
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
        ChTbAssetVerifyOff other = (ChTbAssetVerifyOff) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSettle() == null ? other.getSettle() == null : this.getSettle().equals(other.getSettle()))
            && (this.getCancelAmt() == null ? other.getCancelAmt() == null : this.getCancelAmt().equals(other.getCancelAmt()))
            && (this.getCancelNormalItr() == null ? other.getCancelNormalItr() == null : this.getCancelNormalItr().equals(other.getCancelNormalItr()))
            && (this.getCancelArrearItr() == null ? other.getCancelArrearItr() == null : this.getCancelArrearItr().equals(other.getCancelArrearItr()))
            && (this.getCancelPunishItr() == null ? other.getCancelPunishItr() == null : this.getCancelPunishItr().equals(other.getCancelPunishItr()))
            && (this.getPursue() == null ? other.getPursue() == null : this.getPursue().equals(other.getPursue()))
            && (this.getCancelCapitalAmt() == null ? other.getCancelCapitalAmt() == null : this.getCancelCapitalAmt().equals(other.getCancelCapitalAmt()))
            && (this.getSummaryId() == null ? other.getSummaryId() == null : this.getSummaryId().equals(other.getSummaryId()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
            && (this.getRepayNum() == null ? other.getRepayNum() == null : this.getRepayNum().equals(other.getRepayNum()))
            && (this.getInterestCollectType() == null ? other.getInterestCollectType() == null : this.getInterestCollectType().equals(other.getInterestCollectType()))
            && (this.getSumPunishItr() == null ? other.getSumPunishItr() == null : this.getSumPunishItr().equals(other.getSumPunishItr()))
            && (this.getSumArrearItr() == null ? other.getSumArrearItr() == null : this.getSumArrearItr().equals(other.getSumArrearItr()))
            && (this.getSumNormalItr() == null ? other.getSumNormalItr() == null : this.getSumNormalItr().equals(other.getSumNormalItr()))
            && (this.getSumEndDate() == null ? other.getSumEndDate() == null : this.getSumEndDate().equals(other.getSumEndDate()))
            && (this.getSumBeginDate() == null ? other.getSumBeginDate() == null : this.getSumBeginDate().equals(other.getSumBeginDate()))
            && (this.getSummaryBal() == null ? other.getSummaryBal() == null : this.getSummaryBal().equals(other.getSummaryBal()))
            && (this.getSummaryAmt() == null ? other.getSummaryAmt() == null : this.getSummaryAmt().equals(other.getSummaryAmt()))
            && (this.getRepayName() == null ? other.getRepayName() == null : this.getRepayName().equals(other.getRepayName()))
            && (this.getRepaymentType() == null ? other.getRepaymentType() == null : this.getRepaymentType().equals(other.getRepaymentType()))
            && (this.getYearRate() == null ? other.getYearRate() == null : this.getYearRate().equals(other.getYearRate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRcnStan() == null ? other.getRcnStan() == null : this.getRcnStan().equals(other.getRcnStan()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSettle() == null) ? 0 : getSettle().hashCode());
        result = prime * result + ((getCancelAmt() == null) ? 0 : getCancelAmt().hashCode());
        result = prime * result + ((getCancelNormalItr() == null) ? 0 : getCancelNormalItr().hashCode());
        result = prime * result + ((getCancelArrearItr() == null) ? 0 : getCancelArrearItr().hashCode());
        result = prime * result + ((getCancelPunishItr() == null) ? 0 : getCancelPunishItr().hashCode());
        result = prime * result + ((getPursue() == null) ? 0 : getPursue().hashCode());
        result = prime * result + ((getCancelCapitalAmt() == null) ? 0 : getCancelCapitalAmt().hashCode());
        result = prime * result + ((getSummaryId() == null) ? 0 : getSummaryId().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getRepayNum() == null) ? 0 : getRepayNum().hashCode());
        result = prime * result + ((getInterestCollectType() == null) ? 0 : getInterestCollectType().hashCode());
        result = prime * result + ((getSumPunishItr() == null) ? 0 : getSumPunishItr().hashCode());
        result = prime * result + ((getSumArrearItr() == null) ? 0 : getSumArrearItr().hashCode());
        result = prime * result + ((getSumNormalItr() == null) ? 0 : getSumNormalItr().hashCode());
        result = prime * result + ((getSumEndDate() == null) ? 0 : getSumEndDate().hashCode());
        result = prime * result + ((getSumBeginDate() == null) ? 0 : getSumBeginDate().hashCode());
        result = prime * result + ((getSummaryBal() == null) ? 0 : getSummaryBal().hashCode());
        result = prime * result + ((getSummaryAmt() == null) ? 0 : getSummaryAmt().hashCode());
        result = prime * result + ((getRepayName() == null) ? 0 : getRepayName().hashCode());
        result = prime * result + ((getRepaymentType() == null) ? 0 : getRepaymentType().hashCode());
        result = prime * result + ((getYearRate() == null) ? 0 : getYearRate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRcnStan() == null) ? 0 : getRcnStan().hashCode());
        return result;
    }
}