package com.cdgit.loan.user.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbCsmBondInfo {
    private String bondId;

    private String partyId;

    private Date issueDate;

    private String bondTypeCd;

    private String currencyCd;

    private BigDecimal issueAmt;

    private String remark;

    private Date purchaseDate;

    private String bondName;

    private String bondStatusCd;

    private String rateWayState;

    private String ifMarketed;

    private Long bondTerm;

    private Date createTime;

    private Date updateTime;

    public String getBondId() {
        return bondId;
    }

    public void setBondId(String bondId) {
        this.bondId = bondId == null ? null : bondId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getBondTypeCd() {
        return bondTypeCd;
    }

    public void setBondTypeCd(String bondTypeCd) {
        this.bondTypeCd = bondTypeCd == null ? null : bondTypeCd.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getIssueAmt() {
        return issueAmt;
    }

    public void setIssueAmt(BigDecimal issueAmt) {
        this.issueAmt = issueAmt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName == null ? null : bondName.trim();
    }

    public String getBondStatusCd() {
        return bondStatusCd;
    }

    public void setBondStatusCd(String bondStatusCd) {
        this.bondStatusCd = bondStatusCd == null ? null : bondStatusCd.trim();
    }

    public String getRateWayState() {
        return rateWayState;
    }

    public void setRateWayState(String rateWayState) {
        this.rateWayState = rateWayState == null ? null : rateWayState.trim();
    }

    public String getIfMarketed() {
        return ifMarketed;
    }

    public void setIfMarketed(String ifMarketed) {
        this.ifMarketed = ifMarketed == null ? null : ifMarketed.trim();
    }

    public Long getBondTerm() {
        return bondTerm;
    }

    public void setBondTerm(Long bondTerm) {
        this.bondTerm = bondTerm;
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
        TbCsmBondInfo other = (TbCsmBondInfo) that;
        return (this.getBondId() == null ? other.getBondId() == null : this.getBondId().equals(other.getBondId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getIssueDate() == null ? other.getIssueDate() == null : this.getIssueDate().equals(other.getIssueDate()))
            && (this.getBondTypeCd() == null ? other.getBondTypeCd() == null : this.getBondTypeCd().equals(other.getBondTypeCd()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getIssueAmt() == null ? other.getIssueAmt() == null : this.getIssueAmt().equals(other.getIssueAmt()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getPurchaseDate() == null ? other.getPurchaseDate() == null : this.getPurchaseDate().equals(other.getPurchaseDate()))
            && (this.getBondName() == null ? other.getBondName() == null : this.getBondName().equals(other.getBondName()))
            && (this.getBondStatusCd() == null ? other.getBondStatusCd() == null : this.getBondStatusCd().equals(other.getBondStatusCd()))
            && (this.getRateWayState() == null ? other.getRateWayState() == null : this.getRateWayState().equals(other.getRateWayState()))
            && (this.getIfMarketed() == null ? other.getIfMarketed() == null : this.getIfMarketed().equals(other.getIfMarketed()))
            && (this.getBondTerm() == null ? other.getBondTerm() == null : this.getBondTerm().equals(other.getBondTerm()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBondId() == null) ? 0 : getBondId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getIssueDate() == null) ? 0 : getIssueDate().hashCode());
        result = prime * result + ((getBondTypeCd() == null) ? 0 : getBondTypeCd().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getIssueAmt() == null) ? 0 : getIssueAmt().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getPurchaseDate() == null) ? 0 : getPurchaseDate().hashCode());
        result = prime * result + ((getBondName() == null) ? 0 : getBondName().hashCode());
        result = prime * result + ((getBondStatusCd() == null) ? 0 : getBondStatusCd().hashCode());
        result = prime * result + ((getRateWayState() == null) ? 0 : getRateWayState().hashCode());
        result = prime * result + ((getIfMarketed() == null) ? 0 : getIfMarketed().hashCode());
        result = prime * result + ((getBondTerm() == null) ? 0 : getBondTerm().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}