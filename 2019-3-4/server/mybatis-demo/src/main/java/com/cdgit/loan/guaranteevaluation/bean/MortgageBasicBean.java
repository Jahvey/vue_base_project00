package com.cdgit.loan.guaranteevaluation.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 担保评价的质押，抵押返回bean
 * @author wuyong
 *
 */
public class MortgageBasicBean {
	private String partyName;//抵质押人名称
	private String partyId;//抵质押人Id
	private String suretyName;//抵质押物名称
	private String currencyCd;//币种
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal marketValue;//抵质押物认定价值
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal usedAmt;//已设定担保额
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal totalKhAmt;//抵质押品占用价值
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal suretyAmt;//本次实际担保债权金额
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal mortgageRate;//担保率
	private String collType;//抵质押类型
	private String suretyNo;//抵质押物编号
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal totalAmt;//已担保金额(暂时不用)
	private String suretyId;//押品基本信息id
	
	private String sortType;//抵质押物类型
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal assessValue;//评估价值
	private String ifOtherCommon;//是否有共有人
	@JsonSerialize(using = BigDecimalConvertToString.class)
	private BigDecimal mybankSetValue;//我行已设定担保额
	
	private String relationId;//押品关联表主键
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
	private Date createTime;//TB_GRT_MORTGAGE_BASIC创建时间
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public BigDecimal getAssessValue() {
		return assessValue;
	}
	public void setAssessValue(BigDecimal assessValue) {
		this.assessValue = assessValue;
	}
	public String getIfOtherCommon() {
		return ifOtherCommon;
	}
	public void setIfOtherCommon(String ifOtherCommon) {
		this.ifOtherCommon = ifOtherCommon;
	}
	public BigDecimal getMybankSetValue() {
		return mybankSetValue;
	}
	public void setMybankSetValue(BigDecimal mybankSetValue) {
		this.mybankSetValue = mybankSetValue;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getSuretyName() {
		return suretyName;
	}
	public void setSuretyName(String suretyName) {
		this.suretyName = suretyName;
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
	public BigDecimal getUsedAmt() {
		return usedAmt;
	}
	public void setUsedAmt(BigDecimal usedAmt) {
		this.usedAmt = usedAmt;
	}
	public BigDecimal getTotalKhAmt() {
		return totalKhAmt;
	}
	public void setTotalKhAmt(BigDecimal totalKhAmt) {
		this.totalKhAmt = totalKhAmt;
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
	public String getCollType() {
		return collType;
	}
	public void setCollType(String collType) {
		this.collType = collType;
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
