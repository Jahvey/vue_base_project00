package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.common.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 存单bean
 * @author wuyong
 * @date 2018.12.27
 *
 */
public class GrtDeposit {
    private String guarantyId;

    private String depositReceiptNum;

    private String currencyCd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal amt;

    private String openBank;

    private String accountNum;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date expireDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date startDate;

    private String stopPaymentInd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal depositTerm;

    private String volumenum;

    private String isMyBank;

    private String depositType;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getDepositReceiptNum() {
        return depositReceiptNum;
    }

    public void setDepositReceiptNum(String depositReceiptNum) {
        this.depositReceiptNum = depositReceiptNum == null ? null : depositReceiptNum.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank == null ? null : openBank.trim();
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum == null ? null : accountNum.trim();
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStopPaymentInd() {
        return stopPaymentInd;
    }

    public void setStopPaymentInd(String stopPaymentInd) {
        this.stopPaymentInd = stopPaymentInd == null ? null : stopPaymentInd.trim();
    }

    public BigDecimal getDepositTerm() {
        return depositTerm;
    }

    public void setDepositTerm(BigDecimal depositTerm) {
        this.depositTerm = depositTerm;
    }

    public String getVolumenum() {
        return volumenum;
    }

    public void setVolumenum(String volumenum) {
        this.volumenum = volumenum == null ? null : volumenum.trim();
    }

    public String getIsMyBank() {
        return isMyBank;
    }

    public void setIsMyBank(String isMyBank) {
        this.isMyBank = isMyBank == null ? null : isMyBank.trim();
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType == null ? null : depositType.trim();
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
        GrtDeposit other = (GrtDeposit) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getDepositReceiptNum() == null ? other.getDepositReceiptNum() == null : this.getDepositReceiptNum().equals(other.getDepositReceiptNum()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getAmt() == null ? other.getAmt() == null : this.getAmt().equals(other.getAmt()))
            && (this.getOpenBank() == null ? other.getOpenBank() == null : this.getOpenBank().equals(other.getOpenBank()))
            && (this.getAccountNum() == null ? other.getAccountNum() == null : this.getAccountNum().equals(other.getAccountNum()))
            && (this.getExpireDate() == null ? other.getExpireDate() == null : this.getExpireDate().equals(other.getExpireDate()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getStopPaymentInd() == null ? other.getStopPaymentInd() == null : this.getStopPaymentInd().equals(other.getStopPaymentInd()))
            && (this.getDepositTerm() == null ? other.getDepositTerm() == null : this.getDepositTerm().equals(other.getDepositTerm()))
            && (this.getVolumenum() == null ? other.getVolumenum() == null : this.getVolumenum().equals(other.getVolumenum()))
            && (this.getIsMyBank() == null ? other.getIsMyBank() == null : this.getIsMyBank().equals(other.getIsMyBank()))
            && (this.getDepositType() == null ? other.getDepositType() == null : this.getDepositType().equals(other.getDepositType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getDepositReceiptNum() == null) ? 0 : getDepositReceiptNum().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getAmt() == null) ? 0 : getAmt().hashCode());
        result = prime * result + ((getOpenBank() == null) ? 0 : getOpenBank().hashCode());
        result = prime * result + ((getAccountNum() == null) ? 0 : getAccountNum().hashCode());
        result = prime * result + ((getExpireDate() == null) ? 0 : getExpireDate().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getStopPaymentInd() == null) ? 0 : getStopPaymentInd().hashCode());
        result = prime * result + ((getDepositTerm() == null) ? 0 : getDepositTerm().hashCode());
        result = prime * result + ((getVolumenum() == null) ? 0 : getVolumenum().hashCode());
        result = prime * result + ((getIsMyBank() == null) ? 0 : getIsMyBank().hashCode());
        result = prime * result + ((getDepositType() == null) ? 0 : getDepositType().hashCode());
        return result;
    }
}