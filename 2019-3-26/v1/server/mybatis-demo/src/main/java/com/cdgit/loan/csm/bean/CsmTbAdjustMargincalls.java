package com.cdgit.loan.csm.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbAdjustMargincalls {
    private String suretyId;

    private String partyId;

    private String loanId;

    private String contractId;

    private String contractNum;

    private String subcontractId;

    private String subcontractNum;

    private String marginStatus;

    private String appendFlag;

    private BigDecimal appendAmt;

    private BigDecimal maginScale;

    private String marginAccount;

    private String marginSort;

    private String currencyCd;

    private BigDecimal accBalance;

    private Date beginDate;

    private Date endDate;

    private String openBank;

    private String acctName;

    private String isJixi;

    private BigDecimal marginRate;

    private String fullStatus;

    private String orgNum;

    private String userNum;

    private Date createTime;

    private Date updateTime;

    public String getSuretyId() {
        return suretyId;
    }

    public void setSuretyId(String suretyId) {
        this.suretyId = suretyId == null ? null : suretyId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum == null ? null : contractNum.trim();
    }

    public String getSubcontractId() {
        return subcontractId;
    }

    public void setSubcontractId(String subcontractId) {
        this.subcontractId = subcontractId == null ? null : subcontractId.trim();
    }

    public String getSubcontractNum() {
        return subcontractNum;
    }

    public void setSubcontractNum(String subcontractNum) {
        this.subcontractNum = subcontractNum == null ? null : subcontractNum.trim();
    }

    public String getMarginStatus() {
        return marginStatus;
    }

    public void setMarginStatus(String marginStatus) {
        this.marginStatus = marginStatus == null ? null : marginStatus.trim();
    }

    public String getAppendFlag() {
        return appendFlag;
    }

    public void setAppendFlag(String appendFlag) {
        this.appendFlag = appendFlag == null ? null : appendFlag.trim();
    }

    public BigDecimal getAppendAmt() {
        return appendAmt;
    }

    public void setAppendAmt(BigDecimal appendAmt) {
        this.appendAmt = appendAmt;
    }

    public BigDecimal getMaginScale() {
        return maginScale;
    }

    public void setMaginScale(BigDecimal maginScale) {
        this.maginScale = maginScale;
    }

    public String getMarginAccount() {
        return marginAccount;
    }

    public void setMarginAccount(String marginAccount) {
        this.marginAccount = marginAccount == null ? null : marginAccount.trim();
    }

    public String getMarginSort() {
        return marginSort;
    }

    public void setMarginSort(String marginSort) {
        this.marginSort = marginSort == null ? null : marginSort.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(BigDecimal accBalance) {
        this.accBalance = accBalance;
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

    public String getFullStatus() {
        return fullStatus;
    }

    public void setFullStatus(String fullStatus) {
        this.fullStatus = fullStatus == null ? null : fullStatus.trim();
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
}