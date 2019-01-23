package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.common.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 商品存货bean
 * @author wuyong
 * @date 2019.1.8
 *
 */
public class GrtMerchandise {
    private String guarantyId;

    private String rightPledgeTypeCd;

    private String rightPledgeNum;

    private String merchandiseTypeCd;

    private String merchandiseName;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal amount;

    private String unit;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date storeStartDate;

    private String storePlace;

    private String storeManager;

    private String storeStutas;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal price;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal marketValue;

    private String registOrg;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getRightPledgeTypeCd() {
        return rightPledgeTypeCd;
    }

    public void setRightPledgeTypeCd(String rightPledgeTypeCd) {
        this.rightPledgeTypeCd = rightPledgeTypeCd == null ? null : rightPledgeTypeCd.trim();
    }

    public String getRightPledgeNum() {
        return rightPledgeNum;
    }

    public void setRightPledgeNum(String rightPledgeNum) {
        this.rightPledgeNum = rightPledgeNum == null ? null : rightPledgeNum.trim();
    }

    public String getMerchandiseTypeCd() {
        return merchandiseTypeCd;
    }

    public void setMerchandiseTypeCd(String merchandiseTypeCd) {
        this.merchandiseTypeCd = merchandiseTypeCd == null ? null : merchandiseTypeCd.trim();
    }

    public String getMerchandiseName() {
        return merchandiseName;
    }

    public void setMerchandiseName(String merchandiseName) {
        this.merchandiseName = merchandiseName == null ? null : merchandiseName.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Date getStoreStartDate() {
        return storeStartDate;
    }

    public void setStoreStartDate(Date storeStartDate) {
        this.storeStartDate = storeStartDate;
    }

    public String getStorePlace() {
        return storePlace;
    }

    public void setStorePlace(String storePlace) {
        this.storePlace = storePlace == null ? null : storePlace.trim();
    }

    public String getStoreManager() {
        return storeManager;
    }

    public void setStoreManager(String storeManager) {
        this.storeManager = storeManager == null ? null : storeManager.trim();
    }

    public String getStoreStutas() {
        return storeStutas;
    }

    public void setStoreStutas(String storeStutas) {
        this.storeStutas = storeStutas == null ? null : storeStutas.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    public String getRegistOrg() {
        return registOrg;
    }

    public void setRegistOrg(String registOrg) {
        this.registOrg = registOrg == null ? null : registOrg.trim();
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
        GrtMerchandise other = (GrtMerchandise) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getRightPledgeTypeCd() == null ? other.getRightPledgeTypeCd() == null : this.getRightPledgeTypeCd().equals(other.getRightPledgeTypeCd()))
            && (this.getRightPledgeNum() == null ? other.getRightPledgeNum() == null : this.getRightPledgeNum().equals(other.getRightPledgeNum()))
            && (this.getMerchandiseTypeCd() == null ? other.getMerchandiseTypeCd() == null : this.getMerchandiseTypeCd().equals(other.getMerchandiseTypeCd()))
            && (this.getMerchandiseName() == null ? other.getMerchandiseName() == null : this.getMerchandiseName().equals(other.getMerchandiseName()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getStoreStartDate() == null ? other.getStoreStartDate() == null : this.getStoreStartDate().equals(other.getStoreStartDate()))
            && (this.getStorePlace() == null ? other.getStorePlace() == null : this.getStorePlace().equals(other.getStorePlace()))
            && (this.getStoreManager() == null ? other.getStoreManager() == null : this.getStoreManager().equals(other.getStoreManager()))
            && (this.getStoreStutas() == null ? other.getStoreStutas() == null : this.getStoreStutas().equals(other.getStoreStutas()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getMarketValue() == null ? other.getMarketValue() == null : this.getMarketValue().equals(other.getMarketValue()))
            && (this.getRegistOrg() == null ? other.getRegistOrg() == null : this.getRegistOrg().equals(other.getRegistOrg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getRightPledgeTypeCd() == null) ? 0 : getRightPledgeTypeCd().hashCode());
        result = prime * result + ((getRightPledgeNum() == null) ? 0 : getRightPledgeNum().hashCode());
        result = prime * result + ((getMerchandiseTypeCd() == null) ? 0 : getMerchandiseTypeCd().hashCode());
        result = prime * result + ((getMerchandiseName() == null) ? 0 : getMerchandiseName().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getStoreStartDate() == null) ? 0 : getStoreStartDate().hashCode());
        result = prime * result + ((getStorePlace() == null) ? 0 : getStorePlace().hashCode());
        result = prime * result + ((getStoreManager() == null) ? 0 : getStoreManager().hashCode());
        result = prime * result + ((getStoreStutas() == null) ? 0 : getStoreStutas().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getMarketValue() == null) ? 0 : getMarketValue().hashCode());
        result = prime * result + ((getRegistOrg() == null) ? 0 : getRegistOrg().hashCode());
        return result;
    }
}