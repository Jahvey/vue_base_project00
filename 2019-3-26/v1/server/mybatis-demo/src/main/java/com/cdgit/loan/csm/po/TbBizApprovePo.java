package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class TbBizApprovePo {
    private String approveId;

    private String bizNum;

    private String bizType;

    private String lowRiskBizType;

    private String applyModeType;

    private String bizHappenType;

    private String orgNum;

    private String userNum;

    private String partyId;

    private String businessProduct;

    private String productType;

    private Date applyDate;

    private Date handingDate;

    private String amountType;

    private Date createTime;

    private Date updateTime;

    private String csmCrdLevel;

    private String approvalNum;

    private String becomeEffectiveMark;

    private String originalApproveId;

    private String isBankTeamLoan;

    private Integer loanInspectionFre;

    private String policyDecisionIdea;

    private Date validDate;

    private String policyDecisionNum;

    private String applyTypeMark;

    private String approveConclusion;

    private String endOrgNum;

    private Date endDate;

    private String ifDataMove;

    private String applyId;

    private String bizHappenNature;

    private String isGreenLoan;

    private String loanType;

    private String bizTypeFlag;

    private String guarantyType;

    private Integer termNum;

    private String termUnit;

    private BigDecimal rmbAmt;

    private BigDecimal boUse;

    private BigDecimal noUse;

    private String crdId;

    private String creditMode;

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId == null ? null : approveId.trim();
    }

    public String getBizNum() {
        return bizNum;
    }

    public void setBizNum(String bizNum) {
        this.bizNum = bizNum == null ? null : bizNum.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getLowRiskBizType() {
        return lowRiskBizType;
    }

    public void setLowRiskBizType(String lowRiskBizType) {
        this.lowRiskBizType = lowRiskBizType == null ? null : lowRiskBizType.trim();
    }

    public String getApplyModeType() {
        return applyModeType;
    }

    public void setApplyModeType(String applyModeType) {
        this.applyModeType = applyModeType == null ? null : applyModeType.trim();
    }

    public String getBizHappenType() {
        return bizHappenType;
    }

    public void setBizHappenType(String bizHappenType) {
        this.bizHappenType = bizHappenType == null ? null : bizHappenType.trim();
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getBusinessProduct() {
        return businessProduct;
    }

    public void setBusinessProduct(String businessProduct) {
        this.businessProduct = businessProduct == null ? null : businessProduct.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getHandingDate() {
        return handingDate;
    }

    public void setHandingDate(Date handingDate) {
        this.handingDate = handingDate;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType == null ? null : amountType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCsmCrdLevel() {
        return csmCrdLevel;
    }

    public void setCsmCrdLevel(String csmCrdLevel) {
        this.csmCrdLevel = csmCrdLevel == null ? null : csmCrdLevel.trim();
    }

    public String getApprovalNum() {
        return approvalNum;
    }

    public void setApprovalNum(String approvalNum) {
        this.approvalNum = approvalNum == null ? null : approvalNum.trim();
    }

    public String getBecomeEffectiveMark() {
        return becomeEffectiveMark;
    }

    public void setBecomeEffectiveMark(String becomeEffectiveMark) {
        this.becomeEffectiveMark = becomeEffectiveMark == null ? null : becomeEffectiveMark.trim();
    }

    public String getOriginalApproveId() {
        return originalApproveId;
    }

    public void setOriginalApproveId(String originalApproveId) {
        this.originalApproveId = originalApproveId == null ? null : originalApproveId.trim();
    }

    public String getIsBankTeamLoan() {
        return isBankTeamLoan;
    }

    public void setIsBankTeamLoan(String isBankTeamLoan) {
        this.isBankTeamLoan = isBankTeamLoan == null ? null : isBankTeamLoan.trim();
    }

    public Integer getLoanInspectionFre() {
        return loanInspectionFre;
    }

    public void setLoanInspectionFre(Integer loanInspectionFre) {
        this.loanInspectionFre = loanInspectionFre;
    }

    public String getPolicyDecisionIdea() {
        return policyDecisionIdea;
    }

    public void setPolicyDecisionIdea(String policyDecisionIdea) {
        this.policyDecisionIdea = policyDecisionIdea == null ? null : policyDecisionIdea.trim();
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getPolicyDecisionNum() {
        return policyDecisionNum;
    }

    public void setPolicyDecisionNum(String policyDecisionNum) {
        this.policyDecisionNum = policyDecisionNum == null ? null : policyDecisionNum.trim();
    }

    public String getApplyTypeMark() {
        return applyTypeMark;
    }

    public void setApplyTypeMark(String applyTypeMark) {
        this.applyTypeMark = applyTypeMark == null ? null : applyTypeMark.trim();
    }

    public String getApproveConclusion() {
        return approveConclusion;
    }

    public void setApproveConclusion(String approveConclusion) {
        this.approveConclusion = approveConclusion == null ? null : approveConclusion.trim();
    }

    public String getEndOrgNum() {
        return endOrgNum;
    }

    public void setEndOrgNum(String endOrgNum) {
        this.endOrgNum = endOrgNum == null ? null : endOrgNum.trim();
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getIfDataMove() {
        return ifDataMove;
    }

    public void setIfDataMove(String ifDataMove) {
        this.ifDataMove = ifDataMove == null ? null : ifDataMove.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getBizHappenNature() {
        return bizHappenNature;
    }

    public void setBizHappenNature(String bizHappenNature) {
        this.bizHappenNature = bizHappenNature == null ? null : bizHappenNature.trim();
    }

    public String getIsGreenLoan() {
        return isGreenLoan;
    }

    public void setIsGreenLoan(String isGreenLoan) {
        this.isGreenLoan = isGreenLoan == null ? null : isGreenLoan.trim();
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType == null ? null : loanType.trim();
    }

    public String getBizTypeFlag() {
        return bizTypeFlag;
    }

    public void setBizTypeFlag(String bizTypeFlag) {
        this.bizTypeFlag = bizTypeFlag == null ? null : bizTypeFlag.trim();
    }

    public String getGuarantyType() {
        return guarantyType;
    }

    public void setGuarantyType(String guarantyType) {
        this.guarantyType = guarantyType == null ? null : guarantyType.trim();
    }

    public Integer getTermNum() {
        return termNum;
    }

    public void setTermNum(Integer termNum) {
        this.termNum = termNum;
    }

    public String getTermUnit() {
        return termUnit;
    }

    public void setTermUnit(String termUnit) {
        this.termUnit = termUnit == null ? null : termUnit.trim();
    }

    public BigDecimal getRmbAmt() {
        return rmbAmt;
    }

    public void setRmbAmt(BigDecimal rmbAmt) {
        this.rmbAmt = rmbAmt;
    }

    public BigDecimal getBoUse() {
        return boUse;
    }

    public void setBoUse(BigDecimal boUse) {
        this.boUse = boUse;
    }

    public BigDecimal getNoUse() {
        return noUse;
    }

    public void setNoUse(BigDecimal noUse) {
        this.noUse = noUse;
    }

    public String getCrdId() {
        return crdId;
    }

    public void setCrdId(String crdId) {
        this.crdId = crdId == null ? null : crdId.trim();
    }

    public String getCreditMode() {
        return creditMode;
    }

    public void setCreditMode(String creditMode) {
        this.creditMode = creditMode == null ? null : creditMode.trim();
    }

	@Override
	public String toString() {
		return "TbBizApprovePo [approveId=" + approveId + ", bizNum=" + bizNum + ", bizType=" + bizType
				+ ", lowRiskBizType=" + lowRiskBizType + ", applyModeType=" + applyModeType + ", bizHappenType="
				+ bizHappenType + ", orgNum=" + orgNum + ", userNum=" + userNum + ", partyId=" + partyId
				+ ", businessProduct=" + businessProduct + ", productType=" + productType + ", applyDate=" + applyDate
				+ ", handingDate=" + handingDate + ", amountType=" + amountType + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", csmCrdLevel=" + csmCrdLevel + ", approvalNum=" + approvalNum
				+ ", becomeEffectiveMark=" + becomeEffectiveMark + ", originalApproveId=" + originalApproveId
				+ ", isBankTeamLoan=" + isBankTeamLoan + ", loanInspectionFre=" + loanInspectionFre
				+ ", policyDecisionIdea=" + policyDecisionIdea + ", validDate=" + validDate + ", policyDecisionNum="
				+ policyDecisionNum + ", applyTypeMark=" + applyTypeMark + ", approveConclusion=" + approveConclusion
				+ ", endOrgNum=" + endOrgNum + ", endDate=" + endDate + ", ifDataMove=" + ifDataMove + ", applyId="
				+ applyId + ", bizHappenNature=" + bizHappenNature + ", isGreenLoan=" + isGreenLoan + ", loanType="
				+ loanType + ", bizTypeFlag=" + bizTypeFlag + ", guarantyType=" + guarantyType + ", termNum=" + termNum
				+ ", termUnit=" + termUnit + ", rmbAmt=" + rmbAmt + ", boUse=" + boUse + ", noUse=" + noUse + ", crdId="
				+ crdId + ", creditMode=" + creditMode + "]";
	}
    
 
}
