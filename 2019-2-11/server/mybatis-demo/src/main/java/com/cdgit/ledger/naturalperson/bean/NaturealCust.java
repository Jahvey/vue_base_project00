package com.cdgit.ledger.naturalperson.bean;

public class NaturealCust {
	private String partyId;    //客户ID
    private String partyName;  //客户名称
    private String certType;   //证件类型
    private String certNum;	   //证件号码
    private String middelCode; //中征码
    private String orgNum;     //机构号
    private String isFarmer;   //是否农户
    private String userNum;    //客户经理
    private String generalAdjustRatingCd; //信用等级
	
    public String getGeneralAdjustRatingCd() {
		return generalAdjustRatingCd;
	}
	public void setGeneralAdjustRatingCd(String generalAdjustRatingCd) {
		this.generalAdjustRatingCd = generalAdjustRatingCd;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
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
	public String getMiddelCode() {
		return middelCode;
	}
	public void setMiddelCode(String middelCode) {
		this.middelCode = middelCode;
	}
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getIsFarmer() {
		return isFarmer;
	}
	public void setIsFarmer(String isFarmer) {
		this.isFarmer = isFarmer;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	
    

}
