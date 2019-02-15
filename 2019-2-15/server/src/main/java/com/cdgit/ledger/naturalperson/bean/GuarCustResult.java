package com.cdgit.ledger.naturalperson.bean;
/**封装联保客户查询条件与结果集*/
public class GuarCustResult {
	private String partyId;//联保小组编号
	private String jointGuaranteeType;//联保小组类型
	private String jointGuaranteeStatus;//联保小组状态
	private String Id;//联保成员人数 
	private String orgNum;//机构名称
	private String relatedCustPartyId;//联保小组成员
	private String unifySocietyCreditNum;//统一社会信用代码
	private String registerCode;//营业执照
	private String orgRegisterCd;//组织机构代码
	private String certType;//证件类型
	private String certNum;//证件号码
	private String middleCode;//中征码	
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getRelatedCustPartyId() {
		return relatedCustPartyId;
	}
	public void setRelatedCustPartyId(String relatedCustPartyId) {
		this.relatedCustPartyId = relatedCustPartyId;
	}
	public String getUnifySocietyCreditNum() {
		return unifySocietyCreditNum;
	}
	public void setUnifySocietyCreditNum(String unifySocietyCreditNum) {
		this.unifySocietyCreditNum = unifySocietyCreditNum;
	}
	public String getRegisterCode() {
		return registerCode;
	}
	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}
	public String getOrgRegisterCd() {
		return orgRegisterCd;
	}
	public void setOrgRegisterCd(String orgRegisterCd) {
		this.orgRegisterCd = orgRegisterCd;
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
	public String getMiddleCode() {
		return middleCode;
	}
	public void setMiddleCode(String middleCode) {
		this.middleCode = middleCode;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getJointGuaranteeType() {
		return jointGuaranteeType;
	}
	public void setJointGuaranteeType(String jointGuaranteeType) {
		this.jointGuaranteeType = jointGuaranteeType;
	}
	public String getJointGuaranteeStatus() {
		return jointGuaranteeStatus;
	}
	public void setJointGuaranteeStatus(String jointGuaranteeStatus) {
		this.jointGuaranteeStatus = jointGuaranteeStatus;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}	
}
