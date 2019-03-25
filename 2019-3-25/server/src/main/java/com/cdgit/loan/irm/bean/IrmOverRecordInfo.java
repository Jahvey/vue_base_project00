package com.cdgit.loan.irm.bean;

import java.util.Date;

public class IrmOverRecordInfo {
	private String orId;
	private String iraApplyId;
	private String userNum;
	private String orgNum;
	private String beforeGrade;
	private String afterGrade;
	private String postCd;
	public String getOrId() {
		return orId;
	}
	public void setOrId(String orId) {
		this.orId = orId;
	}
	public String getBeforeGrade() {
		return beforeGrade;
	}
	public void setBeforeGrade(String beforeGrade) {
		this.beforeGrade = beforeGrade;
	}
	public String getAfterGrade() {
		return afterGrade;
	}
	public void setAfterGrade(String afterGrade) {
		this.afterGrade = afterGrade;
	}
	private String overthrowReason;
	private Date overthrowDt;
	private String smallLtdDisplay;
	public String getIraApplyId() {
		return iraApplyId;
	}
	public void setIraApplyId(String iraApplyId) {
		this.iraApplyId = iraApplyId;
	}
	public String getSmallLtdDisplay() {
		return smallLtdDisplay;
	}
	public void setSmallLtdDisplay(String smallLtdDisplay) {
		this.smallLtdDisplay = smallLtdDisplay;
	}
	private String creditRatingDisplay;
	private String avagPD;
	private String isOverthrow;
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getCreditRatingDisplay() {
		return creditRatingDisplay;
	}
	public void setCreditRatingDisplay(String creditRatingDisplay) {
		this.creditRatingDisplay = creditRatingDisplay;
	}
	public String getOverthrowReason() {
		return overthrowReason;
	}
	public void setOverthrowReason(String overthrowReason) {
		this.overthrowReason = overthrowReason;
	}
	public String getAvagPD() {
		return avagPD;
	}
	public void setAvagPD(String avagPD) {
		this.avagPD = avagPD;
	}
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getIsOverthrow() {
		return isOverthrow;
	}
	public void setIsOverthrow(String isOverthrow) {
		this.isOverthrow = isOverthrow;
	}
	public String getPostCd() {
		return postCd;
	}
	public void setPostCd(String postCd) {
		this.postCd = postCd;
	}
	public Date getOverthrowDt() {
		return overthrowDt;
	}
	public void setOverthrowDt(Date overthrowDt) {
		this.overthrowDt = overthrowDt;
	}
	
	
}
