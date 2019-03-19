package com.cdgit.loan.irm.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbAccFinanceIndexData {

	private String indexDataId;//财务指标ID
	private String financeId;//财务信息ID
	private BigDecimal indexValueDataType;//指标值数据类型
	private String stringType;//字符串类型
	private String indexDisp;//指标描述
	private String indexCd;//指标代码
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	public String getIndexDataId() {
		return indexDataId;
	}
	public void setIndexDataId(String indexDataId) {
		this.indexDataId = indexDataId;
	}
	public String getFinanceId() {
		return financeId;
	}
	public void setFinanceId(String financeId) {
		this.financeId = financeId;
	}
	public BigDecimal getIndexValueDataType() {
		return indexValueDataType;
	}
	public void setIndexValueDataType(BigDecimal indexValueDataType) {
		this.indexValueDataType = indexValueDataType;
	}
	public String getStringType() {
		return stringType;
	}
	public void setStringType(String stringType) {
		this.stringType = stringType;
	}
	public String getIndexDisp() {
		return indexDisp;
	}
	public void setIndexDisp(String indexDisp) {
		this.indexDisp = indexDisp;
	}
	public String getIndexCd() {
		return indexCd;
	}
	public void setIndexCd(String indexCd) {
		this.indexCd = indexCd;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
