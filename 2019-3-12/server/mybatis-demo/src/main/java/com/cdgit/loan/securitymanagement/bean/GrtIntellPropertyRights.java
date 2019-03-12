package com.cdgit.loan.securitymanagement.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 知识产权bean
 * @author wuyong
 * @date 2019.1.9
 *
 */
public class GrtIntellPropertyRights {
    private String guarantyId;

    private String propertyRightNature;

    private String brandType;

    private String productClass;

    private String patentType;

    private String patentPurpose;

    private String licenseOwner;

    private String publishedYear;

    private String productionType;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date procetedDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date checkedDate;

    private String licenseName;

    private String licenseNum;

    private String licenseDepartment;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getPropertyRightNature() {
        return propertyRightNature;
    }

    public void setPropertyRightNature(String propertyRightNature) {
        this.propertyRightNature = propertyRightNature == null ? null : propertyRightNature.trim();
    }

    public String getBrandType() {
        return brandType;
    }

    public void setBrandType(String brandType) {
        this.brandType = brandType == null ? null : brandType.trim();
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass == null ? null : productClass.trim();
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType == null ? null : patentType.trim();
    }

    public String getPatentPurpose() {
        return patentPurpose;
    }

    public void setPatentPurpose(String patentPurpose) {
        this.patentPurpose = patentPurpose == null ? null : patentPurpose.trim();
    }

    public String getLicenseOwner() {
        return licenseOwner;
    }

    public void setLicenseOwner(String licenseOwner) {
        this.licenseOwner = licenseOwner == null ? null : licenseOwner.trim();
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear == null ? null : publishedYear.trim();
    }

    public String getProductionType() {
        return productionType;
    }

    public void setProductionType(String productionType) {
        this.productionType = productionType == null ? null : productionType.trim();
    }

    public Date getProcetedDate() {
        return procetedDate;
    }

    public void setProcetedDate(Date procetedDate) {
        this.procetedDate = procetedDate;
    }

    public Date getCheckedDate() {
        return checkedDate;
    }

    public void setCheckedDate(Date checkedDate) {
        this.checkedDate = checkedDate;
    }

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName == null ? null : licenseName.trim();
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum == null ? null : licenseNum.trim();
    }

    public String getLicenseDepartment() {
        return licenseDepartment;
    }

    public void setLicenseDepartment(String licenseDepartment) {
        this.licenseDepartment = licenseDepartment == null ? null : licenseDepartment.trim();
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
        GrtIntellPropertyRights other = (GrtIntellPropertyRights) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getPropertyRightNature() == null ? other.getPropertyRightNature() == null : this.getPropertyRightNature().equals(other.getPropertyRightNature()))
            && (this.getBrandType() == null ? other.getBrandType() == null : this.getBrandType().equals(other.getBrandType()))
            && (this.getProductClass() == null ? other.getProductClass() == null : this.getProductClass().equals(other.getProductClass()))
            && (this.getPatentType() == null ? other.getPatentType() == null : this.getPatentType().equals(other.getPatentType()))
            && (this.getPatentPurpose() == null ? other.getPatentPurpose() == null : this.getPatentPurpose().equals(other.getPatentPurpose()))
            && (this.getLicenseOwner() == null ? other.getLicenseOwner() == null : this.getLicenseOwner().equals(other.getLicenseOwner()))
            && (this.getPublishedYear() == null ? other.getPublishedYear() == null : this.getPublishedYear().equals(other.getPublishedYear()))
            && (this.getProductionType() == null ? other.getProductionType() == null : this.getProductionType().equals(other.getProductionType()))
            && (this.getProcetedDate() == null ? other.getProcetedDate() == null : this.getProcetedDate().equals(other.getProcetedDate()))
            && (this.getCheckedDate() == null ? other.getCheckedDate() == null : this.getCheckedDate().equals(other.getCheckedDate()))
            && (this.getLicenseName() == null ? other.getLicenseName() == null : this.getLicenseName().equals(other.getLicenseName()))
            && (this.getLicenseNum() == null ? other.getLicenseNum() == null : this.getLicenseNum().equals(other.getLicenseNum()))
            && (this.getLicenseDepartment() == null ? other.getLicenseDepartment() == null : this.getLicenseDepartment().equals(other.getLicenseDepartment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getPropertyRightNature() == null) ? 0 : getPropertyRightNature().hashCode());
        result = prime * result + ((getBrandType() == null) ? 0 : getBrandType().hashCode());
        result = prime * result + ((getProductClass() == null) ? 0 : getProductClass().hashCode());
        result = prime * result + ((getPatentType() == null) ? 0 : getPatentType().hashCode());
        result = prime * result + ((getPatentPurpose() == null) ? 0 : getPatentPurpose().hashCode());
        result = prime * result + ((getLicenseOwner() == null) ? 0 : getLicenseOwner().hashCode());
        result = prime * result + ((getPublishedYear() == null) ? 0 : getPublishedYear().hashCode());
        result = prime * result + ((getProductionType() == null) ? 0 : getProductionType().hashCode());
        result = prime * result + ((getProcetedDate() == null) ? 0 : getProcetedDate().hashCode());
        result = prime * result + ((getCheckedDate() == null) ? 0 : getCheckedDate().hashCode());
        result = prime * result + ((getLicenseName() == null) ? 0 : getLicenseName().hashCode());
        result = prime * result + ((getLicenseNum() == null) ? 0 : getLicenseNum().hashCode());
        result = prime * result + ((getLicenseDepartment() == null) ? 0 : getLicenseDepartment().hashCode());
        return result;
    }
}