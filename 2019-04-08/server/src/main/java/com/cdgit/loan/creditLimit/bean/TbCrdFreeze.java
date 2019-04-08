package com.cdgit.loan.creditLimit.bean;

import java.util.Date;

public class TbCrdFreeze {
    private String frzId;

    private String frzNum;

    private String crdId;

    private String frzType;

    private String statusCd;

    private String partyId;

    private String frzReason;

    private String orgNum;

    private Date createTime;

    private String userNum;

    private Date validDate;

    public String getFrzId() {
        return frzId;
    }

    public void setFrzId(String frzId) {
        this.frzId = frzId == null ? null : frzId.trim();
    }

    public String getFrzNum() {
        return frzNum;
    }

    public void setFrzNum(String frzNum) {
        this.frzNum = frzNum == null ? null : frzNum.trim();
    }

    public String getCrdId() {
        return crdId;
    }

    public void setCrdId(String crdId) {
        this.crdId = crdId == null ? null : crdId.trim();
    }

    public String getFrzType() {
        return frzType;
    }

    public void setFrzType(String frzType) {
        this.frzType = frzType == null ? null : frzType.trim();
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd == null ? null : statusCd.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getFrzReason() {
        return frzReason;
    }

    public void setFrzReason(String frzReason) {
        this.frzReason = frzReason == null ? null : frzReason.trim();
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

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
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
        TbCrdFreeze other = (TbCrdFreeze) that;
        return (this.getFrzId() == null ? other.getFrzId() == null : this.getFrzId().equals(other.getFrzId()))
            && (this.getFrzNum() == null ? other.getFrzNum() == null : this.getFrzNum().equals(other.getFrzNum()))
            && (this.getCrdId() == null ? other.getCrdId() == null : this.getCrdId().equals(other.getCrdId()))
            && (this.getFrzType() == null ? other.getFrzType() == null : this.getFrzType().equals(other.getFrzType()))
            && (this.getStatusCd() == null ? other.getStatusCd() == null : this.getStatusCd().equals(other.getStatusCd()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getFrzReason() == null ? other.getFrzReason() == null : this.getFrzReason().equals(other.getFrzReason()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getValidDate() == null ? other.getValidDate() == null : this.getValidDate().equals(other.getValidDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFrzId() == null) ? 0 : getFrzId().hashCode());
        result = prime * result + ((getFrzNum() == null) ? 0 : getFrzNum().hashCode());
        result = prime * result + ((getCrdId() == null) ? 0 : getCrdId().hashCode());
        result = prime * result + ((getFrzType() == null) ? 0 : getFrzType().hashCode());
        result = prime * result + ((getStatusCd() == null) ? 0 : getStatusCd().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getFrzReason() == null) ? 0 : getFrzReason().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getValidDate() == null) ? 0 : getValidDate().hashCode());
        return result;
    }
}