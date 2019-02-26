package com.cdgit.loan.csm.po;

import java.util.Date;

public class CsmTbBizSubcontractRelPo {
    private String relationId;

    private String approveId;

    private String applyId;

    private String subcontractId;

    private Date createTime;

    private Date updateTime;

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId == null ? null : relationId.trim();
    }

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId == null ? null : approveId.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getSubcontractId() {
        return subcontractId;
    }

    public void setSubcontractId(String subcontractId) {
        this.subcontractId = subcontractId == null ? null : subcontractId.trim();
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

	@Override
	public String toString() {
		return "CsmTbBizSubcontractRelPo [relationId=" + relationId + ", approveId=" + approveId + ", applyId="
				+ applyId + ", subcontractId=" + subcontractId + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
    
    
}