package com.cdgit.loan.csm.bean;

import java.util.Date;

public class CsmTbBizXmxxApply {
    private String relateId;

    private String applyDetailId;

    private String projectId;

    private String projectLoanType;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String payDirection;

    public String getRelateId() {
        return relateId;
    }

    public void setRelateId(String relateId) {
        this.relateId = relateId == null ? null : relateId.trim();
    }

    public String getApplyDetailId() {
        return applyDetailId;
    }

    public void setApplyDetailId(String applyDetailId) {
        this.applyDetailId = applyDetailId == null ? null : applyDetailId.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getProjectLoanType() {
        return projectLoanType;
    }

    public void setProjectLoanType(String projectLoanType) {
        this.projectLoanType = projectLoanType == null ? null : projectLoanType.trim();
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

    public String getAmountDetailId() {
        return amountDetailId;
    }

    public void setAmountDetailId(String amountDetailId) {
        this.amountDetailId = amountDetailId == null ? null : amountDetailId.trim();
    }

    public String getPayDirection() {
        return payDirection;
    }

    public void setPayDirection(String payDirection) {
        this.payDirection = payDirection == null ? null : payDirection.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CsmTbBizXmxxApply other = (CsmTbBizXmxxApply) that;
        return (this.getRelateId() == null ? other.getRelateId() == null : this.getRelateId().equals(other.getRelateId()))
            && (this.getApplyDetailId() == null ? other.getApplyDetailId() == null : this.getApplyDetailId().equals(other.getApplyDetailId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectLoanType() == null ? other.getProjectLoanType() == null : this.getProjectLoanType().equals(other.getProjectLoanType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getAmountDetailId() == null ? other.getAmountDetailId() == null : this.getAmountDetailId().equals(other.getAmountDetailId()))
            && (this.getPayDirection() == null ? other.getPayDirection() == null : this.getPayDirection().equals(other.getPayDirection()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRelateId() == null) ? 0 : getRelateId().hashCode());
        result = prime * result + ((getApplyDetailId() == null) ? 0 : getApplyDetailId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectLoanType() == null) ? 0 : getProjectLoanType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getAmountDetailId() == null) ? 0 : getAmountDetailId().hashCode());
        result = prime * result + ((getPayDirection() == null) ? 0 : getPayDirection().hashCode());
        return result;
    }
}