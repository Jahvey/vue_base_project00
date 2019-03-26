/**
 * 
 */
package com.cdgit.loan.csm.bean;

/**
 * @author cwalk
 *
 */
public class CsmRelativePsnListVo {
	
	private String naturalRelativeId; //
	                                
	private String appellation;       //关联关系  XD_GLGX0001
	                                
	private String certType;          //证件类型 XD_ZJLX0001
	                               
	private String certNum;           //
	                                 
	private String partyId;           //
	                               
	private String partyNum;          //
	                               
	private String partyName;         //

	private String partyTypeCd;       // custType 客户类型XD_KHCD1001
	                               
	private String remark;            //
	                               
	private String custRela;          //
	                               
	private String partnerCompany;    //
	                             
	private String partnerPhoneNum;   //
	
    
	public String getPartyTypeCd() {
	return partyTypeCd;
	}
	
	public void setPartyTypeCd(String partyTypeCd) {
	this.partyTypeCd = partyTypeCd;
	}

	public String getNaturalRelativeId() {
		return naturalRelativeId;
	}

	public void setNaturalRelativeId(String naturalRelativeId) {
		this.naturalRelativeId = naturalRelativeId;
	}

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
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

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

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



	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCustRela() {
		return custRela;
	}

	public void setCustRela(String custRela) {
		this.custRela = custRela;
	}

	public String getPartnerCompany() {
		return partnerCompany;
	}

	public void setPartnerCompany(String partnerCompany) {
		this.partnerCompany = partnerCompany;
	}

	public String getPartnerPhoneNum() {
		return partnerPhoneNum;
	}

	public void setPartnerPhoneNum(String partnerPhoneNum) {
		this.partnerPhoneNum = partnerPhoneNum;
	}
	
	
	
	
	
	
	

}
