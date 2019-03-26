package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbSysExchangeRatePo {
    private String exchangeRateId;

    private String currencyCd;

    private BigDecimal discountRateOfRmb;

    private String discountUnit;

    private String validityInd;

    private BigDecimal actualExchangeRate;

    private Date discountDate;

    private String unitCurrencyCd;

    private String valuationCurrencyCd;

    private BigDecimal buyingPrice;

    private BigDecimal sellingPrice;

    public String getExchangeRateId() {
        return exchangeRateId;
    }

    public void setExchangeRateId(String exchangeRateId) {
        this.exchangeRateId = exchangeRateId == null ? null : exchangeRateId.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getDiscountRateOfRmb() {
        return discountRateOfRmb;
    }

    public void setDiscountRateOfRmb(BigDecimal discountRateOfRmb) {
        this.discountRateOfRmb = discountRateOfRmb;
    }

    public String getDiscountUnit() {
        return discountUnit;
    }

    public void setDiscountUnit(String discountUnit) {
        this.discountUnit = discountUnit == null ? null : discountUnit.trim();
    }

    public String getValidityInd() {
        return validityInd;
    }

    public void setValidityInd(String validityInd) {
        this.validityInd = validityInd == null ? null : validityInd.trim();
    }

    public BigDecimal getActualExchangeRate() {
        return actualExchangeRate;
    }

    public void setActualExchangeRate(BigDecimal actualExchangeRate) {
        this.actualExchangeRate = actualExchangeRate;
    }

    public Date getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(Date discountDate) {
        this.discountDate = discountDate;
    }

    public String getUnitCurrencyCd() {
        return unitCurrencyCd;
    }

    public void setUnitCurrencyCd(String unitCurrencyCd) {
        this.unitCurrencyCd = unitCurrencyCd == null ? null : unitCurrencyCd.trim();
    }

    public String getValuationCurrencyCd() {
        return valuationCurrencyCd;
    }

    public void setValuationCurrencyCd(String valuationCurrencyCd) {
        this.valuationCurrencyCd = valuationCurrencyCd == null ? null : valuationCurrencyCd.trim();
    }

    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}