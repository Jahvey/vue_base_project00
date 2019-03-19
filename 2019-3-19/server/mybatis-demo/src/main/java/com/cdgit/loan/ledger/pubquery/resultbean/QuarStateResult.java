package com.cdgit.loan.ledger.pubquery.resultbean;
/**对帐单信息查询*/
public class QuarStateResult {
	private String partyName;//客户名称
	private String contractNum;//合同编号
	private String summaryNum;//借据编号
	private String beginDate;//开始日期
	private String endDate;//结束日期
	private String summaryAmt;//借据金额
	private String jjye;//借据余额
	private String userNum;//经办用户
	private String orgNum;//机构名称
	private String ifAccount;//是否对账
	private String tsDate;//季度日期
	private String loanId;//
	private String ifPrint;//是否打印
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getContractNum() {
		return contractNum;
	}
	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}
	public String getSummaryNum() {
		return summaryNum;
	}
	public void setSummaryNum(String summaryNum) {
		this.summaryNum = summaryNum;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getSummaryAmt() {
		return summaryAmt;
	}
	public void setSummaryAmt(String summaryAmt) {
		this.summaryAmt = summaryAmt;
	}
	public String getJjye() {
		return jjye;
	}
	public void setJjye(String jjye) {
		this.jjye = jjye;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getIfAccount() {
		return ifAccount;
	}
	public void setIfAccount(String ifAccount) {
		this.ifAccount = ifAccount;
	}
	public String getTsDate() {
		return tsDate;
	}
	public void setTsDate(String tsDate) {
		this.tsDate = tsDate;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public String getIfPrint() {
		return ifPrint;
	}
	public void setIfPrint(String ifPrint) {
		this.ifPrint = ifPrint;
	}
		
	
}
