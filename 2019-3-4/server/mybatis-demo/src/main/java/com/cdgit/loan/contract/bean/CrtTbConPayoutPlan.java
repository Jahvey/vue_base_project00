package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 合同用款计划表：TB_CON_PAYOUT_PLAN
 * @author Administrator
 *
 */
public class CrtTbConPayoutPlan {
	
    private String payoutPlanId;				//用款计划ID(主键)

    private Date payoutDate;					//用款日期

    private BigDecimal payoutAmt;				//用款金额	

    private String contractDetailId;			//业务合同id

    private BigDecimal periodsNumber;			//期数

    private Date createTime;					//更新时间

    private Date updateTime;					//修改时间

    private String loanuse;						//用途

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
}