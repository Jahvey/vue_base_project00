package com.cdgit.loan.irm.bean;

import java.math.BigDecimal;

public class TbIrmAdjustOptions {
	private String adjustOptionId;//调整选项ID
	private String adjustValue;//调整项选择
	private String adjustDescribe;//调整项说明
	private String iraApplyId;//评级申请ID
	private String isAdjust;//是否调整
	private String adjOptId;//对应调整选项ID
	private BigDecimal adjustOrder;//调整顺序
	public String getAdjustOptionId() {
		return adjustOptionId;
	}
	public void setAdjustOptionId(String adjustOptionId) {
		this.adjustOptionId = adjustOptionId;
	}
	public String getAdjustValue() {
		return adjustValue;
	}
	public void setAdjustValue(String adjustValue) {
		this.adjustValue = adjustValue;
	}
	public String getAdjustDescribe() {
		return adjustDescribe;
	}
	public void setAdjustDescribe(String adjustDescribe) {
		this.adjustDescribe = adjustDescribe;
	}
	public String getIraApplyId() {
		return iraApplyId;
	}
	public void setIraApplyId(String iraApplyId) {
		this.iraApplyId = iraApplyId;
	}
	public String getIsAdjust() {
		return isAdjust;
	}
	public void setIsAdjust(String isAdjust) {
		this.isAdjust = isAdjust;
	}
	public String getAdjOptId() {
		return adjOptId;
	}
	public void setAdjOptId(String adjOptId) {
		this.adjOptId = adjOptId;
	}
	public BigDecimal getAdjustOrder() {
		return adjustOrder;
	}
	public void setAdjustOrder(BigDecimal adjustOrder) {
		this.adjustOrder = adjustOrder;
	}
	
	
}
