package com.cdgit.loan.csm.po;

public class TbSysApplyDaoConfigPo {//TB_SYS_APPLY_DAO_CONFIG
	
	
	private String configId;
	private String phase;
	private String legOrg;
	private String orgNum;
	private String className;
	private String flowName;
	private String code;
	private String partyType;
	private String remark;
	private String productCd;
	public String getConfigId() {
		return configId;
	}
	public void setConfigId(String configId) {
		this.configId = configId;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getLegOrg() {
		return legOrg;
	}
	public void setLegOrg(String legOrg) {
		this.legOrg = legOrg;
	}
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPartyType() {
		return partyType;
	}
	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getProductCd() {
		return productCd;
	}
	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}
	@Override
	public String toString() {
		return "TbSysApplyDaoConfigPo [configId=" + configId + ", phase=" + phase + ", legOrg=" + legOrg + ", orgNum="
				+ orgNum + ", className=" + className + ", flowName=" + flowName + ", code=" + code + ", partyType="
				+ partyType + ", remark=" + remark + ", productCd=" + productCd + "]";
	}

	

}
