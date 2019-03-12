package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 	业务申请明细信息表	tb_biz_amount_detail_approve
 * @author Administrator
 *	没有主键
 */
public class BizAmountDetailApprove {
	
    private String productType;					//业务品种

    private String currencyCd;					//币种(:CD000001)

    private BigDecimal exchangeRate;			//汇率

    private String cycleUnit;					//期限单位

    private Integer creditTerm;					//期限

    private String loanUse;						//贷款用途

    private String repaymentType;				//还款方式(:XD_SXCD1162)

    private String cycleInd;					//是否可循环(:XD_0002)

    private Short broadCycle;					//宽限期

    private String broadCycleUnit;				//宽期限单位(:XD_GGCD6009)

    private Date createTime;					//创建时间

    private Date updateTime;					//更新时间

    private String amountDetailId;				//额度申请明细ID（不允许为null，但是不是主键）

    private Date exchangeRateDate;				//汇率时点

    private String oldDetailId;					//原明细ID

    private BigDecimal detailAmt;				//明细金额

    private String amountId;					//业务基本信息唯一标识（不允许null）

    private String payment;						//还款来源

    private String prepaymentPenalty;			//提前还款是否收取违约金(:XD_0002)

    private BigDecimal rmbAmt;					//折算人民币金额

    private String cycleIndCon;					//合同是否循环(:XD_0002)

    private String holidayFlg;					//节假日标志

    private String firstRepayTerm;				//首次还款期次

    private BigDecimal detailBalance;			//批复分项可用金额

    private BigDecimal detailUsed;				//分项已用

    private Date endDate;						//申报止期

    private String approveId;					//批准id

    private BigDecimal noUse;

    private BigDecimal boUse;

    private String crdDtlId;

    private String creditMode;

    private Date beginDate;

    private String creditStatus;

    private BigDecimal assurePer;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit == null ? null : cycleUnit.trim();
    }

    public Integer getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(Integer creditTerm) {
        this.creditTerm = creditTerm;
    }

    public String getLoanUse() {
        return loanUse;
    }

    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse == null ? null : loanUse.trim();
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType == null ? null : repaymentType.trim();
    }

    public String getCycleInd() {
        return cycleInd;
    }

    public void setCycleInd(String cycleInd) {
        this.cycleInd = cycleInd == null ? null : cycleInd.trim();
    }

    public Short getBroadCycle() {
        return broadCycle;
    }

    public void setBroadCycle(Short broadCycle) {
        this.broadCycle = broadCycle;
    }

    public String getBroadCycleUnit() {
        return broadCycleUnit;
    }

    public void setBroadCycleUnit(String broadCycleUnit) {
        this.broadCycleUnit = broadCycleUnit == null ? null : broadCycleUnit.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")			//格式化时间戳
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAmountDetailId() {
        return amountDetailId;
    }

    public void setAmountDetailId(String amountDetailId) {
        this.amountDetailId = amountDetailId == null ? null : amountDetailId.trim();
    }

    public Date getExchangeRateDate() {
        return exchangeRateDate;
    }

    public void setExchangeRateDate(Date exchangeRateDate) {
        this.exchangeRateDate = exchangeRateDate;
    }

    public String getOldDetailId() {
        return oldDetailId;
    }

    public void setOldDetailId(String oldDetailId) {
        this.oldDetailId = oldDetailId == null ? null : oldDetailId.trim();
    }

    public BigDecimal getDetailAmt() {
        return detailAmt;
    }

    public void setDetailAmt(BigDecimal detailAmt) {
        this.detailAmt = detailAmt;
    }

    public String getAmountId() {
        return amountId;
    }

    public void setAmountId(String amountId) {
        this.amountId = amountId == null ? null : amountId.trim();
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    public String getPrepaymentPenalty() {
        return prepaymentPenalty;
    }

    public void setPrepaymentPenalty(String prepaymentPenalty) {
        this.prepaymentPenalty = prepaymentPenalty == null ? null : prepaymentPenalty.trim();
    }

    public BigDecimal getRmbAmt() {
        return rmbAmt;
    }

    public void setRmbAmt(BigDecimal rmbAmt) {
        this.rmbAmt = rmbAmt;
    }

    public String getCycleIndCon() {
        return cycleIndCon;
    }

    public void setCycleIndCon(String cycleIndCon) {
        this.cycleIndCon = cycleIndCon == null ? null : cycleIndCon.trim();
    }

    public String getHolidayFlg() {
        return holidayFlg;
    }

    public void setHolidayFlg(String holidayFlg) {
        this.holidayFlg = holidayFlg == null ? null : holidayFlg.trim();
    }

    public String getFirstRepayTerm() {
        return firstRepayTerm;
    }

    public void setFirstRepayTerm(String firstRepayTerm) {
        this.firstRepayTerm = firstRepayTerm == null ? null : firstRepayTerm.trim();
    }

    public BigDecimal getDetailBalance() {
        return detailBalance;
    }

    public void setDetailBalance(BigDecimal detailBalance) {
        this.detailBalance = detailBalance;
    }

    public BigDecimal getDetailUsed() {
        return detailUsed;
    }

    public void setDetailUsed(BigDecimal detailUsed) {
        this.detailUsed = detailUsed;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId == null ? null : approveId.trim();
    }

    public BigDecimal getNoUse() {
        return noUse;
    }

    public void setNoUse(BigDecimal noUse) {
        this.noUse = noUse;
    }

    public BigDecimal getBoUse() {
        return boUse;
    }

    public void setBoUse(BigDecimal boUse) {
        this.boUse = boUse;
    }

    public String getCrdDtlId() {
        return crdDtlId;
    }

    public void setCrdDtlId(String crdDtlId) {
        this.crdDtlId = crdDtlId == null ? null : crdDtlId.trim();
    }

    public String getCreditMode() {
        return creditMode;
    }

    public void setCreditMode(String creditMode) {
        this.creditMode = creditMode == null ? null : creditMode.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus == null ? null : creditStatus.trim();
    }

    public BigDecimal getAssurePer() {
        return assurePer;
    }

    public void setAssurePer(BigDecimal assurePer) {
        this.assurePer = assurePer;
    }
}