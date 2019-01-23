package com.cdgit.loan.customerManage.party.bean;

import java.util.Date;

public class Party {
    private String partyId;

    private String partyNum;

    private String partyTypeCd;

    private String partyName;

    private String ecifPartyNum;

    private Date createTime;

    private Date updateTime;

    private String examineState;

    private String custPropertyStatus;

    private String ifDataMove;

    private String isPotentialCust;

    private String legOrg;

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getPartyNum() {
        return partyNum;
    }

    public void setPartyNum(String partyNum) {
        this.partyNum = partyNum == null ? null : partyNum.trim();
    }

    public String getPartyTypeCd() {
        return partyTypeCd;
    }

    public void setPartyTypeCd(String partyTypeCd) {
        this.partyTypeCd = partyTypeCd == null ? null : partyTypeCd.trim();
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName == null ? null : partyName.trim();
    }

    public String getEcifPartyNum() {
        return ecifPartyNum;
    }

    public void setEcifPartyNum(String ecifPartyNum) {
        this.ecifPartyNum = ecifPartyNum == null ? null : ecifPartyNum.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getExamineState() {
        return examineState;
    }

    public void setExamineState(String examineState) {
        this.examineState = examineState == null ? null : examineState.trim();
    }

    public String getCustPropertyStatus() {
        return custPropertyStatus;
    }

    public void setCustPropertyStatus(String custPropertyStatus) {
        this.custPropertyStatus = custPropertyStatus == null ? null : custPropertyStatus.trim();
    }

    public String getIfDataMove() {
        return ifDataMove;
    }

    public void setIfDataMove(String ifDataMove) {
        this.ifDataMove = ifDataMove == null ? null : ifDataMove.trim();
    }

    public String getIsPotentialCust() {
        return isPotentialCust;
    }

    public void setIsPotentialCust(String isPotentialCust) {
        this.isPotentialCust = isPotentialCust == null ? null : isPotentialCust.trim();
    }

    public String getLegOrg() {
        return legOrg;
    }

    public void setLegOrg(String legOrg) {
        this.legOrg = legOrg == null ? null : legOrg.trim();
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
        Party other = (Party) that;
        return (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getPartyNum() == null ? other.getPartyNum() == null : this.getPartyNum().equals(other.getPartyNum()))
            && (this.getPartyTypeCd() == null ? other.getPartyTypeCd() == null : this.getPartyTypeCd().equals(other.getPartyTypeCd()))
            && (this.getPartyName() == null ? other.getPartyName() == null : this.getPartyName().equals(other.getPartyName()))
            && (this.getEcifPartyNum() == null ? other.getEcifPartyNum() == null : this.getEcifPartyNum().equals(other.getEcifPartyNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getExamineState() == null ? other.getExamineState() == null : this.getExamineState().equals(other.getExamineState()))
            && (this.getCustPropertyStatus() == null ? other.getCustPropertyStatus() == null : this.getCustPropertyStatus().equals(other.getCustPropertyStatus()))
            && (this.getIfDataMove() == null ? other.getIfDataMove() == null : this.getIfDataMove().equals(other.getIfDataMove()))
            && (this.getIsPotentialCust() == null ? other.getIsPotentialCust() == null : this.getIsPotentialCust().equals(other.getIsPotentialCust()))
            && (this.getLegOrg() == null ? other.getLegOrg() == null : this.getLegOrg().equals(other.getLegOrg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getPartyNum() == null) ? 0 : getPartyNum().hashCode());
        result = prime * result + ((getPartyTypeCd() == null) ? 0 : getPartyTypeCd().hashCode());
        result = prime * result + ((getPartyName() == null) ? 0 : getPartyName().hashCode());
        result = prime * result + ((getEcifPartyNum() == null) ? 0 : getEcifPartyNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getExamineState() == null) ? 0 : getExamineState().hashCode());
        result = prime * result + ((getCustPropertyStatus() == null) ? 0 : getCustPropertyStatus().hashCode());
        result = prime * result + ((getIfDataMove() == null) ? 0 : getIfDataMove().hashCode());
        result = prime * result + ((getIsPotentialCust() == null) ? 0 : getIsPotentialCust().hashCode());
        result = prime * result + ((getLegOrg() == null) ? 0 : getLegOrg().hashCode());
        return result;
    }
}