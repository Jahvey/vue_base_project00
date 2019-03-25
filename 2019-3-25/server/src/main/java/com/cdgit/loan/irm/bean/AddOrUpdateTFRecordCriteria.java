package com.cdgit.loan.irm.bean;

public class AddOrUpdateTFRecordCriteria {
	private String tfYN;//是否推翻
	private String userName;//经办人
	private String rateResult;//推翻后评级结果
	private String userOrgName;//经办机构
	private String overThrowReason;//推翻原因
	private String avagPd2;//违约概率（PD2）
	private String applyId;
	private String state;
	private String overFlg;
	private String partyId;
	private int num;//相对机评上调级数
	private int rateResSe;//推翻后评级结果
	private String flowType;//　　01：新增流程  02：更新流程（重检） 03：在审核
	private String isReAud;//再审核 1：是  2：否	
	private String processInstId;//实例号
	private String posicode;//流程岗位信息
	private String flgDisplay;//当前岗位
	public String getTfYN() {
		return tfYN;
	}
	public void setTfYN(String tfYN) {
		this.tfYN = tfYN;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRateResult() {
		return rateResult;
	}
	public void setRateResult(String rateResult) {
		this.rateResult = rateResult;
	}
	public String getUserOrgName() {
		return userOrgName;
	}
	public void setUserOrgName(String userOrgName) {
		this.userOrgName = userOrgName;
	}
	public String getOverThrowReason() {
		return overThrowReason;
	}
	public void setOverThrowReason(String overThrowReason) {
		this.overThrowReason = overThrowReason;
	}
	public String getAvagPd2() {
		return avagPd2;
	}
	public void setAvagPd2(String avagPd2) {
		this.avagPd2 = avagPd2;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOverFlg() {
		return overFlg;
	}
	public void setOverFlg(String overFlg) {
		this.overFlg = overFlg;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getRateResSe() {
		return rateResSe;
	}
	public void setRateResSe(int rateResSe) {
		this.rateResSe = rateResSe;
	}
	public String getFlowType() {
		return flowType;
	}
	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
	public String getIsReAud() {
		return isReAud;
	}
	public void setIsReAud(String isReAud) {
		this.isReAud = isReAud;
	}
	public String getProcessInstId() {
		return processInstId;
	}
	public void setProcessInstId(String processInstId) {
		this.processInstId = processInstId;
	}
	public String getPosicode() {
		return posicode;
	}
	public void setPosicode(String posicode) {
		this.posicode = posicode;
	}
	public String getFlgDisplay() {
		return flgDisplay;
	}
	public void setFlgDisplay(String flgDisplay) {
		this.flgDisplay = flgDisplay;
	}
	
	
}
