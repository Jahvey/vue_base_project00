package com.cdgit.loan.irm.bean;

import java.math.BigDecimal;

public class TbIrmModelScale {

	private String modelId;
	private String creditRatingCd;
	private BigDecimal minValue;
	private BigDecimal maxValue;
	private String modelScaleId;
	private String creditRatingDisplay;
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public String getCreditRatingCd() {
		return creditRatingCd;
	}
	public void setCreditRatingCd(String creditRatingCd) {
		this.creditRatingCd = creditRatingCd;
	}
	public BigDecimal getMinValue() {
		return minValue;
	}
	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}
	public BigDecimal getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}
	public String getModelScaleId() {
		return modelScaleId;
	}
	public void setModelScaleId(String modelScaleId) {
		this.modelScaleId = modelScaleId;
	}
	public String getCreditRatingDisplay() {
		return creditRatingDisplay;
	}
	public void setCreditRatingDisplay(String creditRatingDisplay) {
		this.creditRatingDisplay = creditRatingDisplay;
	}
	
}
