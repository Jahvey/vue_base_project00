package com.cdgit.loan.csm.bean;

import java.util.Date;

public class TbCsmParty {
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
}