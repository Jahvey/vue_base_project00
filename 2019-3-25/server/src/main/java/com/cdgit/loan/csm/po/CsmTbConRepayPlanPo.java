package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbConRepayPlanPo {
    private String repayPlanId;

    private Date repayDate;

    private BigDecimal repayAmt;

    private BigDecimal periodsNumber;

    private Date createTime;

    private Date updateTime;

    private String contractId;

    public String getRepayPlanId() {
        return repayPlanId;
    }

    public void setRepayPlanId(String repayPlanId) {
        this.repayPlanId = repayPlanId == null ? null : repayPlanId.trim();
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public BigDecimal getRepayAmt() {
        return repayAmt;
    }

    public void setRepayAmt(BigDecimal repayAmt) {
        this.repayAmt = repayAmt;
    }

    public BigDecimal getPeriodsNumber() {
        return periodsNumber;
    }

    public void setPeriodsNumber(BigDecimal periodsNumber) {
        this.periodsNumber = periodsNumber;
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

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

	@Override
	public String toString() {
		return "CsmTbConRepayPlanPo [repayPlanId=" + repayPlanId + ", repayDate=" + repayDate + ", repayAmt=" + repayAmt
				+ ", periodsNumber=" + periodsNumber + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", contractId=" + contractId + "]";
	}
    
    
}