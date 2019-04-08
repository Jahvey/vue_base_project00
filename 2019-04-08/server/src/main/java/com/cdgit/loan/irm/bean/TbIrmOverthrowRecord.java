package com.cdgit.loan.irm.bean;

import java.util.Date;

public class TbIrmOverthrowRecord {

	private String orId;//推翻记录ID
	private String userNum;//经办用户
	private String overthrowReason;//推翻原因
	private String beforeGrade;//推翻前等级
	private String afterGrade;//推翻后等级
	private String iraApplyId;//评级申请ID
	private String isOverthrow;//是否推翻
	private String orgNum;//经办机构
	private Date overthrowDt;//推翻日期
	private String postCd;//经办人岗位
	public String getOrId() {
		return orId;
	}
	public void setOrId(String orId) {
		this.orId = orId;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getOverthrowReason() {
		return overthrowReason;
	}
	public void setOverthrowReason(String overthrowReason) {
		this.overthrowReason = overthrowReason;
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
	public String getIraApplyId() {
		return iraApplyId;
	}
	public void setIraApplyId(String iraApplyId) {
		this.iraApplyId = iraApplyId;
	}
	public String getIsOverthrow() {
		return isOverthrow;
	}
	public void setIsOverthrow(String isOverthrow) {
		this.isOverthrow = isOverthrow;
	}
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public Date getOverthrowDt() {
		return overthrowDt;
	}
	public void setOverthrowDt(Date overthrowDt) {
		this.overthrowDt = overthrowDt;
	}
	public String getPostCd() {
		return postCd;
	}
	public void setPostCd(String postCd) {
		this.postCd = postCd;
	}
	
	
}
