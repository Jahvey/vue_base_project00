package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 房地产类型抵押bean
 * @author wuyong
 * @date 2019.1.3
 */
public class GrtRealEstateMortgage {
    private String guarantyId;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date constructedDate;

    private String buildingStructure;

    private String utilizationType;

    private String landAcquiringWayCd;

    private String cityLocationInd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal landArea;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal buildAllArea;

    private String circleStatus;

    private String streetDeep;

    private String streetWidth;

    private String otherStatus;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date finishDate;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal assetLife;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal totleFloor;

    private String houseLicenseInd;

    private String houseLicenseType;

    private String houseLicenseNum;

    private String houseLicenseOwner;

    private String landLicenseInd;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date landLicenseDate;

    private String landLicenseType;

    private String landLicenseNum;

    private String landLicenseOwner;

    private String landCharacter;

    private String landUseType;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal floorArea;

    private String buildingLocation;

    private String cashCapacity;

    private String isLandMortgage;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public Date getConstructedDate() {
        return constructedDate;
    }

    public void setConstructedDate(Date constructedDate) {
        this.constructedDate = constructedDate;
    }

    public String getBuildingStructure() {
        return buildingStructure;
    }

    public void setBuildingStructure(String buildingStructure) {
        this.buildingStructure = buildingStructure == null ? null : buildingStructure.trim();
    }

    public String getUtilizationType() {
        return utilizationType;
    }

    public void setUtilizationType(String utilizationType) {
        this.utilizationType = utilizationType == null ? null : utilizationType.trim();
    }

    public String getLandAcquiringWayCd() {
        return landAcquiringWayCd;
    }

    public void setLandAcquiringWayCd(String landAcquiringWayCd) {
        this.landAcquiringWayCd = landAcquiringWayCd == null ? null : landAcquiringWayCd.trim();
    }

    public String getCityLocationInd() {
        return cityLocationInd;
    }

    public void setCityLocationInd(String cityLocationInd) {
        this.cityLocationInd = cityLocationInd == null ? null : cityLocationInd.trim();
    }

    public BigDecimal getLandArea() {
        return landArea;
    }

    public void setLandArea(BigDecimal landArea) {
        this.landArea = landArea;
    }

    public BigDecimal getBuildAllArea() {
        return buildAllArea;
    }

    public void setBuildAllArea(BigDecimal buildAllArea) {
        this.buildAllArea = buildAllArea;
    }

    public String getCircleStatus() {
        return circleStatus;
    }

    public void setCircleStatus(String circleStatus) {
        this.circleStatus = circleStatus == null ? null : circleStatus.trim();
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

    public String getOtherStatus() {
        return otherStatus;
    }

    public void setOtherStatus(String otherStatus) {
        this.otherStatus = otherStatus == null ? null : otherStatus.trim();
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public BigDecimal getAssetLife() {
        return assetLife;
    }

    public void setAssetLife(BigDecimal assetLife) {
        this.assetLife = assetLife;
    }

    public BigDecimal getTotleFloor() {
        return totleFloor;
    }

    public void setTotleFloor(BigDecimal totleFloor) {
        this.totleFloor = totleFloor;
    }

    public String getHouseLicenseInd() {
        return houseLicenseInd;
    }

    public void setHouseLicenseInd(String houseLicenseInd) {
        this.houseLicenseInd = houseLicenseInd == null ? null : houseLicenseInd.trim();
    }

    public String getHouseLicenseType() {
        return houseLicenseType;
    }

    public void setHouseLicenseType(String houseLicenseType) {
        this.houseLicenseType = houseLicenseType == null ? null : houseLicenseType.trim();
    }

    public String getHouseLicenseNum() {
        return houseLicenseNum;
    }

    public void setHouseLicenseNum(String houseLicenseNum) {
        this.houseLicenseNum = houseLicenseNum == null ? null : houseLicenseNum.trim();
    }

    public String getHouseLicenseOwner() {
        return houseLicenseOwner;
    }

    public void setHouseLicenseOwner(String houseLicenseOwner) {
        this.houseLicenseOwner = houseLicenseOwner == null ? null : houseLicenseOwner.trim();
    }

    public String getLandLicenseInd() {
        return landLicenseInd;
    }

    public void setLandLicenseInd(String landLicenseInd) {
        this.landLicenseInd = landLicenseInd == null ? null : landLicenseInd.trim();
    }

    public Date getLandLicenseDate() {
        return landLicenseDate;
    }

    public void setLandLicenseDate(Date landLicenseDate) {
        this.landLicenseDate = landLicenseDate;
    }

    public String getLandLicenseType() {
        return landLicenseType;
    }

    public void setLandLicenseType(String landLicenseType) {
        this.landLicenseType = landLicenseType == null ? null : landLicenseType.trim();
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

    public String getLandCharacter() {
        return landCharacter;
    }

    public void setLandCharacter(String landCharacter) {
        this.landCharacter = landCharacter == null ? null : landCharacter.trim();
    }

    public String getLandUseType() {
        return landUseType;
    }

    public void setLandUseType(String landUseType) {
        this.landUseType = landUseType == null ? null : landUseType.trim();
    }

    public BigDecimal getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(BigDecimal floorArea) {
        this.floorArea = floorArea;
    }

    public String getBuildingLocation() {
        return buildingLocation;
    }

    public void setBuildingLocation(String buildingLocation) {
        this.buildingLocation = buildingLocation == null ? null : buildingLocation.trim();
    }

    public String getCashCapacity() {
        return cashCapacity;
    }

    public void setCashCapacity(String cashCapacity) {
        this.cashCapacity = cashCapacity == null ? null : cashCapacity.trim();
    }

    public String getIsLandMortgage() {
        return isLandMortgage;
    }

    public void setIsLandMortgage(String isLandMortgage) {
        this.isLandMortgage = isLandMortgage == null ? null : isLandMortgage.trim();
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
        GrtRealEstateMortgage other = (GrtRealEstateMortgage) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getConstructedDate() == null ? other.getConstructedDate() == null : this.getConstructedDate().equals(other.getConstructedDate()))
            && (this.getBuildingStructure() == null ? other.getBuildingStructure() == null : this.getBuildingStructure().equals(other.getBuildingStructure()))
            && (this.getUtilizationType() == null ? other.getUtilizationType() == null : this.getUtilizationType().equals(other.getUtilizationType()))
            && (this.getLandAcquiringWayCd() == null ? other.getLandAcquiringWayCd() == null : this.getLandAcquiringWayCd().equals(other.getLandAcquiringWayCd()))
            && (this.getCityLocationInd() == null ? other.getCityLocationInd() == null : this.getCityLocationInd().equals(other.getCityLocationInd()))
            && (this.getLandArea() == null ? other.getLandArea() == null : this.getLandArea().equals(other.getLandArea()))
            && (this.getBuildAllArea() == null ? other.getBuildAllArea() == null : this.getBuildAllArea().equals(other.getBuildAllArea()))
            && (this.getCircleStatus() == null ? other.getCircleStatus() == null : this.getCircleStatus().equals(other.getCircleStatus()))
            && (this.getStreetDeep() == null ? other.getStreetDeep() == null : this.getStreetDeep().equals(other.getStreetDeep()))
            && (this.getStreetWidth() == null ? other.getStreetWidth() == null : this.getStreetWidth().equals(other.getStreetWidth()))
            && (this.getOtherStatus() == null ? other.getOtherStatus() == null : this.getOtherStatus().equals(other.getOtherStatus()))
            && (this.getFinishDate() == null ? other.getFinishDate() == null : this.getFinishDate().equals(other.getFinishDate()))
            && (this.getAssetLife() == null ? other.getAssetLife() == null : this.getAssetLife().equals(other.getAssetLife()))
            && (this.getTotleFloor() == null ? other.getTotleFloor() == null : this.getTotleFloor().equals(other.getTotleFloor()))
            && (this.getHouseLicenseInd() == null ? other.getHouseLicenseInd() == null : this.getHouseLicenseInd().equals(other.getHouseLicenseInd()))
            && (this.getHouseLicenseType() == null ? other.getHouseLicenseType() == null : this.getHouseLicenseType().equals(other.getHouseLicenseType()))
            && (this.getHouseLicenseNum() == null ? other.getHouseLicenseNum() == null : this.getHouseLicenseNum().equals(other.getHouseLicenseNum()))
            && (this.getHouseLicenseOwner() == null ? other.getHouseLicenseOwner() == null : this.getHouseLicenseOwner().equals(other.getHouseLicenseOwner()))
            && (this.getLandLicenseInd() == null ? other.getLandLicenseInd() == null : this.getLandLicenseInd().equals(other.getLandLicenseInd()))
            && (this.getLandLicenseDate() == null ? other.getLandLicenseDate() == null : this.getLandLicenseDate().equals(other.getLandLicenseDate()))
            && (this.getLandLicenseType() == null ? other.getLandLicenseType() == null : this.getLandLicenseType().equals(other.getLandLicenseType()))
            && (this.getLandLicenseNum() == null ? other.getLandLicenseNum() == null : this.getLandLicenseNum().equals(other.getLandLicenseNum()))
            && (this.getLandLicenseOwner() == null ? other.getLandLicenseOwner() == null : this.getLandLicenseOwner().equals(other.getLandLicenseOwner()))
            && (this.getLandCharacter() == null ? other.getLandCharacter() == null : this.getLandCharacter().equals(other.getLandCharacter()))
            && (this.getLandUseType() == null ? other.getLandUseType() == null : this.getLandUseType().equals(other.getLandUseType()))
            && (this.getFloorArea() == null ? other.getFloorArea() == null : this.getFloorArea().equals(other.getFloorArea()))
            && (this.getBuildingLocation() == null ? other.getBuildingLocation() == null : this.getBuildingLocation().equals(other.getBuildingLocation()))
            && (this.getCashCapacity() == null ? other.getCashCapacity() == null : this.getCashCapacity().equals(other.getCashCapacity()))
            && (this.getIsLandMortgage() == null ? other.getIsLandMortgage() == null : this.getIsLandMortgage().equals(other.getIsLandMortgage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getConstructedDate() == null) ? 0 : getConstructedDate().hashCode());
        result = prime * result + ((getBuildingStructure() == null) ? 0 : getBuildingStructure().hashCode());
        result = prime * result + ((getUtilizationType() == null) ? 0 : getUtilizationType().hashCode());
        result = prime * result + ((getLandAcquiringWayCd() == null) ? 0 : getLandAcquiringWayCd().hashCode());
        result = prime * result + ((getCityLocationInd() == null) ? 0 : getCityLocationInd().hashCode());
        result = prime * result + ((getLandArea() == null) ? 0 : getLandArea().hashCode());
        result = prime * result + ((getBuildAllArea() == null) ? 0 : getBuildAllArea().hashCode());
        result = prime * result + ((getCircleStatus() == null) ? 0 : getCircleStatus().hashCode());
        result = prime * result + ((getStreetDeep() == null) ? 0 : getStreetDeep().hashCode());
        result = prime * result + ((getStreetWidth() == null) ? 0 : getStreetWidth().hashCode());
        result = prime * result + ((getOtherStatus() == null) ? 0 : getOtherStatus().hashCode());
        result = prime * result + ((getFinishDate() == null) ? 0 : getFinishDate().hashCode());
        result = prime * result + ((getAssetLife() == null) ? 0 : getAssetLife().hashCode());
        result = prime * result + ((getTotleFloor() == null) ? 0 : getTotleFloor().hashCode());
        result = prime * result + ((getHouseLicenseInd() == null) ? 0 : getHouseLicenseInd().hashCode());
        result = prime * result + ((getHouseLicenseType() == null) ? 0 : getHouseLicenseType().hashCode());
        result = prime * result + ((getHouseLicenseNum() == null) ? 0 : getHouseLicenseNum().hashCode());
        result = prime * result + ((getHouseLicenseOwner() == null) ? 0 : getHouseLicenseOwner().hashCode());
        result = prime * result + ((getLandLicenseInd() == null) ? 0 : getLandLicenseInd().hashCode());
        result = prime * result + ((getLandLicenseDate() == null) ? 0 : getLandLicenseDate().hashCode());
        result = prime * result + ((getLandLicenseType() == null) ? 0 : getLandLicenseType().hashCode());
        result = prime * result + ((getLandLicenseNum() == null) ? 0 : getLandLicenseNum().hashCode());
        result = prime * result + ((getLandLicenseOwner() == null) ? 0 : getLandLicenseOwner().hashCode());
        result = prime * result + ((getLandCharacter() == null) ? 0 : getLandCharacter().hashCode());
        result = prime * result + ((getLandUseType() == null) ? 0 : getLandUseType().hashCode());
        result = prime * result + ((getFloorArea() == null) ? 0 : getFloorArea().hashCode());
        result = prime * result + ((getBuildingLocation() == null) ? 0 : getBuildingLocation().hashCode());
        result = prime * result + ((getCashCapacity() == null) ? 0 : getCashCapacity().hashCode());
        result = prime * result + ((getIsLandMortgage() == null) ? 0 : getIsLandMortgage().hashCode());
        return result;
    }

	@Override
	public String toString() {
		return "GrtRealEstateMortgage [guarantyId=" + guarantyId + ", constructedDate=" + constructedDate
				+ ", buildingStructure=" + buildingStructure + ", utilizationType=" + utilizationType
				+ ", landAcquiringWayCd=" + landAcquiringWayCd + ", cityLocationInd=" + cityLocationInd + ", landArea="
				+ landArea + ", buildAllArea=" + buildAllArea + ", circleStatus=" + circleStatus + ", streetDeep="
				+ streetDeep + ", streetWidth=" + streetWidth + ", otherStatus=" + otherStatus + ", finishDate="
				+ finishDate + ", assetLife=" + assetLife + ", totleFloor=" + totleFloor + ", houseLicenseInd="
				+ houseLicenseInd + ", houseLicenseType=" + houseLicenseType + ", houseLicenseNum=" + houseLicenseNum
				+ ", houseLicenseOwner=" + houseLicenseOwner + ", landLicenseInd=" + landLicenseInd
				+ ", landLicenseDate=" + landLicenseDate + ", landLicenseType=" + landLicenseType + ", landLicenseNum="
				+ landLicenseNum + ", landLicenseOwner=" + landLicenseOwner + ", landCharacter=" + landCharacter
				+ ", landUseType=" + landUseType + ", floorArea=" + floorArea + ", buildingLocation=" + buildingLocation
				+ ", cashCapacity=" + cashCapacity + ", isLandMortgage=" + isLandMortgage + "]";
	}
    
}