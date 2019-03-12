package com.cdgit.loan.securitymanagement.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 股票bean
 * @author wuyong
 * @date 2019.1.10
 *
 */
public class GrtStockRightAssets {
    private String guarantyId;

    private String accrualType;

    private String investType;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date intoMarketDate;

    private String stockCode;

    private String trusteeship;

    private String stockDistinctionType;

    private String stockName;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getAccrualType() {
        return accrualType;
    }

    public void setAccrualType(String accrualType) {
        this.accrualType = accrualType == null ? null : accrualType.trim();
    }

    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType == null ? null : investType.trim();
    }

    public Date getIntoMarketDate() {
        return intoMarketDate;
    }

    public void setIntoMarketDate(Date intoMarketDate) {
        this.intoMarketDate = intoMarketDate;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public String getTrusteeship() {
        return trusteeship;
    }

    public void setTrusteeship(String trusteeship) {
        this.trusteeship = trusteeship == null ? null : trusteeship.trim();
    }

    public String getStockDistinctionType() {
        return stockDistinctionType;
    }

    public void setStockDistinctionType(String stockDistinctionType) {
        this.stockDistinctionType = stockDistinctionType == null ? null : stockDistinctionType.trim();
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName == null ? null : stockName.trim();
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
        GrtStockRightAssets other = (GrtStockRightAssets) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getAccrualType() == null ? other.getAccrualType() == null : this.getAccrualType().equals(other.getAccrualType()))
            && (this.getInvestType() == null ? other.getInvestType() == null : this.getInvestType().equals(other.getInvestType()))
            && (this.getIntoMarketDate() == null ? other.getIntoMarketDate() == null : this.getIntoMarketDate().equals(other.getIntoMarketDate()))
            && (this.getStockCode() == null ? other.getStockCode() == null : this.getStockCode().equals(other.getStockCode()))
            && (this.getTrusteeship() == null ? other.getTrusteeship() == null : this.getTrusteeship().equals(other.getTrusteeship()))
            && (this.getStockDistinctionType() == null ? other.getStockDistinctionType() == null : this.getStockDistinctionType().equals(other.getStockDistinctionType()))
            && (this.getStockName() == null ? other.getStockName() == null : this.getStockName().equals(other.getStockName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getAccrualType() == null) ? 0 : getAccrualType().hashCode());
        result = prime * result + ((getInvestType() == null) ? 0 : getInvestType().hashCode());
        result = prime * result + ((getIntoMarketDate() == null) ? 0 : getIntoMarketDate().hashCode());
        result = prime * result + ((getStockCode() == null) ? 0 : getStockCode().hashCode());
        result = prime * result + ((getTrusteeship() == null) ? 0 : getTrusteeship().hashCode());
        result = prime * result + ((getStockDistinctionType() == null) ? 0 : getStockDistinctionType().hashCode());
        result = prime * result + ((getStockName() == null) ? 0 : getStockName().hashCode());
        return result;
    }
}