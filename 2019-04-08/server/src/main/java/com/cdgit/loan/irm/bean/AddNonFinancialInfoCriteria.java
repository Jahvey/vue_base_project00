package com.cdgit.loan.irm.bean;

import java.util.List;

public class AddNonFinancialInfoCriteria {

	private String applyId;
	private String flagDb;
	private List<NonFinanceInfoBean> inRows;
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getFlagDb() {
		return flagDb;
	}
	public void setFlagDb(String flagDb) {
		this.flagDb = flagDb;
	}
	public List<NonFinanceInfoBean> getInRows() {
		return inRows;
	}
	public void setInRows(List<NonFinanceInfoBean> inRows) {
		this.inRows = inRows;
	}
	
	
}

