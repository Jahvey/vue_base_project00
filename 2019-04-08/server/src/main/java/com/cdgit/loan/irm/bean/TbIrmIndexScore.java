package com.cdgit.loan.irm.bean;

import java.math.BigDecimal;

public class TbIrmIndexScore {

	private String indexNum;
	private BigDecimal indexScore;
	private String indexId;
	private String indexName;
	private String indexType;
	private String propertyTypeCd;
	private String nonFinancialValue;
	private BigDecimal indexWeight;
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public String getIndexType() {
		return indexType;
	}
	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}
	
	public String getPropertyTypeCd() {
		return propertyTypeCd;
	}
	public void setPropertyTypeCd(String propertyTypeCd) {
		this.propertyTypeCd = propertyTypeCd;
	}
	public String getNonFinancialValue() {
		return nonFinancialValue;
	}
	public void setNonFinancialValue(String nonFinancialValue) {
		this.nonFinancialValue = nonFinancialValue;
	}
	public BigDecimal getIndexWeight() {
		return indexWeight;
	}
	public void setIndexWeight(BigDecimal indexWeight) {
		this.indexWeight = indexWeight;
	}
	private String indexDesc;
	private String scoreId;
	private String indexCalcLogic;
	private String indexCode;
	
	public String getIndexCode() {
		return indexCode;
	}
	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}
	public String getIndexNum() {
		return indexNum;
	}
	public void setIndexNum(String indexNum) {
		this.indexNum = indexNum;
	}
	public BigDecimal getIndexScore() {
		return indexScore;
	}
	public void setIndexScore(BigDecimal indexScore) {
		this.indexScore = indexScore;
	}
	public String getIndexId() {
		return indexId;
	}
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	public String getIndexDesc() {
		return indexDesc;
	}
	public void setIndexDesc(String indexDesc) {
		this.indexDesc = indexDesc;
	}
	public String getScoreId() {
		return scoreId;
	}
	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}
	public String getIndexCalcLogic() {
		return indexCalcLogic;
	}
	public void setIndexCalcLogic(String indexCalcLogic) {
		this.indexCalcLogic = indexCalcLogic;
	}
	
	
}
