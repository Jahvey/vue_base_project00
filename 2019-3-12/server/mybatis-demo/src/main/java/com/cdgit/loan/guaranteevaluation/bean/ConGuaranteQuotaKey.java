package com.cdgit.loan.guaranteevaluation.bean;
/**
 * 担保客户对指定客户设定担保金额
 * @author wuyong
 *
 */
public class ConGuaranteQuotaKey {
    private String conPartyId;

    private String partyId;

    public String getConPartyId() {
        return conPartyId;
    }

    public void setConPartyId(String conPartyId) {
        this.conPartyId = conPartyId == null ? null : conPartyId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
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
        ConGuaranteQuotaKey other = (ConGuaranteQuotaKey) that;
        return (this.getConPartyId() == null ? other.getConPartyId() == null : this.getConPartyId().equals(other.getConPartyId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConPartyId() == null) ? 0 : getConPartyId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        return result;
    }
}