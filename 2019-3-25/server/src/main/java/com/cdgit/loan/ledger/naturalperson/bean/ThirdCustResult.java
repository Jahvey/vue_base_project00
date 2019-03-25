package com.cdgit.loan.ledger.naturalperson.bean;
/**封装中介客户查询结果集*/
public class ThirdCustResult {
	private String orgNum;//机构名称	
	private String partyName;//客户名称
	private String unifySocietyCreditNum;//统一社会信用代码
	private String registrCd;//营业执照
	private String orgRegisterCd;//组织机构代码
	private String middelCode;//中征码
	private String corpCustomerTypeCd;//合作中介类型
	private String creditTypeCd;//信用等级
	private String userNum;//管户经理
	private String partyId;
	private String ratingState;
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getRatingState() {
		return ratingState;
	}
	public void setRatingState(String ratingState) {
		this.ratingState = ratingState;
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
	public String getUnifySocietyCreditNum() {
		return unifySocietyCreditNum;
	}
	public void setUnifySocietyCreditNum(String unifySocietyCreditNum) {
		this.unifySocietyCreditNum = unifySocietyCreditNum;
	}
	public String getRegistrCd() {
		return registrCd;
	}
	public void setRegistrCd(String registrCd) {
		this.registrCd = registrCd;
	}
	public String getOrgRegisterCd() {
		return orgRegisterCd;
	}
	public void setOrgRegisterCd(String orgRegisterCd) {
		this.orgRegisterCd = orgRegisterCd;
	}
	public String getMiddelCode() {
		return middelCode;
	}
	public void setMiddelCode(String middelCode) {
		this.middelCode = middelCode;
	}
	public String getCorpCustomerTypeCd() {
		return corpCustomerTypeCd;
	}
	public void setCorpCustomerTypeCd(String corpCustomerTypeCd) {
		this.corpCustomerTypeCd = corpCustomerTypeCd;
	}
	public String getCreditTypeCd() {
		return creditTypeCd;
	}
	public void setCreditTypeCd(String creditTypeCd) {
		this.creditTypeCd = creditTypeCd;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
}
