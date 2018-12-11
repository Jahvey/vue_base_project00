package com.cdgit.loan.csm.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbConContractInfo {
    private String contractId;

    private String amountDetailId;

    private String contractNum;

    private String contractAddress;

    private String partyId;

    private String oldContractId;

    private String currencyCd;

    private BigDecimal contractAmt;

    private String contractTerm;

    private String cycleUnit;

    private Date beginDate;

    private Date endDate;

    private Date contractDate;

    private String loanUse;

    private String guarantyType;

    private String loanTurn;

    private String userNum;

    private String orgNum;

    private Date createTime;

    private Date updateTime;

    private String productType;

    private String conStatus;

    private String trusToPayFlg;

    private String stopPayFlg;

    private Short specPaymentDate;

    private BigDecimal exchangeRate;

    private BigDecimal rmbAmt;

    private BigDecimal conBalance;

    private String cycleIndCon;

    private String repaymentType;

    private Date tkDate;

    private String holidayFlg;

    private String mainGuarantyType;

    private String xyId;

    private String paperConNum;

    private Integer internalDays;

    private String clsResult;

    private String ifDataMove;

    private String firstRepayTerm;

    private BigDecimal conYuE;

    private String payWay;

    private String payDepend1;

    private String payDepend2;

    private String payDepend3;

    private String prepaymentPenalty;

    private BigDecimal prepayMakeupRate;

    private BigDecimal leastPrepayAmount;

    private BigDecimal prepayJs;

    private BigDecimal bzjbl;

    private String crdCent;

    private String applyModeType;

    private String lowRiskBizType;

    private String agriculLoans;

    private BigDecimal conOccupy;

    private String crdDtlId;

    private String creditMode;

    private String creditStatus;

    private String jxhjId;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getAmountDetailId() {
        return amountDetailId;
    }

    public void setAmountDetailId(String amountDetailId) {
        this.amountDetailId = amountDetailId == null ? null : amountDetailId.trim();
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum == null ? null : contractNum.trim();
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress == null ? null : contractAddress.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getOldContractId() {
        return oldContractId;
    }

    public void setOldContractId(String oldContractId) {
        this.oldContractId = oldContractId == null ? null : oldContractId.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getContractAmt() {
        return contractAmt;
    }

    public void setContractAmt(BigDecimal contractAmt) {
        this.contractAmt = contractAmt;
    }

    public String getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(String contractTerm) {
        this.contractTerm = contractTerm == null ? null : contractTerm.trim();
    }

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit == null ? null : cycleUnit.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getLoanUse() {
        return loanUse;
    }

    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse == null ? null : loanUse.trim();
    }

    public String getGuarantyType() {
        return guarantyType;
    }

    public void setGuarantyType(String guarantyType) {
        this.guarantyType = guarantyType == null ? null : guarantyType.trim();
    }

    public String getLoanTurn() {
        return loanTurn;
    }

    public void setLoanTurn(String loanTurn) {
        this.loanTurn = loanTurn == null ? null : loanTurn.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getConStatus() {
        return conStatus;
    }

    public void setConStatus(String conStatus) {
        this.conStatus = conStatus == null ? null : conStatus.trim();
    }

    public String getTrusToPayFlg() {
        return trusToPayFlg;
    }

    public void setTrusToPayFlg(String trusToPayFlg) {
        this.trusToPayFlg = trusToPayFlg == null ? null : trusToPayFlg.trim();
    }

    public String getStopPayFlg() {
        return stopPayFlg;
    }

    public void setStopPayFlg(String stopPayFlg) {
        this.stopPayFlg = stopPayFlg == null ? null : stopPayFlg.trim();
    }

    public Short getSpecPaymentDate() {
        return specPaymentDate;
    }

    public void setSpecPaymentDate(Short specPaymentDate) {
        this.specPaymentDate = specPaymentDate;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getRmbAmt() {
        return rmbAmt;
    }

    public void setRmbAmt(BigDecimal rmbAmt) {
        this.rmbAmt = rmbAmt;
    }

    public BigDecimal getConBalance() {
        return conBalance;
    }

    public void setConBalance(BigDecimal conBalance) {
        this.conBalance = conBalance;
    }

    public String getCycleIndCon() {
        return cycleIndCon;
    }

    public void setCycleIndCon(String cycleIndCon) {
        this.cycleIndCon = cycleIndCon == null ? null : cycleIndCon.trim();
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType == null ? null : repaymentType.trim();
    }

    public Date getTkDate() {
        return tkDate;
    }

    public void setTkDate(Date tkDate) {
        this.tkDate = tkDate;
    }

    public String getHolidayFlg() {
        return holidayFlg;
    }

    public void setHolidayFlg(String holidayFlg) {
        this.holidayFlg = holidayFlg == null ? null : holidayFlg.trim();
    }

    public String getMainGuarantyType() {
        return mainGuarantyType;
    }

    public void setMainGuarantyType(String mainGuarantyType) {
        this.mainGuarantyType = mainGuarantyType == null ? null : mainGuarantyType.trim();
    }

    public String getXyId() {
        return xyId;
    }

    public void setXyId(String xyId) {
        this.xyId = xyId == null ? null : xyId.trim();
    }

    public String getPaperConNum() {
        return paperConNum;
    }

    public void setPaperConNum(String paperConNum) {
        this.paperConNum = paperConNum == null ? null : paperConNum.trim();
    }

    public Integer getInternalDays() {
        return internalDays;
    }

    public void setInternalDays(Integer internalDays) {
        this.internalDays = internalDays;
    }

    public String getClsResult() {
        return clsResult;
    }

    public void setClsResult(String clsResult) {
        this.clsResult = clsResult == null ? null : clsResult.trim();
    }

    public String getIfDataMove() {
        return ifDataMove;
    }

    public void setIfDataMove(String ifDataMove) {
        this.ifDataMove = ifDataMove == null ? null : ifDataMove.trim();
    }

    public String getFirstRepayTerm() {
        return firstRepayTerm;
    }

    public void setFirstRepayTerm(String firstRepayTerm) {
        this.firstRepayTerm = firstRepayTerm == null ? null : firstRepayTerm.trim();
    }

    public BigDecimal getConYuE() {
        return conYuE;
    }

    public void setConYuE(BigDecimal conYuE) {
        this.conYuE = conYuE;
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

    public String getPrepaymentPenalty() {
        return prepaymentPenalty;
    }

    public void setPrepaymentPenalty(String prepaymentPenalty) {
        this.prepaymentPenalty = prepaymentPenalty == null ? null : prepaymentPenalty.trim();
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

    public BigDecimal getPrepayJs() {
        return prepayJs;
    }

    public void setPrepayJs(BigDecimal prepayJs) {
        this.prepayJs = prepayJs;
    }

    public BigDecimal getBzjbl() {
        return bzjbl;
    }

    public void setBzjbl(BigDecimal bzjbl) {
        this.bzjbl = bzjbl;
    }

    public String getCrdCent() {
        return crdCent;
    }

    public void setCrdCent(String crdCent) {
        this.crdCent = crdCent == null ? null : crdCent.trim();
    }

    public String getApplyModeType() {
        return applyModeType;
    }

    public void setApplyModeType(String applyModeType) {
        this.applyModeType = applyModeType == null ? null : applyModeType.trim();
    }

    public String getLowRiskBizType() {
        return lowRiskBizType;
    }

    public void setLowRiskBizType(String lowRiskBizType) {
        this.lowRiskBizType = lowRiskBizType == null ? null : lowRiskBizType.trim();
    }

    public String getAgriculLoans() {
        return agriculLoans;
    }

    public void setAgriculLoans(String agriculLoans) {
        this.agriculLoans = agriculLoans == null ? null : agriculLoans.trim();
    }

    public BigDecimal getConOccupy() {
        return conOccupy;
    }

    public void setConOccupy(BigDecimal conOccupy) {
        this.conOccupy = conOccupy;
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

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus == null ? null : creditStatus.trim();
    }

    public String getJxhjId() {
        return jxhjId;
    }

    public void setJxhjId(String jxhjId) {
        this.jxhjId = jxhjId == null ? null : jxhjId.trim();
    }
}