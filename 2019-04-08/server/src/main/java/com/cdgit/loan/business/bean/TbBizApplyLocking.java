package com.cdgit.loan.business.bean;

public class TbBizApplyLocking extends TbBizApplyLockingKey {
    private String lockTable;

    public String getLockTable() {
        return lockTable;
    }

    public void setLockTable(String lockTable) {
        this.lockTable = lockTable == null ? null : lockTable.trim();
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
        TbBizApplyLocking other = (TbBizApplyLocking) that;
        return (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()))
            && (this.getLockType() == null ? other.getLockType() == null : this.getLockType().equals(other.getLockType()))
            && (this.getLockBizId() == null ? other.getLockBizId() == null : this.getLockBizId().equals(other.getLockBizId()))
            && (this.getLockTable() == null ? other.getLockTable() == null : this.getLockTable().equals(other.getLockTable()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        result = prime * result + ((getLockType() == null) ? 0 : getLockType().hashCode());
        result = prime * result + ((getLockBizId() == null) ? 0 : getLockBizId().hashCode());
        result = prime * result + ((getLockTable() == null) ? 0 : getLockTable().hashCode());
        return result;
    }
}