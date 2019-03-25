package com.cdgit.loan.csm.po;

public class CsmTbConFlagInfoPo {
    private String flagId;

    private String contractId;

    private String loanTurn;

    private String greenLoan;

    private String emphasisTurn;

    private String rhbzffl;

    private String yjbzffl;

    private String riskInfo;

    private String act;

    private String serviceType;

    private String reduceAmount;

    private String focusType;

    private String ajustType;

    private String upgradeType;

    private String newProductType;

    private String whetherArgRelated;

    private String supArgType;

    private String argType;

    private String greenLoanUse;

    private String greenRiskType;

    private String greenRiskDetail;

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

	@Override
	public String toString() {
		return "CsmTbConFlagInfoPo [flagId=" + flagId + ", contractId=" + contractId + ", loanTurn=" + loanTurn
				+ ", greenLoan=" + greenLoan + ", emphasisTurn=" + emphasisTurn + ", rhbzffl=" + rhbzffl + ", yjbzffl="
				+ yjbzffl + ", riskInfo=" + riskInfo + ", act=" + act + ", serviceType=" + serviceType
				+ ", reduceAmount=" + reduceAmount + ", focusType=" + focusType + ", ajustType=" + ajustType
				+ ", upgradeType=" + upgradeType + ", newProductType=" + newProductType + ", whetherArgRelated="
				+ whetherArgRelated + ", supArgType=" + supArgType + ", argType=" + argType + ", greenLoanUse="
				+ greenLoanUse + ", greenRiskType=" + greenRiskType + ", greenRiskDetail=" + greenRiskDetail + "]";
	}
    
    
}