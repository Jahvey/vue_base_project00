package com.cdgit.loan.irm.bean;

public class AddFinanceinfoCriteria {

	private Item item;
	private String isImport;
	private String modelTypeCd;
	
	public class Item{
		private String applyId;
		private String reportId;
		
		public String getApplyId() {
			return applyId;
		}
		public void setApplyId(String applyId) {
			this.applyId = applyId;
		}
		public String getReportId() {
			return reportId;
		}
		public void setReportId(String reportId) {
			this.reportId = reportId;
		}
		
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getIsImport() {
		return isImport;
	}

	public void setIsImport(String isImport) {
		this.isImport = isImport;
	}

	public String getModelTypeCd() {
		return modelTypeCd;
	}

	public void setModelTypeCd(String modelTypeCd) {
		this.modelTypeCd = modelTypeCd;
	}
	
	
}
