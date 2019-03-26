package com.cdgit.loan.ledger.pubquery.bean ;

public class ChTbClaClassifyDeltInfo {
    private String cdInfoId;

    private String clsResult;

    private String claMethod;

    private String lastClsResult;

    private String lastClaMethod;

    private String claApproveNum;

    private String acApplyId;

    private String loanSummaryId;

    private String aldInfoId;

    private String partyId;

    private String whetherSquare;

    private String contractNum;

    public String getCdInfoId() {
        return cdInfoId;
    }

    public void setCdInfoId(String cdInfoId) {
        this.cdInfoId = cdInfoId == null ? null : cdInfoId.trim();
    }

    public String getClsResult() {
        return clsResult;
    }

    public void setClsResult(String clsResult) {
        this.clsResult = clsResult == null ? null : clsResult.trim();
    }

    public String getClaMethod() {
        return claMethod;
    }

    public void setClaMethod(String claMethod) {
        this.claMethod = claMethod == null ? null : claMethod.trim();
    }

    public String getLastClsResult() {
        return lastClsResult;
    }

    public void setLastClsResult(String lastClsResult) {
        this.lastClsResult = lastClsResult == null ? null : lastClsResult.trim();
    }

    public String getLastClaMethod() {
        return lastClaMethod;
    }

    public void setLastClaMethod(String lastClaMethod) {
        this.lastClaMethod = lastClaMethod == null ? null : lastClaMethod.trim();
    }

    public String getClaApproveNum() {
        return claApproveNum;
    }

    public void setClaApproveNum(String claApproveNum) {
        this.claApproveNum = claApproveNum == null ? null : claApproveNum.trim();
    }

    public String getAcApplyId() {
        return acApplyId;
    }

    public void setAcApplyId(String acApplyId) {
        this.acApplyId = acApplyId == null ? null : acApplyId.trim();
    }

    public String getLoanSummaryId() {
        return loanSummaryId;
    }

    public void setLoanSummaryId(String loanSummaryId) {
        this.loanSummaryId = loanSummaryId == null ? null : loanSummaryId.trim();
    }

    public String getAldInfoId() {
        return aldInfoId;
    }

    public void setAldInfoId(String aldInfoId) {
        this.aldInfoId = aldInfoId == null ? null : aldInfoId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getWhetherSquare() {
        return whetherSquare;
    }

    public void setWhetherSquare(String whetherSquare) {
        this.whetherSquare = whetherSquare == null ? null : whetherSquare.trim();
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum == null ? null : contractNum.trim();
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
        ChTbClaClassifyDeltInfo other = (ChTbClaClassifyDeltInfo) that;
        return (this.getCdInfoId() == null ? other.getCdInfoId() == null : this.getCdInfoId().equals(other.getCdInfoId()))
            && (this.getClsResult() == null ? other.getClsResult() == null : this.getClsResult().equals(other.getClsResult()))
            && (this.getClaMethod() == null ? other.getClaMethod() == null : this.getClaMethod().equals(other.getClaMethod()))
            && (this.getLastClsResult() == null ? other.getLastClsResult() == null : this.getLastClsResult().equals(other.getLastClsResult()))
            && (this.getLastClaMethod() == null ? other.getLastClaMethod() == null : this.getLastClaMethod().equals(other.getLastClaMethod()))
            && (this.getClaApproveNum() == null ? other.getClaApproveNum() == null : this.getClaApproveNum().equals(other.getClaApproveNum()))
            && (this.getAcApplyId() == null ? other.getAcApplyId() == null : this.getAcApplyId().equals(other.getAcApplyId()))
            && (this.getLoanSummaryId() == null ? other.getLoanSummaryId() == null : this.getLoanSummaryId().equals(other.getLoanSummaryId()))
            && (this.getAldInfoId() == null ? other.getAldInfoId() == null : this.getAldInfoId().equals(other.getAldInfoId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getWhetherSquare() == null ? other.getWhetherSquare() == null : this.getWhetherSquare().equals(other.getWhetherSquare()))
            && (this.getContractNum() == null ? other.getContractNum() == null : this.getContractNum().equals(other.getContractNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCdInfoId() == null) ? 0 : getCdInfoId().hashCode());
        result = prime * result + ((getClsResult() == null) ? 0 : getClsResult().hashCode());
        result = prime * result + ((getClaMethod() == null) ? 0 : getClaMethod().hashCode());
        result = prime * result + ((getLastClsResult() == null) ? 0 : getLastClsResult().hashCode());
        result = prime * result + ((getLastClaMethod() == null) ? 0 : getLastClaMethod().hashCode());
        result = prime * result + ((getClaApproveNum() == null) ? 0 : getClaApproveNum().hashCode());
        result = prime * result + ((getAcApplyId() == null) ? 0 : getAcApplyId().hashCode());
        result = prime * result + ((getLoanSummaryId() == null) ? 0 : getLoanSummaryId().hashCode());
        result = prime * result + ((getAldInfoId() == null) ? 0 : getAldInfoId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getWhetherSquare() == null) ? 0 : getWhetherSquare().hashCode());
        result = prime * result + ((getContractNum() == null) ? 0 : getContractNum().hashCode());
        return result;
    }
}