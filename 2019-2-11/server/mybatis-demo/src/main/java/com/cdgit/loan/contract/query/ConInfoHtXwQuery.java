package com.cdgit.loan.contract.query;

/**
 * 主合同基本信息页面展示表，封装的页面查询信息，只是做数据回显而已，
 * 已经全部转成String类型，date也做了tochar处理
 * 
 * @author Administrator
 *
 */
public class ConInfoHtXwQuery {
	
	private String contractId;
	private String conStatus;					//合同状态	必须要（03或者05）
	private String userId;						//经办人		必填
	private String orgNum;						//经办机构	必填
	private String partyName;
	private String partyNum;
	private String productType;
	private String contractNum;					//根据合同编号查询详细的信息
	private String paperConNum;
	private String oldContractNum;				//旧合同编号根据现合同id查询全部信息，里面有旧合同id，根据合同id查询合同编号
	private String currencyCd;
	private String contractAmt;
	private String beginDate;
	private String contractTerm;
	private String cycleUnit;
	private String endDate;
	private String repaymentType;
	private String firstRepayTerm;
	private String cycleIndCon;
	private String contractDate;
	private String contractAddress;
	private String specPaymentDate;
	private String internalDays;
	private String loanUse;
	private String guarantyType;
	private String mainGuarantyType;
	private String loanTurn;
	private String riskInfo;
	private String act;
	private String serviceType;
	private String reduceAmount;
	private String ajustType;
	private String upgradeType;
	private String newProductType;
	private String whetherArgRelated;
	private String argType;
	private String supArgType;
	private String greenLoan;
	private String greenLoanUse;
	private String greenRiskType;
	private String greenRiskDetail;
	private String oldContractId;				//旧合同id，如果存在就可以使用
	
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getOldContractId() {
		return oldContractId;
	}
	public void setOldContractId(String oldContractId) {
		this.oldContractId = oldContractId;
	}
	public String getConStatus() {
		return conStatus;
	}
	public void setConStatus(String conStatus) {
		this.conStatus = conStatus;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getPartyNum() {
		return partyNum;
	}
	public void setPartyNum(String partyNum) {
		this.partyNum = partyNum;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getContractNum() {
		return contractNum;
	}
	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}
	public String getPaperConNum() {
		return paperConNum;
	}
	public void setPaperConNum(String paperConNum) {
		this.paperConNum = paperConNum;
	}
	public String getOldContractNum() {
		return oldContractNum;
	}
	public void setOldContractNum(String oldContractNum) {
		this.oldContractNum = oldContractNum;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	public String getContractAmt() {
		return contractAmt;
	}
	public void setContractAmt(String contractAmt) {
		this.contractAmt = contractAmt;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getContractTerm() {
		return contractTerm;
	}
	public void setContractTerm(String contractTerm) {
		this.contractTerm = contractTerm;
	}
	public String getCycleUnit() {
		return cycleUnit;
	}
	public void setCycleUnit(String cycleUnit) {
		this.cycleUnit = cycleUnit;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getRepaymentType() {
		return repaymentType;
	}
	public void setRepaymentType(String repaymentType) {
		this.repaymentType = repaymentType;
	}
	public String getFirstRepayTerm() {
		return firstRepayTerm;
	}
	public void setFirstRepayTerm(String firstRepayTerm) {
		this.firstRepayTerm = firstRepayTerm;
	}
	public String getCycleIndCon() {
		return cycleIndCon;
	}
	public void setCycleIndCon(String cycleIndCon) {
		this.cycleIndCon = cycleIndCon;
	}
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	public String getContractAddress() {
		return contractAddress;
	}
	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}
	public String getSpecPaymentDate() {
		return specPaymentDate;
	}
	public void setSpecPaymentDate(String specPaymentDate) {
		this.specPaymentDate = specPaymentDate;
	}
	public String getInternalDays() {
		return internalDays;
	}
	public void setInternalDays(String internalDays) {
		this.internalDays = internalDays;
	}
	public String getLoanUse() {
		return loanUse;
	}
	public void setLoanUse(String loanUse) {
		this.loanUse = loanUse;
	}
	public String getGuarantyType() {
		return guarantyType;
	}
	public void setGuarantyType(String guarantyType) {
		this.guarantyType = guarantyType;
	}
	public String getMainGuarantyType() {
		return mainGuarantyType;
	}
	public void setMainGuarantyType(String mainGuarantyType) {
		this.mainGuarantyType = mainGuarantyType;
	}
	public String getLoanTurn() {
		return loanTurn;
	}
	public void setLoanTurn(String loanTurn) {
		this.loanTurn = loanTurn;
	}
	public String getRiskInfo() {
		return riskInfo;
	}
	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act = act;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getReduceAmount() {
		return reduceAmount;
	}
	public void setReduceAmount(String reduceAmount) {
		this.reduceAmount = reduceAmount;
	}
	public String getAjustType() {
		return ajustType;
	}
	public void setAjustType(String ajustType) {
		this.ajustType = ajustType;
	}
	public String getUpgradeType() {
		return upgradeType;
	}
	public void setUpgradeType(String upgradeType) {
		this.upgradeType = upgradeType;
	}
	public String getNewProductType() {
		return newProductType;
	}
	public void setNewProductType(String newProductType) {
		this.newProductType = newProductType;
	}
	public String getWhetherArgRelated() {
		return whetherArgRelated;
	}
	public void setWhetherArgRelated(String whetherArgRelated) {
		this.whetherArgRelated = whetherArgRelated;
	}
	public String getArgType() {
		return argType;
	}
	public void setArgType(String argType) {
		this.argType = argType;
	}
	public String getSupArgType() {
		return supArgType;
	}
	public void setSupArgType(String supArgType) {
		this.supArgType = supArgType;
	}
	public String getGreenLoan() {
		return greenLoan;
	}
	public void setGreenLoan(String greenLoan) {
		this.greenLoan = greenLoan;
	}
	public String getGreenLoanUse() {
		return greenLoanUse;
	}
	public void setGreenLoanUse(String greenLoanUse) {
		this.greenLoanUse = greenLoanUse;
	}
	public String getGreenRiskType() {
		return greenRiskType;
	}
	public void setGreenRiskType(String greenRiskType) {
		this.greenRiskType = greenRiskType;
	}
	public String getGreenRiskDetail() {
		return greenRiskDetail;
	}
	public void setGreenRiskDetail(String greenRiskDetail) {
		this.greenRiskDetail = greenRiskDetail;
	}
	@Override
	public String toString() {
		return "ConInfoHtXwQuery [conStatus=" + conStatus + ", userId=" + userId + ", orgNum=" + orgNum + ", partyName="
				+ partyName + ", partyNum=" + partyNum + ", productType=" + productType + ", contractNum=" + contractNum
				+ ", paperConNum=" + paperConNum + ", oldContractNum=" + oldContractNum + ", currencyCd=" + currencyCd
				+ ", contractAmt=" + contractAmt + ", beginDate=" + beginDate + ", contractTerm=" + contractTerm
				+ ", cycleUnit=" + cycleUnit + ", endDate=" + endDate + ", repaymentType=" + repaymentType
				+ ", firstRepayTerm=" + firstRepayTerm + ", cycleIndCon=" + cycleIndCon + ", contractDate="
				+ contractDate + ", contractAddress=" + contractAddress + ", specPaymentDate=" + specPaymentDate
				+ ", internalDays=" + internalDays + ", loanUse=" + loanUse + ", guarantyType=" + guarantyType
				+ ", mainGuarantyType=" + mainGuarantyType + ", loanTurn=" + loanTurn + ", riskInfo=" + riskInfo
				+ ", act=" + act + ", serviceType=" + serviceType + ", reduceAmount=" + reduceAmount + ", ajustType="
				+ ajustType + ", upgradeType=" + upgradeType + ", newProductType=" + newProductType
				+ ", whetherArgRelated=" + whetherArgRelated + ", argType=" + argType + ", supArgType=" + supArgType
				+ ", greenLoan=" + greenLoan + ", greenLoanUse=" + greenLoanUse + ", greenRiskType=" + greenRiskType
				+ ", greenRiskDetail=" + greenRiskDetail + ", oldContractId=" + oldContractId + "]";
	}

}
