package com.cdgit.loan.csm.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbCrdApprove {
    private String crdId;

    private String crdNum;

    private String creditMode;

    private String partyId;

    private String statusCd;

    private String orgNum;

    private String userNum;

    private Date applyDate;

    private Date validDate;

    private Date endDate;

    private Date updateTime;

    private String guarantyType;

    private Short termNum;

    private String termUnit;

    private String happenNature;

    private BigDecimal rmbAmt;

    private String applyId;

    private String bizId;

    private BigDecimal boUse;

    private BigDecimal noUse;

    private String csmCrdLevel;

    private String happenType;

    public String getCrdId() {
        return crdId;
    }

    public void setCrdId(String crdId) {
        this.crdId = crdId == null ? null : crdId.trim();
    }

    public String getCrdNum() {
        return crdNum;
    }

    public void setCrdNum(String crdNum) {
        this.crdNum = crdNum == null ? null : crdNum.trim();
    }

    public String getCreditMode() {
        return creditMode;
    }

    public void setCreditMode(String creditMode) {
        this.creditMode = creditMode == null ? null : creditMode.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd == null ? null : statusCd.trim();
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

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getGuarantyType() {
        return guarantyType;
    }

    public void setGuarantyType(String guarantyType) {
        this.guarantyType = guarantyType == null ? null : guarantyType.trim();
    }

    public Short getTermNum() {
        return termNum;
    }

    public void setTermNum(Short termNum) {
        this.termNum = termNum;
    }

    public String getTermUnit() {
        return termUnit;
    }

    public void setTermUnit(String termUnit) {
        this.termUnit = termUnit == null ? null : termUnit.trim();
    }

    public String getHappenNature() {
        return happenNature;
    }

    public void setHappenNature(String happenNature) {
        this.happenNature = happenNature == null ? null : happenNature.trim();
    }

    public BigDecimal getRmbAmt() {
        return rmbAmt;
    }

    public void setRmbAmt(BigDecimal rmbAmt) {
        this.rmbAmt = rmbAmt;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
    }

    public BigDecimal getBoUse() {
        return boUse;
    }

    public void setBoUse(BigDecimal boUse) {
        this.boUse = boUse;
    }

    public BigDecimal getNoUse() {
        return noUse;
    }

    public void setNoUse(BigDecimal noUse) {
        this.noUse = noUse;
    }

    public String getCsmCrdLevel() {
        return csmCrdLevel;
    }

    public void setCsmCrdLevel(String csmCrdLevel) {
        this.csmCrdLevel = csmCrdLevel == null ? null : csmCrdLevel.trim();
    }

    public String getHappenType() {
        return happenType;
    }

    public void setHappenType(String happenType) {
        this.happenType = happenType == null ? null : happenType.trim();
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
        CsmTbCrdApprove other = (CsmTbCrdApprove) that;
        return (this.getCrdId() == null ? other.getCrdId() == null : this.getCrdId().equals(other.getCrdId()))
            && (this.getCrdNum() == null ? other.getCrdNum() == null : this.getCrdNum().equals(other.getCrdNum()))
            && (this.getCreditMode() == null ? other.getCreditMode() == null : this.getCreditMode().equals(other.getCreditMode()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getStatusCd() == null ? other.getStatusCd() == null : this.getStatusCd().equals(other.getStatusCd()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()))
            && (this.getValidDate() == null ? other.getValidDate() == null : this.getValidDate().equals(other.getValidDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getGuarantyType() == null ? other.getGuarantyType() == null : this.getGuarantyType().equals(other.getGuarantyType()))
            && (this.getTermNum() == null ? other.getTermNum() == null : this.getTermNum().equals(other.getTermNum()))
            && (this.getTermUnit() == null ? other.getTermUnit() == null : this.getTermUnit().equals(other.getTermUnit()))
            && (this.getHappenNature() == null ? other.getHappenNature() == null : this.getHappenNature().equals(other.getHappenNature()))
            && (this.getRmbAmt() == null ? other.getRmbAmt() == null : this.getRmbAmt().equals(other.getRmbAmt()))
            && (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()))
            && (this.getBizId() == null ? other.getBizId() == null : this.getBizId().equals(other.getBizId()))
            && (this.getBoUse() == null ? other.getBoUse() == null : this.getBoUse().equals(other.getBoUse()))
            && (this.getNoUse() == null ? other.getNoUse() == null : this.getNoUse().equals(other.getNoUse()))
            && (this.getCsmCrdLevel() == null ? other.getCsmCrdLevel() == null : this.getCsmCrdLevel().equals(other.getCsmCrdLevel()))
            && (this.getHappenType() == null ? other.getHappenType() == null : this.getHappenType().equals(other.getHappenType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCrdId() == null) ? 0 : getCrdId().hashCode());
        result = prime * result + ((getCrdNum() == null) ? 0 : getCrdNum().hashCode());
        result = prime * result + ((getCreditMode() == null) ? 0 : getCreditMode().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getStatusCd() == null) ? 0 : getStatusCd().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getValidDate() == null) ? 0 : getValidDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getGuarantyType() == null) ? 0 : getGuarantyType().hashCode());
        result = prime * result + ((getTermNum() == null) ? 0 : getTermNum().hashCode());
        result = prime * result + ((getTermUnit() == null) ? 0 : getTermUnit().hashCode());
        result = prime * result + ((getHappenNature() == null) ? 0 : getHappenNature().hashCode());
        result = prime * result + ((getRmbAmt() == null) ? 0 : getRmbAmt().hashCode());
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        result = prime * result + ((getBizId() == null) ? 0 : getBizId().hashCode());
        result = prime * result + ((getBoUse() == null) ? 0 : getBoUse().hashCode());
        result = prime * result + ((getNoUse() == null) ? 0 : getNoUse().hashCode());
        result = prime * result + ((getCsmCrdLevel() == null) ? 0 : getCsmCrdLevel().hashCode());
        result = prime * result + ((getHappenType() == null) ? 0 : getHappenType().hashCode());
        return result;
    }
}