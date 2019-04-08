/**
 * 
 */
package com.cdgit.loan.csm.bean;

/**
 * @author cwalk
 *
 */
public class CsmBizListVo {
	
	
	private String partyNum;       //客户编号
	                            
	private String partyName;      //客户名称
	                        
	private String approveId;      //
	                          
	private String bizHappenType;  //业务发生性质(:XD_SXYW0001)
	                           
	private String bizType;        //业务性质(:XD_SXYW0002)
	                           
	private String partyId;        //参与人ID
	                           
	private String bizTypeFlag;    //业务性质标识(:XD_SXYW0002)
	                             
	private String rmbAmt;         //业务金额（元）
	                              
	private String boUse;          //可用金额（元
	                            
	private String productType;    //业务品种(:tb_sys_product)
	                             
	private String validDate;      //生效日期
	                           
	private String endDate;        //
	                             
	private String userNum;        //经办人编号
	                              
	private String orgNum;         //经办机构编号
	                              
	private String creditMode;     //业务性质 XD_BIZ0003
	                              
	private String bizNum;         //对于业务申请来说是业务编号， 标识申报书所代表债项业务的业务编号，用于唯一标识该笔债项业务
									//对于额度申请来说是授信额度编号，标识要申请的授信额度编号
	                              
	private String isBankTeamLoan; //是否银团贷款(:XD_0002)

	public String getPartyNum() {
		return partyNum;
	}

	public void setPartyNum(String partyNum) {
		this.partyNum = partyNum;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public String getBizHappenType() {
		return bizHappenType;
	}

	public void setBizHappenType(String bizHappenType) {
		this.bizHappenType = bizHappenType;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getBizTypeFlag() {
		return bizTypeFlag;
	}

	public void setBizTypeFlag(String bizTypeFlag) {
		this.bizTypeFlag = bizTypeFlag;
	}

	public String getRmbAmt() {
		return rmbAmt;
	}

	public void setRmbAmt(String rmbAmt) {
		this.rmbAmt = rmbAmt;
	}

	public String getBoUse() {
		return boUse;
	}

	public void setBoUse(String boUse) {
		this.boUse = boUse;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
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

	public String getCreditMode() {
		return creditMode;
	}

	public void setCreditMode(String creditMode) {
		this.creditMode = creditMode;
	}

	public String getBizNum() {
		return bizNum;
	}

	public void setBizNum(String bizNum) {
		this.bizNum = bizNum;
	}

	public String getIsBankTeamLoan() {
		return isBankTeamLoan;
	}

	public void setIsBankTeamLoan(String isBankTeamLoan) {
		this.isBankTeamLoan = isBankTeamLoan;
	}
	
	
	

}
