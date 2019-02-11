package com.cdgit.ledger.pubquery.resultbean;
/**流程查询结果集**/
public class TechProcessResult {
	private String processId;//流程编号
	private String cusName;//客户名称
	private String createOrgNum;//发起机构编号
	private String createOrgName;//发起机构名称
	private String createUserNum;//发起人编号
	private String createUserName;//发起人名称
	private String createTime;//创建时间
	private String lastUpdateTime;//最新更新时间
	private String processStatus;//流程状态
	private String operation;//操作
	private String bizType;//业务类型
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCreateOrgNum() {
		return createOrgNum;
	}
	public void setCreateOrgNum(String createOrgNum) {
		this.createOrgNum = createOrgNum;
	}
	public String getCreateUserNum() {
		return createUserNum;
	}
	public void setCreateUserNum(String createUserNum) {
		this.createUserNum = createUserNum;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getCreateOrgName() {
		return createOrgName;
	}
	public void setCreateOrgName(String createOrgName) {
		this.createOrgName = createOrgName;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	
	
}
