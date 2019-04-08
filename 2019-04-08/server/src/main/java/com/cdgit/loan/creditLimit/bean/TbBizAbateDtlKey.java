package com.cdgit.loan.creditLimit.bean;

public class TbBizAbateDtlKey {
    private String abateId;

    private String bizDtlId;

    public String getAbateId() {
        return abateId;
    }

    public void setAbateId(String abateId) {
        this.abateId = abateId == null ? null : abateId.trim();
    }

    public String getBizDtlId() {
        return bizDtlId;
    }

    public void setBizDtlId(String bizDtlId) {
        this.bizDtlId = bizDtlId == null ? null : bizDtlId.trim();
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
        TbBizAbateDtlKey other = (TbBizAbateDtlKey) that;
        return (this.getAbateId() == null ? other.getAbateId() == null : this.getAbateId().equals(other.getAbateId()))
            && (this.getBizDtlId() == null ? other.getBizDtlId() == null : this.getBizDtlId().equals(other.getBizDtlId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAbateId() == null) ? 0 : getAbateId().hashCode());
        result = prime * result + ((getBizDtlId() == null) ? 0 : getBizDtlId().hashCode());
        return result;
    }
}