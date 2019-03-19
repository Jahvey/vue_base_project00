package com.cdgit.loan.irm.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbIrmRatingEngineCalc {

	private String recId;//评级引擎计算ID
	private String iraApplyId;
	private BigDecimal financeModelWeight;//财务模型权重
	private BigDecimal financeModelScore;//财务模型总得分
	private BigDecimal nonFinanceModelWeigh;//非财务模型权重
	private BigDecimal ratingTatalScore;//评级总得分
	private String initialRatingCd;//初始信用等级
	private String governmentAdjustRatingCd;//政府融资平台调整后等级
	private String generalAdjustRatingCd;//一般调整后信用等级
	private Date executionDate;//执行时间
	private Date completeDate;//结束时间
	private BigDecimal nonFinanceModelScore;//非财务模型总得分
	private BigDecimal governmentAdjustScore;//政府融资平台得分
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
	public String getIraApplyId() {
		return iraApplyId;
	}
	public void setIraApplyId(String iraApplyId) {
		this.iraApplyId = iraApplyId;
	}
	public BigDecimal getFinanceModelWeight() {
		return financeModelWeight;
	}
	public void setFinanceModelWeight(BigDecimal financeModelWeight) {
		this.financeModelWeight = financeModelWeight;
	}
	public BigDecimal getFinanceModelScore() {
		return financeModelScore;
	}
	public void setFinanceModelScore(BigDecimal financeModelScore) {
		this.financeModelScore = financeModelScore;
	}
	public BigDecimal getNonFinanceModelWeigh() {
		return nonFinanceModelWeigh;
	}
	public void setNonFinanceModelWeigh(BigDecimal nonFinanceModelWeigh) {
		this.nonFinanceModelWeigh = nonFinanceModelWeigh;
	}
	public BigDecimal getRatingTatalScore() {
		return ratingTatalScore;
	}
	public void setRatingTatalScore(BigDecimal ratingTatalScore) {
		this.ratingTatalScore = ratingTatalScore;
	}
	public String getInitialRatingCd() {
		return initialRatingCd;
	}
	public void setInitialRatingCd(String initialRatingCd) {
		this.initialRatingCd = initialRatingCd;
	}
	public String getGovernmentAdjustRatingCd() {
		return governmentAdjustRatingCd;
	}
	public void setGovernmentAdjustRatingCd(String governmentAdjustRatingCd) {
		this.governmentAdjustRatingCd = governmentAdjustRatingCd;
	}
	public String getGeneralAdjustRatingCd() {
		return generalAdjustRatingCd;
	}
	public void setGeneralAdjustRatingCd(String generalAdjustRatingCd) {
		this.generalAdjustRatingCd = generalAdjustRatingCd;
	}
	public Date getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}
	public Date getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}
	public BigDecimal getNonFinanceModelScore() {
		return nonFinanceModelScore;
	}
	public void setNonFinanceModelScore(BigDecimal nonFinanceModelScore) {
		this.nonFinanceModelScore = nonFinanceModelScore;
	}
	public BigDecimal getGovernmentAdjustScore() {
		return governmentAdjustScore;
	}
	public void setGovernmentAdjustScore(BigDecimal governmentAdjustScore) {
		this.governmentAdjustScore = governmentAdjustScore;
	}
	
}
