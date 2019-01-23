package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbConLdzjPo {
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String contractId;

    private BigDecimal restRate;

    private String payWay;

    private String payDepend1;

    private String payDepend2;

    private String payDepend3;

    private BigDecimal leastPrepayAmount;

    private BigDecimal prepayJs;

    private BigDecimal prepayMakeupRate;

    private BigDecimal leastSettleRate;

    private String jmrhsx;

    private String sfjmrhsx;

    private BigDecimal minAmt;

    public String getApplyDetailId() {
        return applyDetailId;
    }

    public void setApplyDetailId(String applyDetailId) {
        this.applyDetailId = applyDetailId == null ? null : applyDetailId.trim();
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

    public String getAmountDetailId() {
        return amountDetailId;
    }

    public void setAmountDetailId(String amountDetailId) {
        this.amountDetailId = amountDetailId == null ? null : amountDetailId.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public BigDecimal getRestRate() {
        return restRate;
    }

    public void setRestRate(BigDecimal restRate) {
        this.restRate = restRate;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public String getPayDepend1() {
        return payDepend1;
    }

    public void setPayDepend1(String payDepend1) {
        this.payDepend1 = payDepend1 == null ? null : payDepend1.trim();
    }

    public String getPayDepend2() {
        return payDepend2;
    }

    public void setPayDepend2(String payDepend2) {
        this.payDepend2 = payDepend2 == null ? null : payDepend2.trim();
    }

    public String getPayDepend3() {
        return payDepend3;
    }

    public void setPayDepend3(String payDepend3) {
        this.payDepend3 = payDepend3 == null ? null : payDepend3.trim();
    }

    public BigDecimal getLeastPrepayAmount() {
        return leastPrepayAmount;
    }

    public void setLeastPrepayAmount(BigDecimal leastPrepayAmount) {
        this.leastPrepayAmount = leastPrepayAmount;
    }

    public BigDecimal getPrepayJs() {
        return prepayJs;
    }

    public void setPrepayJs(BigDecimal prepayJs) {
        this.prepayJs = prepayJs;
    }

    public BigDecimal getPrepayMakeupRate() {
        return prepayMakeupRate;
    }

    public void setPrepayMakeupRate(BigDecimal prepayMakeupRate) {
        this.prepayMakeupRate = prepayMakeupRate;
    }

    public BigDecimal getLeastSettleRate() {
        return leastSettleRate;
    }

    public void setLeastSettleRate(BigDecimal leastSettleRate) {
        this.leastSettleRate = leastSettleRate;
    }

    public String getJmrhsx() {
        return jmrhsx;
    }

    public void setJmrhsx(String jmrhsx) {
        this.jmrhsx = jmrhsx == null ? null : jmrhsx.trim();
    }

    public String getSfjmrhsx() {
        return sfjmrhsx;
    }

    public void setSfjmrhsx(String sfjmrhsx) {
        this.sfjmrhsx = sfjmrhsx == null ? null : sfjmrhsx.trim();
    }

    public BigDecimal getMinAmt() {
        return minAmt;
    }

    public void setMinAmt(BigDecimal minAmt) {
        this.minAmt = minAmt;
    }
}