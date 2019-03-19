package com.cdgit.loan.creditLimit.bean;

import java.util.Date;

public class TbCrdProjectRel {
    private String relId;

    private String limitId;

    private String projectId;

    private Date createTime;

    private Date updateTime;

    private String status;

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId == null ? null : relId.trim();
    }

    public String getLimitId() {
        return limitId;
    }

    public void setLimitId(String limitId) {
        this.limitId = limitId == null ? null : limitId.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        TbCrdProjectRel other = (TbCrdProjectRel) that;
        return (this.getRelId() == null ? other.getRelId() == null : this.getRelId().equals(other.getRelId()))
            && (this.getLimitId() == null ? other.getLimitId() == null : this.getLimitId().equals(other.getLimitId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRelId() == null) ? 0 : getRelId().hashCode());
        result = prime * result + ((getLimitId() == null) ? 0 : getLimitId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}