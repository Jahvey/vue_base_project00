package com.cdgit.loan.guaranteevaluation.bean;

import java.math.BigDecimal;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 担保评价的质押，抵押返回bean
 * @author wuyong
 *
 */
public class MortgageBasicBean {
	private String partyName;//抵质押人名称
	private String partyId;//抵质押人Id
	private String collateralName;//抵质押物名称
	private String currencyCd;//币种
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal marketValue;//抵质押物认定价值
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal setGuarantyAmt;//已设定担保额
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal mortgageValue;//抵质押品占用价值
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal suretyAmt;//本次实际担保债权金额
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal mortgageRate;//担保率
	private String mpType;//抵质押类型
	private String suretyType;//担保类型，默认情况等于抵质押类型
	private String suretyNo;//抵质押物编号
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal totalAmt;//已担保金额(暂时不用)
	private String suretyId;//关联表担保品id
	
	private String collateralTypeCd;//抵质押物类型
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal assessValue;//评估价值

	
	private String relationId;//押品关联表主键
	private String guarantyId;//担保品id

	
	public String getCollateralName() {
		return collateralName;
	}
	public void setCollateralName(String collateralName) {
		this.collateralName = collateralName;
	}
	public BigDecimal getSetGuarantyAmt() {
		return setGuarantyAmt;
	}
	public void setSetGuarantyAmt(BigDecimal setGuarantyAmt) {
		this.setGuarantyAmt = setGuarantyAmt;
	}
	public BigDecimal getMortgageValue() {
		return mortgageValue;
	}
	public void setMortgageValue(BigDecimal mortgageValue) {
		this.mortgageValue = mortgageValue;
	}
	public String getMpType() {
		return mpType;
	}
	public void setMpType(String mpType) {
		this.mpType = mpType;
	}
	public String getSuretyType() {
		return suretyType;
	}
	public void setSuretyType(String suretyType) {
		this.suretyType = suretyType;
	}
	public String getCollateralTypeCd() {
		return collateralTypeCd;
	}
	public void setCollateralTypeCd(String collateralTypeCd) {
		this.collateralTypeCd = collateralTypeCd;
	}
	public String getGuarantyId() {
		return guarantyId;
	}
	public void setGuarantyId(String guarantyId) {
		this.guarantyId = guarantyId;
	}
	public String getRelationId() {
		return relationId;
	}
	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public BigDecimal getAssessValue() {
		return assessValue;
	}
	public void setAssessValue(BigDecimal assessValue) {
		this.assessValue = assessValue;
	}

	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	public BigDecimal getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(BigDecimal marketValue) {
		this.marketValue = marketValue;
	}
	public BigDecimal getSuretyAmt() {
		return suretyAmt;
	}
	public void setSuretyAmt(BigDecimal suretyAmt) {
		this.suretyAmt = suretyAmt;
	}
	public BigDecimal getMortgageRate() {
		return mortgageRate;
	}
	public void setMortgageRate(BigDecimal mortgageRate) {
		this.mortgageRate = mortgageRate;
	}
	public String getSuretyNo() {
		return suretyNo;
	}
	public void setSuretyNo(String suretyNo) {
		this.suretyNo = suretyNo;
	}
	public BigDecimal getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getSuretyId() {
		return suretyId;
	}
	public void setSuretyId(String suretyId) {
		this.suretyId = suretyId;
	}
	
	
	
}
