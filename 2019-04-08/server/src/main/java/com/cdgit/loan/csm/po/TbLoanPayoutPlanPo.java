package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class TbLoanPayoutPlanPo {
    private String payoutPlanId;

    private Date payoutDate;

    private BigDecimal payoutAmt;

    private String contractDetailId;

    private BigDecimal periodsNumber;

    private Date createTime;

    private Date updateTime;

    private String loanuse;

    private String summaryId;

    private String loanId;

    public String getPayoutPlanId() {
        return payoutPlanId;
    }

    public void setPayoutPlanId(String payoutPlanId) {
        this.payoutPlanId = payoutPlanId == null ? null : payoutPlanId.trim();
    }

    public Date getPayoutDate() {
        return payoutDate;
    }

    public void setPayoutDate(Date payoutDate) {
        this.payoutDate = payoutDate;
    }

    public BigDecimal getPayoutAmt() {
        return payoutAmt;
    }

    public void setPayoutAmt(BigDecimal payoutAmt) {
        this.payoutAmt = payoutAmt;
    }

    public String getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(String contractDetailId) {
        this.contractDetailId = contractDetailId == null ? null : contractDetailId.trim();
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

    public String getLoanuse() {
        return loanuse;
    }

    public void setLoanuse(String loanuse) {
        this.loanuse = loanuse == null ? null : loanuse.trim();
    }

    public String getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(String summaryId) {
        this.summaryId = summaryId == null ? null : summaryId.trim();
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

	@Override
	public String toString() {
		return "TbLoanPayoutPlanPo [payoutPlanId=" + payoutPlanId + ", payoutDate=" + payoutDate + ", payoutAmt="
				+ payoutAmt + ", contractDetailId=" + contractDetailId + ", periodsNumber=" + periodsNumber
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", loanuse=" + loanuse + ", summaryId="
				+ summaryId + ", loanId=" + loanId + "]";
	}
    
    
}