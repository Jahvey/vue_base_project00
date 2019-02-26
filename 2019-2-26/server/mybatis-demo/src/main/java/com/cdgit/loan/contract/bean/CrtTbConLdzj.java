package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 	01-流动资金贷款批复表：Tb_Con_Ldzj
 * @author Administrator
 *
 */
public class CrtTbConLdzj {
	
    private String applyDetailId;				//业务明细的唯一标识（主键）

    private Date createTime;					//创建时间

    private Date updateTime;					//更新时间

    private String amountDetailId;				//额度申请明细ID

    private String contractId;					//合同id

    private BigDecimal restRate;				//结算金额不低于借款金额的%

    private String payWay;						//资金支付方式(:CDXY0144)

    private String payDepend1;					//受托支付支付依据1

    private String payDepend2;					//受托支付支付依据2

    private String payDepend3;					//受托支付支付依据3

    private BigDecimal leastPrepayAmount;		//提前还款最低金额

    private BigDecimal prepayJs;				//提前还款基数

    private BigDecimal prepayMakeupRate;		//提前还款补偿率	

    private BigDecimal leastSettleRate;			//最低结算比率

    private String jmrhsx;						//军民融合属性(XD_JMRHSX001)

    private String sfjmrhsx;					//是否军民融合属性(YesOrNo)

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