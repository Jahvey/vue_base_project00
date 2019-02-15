package com.cdgit.ledger.naturalperson.bean;

import java.util.Date;

public class TbCsmGuarGroup {
    private String partyId;

    private String jointGuaranteeType;

    private String jointGuaranteeStatus;

    private Date createDate;

    private Date updateDate;

    private String updateOrgNum;

    private String updateUserNum;

    private String isDifOrgGuarantee;

    private String manageWay;

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getJointGuaranteeType() {
        return jointGuaranteeType;
    }

    public void setJointGuaranteeType(String jointGuaranteeType) {
        this.jointGuaranteeType = jointGuaranteeType == null ? null : jointGuaranteeType.trim();
    }

    public String getJointGuaranteeStatus() {
        return jointGuaranteeStatus;
    }

    public void setJointGuaranteeStatus(String jointGuaranteeStatus) {
        this.jointGuaranteeStatus = jointGuaranteeStatus == null ? null : jointGuaranteeStatus.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateOrgNum() {
        return updateOrgNum;
    }

    public void setUpdateOrgNum(String updateOrgNum) {
        this.updateOrgNum = updateOrgNum == null ? null : updateOrgNum.trim();
    }

    public String getUpdateUserNum() {
        return updateUserNum;
    }

    public void setUpdateUserNum(String updateUserNum) {
        this.updateUserNum = updateUserNum == null ? null : updateUserNum.trim();
    }

    public String getIsDifOrgGuarantee() {
        return isDifOrgGuarantee;
    }

    public void setIsDifOrgGuarantee(String isDifOrgGuarantee) {
        this.isDifOrgGuarantee = isDifOrgGuarantee == null ? null : isDifOrgGuarantee.trim();
    }

    public String getManageWay() {
        return manageWay;
    }

    public void setManageWay(String manageWay) {
        this.manageWay = manageWay == null ? null : manageWay.trim();
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
        TbCsmGuarGroup other = (TbCsmGuarGroup) that;
        return (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getJointGuaranteeType() == null ? other.getJointGuaranteeType() == null : this.getJointGuaranteeType().equals(other.getJointGuaranteeType()))
            && (this.getJointGuaranteeStatus() == null ? other.getJointGuaranteeStatus() == null : this.getJointGuaranteeStatus().equals(other.getJointGuaranteeStatus()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateOrgNum() == null ? other.getUpdateOrgNum() == null : this.getUpdateOrgNum().equals(other.getUpdateOrgNum()))
            && (this.getUpdateUserNum() == null ? other.getUpdateUserNum() == null : this.getUpdateUserNum().equals(other.getUpdateUserNum()))
            && (this.getIsDifOrgGuarantee() == null ? other.getIsDifOrgGuarantee() == null : this.getIsDifOrgGuarantee().equals(other.getIsDifOrgGuarantee()))
            && (this.getManageWay() == null ? other.getManageWay() == null : this.getManageWay().equals(other.getManageWay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getJointGuaranteeType() == null) ? 0 : getJointGuaranteeType().hashCode());
        result = prime * result + ((getJointGuaranteeStatus() == null) ? 0 : getJointGuaranteeStatus().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateOrgNum() == null) ? 0 : getUpdateOrgNum().hashCode());
        result = prime * result + ((getUpdateUserNum() == null) ? 0 : getUpdateUserNum().hashCode());
        result = prime * result + ((getIsDifOrgGuarantee() == null) ? 0 : getIsDifOrgGuarantee().hashCode());
        result = prime * result + ((getManageWay() == null) ? 0 : getManageWay().hashCode());
        return result;
    }
}