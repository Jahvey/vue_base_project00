package com.cdgit.loan.common.bean;

import java.util.List;

public class ProcessVO {

	private String procDefId;
	private String procDefNodeId;
	private String processKey;
	private String userNo;
	private List variables;//业务变量 放到数组里面
	private String beAgentPersonNo;
	private String nextTaskDefKey;
	private String nodeType;
	private String agentPersonNo;
	private String createUserNo;
	private String procInstId;
	private String taskId;
	private String comment;
	public String getProcDefId() {
		return procDefId;
	}
	public void setProcDefId(String procDefId) {
		this.procDefId = procDefId;
	}
	public String getProcDefNodeId() {
		return procDefNodeId;
	}
	public void setProcDefNodeId(String procDefNodeId) {
		this.procDefNodeId = procDefNodeId;
	}
	public String getProcessKey() {
		return processKey;
	}
	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public List getVariables() {
		return variables;
	}
	public void setVariables(List variables) {
		this.variables = variables;
	}
	public String getBeAgentPersonNo() {
		return beAgentPersonNo;
	}
	public void setBeAgentPersonNo(String beAgentPersonNo) {
		this.beAgentPersonNo = beAgentPersonNo;
	}
	public String getNextTaskDefKey() {
		return nextTaskDefKey;
	}
	public void setNextTaskDefKey(String nextTaskDefKey) {
		this.nextTaskDefKey = nextTaskDefKey;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getAgentPersonNo() {
		return agentPersonNo;
	}
	public void setAgentPersonNo(String agentPersonNo) {
		this.agentPersonNo = agentPersonNo;
	}
	public String getCreateUserNo() {
		return createUserNo;
	}
	public void setCreateUserNo(String createUserNo) {
		this.createUserNo = createUserNo;
	}
	public String getProcInstId() {
		return procInstId;
	}
	public void setProcInstId(String procInstId) {
		this.procInstId = procInstId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
