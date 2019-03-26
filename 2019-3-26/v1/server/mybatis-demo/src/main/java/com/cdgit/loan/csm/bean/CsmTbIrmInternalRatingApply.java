package com.cdgit.loan.csm.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbIrmInternalRatingApply {
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

    private BigDecimal allowTimes;

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

    public BigDecimal getAllowTimes() {
        return allowTimes;
    }

    public void setAllowTimes(BigDecimal allowTimes) {
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
}