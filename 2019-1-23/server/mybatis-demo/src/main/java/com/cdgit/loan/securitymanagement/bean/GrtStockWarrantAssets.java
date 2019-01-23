package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;

import com.cdgit.loan.csm.common.BigDecimalConvertToString;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 股权bean
 * @author wuyong
 * @date 2019.1.10
 *
 */
public class GrtStockWarrantAssets {
    private String guarantyId;

    private String stockNature;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal controlCount;

    private String controledCompanyName;

    private String controledCompanyType;

    private String controledCompanyStatus;

    private String stockRightName;

    private String stockEquityNoticeNum;

    private String companyHoldBiz;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getStockNature() {
        return stockNature;
    }

    public void setStockNature(String stockNature) {
        this.stockNature = stockNature == null ? null : stockNature.trim();
    }

    public BigDecimal getControlCount() {
        return controlCount;
    }

    public void setControlCount(BigDecimal controlCount) {
        this.controlCount = controlCount;
    }

    public String getControledCompanyName() {
        return controledCompanyName;
    }

    public void setControledCompanyName(String controledCompanyName) {
        this.controledCompanyName = controledCompanyName == null ? null : controledCompanyName.trim();
    }

    public String getControledCompanyType() {
        return controledCompanyType;
    }

    public void setControledCompanyType(String controledCompanyType) {
        this.controledCompanyType = controledCompanyType == null ? null : controledCompanyType.trim();
    }

    public String getControledCompanyStatus() {
        return controledCompanyStatus;
    }

    public void setControledCompanyStatus(String controledCompanyStatus) {
        this.controledCompanyStatus = controledCompanyStatus == null ? null : controledCompanyStatus.trim();
    }

    public String getStockRightName() {
        return stockRightName;
    }

    public void setStockRightName(String stockRightName) {
        this.stockRightName = stockRightName == null ? null : stockRightName.trim();
    }

    public String getStockEquityNoticeNum() {
        return stockEquityNoticeNum;
    }

    public void setStockEquityNoticeNum(String stockEquityNoticeNum) {
        this.stockEquityNoticeNum = stockEquityNoticeNum == null ? null : stockEquityNoticeNum.trim();
    }

    public String getCompanyHoldBiz() {
        return companyHoldBiz;
    }

    public void setCompanyHoldBiz(String companyHoldBiz) {
        this.companyHoldBiz = companyHoldBiz == null ? null : companyHoldBiz.trim();
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
        GrtStockWarrantAssets other = (GrtStockWarrantAssets) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getStockNature() == null ? other.getStockNature() == null : this.getStockNature().equals(other.getStockNature()))
            && (this.getControlCount() == null ? other.getControlCount() == null : this.getControlCount().equals(other.getControlCount()))
            && (this.getControledCompanyName() == null ? other.getControledCompanyName() == null : this.getControledCompanyName().equals(other.getControledCompanyName()))
            && (this.getControledCompanyType() == null ? other.getControledCompanyType() == null : this.getControledCompanyType().equals(other.getControledCompanyType()))
            && (this.getControledCompanyStatus() == null ? other.getControledCompanyStatus() == null : this.getControledCompanyStatus().equals(other.getControledCompanyStatus()))
            && (this.getStockRightName() == null ? other.getStockRightName() == null : this.getStockRightName().equals(other.getStockRightName()))
            && (this.getStockEquityNoticeNum() == null ? other.getStockEquityNoticeNum() == null : this.getStockEquityNoticeNum().equals(other.getStockEquityNoticeNum()))
            && (this.getCompanyHoldBiz() == null ? other.getCompanyHoldBiz() == null : this.getCompanyHoldBiz().equals(other.getCompanyHoldBiz()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getStockNature() == null) ? 0 : getStockNature().hashCode());
        result = prime * result + ((getControlCount() == null) ? 0 : getControlCount().hashCode());
        result = prime * result + ((getControledCompanyName() == null) ? 0 : getControledCompanyName().hashCode());
        result = prime * result + ((getControledCompanyType() == null) ? 0 : getControledCompanyType().hashCode());
        result = prime * result + ((getControledCompanyStatus() == null) ? 0 : getControledCompanyStatus().hashCode());
        result = prime * result + ((getStockRightName() == null) ? 0 : getStockRightName().hashCode());
        result = prime * result + ((getStockEquityNoticeNum() == null) ? 0 : getStockEquityNoticeNum().hashCode());
        result = prime * result + ((getCompanyHoldBiz() == null) ? 0 : getCompanyHoldBiz().hashCode());
        return result;
    }
}