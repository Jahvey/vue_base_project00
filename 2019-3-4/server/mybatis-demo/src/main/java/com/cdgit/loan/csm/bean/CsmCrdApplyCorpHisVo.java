/**
 * 
 */
package com.cdgit.loan.csm.bean;

/**
 * @author cwalk
 *
 */
//查询对公、自然人、同业额度历史列表
public class CsmCrdApplyCorpHisVo {
	
	private String partyId;
	
	private String limitId;
	
	private String limitType;
	
	private String creditAmt;
	
	private String usedAmt;
	
	private String usedAmtReal;
	
	private String availableAmt;
	
	private String availableAmtReal;
	
	private String partyName;
	
	private String certType;
	
	private String certNum;
	
	private String userNum;
	
	private String orgNum;
	
	private String beginDate;
	
	private String endDate;

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getLimitId() {
		return limitId;
	}

	public void setLimitId(String limitId) {
		this.limitId = limitId;
	}

	public String getLimitType() {
		return limitType;
	}

	public void setLimitType(String limitType) {
		this.limitType = limitType;
	}

	public String getCreditAmt() {
		return creditAmt;
	}

	public void setCreditAmt(String creditAmt) {
		this.creditAmt = creditAmt;
	}

	public String getUsedAmt() {
		return usedAmt;
	}

	public void setUsedAmt(String usedAmt) {
		this.usedAmt = usedAmt;
	}

	public String getUsedAmtReal() {
		return usedAmtReal;
	}

	public void setUsedAmtReal(String usedAmtReal) {
		this.usedAmtReal = usedAmtReal;
	}

	public String getAvailableAmt() {
		return availableAmt;
	}

	public void setAvailableAmt(String availableAmt) {
		this.availableAmt = availableAmt;
	}

	public String getAvailableAmtReal() {
		return availableAmtReal;
	}

	public void setAvailableAmtReal(String availableAmtReal) {
		this.availableAmtReal = availableAmtReal;
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
	
	
}
