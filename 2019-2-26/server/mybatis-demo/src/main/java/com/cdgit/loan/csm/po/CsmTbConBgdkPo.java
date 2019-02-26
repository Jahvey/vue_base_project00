package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbConBgdkPo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String bgfs;

    private BigDecimal bgjyje;

    private String bbgf;

    private String contractId;

    private BigDecimal restRate;

    private String payWay;

    private String payDepend1;

    private String payDepend2;

    private String payDepend3;

    private BigDecimal prepayJs;

    private BigDecimal prepayMakeupRate;

    private BigDecimal leastPrepayAmount;

    private BigDecimal leastSettleRate;

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

    public String getBgfs() {
        return bgfs;
    }

    public void setBgfs(String bgfs) {
        this.bgfs = bgfs == null ? null : bgfs.trim();
    }

    public BigDecimal getBgjyje() {
        return bgjyje;
    }

    public void setBgjyje(BigDecimal bgjyje) {
        this.bgjyje = bgjyje;
    }

    public String getBbgf() {
        return bbgf;
    }

    public void setBbgf(String bbgf) {
        this.bbgf = bbgf == null ? null : bbgf.trim();
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

    public BigDecimal getLeastPrepayAmount() {
        return leastPrepayAmount;
    }

    public void setLeastPrepayAmount(BigDecimal leastPrepayAmount) {
        this.leastPrepayAmount = leastPrepayAmount;
    }

    public BigDecimal getLeastSettleRate() {
        return leastSettleRate;
    }

    public void setLeastSettleRate(BigDecimal leastSettleRate) {
        this.leastSettleRate = leastSettleRate;
    }

	@Override
	public String toString() {
		return "CsmTbConBgdkPo [applyDetailId=" + applyDetailId + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", amountDetailId=" + amountDetailId + ", bgfs=" + bgfs + ", bgjyje=" + bgjyje
				+ ", bbgf=" + bbgf + ", contractId=" + contractId + ", restRate=" + restRate + ", payWay=" + payWay
				+ ", payDepend1=" + payDepend1 + ", payDepend2=" + payDepend2 + ", payDepend3=" + payDepend3
				+ ", prepayJs=" + prepayJs + ", prepayMakeupRate=" + prepayMakeupRate + ", leastPrepayAmount="
				+ leastPrepayAmount + ", leastSettleRate=" + leastSettleRate + "]";
	}
    
    
}