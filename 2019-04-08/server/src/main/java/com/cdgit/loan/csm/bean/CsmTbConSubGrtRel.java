package com.cdgit.loan.csm.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbConSubGrtRel {
    private String relationId;

    private String subcontractId;

    private String suretyId;

    private BigDecimal suretyAmt;

    private String grtStatus;

    private String partyId;

    private Date createTime;

    private Date updateTime;

    private String suretyIdBackups;

    private BigDecimal grtAmt;

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId == null ? null : relationId.trim();
    }

    public String getSubcontractId() {
        return subcontractId;
    }

    public void setSubcontractId(String subcontractId) {
        this.subcontractId = subcontractId == null ? null : subcontractId.trim();
    }

    public String getSuretyId() {
        return suretyId;
    }

    public void setSuretyId(String suretyId) {
        this.suretyId = suretyId == null ? null : suretyId.trim();
    }

    public BigDecimal getSuretyAmt() {
        return suretyAmt;
    }

    public void setSuretyAmt(BigDecimal suretyAmt) {
        this.suretyAmt = suretyAmt;
    }

    public String getGrtStatus() {
        return grtStatus;
    }

    public void setGrtStatus(String grtStatus) {
        this.grtStatus = grtStatus == null ? null : grtStatus.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
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

    public String getSuretyIdBackups() {
        return suretyIdBackups;
    }

    public void setSuretyIdBackups(String suretyIdBackups) {
        this.suretyIdBackups = suretyIdBackups == null ? null : suretyIdBackups.trim();
    }

    public BigDecimal getGrtAmt() {
        return grtAmt;
    }

    public void setGrtAmt(BigDecimal grtAmt) {
        this.grtAmt = grtAmt;
    }
}