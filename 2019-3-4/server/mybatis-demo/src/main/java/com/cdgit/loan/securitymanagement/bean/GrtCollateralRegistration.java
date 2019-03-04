package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 抵质押物登记信息
 * @author wuyong
 * @date 2018.12.29
 *
 */
public class GrtCollateralRegistration {
    private String collateralRegistrationId;

    private String guarantyId;

    private String registerNum;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date registerDate;

    private String otherNote;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date registerExpirationDate;

    private String registerOrgName;

    private String registerOrgTypeCd;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date sysUpdateTime;

    private String contractNum;

    private String isUse;

    private String registerArea;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal registerValue;

    public String getCollateralRegistrationId() {
        return collateralRegistrationId;
    }

    public void setCollateralRegistrationId(String collateralRegistrationId) {
        this.collateralRegistrationId = collateralRegistrationId == null ? null : collateralRegistrationId.trim();
    }

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getRegisterNum() {
        return registerNum;
    }

    public void setRegisterNum(String registerNum) {
        this.registerNum = registerNum == null ? null : registerNum.trim();
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getOtherNote() {
        return otherNote;
    }

    public void setOtherNote(String otherNote) {
        this.otherNote = otherNote == null ? null : otherNote.trim();
    }

    public Date getRegisterExpirationDate() {
        return registerExpirationDate;
    }

    public void setRegisterExpirationDate(Date registerExpirationDate) {
        this.registerExpirationDate = registerExpirationDate;
    }

    public String getRegisterOrgName() {
        return registerOrgName;
    }

    public void setRegisterOrgName(String registerOrgName) {
        this.registerOrgName = registerOrgName == null ? null : registerOrgName.trim();
    }

    public String getRegisterOrgTypeCd() {
        return registerOrgTypeCd;
    }

    public void setRegisterOrgTypeCd(String registerOrgTypeCd) {
        this.registerOrgTypeCd = registerOrgTypeCd == null ? null : registerOrgTypeCd.trim();
    }

    public Date getSysUpdateTime() {
        return sysUpdateTime;
    }

    public void setSysUpdateTime(Date sysUpdateTime) {
        this.sysUpdateTime = sysUpdateTime;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum == null ? null : contractNum.trim();
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse == null ? null : isUse.trim();
    }

    public String getRegisterArea() {
        return registerArea;
    }

    public void setRegisterArea(String registerArea) {
        this.registerArea = registerArea == null ? null : registerArea.trim();
    }

    public BigDecimal getRegisterValue() {
        return registerValue;
    }

    public void setRegisterValue(BigDecimal registerValue) {
        this.registerValue = registerValue;
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
        GrtCollateralRegistration other = (GrtCollateralRegistration) that;
        return (this.getCollateralRegistrationId() == null ? other.getCollateralRegistrationId() == null : this.getCollateralRegistrationId().equals(other.getCollateralRegistrationId()))
            && (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getRegisterNum() == null ? other.getRegisterNum() == null : this.getRegisterNum().equals(other.getRegisterNum()))
            && (this.getRegisterDate() == null ? other.getRegisterDate() == null : this.getRegisterDate().equals(other.getRegisterDate()))
            && (this.getOtherNote() == null ? other.getOtherNote() == null : this.getOtherNote().equals(other.getOtherNote()))
            && (this.getRegisterExpirationDate() == null ? other.getRegisterExpirationDate() == null : this.getRegisterExpirationDate().equals(other.getRegisterExpirationDate()))
            && (this.getRegisterOrgName() == null ? other.getRegisterOrgName() == null : this.getRegisterOrgName().equals(other.getRegisterOrgName()))
            && (this.getRegisterOrgTypeCd() == null ? other.getRegisterOrgTypeCd() == null : this.getRegisterOrgTypeCd().equals(other.getRegisterOrgTypeCd()))
            && (this.getSysUpdateTime() == null ? other.getSysUpdateTime() == null : this.getSysUpdateTime().equals(other.getSysUpdateTime()))
            && (this.getContractNum() == null ? other.getContractNum() == null : this.getContractNum().equals(other.getContractNum()))
            && (this.getIsUse() == null ? other.getIsUse() == null : this.getIsUse().equals(other.getIsUse()))
            && (this.getRegisterArea() == null ? other.getRegisterArea() == null : this.getRegisterArea().equals(other.getRegisterArea()))
            && (this.getRegisterValue() == null ? other.getRegisterValue() == null : this.getRegisterValue().equals(other.getRegisterValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCollateralRegistrationId() == null) ? 0 : getCollateralRegistrationId().hashCode());
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getRegisterNum() == null) ? 0 : getRegisterNum().hashCode());
        result = prime * result + ((getRegisterDate() == null) ? 0 : getRegisterDate().hashCode());
        result = prime * result + ((getOtherNote() == null) ? 0 : getOtherNote().hashCode());
        result = prime * result + ((getRegisterExpirationDate() == null) ? 0 : getRegisterExpirationDate().hashCode());
        result = prime * result + ((getRegisterOrgName() == null) ? 0 : getRegisterOrgName().hashCode());
        result = prime * result + ((getRegisterOrgTypeCd() == null) ? 0 : getRegisterOrgTypeCd().hashCode());
        result = prime * result + ((getSysUpdateTime() == null) ? 0 : getSysUpdateTime().hashCode());
        result = prime * result + ((getContractNum() == null) ? 0 : getContractNum().hashCode());
        result = prime * result + ((getIsUse() == null) ? 0 : getIsUse().hashCode());
        result = prime * result + ((getRegisterArea() == null) ? 0 : getRegisterArea().hashCode());
        result = prime * result + ((getRegisterValue() == null) ? 0 : getRegisterValue().hashCode());
        return result;
    }
}