package com.cdgit.loan.irm.bean;

import java.math.BigDecimal;

public class IndexEntity {

	private String indexId;
	private String indexCode;
	private String indexName;
	private String indexType;
	private String propertyTypeCd;
	private BigDecimal indexValueDataType;
	private BigDecimal indexScore;
	private String indexCalcLogic;
	private String customerTypeCd;
	private BigDecimal indexWeight;
	public BigDecimal getIndexWeight() {
		return indexWeight;
	}
	public void setIndexWeight(BigDecimal indexWeight) {
		this.indexWeight = indexWeight;
	}
	private String remarks;
	private BigDecimal iValue;
	public BigDecimal getiValue() {
		return iValue;
	}
	public void setiValue(BigDecimal iValue) {
		this.iValue = iValue;
	}
	public String getIndexId() {
		return indexId;
	}
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	public String getIndexCode() {
		return indexCode;
	}
	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}
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
	public BigDecimal getIndexValueDataType() {
		return indexValueDataType;
	}
	public void setIndexValueDataType(BigDecimal indexValueDataType) {
		this.indexValueDataType = indexValueDataType;
	}
	public BigDecimal getIndexScore() {
		return indexScore;
	}
	public void setIndexScore(BigDecimal indexScore) {
		this.indexScore = indexScore;
	}
	public String getIndexCalcLogic() {
		return indexCalcLogic;
	}
	public void setIndexCalcLogic(String indexCalcLogic) {
		this.indexCalcLogic = indexCalcLogic;
	}
	public String getCustomerTypeCd() {
		return customerTypeCd;
	}
	public void setCustomerTypeCd(String customerTypeCd) {
		this.customerTypeCd = customerTypeCd;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
