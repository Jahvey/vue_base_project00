package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 批复表:tb_biz_approve
 * 两大作用：
 *		1. 记录业务基本信息，充当合同签订的审批依据。
 *		2. 记录业务申请审批记录信息，支持业务申请审批业务的流转，并留下业务审计痕迹。
 * @author Administrator
 * 	Approve：批准
 *
 */
public class BizApprove {
	
    private String approveId;					//业务基本信息唯一标识(主键)

    private String bizNum;						//对于业务申请来说是业务编号， 标识申报书所代表债项业务的业务编号，用于唯一标识该笔债项业务    对于额度申请来说是授信额度编号，标识要申请的授信额度编号

    private String bizType;						//业务性质(:XD_SXYW0002)

    private String lowRiskBizType;				//低风险业务类别(:XD_SXYW0225)

    private String applyModeType;				//申报模式(:XD_SXYW0003)

    private String bizHappenType;				//业务发生性质(:XD_SXYW0001)

    private String orgNum;						//经办机构编号

    private String userNum;						//经办人编号

    private String partyId;						//参与人ID

    private String businessProduct;				//业务产品

    private String productType;					//业务品种(:tb_sys_product)

    private Date applyDate;						//申请日期

    private Date handingDate;					//经办时间

    private String amountType;					//额度分类

    private Date createTime;					//创建时间

    private Date updateTime;					//更新时间

    private String csmCrdLevel;

    private String approvalNum;					//批复编号

    private String becomeEffectiveMark;			//生效标识(:XD_SXCD8003)

    private String originalApproveId;			//原批复ID

    private String isBankTeamLoan;				//是否银团贷款(:XD_0002

    private Integer loanInspectionFre;			//贷后检查频率

    private String policyDecisionIdea;			//决策单意见

    private Date validDate;						//生效日期

    private String policyDecisionNum;			//终审人编号

    private String applyTypeMark;				//申请类型标识

    private String approveConclusion;			//批复结论(:XD_WFCD0002)

    private String endOrgNum;					//终批机构编号

    private Date endDate;						//到期日期

    private String ifDataMove;					//是否迁移数据(:XD_0002)

    private String applyId;						//申请ID

    private String bizHappenNature;				//业务发生方式(:XD_SXYW0004)

    private String isGreenLoan;					//是否绿色贷款 XD_0002

    private String loanType;					//贷款形式 XD_DKXS0001

    private String bizTypeFlag;					//业务性质标识(:XD_SXYW0002)

    private String guarantyType;				//担保方式

    private Integer termNum;					//条款编号
    
    private String termUnit;					//条款单位

    private BigDecimal rmbAmt;					//折算人民币金额

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
}