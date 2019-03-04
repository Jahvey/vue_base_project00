package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 	TB_LOAN_REPAY_PLAN:还款计划表
 * @author Administrator
 *
 */
public class CrtTbLoanRepayPlan {
	
    private String repayPlanId;			//(主键)

    private Date repayDate;				//还款日期

    private BigDecimal repayAmt;		//还款金额

    private BigDecimal periodsNumber;	//期数

    private Date createTime;			//创建时间

    private Date updateTime;			//更新时间

    private String contractId;			//业务合同ID

    private String summaryId;			//借据ID

    private String loanId;				//放款ID

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