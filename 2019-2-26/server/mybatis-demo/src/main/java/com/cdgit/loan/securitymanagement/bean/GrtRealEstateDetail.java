package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 抵质押品房地产bean
 * @author wuyong
 * @date 2019.1.3
 *
 */
public class GrtRealEstateDetail {
    private String guarantyId;

    private String roomNum;

    private String buildingNum;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal floorCount;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal floorHeight;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal buildArea;

    private String manageStatus;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal landArea;

    private String roomUser;

    private String direction;

    private String houseModel;

    private String fitmentDegree;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal courtArea;

    private String selfCarbarnInd;

    private String floor;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum == null ? null : roomNum.trim();
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum == null ? null : buildingNum.trim();
    }

    public BigDecimal getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(BigDecimal floorCount) {
        this.floorCount = floorCount;
    }

    public BigDecimal getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(BigDecimal floorHeight) {
        this.floorHeight = floorHeight;
    }

    public BigDecimal getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(BigDecimal buildArea) {
        this.buildArea = buildArea;
    }

    public String getManageStatus() {
        return manageStatus;
    }

    public void setManageStatus(String manageStatus) {
        this.manageStatus = manageStatus == null ? null : manageStatus.trim();
    }

    public BigDecimal getLandArea() {
        return landArea;
    }

    public void setLandArea(BigDecimal landArea) {
        this.landArea = landArea;
    }

    public String getRoomUser() {
        return roomUser;
    }

    public void setRoomUser(String roomUser) {
        this.roomUser = roomUser == null ? null : roomUser.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getHouseModel() {
        return houseModel;
    }

    public void setHouseModel(String houseModel) {
        this.houseModel = houseModel == null ? null : houseModel.trim();
    }

    public String getFitmentDegree() {
        return fitmentDegree;
    }

    public void setFitmentDegree(String fitmentDegree) {
        this.fitmentDegree = fitmentDegree == null ? null : fitmentDegree.trim();
    }

    public BigDecimal getCourtArea() {
        return courtArea;
    }

    public void setCourtArea(BigDecimal courtArea) {
        this.courtArea = courtArea;
    }

    public String getSelfCarbarnInd() {
        return selfCarbarnInd;
    }

    public void setSelfCarbarnInd(String selfCarbarnInd) {
        this.selfCarbarnInd = selfCarbarnInd == null ? null : selfCarbarnInd.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
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
        GrtRealEstateDetail other = (GrtRealEstateDetail) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getRoomNum() == null ? other.getRoomNum() == null : this.getRoomNum().equals(other.getRoomNum()))
            && (this.getBuildingNum() == null ? other.getBuildingNum() == null : this.getBuildingNum().equals(other.getBuildingNum()))
            && (this.getFloorCount() == null ? other.getFloorCount() == null : this.getFloorCount().equals(other.getFloorCount()))
            && (this.getFloorHeight() == null ? other.getFloorHeight() == null : this.getFloorHeight().equals(other.getFloorHeight()))
            && (this.getBuildArea() == null ? other.getBuildArea() == null : this.getBuildArea().equals(other.getBuildArea()))
            && (this.getManageStatus() == null ? other.getManageStatus() == null : this.getManageStatus().equals(other.getManageStatus()))
            && (this.getLandArea() == null ? other.getLandArea() == null : this.getLandArea().equals(other.getLandArea()))
            && (this.getRoomUser() == null ? other.getRoomUser() == null : this.getRoomUser().equals(other.getRoomUser()))
            && (this.getDirection() == null ? other.getDirection() == null : this.getDirection().equals(other.getDirection()))
            && (this.getHouseModel() == null ? other.getHouseModel() == null : this.getHouseModel().equals(other.getHouseModel()))
            && (this.getFitmentDegree() == null ? other.getFitmentDegree() == null : this.getFitmentDegree().equals(other.getFitmentDegree()))
            && (this.getCourtArea() == null ? other.getCourtArea() == null : this.getCourtArea().equals(other.getCourtArea()))
            && (this.getSelfCarbarnInd() == null ? other.getSelfCarbarnInd() == null : this.getSelfCarbarnInd().equals(other.getSelfCarbarnInd()))
            && (this.getFloor() == null ? other.getFloor() == null : this.getFloor().equals(other.getFloor()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getRoomNum() == null) ? 0 : getRoomNum().hashCode());
        result = prime * result + ((getBuildingNum() == null) ? 0 : getBuildingNum().hashCode());
        result = prime * result + ((getFloorCount() == null) ? 0 : getFloorCount().hashCode());
        result = prime * result + ((getFloorHeight() == null) ? 0 : getFloorHeight().hashCode());
        result = prime * result + ((getBuildArea() == null) ? 0 : getBuildArea().hashCode());
        result = prime * result + ((getManageStatus() == null) ? 0 : getManageStatus().hashCode());
        result = prime * result + ((getLandArea() == null) ? 0 : getLandArea().hashCode());
        result = prime * result + ((getRoomUser() == null) ? 0 : getRoomUser().hashCode());
        result = prime * result + ((getDirection() == null) ? 0 : getDirection().hashCode());
        result = prime * result + ((getHouseModel() == null) ? 0 : getHouseModel().hashCode());
        result = prime * result + ((getFitmentDegree() == null) ? 0 : getFitmentDegree().hashCode());
        result = prime * result + ((getCourtArea() == null) ? 0 : getCourtArea().hashCode());
        result = prime * result + ((getSelfCarbarnInd() == null) ? 0 : getSelfCarbarnInd().hashCode());
        result = prime * result + ((getFloor() == null) ? 0 : getFloor().hashCode());
        return result;
    }
}