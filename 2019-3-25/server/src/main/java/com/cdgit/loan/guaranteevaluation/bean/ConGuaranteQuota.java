package com.cdgit.loan.guaranteevaluation.bean;

import java.math.BigDecimal;

public class ConGuaranteQuota extends ConGuaranteQuotaKey {
    private BigDecimal guaranteAmt;

    public BigDecimal getGuaranteAmt() {
        return guaranteAmt;
    }

    public void setGuaranteAmt(BigDecimal guaranteAmt) {
        this.guaranteAmt = guaranteAmt;
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
        ConGuaranteQuota other = (ConGuaranteQuota) that;
        return (this.getConPartyId() == null ? other.getConPartyId() == null : this.getConPartyId().equals(other.getConPartyId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getGuaranteAmt() == null ? other.getGuaranteAmt() == null : this.getGuaranteAmt().equals(other.getGuaranteAmt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConPartyId() == null) ? 0 : getConPartyId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getGuaranteAmt() == null) ? 0 : getGuaranteAmt().hashCode());
        return result;
    }
}