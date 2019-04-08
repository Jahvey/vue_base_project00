package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用款计划表：Tb_Loan_Payout_Plan
 * @author Administrator
 *
 */
public class CrtTbLoanPayoutPlan {
	
    private String payoutPlanId;		//(主键)

    private Date payoutDate;			//用款日期

    private BigDecimal payoutAmt;		//用款金额

    private String contractDetailId;	//业务合同ID

    private BigDecimal periodsNumber;	//期数

    private Date createTime;			//更新时间

    private Date updateTime;			//修改时间

    private String loanuse;				//贷款用途

    private String summaryId;			//借据id

    private String loanId;				//放款id

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
}