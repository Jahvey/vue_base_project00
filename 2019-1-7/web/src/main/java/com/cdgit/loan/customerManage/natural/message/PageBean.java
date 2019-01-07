package com.cdgit.loan.customerManage.natural.message;

import java.util.List;

public class PageBean {

	//当前页
    private long total;
    //当前页记录
    private List data;
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
}
