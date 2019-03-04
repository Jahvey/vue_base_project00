package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbConFeePo {
    private String feeId;

    private String costType;

    private String chargingDirection;

    private String chargingFrequency;

    private String chargingType;

    private BigDecimal chargingProportion;

    private BigDecimal shouldFee;

    private BigDecimal reductionFee;

    private BigDecimal actualFee;

    private Date feeDate;

    private String contractDetailId;

    private Date createTime;

    private Date updateTime;

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId == null ? null : feeId.trim();
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType == null ? null : costType.trim();
    }

    public String getChargingDirection() {
        return chargingDirection;
    }

    public void setChargingDirection(String chargingDirection) {
        this.chargingDirection = chargingDirection == null ? null : chargingDirection.trim();
    }

    public String getChargingFrequency() {
        return chargingFrequency;
    }

    public void setChargingFrequency(String chargingFrequency) {
        this.chargingFrequency = chargingFrequency == null ? null : chargingFrequency.trim();
    }

    public String getChargingType() {
        return chargingType;
    }

    public void setChargingType(String chargingType) {
        this.chargingType = chargingType == null ? null : chargingType.trim();
    }

    public BigDecimal getChargingProportion() {
        return chargingProportion;
    }

    public void setChargingProportion(BigDecimal chargingProportion) {
        this.chargingProportion = chargingProportion;
    }

    public BigDecimal getShouldFee() {
        return shouldFee;
    }

    public void setShouldFee(BigDecimal shouldFee) {
        this.shouldFee = shouldFee;
    }

    public BigDecimal getReductionFee() {
        return reductionFee;
    }

    public void setReductionFee(BigDecimal reductionFee) {
        this.reductionFee = reductionFee;
    }

    public BigDecimal getActualFee() {
        return actualFee;
    }

    public void setActualFee(BigDecimal actualFee) {
        this.actualFee = actualFee;
    }

    public Date getFeeDate() {
        return feeDate;
    }

    public void setFeeDate(Date feeDate) {
        this.feeDate = feeDate;
    }

    public String getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(String contractDetailId) {
        this.contractDetailId = contractDetailId == null ? null : contractDetailId.trim();
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

	@Override
	public String toString() {
		return "CsmTbConFeePo [feeId=" + feeId + ", costType=" + costType + ", chargingDirection=" + chargingDirection
				+ ", chargingFrequency=" + chargingFrequency + ", chargingType=" + chargingType
				+ ", chargingProportion=" + chargingProportion + ", shouldFee=" + shouldFee + ", reductionFee="
				+ reductionFee + ", actualFee=" + actualFee + ", feeDate=" + feeDate + ", contractDetailId="
				+ contractDetailId + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
    
    
}