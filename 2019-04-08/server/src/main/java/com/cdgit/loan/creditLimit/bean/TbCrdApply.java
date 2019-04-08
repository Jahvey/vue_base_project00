package com.cdgit.loan.creditLimit.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbCrdApply {
    private String crdId;

    private String crdNum;

    private String creditMode;

    private String partyId;

    private String statusCd;

    private String orgNum;

    private String userNum;

    private Date applyDate;

    private Date updateTime;

    private String guarantyType;

    private BigDecimal termNum;

    private String termUnit;

    private String happenNature;

    private String happenType;

    private BigDecimal rmbAmt;

    private String oldCrdId;

    private String bizId;

    private String csmCrdLevel;

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

    public BigDecimal getTermNum() {
        return termNum;
    }

    public void setTermNum(BigDecimal termNum) {
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

    public String getHappenType() {
        return happenType;
    }

    public void setHappenType(String happenType) {
        this.happenType = happenType == null ? null : happenType.trim();
    }

    public BigDecimal getRmbAmt() {
        return rmbAmt;
    }

    public void setRmbAmt(BigDecimal rmbAmt) {
        this.rmbAmt = rmbAmt;
    }

    public String getOldCrdId() {
        return oldCrdId;
    }

    public void setOldCrdId(String oldCrdId) {
        this.oldCrdId = oldCrdId == null ? null : oldCrdId.trim();
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
    }

    public String getCsmCrdLevel() {
        return csmCrdLevel;
    }

    public void setCsmCrdLevel(String csmCrdLevel) {
        this.csmCrdLevel = csmCrdLevel == null ? null : csmCrdLevel.trim();
    }
}