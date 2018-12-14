package com.cdgit.loan.csm.bean;

import java.util.Date;

public class TbLstInfo {
    private String partyId;

    private String listStatus;

    private String approveStatus;

    private String operUserid;

    private String operOrgcode;

    private Date createDate;

    private String pdYj;

    private String newStatus;

    private Date updateTime;

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getListStatus() {
        return listStatus;
    }

    public void setListStatus(String listStatus) {
        this.listStatus = listStatus == null ? null : listStatus.trim();
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus == null ? null : approveStatus.trim();
    }

    public String getOperUserid() {
        return operUserid;
    }

    public void setOperUserid(String operUserid) {
        this.operUserid = operUserid == null ? null : operUserid.trim();
    }

    public String getOperOrgcode() {
        return operOrgcode;
    }

    public void setOperOrgcode(String operOrgcode) {
        this.operOrgcode = operOrgcode == null ? null : operOrgcode.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPdYj() {
        return pdYj;
    }

    public void setPdYj(String pdYj) {
        this.pdYj = pdYj == null ? null : pdYj.trim();
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus == null ? null : newStatus.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}