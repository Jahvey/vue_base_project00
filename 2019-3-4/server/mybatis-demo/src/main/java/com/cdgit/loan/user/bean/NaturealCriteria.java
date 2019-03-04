package com.cdgit.loan.user.bean;

import com.cdgit.loan.user.common.BaseCriteria;

public class NaturealCriteria extends BaseCriteria{

	private String partyName;
    private String certType;
    private String certNum;
    private String middelCode;
    private String curUserNum;
    private String orgcode;
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
	public String getCurUserNum() {
		return curUserNum;
	}
	public void setCurUserNum(String curUserNum) {
		this.curUserNum = curUserNum;
	}
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	} 
}
