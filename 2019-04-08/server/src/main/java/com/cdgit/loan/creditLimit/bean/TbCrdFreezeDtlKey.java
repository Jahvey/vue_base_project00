package com.cdgit.loan.creditLimit.bean;

public class TbCrdFreezeDtlKey {
    private String frzId;

    private String crdDtlId;

    public String getFrzId() {
        return frzId;
    }

    public void setFrzId(String frzId) {
        this.frzId = frzId == null ? null : frzId.trim();
    }

    public String getCrdDtlId() {
        return crdDtlId;
    }

    public void setCrdDtlId(String crdDtlId) {
        this.crdDtlId = crdDtlId == null ? null : crdDtlId.trim();
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
        TbCrdFreezeDtlKey other = (TbCrdFreezeDtlKey) that;
        return (this.getFrzId() == null ? other.getFrzId() == null : this.getFrzId().equals(other.getFrzId()))
            && (this.getCrdDtlId() == null ? other.getCrdDtlId() == null : this.getCrdDtlId().equals(other.getCrdDtlId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFrzId() == null) ? 0 : getFrzId().hashCode());
        result = prime * result + ((getCrdDtlId() == null) ? 0 : getCrdDtlId().hashCode());
        return result;
    }
}