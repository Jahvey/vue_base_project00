package com.cdgit.loan.csm.bean;

public class CsmTbBizYesOrNoApply {
    private String yesornoId;

    private String isPhotovoltaic;

    private String isSteelTrade;

    private String applyId;

    private String isSteel;

    private String isCement;

    private String isWindPower;

    private String isBdo;

    private String isCapacitor;

    private String isOverCapacity;

    private String isShipbuilding;

    private String isFz;

    private String isOffSite;

    private String cusType;

    private String houseSum;

    public String getYesornoId() {
        return yesornoId;
    }

    public void setYesornoId(String yesornoId) {
        this.yesornoId = yesornoId == null ? null : yesornoId.trim();
    }

    public String getIsPhotovoltaic() {
        return isPhotovoltaic;
    }

    public void setIsPhotovoltaic(String isPhotovoltaic) {
        this.isPhotovoltaic = isPhotovoltaic == null ? null : isPhotovoltaic.trim();
    }

    public String getIsSteelTrade() {
        return isSteelTrade;
    }

    public void setIsSteelTrade(String isSteelTrade) {
        this.isSteelTrade = isSteelTrade == null ? null : isSteelTrade.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getIsSteel() {
        return isSteel;
    }

    public void setIsSteel(String isSteel) {
        this.isSteel = isSteel == null ? null : isSteel.trim();
    }

    public String getIsCement() {
        return isCement;
    }

    public void setIsCement(String isCement) {
        this.isCement = isCement == null ? null : isCement.trim();
    }

    public String getIsWindPower() {
        return isWindPower;
    }

    public void setIsWindPower(String isWindPower) {
        this.isWindPower = isWindPower == null ? null : isWindPower.trim();
    }

    public String getIsBdo() {
        return isBdo;
    }

    public void setIsBdo(String isBdo) {
        this.isBdo = isBdo == null ? null : isBdo.trim();
    }

    public String getIsCapacitor() {
        return isCapacitor;
    }

    public void setIsCapacitor(String isCapacitor) {
        this.isCapacitor = isCapacitor == null ? null : isCapacitor.trim();
    }

    public String getIsOverCapacity() {
        return isOverCapacity;
    }

    public void setIsOverCapacity(String isOverCapacity) {
        this.isOverCapacity = isOverCapacity == null ? null : isOverCapacity.trim();
    }

    public String getIsShipbuilding() {
        return isShipbuilding;
    }

    public void setIsShipbuilding(String isShipbuilding) {
        this.isShipbuilding = isShipbuilding == null ? null : isShipbuilding.trim();
    }

    public String getIsFz() {
        return isFz;
    }

    public void setIsFz(String isFz) {
        this.isFz = isFz == null ? null : isFz.trim();
    }

    public String getIsOffSite() {
        return isOffSite;
    }

    public void setIsOffSite(String isOffSite) {
        this.isOffSite = isOffSite == null ? null : isOffSite.trim();
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType == null ? null : cusType.trim();
    }

    public String getHouseSum() {
        return houseSum;
    }

    public void setHouseSum(String houseSum) {
        this.houseSum = houseSum == null ? null : houseSum.trim();
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
        CsmTbBizYesOrNoApply other = (CsmTbBizYesOrNoApply) that;
        return (this.getYesornoId() == null ? other.getYesornoId() == null : this.getYesornoId().equals(other.getYesornoId()))
            && (this.getIsPhotovoltaic() == null ? other.getIsPhotovoltaic() == null : this.getIsPhotovoltaic().equals(other.getIsPhotovoltaic()))
            && (this.getIsSteelTrade() == null ? other.getIsSteelTrade() == null : this.getIsSteelTrade().equals(other.getIsSteelTrade()))
            && (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()))
            && (this.getIsSteel() == null ? other.getIsSteel() == null : this.getIsSteel().equals(other.getIsSteel()))
            && (this.getIsCement() == null ? other.getIsCement() == null : this.getIsCement().equals(other.getIsCement()))
            && (this.getIsWindPower() == null ? other.getIsWindPower() == null : this.getIsWindPower().equals(other.getIsWindPower()))
            && (this.getIsBdo() == null ? other.getIsBdo() == null : this.getIsBdo().equals(other.getIsBdo()))
            && (this.getIsCapacitor() == null ? other.getIsCapacitor() == null : this.getIsCapacitor().equals(other.getIsCapacitor()))
            && (this.getIsOverCapacity() == null ? other.getIsOverCapacity() == null : this.getIsOverCapacity().equals(other.getIsOverCapacity()))
            && (this.getIsShipbuilding() == null ? other.getIsShipbuilding() == null : this.getIsShipbuilding().equals(other.getIsShipbuilding()))
            && (this.getIsFz() == null ? other.getIsFz() == null : this.getIsFz().equals(other.getIsFz()))
            && (this.getIsOffSite() == null ? other.getIsOffSite() == null : this.getIsOffSite().equals(other.getIsOffSite()))
            && (this.getCusType() == null ? other.getCusType() == null : this.getCusType().equals(other.getCusType()))
            && (this.getHouseSum() == null ? other.getHouseSum() == null : this.getHouseSum().equals(other.getHouseSum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getYesornoId() == null) ? 0 : getYesornoId().hashCode());
        result = prime * result + ((getIsPhotovoltaic() == null) ? 0 : getIsPhotovoltaic().hashCode());
        result = prime * result + ((getIsSteelTrade() == null) ? 0 : getIsSteelTrade().hashCode());
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        result = prime * result + ((getIsSteel() == null) ? 0 : getIsSteel().hashCode());
        result = prime * result + ((getIsCement() == null) ? 0 : getIsCement().hashCode());
        result = prime * result + ((getIsWindPower() == null) ? 0 : getIsWindPower().hashCode());
        result = prime * result + ((getIsBdo() == null) ? 0 : getIsBdo().hashCode());
        result = prime * result + ((getIsCapacitor() == null) ? 0 : getIsCapacitor().hashCode());
        result = prime * result + ((getIsOverCapacity() == null) ? 0 : getIsOverCapacity().hashCode());
        result = prime * result + ((getIsShipbuilding() == null) ? 0 : getIsShipbuilding().hashCode());
        result = prime * result + ((getIsFz() == null) ? 0 : getIsFz().hashCode());
        result = prime * result + ((getIsOffSite() == null) ? 0 : getIsOffSite().hashCode());
        result = prime * result + ((getCusType() == null) ? 0 : getCusType().hashCode());
        result = prime * result + ((getHouseSum() == null) ? 0 : getHouseSum().hashCode());
        return result;
    }
}