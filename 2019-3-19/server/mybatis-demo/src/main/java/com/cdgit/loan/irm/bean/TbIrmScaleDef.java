package com.cdgit.loan.irm.bean;

import java.math.BigDecimal;

public class TbIrmScaleDef {

	private String scaleDefId;
	private String creditRatingCd;
	private String creditRatingDef;
	private BigDecimal minPd;
	private BigDecimal maxPd;
	private BigDecimal avagPd;
	private String creditRatingDisplay;
	private String smallLtdDisplay;
	private String orderNo;
	private String isProfessionalLoan;
	public String getScaleDefId() {
		return scaleDefId;
	}
	public void setScaleDefId(String scaleDefId) {
		this.scaleDefId = scaleDefId;
	}
	public String getCreditRatingCd() {
		return creditRatingCd;
	}
	public void setCreditRatingCd(String creditRatingCd) {
		this.creditRatingCd = creditRatingCd;
	}
	public String getCreditRatingDef() {
		return creditRatingDef;
	}
	public void setCreditRatingDef(String creditRatingDef) {
		this.creditRatingDef = creditRatingDef;
	}
	public BigDecimal getMinPd() {
		return minPd;
	}
	public void setMinPd(BigDecimal minPd) {
		this.minPd = minPd;
	}
	public BigDecimal getMaxPd() {
		return maxPd;
	}
	public void setMaxPd(BigDecimal maxPd) {
		this.maxPd = maxPd;
	}
	public BigDecimal getAvagPd() {
		return avagPd;
	}
	public void setAvagPd(BigDecimal avagPd) {
		this.avagPd = avagPd;
	}
	public String getCreditRatingDisplay() {
		return creditRatingDisplay;
	}
	public void setCreditRatingDisplay(String creditRatingDisplay) {
		this.creditRatingDisplay = creditRatingDisplay;
	}
	public String getSmallLtdDisplay() {
		return smallLtdDisplay;
	}
	public void setSmallLtdDisplay(String smallLtdDisplay) {
		this.smallLtdDisplay = smallLtdDisplay;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getIsProfessionalLoan() {
		return isProfessionalLoan;
	}
	public void setIsProfessionalLoan(String isProfessionalLoan) {
		this.isProfessionalLoan = isProfessionalLoan;
	}
	
	
}
