package com.cdgit.loan.csm.bean;

import java.util.Date;

public class CsmTbCsmManagementTeam {
    private String managementTeamId;

    private String userNum;

    private String userPlacingCd;

    private String status;

    private String partyId;

    private Date updateTime;

    private String orgNum;

    private Date createTime;

    private String partyType;

    public String getManagementTeamId() {
        return managementTeamId;
    }

    public void setManagementTeamId(String managementTeamId) {
        this.managementTeamId = managementTeamId == null ? null : managementTeamId.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getUserPlacingCd() {
        return userPlacingCd;
    }

    public void setUserPlacingCd(String userPlacingCd) {
        this.userPlacingCd = userPlacingCd == null ? null : userPlacingCd.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType == null ? null : partyType.trim();
    }
}