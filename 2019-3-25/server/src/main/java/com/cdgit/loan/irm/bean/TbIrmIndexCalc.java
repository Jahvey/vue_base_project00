package com.cdgit.loan.irm.bean;

import java.math.BigDecimal;

public class TbIrmIndexCalc {

	private String idxCalcId;
	private String indexId;
	private String indexType;
	private BigDecimal indexScore;
	private BigDecimal indexWeight;
	private String indexClass;
	private String recId;
	private BigDecimal indexValue;
	public String getIdxCalcId() {
		return idxCalcId;
	}
	public void setIdxCalcId(String idxCalcId) {
		this.idxCalcId = idxCalcId;
	}
	public String getIndexId() {
		return indexId;
	}
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	public String getIndexType() {
		return indexType;
	}
	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}
	public BigDecimal getIndexScore() {
		return indexScore;
	}
	public void setIndexScore(BigDecimal indexScore) {
		this.indexScore = indexScore;
	}
	public BigDecimal getIndexWeight() {
		return indexWeight;
	}
	public void setIndexWeight(BigDecimal indexWeight) {
		this.indexWeight = indexWeight;
	}
	public String getIndexClass() {
		return indexClass;
	}
	public void setIndexClass(String indexClass) {
		this.indexClass = indexClass;
	}
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
	public BigDecimal getIndexValue() {
		return indexValue;
	}
	public void setIndexValue(BigDecimal indexValue) {
		this.indexValue = indexValue;
	}
	
	
}
