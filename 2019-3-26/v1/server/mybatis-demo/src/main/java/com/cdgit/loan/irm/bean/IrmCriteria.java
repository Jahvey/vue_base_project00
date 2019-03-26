package com.cdgit.loan.irm.bean;

public class IrmCriteria {

	private String partyId;//客户号
	
	private String thirdPartyTypeCd;//第三方客户类型
	
	private String userNum;//经办人
	
	private String orgNum;//经办机构

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
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

	public String getThirdPartyTypeCd() {
		return thirdPartyTypeCd;
	}

	public void setThirdPartyTypeCd(String thirdPartyTypeCd) {
		this.thirdPartyTypeCd = thirdPartyTypeCd;
	}
	
	
}
