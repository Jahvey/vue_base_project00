package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.common.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 仪器社备bean
 * @author wuyong
 * @date 2019.1.10
 *
 */
public class GrtMachineEquipment {
    private String guarantyId;

    private String secondhandInd;

    private String equipmentName;

    private String modelType;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal power;

    private String powerUnitCd;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date manufactureDate;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal utilizedYears;

    private String purpose;

    private String fuel;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal equipMount;

    private String equipMountUnitCd;

    private String manufacture;

    private String produceArea;

    private String eliLicenseInd;

    private String safeCheckInd;

    private String fireCheckInd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal deviceUseLife;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal bigRepairTimes;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal oriPurPrice;

    private String obtainMode;

    private String equipmentType;

    private String useType;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal newRate;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getSecondhandInd() {
        return secondhandInd;
    }

    public void setSecondhandInd(String secondhandInd) {
        this.secondhandInd = secondhandInd == null ? null : secondhandInd.trim();
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType == null ? null : modelType.trim();
    }

    public BigDecimal getPower() {
        return power;
    }

    public void setPower(BigDecimal power) {
        this.power = power;
    }

    public String getPowerUnitCd() {
        return powerUnitCd;
    }

    public void setPowerUnitCd(String powerUnitCd) {
        this.powerUnitCd = powerUnitCd == null ? null : powerUnitCd.trim();
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public BigDecimal getUtilizedYears() {
        return utilizedYears;
    }

    public void setUtilizedYears(BigDecimal utilizedYears) {
        this.utilizedYears = utilizedYears;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel == null ? null : fuel.trim();
    }

    public BigDecimal getEquipMount() {
        return equipMount;
    }

    public void setEquipMount(BigDecimal equipMount) {
        this.equipMount = equipMount;
    }

    public String getEquipMountUnitCd() {
        return equipMountUnitCd;
    }

    public void setEquipMountUnitCd(String equipMountUnitCd) {
        this.equipMountUnitCd = equipMountUnitCd == null ? null : equipMountUnitCd.trim();
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture == null ? null : manufacture.trim();
    }

    public String getProduceArea() {
        return produceArea;
    }

    public void setProduceArea(String produceArea) {
        this.produceArea = produceArea == null ? null : produceArea.trim();
    }

    public String getEliLicenseInd() {
        return eliLicenseInd;
    }

    public void setEliLicenseInd(String eliLicenseInd) {
        this.eliLicenseInd = eliLicenseInd == null ? null : eliLicenseInd.trim();
    }

    public String getSafeCheckInd() {
        return safeCheckInd;
    }

    public void setSafeCheckInd(String safeCheckInd) {
        this.safeCheckInd = safeCheckInd == null ? null : safeCheckInd.trim();
    }

    public String getFireCheckInd() {
        return fireCheckInd;
    }

    public void setFireCheckInd(String fireCheckInd) {
        this.fireCheckInd = fireCheckInd == null ? null : fireCheckInd.trim();
    }

    public BigDecimal getDeviceUseLife() {
        return deviceUseLife;
    }

    public void setDeviceUseLife(BigDecimal deviceUseLife) {
        this.deviceUseLife = deviceUseLife;
    }

    public BigDecimal getBigRepairTimes() {
        return bigRepairTimes;
    }

    public void setBigRepairTimes(BigDecimal bigRepairTimes) {
        this.bigRepairTimes = bigRepairTimes;
    }

    public BigDecimal getOriPurPrice() {
        return oriPurPrice;
    }

    public void setOriPurPrice(BigDecimal oriPurPrice) {
        this.oriPurPrice = oriPurPrice;
    }

    public String getObtainMode() {
        return obtainMode;
    }

    public void setObtainMode(String obtainMode) {
        this.obtainMode = obtainMode == null ? null : obtainMode.trim();
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType == null ? null : equipmentType.trim();
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType == null ? null : useType.trim();
    }

    public BigDecimal getNewRate() {
        return newRate;
    }

    public void setNewRate(BigDecimal newRate) {
        this.newRate = newRate;
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
        GrtMachineEquipment other = (GrtMachineEquipment) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getSecondhandInd() == null ? other.getSecondhandInd() == null : this.getSecondhandInd().equals(other.getSecondhandInd()))
            && (this.getEquipmentName() == null ? other.getEquipmentName() == null : this.getEquipmentName().equals(other.getEquipmentName()))
            && (this.getModelType() == null ? other.getModelType() == null : this.getModelType().equals(other.getModelType()))
            && (this.getPower() == null ? other.getPower() == null : this.getPower().equals(other.getPower()))
            && (this.getPowerUnitCd() == null ? other.getPowerUnitCd() == null : this.getPowerUnitCd().equals(other.getPowerUnitCd()))
            && (this.getManufactureDate() == null ? other.getManufactureDate() == null : this.getManufactureDate().equals(other.getManufactureDate()))
            && (this.getUtilizedYears() == null ? other.getUtilizedYears() == null : this.getUtilizedYears().equals(other.getUtilizedYears()))
            && (this.getPurpose() == null ? other.getPurpose() == null : this.getPurpose().equals(other.getPurpose()))
            && (this.getFuel() == null ? other.getFuel() == null : this.getFuel().equals(other.getFuel()))
            && (this.getEquipMount() == null ? other.getEquipMount() == null : this.getEquipMount().equals(other.getEquipMount()))
            && (this.getEquipMountUnitCd() == null ? other.getEquipMountUnitCd() == null : this.getEquipMountUnitCd().equals(other.getEquipMountUnitCd()))
            && (this.getManufacture() == null ? other.getManufacture() == null : this.getManufacture().equals(other.getManufacture()))
            && (this.getProduceArea() == null ? other.getProduceArea() == null : this.getProduceArea().equals(other.getProduceArea()))
            && (this.getEliLicenseInd() == null ? other.getEliLicenseInd() == null : this.getEliLicenseInd().equals(other.getEliLicenseInd()))
            && (this.getSafeCheckInd() == null ? other.getSafeCheckInd() == null : this.getSafeCheckInd().equals(other.getSafeCheckInd()))
            && (this.getFireCheckInd() == null ? other.getFireCheckInd() == null : this.getFireCheckInd().equals(other.getFireCheckInd()))
            && (this.getDeviceUseLife() == null ? other.getDeviceUseLife() == null : this.getDeviceUseLife().equals(other.getDeviceUseLife()))
            && (this.getBigRepairTimes() == null ? other.getBigRepairTimes() == null : this.getBigRepairTimes().equals(other.getBigRepairTimes()))
            && (this.getOriPurPrice() == null ? other.getOriPurPrice() == null : this.getOriPurPrice().equals(other.getOriPurPrice()))
            && (this.getObtainMode() == null ? other.getObtainMode() == null : this.getObtainMode().equals(other.getObtainMode()))
            && (this.getEquipmentType() == null ? other.getEquipmentType() == null : this.getEquipmentType().equals(other.getEquipmentType()))
            && (this.getUseType() == null ? other.getUseType() == null : this.getUseType().equals(other.getUseType()))
            && (this.getNewRate() == null ? other.getNewRate() == null : this.getNewRate().equals(other.getNewRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getSecondhandInd() == null) ? 0 : getSecondhandInd().hashCode());
        result = prime * result + ((getEquipmentName() == null) ? 0 : getEquipmentName().hashCode());
        result = prime * result + ((getModelType() == null) ? 0 : getModelType().hashCode());
        result = prime * result + ((getPower() == null) ? 0 : getPower().hashCode());
        result = prime * result + ((getPowerUnitCd() == null) ? 0 : getPowerUnitCd().hashCode());
        result = prime * result + ((getManufactureDate() == null) ? 0 : getManufactureDate().hashCode());
        result = prime * result + ((getUtilizedYears() == null) ? 0 : getUtilizedYears().hashCode());
        result = prime * result + ((getPurpose() == null) ? 0 : getPurpose().hashCode());
        result = prime * result + ((getFuel() == null) ? 0 : getFuel().hashCode());
        result = prime * result + ((getEquipMount() == null) ? 0 : getEquipMount().hashCode());
        result = prime * result + ((getEquipMountUnitCd() == null) ? 0 : getEquipMountUnitCd().hashCode());
        result = prime * result + ((getManufacture() == null) ? 0 : getManufacture().hashCode());
        result = prime * result + ((getProduceArea() == null) ? 0 : getProduceArea().hashCode());
        result = prime * result + ((getEliLicenseInd() == null) ? 0 : getEliLicenseInd().hashCode());
        result = prime * result + ((getSafeCheckInd() == null) ? 0 : getSafeCheckInd().hashCode());
        result = prime * result + ((getFireCheckInd() == null) ? 0 : getFireCheckInd().hashCode());
        result = prime * result + ((getDeviceUseLife() == null) ? 0 : getDeviceUseLife().hashCode());
        result = prime * result + ((getBigRepairTimes() == null) ? 0 : getBigRepairTimes().hashCode());
        result = prime * result + ((getOriPurPrice() == null) ? 0 : getOriPurPrice().hashCode());
        result = prime * result + ((getObtainMode() == null) ? 0 : getObtainMode().hashCode());
        result = prime * result + ((getEquipmentType() == null) ? 0 : getEquipmentType().hashCode());
        result = prime * result + ((getUseType() == null) ? 0 : getUseType().hashCode());
        result = prime * result + ((getNewRate() == null) ? 0 : getNewRate().hashCode());
        return result;
    }
}