package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Tb_Loan_Hp_Amt 汇票出账金额表
 * @author Administrator
 *
 */
public class CrtTbLoanHpAmt {
	
    private String moneyUseId;				//出账金额id(主键)

    private String loanId;					//出账id

    private BigDecimal loanAmt;				//出账金额

    private String ordNumber;				//编号

    private String pyeAcctNm;				//收款人户名

    private String pyeAcctNo;				//收款人账号

    private String pyeOpenAcctBnkNm;		//收款人开户行行名

    private Date drftExpDt;					//汇票到期日期

    private Date issuDt;					//出票日期

    private String billNo;					//票据号

    private String billState;				//票据状态(0-正常；1-删除)

    private String summaryId;				//借据id

    private String summaryNum;				//借据号

    private String drweBnkNm;				//付款行全称

    private String drweBnkNo;				//付款行行号

    private String drweBnkAdr;				//付款行地址

    private String applyDetailId;			//汇票明细ID

    private String hpBillStatus;			//票据状态(来自票据系统):XD_HPZTCD0001

    private Date updateTime;				//更新时间
    
    private BigDecimal sortOrder;			//排序序号

    public String getMoneyUseId() {
        return moneyUseId;
    }

    public void setMoneyUseId(String moneyUseId) {
        this.moneyUseId = moneyUseId == null ? null : moneyUseId.trim();
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(BigDecimal loanAmt) {
        this.loanAmt = loanAmt;
    }

    public String getOrdNumber() {
        return ordNumber;
    }

    public void setOrdNumber(String ordNumber) {
        this.ordNumber = ordNumber == null ? null : ordNumber.trim();
    }

    public String getPyeAcctNm() {
        return pyeAcctNm;
    }

    public void setPyeAcctNm(String pyeAcctNm) {
        this.pyeAcctNm = pyeAcctNm == null ? null : pyeAcctNm.trim();
    }

    public String getPyeAcctNo() {
        return pyeAcctNo;
    }

    public void setPyeAcctNo(String pyeAcctNo) {
        this.pyeAcctNo = pyeAcctNo == null ? null : pyeAcctNo.trim();
    }

    public String getPyeOpenAcctBnkNm() {
        return pyeOpenAcctBnkNm;
    }

    public void setPyeOpenAcctBnkNm(String pyeOpenAcctBnkNm) {
        this.pyeOpenAcctBnkNm = pyeOpenAcctBnkNm == null ? null : pyeOpenAcctBnkNm.trim();
    }

    public Date getDrftExpDt() {
        return drftExpDt;
    }

    public void setDrftExpDt(Date drftExpDt) {
        this.drftExpDt = drftExpDt;
    }

    public Date getIssuDt() {
        return issuDt;
    }

    public void setIssuDt(Date issuDt) {
        this.issuDt = issuDt;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public String getBillState() {
        return billState;
    }

    public void setBillState(String billState) {
        this.billState = billState == null ? null : billState.trim();
    }

    public String getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(String summaryId) {
        this.summaryId = summaryId == null ? null : summaryId.trim();
    }

    public String getSummaryNum() {
        return summaryNum;
    }

    public void setSummaryNum(String summaryNum) {
        this.summaryNum = summaryNum == null ? null : summaryNum.trim();
    }

    public String getDrweBnkNm() {
        return drweBnkNm;
    }

    public void setDrweBnkNm(String drweBnkNm) {
        this.drweBnkNm = drweBnkNm == null ? null : drweBnkNm.trim();
    }

    public String getDrweBnkNo() {
        return drweBnkNo;
    }

    public void setDrweBnkNo(String drweBnkNo) {
        this.drweBnkNo = drweBnkNo == null ? null : drweBnkNo.trim();
    }

    public String getDrweBnkAdr() {
        return drweBnkAdr;
    }

    public void setDrweBnkAdr(String drweBnkAdr) {
        this.drweBnkAdr = drweBnkAdr == null ? null : drweBnkAdr.trim();
    }

    public String getApplyDetailId() {
        return applyDetailId;
    }

    public void setApplyDetailId(String applyDetailId) {
        this.applyDetailId = applyDetailId == null ? null : applyDetailId.trim();
    }

    public String getHpBillStatus() {
        return hpBillStatus;
    }

    public void setHpBillStatus(String hpBillStatus) {
        this.hpBillStatus = hpBillStatus == null ? null : hpBillStatus.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(BigDecimal sortOrder) {
        this.sortOrder = sortOrder;
    }
}