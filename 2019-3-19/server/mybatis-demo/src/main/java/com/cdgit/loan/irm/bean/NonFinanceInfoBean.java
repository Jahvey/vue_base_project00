package com.cdgit.loan.irm.bean;

import java.util.List;

public class NonFinanceInfoBean {

	private String indexId;////指标编号
	private String propertyTypeCd;////指标类别
	private String indexName;///指标名称
	private String indexDesc;////指标说明、
	private String remarks;////附加说明
	private String indexValue;//勾选结果
	private List<TbIrmIndexScore> tbIrmIndexScores;//选项内容
	public String getIndexId() {
		return indexId;
	}
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	public String getPropertyTypeCd() {
		return propertyTypeCd;
	}
	public void setPropertyTypeCd(String propertyTypeCd) {
		this.propertyTypeCd = propertyTypeCd;
	}
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public String getIndexDesc() {
		return indexDesc;
	}
	public void setIndexDesc(String indexDesc) {
		this.indexDesc = indexDesc;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getIndexValue() {
		return indexValue;
	}
	public void setIndexValue(String indexValue) {
		this.indexValue = indexValue;
	}
	public List<TbIrmIndexScore> getTbIrmIndexScores() {
		return tbIrmIndexScores;
	}
	public void setTbIrmIndexScores(List<TbIrmIndexScore> tbIrmIndexScores) {
		this.tbIrmIndexScores = tbIrmIndexScores;
	}
	
	
}
