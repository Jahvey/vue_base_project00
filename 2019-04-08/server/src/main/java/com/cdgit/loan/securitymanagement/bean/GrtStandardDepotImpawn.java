package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 仓单bean
 * @author wuyong
 * @date 2019.1.10
 *
 */
public class GrtStandardDepotImpawn {
    private String guarantyId;

    private String depotTypeCd;

    private String bourse;

    private String breed;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal holdNum;

    private String amount;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date availabilityExpirationDate;

    private String depotName;

    private String consignorName;

    private String goodsName;

    private String logo;

    private String rank;

    private String extendField;

    private String depotImpawnSort;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date enterDepotDate;

    private String enterDepotApplyUser;

    private String enterDepotApproveUser;

    private String depotImpawnApplyUser;

    private String warehouseAddress;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal custodyFee;

    private String isPayCustodyFee;

    private String otherNote;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getDepotTypeCd() {
        return depotTypeCd;
    }

    public void setDepotTypeCd(String depotTypeCd) {
        this.depotTypeCd = depotTypeCd == null ? null : depotTypeCd.trim();
    }

    public String getBourse() {
        return bourse;
    }

    public void setBourse(String bourse) {
        this.bourse = bourse == null ? null : bourse.trim();
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed == null ? null : breed.trim();
    }

    public BigDecimal getHoldNum() {
        return holdNum;
    }

    public void setHoldNum(BigDecimal holdNum) {
        this.holdNum = holdNum;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public Date getAvailabilityExpirationDate() {
        return availabilityExpirationDate;
    }

    public void setAvailabilityExpirationDate(Date availabilityExpirationDate) {
        this.availabilityExpirationDate = availabilityExpirationDate;
    }

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName == null ? null : depotName.trim();
    }

    public String getConsignorName() {
        return consignorName;
    }

    public void setConsignorName(String consignorName) {
        this.consignorName = consignorName == null ? null : consignorName.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    public String getExtendField() {
        return extendField;
    }

    public void setExtendField(String extendField) {
        this.extendField = extendField == null ? null : extendField.trim();
    }

    public String getDepotImpawnSort() {
        return depotImpawnSort;
    }

    public void setDepotImpawnSort(String depotImpawnSort) {
        this.depotImpawnSort = depotImpawnSort == null ? null : depotImpawnSort.trim();
    }

    public Date getEnterDepotDate() {
        return enterDepotDate;
    }

    public void setEnterDepotDate(Date enterDepotDate) {
        this.enterDepotDate = enterDepotDate;
    }

    public String getEnterDepotApplyUser() {
        return enterDepotApplyUser;
    }

    public void setEnterDepotApplyUser(String enterDepotApplyUser) {
        this.enterDepotApplyUser = enterDepotApplyUser == null ? null : enterDepotApplyUser.trim();
    }

    public String getEnterDepotApproveUser() {
        return enterDepotApproveUser;
    }

    public void setEnterDepotApproveUser(String enterDepotApproveUser) {
        this.enterDepotApproveUser = enterDepotApproveUser == null ? null : enterDepotApproveUser.trim();
    }

    public String getDepotImpawnApplyUser() {
        return depotImpawnApplyUser;
    }

    public void setDepotImpawnApplyUser(String depotImpawnApplyUser) {
        this.depotImpawnApplyUser = depotImpawnApplyUser == null ? null : depotImpawnApplyUser.trim();
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress == null ? null : warehouseAddress.trim();
    }

    public BigDecimal getCustodyFee() {
        return custodyFee;
    }

    public void setCustodyFee(BigDecimal custodyFee) {
        this.custodyFee = custodyFee;
    }

    public String getIsPayCustodyFee() {
        return isPayCustodyFee;
    }

    public void setIsPayCustodyFee(String isPayCustodyFee) {
        this.isPayCustodyFee = isPayCustodyFee == null ? null : isPayCustodyFee.trim();
    }

    public String getOtherNote() {
        return otherNote;
    }

    public void setOtherNote(String otherNote) {
        this.otherNote = otherNote == null ? null : otherNote.trim();
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
        GrtStandardDepotImpawn other = (GrtStandardDepotImpawn) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getDepotTypeCd() == null ? other.getDepotTypeCd() == null : this.getDepotTypeCd().equals(other.getDepotTypeCd()))
            && (this.getBourse() == null ? other.getBourse() == null : this.getBourse().equals(other.getBourse()))
            && (this.getBreed() == null ? other.getBreed() == null : this.getBreed().equals(other.getBreed()))
            && (this.getHoldNum() == null ? other.getHoldNum() == null : this.getHoldNum().equals(other.getHoldNum()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getAvailabilityExpirationDate() == null ? other.getAvailabilityExpirationDate() == null : this.getAvailabilityExpirationDate().equals(other.getAvailabilityExpirationDate()))
            && (this.getDepotName() == null ? other.getDepotName() == null : this.getDepotName().equals(other.getDepotName()))
            && (this.getConsignorName() == null ? other.getConsignorName() == null : this.getConsignorName().equals(other.getConsignorName()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
            && (this.getRank() == null ? other.getRank() == null : this.getRank().equals(other.getRank()))
            && (this.getExtendField() == null ? other.getExtendField() == null : this.getExtendField().equals(other.getExtendField()))
            && (this.getDepotImpawnSort() == null ? other.getDepotImpawnSort() == null : this.getDepotImpawnSort().equals(other.getDepotImpawnSort()))
            && (this.getEnterDepotDate() == null ? other.getEnterDepotDate() == null : this.getEnterDepotDate().equals(other.getEnterDepotDate()))
            && (this.getEnterDepotApplyUser() == null ? other.getEnterDepotApplyUser() == null : this.getEnterDepotApplyUser().equals(other.getEnterDepotApplyUser()))
            && (this.getEnterDepotApproveUser() == null ? other.getEnterDepotApproveUser() == null : this.getEnterDepotApproveUser().equals(other.getEnterDepotApproveUser()))
            && (this.getDepotImpawnApplyUser() == null ? other.getDepotImpawnApplyUser() == null : this.getDepotImpawnApplyUser().equals(other.getDepotImpawnApplyUser()))
            && (this.getWarehouseAddress() == null ? other.getWarehouseAddress() == null : this.getWarehouseAddress().equals(other.getWarehouseAddress()))
            && (this.getCustodyFee() == null ? other.getCustodyFee() == null : this.getCustodyFee().equals(other.getCustodyFee()))
            && (this.getIsPayCustodyFee() == null ? other.getIsPayCustodyFee() == null : this.getIsPayCustodyFee().equals(other.getIsPayCustodyFee()))
            && (this.getOtherNote() == null ? other.getOtherNote() == null : this.getOtherNote().equals(other.getOtherNote()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getDepotTypeCd() == null) ? 0 : getDepotTypeCd().hashCode());
        result = prime * result + ((getBourse() == null) ? 0 : getBourse().hashCode());
        result = prime * result + ((getBreed() == null) ? 0 : getBreed().hashCode());
        result = prime * result + ((getHoldNum() == null) ? 0 : getHoldNum().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getAvailabilityExpirationDate() == null) ? 0 : getAvailabilityExpirationDate().hashCode());
        result = prime * result + ((getDepotName() == null) ? 0 : getDepotName().hashCode());
        result = prime * result + ((getConsignorName() == null) ? 0 : getConsignorName().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
        result = prime * result + ((getRank() == null) ? 0 : getRank().hashCode());
        result = prime * result + ((getExtendField() == null) ? 0 : getExtendField().hashCode());
        result = prime * result + ((getDepotImpawnSort() == null) ? 0 : getDepotImpawnSort().hashCode());
        result = prime * result + ((getEnterDepotDate() == null) ? 0 : getEnterDepotDate().hashCode());
        result = prime * result + ((getEnterDepotApplyUser() == null) ? 0 : getEnterDepotApplyUser().hashCode());
        result = prime * result + ((getEnterDepotApproveUser() == null) ? 0 : getEnterDepotApproveUser().hashCode());
        result = prime * result + ((getDepotImpawnApplyUser() == null) ? 0 : getDepotImpawnApplyUser().hashCode());
        result = prime * result + ((getWarehouseAddress() == null) ? 0 : getWarehouseAddress().hashCode());
        result = prime * result + ((getCustodyFee() == null) ? 0 : getCustodyFee().hashCode());
        result = prime * result + ((getIsPayCustodyFee() == null) ? 0 : getIsPayCustodyFee().hashCode());
        result = prime * result + ((getOtherNote() == null) ? 0 : getOtherNote().hashCode());
        return result;
    }
}