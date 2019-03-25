package com.cdgit.loan.irm.bean;

public class TbIrmFinancialInfo {

	private String financialInfoId;//财务信息ID
	private String reportId;//引用财务报表ID
	private String iraApplyId;//评级申请ID
	private String remark;//备注说明（选择财报原因）
	public String getFinancialInfoId() {
		return financialInfoId;
	}
	public void setFinancialInfoId(String financialInfoId) {
		this.financialInfoId = financialInfoId;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getIraApplyId() {
		return iraApplyId;
	}
	public void setIraApplyId(String iraApplyId) {
		this.iraApplyId = iraApplyId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
