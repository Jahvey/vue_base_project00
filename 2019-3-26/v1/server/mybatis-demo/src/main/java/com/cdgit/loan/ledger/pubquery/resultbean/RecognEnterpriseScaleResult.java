package com.cdgit.loan.ledger.pubquery.resultbean;
/**企业规模认定结果集*/
public class RecognEnterpriseScaleResult {
	private String partyName;
	private String orgNum;
	private String userNum;
	private String certType;
	private String certNum;
	private String createDate;
	private String oldScaleCode;//原企业规模
	private String scaleCode;//现企业规模
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getOldScaleCode() {
		return oldScaleCode;
	}
	public void setOldScaleCode(String oldScaleCode) {
		this.oldScaleCode = oldScaleCode;
	}
	public String getScaleCode() {
		return scaleCode;
	}
	public void setScaleCode(String scaleCode) {
		this.scaleCode = scaleCode;
	}
	
}
