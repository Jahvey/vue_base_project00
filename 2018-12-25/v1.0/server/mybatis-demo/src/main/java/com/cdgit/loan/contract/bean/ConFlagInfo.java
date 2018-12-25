package com.cdgit.loan.contract.bean;

/**
 * 合同标志信息表		tb_Con_Flag_Info
 * @author Administrator
 *
 */
public class ConFlagInfo {
	
    private String flagId;					//标志ID（主键）

    private String contractId;				//合同ID（连表）

    private String loanTurn;				//行业投向(:CDXY0300)

    private String greenLoan;				//是否绿色信贷

    private String emphasisTurn;			//重点投向

    private String rhbzffl;					//人行保障住房分类(:XD_SXYW0232)

    private String yjbzffl;					//银监保障住房分类(:XD_SXYW0233)

    private String riskInfo;				//涉及环境、安全等重大风险情况(:XD_SXYW0211)

    private String act;						//采取措施(:XD_SXYW0212)

    private String serviceType;				//节能环保项目及服务类型(:XD_SXYW0215)

    private String reduceAmount;			//节能减排量(:XD_SXYW0214)

    private String focusType;				//重点关注行业类型(:XD_SXYW0213)

    private String ajustType;				//产业结构调整类型(:XD_SXCD8030)

    private String upgradeType;				//工业转型升级标识(:XD_0002)

    private String newProductType;			//战略新兴产业类型(:XD_SXCD1204)

    private String whetherArgRelated;		//是否涉农企业

    private String supArgType;				//支农贷款类型

    private String argType;					//涉农企业类型

    private String greenLoanUse;			//绿色贷款的贷款用途

    private String greenRiskType;			//环境、安全等重大风险企业类别

    private String greenRiskDetail;			//风险明细类型，分01、02、04没有这个字段？？？

    public String getFlagId() {
        return flagId;
    }

    public void setFlagId(String flagId) {
        this.flagId = flagId == null ? null : flagId.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getLoanTurn() {
        return loanTurn;
    }

    public void setLoanTurn(String loanTurn) {
        this.loanTurn = loanTurn == null ? null : loanTurn.trim();
    }

    public String getGreenLoan() {
        return greenLoan;
    }

    public void setGreenLoan(String greenLoan) {
        this.greenLoan = greenLoan == null ? null : greenLoan.trim();
    }

    public String getEmphasisTurn() {
        return emphasisTurn;
    }

    public void setEmphasisTurn(String emphasisTurn) {
        this.emphasisTurn = emphasisTurn == null ? null : emphasisTurn.trim();
    }

    public String getRhbzffl() {
        return rhbzffl;
    }

    public void setRhbzffl(String rhbzffl) {
        this.rhbzffl = rhbzffl == null ? null : rhbzffl.trim();
    }

    public String getYjbzffl() {
        return yjbzffl;
    }

    public void setYjbzffl(String yjbzffl) {
        this.yjbzffl = yjbzffl == null ? null : yjbzffl.trim();
    }

    public String getRiskInfo() {
        return riskInfo;
    }

    public void setRiskInfo(String riskInfo) {
        this.riskInfo = riskInfo == null ? null : riskInfo.trim();
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act == null ? null : act.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(String reduceAmount) {
        this.reduceAmount = reduceAmount == null ? null : reduceAmount.trim();
    }

    public String getFocusType() {
        return focusType;
    }

    public void setFocusType(String focusType) {
        this.focusType = focusType == null ? null : focusType.trim();
    }

    public String getAjustType() {
        return ajustType;
    }

    public void setAjustType(String ajustType) {
        this.ajustType = ajustType == null ? null : ajustType.trim();
    }

    public String getUpgradeType() {
        return upgradeType;
    }

    public void setUpgradeType(String upgradeType) {
        this.upgradeType = upgradeType == null ? null : upgradeType.trim();
    }

    public String getNewProductType() {
        return newProductType;
    }

    public void setNewProductType(String newProductType) {
        this.newProductType = newProductType == null ? null : newProductType.trim();
    }

    public String getWhetherArgRelated() {
        return whetherArgRelated;
    }

    public void setWhetherArgRelated(String whetherArgRelated) {
        this.whetherArgRelated = whetherArgRelated == null ? null : whetherArgRelated.trim();
    }

    public String getSupArgType() {
        return supArgType;
    }

    public void setSupArgType(String supArgType) {
        this.supArgType = supArgType == null ? null : supArgType.trim();
    }

    public String getArgType() {
        return argType;
    }

    public void setArgType(String argType) {
        this.argType = argType == null ? null : argType.trim();
    }

    public String getGreenLoanUse() {
        return greenLoanUse;
    }

    public void setGreenLoanUse(String greenLoanUse) {
        this.greenLoanUse = greenLoanUse == null ? null : greenLoanUse.trim();
    }

    public String getGreenRiskType() {
        return greenRiskType;
    }

    public void setGreenRiskType(String greenRiskType) {
        this.greenRiskType = greenRiskType == null ? null : greenRiskType.trim();
    }

    public String getGreenRiskDetail() {
        return greenRiskDetail;
    }

    public void setGreenRiskDetail(String greenRiskDetail) {
        this.greenRiskDetail = greenRiskDetail == null ? null : greenRiskDetail.trim();
    }
}