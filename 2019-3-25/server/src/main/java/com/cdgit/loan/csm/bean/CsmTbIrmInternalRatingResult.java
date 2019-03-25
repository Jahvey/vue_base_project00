package com.cdgit.loan.csm.bean;

import java.util.Date;

public class CsmTbIrmInternalRatingResult {
    private String irrResultId;

    private String iraApplyId;

    private String creditRatingCd;

    private Date effectiveStartDt;

    private String ratingState;

    private Date effectiveEndDt;

    private Date ratingDt;

    private String projectId;

    private String orgNum;

    private String userNum;

    private String isProfessional;

    private String creditRatingCdOld;

    private String partyId;

    public String getIrrResultId() {
        return irrResultId;
    }

    public void setIrrResultId(String irrResultId) {
        this.irrResultId = irrResultId == null ? null : irrResultId.trim();
    }

    public String getIraApplyId() {
        return iraApplyId;
    }

    public void setIraApplyId(String iraApplyId) {
        this.iraApplyId = iraApplyId == null ? null : iraApplyId.trim();
    }

    public String getCreditRatingCd() {
        return creditRatingCd;
    }

    public void setCreditRatingCd(String creditRatingCd) {
        this.creditRatingCd = creditRatingCd == null ? null : creditRatingCd.trim();
    }

    public Date getEffectiveStartDt() {
        return effectiveStartDt;
    }

    public void setEffectiveStartDt(Date effectiveStartDt) {
        this.effectiveStartDt = effectiveStartDt;
    }

    public String getRatingState() {
        return ratingState;
    }

    public void setRatingState(String ratingState) {
        this.ratingState = ratingState == null ? null : ratingState.trim();
    }

    public Date getEffectiveEndDt() {
        return effectiveEndDt;
    }

    public void setEffectiveEndDt(Date effectiveEndDt) {
        this.effectiveEndDt = effectiveEndDt;
    }

    public Date getRatingDt() {
        return ratingDt;
    }

    public void setRatingDt(Date ratingDt) {
        this.ratingDt = ratingDt;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getIsProfessional() {
        return isProfessional;
    }

    public void setIsProfessional(String isProfessional) {
        this.isProfessional = isProfessional == null ? null : isProfessional.trim();
    }

    public String getCreditRatingCdOld() {
        return creditRatingCdOld;
    }

    public void setCreditRatingCdOld(String creditRatingCdOld) {
        this.creditRatingCdOld = creditRatingCdOld == null ? null : creditRatingCdOld.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
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
        CsmTbIrmInternalRatingResult other = (CsmTbIrmInternalRatingResult) that;
        return (this.getIrrResultId() == null ? other.getIrrResultId() == null : this.getIrrResultId().equals(other.getIrrResultId()))
            && (this.getIraApplyId() == null ? other.getIraApplyId() == null : this.getIraApplyId().equals(other.getIraApplyId()))
            && (this.getCreditRatingCd() == null ? other.getCreditRatingCd() == null : this.getCreditRatingCd().equals(other.getCreditRatingCd()))
            && (this.getEffectiveStartDt() == null ? other.getEffectiveStartDt() == null : this.getEffectiveStartDt().equals(other.getEffectiveStartDt()))
            && (this.getRatingState() == null ? other.getRatingState() == null : this.getRatingState().equals(other.getRatingState()))
            && (this.getEffectiveEndDt() == null ? other.getEffectiveEndDt() == null : this.getEffectiveEndDt().equals(other.getEffectiveEndDt()))
            && (this.getRatingDt() == null ? other.getRatingDt() == null : this.getRatingDt().equals(other.getRatingDt()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getIsProfessional() == null ? other.getIsProfessional() == null : this.getIsProfessional().equals(other.getIsProfessional()))
            && (this.getCreditRatingCdOld() == null ? other.getCreditRatingCdOld() == null : this.getCreditRatingCdOld().equals(other.getCreditRatingCdOld()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIrrResultId() == null) ? 0 : getIrrResultId().hashCode());
        result = prime * result + ((getIraApplyId() == null) ? 0 : getIraApplyId().hashCode());
        result = prime * result + ((getCreditRatingCd() == null) ? 0 : getCreditRatingCd().hashCode());
        result = prime * result + ((getEffectiveStartDt() == null) ? 0 : getEffectiveStartDt().hashCode());
        result = prime * result + ((getRatingState() == null) ? 0 : getRatingState().hashCode());
        result = prime * result + ((getEffectiveEndDt() == null) ? 0 : getEffectiveEndDt().hashCode());
        result = prime * result + ((getRatingDt() == null) ? 0 : getRatingDt().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getIsProfessional() == null) ? 0 : getIsProfessional().hashCode());
        result = prime * result + ((getCreditRatingCdOld() == null) ? 0 : getCreditRatingCdOld().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        return result;
    }
}