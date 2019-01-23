package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.common.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 船舶bean
 * @author wuyong
 * @date 2019.1.7
 *
 */
public class GrtTrafficShip {
    private String guarantyId;

    private String engineType;

    private String shipNum;

    private String fuel;

    private String fuelLabelNo;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal totalTon;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal displacement;

    private String seaworthinessCertificateInd;

    private String seaworthinessCertificateNum;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date seaworthinessCertificateDate;

    private String registerAddress;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date insuranceDate;

    private String oriShipOwner;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal oriPurchasePrice;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal runnedKm;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal usedYears;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType == null ? null : engineType.trim();
    }

    public String getShipNum() {
        return shipNum;
    }

    public void setShipNum(String shipNum) {
        this.shipNum = shipNum == null ? null : shipNum.trim();
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel == null ? null : fuel.trim();
    }

    public String getFuelLabelNo() {
        return fuelLabelNo;
    }

    public void setFuelLabelNo(String fuelLabelNo) {
        this.fuelLabelNo = fuelLabelNo == null ? null : fuelLabelNo.trim();
    }

    public BigDecimal getTotalTon() {
        return totalTon;
    }

    public void setTotalTon(BigDecimal totalTon) {
        this.totalTon = totalTon;
    }

    public BigDecimal getDisplacement() {
        return displacement;
    }

    public void setDisplacement(BigDecimal displacement) {
        this.displacement = displacement;
    }

    public String getSeaworthinessCertificateInd() {
        return seaworthinessCertificateInd;
    }

    public void setSeaworthinessCertificateInd(String seaworthinessCertificateInd) {
        this.seaworthinessCertificateInd = seaworthinessCertificateInd == null ? null : seaworthinessCertificateInd.trim();
    }

    public String getSeaworthinessCertificateNum() {
        return seaworthinessCertificateNum;
    }

    public void setSeaworthinessCertificateNum(String seaworthinessCertificateNum) {
        this.seaworthinessCertificateNum = seaworthinessCertificateNum == null ? null : seaworthinessCertificateNum.trim();
    }

    public Date getSeaworthinessCertificateDate() {
        return seaworthinessCertificateDate;
    }

    public void setSeaworthinessCertificateDate(Date seaworthinessCertificateDate) {
        this.seaworthinessCertificateDate = seaworthinessCertificateDate;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress == null ? null : registerAddress.trim();
    }

    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public String getOriShipOwner() {
        return oriShipOwner;
    }

    public void setOriShipOwner(String oriShipOwner) {
        this.oriShipOwner = oriShipOwner == null ? null : oriShipOwner.trim();
    }

    public BigDecimal getOriPurchasePrice() {
        return oriPurchasePrice;
    }

    public void setOriPurchasePrice(BigDecimal oriPurchasePrice) {
        this.oriPurchasePrice = oriPurchasePrice;
    }

    public BigDecimal getRunnedKm() {
        return runnedKm;
    }

    public void setRunnedKm(BigDecimal runnedKm) {
        this.runnedKm = runnedKm;
    }

    public BigDecimal getUsedYears() {
        return usedYears;
    }

    public void setUsedYears(BigDecimal usedYears) {
        this.usedYears = usedYears;
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
        GrtTrafficShip other = (GrtTrafficShip) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getEngineType() == null ? other.getEngineType() == null : this.getEngineType().equals(other.getEngineType()))
            && (this.getShipNum() == null ? other.getShipNum() == null : this.getShipNum().equals(other.getShipNum()))
            && (this.getFuel() == null ? other.getFuel() == null : this.getFuel().equals(other.getFuel()))
            && (this.getFuelLabelNo() == null ? other.getFuelLabelNo() == null : this.getFuelLabelNo().equals(other.getFuelLabelNo()))
            && (this.getTotalTon() == null ? other.getTotalTon() == null : this.getTotalTon().equals(other.getTotalTon()))
            && (this.getDisplacement() == null ? other.getDisplacement() == null : this.getDisplacement().equals(other.getDisplacement()))
            && (this.getSeaworthinessCertificateInd() == null ? other.getSeaworthinessCertificateInd() == null : this.getSeaworthinessCertificateInd().equals(other.getSeaworthinessCertificateInd()))
            && (this.getSeaworthinessCertificateNum() == null ? other.getSeaworthinessCertificateNum() == null : this.getSeaworthinessCertificateNum().equals(other.getSeaworthinessCertificateNum()))
            && (this.getSeaworthinessCertificateDate() == null ? other.getSeaworthinessCertificateDate() == null : this.getSeaworthinessCertificateDate().equals(other.getSeaworthinessCertificateDate()))
            && (this.getRegisterAddress() == null ? other.getRegisterAddress() == null : this.getRegisterAddress().equals(other.getRegisterAddress()))
            && (this.getInsuranceDate() == null ? other.getInsuranceDate() == null : this.getInsuranceDate().equals(other.getInsuranceDate()))
            && (this.getOriShipOwner() == null ? other.getOriShipOwner() == null : this.getOriShipOwner().equals(other.getOriShipOwner()))
            && (this.getOriPurchasePrice() == null ? other.getOriPurchasePrice() == null : this.getOriPurchasePrice().equals(other.getOriPurchasePrice()))
            && (this.getRunnedKm() == null ? other.getRunnedKm() == null : this.getRunnedKm().equals(other.getRunnedKm()))
            && (this.getUsedYears() == null ? other.getUsedYears() == null : this.getUsedYears().equals(other.getUsedYears()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getEngineType() == null) ? 0 : getEngineType().hashCode());
        result = prime * result + ((getShipNum() == null) ? 0 : getShipNum().hashCode());
        result = prime * result + ((getFuel() == null) ? 0 : getFuel().hashCode());
        result = prime * result + ((getFuelLabelNo() == null) ? 0 : getFuelLabelNo().hashCode());
        result = prime * result + ((getTotalTon() == null) ? 0 : getTotalTon().hashCode());
        result = prime * result + ((getDisplacement() == null) ? 0 : getDisplacement().hashCode());
        result = prime * result + ((getSeaworthinessCertificateInd() == null) ? 0 : getSeaworthinessCertificateInd().hashCode());
        result = prime * result + ((getSeaworthinessCertificateNum() == null) ? 0 : getSeaworthinessCertificateNum().hashCode());
        result = prime * result + ((getSeaworthinessCertificateDate() == null) ? 0 : getSeaworthinessCertificateDate().hashCode());
        result = prime * result + ((getRegisterAddress() == null) ? 0 : getRegisterAddress().hashCode());
        result = prime * result + ((getInsuranceDate() == null) ? 0 : getInsuranceDate().hashCode());
        result = prime * result + ((getOriShipOwner() == null) ? 0 : getOriShipOwner().hashCode());
        result = prime * result + ((getOriPurchasePrice() == null) ? 0 : getOriPurchasePrice().hashCode());
        result = prime * result + ((getRunnedKm() == null) ? 0 : getRunnedKm().hashCode());
        result = prime * result + ((getUsedYears() == null) ? 0 : getUsedYears().hashCode());
        return result;
    }
}