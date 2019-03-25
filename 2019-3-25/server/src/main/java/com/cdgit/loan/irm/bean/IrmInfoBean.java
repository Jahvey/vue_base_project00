package com.cdgit.loan.irm.bean;

public class IrmInfoBean {

	private String iraApplyId;//评级信息唯一编号
	
	private String partyName;//客户名称
	
	private String ratingDt;//评级日期
	
	private String ratingType;//评级类型
	
	private String creditRatingCd;//信用等级
	
	private String effectiveStartDt;//起始日期
	
	private String effectiveEndDt;//到期日期
	
	private String ratingState;//是否有效评级
	
	private String userNum;//经办人
	
	private String orgNum;//经办机构

	public String getIraApplyId() {
		return iraApplyId;
	}

	public void setIraApplyId(String iraApplyId) {
		this.iraApplyId = iraApplyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getRatingDt() {
		return ratingDt;
	}

	public void setRatingDt(String ratingDt) {
		this.ratingDt = ratingDt;
	}

	public String getRatingType() {
		return ratingType;
	}

	public void setRatingType(String ratingType) {
		this.ratingType = ratingType;
	}

	public String getCreditRatingCd() {
		return creditRatingCd;
	}

	public void setCreditRatingCd(String creditRatingCd) {
		this.creditRatingCd = creditRatingCd;
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

	public String getRatingState() {
		return ratingState;
	}

	public void setRatingState(String ratingState) {
		this.ratingState = ratingState;
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
	
	
	
}
