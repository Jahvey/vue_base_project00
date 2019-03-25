package com.cdgit.loan.guaranteevaluation.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 押品-保证金表
 * @author wuyong
 *
 */
public class GrtMargin {
    private String suretyKeyId;

    private String suretyId;

    private String marginAccount;

    private String currencyCd;

    private BigDecimal maginScale;

    private BigDecimal accBalance;

    private Date endDate;

    private String marginSort;

    private String openBank;

    private String acctName;

    private String isJixi;

    private BigDecimal marginRate;

    private String appendFlag;

    private String orgNum;

    private String userNum;

    private Date createTime;

    private Date updateTime;

    private Date beginDate;

    private BigDecimal appendAmt;

    public String getSuretyKeyId() {
        return suretyKeyId;
    }

    public void setSuretyKeyId(String suretyKeyId) {
        this.suretyKeyId = suretyKeyId == null ? null : suretyKeyId.trim();
    }

    public String getSuretyId() {
        return suretyId;
    }

    public void setSuretyId(String suretyId) {
        this.suretyId = suretyId == null ? null : suretyId.trim();
    }

    public String getMarginAccount() {
        return marginAccount;
    }

    public void setMarginAccount(String marginAccount) {
        this.marginAccount = marginAccount == null ? null : marginAccount.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getMaginScale() {
        return maginScale;
    }

    public void setMaginScale(BigDecimal maginScale) {
        this.maginScale = maginScale;
    }

    public BigDecimal getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(BigDecimal accBalance) {
        this.accBalance = accBalance;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMarginSort() {
        return marginSort;
    }

    public void setMarginSort(String marginSort) {
        this.marginSort = marginSort == null ? null : marginSort.trim();
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank == null ? null : openBank.trim();
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName == null ? null : acctName.trim();
    }

    public String getIsJixi() {
        return isJixi;
    }

    public void setIsJixi(String isJixi) {
        this.isJixi = isJixi == null ? null : isJixi.trim();
    }

    public BigDecimal getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(BigDecimal marginRate) {
        this.marginRate = marginRate;
    }

    public String getAppendFlag() {
        return appendFlag;
    }

    public void setAppendFlag(String appendFlag) {
        this.appendFlag = appendFlag == null ? null : appendFlag.trim();
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public BigDecimal getAppendAmt() {
        return appendAmt;
    }

    public void setAppendAmt(BigDecimal appendAmt) {
        this.appendAmt = appendAmt;
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
        GrtMargin other = (GrtMargin) that;
        return (this.getSuretyKeyId() == null ? other.getSuretyKeyId() == null : this.getSuretyKeyId().equals(other.getSuretyKeyId()))
            && (this.getSuretyId() == null ? other.getSuretyId() == null : this.getSuretyId().equals(other.getSuretyId()))
            && (this.getMarginAccount() == null ? other.getMarginAccount() == null : this.getMarginAccount().equals(other.getMarginAccount()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getMaginScale() == null ? other.getMaginScale() == null : this.getMaginScale().equals(other.getMaginScale()))
            && (this.getAccBalance() == null ? other.getAccBalance() == null : this.getAccBalance().equals(other.getAccBalance()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getMarginSort() == null ? other.getMarginSort() == null : this.getMarginSort().equals(other.getMarginSort()))
            && (this.getOpenBank() == null ? other.getOpenBank() == null : this.getOpenBank().equals(other.getOpenBank()))
            && (this.getAcctName() == null ? other.getAcctName() == null : this.getAcctName().equals(other.getAcctName()))
            && (this.getIsJixi() == null ? other.getIsJixi() == null : this.getIsJixi().equals(other.getIsJixi()))
            && (this.getMarginRate() == null ? other.getMarginRate() == null : this.getMarginRate().equals(other.getMarginRate()))
            && (this.getAppendFlag() == null ? other.getAppendFlag() == null : this.getAppendFlag().equals(other.getAppendFlag()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
            && (this.getAppendAmt() == null ? other.getAppendAmt() == null : this.getAppendAmt().equals(other.getAppendAmt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSuretyKeyId() == null) ? 0 : getSuretyKeyId().hashCode());
        result = prime * result + ((getSuretyId() == null) ? 0 : getSuretyId().hashCode());
        result = prime * result + ((getMarginAccount() == null) ? 0 : getMarginAccount().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getMaginScale() == null) ? 0 : getMaginScale().hashCode());
        result = prime * result + ((getAccBalance() == null) ? 0 : getAccBalance().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getMarginSort() == null) ? 0 : getMarginSort().hashCode());
        result = prime * result + ((getOpenBank() == null) ? 0 : getOpenBank().hashCode());
        result = prime * result + ((getAcctName() == null) ? 0 : getAcctName().hashCode());
        result = prime * result + ((getIsJixi() == null) ? 0 : getIsJixi().hashCode());
        result = prime * result + ((getMarginRate() == null) ? 0 : getMarginRate().hashCode());
        result = prime * result + ((getAppendFlag() == null) ? 0 : getAppendFlag().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
        result = prime * result + ((getAppendAmt() == null) ? 0 : getAppendAmt().hashCode());
        return result;
    }
}