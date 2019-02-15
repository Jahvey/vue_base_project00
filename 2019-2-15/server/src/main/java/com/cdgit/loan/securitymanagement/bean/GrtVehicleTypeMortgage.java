package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 交通运输设备Bean
 * @author wuyong
 * @date 2019.1.7
 *
 */
public class GrtVehicleTypeMortgage {
    private String guarantyId;

    private String vehicleLicenseNum;

    private String vehicleName;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal carryingCapacity;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal power;

    private String manufacturingYear;

    private String manufacturingCompany;

    private String powerUnitCd;

    private String manufacturingPlace;

    private String modelStyle;

    private String bigRepairTimes;

    private String troubleRecords;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal usedYear;

    private String vehicleType;

    private String bearAbility;

    private String storePlace;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal depreciationValue;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal depreciationRestValue;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal carAge;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date purchaseYear;

    private String carBrand;

    private String carType;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date rejectYear;

    private String trafficCurrencyCd;

    private String engineNum;

    private String hasOperationCertificate;

    private String operationCertificateOrg;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getVehicleLicenseNum() {
        return vehicleLicenseNum;
    }

    public void setVehicleLicenseNum(String vehicleLicenseNum) {
        this.vehicleLicenseNum = vehicleLicenseNum == null ? null : vehicleLicenseNum.trim();
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName == null ? null : vehicleName.trim();
    }

    public BigDecimal getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(BigDecimal carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public BigDecimal getPower() {
        return power;
    }

    public void setPower(BigDecimal power) {
        this.power = power;
    }

    public String getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(String manufacturingYear) {
        this.manufacturingYear = manufacturingYear == null ? null : manufacturingYear.trim();
    }

    public String getManufacturingCompany() {
        return manufacturingCompany;
    }

    public void setManufacturingCompany(String manufacturingCompany) {
        this.manufacturingCompany = manufacturingCompany == null ? null : manufacturingCompany.trim();
    }

    public String getPowerUnitCd() {
        return powerUnitCd;
    }

    public void setPowerUnitCd(String powerUnitCd) {
        this.powerUnitCd = powerUnitCd == null ? null : powerUnitCd.trim();
    }

    public String getManufacturingPlace() {
        return manufacturingPlace;
    }

    public void setManufacturingPlace(String manufacturingPlace) {
        this.manufacturingPlace = manufacturingPlace == null ? null : manufacturingPlace.trim();
    }

    public String getModelStyle() {
        return modelStyle;
    }

    public void setModelStyle(String modelStyle) {
        this.modelStyle = modelStyle == null ? null : modelStyle.trim();
    }

    public String getBigRepairTimes() {
        return bigRepairTimes;
    }

    public void setBigRepairTimes(String bigRepairTimes) {
        this.bigRepairTimes = bigRepairTimes == null ? null : bigRepairTimes.trim();
    }

    public String getTroubleRecords() {
        return troubleRecords;
    }

    public void setTroubleRecords(String troubleRecords) {
        this.troubleRecords = troubleRecords == null ? null : troubleRecords.trim();
    }

    public BigDecimal getUsedYear() {
        return usedYear;
    }

    public void setUsedYear(BigDecimal usedYear) {
        this.usedYear = usedYear;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType == null ? null : vehicleType.trim();
    }

    public String getBearAbility() {
        return bearAbility;
    }

    public void setBearAbility(String bearAbility) {
        this.bearAbility = bearAbility == null ? null : bearAbility.trim();
    }

    public String getStorePlace() {
        return storePlace;
    }

    public void setStorePlace(String storePlace) {
        this.storePlace = storePlace == null ? null : storePlace.trim();
    }

    public BigDecimal getDepreciationValue() {
        return depreciationValue;
    }

    public void setDepreciationValue(BigDecimal depreciationValue) {
        this.depreciationValue = depreciationValue;
    }

    public BigDecimal getDepreciationRestValue() {
        return depreciationRestValue;
    }

    public void setDepreciationRestValue(BigDecimal depreciationRestValue) {
        this.depreciationRestValue = depreciationRestValue;
    }

    public BigDecimal getCarAge() {
        return carAge;
    }

    public void setCarAge(BigDecimal carAge) {
        this.carAge = carAge;
    }

    public Date getPurchaseYear() {
        return purchaseYear;
    }

    public void setPurchaseYear(Date purchaseYear) {
        this.purchaseYear = purchaseYear;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand == null ? null : carBrand.trim();
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public Date getRejectYear() {
        return rejectYear;
    }

    public void setRejectYear(Date rejectYear) {
        this.rejectYear = rejectYear;
    }

    public String getTrafficCurrencyCd() {
        return trafficCurrencyCd;
    }

    public void setTrafficCurrencyCd(String trafficCurrencyCd) {
        this.trafficCurrencyCd = trafficCurrencyCd == null ? null : trafficCurrencyCd.trim();
    }

    public String getEngineNum() {
        return engineNum;
    }

    public void setEngineNum(String engineNum) {
        this.engineNum = engineNum == null ? null : engineNum.trim();
    }

    public String getHasOperationCertificate() {
        return hasOperationCertificate;
    }

    public void setHasOperationCertificate(String hasOperationCertificate) {
        this.hasOperationCertificate = hasOperationCertificate == null ? null : hasOperationCertificate.trim();
    }

    public String getOperationCertificateOrg() {
        return operationCertificateOrg;
    }

    public void setOperationCertificateOrg(String operationCertificateOrg) {
        this.operationCertificateOrg = operationCertificateOrg == null ? null : operationCertificateOrg.trim();
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
        GrtVehicleTypeMortgage other = (GrtVehicleTypeMortgage) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getVehicleLicenseNum() == null ? other.getVehicleLicenseNum() == null : this.getVehicleLicenseNum().equals(other.getVehicleLicenseNum()))
            && (this.getVehicleName() == null ? other.getVehicleName() == null : this.getVehicleName().equals(other.getVehicleName()))
            && (this.getCarryingCapacity() == null ? other.getCarryingCapacity() == null : this.getCarryingCapacity().equals(other.getCarryingCapacity()))
            && (this.getPower() == null ? other.getPower() == null : this.getPower().equals(other.getPower()))
            && (this.getManufacturingYear() == null ? other.getManufacturingYear() == null : this.getManufacturingYear().equals(other.getManufacturingYear()))
            && (this.getManufacturingCompany() == null ? other.getManufacturingCompany() == null : this.getManufacturingCompany().equals(other.getManufacturingCompany()))
            && (this.getPowerUnitCd() == null ? other.getPowerUnitCd() == null : this.getPowerUnitCd().equals(other.getPowerUnitCd()))
            && (this.getManufacturingPlace() == null ? other.getManufacturingPlace() == null : this.getManufacturingPlace().equals(other.getManufacturingPlace()))
            && (this.getModelStyle() == null ? other.getModelStyle() == null : this.getModelStyle().equals(other.getModelStyle()))
            && (this.getBigRepairTimes() == null ? other.getBigRepairTimes() == null : this.getBigRepairTimes().equals(other.getBigRepairTimes()))
            && (this.getTroubleRecords() == null ? other.getTroubleRecords() == null : this.getTroubleRecords().equals(other.getTroubleRecords()))
            && (this.getUsedYear() == null ? other.getUsedYear() == null : this.getUsedYear().equals(other.getUsedYear()))
            && (this.getVehicleType() == null ? other.getVehicleType() == null : this.getVehicleType().equals(other.getVehicleType()))
            && (this.getBearAbility() == null ? other.getBearAbility() == null : this.getBearAbility().equals(other.getBearAbility()))
            && (this.getStorePlace() == null ? other.getStorePlace() == null : this.getStorePlace().equals(other.getStorePlace()))
            && (this.getDepreciationValue() == null ? other.getDepreciationValue() == null : this.getDepreciationValue().equals(other.getDepreciationValue()))
            && (this.getDepreciationRestValue() == null ? other.getDepreciationRestValue() == null : this.getDepreciationRestValue().equals(other.getDepreciationRestValue()))
            && (this.getCarAge() == null ? other.getCarAge() == null : this.getCarAge().equals(other.getCarAge()))
            && (this.getPurchaseYear() == null ? other.getPurchaseYear() == null : this.getPurchaseYear().equals(other.getPurchaseYear()))
            && (this.getCarBrand() == null ? other.getCarBrand() == null : this.getCarBrand().equals(other.getCarBrand()))
            && (this.getCarType() == null ? other.getCarType() == null : this.getCarType().equals(other.getCarType()))
            && (this.getRejectYear() == null ? other.getRejectYear() == null : this.getRejectYear().equals(other.getRejectYear()))
            && (this.getTrafficCurrencyCd() == null ? other.getTrafficCurrencyCd() == null : this.getTrafficCurrencyCd().equals(other.getTrafficCurrencyCd()))
            && (this.getEngineNum() == null ? other.getEngineNum() == null : this.getEngineNum().equals(other.getEngineNum()))
            && (this.getHasOperationCertificate() == null ? other.getHasOperationCertificate() == null : this.getHasOperationCertificate().equals(other.getHasOperationCertificate()))
            && (this.getOperationCertificateOrg() == null ? other.getOperationCertificateOrg() == null : this.getOperationCertificateOrg().equals(other.getOperationCertificateOrg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getVehicleLicenseNum() == null) ? 0 : getVehicleLicenseNum().hashCode());
        result = prime * result + ((getVehicleName() == null) ? 0 : getVehicleName().hashCode());
        result = prime * result + ((getCarryingCapacity() == null) ? 0 : getCarryingCapacity().hashCode());
        result = prime * result + ((getPower() == null) ? 0 : getPower().hashCode());
        result = prime * result + ((getManufacturingYear() == null) ? 0 : getManufacturingYear().hashCode());
        result = prime * result + ((getManufacturingCompany() == null) ? 0 : getManufacturingCompany().hashCode());
        result = prime * result + ((getPowerUnitCd() == null) ? 0 : getPowerUnitCd().hashCode());
        result = prime * result + ((getManufacturingPlace() == null) ? 0 : getManufacturingPlace().hashCode());
        result = prime * result + ((getModelStyle() == null) ? 0 : getModelStyle().hashCode());
        result = prime * result + ((getBigRepairTimes() == null) ? 0 : getBigRepairTimes().hashCode());
        result = prime * result + ((getTroubleRecords() == null) ? 0 : getTroubleRecords().hashCode());
        result = prime * result + ((getUsedYear() == null) ? 0 : getUsedYear().hashCode());
        result = prime * result + ((getVehicleType() == null) ? 0 : getVehicleType().hashCode());
        result = prime * result + ((getBearAbility() == null) ? 0 : getBearAbility().hashCode());
        result = prime * result + ((getStorePlace() == null) ? 0 : getStorePlace().hashCode());
        result = prime * result + ((getDepreciationValue() == null) ? 0 : getDepreciationValue().hashCode());
        result = prime * result + ((getDepreciationRestValue() == null) ? 0 : getDepreciationRestValue().hashCode());
        result = prime * result + ((getCarAge() == null) ? 0 : getCarAge().hashCode());
        result = prime * result + ((getPurchaseYear() == null) ? 0 : getPurchaseYear().hashCode());
        result = prime * result + ((getCarBrand() == null) ? 0 : getCarBrand().hashCode());
        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());
        result = prime * result + ((getRejectYear() == null) ? 0 : getRejectYear().hashCode());
        result = prime * result + ((getTrafficCurrencyCd() == null) ? 0 : getTrafficCurrencyCd().hashCode());
        result = prime * result + ((getEngineNum() == null) ? 0 : getEngineNum().hashCode());
        result = prime * result + ((getHasOperationCertificate() == null) ? 0 : getHasOperationCertificate().hashCode());
        result = prime * result + ((getOperationCertificateOrg() == null) ? 0 : getOperationCertificateOrg().hashCode());
        return result;
    }
}