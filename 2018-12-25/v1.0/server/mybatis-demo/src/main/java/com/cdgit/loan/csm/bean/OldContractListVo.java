/**
 * 
 */
package com.cdgit.loan.csm.bean;

/**
 * @author cwalk
 * @createTime 下午6:15:31
 * mybatis-demo
 * com.cdgit.loan.csm.bean
 * OldContractListVo.java
 */
public class OldContractListVo {
	
	private String contractId;       //
	                               
	private String subcontractId;    //
	                              
	private String contractNum;      //合同编号
	                               
	private String contractAmt;      //合同金额
	                               
	private String conYuE;           //合同已用金额
	                              
	private String currencyCd;       //币种
	                               
	private String beginDate;        //合同起期
	                             
	private String endDate;          //合同止期
	                                
	private String productType;      //业务品种
	                               
	private String subcontractType;  //
	                              
	private String suretyAmt;        //本次担保金额

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getSubcontractId() {
		return subcontractId;
	}

	public void setSubcontractId(String subcontractId) {
		this.subcontractId = subcontractId;
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

	public String getConYuE() {
		return conYuE;
	}

	public void setConYuE(String conYuE) {
		this.conYuE = conYuE;
	}

	public String getCurrencyCd() {
		return currencyCd;
	}

	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
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

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getSubcontractType() {
		return subcontractType;
	}

	public void setSubcontractType(String subcontractType) {
		this.subcontractType = subcontractType;
	}

	public String getSuretyAmt() {
		return suretyAmt;
	}

	public void setSuretyAmt(String suretyAmt) {
		this.suretyAmt = suretyAmt;
	}
	
	

}
