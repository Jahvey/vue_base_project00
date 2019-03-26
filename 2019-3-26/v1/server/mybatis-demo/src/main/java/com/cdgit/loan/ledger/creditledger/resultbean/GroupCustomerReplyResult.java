package com.cdgit.loan.ledger.creditledger.resultbean;
/**封装集团客户批复查询结果集*/
public class GroupCustomerReplyResult {
	private String orgNum; //机构名称
	private String partyName;//客户姓名
	private String approvalNum;//批复编号
	private String bizType;//业务性质
	private String currencyCd;//币种
	private String creditAvi;//可用余额
	private String creditAmount;//批复金额
	private String creditUsed;//已用金额
	private String validDate;//起始日
	private String endDate;//到期日
	private String userNum;//经办用户
	private String certType;//证件类型
	private String certNum;//证件号
	private String firstResponseName;//第一责任人
	public String getFirstResponseName() {
		return firstResponseName;
	}
	public void setFirstResponseName(String firstResponseName) {
		this.firstResponseName = firstResponseName;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getApprovalNum() {
		return approvalNum;
	}
	public void setApprovalNum(String approvalNum) {
		this.approvalNum = approvalNum;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	public String getCreditAvi() {
		return creditAvi;
	}
	public void setCreditAvi(String creditAvi) {
		this.creditAvi = creditAvi;
	}
	public String getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}
	public String getCreditUsed() {
		return creditUsed;
	}
	public void setCreditUsed(String creditUsed) {
		this.creditUsed = creditUsed;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
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
	
	
}
