package com.cdgit.loan.afterloan.riskclass.resultbean;
/**风险分类-季度调整结果集*/
public class QuarSmallNaturalResult {
	private String partyName;
	private String certType;
	private String certNum;
	private String totalCredAmt;
	private String sortResult;
	private String sortStatus;
	private String custtype;
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertNum() {
		return certNum;
	}
	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}
	public String getTotalCredAmt() {
		return totalCredAmt;
	}
	public void setTotalCredAmt(String totalCredAmt) {
		this.totalCredAmt = totalCredAmt;
	}
	public String getSortResult() {
		return sortResult;
	}
	public void setSortResult(String sortResult) {
		this.sortResult = sortResult;
	}
	public String getSortStatus() {
		return sortStatus;
	}
	public void setSortStatus(String sortStatus) {
		this.sortStatus = sortStatus;
	}
	public String getCusttype() {
		return custtype;
	}
	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}

}
