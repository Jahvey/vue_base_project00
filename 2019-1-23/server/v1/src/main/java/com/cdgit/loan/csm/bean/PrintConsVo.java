
package com.cdgit.loan.csm.bean;

/**
 * 
 * @author cwalk
 * @createTime 上午11:17:27
 * mybatis-demo
 * com.cdgit.loan.csm.bean
 * PrintConsVo.java
 */
public class PrintConsVo {
	
	private String contractNum;             //合同编号
	                                      
	private String partyName;               //借款/担保人
	                                      
	private String conTypeCn;               //担保合同类型(XD_YWDB0131) subcontract_type tb_con_subcontract
	                                        //借据调整类型(:XD_DHBG0001)
	private String productType;             //  业务品种
	                                      
	private String contractAmt;             //合同金额
	                                      
	private String periodNum;               //展期协议号
	                                      
	private String beginDate;               //合同起期
	                                        
	private String endDate;                 //合同止期
	
	private String currencyCd;              //币种
	
	private String contractDate;            //
	
	
	
	
                                            
	public String getCurrencyCd() {
		return currencyCd;
	}

	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}

	public String getContractDate() {
		return contractDate;
	}

	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getConTypeCn() {
		return conTypeCn;
	}

	public void setConTypeCn(String conTypeCn) {
		this.conTypeCn = conTypeCn;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getContractAmt() {
		return contractAmt;
	}

	public void setContractAmt(String contractAmt) {
		this.contractAmt = contractAmt;
	}

	public String getPeriodNum() {
		return periodNum;
	}

	public void setPeriodNum(String periodNum) {
		this.periodNum = periodNum;
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
	
	
	

}
