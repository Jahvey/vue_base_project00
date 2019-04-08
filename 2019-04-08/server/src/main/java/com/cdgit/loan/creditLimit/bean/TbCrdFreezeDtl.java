package com.cdgit.loan.creditLimit.bean;

import java.math.BigDecimal;

public class TbCrdFreezeDtl extends TbCrdFreezeDtlKey {
    private BigDecimal frzAmt;

    private String statusCd;

    public BigDecimal getFrzAmt() {
        return frzAmt;
    }

    public void setFrzAmt(BigDecimal frzAmt) {
        this.frzAmt = frzAmt;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd == null ? null : statusCd.trim();
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
        TbCrdFreezeDtl other = (TbCrdFreezeDtl) that;
        return (this.getFrzId() == null ? other.getFrzId() == null : this.getFrzId().equals(other.getFrzId()))
            && (this.getCrdDtlId() == null ? other.getCrdDtlId() == null : this.getCrdDtlId().equals(other.getCrdDtlId()))
            && (this.getFrzAmt() == null ? other.getFrzAmt() == null : this.getFrzAmt().equals(other.getFrzAmt()))
            && (this.getStatusCd() == null ? other.getStatusCd() == null : this.getStatusCd().equals(other.getStatusCd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFrzId() == null) ? 0 : getFrzId().hashCode());
        result = prime * result + ((getCrdDtlId() == null) ? 0 : getCrdDtlId().hashCode());
        result = prime * result + ((getFrzAmt() == null) ? 0 : getFrzAmt().hashCode());
        result = prime * result + ((getStatusCd() == null) ? 0 : getStatusCd().hashCode());
        return result;
    }
}