package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 抵质押物意外信息
 * @author wuyong
 * @date 2018.12.29
 *
 */
public class GrtCollateralAccident {
    private String accidentId;

    private String guarantyId;

    private String accidentTypeCd;

    private String reason;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date occurDate;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal priceLosses;

    private String otherNote;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal pricesCompensation;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date sysUpdateTime;

    private String currencyCd;

    public String getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(String accidentId) {
        this.accidentId = accidentId == null ? null : accidentId.trim();
    }

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getAccidentTypeCd() {
        return accidentTypeCd;
    }

    public void setAccidentTypeCd(String accidentTypeCd) {
        this.accidentTypeCd = accidentTypeCd == null ? null : accidentTypeCd.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getOccurDate() {
        return occurDate;
    }

    public void setOccurDate(Date occurDate) {
        this.occurDate = occurDate;
    }

    public BigDecimal getPriceLosses() {
        return priceLosses;
    }

    public void setPriceLosses(BigDecimal priceLosses) {
        this.priceLosses = priceLosses;
    }

    public String getOtherNote() {
        return otherNote;
    }

    public void setOtherNote(String otherNote) {
        this.otherNote = otherNote == null ? null : otherNote.trim();
    }

    public BigDecimal getPricesCompensation() {
        return pricesCompensation;
    }

    public void setPricesCompensation(BigDecimal pricesCompensation) {
        this.pricesCompensation = pricesCompensation;
    }

    public Date getSysUpdateTime() {
        return sysUpdateTime;
    }

    public void setSysUpdateTime(Date sysUpdateTime) {
        this.sysUpdateTime = sysUpdateTime;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
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
        GrtCollateralAccident other = (GrtCollateralAccident) that;
        return (this.getAccidentId() == null ? other.getAccidentId() == null : this.getAccidentId().equals(other.getAccidentId()))
            && (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getAccidentTypeCd() == null ? other.getAccidentTypeCd() == null : this.getAccidentTypeCd().equals(other.getAccidentTypeCd()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getOccurDate() == null ? other.getOccurDate() == null : this.getOccurDate().equals(other.getOccurDate()))
            && (this.getPriceLosses() == null ? other.getPriceLosses() == null : this.getPriceLosses().equals(other.getPriceLosses()))
            && (this.getOtherNote() == null ? other.getOtherNote() == null : this.getOtherNote().equals(other.getOtherNote()))
            && (this.getPricesCompensation() == null ? other.getPricesCompensation() == null : this.getPricesCompensation().equals(other.getPricesCompensation()))
            && (this.getSysUpdateTime() == null ? other.getSysUpdateTime() == null : this.getSysUpdateTime().equals(other.getSysUpdateTime()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccidentId() == null) ? 0 : getAccidentId().hashCode());
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getAccidentTypeCd() == null) ? 0 : getAccidentTypeCd().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getOccurDate() == null) ? 0 : getOccurDate().hashCode());
        result = prime * result + ((getPriceLosses() == null) ? 0 : getPriceLosses().hashCode());
        result = prime * result + ((getOtherNote() == null) ? 0 : getOtherNote().hashCode());
        result = prime * result + ((getPricesCompensation() == null) ? 0 : getPricesCompensation().hashCode());
        result = prime * result + ((getSysUpdateTime() == null) ? 0 : getSysUpdateTime().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        return result;
    }
}