package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;

import com.cdgit.loan.csm.common.BigDecimalConvertToString;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 林权bean
 * @author wuyong
 * @date 2019.1.9
 *
 */
public class GrtWoodlandProperty {
    private String guarantyId;

    private String woodlandPropertyTypeCd;

    private String woodlandPropertyNum;

    private String woodlandType;

    private String woodlandPlace;

    private String woodlandBorderline;

    private String woodlandArea;

    private String woodsTypeCd;

    private String treeKind;

    private String treeYears;

    private String farmingArea;

    private String woodlandTerraTypeCd;

    private String remainAvailabilityTerm;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal treeNumber;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getWoodlandPropertyTypeCd() {
        return woodlandPropertyTypeCd;
    }

    public void setWoodlandPropertyTypeCd(String woodlandPropertyTypeCd) {
        this.woodlandPropertyTypeCd = woodlandPropertyTypeCd == null ? null : woodlandPropertyTypeCd.trim();
    }

    public String getWoodlandPropertyNum() {
        return woodlandPropertyNum;
    }

    public void setWoodlandPropertyNum(String woodlandPropertyNum) {
        this.woodlandPropertyNum = woodlandPropertyNum == null ? null : woodlandPropertyNum.trim();
    }

    public String getWoodlandType() {
        return woodlandType;
    }

    public void setWoodlandType(String woodlandType) {
        this.woodlandType = woodlandType == null ? null : woodlandType.trim();
    }

    public String getWoodlandPlace() {
        return woodlandPlace;
    }

    public void setWoodlandPlace(String woodlandPlace) {
        this.woodlandPlace = woodlandPlace == null ? null : woodlandPlace.trim();
    }

    public String getWoodlandBorderline() {
        return woodlandBorderline;
    }

    public void setWoodlandBorderline(String woodlandBorderline) {
        this.woodlandBorderline = woodlandBorderline == null ? null : woodlandBorderline.trim();
    }

    public String getWoodlandArea() {
        return woodlandArea;
    }

    public void setWoodlandArea(String woodlandArea) {
        this.woodlandArea = woodlandArea == null ? null : woodlandArea.trim();
    }

    public String getWoodsTypeCd() {
        return woodsTypeCd;
    }

    public void setWoodsTypeCd(String woodsTypeCd) {
        this.woodsTypeCd = woodsTypeCd == null ? null : woodsTypeCd.trim();
    }

    public String getTreeKind() {
        return treeKind;
    }

    public void setTreeKind(String treeKind) {
        this.treeKind = treeKind == null ? null : treeKind.trim();
    }

    public String getTreeYears() {
        return treeYears;
    }

    public void setTreeYears(String treeYears) {
        this.treeYears = treeYears == null ? null : treeYears.trim();
    }

    public String getFarmingArea() {
        return farmingArea;
    }

    public void setFarmingArea(String farmingArea) {
        this.farmingArea = farmingArea == null ? null : farmingArea.trim();
    }

    public String getWoodlandTerraTypeCd() {
        return woodlandTerraTypeCd;
    }

    public void setWoodlandTerraTypeCd(String woodlandTerraTypeCd) {
        this.woodlandTerraTypeCd = woodlandTerraTypeCd == null ? null : woodlandTerraTypeCd.trim();
    }

    public String getRemainAvailabilityTerm() {
        return remainAvailabilityTerm;
    }

    public void setRemainAvailabilityTerm(String remainAvailabilityTerm) {
        this.remainAvailabilityTerm = remainAvailabilityTerm == null ? null : remainAvailabilityTerm.trim();
    }

    public BigDecimal getTreeNumber() {
        return treeNumber;
    }

    public void setTreeNumber(BigDecimal treeNumber) {
        this.treeNumber = treeNumber;
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
        GrtWoodlandProperty other = (GrtWoodlandProperty) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getWoodlandPropertyTypeCd() == null ? other.getWoodlandPropertyTypeCd() == null : this.getWoodlandPropertyTypeCd().equals(other.getWoodlandPropertyTypeCd()))
            && (this.getWoodlandPropertyNum() == null ? other.getWoodlandPropertyNum() == null : this.getWoodlandPropertyNum().equals(other.getWoodlandPropertyNum()))
            && (this.getWoodlandType() == null ? other.getWoodlandType() == null : this.getWoodlandType().equals(other.getWoodlandType()))
            && (this.getWoodlandPlace() == null ? other.getWoodlandPlace() == null : this.getWoodlandPlace().equals(other.getWoodlandPlace()))
            && (this.getWoodlandBorderline() == null ? other.getWoodlandBorderline() == null : this.getWoodlandBorderline().equals(other.getWoodlandBorderline()))
            && (this.getWoodlandArea() == null ? other.getWoodlandArea() == null : this.getWoodlandArea().equals(other.getWoodlandArea()))
            && (this.getWoodsTypeCd() == null ? other.getWoodsTypeCd() == null : this.getWoodsTypeCd().equals(other.getWoodsTypeCd()))
            && (this.getTreeKind() == null ? other.getTreeKind() == null : this.getTreeKind().equals(other.getTreeKind()))
            && (this.getTreeYears() == null ? other.getTreeYears() == null : this.getTreeYears().equals(other.getTreeYears()))
            && (this.getFarmingArea() == null ? other.getFarmingArea() == null : this.getFarmingArea().equals(other.getFarmingArea()))
            && (this.getWoodlandTerraTypeCd() == null ? other.getWoodlandTerraTypeCd() == null : this.getWoodlandTerraTypeCd().equals(other.getWoodlandTerraTypeCd()))
            && (this.getRemainAvailabilityTerm() == null ? other.getRemainAvailabilityTerm() == null : this.getRemainAvailabilityTerm().equals(other.getRemainAvailabilityTerm()))
            && (this.getTreeNumber() == null ? other.getTreeNumber() == null : this.getTreeNumber().equals(other.getTreeNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getWoodlandPropertyTypeCd() == null) ? 0 : getWoodlandPropertyTypeCd().hashCode());
        result = prime * result + ((getWoodlandPropertyNum() == null) ? 0 : getWoodlandPropertyNum().hashCode());
        result = prime * result + ((getWoodlandType() == null) ? 0 : getWoodlandType().hashCode());
        result = prime * result + ((getWoodlandPlace() == null) ? 0 : getWoodlandPlace().hashCode());
        result = prime * result + ((getWoodlandBorderline() == null) ? 0 : getWoodlandBorderline().hashCode());
        result = prime * result + ((getWoodlandArea() == null) ? 0 : getWoodlandArea().hashCode());
        result = prime * result + ((getWoodsTypeCd() == null) ? 0 : getWoodsTypeCd().hashCode());
        result = prime * result + ((getTreeKind() == null) ? 0 : getTreeKind().hashCode());
        result = prime * result + ((getTreeYears() == null) ? 0 : getTreeYears().hashCode());
        result = prime * result + ((getFarmingArea() == null) ? 0 : getFarmingArea().hashCode());
        result = prime * result + ((getWoodlandTerraTypeCd() == null) ? 0 : getWoodlandTerraTypeCd().hashCode());
        result = prime * result + ((getRemainAvailabilityTerm() == null) ? 0 : getRemainAvailabilityTerm().hashCode());
        result = prime * result + ((getTreeNumber() == null) ? 0 : getTreeNumber().hashCode());
        return result;
    }
}