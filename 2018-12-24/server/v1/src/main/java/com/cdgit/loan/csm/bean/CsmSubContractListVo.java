/**
 * 
 */
package com.cdgit.loan.csm.bean;

/**
 * @author cwalk
 * @createTime 下午3:14:22
 * mybatis-demo
 * com.cdgit.loan.csm.bean
 * SubContractListVo.java
 * 
 * 担保合同管理
 */
public class CsmSubContractListVo {
	
	private String subcontractId; 
	
	private String partyId;
	
	private String subcontractType;
	

	private String subcontractNum;          //担保合同编号
	                                        
	private String partyName;               //担保人名称
	                                       
	private String currencyCdn;             //币种
	                                      
	private String subcontractAmt;          //担保合同金额
	                                      
	private String subcontractTypeName;     //担保合同类型
	                                     
	private String ifTopSubcon;             //是否最高额
	                                     
	private String beginDate;               //担保合同起期
	                                    
	private String endDate;                 //担保合同止期
	                                    
	private String userNum;                 //经办人
	                                    
	private String orgNum;                  //经办机构

	public String getSubcontractNum() {
		return subcontractNum;
	}

	public void setSubcontractNum(String subcontractNum) {
		this.subcontractNum = subcontractNum;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getCurrencyCdn() {
		return currencyCdn;
	}

	public void setCurrencyCdn(String currencyCdn) {
		this.currencyCdn = currencyCdn;
	}

	public String getSubcontractAmt() {
		return subcontractAmt;
	}

	public void setSubcontractAmt(String subcontractAmt) {
		this.subcontractAmt = subcontractAmt;
	}

	public String getSubcontractTypeName() {
		return subcontractTypeName;
	}

	public void setSubcontractTypeName(String subcontractTypeName) {
		this.subcontractTypeName = subcontractTypeName;
	}

	public String getIfTopSubcon() {
		return ifTopSubcon;
	}

	public void setIfTopSubcon(String ifTopSubcon) {
		this.ifTopSubcon = ifTopSubcon;
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

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getOrgNum() {
		return orgNum;
	}

	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getSubcontractId() {
		return subcontractId;
	}

	public void setSubcontractId(String subcontractId) {
		this.subcontractId = subcontractId;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getSubcontractType() {
		return subcontractType;
	}

	public void setSubcontractType(String subcontractType) {
		this.subcontractType = subcontractType;
	}
	
	
	

}
