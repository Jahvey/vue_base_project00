package com.cdgit.loan.afterloan.riskclass.bean;

import java.util.Date;

public class ChTbClaDebtDetailinfo {
    private String debtDetailinfoId;

    private String partyId;

    private String acApplyId;

    private String claApproveNum;

    private String loanSummaryId;

    private String custRiskTypeCd;

    private String claProperties;

    private String claMethod;

    private String lastClsResult;

    private String lastClaMethod;

    private String clsResult;

    private String alcInfoId;

    private String aldInfoId;

    private String status;

    private Date createTime;

    private String userNum;

    private String orgNum;

    private String generateTypeCd;

    private String whetherSquare;

    private String contractNum;

    public String getDebtDetailinfoId() {
        return debtDetailinfoId;
    }

    public void setDebtDetailinfoId(String debtDetailinfoId) {
        this.debtDetailinfoId = debtDetailinfoId == null ? null : debtDetailinfoId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getAcApplyId() {
        return acApplyId;
    }

    public void setAcApplyId(String acApplyId) {
        this.acApplyId = acApplyId == null ? null : acApplyId.trim();
    }

    public String getClaApproveNum() {
        return claApproveNum;
    }

    public void setClaApproveNum(String claApproveNum) {
        this.claApproveNum = claApproveNum == null ? null : claApproveNum.trim();
    }

    public String getLoanSummaryId() {
        return loanSummaryId;
    }

    public void setLoanSummaryId(String loanSummaryId) {
        this.loanSummaryId = loanSummaryId == null ? null : loanSummaryId.trim();
    }

    public String getCustRiskTypeCd() {
        return custRiskTypeCd;
    }

    public void setCustRiskTypeCd(String custRiskTypeCd) {
        this.custRiskTypeCd = custRiskTypeCd == null ? null : custRiskTypeCd.trim();
    }

    public String getClaProperties() {
        return claProperties;
    }

    public void setClaProperties(String claProperties) {
        this.claProperties = claProperties == null ? null : claProperties.trim();
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

    public String getClsResult() {
        return clsResult;
    }

    public void setClsResult(String clsResult) {
        this.clsResult = clsResult == null ? null : clsResult.trim();
    }

    public String getAlcInfoId() {
        return alcInfoId;
    }

    public void setAlcInfoId(String alcInfoId) {
        this.alcInfoId = alcInfoId == null ? null : alcInfoId.trim();
    }

    public String getAldInfoId() {
        return aldInfoId;
    }

    public void setAldInfoId(String aldInfoId) {
        this.aldInfoId = aldInfoId == null ? null : aldInfoId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
    }

    public String getGenerateTypeCd() {
        return generateTypeCd;
    }

    public void setGenerateTypeCd(String generateTypeCd) {
        this.generateTypeCd = generateTypeCd == null ? null : generateTypeCd.trim();
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
        ChTbClaDebtDetailinfo other = (ChTbClaDebtDetailinfo) that;
        return (this.getDebtDetailinfoId() == null ? other.getDebtDetailinfoId() == null : this.getDebtDetailinfoId().equals(other.getDebtDetailinfoId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getAcApplyId() == null ? other.getAcApplyId() == null : this.getAcApplyId().equals(other.getAcApplyId()))
            && (this.getClaApproveNum() == null ? other.getClaApproveNum() == null : this.getClaApproveNum().equals(other.getClaApproveNum()))
            && (this.getLoanSummaryId() == null ? other.getLoanSummaryId() == null : this.getLoanSummaryId().equals(other.getLoanSummaryId()))
            && (this.getCustRiskTypeCd() == null ? other.getCustRiskTypeCd() == null : this.getCustRiskTypeCd().equals(other.getCustRiskTypeCd()))
            && (this.getClaProperties() == null ? other.getClaProperties() == null : this.getClaProperties().equals(other.getClaProperties()))
            && (this.getClaMethod() == null ? other.getClaMethod() == null : this.getClaMethod().equals(other.getClaMethod()))
            && (this.getLastClsResult() == null ? other.getLastClsResult() == null : this.getLastClsResult().equals(other.getLastClsResult()))
            && (this.getLastClaMethod() == null ? other.getLastClaMethod() == null : this.getLastClaMethod().equals(other.getLastClaMethod()))
            && (this.getClsResult() == null ? other.getClsResult() == null : this.getClsResult().equals(other.getClsResult()))
            && (this.getAlcInfoId() == null ? other.getAlcInfoId() == null : this.getAlcInfoId().equals(other.getAlcInfoId()))
            && (this.getAldInfoId() == null ? other.getAldInfoId() == null : this.getAldInfoId().equals(other.getAldInfoId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getGenerateTypeCd() == null ? other.getGenerateTypeCd() == null : this.getGenerateTypeCd().equals(other.getGenerateTypeCd()))
            && (this.getWhetherSquare() == null ? other.getWhetherSquare() == null : this.getWhetherSquare().equals(other.getWhetherSquare()))
            && (this.getContractNum() == null ? other.getContractNum() == null : this.getContractNum().equals(other.getContractNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDebtDetailinfoId() == null) ? 0 : getDebtDetailinfoId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getAcApplyId() == null) ? 0 : getAcApplyId().hashCode());
        result = prime * result + ((getClaApproveNum() == null) ? 0 : getClaApproveNum().hashCode());
        result = prime * result + ((getLoanSummaryId() == null) ? 0 : getLoanSummaryId().hashCode());
        result = prime * result + ((getCustRiskTypeCd() == null) ? 0 : getCustRiskTypeCd().hashCode());
        result = prime * result + ((getClaProperties() == null) ? 0 : getClaProperties().hashCode());
        result = prime * result + ((getClaMethod() == null) ? 0 : getClaMethod().hashCode());
        result = prime * result + ((getLastClsResult() == null) ? 0 : getLastClsResult().hashCode());
        result = prime * result + ((getLastClaMethod() == null) ? 0 : getLastClaMethod().hashCode());
        result = prime * result + ((getClsResult() == null) ? 0 : getClsResult().hashCode());
        result = prime * result + ((getAlcInfoId() == null) ? 0 : getAlcInfoId().hashCode());
        result = prime * result + ((getAldInfoId() == null) ? 0 : getAldInfoId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getGenerateTypeCd() == null) ? 0 : getGenerateTypeCd().hashCode());
        result = prime * result + ((getWhetherSquare() == null) ? 0 : getWhetherSquare().hashCode());
        result = prime * result + ((getContractNum() == null) ? 0 : getContractNum().hashCode());
        return result;
    }
}