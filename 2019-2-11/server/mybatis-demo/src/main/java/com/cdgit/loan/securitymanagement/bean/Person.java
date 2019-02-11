package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Person {
	@JSONField(ordinal = 3,format = "yyyy-MM-dd")
	private Date birthday;
	@JSONField(name="性别",ordinal = 1)
	private String sex;
	@JSONField(name="身高",ordinal = 2)
	private BigDecimal height;
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
}
