package com.cdgit.loan.business.bean;

public class TbBizApplyLockingKey {
    private String applyId;

    private String lockType;

    private String lockBizId;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getLockType() {
        return lockType;
    }

    public void setLockType(String lockType) {
        this.lockType = lockType == null ? null : lockType.trim();
    }

    public String getLockBizId() {
        return lockBizId;
    }

    public void setLockBizId(String lockBizId) {
        this.lockBizId = lockBizId == null ? null : lockBizId.trim();
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
        TbBizApplyLockingKey other = (TbBizApplyLockingKey) that;
        return (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()))
            && (this.getLockType() == null ? other.getLockType() == null : this.getLockType().equals(other.getLockType()))
            && (this.getLockBizId() == null ? other.getLockBizId() == null : this.getLockBizId().equals(other.getLockBizId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        result = prime * result + ((getLockType() == null) ? 0 : getLockType().hashCode());
        result = prime * result + ((getLockBizId() == null) ? 0 : getLockBizId().hashCode());
        return result;
    }
}