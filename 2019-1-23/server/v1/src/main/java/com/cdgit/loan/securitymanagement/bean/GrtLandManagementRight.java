package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.common.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 土地经营权bean
 * @author wuyong
 * @date 2019.1.8
 *
 */
public class GrtLandManagementRight {
    private String guarantyId;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal landAcreage;

    private String circleStatus;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date contractStartDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date contractEndDate;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal annualCharge;

    private String landUtilizationPurpose;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date expirateDate;

    private String landAcquiringWayCd;

    private String groundRemiseCd;

    private String signDesc;

    private String managementTypeCd;

    private String managementSizeCd;

    private String licenseOwner;

    private String managementStatus;

    private String landBusinessNature;

    private String contractFeesPayMethod;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date contractFeesDueDate;

    private String landUseStatus;

    private String landUseNature;

    private String contractFeesPaySituation;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public BigDecimal getLandAcreage() {
        return landAcreage;
    }

    public void setLandAcreage(BigDecimal landAcreage) {
        this.landAcreage = landAcreage;
    }

    public String getCircleStatus() {
        return circleStatus;
    }

    public void setCircleStatus(String circleStatus) {
        this.circleStatus = circleStatus == null ? null : circleStatus.trim();
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public BigDecimal getAnnualCharge() {
        return annualCharge;
    }

    public void setAnnualCharge(BigDecimal annualCharge) {
        this.annualCharge = annualCharge;
    }

    public String getLandUtilizationPurpose() {
        return landUtilizationPurpose;
    }

    public void setLandUtilizationPurpose(String landUtilizationPurpose) {
        this.landUtilizationPurpose = landUtilizationPurpose == null ? null : landUtilizationPurpose.trim();
    }

    public Date getExpirateDate() {
        return expirateDate;
    }

    public void setExpirateDate(Date expirateDate) {
        this.expirateDate = expirateDate;
    }

    public String getLandAcquiringWayCd() {
        return landAcquiringWayCd;
    }

    public void setLandAcquiringWayCd(String landAcquiringWayCd) {
        this.landAcquiringWayCd = landAcquiringWayCd == null ? null : landAcquiringWayCd.trim();
    }

    public String getGroundRemiseCd() {
        return groundRemiseCd;
    }

    public void setGroundRemiseCd(String groundRemiseCd) {
        this.groundRemiseCd = groundRemiseCd == null ? null : groundRemiseCd.trim();
    }

    public String getSignDesc() {
        return signDesc;
    }

    public void setSignDesc(String signDesc) {
        this.signDesc = signDesc == null ? null : signDesc.trim();
    }

    public String getManagementTypeCd() {
        return managementTypeCd;
    }

    public void setManagementTypeCd(String managementTypeCd) {
        this.managementTypeCd = managementTypeCd == null ? null : managementTypeCd.trim();
    }

    public String getManagementSizeCd() {
        return managementSizeCd;
    }

    public void setManagementSizeCd(String managementSizeCd) {
        this.managementSizeCd = managementSizeCd == null ? null : managementSizeCd.trim();
    }

    public String getLicenseOwner() {
        return licenseOwner;
    }

    public void setLicenseOwner(String licenseOwner) {
        this.licenseOwner = licenseOwner == null ? null : licenseOwner.trim();
    }

    public String getManagementStatus() {
        return managementStatus;
    }

    public void setManagementStatus(String managementStatus) {
        this.managementStatus = managementStatus == null ? null : managementStatus.trim();
    }

    public String getLandBusinessNature() {
        return landBusinessNature;
    }

    public void setLandBusinessNature(String landBusinessNature) {
        this.landBusinessNature = landBusinessNature == null ? null : landBusinessNature.trim();
    }

    public String getContractFeesPayMethod() {
        return contractFeesPayMethod;
    }

    public void setContractFeesPayMethod(String contractFeesPayMethod) {
        this.contractFeesPayMethod = contractFeesPayMethod == null ? null : contractFeesPayMethod.trim();
    }

    public Date getContractFeesDueDate() {
        return contractFeesDueDate;
    }

    public void setContractFeesDueDate(Date contractFeesDueDate) {
        this.contractFeesDueDate = contractFeesDueDate;
    }

    public String getLandUseStatus() {
        return landUseStatus;
    }

    public void setLandUseStatus(String landUseStatus) {
        this.landUseStatus = landUseStatus == null ? null : landUseStatus.trim();
    }

    public String getLandUseNature() {
        return landUseNature;
    }

    public void setLandUseNature(String landUseNature) {
        this.landUseNature = landUseNature == null ? null : landUseNature.trim();
    }

    public String getContractFeesPaySituation() {
        return contractFeesPaySituation;
    }

    public void setContractFeesPaySituation(String contractFeesPaySituation) {
        this.contractFeesPaySituation = contractFeesPaySituation == null ? null : contractFeesPaySituation.trim();
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
        GrtLandManagementRight other = (GrtLandManagementRight) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getLandAcreage() == null ? other.getLandAcreage() == null : this.getLandAcreage().equals(other.getLandAcreage()))
            && (this.getCircleStatus() == null ? other.getCircleStatus() == null : this.getCircleStatus().equals(other.getCircleStatus()))
            && (this.getContractStartDate() == null ? other.getContractStartDate() == null : this.getContractStartDate().equals(other.getContractStartDate()))
            && (this.getContractEndDate() == null ? other.getContractEndDate() == null : this.getContractEndDate().equals(other.getContractEndDate()))
            && (this.getAnnualCharge() == null ? other.getAnnualCharge() == null : this.getAnnualCharge().equals(other.getAnnualCharge()))
            && (this.getLandUtilizationPurpose() == null ? other.getLandUtilizationPurpose() == null : this.getLandUtilizationPurpose().equals(other.getLandUtilizationPurpose()))
            && (this.getExpirateDate() == null ? other.getExpirateDate() == null : this.getExpirateDate().equals(other.getExpirateDate()))
            && (this.getLandAcquiringWayCd() == null ? other.getLandAcquiringWayCd() == null : this.getLandAcquiringWayCd().equals(other.getLandAcquiringWayCd()))
            && (this.getGroundRemiseCd() == null ? other.getGroundRemiseCd() == null : this.getGroundRemiseCd().equals(other.getGroundRemiseCd()))
            && (this.getSignDesc() == null ? other.getSignDesc() == null : this.getSignDesc().equals(other.getSignDesc()))
            && (this.getManagementTypeCd() == null ? other.getManagementTypeCd() == null : this.getManagementTypeCd().equals(other.getManagementTypeCd()))
            && (this.getManagementSizeCd() == null ? other.getManagementSizeCd() == null : this.getManagementSizeCd().equals(other.getManagementSizeCd()))
            && (this.getLicenseOwner() == null ? other.getLicenseOwner() == null : this.getLicenseOwner().equals(other.getLicenseOwner()))
            && (this.getManagementStatus() == null ? other.getManagementStatus() == null : this.getManagementStatus().equals(other.getManagementStatus()))
            && (this.getLandBusinessNature() == null ? other.getLandBusinessNature() == null : this.getLandBusinessNature().equals(other.getLandBusinessNature()))
            && (this.getContractFeesPayMethod() == null ? other.getContractFeesPayMethod() == null : this.getContractFeesPayMethod().equals(other.getContractFeesPayMethod()))
            && (this.getContractFeesDueDate() == null ? other.getContractFeesDueDate() == null : this.getContractFeesDueDate().equals(other.getContractFeesDueDate()))
            && (this.getLandUseStatus() == null ? other.getLandUseStatus() == null : this.getLandUseStatus().equals(other.getLandUseStatus()))
            && (this.getLandUseNature() == null ? other.getLandUseNature() == null : this.getLandUseNature().equals(other.getLandUseNature()))
            && (this.getContractFeesPaySituation() == null ? other.getContractFeesPaySituation() == null : this.getContractFeesPaySituation().equals(other.getContractFeesPaySituation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getLandAcreage() == null) ? 0 : getLandAcreage().hashCode());
        result = prime * result + ((getCircleStatus() == null) ? 0 : getCircleStatus().hashCode());
        result = prime * result + ((getContractStartDate() == null) ? 0 : getContractStartDate().hashCode());
        result = prime * result + ((getContractEndDate() == null) ? 0 : getContractEndDate().hashCode());
        result = prime * result + ((getAnnualCharge() == null) ? 0 : getAnnualCharge().hashCode());
        result = prime * result + ((getLandUtilizationPurpose() == null) ? 0 : getLandUtilizationPurpose().hashCode());
        result = prime * result + ((getExpirateDate() == null) ? 0 : getExpirateDate().hashCode());
        result = prime * result + ((getLandAcquiringWayCd() == null) ? 0 : getLandAcquiringWayCd().hashCode());
        result = prime * result + ((getGroundRemiseCd() == null) ? 0 : getGroundRemiseCd().hashCode());
        result = prime * result + ((getSignDesc() == null) ? 0 : getSignDesc().hashCode());
        result = prime * result + ((getManagementTypeCd() == null) ? 0 : getManagementTypeCd().hashCode());
        result = prime * result + ((getManagementSizeCd() == null) ? 0 : getManagementSizeCd().hashCode());
        result = prime * result + ((getLicenseOwner() == null) ? 0 : getLicenseOwner().hashCode());
        result = prime * result + ((getManagementStatus() == null) ? 0 : getManagementStatus().hashCode());
        result = prime * result + ((getLandBusinessNature() == null) ? 0 : getLandBusinessNature().hashCode());
        result = prime * result + ((getContractFeesPayMethod() == null) ? 0 : getContractFeesPayMethod().hashCode());
        result = prime * result + ((getContractFeesDueDate() == null) ? 0 : getContractFeesDueDate().hashCode());
        result = prime * result + ((getLandUseStatus() == null) ? 0 : getLandUseStatus().hashCode());
        result = prime * result + ((getLandUseNature() == null) ? 0 : getLandUseNature().hashCode());
        result = prime * result + ((getContractFeesPaySituation() == null) ? 0 : getContractFeesPaySituation().hashCode());
        return result;
    }
}