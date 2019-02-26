package com.cdgit.loan.user.bean;

import com.cdgit.loan.user.common.BaseCriteria;

public class UserInfoCriteria extends BaseCriteria{

	private String userName;
	private String customerNum;
	private String state;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
