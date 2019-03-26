package com.cdgit.loan.guaranteevaluation.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestParam;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 返回查询保证金列表bean
 * @author wuyong
 *
 */
public class CashDepositBean {
	private String relationId;
	private String suretyKeyId;
	private String marginAccount;
	private String suretyId;
	private String marginSort;
	private String currencyCd;
	private String openBank;
	private String acctName;
	private String isJixi;
	private String appendFlag;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
	private Date endDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date beginDate;
    @JsonSerialize(using=BigDecimalConvertToString.class)
	private BigDecimal marginRate;
    @JsonSerialize(using=BigDecimalConvertToString.class)
	private BigDecimal appendAmt;
    @JsonSerialize(using=BigDecimalConvertToString.class)
	private BigDecimal maginScale;
    @JsonSerialize(using=BigDecimalConvertToString.class)
	private BigDecimal accBalance;
    
	public String getAppendFlag() {
		return appendFlag;
	}
	public void setAppendFlag(String appendFlag) {
		this.appendFlag = appendFlag;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public String getRelationId() {
		return relationId;
	}
	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	public String getSuretyKeyId() {
		return suretyKeyId;
	}
	public void setSuretyKeyId(String suretyKeyId) {
		this.suretyKeyId = suretyKeyId;
	}
	public String getMarginAccount() {
		return marginAccount;
	}
	public void setMarginAccount(String marginAccount) {
		this.marginAccount = marginAccount;
	}
	public String getSuretyId() {
		return suretyId;
	}
	public void setSuretyId(String suretyId) {
		this.suretyId = suretyId;
	}
	public String getMarginSort() {
		return marginSort;
	}
	public void setMarginSort(String marginSort) {
		this.marginSort = marginSort;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	public String getOpenBank() {
		return openBank;
	}
	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}
	public String getAcctName() {
		return acctName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public String getIsJixi() {
		return isJixi;
	}
	public void setIsJixi(String isJixi) {
		this.isJixi = isJixi;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public BigDecimal getMarginRate() {
		return marginRate;
	}
	public void setMarginRate(BigDecimal marginRate) {
		this.marginRate = marginRate;
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
	public BigDecimal getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(BigDecimal accBalance) {
		this.accBalance = accBalance;
	}
	
	
}
