package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 土地使用权bean
 * @author wuyong
 * @date 2019.1.8
 *
 */
public class GrtLandUseRight {
    private String guarantyId;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal landAcreage;

    private String landFour;

    private String streetDeep;

    private String streetWidth;

    private String circleStatus;

    private String landLicenseInd;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date licenseDate;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal useYears;

    private String landLicenseNum;

    private String landLicenseOwner;

    private String landNum;

    private String rawDegree;

    private String projectPlanLicenseInd;

    private String landCharacter;

    private String landUserType;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal patchLandMoney;

    private String signDesc;

    private String groundRemiseCd;

    private String landAcquiringWayCd;

    private String landUtilizationPurpose;

    private String cityLocationInd;

    private String isPaymentLandTransfer;

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

    public String getLandFour() {
        return landFour;
    }

    public void setLandFour(String landFour) {
        this.landFour = landFour == null ? null : landFour.trim();
    }

    public String getStreetDeep() {
        return streetDeep;
    }

    public void setStreetDeep(String streetDeep) {
        this.streetDeep = streetDeep == null ? null : streetDeep.trim();
    }

    public String getStreetWidth() {
        return streetWidth;
    }

    public void setStreetWidth(String streetWidth) {
        this.streetWidth = streetWidth == null ? null : streetWidth.trim();
    }

    public String getCircleStatus() {
        return circleStatus;
    }

    public void setCircleStatus(String circleStatus) {
        this.circleStatus = circleStatus == null ? null : circleStatus.trim();
    }

    public String getLandLicenseInd() {
        return landLicenseInd;
    }

    public void setLandLicenseInd(String landLicenseInd) {
        this.landLicenseInd = landLicenseInd == null ? null : landLicenseInd.trim();
    }

    public Date getLicenseDate() {
        return licenseDate;
    }

    public void setLicenseDate(Date licenseDate) {
        this.licenseDate = licenseDate;
    }

    public BigDecimal getUseYears() {
        return useYears;
    }

    public void setUseYears(BigDecimal useYears) {
        this.useYears = useYears;
    }

    public String getLandLicenseNum() {
        return landLicenseNum;
    }

    public void setLandLicenseNum(String landLicenseNum) {
        this.landLicenseNum = landLicenseNum == null ? null : landLicenseNum.trim();
    }

    public String getLandLicenseOwner() {
        return landLicenseOwner;
    }

    public void setLandLicenseOwner(String landLicenseOwner) {
        this.landLicenseOwner = landLicenseOwner == null ? null : landLicenseOwner.trim();
    }

    public String getLandNum() {
        return landNum;
    }

    public void setLandNum(String landNum) {
        this.landNum = landNum == null ? null : landNum.trim();
    }

    public String getRawDegree() {
        return rawDegree;
    }

    public void setRawDegree(String rawDegree) {
        this.rawDegree = rawDegree == null ? null : rawDegree.trim();
    }

    public String getProjectPlanLicenseInd() {
        return projectPlanLicenseInd;
    }

    public void setProjectPlanLicenseInd(String projectPlanLicenseInd) {
        this.projectPlanLicenseInd = projectPlanLicenseInd == null ? null : projectPlanLicenseInd.trim();
    }

    public String getLandCharacter() {
        return landCharacter;
    }

    public void setLandCharacter(String landCharacter) {
        this.landCharacter = landCharacter == null ? null : landCharacter.trim();
    }

    public String getLandUserType() {
        return landUserType;
    }

    public void setLandUserType(String landUserType) {
        this.landUserType = landUserType == null ? null : landUserType.trim();
    }

    public BigDecimal getPatchLandMoney() {
        return patchLandMoney;
    }

    public void setPatchLandMoney(BigDecimal patchLandMoney) {
        this.patchLandMoney = patchLandMoney;
    }

    public String getSignDesc() {
        return signDesc;
    }

    public void setSignDesc(String signDesc) {
        this.signDesc = signDesc == null ? null : signDesc.trim();
    }

    public String getGroundRemiseCd() {
        return groundRemiseCd;
    }

    public void setGroundRemiseCd(String groundRemiseCd) {
        this.groundRemiseCd = groundRemiseCd == null ? null : groundRemiseCd.trim();
    }

    public String getLandAcquiringWayCd() {
        return landAcquiringWayCd;
    }

    public void setLandAcquiringWayCd(String landAcquiringWayCd) {
        this.landAcquiringWayCd = landAcquiringWayCd == null ? null : landAcquiringWayCd.trim();
    }

    public String getLandUtilizationPurpose() {
        return landUtilizationPurpose;
    }

    public void setLandUtilizationPurpose(String landUtilizationPurpose) {
        this.landUtilizationPurpose = landUtilizationPurpose == null ? null : landUtilizationPurpose.trim();
    }

    public String getCityLocationInd() {
        return cityLocationInd;
    }

    public void setCityLocationInd(String cityLocationInd) {
        this.cityLocationInd = cityLocationInd == null ? null : cityLocationInd.trim();
    }

    public String getIsPaymentLandTransfer() {
        return isPaymentLandTransfer;
    }

    public void setIsPaymentLandTransfer(String isPaymentLandTransfer) {
        this.isPaymentLandTransfer = isPaymentLandTransfer == null ? null : isPaymentLandTransfer.trim();
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
        GrtLandUseRight other = (GrtLandUseRight) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getLandAcreage() == null ? other.getLandAcreage() == null : this.getLandAcreage().equals(other.getLandAcreage()))
            && (this.getLandFour() == null ? other.getLandFour() == null : this.getLandFour().equals(other.getLandFour()))
            && (this.getStreetDeep() == null ? other.getStreetDeep() == null : this.getStreetDeep().equals(other.getStreetDeep()))
            && (this.getStreetWidth() == null ? other.getStreetWidth() == null : this.getStreetWidth().equals(other.getStreetWidth()))
            && (this.getCircleStatus() == null ? other.getCircleStatus() == null : this.getCircleStatus().equals(other.getCircleStatus()))
            && (this.getLandLicenseInd() == null ? other.getLandLicenseInd() == null : this.getLandLicenseInd().equals(other.getLandLicenseInd()))
            && (this.getLicenseDate() == null ? other.getLicenseDate() == null : this.getLicenseDate().equals(other.getLicenseDate()))
            && (this.getUseYears() == null ? other.getUseYears() == null : this.getUseYears().equals(other.getUseYears()))
            && (this.getLandLicenseNum() == null ? other.getLandLicenseNum() == null : this.getLandLicenseNum().equals(other.getLandLicenseNum()))
            && (this.getLandLicenseOwner() == null ? other.getLandLicenseOwner() == null : this.getLandLicenseOwner().equals(other.getLandLicenseOwner()))
            && (this.getLandNum() == null ? other.getLandNum() == null : this.getLandNum().equals(other.getLandNum()))
            && (this.getRawDegree() == null ? other.getRawDegree() == null : this.getRawDegree().equals(other.getRawDegree()))
            && (this.getProjectPlanLicenseInd() == null ? other.getProjectPlanLicenseInd() == null : this.getProjectPlanLicenseInd().equals(other.getProjectPlanLicenseInd()))
            && (this.getLandCharacter() == null ? other.getLandCharacter() == null : this.getLandCharacter().equals(other.getLandCharacter()))
            && (this.getLandUserType() == null ? other.getLandUserType() == null : this.getLandUserType().equals(other.getLandUserType()))
            && (this.getPatchLandMoney() == null ? other.getPatchLandMoney() == null : this.getPatchLandMoney().equals(other.getPatchLandMoney()))
            && (this.getSignDesc() == null ? other.getSignDesc() == null : this.getSignDesc().equals(other.getSignDesc()))
            && (this.getGroundRemiseCd() == null ? other.getGroundRemiseCd() == null : this.getGroundRemiseCd().equals(other.getGroundRemiseCd()))
            && (this.getLandAcquiringWayCd() == null ? other.getLandAcquiringWayCd() == null : this.getLandAcquiringWayCd().equals(other.getLandAcquiringWayCd()))
            && (this.getLandUtilizationPurpose() == null ? other.getLandUtilizationPurpose() == null : this.getLandUtilizationPurpose().equals(other.getLandUtilizationPurpose()))
            && (this.getCityLocationInd() == null ? other.getCityLocationInd() == null : this.getCityLocationInd().equals(other.getCityLocationInd()))
            && (this.getIsPaymentLandTransfer() == null ? other.getIsPaymentLandTransfer() == null : this.getIsPaymentLandTransfer().equals(other.getIsPaymentLandTransfer()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getLandAcreage() == null) ? 0 : getLandAcreage().hashCode());
        result = prime * result + ((getLandFour() == null) ? 0 : getLandFour().hashCode());
        result = prime * result + ((getStreetDeep() == null) ? 0 : getStreetDeep().hashCode());
        result = prime * result + ((getStreetWidth() == null) ? 0 : getStreetWidth().hashCode());
        result = prime * result + ((getCircleStatus() == null) ? 0 : getCircleStatus().hashCode());
        result = prime * result + ((getLandLicenseInd() == null) ? 0 : getLandLicenseInd().hashCode());
        result = prime * result + ((getLicenseDate() == null) ? 0 : getLicenseDate().hashCode());
        result = prime * result + ((getUseYears() == null) ? 0 : getUseYears().hashCode());
        result = prime * result + ((getLandLicenseNum() == null) ? 0 : getLandLicenseNum().hashCode());
        result = prime * result + ((getLandLicenseOwner() == null) ? 0 : getLandLicenseOwner().hashCode());
        result = prime * result + ((getLandNum() == null) ? 0 : getLandNum().hashCode());
        result = prime * result + ((getRawDegree() == null) ? 0 : getRawDegree().hashCode());
        result = prime * result + ((getProjectPlanLicenseInd() == null) ? 0 : getProjectPlanLicenseInd().hashCode());
        result = prime * result + ((getLandCharacter() == null) ? 0 : getLandCharacter().hashCode());
        result = prime * result + ((getLandUserType() == null) ? 0 : getLandUserType().hashCode());
        result = prime * result + ((getPatchLandMoney() == null) ? 0 : getPatchLandMoney().hashCode());
        result = prime * result + ((getSignDesc() == null) ? 0 : getSignDesc().hashCode());
        result = prime * result + ((getGroundRemiseCd() == null) ? 0 : getGroundRemiseCd().hashCode());
        result = prime * result + ((getLandAcquiringWayCd() == null) ? 0 : getLandAcquiringWayCd().hashCode());
        result = prime * result + ((getLandUtilizationPurpose() == null) ? 0 : getLandUtilizationPurpose().hashCode());
        result = prime * result + ((getCityLocationInd() == null) ? 0 : getCityLocationInd().hashCode());
        result = prime * result + ((getIsPaymentLandTransfer() == null) ? 0 : getIsPaymentLandTransfer().hashCode());
        return result;
    }
}