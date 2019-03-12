package com.cdgit.loan.ledger.pubquery.resultbean;
/**客户评级信息结果集*/
public class CustRateInfoResult {
	private String orgname;
	private String partyName;
	private String certType;
	private String certNum;
	private String effectiveStartDt;
	private String effectiveEndDt;
	private String iraApplyId;
	private String generalAdjustRatingCd;
	private String operatorname;
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
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
	public String getEffectiveStartDt() {
		return effectiveStartDt;
	}
	public void setEffectiveStartDt(String effectiveStartDt) {
		this.effectiveStartDt = effectiveStartDt;
	}
	public String getEffectiveEndDt() {
		return effectiveEndDt;
	}
	public void setEffectiveEndDt(String effectiveEndDt) {
		this.effectiveEndDt = effectiveEndDt;
	}
	public String getIraApplyId() {
		return iraApplyId;
	}
	public void setIraApplyId(String iraApplyId) {
		this.iraApplyId = iraApplyId;
	}
	public String getGeneralAdjustRatingCd() {
		return generalAdjustRatingCd;
	}
	public void setGeneralAdjustRatingCd(String generalAdjustRatingCd) {
		this.generalAdjustRatingCd = generalAdjustRatingCd;
	}
	public String getOperatorname() {
		return operatorname;
	}
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	
}
