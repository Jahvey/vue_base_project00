package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 工资账户bean
 * @author wuyong
 * @date 2019.1.8
 *
 */
public class GrtEarningsAccount {
    private String guarantyId;

    private String personalSettlementAccount;

    private String currencySpecies;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal monthSendEarnings;

    private String openBankAccount;

    private String isPayment;

    private String isCommonPerson;

    private String otherExplain;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getPersonalSettlementAccount() {
        return personalSettlementAccount;
    }

    public void setPersonalSettlementAccount(String personalSettlementAccount) {
        this.personalSettlementAccount = personalSettlementAccount == null ? null : personalSettlementAccount.trim();
    }

    public String getCurrencySpecies() {
        return currencySpecies;
    }

    public void setCurrencySpecies(String currencySpecies) {
        this.currencySpecies = currencySpecies == null ? null : currencySpecies.trim();
    }

    public BigDecimal getMonthSendEarnings() {
        return monthSendEarnings;
    }

    public void setMonthSendEarnings(BigDecimal monthSendEarnings) {
        this.monthSendEarnings = monthSendEarnings;
    }

    public String getOpenBankAccount() {
        return openBankAccount;
    }

    public void setOpenBankAccount(String openBankAccount) {
        this.openBankAccount = openBankAccount == null ? null : openBankAccount.trim();
    }

    public String getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(String isPayment) {
        this.isPayment = isPayment == null ? null : isPayment.trim();
    }

    public String getIsCommonPerson() {
        return isCommonPerson;
    }

    public void setIsCommonPerson(String isCommonPerson) {
        this.isCommonPerson = isCommonPerson == null ? null : isCommonPerson.trim();
    }

    public String getOtherExplain() {
        return otherExplain;
    }

    public void setOtherExplain(String otherExplain) {
        this.otherExplain = otherExplain == null ? null : otherExplain.trim();
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
        GrtEarningsAccount other = (GrtEarningsAccount) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getPersonalSettlementAccount() == null ? other.getPersonalSettlementAccount() == null : this.getPersonalSettlementAccount().equals(other.getPersonalSettlementAccount()))
            && (this.getCurrencySpecies() == null ? other.getCurrencySpecies() == null : this.getCurrencySpecies().equals(other.getCurrencySpecies()))
            && (this.getMonthSendEarnings() == null ? other.getMonthSendEarnings() == null : this.getMonthSendEarnings().equals(other.getMonthSendEarnings()))
            && (this.getOpenBankAccount() == null ? other.getOpenBankAccount() == null : this.getOpenBankAccount().equals(other.getOpenBankAccount()))
            && (this.getIsPayment() == null ? other.getIsPayment() == null : this.getIsPayment().equals(other.getIsPayment()))
            && (this.getIsCommonPerson() == null ? other.getIsCommonPerson() == null : this.getIsCommonPerson().equals(other.getIsCommonPerson()))
            && (this.getOtherExplain() == null ? other.getOtherExplain() == null : this.getOtherExplain().equals(other.getOtherExplain()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getPersonalSettlementAccount() == null) ? 0 : getPersonalSettlementAccount().hashCode());
        result = prime * result + ((getCurrencySpecies() == null) ? 0 : getCurrencySpecies().hashCode());
        result = prime * result + ((getMonthSendEarnings() == null) ? 0 : getMonthSendEarnings().hashCode());
        result = prime * result + ((getOpenBankAccount() == null) ? 0 : getOpenBankAccount().hashCode());
        result = prime * result + ((getIsPayment() == null) ? 0 : getIsPayment().hashCode());
        result = prime * result + ((getIsCommonPerson() == null) ? 0 : getIsCommonPerson().hashCode());
        result = prime * result + ((getOtherExplain() == null) ? 0 : getOtherExplain().hashCode());
        return result;
    }
}