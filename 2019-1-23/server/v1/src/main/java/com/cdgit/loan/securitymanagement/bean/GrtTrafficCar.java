package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.common.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 机动车bean
 * @author wuyong
 * @date  2018.1.7
 *
 */
public class GrtTrafficCar {
    private String guarantyId;

    private String fuel;

    private String color;

    private String fuelLabelNo;

    private String frameworkNum;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal oriPurchasePrice;

    private String dirverLicenseInd;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date hangDate;

    private String carCardNum;

    private String registerAddress;

    private String licenseOwner;

    private String coverChargeCertInd;

    private String carryLicenseInd;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date additionalChargesDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date insuranceDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date roadTollDate;

    private String purpose;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal runnedKm;

    private String purchaseContractNo;

    private String brand;

    private String carModel;

    private String carType;

    private String carRunNo;

    private String eligibilityCertificate;

    private String underPanNo;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal seatNum;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date rroductDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date purchaseDate;

    private String invoiceNo;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal useYearNum;

    private String majorPurpose;

    private String k53bzsm;

    private String vehiclesNature;

    private String origin;

    private String manufacturers;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal purchasePrice;

    private String licenseNum;

    private String licenseDepartment;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date producedDate;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel == null ? null : fuel.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getFuelLabelNo() {
        return fuelLabelNo;
    }

    public void setFuelLabelNo(String fuelLabelNo) {
        this.fuelLabelNo = fuelLabelNo == null ? null : fuelLabelNo.trim();
    }

    public String getFrameworkNum() {
        return frameworkNum;
    }

    public void setFrameworkNum(String frameworkNum) {
        this.frameworkNum = frameworkNum == null ? null : frameworkNum.trim();
    }

    public BigDecimal getOriPurchasePrice() {
        return oriPurchasePrice;
    }

    public void setOriPurchasePrice(BigDecimal oriPurchasePrice) {
        this.oriPurchasePrice = oriPurchasePrice;
    }

    public String getDirverLicenseInd() {
        return dirverLicenseInd;
    }

    public void setDirverLicenseInd(String dirverLicenseInd) {
        this.dirverLicenseInd = dirverLicenseInd == null ? null : dirverLicenseInd.trim();
    }

    public Date getHangDate() {
        return hangDate;
    }

    public void setHangDate(Date hangDate) {
        this.hangDate = hangDate;
    }

    public String getCarCardNum() {
        return carCardNum;
    }

    public void setCarCardNum(String carCardNum) {
        this.carCardNum = carCardNum == null ? null : carCardNum.trim();
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress == null ? null : registerAddress.trim();
    }

    public String getLicenseOwner() {
        return licenseOwner;
    }

    public void setLicenseOwner(String licenseOwner) {
        this.licenseOwner = licenseOwner == null ? null : licenseOwner.trim();
    }

    public String getCoverChargeCertInd() {
        return coverChargeCertInd;
    }

    public void setCoverChargeCertInd(String coverChargeCertInd) {
        this.coverChargeCertInd = coverChargeCertInd == null ? null : coverChargeCertInd.trim();
    }

    public String getCarryLicenseInd() {
        return carryLicenseInd;
    }

    public void setCarryLicenseInd(String carryLicenseInd) {
        this.carryLicenseInd = carryLicenseInd == null ? null : carryLicenseInd.trim();
    }

    public Date getAdditionalChargesDate() {
        return additionalChargesDate;
    }

    public void setAdditionalChargesDate(Date additionalChargesDate) {
        this.additionalChargesDate = additionalChargesDate;
    }

    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public Date getRoadTollDate() {
        return roadTollDate;
    }

    public void setRoadTollDate(Date roadTollDate) {
        this.roadTollDate = roadTollDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public BigDecimal getRunnedKm() {
        return runnedKm;
    }

    public void setRunnedKm(BigDecimal runnedKm) {
        this.runnedKm = runnedKm;
    }

    public String getPurchaseContractNo() {
        return purchaseContractNo;
    }

    public void setPurchaseContractNo(String purchaseContractNo) {
        this.purchaseContractNo = purchaseContractNo == null ? null : purchaseContractNo.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel == null ? null : carModel.trim();
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public String getCarRunNo() {
        return carRunNo;
    }

    public void setCarRunNo(String carRunNo) {
        this.carRunNo = carRunNo == null ? null : carRunNo.trim();
    }

    public String getEligibilityCertificate() {
        return eligibilityCertificate;
    }

    public void setEligibilityCertificate(String eligibilityCertificate) {
        this.eligibilityCertificate = eligibilityCertificate == null ? null : eligibilityCertificate.trim();
    }

    public String getUnderPanNo() {
        return underPanNo;
    }

    public void setUnderPanNo(String underPanNo) {
        this.underPanNo = underPanNo == null ? null : underPanNo.trim();
    }

    public BigDecimal getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(BigDecimal seatNum) {
        this.seatNum = seatNum;
    }

    public Date getRroductDate() {
        return rroductDate;
    }

    public void setRroductDate(Date rroductDate) {
        this.rroductDate = rroductDate;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public BigDecimal getUseYearNum() {
        return useYearNum;
    }

    public void setUseYearNum(BigDecimal useYearNum) {
        this.useYearNum = useYearNum;
    }

    public String getMajorPurpose() {
        return majorPurpose;
    }

    public void setMajorPurpose(String majorPurpose) {
        this.majorPurpose = majorPurpose == null ? null : majorPurpose.trim();
    }

    public String getK53bzsm() {
        return k53bzsm;
    }

    public void setK53bzsm(String k53bzsm) {
        this.k53bzsm = k53bzsm == null ? null : k53bzsm.trim();
    }

    public String getVehiclesNature() {
        return vehiclesNature;
    }

    public void setVehiclesNature(String vehiclesNature) {
        this.vehiclesNature = vehiclesNature == null ? null : vehiclesNature.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers == null ? null : manufacturers.trim();
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
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

    public Date getProducedDate() {
        return producedDate;
    }

    public void setProducedDate(Date producedDate) {
        this.producedDate = producedDate;
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
        GrtTrafficCar other = (GrtTrafficCar) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getFuel() == null ? other.getFuel() == null : this.getFuel().equals(other.getFuel()))
            && (this.getColor() == null ? other.getColor() == null : this.getColor().equals(other.getColor()))
            && (this.getFuelLabelNo() == null ? other.getFuelLabelNo() == null : this.getFuelLabelNo().equals(other.getFuelLabelNo()))
            && (this.getFrameworkNum() == null ? other.getFrameworkNum() == null : this.getFrameworkNum().equals(other.getFrameworkNum()))
            && (this.getOriPurchasePrice() == null ? other.getOriPurchasePrice() == null : this.getOriPurchasePrice().equals(other.getOriPurchasePrice()))
            && (this.getDirverLicenseInd() == null ? other.getDirverLicenseInd() == null : this.getDirverLicenseInd().equals(other.getDirverLicenseInd()))
            && (this.getHangDate() == null ? other.getHangDate() == null : this.getHangDate().equals(other.getHangDate()))
            && (this.getCarCardNum() == null ? other.getCarCardNum() == null : this.getCarCardNum().equals(other.getCarCardNum()))
            && (this.getRegisterAddress() == null ? other.getRegisterAddress() == null : this.getRegisterAddress().equals(other.getRegisterAddress()))
            && (this.getLicenseOwner() == null ? other.getLicenseOwner() == null : this.getLicenseOwner().equals(other.getLicenseOwner()))
            && (this.getCoverChargeCertInd() == null ? other.getCoverChargeCertInd() == null : this.getCoverChargeCertInd().equals(other.getCoverChargeCertInd()))
            && (this.getCarryLicenseInd() == null ? other.getCarryLicenseInd() == null : this.getCarryLicenseInd().equals(other.getCarryLicenseInd()))
            && (this.getAdditionalChargesDate() == null ? other.getAdditionalChargesDate() == null : this.getAdditionalChargesDate().equals(other.getAdditionalChargesDate()))
            && (this.getInsuranceDate() == null ? other.getInsuranceDate() == null : this.getInsuranceDate().equals(other.getInsuranceDate()))
            && (this.getRoadTollDate() == null ? other.getRoadTollDate() == null : this.getRoadTollDate().equals(other.getRoadTollDate()))
            && (this.getPurpose() == null ? other.getPurpose() == null : this.getPurpose().equals(other.getPurpose()))
            && (this.getRunnedKm() == null ? other.getRunnedKm() == null : this.getRunnedKm().equals(other.getRunnedKm()))
            && (this.getPurchaseContractNo() == null ? other.getPurchaseContractNo() == null : this.getPurchaseContractNo().equals(other.getPurchaseContractNo()))
            && (this.getBrand() == null ? other.getBrand() == null : this.getBrand().equals(other.getBrand()))
            && (this.getCarModel() == null ? other.getCarModel() == null : this.getCarModel().equals(other.getCarModel()))
            && (this.getCarType() == null ? other.getCarType() == null : this.getCarType().equals(other.getCarType()))
            && (this.getCarRunNo() == null ? other.getCarRunNo() == null : this.getCarRunNo().equals(other.getCarRunNo()))
            && (this.getEligibilityCertificate() == null ? other.getEligibilityCertificate() == null : this.getEligibilityCertificate().equals(other.getEligibilityCertificate()))
            && (this.getUnderPanNo() == null ? other.getUnderPanNo() == null : this.getUnderPanNo().equals(other.getUnderPanNo()))
            && (this.getSeatNum() == null ? other.getSeatNum() == null : this.getSeatNum().equals(other.getSeatNum()))
            && (this.getRroductDate() == null ? other.getRroductDate() == null : this.getRroductDate().equals(other.getRroductDate()))
            && (this.getPurchaseDate() == null ? other.getPurchaseDate() == null : this.getPurchaseDate().equals(other.getPurchaseDate()))
            && (this.getInvoiceNo() == null ? other.getInvoiceNo() == null : this.getInvoiceNo().equals(other.getInvoiceNo()))
            && (this.getUseYearNum() == null ? other.getUseYearNum() == null : this.getUseYearNum().equals(other.getUseYearNum()))
            && (this.getMajorPurpose() == null ? other.getMajorPurpose() == null : this.getMajorPurpose().equals(other.getMajorPurpose()))
            && (this.getK53bzsm() == null ? other.getK53bzsm() == null : this.getK53bzsm().equals(other.getK53bzsm()))
            && (this.getVehiclesNature() == null ? other.getVehiclesNature() == null : this.getVehiclesNature().equals(other.getVehiclesNature()))
            && (this.getOrigin() == null ? other.getOrigin() == null : this.getOrigin().equals(other.getOrigin()))
            && (this.getManufacturers() == null ? other.getManufacturers() == null : this.getManufacturers().equals(other.getManufacturers()))
            && (this.getPurchasePrice() == null ? other.getPurchasePrice() == null : this.getPurchasePrice().equals(other.getPurchasePrice()))
            && (this.getLicenseNum() == null ? other.getLicenseNum() == null : this.getLicenseNum().equals(other.getLicenseNum()))
            && (this.getLicenseDepartment() == null ? other.getLicenseDepartment() == null : this.getLicenseDepartment().equals(other.getLicenseDepartment()))
            && (this.getProducedDate() == null ? other.getProducedDate() == null : this.getProducedDate().equals(other.getProducedDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getFuel() == null) ? 0 : getFuel().hashCode());
        result = prime * result + ((getColor() == null) ? 0 : getColor().hashCode());
        result = prime * result + ((getFuelLabelNo() == null) ? 0 : getFuelLabelNo().hashCode());
        result = prime * result + ((getFrameworkNum() == null) ? 0 : getFrameworkNum().hashCode());
        result = prime * result + ((getOriPurchasePrice() == null) ? 0 : getOriPurchasePrice().hashCode());
        result = prime * result + ((getDirverLicenseInd() == null) ? 0 : getDirverLicenseInd().hashCode());
        result = prime * result + ((getHangDate() == null) ? 0 : getHangDate().hashCode());
        result = prime * result + ((getCarCardNum() == null) ? 0 : getCarCardNum().hashCode());
        result = prime * result + ((getRegisterAddress() == null) ? 0 : getRegisterAddress().hashCode());
        result = prime * result + ((getLicenseOwner() == null) ? 0 : getLicenseOwner().hashCode());
        result = prime * result + ((getCoverChargeCertInd() == null) ? 0 : getCoverChargeCertInd().hashCode());
        result = prime * result + ((getCarryLicenseInd() == null) ? 0 : getCarryLicenseInd().hashCode());
        result = prime * result + ((getAdditionalChargesDate() == null) ? 0 : getAdditionalChargesDate().hashCode());
        result = prime * result + ((getInsuranceDate() == null) ? 0 : getInsuranceDate().hashCode());
        result = prime * result + ((getRoadTollDate() == null) ? 0 : getRoadTollDate().hashCode());
        result = prime * result + ((getPurpose() == null) ? 0 : getPurpose().hashCode());
        result = prime * result + ((getRunnedKm() == null) ? 0 : getRunnedKm().hashCode());
        result = prime * result + ((getPurchaseContractNo() == null) ? 0 : getPurchaseContractNo().hashCode());
        result = prime * result + ((getBrand() == null) ? 0 : getBrand().hashCode());
        result = prime * result + ((getCarModel() == null) ? 0 : getCarModel().hashCode());
        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());
        result = prime * result + ((getCarRunNo() == null) ? 0 : getCarRunNo().hashCode());
        result = prime * result + ((getEligibilityCertificate() == null) ? 0 : getEligibilityCertificate().hashCode());
        result = prime * result + ((getUnderPanNo() == null) ? 0 : getUnderPanNo().hashCode());
        result = prime * result + ((getSeatNum() == null) ? 0 : getSeatNum().hashCode());
        result = prime * result + ((getRroductDate() == null) ? 0 : getRroductDate().hashCode());
        result = prime * result + ((getPurchaseDate() == null) ? 0 : getPurchaseDate().hashCode());
        result = prime * result + ((getInvoiceNo() == null) ? 0 : getInvoiceNo().hashCode());
        result = prime * result + ((getUseYearNum() == null) ? 0 : getUseYearNum().hashCode());
        result = prime * result + ((getMajorPurpose() == null) ? 0 : getMajorPurpose().hashCode());
        result = prime * result + ((getK53bzsm() == null) ? 0 : getK53bzsm().hashCode());
        result = prime * result + ((getVehiclesNature() == null) ? 0 : getVehiclesNature().hashCode());
        result = prime * result + ((getOrigin() == null) ? 0 : getOrigin().hashCode());
        result = prime * result + ((getManufacturers() == null) ? 0 : getManufacturers().hashCode());
        result = prime * result + ((getPurchasePrice() == null) ? 0 : getPurchasePrice().hashCode());
        result = prime * result + ((getLicenseNum() == null) ? 0 : getLicenseNum().hashCode());
        result = prime * result + ((getLicenseDepartment() == null) ? 0 : getLicenseDepartment().hashCode());
        result = prime * result + ((getProducedDate() == null) ? 0 : getProducedDate().hashCode());
        return result;
    }
}