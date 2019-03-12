package com.cdgit.loan.guaranteevaluation.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 信用保险
 * @author wuyong
 *
 */
public class GrtCreditsafe {
    private String suretyId;

    private String policyHolder;

    private String beneficiary;

    private String insurer;

    private String policyNum;

    private String ndemnityNum;

    private String currencyCd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal creditLimit;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date effectiveDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date endDate;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal minLossRate;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal guaranteeMoney;

    public String getSuretyId() {
        return suretyId;
    }

    public void setSuretyId(String suretyId) {
        this.suretyId = suretyId == null ? null : suretyId.trim();
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(String policyHolder) {
        this.policyHolder = policyHolder == null ? null : policyHolder.trim();
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary == null ? null : beneficiary.trim();
    }

    public String getInsurer() {
        return insurer;
    }

    public void setInsurer(String insurer) {
        this.insurer = insurer == null ? null : insurer.trim();
    }

    public String getPolicyNum() {
        return policyNum;
    }

    public void setPolicyNum(String policyNum) {
        this.policyNum = policyNum == null ? null : policyNum.trim();
    }

    public String getNdemnityNum() {
        return ndemnityNum;
    }

    public void setNdemnityNum(String ndemnityNum) {
        this.ndemnityNum = ndemnityNum == null ? null : ndemnityNum.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getMinLossRate() {
        return minLossRate;
    }

    public void setMinLossRate(BigDecimal minLossRate) {
        this.minLossRate = minLossRate;
    }

    public BigDecimal getGuaranteeMoney() {
        return guaranteeMoney;
    }

    public void setGuaranteeMoney(BigDecimal guaranteeMoney) {
        this.guaranteeMoney = guaranteeMoney;
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
        GrtCreditsafe other = (GrtCreditsafe) that;
        return (this.getSuretyId() == null ? other.getSuretyId() == null : this.getSuretyId().equals(other.getSuretyId()))
            && (this.getPolicyHolder() == null ? other.getPolicyHolder() == null : this.getPolicyHolder().equals(other.getPolicyHolder()))
            && (this.getBeneficiary() == null ? other.getBeneficiary() == null : this.getBeneficiary().equals(other.getBeneficiary()))
            && (this.getInsurer() == null ? other.getInsurer() == null : this.getInsurer().equals(other.getInsurer()))
            && (this.getPolicyNum() == null ? other.getPolicyNum() == null : this.getPolicyNum().equals(other.getPolicyNum()))
            && (this.getNdemnityNum() == null ? other.getNdemnityNum() == null : this.getNdemnityNum().equals(other.getNdemnityNum()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getCreditLimit() == null ? other.getCreditLimit() == null : this.getCreditLimit().equals(other.getCreditLimit()))
            && (this.getEffectiveDate() == null ? other.getEffectiveDate() == null : this.getEffectiveDate().equals(other.getEffectiveDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getMinLossRate() == null ? other.getMinLossRate() == null : this.getMinLossRate().equals(other.getMinLossRate()))
            && (this.getGuaranteeMoney() == null ? other.getGuaranteeMoney() == null : this.getGuaranteeMoney().equals(other.getGuaranteeMoney()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSuretyId() == null) ? 0 : getSuretyId().hashCode());
        result = prime * result + ((getPolicyHolder() == null) ? 0 : getPolicyHolder().hashCode());
        result = prime * result + ((getBeneficiary() == null) ? 0 : getBeneficiary().hashCode());
        result = prime * result + ((getInsurer() == null) ? 0 : getInsurer().hashCode());
        result = prime * result + ((getPolicyNum() == null) ? 0 : getPolicyNum().hashCode());
        result = prime * result + ((getNdemnityNum() == null) ? 0 : getNdemnityNum().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getCreditLimit() == null) ? 0 : getCreditLimit().hashCode());
        result = prime * result + ((getEffectiveDate() == null) ? 0 : getEffectiveDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getMinLossRate() == null) ? 0 : getMinLossRate().hashCode());
        result = prime * result + ((getGuaranteeMoney() == null) ? 0 : getGuaranteeMoney().hashCode());
        return result;
    }
}