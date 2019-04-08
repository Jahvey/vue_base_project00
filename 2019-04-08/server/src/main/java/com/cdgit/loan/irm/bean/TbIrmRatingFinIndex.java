package com.cdgit.loan.irm.bean;

public class TbIrmRatingFinIndex {

	private String indexId;//财务指标代码ID
	private String indexCd;//指标代码
	private String indexName;//指标名称
	private String indexFormula;//指标公式
	private String remarks;//附注
	private String propertyTypeCd;//v属性类型代码
	private String customerTypeCd;//客户类型代码
	public String getIndexId() {
		return indexId;
	}
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public String getIndexFormula() {
		return indexFormula;
	}
	public void setIndexFormula(String indexFormula) {
		this.indexFormula = indexFormula;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getIndexCd() {
		return indexCd;
	}
	public void setIndexCd(String indexCd) {
		this.indexCd = indexCd;
	}
	public String getPropertyTypeCd() {
		return propertyTypeCd;
	}
	public void setPropertyTypeCd(String propertyTypeCd) {
		this.propertyTypeCd = propertyTypeCd;
	}
	public String getCustomerTypeCd() {
		return customerTypeCd;
	}
	public void setCustomerTypeCd(String customerTypeCd) {
		this.customerTypeCd = customerTypeCd;
	}
	
	
}
