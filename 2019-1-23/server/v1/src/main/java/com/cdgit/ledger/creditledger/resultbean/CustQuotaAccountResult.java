package com.cdgit.ledger.creditledger.resultbean;
/**额度台账查询结果集*/
public class CustQuotaAccountResult {
	private String orgNum;//机构
	private String partyName;//客户名称
	private String currencyCd;//币种
	private String creditAmt;//额度金额
	private String availableAmt;//额度余额
	private String startDate;//起始日
	private String endDate;//到期日
	private String userNum;//经办人
	private String certType;//证件类型
	private String certNum;//证件号码
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
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	public String getCreditAmt() {
		return creditAmt;
	}
	public void setCreditAmt(String creditAmt) {
		this.creditAmt = creditAmt;
	}
	public String getAvailableAmt() {
		return availableAmt;
	}
	public void setAvailableAmt(String availableAmt) {
		this.availableAmt = availableAmt;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
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
	
}
