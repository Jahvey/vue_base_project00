package com.cdgit.ledger.naturalperson.bean;

public class TbCsmGuarMemeber {
    private String id;

    private String partyId;

    private String relatedCustPartyId;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getRelatedCustPartyId() {
        return relatedCustPartyId;
    }

    public void setRelatedCustPartyId(String relatedCustPartyId) {
        this.relatedCustPartyId = relatedCustPartyId == null ? null : relatedCustPartyId.trim();
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
        TbCsmGuarMemeber other = (TbCsmGuarMemeber) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getRelatedCustPartyId() == null ? other.getRelatedCustPartyId() == null : this.getRelatedCustPartyId().equals(other.getRelatedCustPartyId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getRelatedCustPartyId() == null) ? 0 : getRelatedCustPartyId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}