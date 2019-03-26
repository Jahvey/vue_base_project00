package com.cdgit.loan.guaranteevaluation.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 返回查询信用保险列表bean
 * 
 * @author wuyong
 *
 */
public class CreditsafeBean {
	private String relationId;
	private String suretyId;
	private String suretyType;
	private String currencyCd;
	private String policyHolder;
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal guaranteeMoney;
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal creditLimit;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date effectiveDate;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date endDate;
	public String getRelationId() {
		return relationId;
	}
	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	public String getSuretyId() {
		return suretyId;
	}
	public void setSuretyId(String suretyId) {
		this.suretyId = suretyId;
	}
	public String getSuretyType() {
		return suretyType;
	}
	public void setSuretyType(String suretyType) {
		this.suretyType = suretyType;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	public String getPolicyHolder() {
		return policyHolder;
	}
	public void setPolicyHolder(String policyHolder) {
		this.policyHolder = policyHolder;
	}
	public BigDecimal getGuaranteeMoney() {
		return guaranteeMoney;
	}
	public void setGuaranteeMoney(BigDecimal guaranteeMoney) {
		this.guaranteeMoney = guaranteeMoney;
	}
	public BigDecimal getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
