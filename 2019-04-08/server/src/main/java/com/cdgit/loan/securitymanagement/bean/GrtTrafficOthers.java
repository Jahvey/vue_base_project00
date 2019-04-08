package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 交通运输工具（其他交通工具）bean
 * @author wuyong
 * @date 2019.1.11
 *
 */
public class GrtTrafficOthers {
    private String guarantyId;

    private String amountUnitCd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal amount;

    private String destroyYears;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal oriPurchasePrice;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date producedDate;

    private String ownerLicenseInd;

    private String ownerLicenseNum;

    private String ownerName;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date insuranceDate;

    private String purposeRemark;

    private String useType;

    private String numberPlate;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getAmountUnitCd() {
        return amountUnitCd;
    }

    public void setAmountUnitCd(String amountUnitCd) {
        this.amountUnitCd = amountUnitCd == null ? null : amountUnitCd.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDestroyYears() {
        return destroyYears;
    }

    public void setDestroyYears(String destroyYears) {
        this.destroyYears = destroyYears == null ? null : destroyYears.trim();
    }

    public BigDecimal getOriPurchasePrice() {
        return oriPurchasePrice;
    }

    public void setOriPurchasePrice(BigDecimal oriPurchasePrice) {
        this.oriPurchasePrice = oriPurchasePrice;
    }

    public Date getProducedDate() {
        return producedDate;
    }

    public void setProducedDate(Date producedDate) {
        this.producedDate = producedDate;
    }

    public String getOwnerLicenseInd() {
        return ownerLicenseInd;
    }

    public void setOwnerLicenseInd(String ownerLicenseInd) {
        this.ownerLicenseInd = ownerLicenseInd == null ? null : ownerLicenseInd.trim();
    }

    public String getOwnerLicenseNum() {
        return ownerLicenseNum;
    }

    public void setOwnerLicenseNum(String ownerLicenseNum) {
        this.ownerLicenseNum = ownerLicenseNum == null ? null : ownerLicenseNum.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public String getPurposeRemark() {
        return purposeRemark;
    }

    public void setPurposeRemark(String purposeRemark) {
        this.purposeRemark = purposeRemark == null ? null : purposeRemark.trim();
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType == null ? null : useType.trim();
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate == null ? null : numberPlate.trim();
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
        GrtTrafficOthers other = (GrtTrafficOthers) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getAmountUnitCd() == null ? other.getAmountUnitCd() == null : this.getAmountUnitCd().equals(other.getAmountUnitCd()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getDestroyYears() == null ? other.getDestroyYears() == null : this.getDestroyYears().equals(other.getDestroyYears()))
            && (this.getOriPurchasePrice() == null ? other.getOriPurchasePrice() == null : this.getOriPurchasePrice().equals(other.getOriPurchasePrice()))
            && (this.getProducedDate() == null ? other.getProducedDate() == null : this.getProducedDate().equals(other.getProducedDate()))
            && (this.getOwnerLicenseInd() == null ? other.getOwnerLicenseInd() == null : this.getOwnerLicenseInd().equals(other.getOwnerLicenseInd()))
            && (this.getOwnerLicenseNum() == null ? other.getOwnerLicenseNum() == null : this.getOwnerLicenseNum().equals(other.getOwnerLicenseNum()))
            && (this.getOwnerName() == null ? other.getOwnerName() == null : this.getOwnerName().equals(other.getOwnerName()))
            && (this.getInsuranceDate() == null ? other.getInsuranceDate() == null : this.getInsuranceDate().equals(other.getInsuranceDate()))
            && (this.getPurposeRemark() == null ? other.getPurposeRemark() == null : this.getPurposeRemark().equals(other.getPurposeRemark()))
            && (this.getUseType() == null ? other.getUseType() == null : this.getUseType().equals(other.getUseType()))
            && (this.getNumberPlate() == null ? other.getNumberPlate() == null : this.getNumberPlate().equals(other.getNumberPlate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getAmountUnitCd() == null) ? 0 : getAmountUnitCd().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getDestroyYears() == null) ? 0 : getDestroyYears().hashCode());
        result = prime * result + ((getOriPurchasePrice() == null) ? 0 : getOriPurchasePrice().hashCode());
        result = prime * result + ((getProducedDate() == null) ? 0 : getProducedDate().hashCode());
        result = prime * result + ((getOwnerLicenseInd() == null) ? 0 : getOwnerLicenseInd().hashCode());
        result = prime * result + ((getOwnerLicenseNum() == null) ? 0 : getOwnerLicenseNum().hashCode());
        result = prime * result + ((getOwnerName() == null) ? 0 : getOwnerName().hashCode());
        result = prime * result + ((getInsuranceDate() == null) ? 0 : getInsuranceDate().hashCode());
        result = prime * result + ((getPurposeRemark() == null) ? 0 : getPurposeRemark().hashCode());
        result = prime * result + ((getUseType() == null) ? 0 : getUseType().hashCode());
        result = prime * result + ((getNumberPlate() == null) ? 0 : getNumberPlate().hashCode());
        return result;
    }
}