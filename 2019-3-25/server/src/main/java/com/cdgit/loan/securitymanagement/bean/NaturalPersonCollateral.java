package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 查询自然人的抵质押品返回的bean
 * @author wuyong
 * @date 2019.1.14
 *
 */
public class NaturalPersonCollateral {
	private String partyNum;//抵质押人编号
	private String partyName;//抵质押人
	private String certType;
	private String certNum;
	private String isPotentialCust;
	private String isFarmer;
	private String partyId;
	private String phoneNumber;
	private String isThirdCust;
	private String guarantyId;//抵质押品主键
	private String collateralName;//抵质押品名称
	private String collateralTypeCd;//抵质押物类别
	private String customerType;//客户类型
	private String collateralNum;//抵质押物编号
	@JsonSerialize(using=BigDecimalConvertToString.class)
	private BigDecimal marketValue;//抵质押物认定价值(元)
	private String currencyCd;//币种
	@JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
	private Date timeMark;//建档日期
	
	private String isBind;//是否已经绑定业务
	
	public String getIsBind() {
		return isBind;
	}
	public void setIsBind(String isBind) {
		this.isBind = isBind;
	}
	public String getPartyNum() {
		return partyNum;
	}
	public void setPartyNum(String partyNum) {
		this.partyNum = partyNum;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertNum() {
		return certNum;
	}
	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}
	public String getIsPotentialCust() {
		return isPotentialCust;
	}
	public void setIsPotentialCust(String isPotentialCust) {
		this.isPotentialCust = isPotentialCust;
	}
	public String getIsFarmer() {
		return isFarmer;
	}
	public void setIsFarmer(String isFarmer) {
		this.isFarmer = isFarmer;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getIsThirdCust() {
		return isThirdCust;
	}
	public void setIsThirdCust(String isThirdCust) {
		this.isThirdCust = isThirdCust;
	}
	public String getGuarantyId() {
		return guarantyId;
	}
	public void setGuarantyId(String guarantyId) {
		this.guarantyId = guarantyId;
	}
	public String getCollateralName() {
		return collateralName;
	}
	public void setCollateralName(String collateralName) {
		this.collateralName = collateralName;
	}
	public String getCollateralTypeCd() {
		return collateralTypeCd;
	}
	public void setCollateralTypeCd(String collateralTypeCd) {
		this.collateralTypeCd = collateralTypeCd;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getCollateralNum() {
		return collateralNum;
	}
	public void setCollateralNum(String collateralNum) {
		this.collateralNum = collateralNum;
	}
	public BigDecimal getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(BigDecimal marketValue) {
		this.marketValue = marketValue;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	public Date getTimeMark() {
		return timeMark;
	}
	public void setTimeMark(Date timeMark) {
		this.timeMark = timeMark;
	}
	
}
