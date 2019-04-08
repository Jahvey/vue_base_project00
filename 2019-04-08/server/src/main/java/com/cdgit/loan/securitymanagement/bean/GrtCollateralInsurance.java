package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 保险信息bean
 * @author wuyong
 * @date 2018.12.29
 *
 */
public class GrtCollateralInsurance {
    private String insuranceId;

    private String guarantyId;

    private String insuranceCompanyName;

    private String insuranceType;

    private String insurancePolicyNum;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal insuranceAmt;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date effectiveDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date endDate;

    private String insuranceTermsInstruction;

    private String insuranceBenefitiary;

    private String policyHolder;

    private String currencyCd;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date startDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date sysUpdateTime;

    private String loanmanContractNum;

    private String loanmanname;

    private String certificateType;

    private String certificateCode;

    private String insuranceKind;

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId == null ? null : insuranceId.trim();
    }

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName == null ? null : insuranceCompanyName.trim();
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType == null ? null : insuranceType.trim();
    }

    public String getInsurancePolicyNum() {
        return insurancePolicyNum;
    }

    public void setInsurancePolicyNum(String insurancePolicyNum) {
        this.insurancePolicyNum = insurancePolicyNum == null ? null : insurancePolicyNum.trim();
    }

    public BigDecimal getInsuranceAmt() {
        return insuranceAmt;
    }

    public void setInsuranceAmt(BigDecimal insuranceAmt) {
        this.insuranceAmt = insuranceAmt;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getInsuranceTermsInstruction() {
        return insuranceTermsInstruction;
    }

    public void setInsuranceTermsInstruction(String insuranceTermsInstruction) {
        this.insuranceTermsInstruction = insuranceTermsInstruction == null ? null : insuranceTermsInstruction.trim();
    }

    public String getInsuranceBenefitiary() {
        return insuranceBenefitiary;
    }

    public void setInsuranceBenefitiary(String insuranceBenefitiary) {
        this.insuranceBenefitiary = insuranceBenefitiary == null ? null : insuranceBenefitiary.trim();
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(String policyHolder) {
        this.policyHolder = policyHolder == null ? null : policyHolder.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getSysUpdateTime() {
        return sysUpdateTime;
    }

    public void setSysUpdateTime(Date sysUpdateTime) {
        this.sysUpdateTime = sysUpdateTime;
    }

    public String getLoanmanContractNum() {
        return loanmanContractNum;
    }

    public void setLoanmanContractNum(String loanmanContractNum) {
        this.loanmanContractNum = loanmanContractNum == null ? null : loanmanContractNum.trim();
    }

    public String getLoanmanname() {
        return loanmanname;
    }

    public void setLoanmanname(String loanmanname) {
        this.loanmanname = loanmanname == null ? null : loanmanname.trim();
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType == null ? null : certificateType.trim();
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode == null ? null : certificateCode.trim();
    }

    public String getInsuranceKind() {
        return insuranceKind;
    }

    public void setInsuranceKind(String insuranceKind) {
        this.insuranceKind = insuranceKind == null ? null : insuranceKind.trim();
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
        GrtCollateralInsurance other = (GrtCollateralInsurance) that;
        return (this.getInsuranceId() == null ? other.getInsuranceId() == null : this.getInsuranceId().equals(other.getInsuranceId()))
            && (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getInsuranceCompanyName() == null ? other.getInsuranceCompanyName() == null : this.getInsuranceCompanyName().equals(other.getInsuranceCompanyName()))
            && (this.getInsuranceType() == null ? other.getInsuranceType() == null : this.getInsuranceType().equals(other.getInsuranceType()))
            && (this.getInsurancePolicyNum() == null ? other.getInsurancePolicyNum() == null : this.getInsurancePolicyNum().equals(other.getInsurancePolicyNum()))
            && (this.getInsuranceAmt() == null ? other.getInsuranceAmt() == null : this.getInsuranceAmt().equals(other.getInsuranceAmt()))
            && (this.getEffectiveDate() == null ? other.getEffectiveDate() == null : this.getEffectiveDate().equals(other.getEffectiveDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getInsuranceTermsInstruction() == null ? other.getInsuranceTermsInstruction() == null : this.getInsuranceTermsInstruction().equals(other.getInsuranceTermsInstruction()))
            && (this.getInsuranceBenefitiary() == null ? other.getInsuranceBenefitiary() == null : this.getInsuranceBenefitiary().equals(other.getInsuranceBenefitiary()))
            && (this.getPolicyHolder() == null ? other.getPolicyHolder() == null : this.getPolicyHolder().equals(other.getPolicyHolder()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getSysUpdateTime() == null ? other.getSysUpdateTime() == null : this.getSysUpdateTime().equals(other.getSysUpdateTime()))
            && (this.getLoanmanContractNum() == null ? other.getLoanmanContractNum() == null : this.getLoanmanContractNum().equals(other.getLoanmanContractNum()))
            && (this.getLoanmanname() == null ? other.getLoanmanname() == null : this.getLoanmanname().equals(other.getLoanmanname()))
            && (this.getCertificateType() == null ? other.getCertificateType() == null : this.getCertificateType().equals(other.getCertificateType()))
            && (this.getCertificateCode() == null ? other.getCertificateCode() == null : this.getCertificateCode().equals(other.getCertificateCode()))
            && (this.getInsuranceKind() == null ? other.getInsuranceKind() == null : this.getInsuranceKind().equals(other.getInsuranceKind()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInsuranceId() == null) ? 0 : getInsuranceId().hashCode());
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getInsuranceCompanyName() == null) ? 0 : getInsuranceCompanyName().hashCode());
        result = prime * result + ((getInsuranceType() == null) ? 0 : getInsuranceType().hashCode());
        result = prime * result + ((getInsurancePolicyNum() == null) ? 0 : getInsurancePolicyNum().hashCode());
        result = prime * result + ((getInsuranceAmt() == null) ? 0 : getInsuranceAmt().hashCode());
        result = prime * result + ((getEffectiveDate() == null) ? 0 : getEffectiveDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getInsuranceTermsInstruction() == null) ? 0 : getInsuranceTermsInstruction().hashCode());
        result = prime * result + ((getInsuranceBenefitiary() == null) ? 0 : getInsuranceBenefitiary().hashCode());
        result = prime * result + ((getPolicyHolder() == null) ? 0 : getPolicyHolder().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getSysUpdateTime() == null) ? 0 : getSysUpdateTime().hashCode());
        result = prime * result + ((getLoanmanContractNum() == null) ? 0 : getLoanmanContractNum().hashCode());
        result = prime * result + ((getLoanmanname() == null) ? 0 : getLoanmanname().hashCode());
        result = prime * result + ((getCertificateType() == null) ? 0 : getCertificateType().hashCode());
        result = prime * result + ((getCertificateCode() == null) ? 0 : getCertificateCode().hashCode());
        result = prime * result + ((getInsuranceKind() == null) ? 0 : getInsuranceKind().hashCode());
        return result;
    }
}