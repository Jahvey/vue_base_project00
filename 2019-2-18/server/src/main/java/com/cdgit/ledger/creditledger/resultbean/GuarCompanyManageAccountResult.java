package com.cdgit.ledger.creditledger.resultbean;
/**担保公司业务管理台账查询结果集*/
public class GuarCompanyManageAccountResult {
	private String partyName;//客户名称
	private String creditAmount;//授信总额
	private String simpleAmount;//单户总额
	private String avalibleamt;//可用余额
	private String creditStatus;//合作状态
	private String beginDate;//额度起始日
	private String endDate;//额度到期日
	private String accnoWay;//保证金存储方式
	private String creditType;//性质
	private String creditApport;//责任分担比例
	private String innerCret;//内部评级
	private String userNum;//经办人
	private String orgNum;//经办机构
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}
	public String getSimpleAmount() {
		return simpleAmount;
	}
	public void setSimpleAmount(String simpleAmount) {
		this.simpleAmount = simpleAmount;
	}
	public String getAvalibleamt() {
		return avalibleamt;
	}
	public void setAvalibleamt(String avalibleamt) {
		this.avalibleamt = avalibleamt;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
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
	public String getAccnoWay() {
		return accnoWay;
	}
	public void setAccnoWay(String accnoWay) {
		this.accnoWay = accnoWay;
	}
	public String getCreditType() {
		return creditType;
	}
	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}
	public String getCreditApport() {
		return creditApport;
	}
	public void setCreditApport(String creditApport) {
		this.creditApport = creditApport;
	}
	public String getInnerCret() {
		return innerCret;
	}
	public void setInnerCret(String innerCret) {
		this.innerCret = innerCret;
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
