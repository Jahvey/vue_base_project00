package com.cdgit.loan.contract.bean;

/**
 * 这是一个映射合同查询的bean，查询我的业务主页面的信息，里面的参数是几张表联合查询的参数
 * 其实我觉得这玩意儿最好是放到query包下面
 * @author Administrator
 *
 */
public class ConApvList {
	
	private String contractId;
	private String bizType;
	private String bizTypeFlag;
	private String partyId;
	private String partyName;
	private String contractNum;
	private String productType;
	private String certType;
	private String certNum;
	private String conStatus;
	private String beginDate;
	private String endDate;
	private String currencyCd;
	private String contractAmt;
	private String conBalance;
	private String conYuE;
	private String ocupAmt;
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getBizTypeFlag() {
		return bizTypeFlag;
	}
	public void setBizTypeFlag(String bizTypeFlag) {
		this.bizTypeFlag = bizTypeFlag;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getContractNum() {
		return contractNum;
	}
	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertNum() {
		return certNum;
	}
	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}
	public String getConStatus() {
		return conStatus;
	}
	public void setConStatus(String conStatus) {
		this.conStatus = conStatus;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	public String getConBalance() {
		return conBalance;
	}
	public void setConBalance(String conBalance) {
		this.conBalance = conBalance;
	}
	public String getConYuE() {
		return conYuE;
	}
	public void setConYuE(String conYuE) {
		this.conYuE = conYuE;
	}
	public String getOcupAmt() {
		return ocupAmt;
	}
	public void setOcupAmt(String ocupAmt) {
		this.ocupAmt = ocupAmt;
	}
	@Override
	public String toString() {
		return "ConApvList [contractId=" + contractId + ", bizType=" + bizType + ", bizTypeFlag=" + bizTypeFlag
				+ ", partyId=" + partyId + ", partyName=" + partyName + ", contractNum=" + contractNum
				+ ", productType=" + productType + ", certType=" + certType + ", certNum=" + certNum + ", conStatus="
				+ conStatus + ", beginDate=" + beginDate + ", endDate=" + endDate + ", currencyCd=" + currencyCd
				+ ", contractAmt=" + contractAmt + ", conBalance=" + conBalance + ", conYuE=" + conYuE + ", ocupAmt="
				+ ocupAmt + "]";
	}
	

}
