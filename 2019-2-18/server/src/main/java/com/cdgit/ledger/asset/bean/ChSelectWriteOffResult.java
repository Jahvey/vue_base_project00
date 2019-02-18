package com.cdgit.ledger.asset.bean;

import java.math.BigDecimal;
import java.util.Date;
/**封装 1.核销查询 2.不良资产处置 结果集*/
public class ChSelectWriteOffResult {
	private String planNum;//方案编号
	private String partyName;//客户名称
	private String certType;//证件类型
	private String certNum;//证件号码
	private String planType;//处置方式
	private String regDate;//申请日期
	private String regOrgId;//申请机构
	private String regUserId;//方案申请人
	private String sumBeginDate;//借据止期
	private String sumEndDate;//借据起期
	private BigDecimal summaryAmt;//借据金额
	private BigDecimal summaryBal;//借据余额
	private String pursue;//是否保留追索权:XD_0002
	private BigDecimal cancelArrearItr;//核销拖欠利息
	private BigDecimal cancelCapitalAmt;//核销本金
	private BigDecimal cancelAmt;//核销总额
	private BigDecimal cancelNormalItr;//核销正常利息
	private BigDecimal cancelPunishItr;//核销罚息
	private String summaryNum;//借据编号
	private String contractNum;//合同编号
	private String productType;//业务品种(:tb_sys_product)
	private String id;
	private String loanId;//放款ID
	private String contractId;//合同ID
	private String userNum;//经办人
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getPlanNum() {
		return planNum;
	}
	public void setPlanNum(String planNum) {
		this.planNum = planNum;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
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
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	
	public String getRegOrgId() {
		return regOrgId;
	}
	public void setRegOrgId(String regOrgId) {
		this.regOrgId = regOrgId;
	}
	public String getRegUserId() {
		return regUserId;
	}
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getSumBeginDate() {
		return sumBeginDate;
	}
	public void setSumBeginDate(String sumBeginDate) {
		this.sumBeginDate = sumBeginDate;
	}
	public String getSumEndDate() {
		return sumEndDate;
	}
	public void setSumEndDate(String sumEndDate) {
		this.sumEndDate = sumEndDate;
	}
	public BigDecimal getSummaryAmt() {
		return summaryAmt;
	}
	public void setSummaryAmt(BigDecimal summaryAmt) {
		this.summaryAmt = summaryAmt;
	}
	public BigDecimal getSummaryBal() {
		return summaryBal;
	}
	public void setSummaryBal(BigDecimal summaryBal) {
		this.summaryBal = summaryBal;
	}
	public String getPursue() {
		return pursue;
	}
	public void setPursue(String pursue) {
		this.pursue = pursue;
	}
	public BigDecimal getCancelArrearItr() {
		return cancelArrearItr;
	}
	public void setCancelArrearItr(BigDecimal cancelArrearItr) {
		this.cancelArrearItr = cancelArrearItr;
	}
	public BigDecimal getCancelCapitalAmt() {
		return cancelCapitalAmt;
	}
	public void setCancelCapitalAmt(BigDecimal cancelCapitalAmt) {
		this.cancelCapitalAmt = cancelCapitalAmt;
	}
	public BigDecimal getCancelAmt() {
		return cancelAmt;
	}
	public void setCancelAmt(BigDecimal cancelAmt) {
		this.cancelAmt = cancelAmt;
	}
	public BigDecimal getCancelNormalItr() {
		return cancelNormalItr;
	}
	public void setCancelNormalItr(BigDecimal cancelNormalItr) {
		this.cancelNormalItr = cancelNormalItr;
	}
	public BigDecimal getCancelPunishItr() {
		return cancelPunishItr;
	}
	public void setCancelPunishItr(BigDecimal cancelPunishItr) {
		this.cancelPunishItr = cancelPunishItr;
	}
	public String getSummaryNum() {
		return summaryNum;
	}
	public void setSummaryNum(String summaryNum) {
		this.summaryNum = summaryNum;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
}
