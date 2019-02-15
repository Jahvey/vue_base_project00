package com.cdgit.ledger.naturalperson.bean;

import java.util.Date;

public class TbCsmManagementTeam {
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
        TbCsmManagementTeam other = (TbCsmManagementTeam) that;
        return (this.getManagementTeamId() == null ? other.getManagementTeamId() == null : this.getManagementTeamId().equals(other.getManagementTeamId()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getUserPlacingCd() == null ? other.getUserPlacingCd() == null : this.getUserPlacingCd().equals(other.getUserPlacingCd()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getPartyType() == null ? other.getPartyType() == null : this.getPartyType().equals(other.getPartyType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getManagementTeamId() == null) ? 0 : getManagementTeamId().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getUserPlacingCd() == null) ? 0 : getUserPlacingCd().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getPartyType() == null) ? 0 : getPartyType().hashCode());
        return result;
    }
}