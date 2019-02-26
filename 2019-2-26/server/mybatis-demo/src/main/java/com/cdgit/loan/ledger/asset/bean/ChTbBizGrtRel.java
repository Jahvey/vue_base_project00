package com.cdgit.loan.ledger.asset.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ChTbBizGrtRel {
    private String relationId;

    private String approveId;

    private String applyId;

    private String suretyId;

    private String suretyType;

    private BigDecimal suretyAmt;

    private BigDecimal mortgageRate;

    private Date createTime;

    private Date updateTime;

    private BigDecimal mortgageValue;

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId == null ? null : relationId.trim();
    }

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId == null ? null : approveId.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getSuretyId() {
        return suretyId;
    }

    public void setSuretyId(String suretyId) {
        this.suretyId = suretyId == null ? null : suretyId.trim();
    }

    public String getSuretyType() {
        return suretyType;
    }

    public void setSuretyType(String suretyType) {
        this.suretyType = suretyType == null ? null : suretyType.trim();
    }

    public BigDecimal getSuretyAmt() {
        return suretyAmt;
    }

    public void setSuretyAmt(BigDecimal suretyAmt) {
        this.suretyAmt = suretyAmt;
    }

    public BigDecimal getMortgageRate() {
        return mortgageRate;
    }

    public void setMortgageRate(BigDecimal mortgageRate) {
        this.mortgageRate = mortgageRate;
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

    public BigDecimal getMortgageValue() {
        return mortgageValue;
    }

    public void setMortgageValue(BigDecimal mortgageValue) {
        this.mortgageValue = mortgageValue;
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
        ChTbBizGrtRel other = (ChTbBizGrtRel) that;
        return (this.getRelationId() == null ? other.getRelationId() == null : this.getRelationId().equals(other.getRelationId()))
            && (this.getApproveId() == null ? other.getApproveId() == null : this.getApproveId().equals(other.getApproveId()))
            && (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()))
            && (this.getSuretyId() == null ? other.getSuretyId() == null : this.getSuretyId().equals(other.getSuretyId()))
            && (this.getSuretyType() == null ? other.getSuretyType() == null : this.getSuretyType().equals(other.getSuretyType()))
            && (this.getSuretyAmt() == null ? other.getSuretyAmt() == null : this.getSuretyAmt().equals(other.getSuretyAmt()))
            && (this.getMortgageRate() == null ? other.getMortgageRate() == null : this.getMortgageRate().equals(other.getMortgageRate()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getMortgageValue() == null ? other.getMortgageValue() == null : this.getMortgageValue().equals(other.getMortgageValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRelationId() == null) ? 0 : getRelationId().hashCode());
        result = prime * result + ((getApproveId() == null) ? 0 : getApproveId().hashCode());
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        result = prime * result + ((getSuretyId() == null) ? 0 : getSuretyId().hashCode());
        result = prime * result + ((getSuretyType() == null) ? 0 : getSuretyType().hashCode());
        result = prime * result + ((getSuretyAmt() == null) ? 0 : getSuretyAmt().hashCode());
        result = prime * result + ((getMortgageRate() == null) ? 0 : getMortgageRate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getMortgageValue() == null) ? 0 : getMortgageValue().hashCode());
        return result;
    }
}