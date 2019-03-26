package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 股权股票基金公共信息bean
 * @author wuyong
 * @date 2019.1.10
 *
 */
public class GrtStockPledge {
    private String guarantyId;

    private String stockListedInd;

    private String stockCharacter;

    private String stockRegistrationOrg;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal stockCount;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal controlPercentage;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal netValuePerStock;

    private String netValueCurrencyCd;

    private String stockName;

    private String stockIssueTypeCd;

    private String marketPlace;

    private String marketCompanyName;

    private String marketCompanyTypeCd;

    private String marketCompanyOperStatus;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal averagePriceLatestYear;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal averagePriceLatestDay;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getStockListedInd() {
        return stockListedInd;
    }

    public void setStockListedInd(String stockListedInd) {
        this.stockListedInd = stockListedInd == null ? null : stockListedInd.trim();
    }

    public String getStockCharacter() {
        return stockCharacter;
    }

    public void setStockCharacter(String stockCharacter) {
        this.stockCharacter = stockCharacter == null ? null : stockCharacter.trim();
    }

    public String getStockRegistrationOrg() {
        return stockRegistrationOrg;
    }

    public void setStockRegistrationOrg(String stockRegistrationOrg) {
        this.stockRegistrationOrg = stockRegistrationOrg == null ? null : stockRegistrationOrg.trim();
    }

    public BigDecimal getStockCount() {
        return stockCount;
    }

    public void setStockCount(BigDecimal stockCount) {
        this.stockCount = stockCount;
    }

    public BigDecimal getControlPercentage() {
        return controlPercentage;
    }

    public void setControlPercentage(BigDecimal controlPercentage) {
        this.controlPercentage = controlPercentage;
    }

    public BigDecimal getNetValuePerStock() {
        return netValuePerStock;
    }

    public void setNetValuePerStock(BigDecimal netValuePerStock) {
        this.netValuePerStock = netValuePerStock;
    }

    public String getNetValueCurrencyCd() {
        return netValueCurrencyCd;
    }

    public void setNetValueCurrencyCd(String netValueCurrencyCd) {
        this.netValueCurrencyCd = netValueCurrencyCd == null ? null : netValueCurrencyCd.trim();
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName == null ? null : stockName.trim();
    }

    public String getStockIssueTypeCd() {
        return stockIssueTypeCd;
    }

    public void setStockIssueTypeCd(String stockIssueTypeCd) {
        this.stockIssueTypeCd = stockIssueTypeCd == null ? null : stockIssueTypeCd.trim();
    }

    public String getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(String marketPlace) {
        this.marketPlace = marketPlace == null ? null : marketPlace.trim();
    }

    public String getMarketCompanyName() {
        return marketCompanyName;
    }

    public void setMarketCompanyName(String marketCompanyName) {
        this.marketCompanyName = marketCompanyName == null ? null : marketCompanyName.trim();
    }

    public String getMarketCompanyTypeCd() {
        return marketCompanyTypeCd;
    }

    public void setMarketCompanyTypeCd(String marketCompanyTypeCd) {
        this.marketCompanyTypeCd = marketCompanyTypeCd == null ? null : marketCompanyTypeCd.trim();
    }

    public String getMarketCompanyOperStatus() {
        return marketCompanyOperStatus;
    }

    public void setMarketCompanyOperStatus(String marketCompanyOperStatus) {
        this.marketCompanyOperStatus = marketCompanyOperStatus == null ? null : marketCompanyOperStatus.trim();
    }

    public BigDecimal getAveragePriceLatestYear() {
        return averagePriceLatestYear;
    }

    public void setAveragePriceLatestYear(BigDecimal averagePriceLatestYear) {
        this.averagePriceLatestYear = averagePriceLatestYear;
    }

    public BigDecimal getAveragePriceLatestDay() {
        return averagePriceLatestDay;
    }

    public void setAveragePriceLatestDay(BigDecimal averagePriceLatestDay) {
        this.averagePriceLatestDay = averagePriceLatestDay;
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
        GrtStockPledge other = (GrtStockPledge) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getStockListedInd() == null ? other.getStockListedInd() == null : this.getStockListedInd().equals(other.getStockListedInd()))
            && (this.getStockCharacter() == null ? other.getStockCharacter() == null : this.getStockCharacter().equals(other.getStockCharacter()))
            && (this.getStockRegistrationOrg() == null ? other.getStockRegistrationOrg() == null : this.getStockRegistrationOrg().equals(other.getStockRegistrationOrg()))
            && (this.getStockCount() == null ? other.getStockCount() == null : this.getStockCount().equals(other.getStockCount()))
            && (this.getControlPercentage() == null ? other.getControlPercentage() == null : this.getControlPercentage().equals(other.getControlPercentage()))
            && (this.getNetValuePerStock() == null ? other.getNetValuePerStock() == null : this.getNetValuePerStock().equals(other.getNetValuePerStock()))
            && (this.getNetValueCurrencyCd() == null ? other.getNetValueCurrencyCd() == null : this.getNetValueCurrencyCd().equals(other.getNetValueCurrencyCd()))
            && (this.getStockName() == null ? other.getStockName() == null : this.getStockName().equals(other.getStockName()))
            && (this.getStockIssueTypeCd() == null ? other.getStockIssueTypeCd() == null : this.getStockIssueTypeCd().equals(other.getStockIssueTypeCd()))
            && (this.getMarketPlace() == null ? other.getMarketPlace() == null : this.getMarketPlace().equals(other.getMarketPlace()))
            && (this.getMarketCompanyName() == null ? other.getMarketCompanyName() == null : this.getMarketCompanyName().equals(other.getMarketCompanyName()))
            && (this.getMarketCompanyTypeCd() == null ? other.getMarketCompanyTypeCd() == null : this.getMarketCompanyTypeCd().equals(other.getMarketCompanyTypeCd()))
            && (this.getMarketCompanyOperStatus() == null ? other.getMarketCompanyOperStatus() == null : this.getMarketCompanyOperStatus().equals(other.getMarketCompanyOperStatus()))
            && (this.getAveragePriceLatestYear() == null ? other.getAveragePriceLatestYear() == null : this.getAveragePriceLatestYear().equals(other.getAveragePriceLatestYear()))
            && (this.getAveragePriceLatestDay() == null ? other.getAveragePriceLatestDay() == null : this.getAveragePriceLatestDay().equals(other.getAveragePriceLatestDay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getStockListedInd() == null) ? 0 : getStockListedInd().hashCode());
        result = prime * result + ((getStockCharacter() == null) ? 0 : getStockCharacter().hashCode());
        result = prime * result + ((getStockRegistrationOrg() == null) ? 0 : getStockRegistrationOrg().hashCode());
        result = prime * result + ((getStockCount() == null) ? 0 : getStockCount().hashCode());
        result = prime * result + ((getControlPercentage() == null) ? 0 : getControlPercentage().hashCode());
        result = prime * result + ((getNetValuePerStock() == null) ? 0 : getNetValuePerStock().hashCode());
        result = prime * result + ((getNetValueCurrencyCd() == null) ? 0 : getNetValueCurrencyCd().hashCode());
        result = prime * result + ((getStockName() == null) ? 0 : getStockName().hashCode());
        result = prime * result + ((getStockIssueTypeCd() == null) ? 0 : getStockIssueTypeCd().hashCode());
        result = prime * result + ((getMarketPlace() == null) ? 0 : getMarketPlace().hashCode());
        result = prime * result + ((getMarketCompanyName() == null) ? 0 : getMarketCompanyName().hashCode());
        result = prime * result + ((getMarketCompanyTypeCd() == null) ? 0 : getMarketCompanyTypeCd().hashCode());
        result = prime * result + ((getMarketCompanyOperStatus() == null) ? 0 : getMarketCompanyOperStatus().hashCode());
        result = prime * result + ((getAveragePriceLatestYear() == null) ? 0 : getAveragePriceLatestYear().hashCode());
        result = prime * result + ((getAveragePriceLatestDay() == null) ? 0 : getAveragePriceLatestDay().hashCode());
        return result;
    }
}