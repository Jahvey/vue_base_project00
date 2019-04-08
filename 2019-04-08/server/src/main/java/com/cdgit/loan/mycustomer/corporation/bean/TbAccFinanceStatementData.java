package com.cdgit.loan.mycustomer.corporation.bean;

import java.math.BigDecimal;

public class TbAccFinanceStatementData {

	private String financeStatementDataId;//财务报表子项数据ID
	private String financialStatementId;//财务报表子项ID
	private String financeId;//财务信息ID
	private String projectCd;//科目代码
	private BigDecimal projectValue;//科目值
	private String createTime;//创建时间
	private String updateTime;//更新时间
	private BigDecimal preTotalValue;//期初累计值
	private String preTotalFlag;//期初累计值标志
	private String projectName;
	private String customerTypeCd;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCustomerTypeCd() {
		return customerTypeCd;
	}
	public void setCustomerTypeCd(String customerTypeCd) {
		this.customerTypeCd = customerTypeCd;
	}
	public String getFinanceStatementDataId() {
		return financeStatementDataId;
	}
	public void setFinanceStatementDataId(String financeStatementDataId) {
		this.financeStatementDataId = financeStatementDataId;
	}
	public String getFinancialStatementId() {
		return financialStatementId;
	}
	public void setFinancialStatementId(String financialStatementId) {
		this.financialStatementId = financialStatementId;
	}
	public String getFinanceId() {
		return financeId;
	}
	public void setFinanceId(String financeId) {
		this.financeId = financeId;
	}
	public String getProjectCd() {
		return projectCd;
	}
	public void setProjectCd(String projectCd) {
		this.projectCd = projectCd;
	}
	public BigDecimal getProjectValue() {
		return projectValue;
	}
	public void setProjectValue(BigDecimal projectValue) {
		this.projectValue = projectValue;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public BigDecimal getPreTotalValue() {
		return preTotalValue;
	}
	public void setPreTotalValue(BigDecimal preTotalValue) {
		this.preTotalValue = preTotalValue;
	}
	public String getPreTotalFlag() {
		return preTotalFlag;
	}
	public void setPreTotalFlag(String preTotalFlag) {
		this.preTotalFlag = preTotalFlag;
	}
	
}
