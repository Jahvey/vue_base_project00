package com.cdgit.ledger.pubquery.bean ;

import java.util.Date;

public class ChTbIrmInternalRatingApply {
    private String iraApplyId;

    private String ratingModelCd;

    private String ratingModelVer;

    private String ratingState;

    private String projectId;

    private Date applyDate;

    private String applyNatureCd;

    private String triggerTypeCd;

    private String orgNum;

    private String userNum;

    private String originalIraApplyId;

    private String isAudit;

    private Short allowTimes;

    private String isGovernmentPlatform;

    private String gpModelVer;

    private String allowModifyFlag;

    private String governmentAdjustRatingCd;

    private String generalAdjustRatingCd;

    private String ratingType;

    private String partyId;

    public String getIraApplyId() {
        return iraApplyId;
    }

    public void setIraApplyId(String iraApplyId) {
        this.iraApplyId = iraApplyId == null ? null : iraApplyId.trim();
    }

    public String getRatingModelCd() {
        return ratingModelCd;
    }

    public void setRatingModelCd(String ratingModelCd) {
        this.ratingModelCd = ratingModelCd == null ? null : ratingModelCd.trim();
    }

    public String getRatingModelVer() {
        return ratingModelVer;
    }

    public void setRatingModelVer(String ratingModelVer) {
        this.ratingModelVer = ratingModelVer == null ? null : ratingModelVer.trim();
    }

    public String getRatingState() {
        return ratingState;
    }

    public void setRatingState(String ratingState) {
        this.ratingState = ratingState == null ? null : ratingState.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyNatureCd() {
        return applyNatureCd;
    }

    public void setApplyNatureCd(String applyNatureCd) {
        this.applyNatureCd = applyNatureCd == null ? null : applyNatureCd.trim();
    }

    public String getTriggerTypeCd() {
        return triggerTypeCd;
    }

    public void setTriggerTypeCd(String triggerTypeCd) {
        this.triggerTypeCd = triggerTypeCd == null ? null : triggerTypeCd.trim();
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

    public String getOriginalIraApplyId() {
        return originalIraApplyId;
    }

    public void setOriginalIraApplyId(String originalIraApplyId) {
        this.originalIraApplyId = originalIraApplyId == null ? null : originalIraApplyId.trim();
    }

    public String getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(String isAudit) {
        this.isAudit = isAudit == null ? null : isAudit.trim();
    }

    public Short getAllowTimes() {
        return allowTimes;
    }

    public void setAllowTimes(Short allowTimes) {
        this.allowTimes = allowTimes;
    }

    public String getIsGovernmentPlatform() {
        return isGovernmentPlatform;
    }

    public void setIsGovernmentPlatform(String isGovernmentPlatform) {
        this.isGovernmentPlatform = isGovernmentPlatform == null ? null : isGovernmentPlatform.trim();
    }

    public String getGpModelVer() {
        return gpModelVer;
    }

    public void setGpModelVer(String gpModelVer) {
        this.gpModelVer = gpModelVer == null ? null : gpModelVer.trim();
    }

    public String getAllowModifyFlag() {
        return allowModifyFlag;
    }

    public void setAllowModifyFlag(String allowModifyFlag) {
        this.allowModifyFlag = allowModifyFlag == null ? null : allowModifyFlag.trim();
    }

    public String getGovernmentAdjustRatingCd() {
        return governmentAdjustRatingCd;
    }

    public void setGovernmentAdjustRatingCd(String governmentAdjustRatingCd) {
        this.governmentAdjustRatingCd = governmentAdjustRatingCd == null ? null : governmentAdjustRatingCd.trim();
    }

    public String getGeneralAdjustRatingCd() {
        return generalAdjustRatingCd;
    }

    public void setGeneralAdjustRatingCd(String generalAdjustRatingCd) {
        this.generalAdjustRatingCd = generalAdjustRatingCd == null ? null : generalAdjustRatingCd.trim();
    }

    public String getRatingType() {
        return ratingType;
    }

    public void setRatingType(String ratingType) {
        this.ratingType = ratingType == null ? null : ratingType.trim();
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
        ChTbIrmInternalRatingApply other = (ChTbIrmInternalRatingApply) that;
        return (this.getIraApplyId() == null ? other.getIraApplyId() == null : this.getIraApplyId().equals(other.getIraApplyId()))
            && (this.getRatingModelCd() == null ? other.getRatingModelCd() == null : this.getRatingModelCd().equals(other.getRatingModelCd()))
            && (this.getRatingModelVer() == null ? other.getRatingModelVer() == null : this.getRatingModelVer().equals(other.getRatingModelVer()))
            && (this.getRatingState() == null ? other.getRatingState() == null : this.getRatingState().equals(other.getRatingState()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()))
            && (this.getApplyNatureCd() == null ? other.getApplyNatureCd() == null : this.getApplyNatureCd().equals(other.getApplyNatureCd()))
            && (this.getTriggerTypeCd() == null ? other.getTriggerTypeCd() == null : this.getTriggerTypeCd().equals(other.getTriggerTypeCd()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOriginalIraApplyId() == null ? other.getOriginalIraApplyId() == null : this.getOriginalIraApplyId().equals(other.getOriginalIraApplyId()))
            && (this.getIsAudit() == null ? other.getIsAudit() == null : this.getIsAudit().equals(other.getIsAudit()))
            && (this.getAllowTimes() == null ? other.getAllowTimes() == null : this.getAllowTimes().equals(other.getAllowTimes()))
            && (this.getIsGovernmentPlatform() == null ? other.getIsGovernmentPlatform() == null : this.getIsGovernmentPlatform().equals(other.getIsGovernmentPlatform()))
            && (this.getGpModelVer() == null ? other.getGpModelVer() == null : this.getGpModelVer().equals(other.getGpModelVer()))
            && (this.getAllowModifyFlag() == null ? other.getAllowModifyFlag() == null : this.getAllowModifyFlag().equals(other.getAllowModifyFlag()))
            && (this.getGovernmentAdjustRatingCd() == null ? other.getGovernmentAdjustRatingCd() == null : this.getGovernmentAdjustRatingCd().equals(other.getGovernmentAdjustRatingCd()))
            && (this.getGeneralAdjustRatingCd() == null ? other.getGeneralAdjustRatingCd() == null : this.getGeneralAdjustRatingCd().equals(other.getGeneralAdjustRatingCd()))
            && (this.getRatingType() == null ? other.getRatingType() == null : this.getRatingType().equals(other.getRatingType()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIraApplyId() == null) ? 0 : getIraApplyId().hashCode());
        result = prime * result + ((getRatingModelCd() == null) ? 0 : getRatingModelCd().hashCode());
        result = prime * result + ((getRatingModelVer() == null) ? 0 : getRatingModelVer().hashCode());
        result = prime * result + ((getRatingState() == null) ? 0 : getRatingState().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getApplyNatureCd() == null) ? 0 : getApplyNatureCd().hashCode());
        result = prime * result + ((getTriggerTypeCd() == null) ? 0 : getTriggerTypeCd().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOriginalIraApplyId() == null) ? 0 : getOriginalIraApplyId().hashCode());
        result = prime * result + ((getIsAudit() == null) ? 0 : getIsAudit().hashCode());
        result = prime * result + ((getAllowTimes() == null) ? 0 : getAllowTimes().hashCode());
        result = prime * result + ((getIsGovernmentPlatform() == null) ? 0 : getIsGovernmentPlatform().hashCode());
        result = prime * result + ((getGpModelVer() == null) ? 0 : getGpModelVer().hashCode());
        result = prime * result + ((getAllowModifyFlag() == null) ? 0 : getAllowModifyFlag().hashCode());
        result = prime * result + ((getGovernmentAdjustRatingCd() == null) ? 0 : getGovernmentAdjustRatingCd().hashCode());
        result = prime * result + ((getGeneralAdjustRatingCd() == null) ? 0 : getGeneralAdjustRatingCd().hashCode());
        result = prime * result + ((getRatingType() == null) ? 0 : getRatingType().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        return result;
    }
}