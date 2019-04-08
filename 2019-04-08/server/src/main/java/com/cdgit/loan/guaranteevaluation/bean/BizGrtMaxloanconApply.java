package com.cdgit.loan.guaranteevaluation.bean;

import java.util.Date;

public class BizGrtMaxloanconApply {
    private String maxloanconId;

    private String approveId;

    private String subcontractId;

    private Date createTime;

    private Date updateTime;

    private String applyId;

    private String reType;

    public String getMaxloanconId() {
        return maxloanconId;
    }

    public void setMaxloanconId(String maxloanconId) {
        this.maxloanconId = maxloanconId == null ? null : maxloanconId.trim();
    }

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId == null ? null : approveId.trim();
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

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getReType() {
        return reType;
    }

    public void setReType(String reType) {
        this.reType = reType == null ? null : reType.trim();
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
        BizGrtMaxloanconApply other = (BizGrtMaxloanconApply) that;
        return (this.getMaxloanconId() == null ? other.getMaxloanconId() == null : this.getMaxloanconId().equals(other.getMaxloanconId()))
            && (this.getApproveId() == null ? other.getApproveId() == null : this.getApproveId().equals(other.getApproveId()))
            && (this.getSubcontractId() == null ? other.getSubcontractId() == null : this.getSubcontractId().equals(other.getSubcontractId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()))
            && (this.getReType() == null ? other.getReType() == null : this.getReType().equals(other.getReType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMaxloanconId() == null) ? 0 : getMaxloanconId().hashCode());
        result = prime * result + ((getApproveId() == null) ? 0 : getApproveId().hashCode());
        result = prime * result + ((getSubcontractId() == null) ? 0 : getSubcontractId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        result = prime * result + ((getReType() == null) ? 0 : getReType().hashCode());
        return result;
    }
}