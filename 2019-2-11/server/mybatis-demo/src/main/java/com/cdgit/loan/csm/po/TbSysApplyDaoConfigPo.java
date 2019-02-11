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
        this.configId = configId == null ? null : configId.trim();
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase == null ? null : phase.trim();
    }

    public String getLegOrg() {
        return legOrg;
    }

    public void setLegOrg(String legOrg) {
        this.legOrg = legOrg == null ? null : legOrg.trim();
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType == null ? null : partyType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getProductCd() {
        return productCd;
    }

    public void setProductCd(String productCd) {
        this.productCd = productCd == null ? null : productCd.trim();
    }

	@Override
	public String toString() {
		return "TbSysApplyDaoConfigPo [configId=" + configId + ", phase=" + phase + ", legOrg=" + legOrg + ", orgNum="
				+ orgNum + ", className=" + className + ", flowName=" + flowName + ", code=" + code + ", partyType="
				+ partyType + ", remark=" + remark + ", productCd=" + productCd + "]";
	}
    
    
	

}
