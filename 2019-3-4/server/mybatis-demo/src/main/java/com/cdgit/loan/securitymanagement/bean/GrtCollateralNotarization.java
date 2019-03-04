package com.cdgit.loan.securitymanagement.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 抵质押物公证信息
 * @author wuyong
 * @date 2018.12.29
 *
 */
public class GrtCollateralNotarization {
    private String notarizationId;

    private String guarantyId;

    private String loanContractNum;

    private String loanManName;

    private String loanCertificateType;

    private String certificateCode;

    private String notarialDeedNo;

    private String notarialOrg;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date recordDate;

    public String getNotarizationId() {
        return notarizationId;
    }

    public void setNotarizationId(String notarizationId) {
        this.notarizationId = notarizationId == null ? null : notarizationId.trim();
    }

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getLoanContractNum() {
        return loanContractNum;
    }

    public void setLoanContractNum(String loanContractNum) {
        this.loanContractNum = loanContractNum == null ? null : loanContractNum.trim();
    }

    public String getLoanManName() {
        return loanManName;
    }

    public void setLoanManName(String loanManName) {
        this.loanManName = loanManName == null ? null : loanManName.trim();
    }

    public String getLoanCertificateType() {
        return loanCertificateType;
    }

    public void setLoanCertificateType(String loanCertificateType) {
        this.loanCertificateType = loanCertificateType == null ? null : loanCertificateType.trim();
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode == null ? null : certificateCode.trim();
    }

    public String getNotarialDeedNo() {
        return notarialDeedNo;
    }

    public void setNotarialDeedNo(String notarialDeedNo) {
        this.notarialDeedNo = notarialDeedNo == null ? null : notarialDeedNo.trim();
    }

    public String getNotarialOrg() {
        return notarialOrg;
    }

    public void setNotarialOrg(String notarialOrg) {
        this.notarialOrg = notarialOrg == null ? null : notarialOrg.trim();
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
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
        GrtCollateralNotarization other = (GrtCollateralNotarization) that;
        return (this.getNotarizationId() == null ? other.getNotarizationId() == null : this.getNotarizationId().equals(other.getNotarizationId()))
            && (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getLoanContractNum() == null ? other.getLoanContractNum() == null : this.getLoanContractNum().equals(other.getLoanContractNum()))
            && (this.getLoanManName() == null ? other.getLoanManName() == null : this.getLoanManName().equals(other.getLoanManName()))
            && (this.getLoanCertificateType() == null ? other.getLoanCertificateType() == null : this.getLoanCertificateType().equals(other.getLoanCertificateType()))
            && (this.getCertificateCode() == null ? other.getCertificateCode() == null : this.getCertificateCode().equals(other.getCertificateCode()))
            && (this.getNotarialDeedNo() == null ? other.getNotarialDeedNo() == null : this.getNotarialDeedNo().equals(other.getNotarialDeedNo()))
            && (this.getNotarialOrg() == null ? other.getNotarialOrg() == null : this.getNotarialOrg().equals(other.getNotarialOrg()))
            && (this.getRecordDate() == null ? other.getRecordDate() == null : this.getRecordDate().equals(other.getRecordDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNotarizationId() == null) ? 0 : getNotarizationId().hashCode());
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getLoanContractNum() == null) ? 0 : getLoanContractNum().hashCode());
        result = prime * result + ((getLoanManName() == null) ? 0 : getLoanManName().hashCode());
        result = prime * result + ((getLoanCertificateType() == null) ? 0 : getLoanCertificateType().hashCode());
        result = prime * result + ((getCertificateCode() == null) ? 0 : getCertificateCode().hashCode());
        result = prime * result + ((getNotarialDeedNo() == null) ? 0 : getNotarialDeedNo().hashCode());
        result = prime * result + ((getNotarialOrg() == null) ? 0 : getNotarialOrg().hashCode());
        result = prime * result + ((getRecordDate() == null) ? 0 : getRecordDate().hashCode());
        return result;
    }
}