package com.cdgit.loan.customerManage.entrustAccount.bean;

public class EntrustAccount {
    private String accId;

    private String accName;

    private String entrustAcc;

    private String entrustLoanAcc;

    private String entrustReturnAcc;

    private String entrustReturnPrincipalAcc;

    private String entrustReturnInterestAcc;

    private String partyId;

    private String entrustProjectName;

    private String entrustType;

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId == null ? null : accId.trim();
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName == null ? null : accName.trim();
    }

    public String getEntrustAcc() {
        return entrustAcc;
    }

    public void setEntrustAcc(String entrustAcc) {
        this.entrustAcc = entrustAcc == null ? null : entrustAcc.trim();
    }

    public String getEntrustLoanAcc() {
        return entrustLoanAcc;
    }

    public void setEntrustLoanAcc(String entrustLoanAcc) {
        this.entrustLoanAcc = entrustLoanAcc == null ? null : entrustLoanAcc.trim();
    }

    public String getEntrustReturnAcc() {
        return entrustReturnAcc;
    }

    public void setEntrustReturnAcc(String entrustReturnAcc) {
        this.entrustReturnAcc = entrustReturnAcc == null ? null : entrustReturnAcc.trim();
    }

    public String getEntrustReturnPrincipalAcc() {
        return entrustReturnPrincipalAcc;
    }

    public void setEntrustReturnPrincipalAcc(String entrustReturnPrincipalAcc) {
        this.entrustReturnPrincipalAcc = entrustReturnPrincipalAcc == null ? null : entrustReturnPrincipalAcc.trim();
    }

    public String getEntrustReturnInterestAcc() {
        return entrustReturnInterestAcc;
    }

    public void setEntrustReturnInterestAcc(String entrustReturnInterestAcc) {
        this.entrustReturnInterestAcc = entrustReturnInterestAcc == null ? null : entrustReturnInterestAcc.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getEntrustProjectName() {
        return entrustProjectName;
    }

    public void setEntrustProjectName(String entrustProjectName) {
        this.entrustProjectName = entrustProjectName == null ? null : entrustProjectName.trim();
    }

    public String getEntrustType() {
        return entrustType;
    }

    public void setEntrustType(String entrustType) {
        this.entrustType = entrustType == null ? null : entrustType.trim();
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
        EntrustAccount other = (EntrustAccount) that;
        return (this.getAccId() == null ? other.getAccId() == null : this.getAccId().equals(other.getAccId()))
            && (this.getAccName() == null ? other.getAccName() == null : this.getAccName().equals(other.getAccName()))
            && (this.getEntrustAcc() == null ? other.getEntrustAcc() == null : this.getEntrustAcc().equals(other.getEntrustAcc()))
            && (this.getEntrustLoanAcc() == null ? other.getEntrustLoanAcc() == null : this.getEntrustLoanAcc().equals(other.getEntrustLoanAcc()))
            && (this.getEntrustReturnAcc() == null ? other.getEntrustReturnAcc() == null : this.getEntrustReturnAcc().equals(other.getEntrustReturnAcc()))
            && (this.getEntrustReturnPrincipalAcc() == null ? other.getEntrustReturnPrincipalAcc() == null : this.getEntrustReturnPrincipalAcc().equals(other.getEntrustReturnPrincipalAcc()))
            && (this.getEntrustReturnInterestAcc() == null ? other.getEntrustReturnInterestAcc() == null : this.getEntrustReturnInterestAcc().equals(other.getEntrustReturnInterestAcc()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getEntrustProjectName() == null ? other.getEntrustProjectName() == null : this.getEntrustProjectName().equals(other.getEntrustProjectName()))
            && (this.getEntrustType() == null ? other.getEntrustType() == null : this.getEntrustType().equals(other.getEntrustType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccId() == null) ? 0 : getAccId().hashCode());
        result = prime * result + ((getAccName() == null) ? 0 : getAccName().hashCode());
        result = prime * result + ((getEntrustAcc() == null) ? 0 : getEntrustAcc().hashCode());
        result = prime * result + ((getEntrustLoanAcc() == null) ? 0 : getEntrustLoanAcc().hashCode());
        result = prime * result + ((getEntrustReturnAcc() == null) ? 0 : getEntrustReturnAcc().hashCode());
        result = prime * result + ((getEntrustReturnPrincipalAcc() == null) ? 0 : getEntrustReturnPrincipalAcc().hashCode());
        result = prime * result + ((getEntrustReturnInterestAcc() == null) ? 0 : getEntrustReturnInterestAcc().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getEntrustProjectName() == null) ? 0 : getEntrustProjectName().hashCode());
        result = prime * result + ((getEntrustType() == null) ? 0 : getEntrustType().hashCode());
        return result;
    }
}