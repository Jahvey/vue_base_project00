package com.cdgit.loan.csm.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 申请基本信息表	tb_Biz_Amount_Approve
 * @author Administrator
 *
 */
public class CsmBizAmountApprove {
	
    private String amountId;					//业务基本信息唯一标识（主键），有索引

    private String guarantyType;				//担保方式(:CDZC0005)

    private String partyId;						//参与人ID

    private String amountClassify;				//额度分类

    private String creditType;					//额度类型

    private BigDecimal creditAmount;			//申请额度

    private Integer creditTerm;					//期限（信用期限）

    private String applyDesc;					//描述信息

    private Date createTime;					//创建时间
    
    private Date updateTime;					//更新时间

    private String cycleUnit;					//期限单位

    private String statusCd;					//额度状态(:XD_SXCD8003)

    private String currencyCd;					//币种(:CD000001)

    private String mainGuarantyType;			//主担保方式

    private String approveId;					//业务基本信息唯一标识(批准)，外键，有索引

    private BigDecimal creditAvi;				//批复可用

    private BigDecimal creditUsed;				//批复已用

    private String frzNum;						//冻结编号

    private BigDecimal frzAmt;					//冻结金额(该字段不使用

    private String operFlag;					//是否到期自动解冻(该字段不使用)

    private String frzEndDate;					//冻结止期(该字段不使用)

    private String frzType;						//冻结种类(该字段不使用)

    private String frzStatus;					//冻结状态(该字段不使用)

    private String frzReason;					//冻结原因（该字段不使用）

    public String getAmountId() {
        return amountId;
    }

    public void setAmountId(String amountId) {
        this.amountId = amountId == null ? null : amountId.trim();
    }

    public String getGuarantyType() {
        return guarantyType;
    }

    public void setGuarantyType(String guarantyType) {
        this.guarantyType = guarantyType == null ? null : guarantyType.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getAmountClassify() {
        return amountClassify;
    }

    public void setAmountClassify(String amountClassify) {
        this.amountClassify = amountClassify == null ? null : amountClassify.trim();
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType == null ? null : creditType.trim();
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Integer getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(Integer creditTerm) {
        this.creditTerm = creditTerm;
    }

    public String getApplyDesc() {
        return applyDesc;
    }

    public void setApplyDesc(String applyDesc) {
        this.applyDesc = applyDesc == null ? null : applyDesc.trim();
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

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit == null ? null : cycleUnit.trim();
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd == null ? null : statusCd.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public String getMainGuarantyType() {
        return mainGuarantyType;
    }

    public void setMainGuarantyType(String mainGuarantyType) {
        this.mainGuarantyType = mainGuarantyType == null ? null : mainGuarantyType.trim();
    }

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId == null ? null : approveId.trim();
    }

    public BigDecimal getCreditAvi() {
        return creditAvi;
    }

    public void setCreditAvi(BigDecimal creditAvi) {
        this.creditAvi = creditAvi;
    }

    public BigDecimal getCreditUsed() {
        return creditUsed;
    }

    public void setCreditUsed(BigDecimal creditUsed) {
        this.creditUsed = creditUsed;
    }

    public String getFrzNum() {
        return frzNum;
    }

    public void setFrzNum(String frzNum) {
        this.frzNum = frzNum == null ? null : frzNum.trim();
    }

    public BigDecimal getFrzAmt() {
        return frzAmt;
    }

    public void setFrzAmt(BigDecimal frzAmt) {
        this.frzAmt = frzAmt;
    }

    public String getOperFlag() {
        return operFlag;
    }

    public void setOperFlag(String operFlag) {
        this.operFlag = operFlag == null ? null : operFlag.trim();
    }

    public String getFrzEndDate() {
        return frzEndDate;
    }

    public void setFrzEndDate(String frzEndDate) {
        this.frzEndDate = frzEndDate == null ? null : frzEndDate.trim();
    }

    public String getFrzType() {
        return frzType;
    }

    public void setFrzType(String frzType) {
        this.frzType = frzType == null ? null : frzType.trim();
    }

    public String getFrzStatus() {
        return frzStatus;
    }

    public void setFrzStatus(String frzStatus) {
        this.frzStatus = frzStatus == null ? null : frzStatus.trim();
    }

    public String getFrzReason() {
        return frzReason;
    }

    public void setFrzReason(String frzReason) {
        this.frzReason = frzReason == null ? null : frzReason.trim();
    }
}