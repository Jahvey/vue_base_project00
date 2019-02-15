package com.cdgit.ledger.pubquery.bean ;

import java.util.Date;

public class ChTbClaAssetsClassifyApply {
    private String acApplyId;

    private Date applyDt;

    private String claProperties;

    private String realtimeAdjustCd;

    private String applyStatus;

    private String acApplyNum;

    private String createUserNum;

    private String createOrgNum;

    private String userNum;

    private String orgNum;

    private String claMethod;

    public String getAcApplyId() {
        return acApplyId;
    }

    public void setAcApplyId(String acApplyId) {
        this.acApplyId = acApplyId == null ? null : acApplyId.trim();
    }

    public Date getApplyDt() {
        return applyDt;
    }

    public void setApplyDt(Date applyDt) {
        this.applyDt = applyDt;
    }

    public String getClaProperties() {
        return claProperties;
    }

    public void setClaProperties(String claProperties) {
        this.claProperties = claProperties == null ? null : claProperties.trim();
    }

    public String getRealtimeAdjustCd() {
        return realtimeAdjustCd;
    }

    public void setRealtimeAdjustCd(String realtimeAdjustCd) {
        this.realtimeAdjustCd = realtimeAdjustCd == null ? null : realtimeAdjustCd.trim();
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus == null ? null : applyStatus.trim();
    }

    public String getAcApplyNum() {
        return acApplyNum;
    }

    public void setAcApplyNum(String acApplyNum) {
        this.acApplyNum = acApplyNum == null ? null : acApplyNum.trim();
    }

    public String getCreateUserNum() {
        return createUserNum;
    }

    public void setCreateUserNum(String createUserNum) {
        this.createUserNum = createUserNum == null ? null : createUserNum.trim();
    }

    public String getCreateOrgNum() {
        return createOrgNum;
    }

    public void setCreateOrgNum(String createOrgNum) {
        this.createOrgNum = createOrgNum == null ? null : createOrgNum.trim();
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

    public String getClaMethod() {
        return claMethod;
    }

    public void setClaMethod(String claMethod) {
        this.claMethod = claMethod == null ? null : claMethod.trim();
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
        ChTbClaAssetsClassifyApply other = (ChTbClaAssetsClassifyApply) that;
        return (this.getAcApplyId() == null ? other.getAcApplyId() == null : this.getAcApplyId().equals(other.getAcApplyId()))
            && (this.getApplyDt() == null ? other.getApplyDt() == null : this.getApplyDt().equals(other.getApplyDt()))
            && (this.getClaProperties() == null ? other.getClaProperties() == null : this.getClaProperties().equals(other.getClaProperties()))
            && (this.getRealtimeAdjustCd() == null ? other.getRealtimeAdjustCd() == null : this.getRealtimeAdjustCd().equals(other.getRealtimeAdjustCd()))
            && (this.getApplyStatus() == null ? other.getApplyStatus() == null : this.getApplyStatus().equals(other.getApplyStatus()))
            && (this.getAcApplyNum() == null ? other.getAcApplyNum() == null : this.getAcApplyNum().equals(other.getAcApplyNum()))
            && (this.getCreateUserNum() == null ? other.getCreateUserNum() == null : this.getCreateUserNum().equals(other.getCreateUserNum()))
            && (this.getCreateOrgNum() == null ? other.getCreateOrgNum() == null : this.getCreateOrgNum().equals(other.getCreateOrgNum()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getClaMethod() == null ? other.getClaMethod() == null : this.getClaMethod().equals(other.getClaMethod()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAcApplyId() == null) ? 0 : getAcApplyId().hashCode());
        result = prime * result + ((getApplyDt() == null) ? 0 : getApplyDt().hashCode());
        result = prime * result + ((getClaProperties() == null) ? 0 : getClaProperties().hashCode());
        result = prime * result + ((getRealtimeAdjustCd() == null) ? 0 : getRealtimeAdjustCd().hashCode());
        result = prime * result + ((getApplyStatus() == null) ? 0 : getApplyStatus().hashCode());
        result = prime * result + ((getAcApplyNum() == null) ? 0 : getAcApplyNum().hashCode());
        result = prime * result + ((getCreateUserNum() == null) ? 0 : getCreateUserNum().hashCode());
        result = prime * result + ((getCreateOrgNum() == null) ? 0 : getCreateOrgNum().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getClaMethod() == null) ? 0 : getClaMethod().hashCode());
        return result;
    }
}