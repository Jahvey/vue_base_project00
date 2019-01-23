package com.cdgit.loan.csm.po;

import java.util.Date;

public class TbConSubcontractRelPo {//TB_CON_SUBCONTRACT_REL
    private String conSubconId;

    private String contractId;

    private String subcontractId;

    private String ifEffective;

    private String suretyAmt;

    private Date createTime;

    private Date updateTime;

    private String operationType;

    private String subcontractIdBackups;

    private String subcontractAmt;

	public String getConSubconId() {
		return conSubconId;
	}

	public void setConSubconId(String conSubconId) {
		this.conSubconId = conSubconId;
	}

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

	public String getIfEffective() {
		return ifEffective;
	}

	public void setIfEffective(String ifEffective) {
		this.ifEffective = ifEffective;
	}

	public String getSuretyAmt() {
		return suretyAmt;
	}

	public void setSuretyAmt(String suretyAmt) {
		this.suretyAmt = suretyAmt;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getSubcontractIdBackups() {
		return subcontractIdBackups;
	}

	public void setSubcontractIdBackups(String subcontractIdBackups) {
		this.subcontractIdBackups = subcontractIdBackups;
	}

	public String getSubcontractAmt() {
		return subcontractAmt;
	}

	public void setSubcontractAmt(String subcontractAmt) {
		this.subcontractAmt = subcontractAmt;
	}

	@Override
	public String toString() {
		return "TbConSubcontractRelPo [conSubconId=" + conSubconId + ", contractId=" + contractId + ", subcontractId="
				+ subcontractId + ", ifEffective=" + ifEffective + ", suretyAmt=" + suretyAmt + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", operationType=" + operationType
				+ ", subcontractIdBackups=" + subcontractIdBackups + ", subcontractAmt=" + subcontractAmt + "]";
	}
    
    
    
	

}
