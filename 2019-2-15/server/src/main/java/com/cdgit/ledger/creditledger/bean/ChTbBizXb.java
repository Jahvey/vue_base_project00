package com.cdgit.ledger.creditledger.bean ;

import java.util.Date;

public class ChTbBizXb {
    private String bizId;

    private String xbNum;

    private String xbName;

    private String userNum;

    private String orgNum;

    private Date createTime;

    private Date updateTime;

    private String xbOrgNum;

    private String xbOrgName;

    private String firstResponseNum;

    private String firstResponseName;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
    }

    public String getXbNum() {
        return xbNum;
    }

    public void setXbNum(String xbNum) {
        this.xbNum = xbNum == null ? null : xbNum.trim();
    }

    public String getXbName() {
        return xbName;
    }

    public void setXbName(String xbName) {
        this.xbName = xbName == null ? null : xbName.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getXbOrgNum() {
        return xbOrgNum;
    }

    public void setXbOrgNum(String xbOrgNum) {
        this.xbOrgNum = xbOrgNum == null ? null : xbOrgNum.trim();
    }

    public String getXbOrgName() {
        return xbOrgName;
    }

    public void setXbOrgName(String xbOrgName) {
        this.xbOrgName = xbOrgName == null ? null : xbOrgName.trim();
    }

    public String getFirstResponseNum() {
        return firstResponseNum;
    }

    public void setFirstResponseNum(String firstResponseNum) {
        this.firstResponseNum = firstResponseNum == null ? null : firstResponseNum.trim();
    }

    public String getFirstResponseName() {
        return firstResponseName;
    }

    public void setFirstResponseName(String firstResponseName) {
        this.firstResponseName = firstResponseName == null ? null : firstResponseName.trim();
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
        ChTbBizXb other = (ChTbBizXb) that;
        return (this.getBizId() == null ? other.getBizId() == null : this.getBizId().equals(other.getBizId()))
            && (this.getXbNum() == null ? other.getXbNum() == null : this.getXbNum().equals(other.getXbNum()))
            && (this.getXbName() == null ? other.getXbName() == null : this.getXbName().equals(other.getXbName()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getXbOrgNum() == null ? other.getXbOrgNum() == null : this.getXbOrgNum().equals(other.getXbOrgNum()))
            && (this.getXbOrgName() == null ? other.getXbOrgName() == null : this.getXbOrgName().equals(other.getXbOrgName()))
            && (this.getFirstResponseNum() == null ? other.getFirstResponseNum() == null : this.getFirstResponseNum().equals(other.getFirstResponseNum()))
            && (this.getFirstResponseName() == null ? other.getFirstResponseName() == null : this.getFirstResponseName().equals(other.getFirstResponseName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBizId() == null) ? 0 : getBizId().hashCode());
        result = prime * result + ((getXbNum() == null) ? 0 : getXbNum().hashCode());
        result = prime * result + ((getXbName() == null) ? 0 : getXbName().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getXbOrgNum() == null) ? 0 : getXbOrgNum().hashCode());
        result = prime * result + ((getXbOrgName() == null) ? 0 : getXbOrgName().hashCode());
        result = prime * result + ((getFirstResponseNum() == null) ? 0 : getFirstResponseNum().hashCode());
        result = prime * result + ((getFirstResponseName() == null) ? 0 : getFirstResponseName().hashCode());
        return result;
    }
}