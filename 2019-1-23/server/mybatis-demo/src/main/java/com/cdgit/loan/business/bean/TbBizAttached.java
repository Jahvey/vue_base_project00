package com.cdgit.loan.business.bean;

import java.util.Date;

public class TbBizAttached {
    private String attachedId;

    private String attachedType;

    private String attachedDesc;

    private String userNum;

    private String orgNum;

    private Date createTime;

    private String applyId;

    public String getAttachedId() {
        return attachedId;
    }

    public void setAttachedId(String attachedId) {
        this.attachedId = attachedId == null ? null : attachedId.trim();
    }

    public String getAttachedType() {
        return attachedType;
    }

    public void setAttachedType(String attachedType) {
        this.attachedType = attachedType == null ? null : attachedType.trim();
    }

    public String getAttachedDesc() {
        return attachedDesc;
    }

    public void setAttachedDesc(String attachedDesc) {
        this.attachedDesc = attachedDesc == null ? null : attachedDesc.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
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
        TbBizAttached other = (TbBizAttached) that;
        return (this.getAttachedId() == null ? other.getAttachedId() == null : this.getAttachedId().equals(other.getAttachedId()))
            && (this.getAttachedType() == null ? other.getAttachedType() == null : this.getAttachedType().equals(other.getAttachedType()))
            && (this.getAttachedDesc() == null ? other.getAttachedDesc() == null : this.getAttachedDesc().equals(other.getAttachedDesc()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttachedId() == null) ? 0 : getAttachedId().hashCode());
        result = prime * result + ((getAttachedType() == null) ? 0 : getAttachedType().hashCode());
        result = prime * result + ((getAttachedDesc() == null) ? 0 : getAttachedDesc().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        return result;
    }
}