/**
 * 
 */
package com.cdgit.loan.csm.bean;

/**
 * @author cwalk
 * @createTime 2018年12月11日
 * mybatis-demo
 * com.cdgit.loan.csm.bean
 * ApproveConsVo.java
 * 生效的合同信息
 */
public class ApproveConsVo {
	
	private String conStatus;       //合同状态(:XD_SXCD8003)  
	
	private String bizType;         //
	                               
	private String productType;     //业务品种(:tb_sys_product)
	                              
	private String applyId;         //
	                               
	private String amountDetailId;  //
	                              
	private String contractId;      //
	                               
	private String contractNum;     //合同编号
	                              
	private String contractAmt;     //合同金额
	                              
	private String conBalance;      //可用金额
	                              
	private String creditMode;      //合同性质 dictTypeId="XD_BIZ0003"
	                              
	private String conYuE;          //
	                               
	private String currencyCd;      //币种
	                               
	private String beginDate;       //
	                               
	private String endDate;         //
	
	public String getConStatus() {
		return conStatus;
	}

	public void setConStatus(String conStatus) {
		this.conStatus = conStatus;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getAmountDetailId() {
		return amountDetailId;
	}

	public void setAmountDetailId(String amountDetailId) {
		this.amountDetailId = amountDetailId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
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

	public String getCreditMode() {
		return creditMode;
	}

	public void setCreditMode(String creditMode) {
		this.creditMode = creditMode;
	}


	public String getConYuE() {
		return conYuE;
	}

	public void setConYuE(String conYuE) {
		this.conYuE = conYuE;
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


	
	
	

}
