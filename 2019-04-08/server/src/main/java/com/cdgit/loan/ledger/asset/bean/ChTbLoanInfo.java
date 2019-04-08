package com.cdgit.loan.ledger.asset.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ChTbLoanInfo {
    private String loanId;

    private String contractId;

    private String loanNum;

    private String loanSubject1;

    private BigDecimal loanAmt;

    private String currencyCd;

    private Long loanTerm;

    private String cycleUnit;

    private Date beginDate;

    private Date endDate;

    private String loanOrg;

    private String userNum;

    private String orgNum;

    private Date createTime;

    private Date updateTime;

    private String productType;

    private String partyId;

    private String loanStatus;

    private Short specPaymentDate;

    private String holidayFlg;

    private String holidayItrWay;

    private String counterFlg;

    private String batFlg;

    private String trusToPayFlg;

    private String stopPayFlg;

    private String repayType;

    private String summaryNum;

    private BigDecimal exchangeRate;

    private BigDecimal rmbAmt;

    private String ifDataMove;

    private String firstRepayTerm;

    private Integer hpzs;

    private String hpbh;

    private String pjzl;

    private String drweBnkNm;

    private String drweBnkNo;

    private String drweBnkAdr;

    private Date txzq;

    private BigDecimal comAmt;

    private String term;

    private String unit;

    private String payOutFlag;

    private String orgRcnStan;

    private String midStatus;

    private String rcnStan;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getLoanNum() {
        return loanNum;
    }

    public void setLoanNum(String loanNum) {
        this.loanNum = loanNum == null ? null : loanNum.trim();
    }

    public String getLoanSubject1() {
        return loanSubject1;
    }

    public void setLoanSubject1(String loanSubject1) {
        this.loanSubject1 = loanSubject1 == null ? null : loanSubject1.trim();
    }

    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(BigDecimal loanAmt) {
        this.loanAmt = loanAmt;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public Long getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(Long loanTerm) {
        this.loanTerm = loanTerm;
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

    public String getLoanOrg() {
        return loanOrg;
    }

    public void setLoanOrg(String loanOrg) {
        this.loanOrg = loanOrg == null ? null : loanOrg.trim();
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

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus == null ? null : loanStatus.trim();
    }

    public Short getSpecPaymentDate() {
        return specPaymentDate;
    }

    public void setSpecPaymentDate(Short specPaymentDate) {
        this.specPaymentDate = specPaymentDate;
    }

    public String getHolidayFlg() {
        return holidayFlg;
    }

    public void setHolidayFlg(String holidayFlg) {
        this.holidayFlg = holidayFlg == null ? null : holidayFlg.trim();
    }

    public String getHolidayItrWay() {
        return holidayItrWay;
    }

    public void setHolidayItrWay(String holidayItrWay) {
        this.holidayItrWay = holidayItrWay == null ? null : holidayItrWay.trim();
    }

    public String getCounterFlg() {
        return counterFlg;
    }

    public void setCounterFlg(String counterFlg) {
        this.counterFlg = counterFlg == null ? null : counterFlg.trim();
    }

    public String getBatFlg() {
        return batFlg;
    }

    public void setBatFlg(String batFlg) {
        this.batFlg = batFlg == null ? null : batFlg.trim();
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

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType == null ? null : repayType.trim();
    }

    public String getSummaryNum() {
        return summaryNum;
    }

    public void setSummaryNum(String summaryNum) {
        this.summaryNum = summaryNum == null ? null : summaryNum.trim();
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

    public Integer getHpzs() {
        return hpzs;
    }

    public void setHpzs(Integer hpzs) {
        this.hpzs = hpzs;
    }

    public String getHpbh() {
        return hpbh;
    }

    public void setHpbh(String hpbh) {
        this.hpbh = hpbh == null ? null : hpbh.trim();
    }

    public String getPjzl() {
        return pjzl;
    }

    public void setPjzl(String pjzl) {
        this.pjzl = pjzl == null ? null : pjzl.trim();
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

    public Date getTxzq() {
        return txzq;
    }

    public void setTxzq(Date txzq) {
        this.txzq = txzq;
    }

    public BigDecimal getComAmt() {
        return comAmt;
    }

    public void setComAmt(BigDecimal comAmt) {
        this.comAmt = comAmt;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getPayOutFlag() {
        return payOutFlag;
    }

    public void setPayOutFlag(String payOutFlag) {
        this.payOutFlag = payOutFlag == null ? null : payOutFlag.trim();
    }

    public String getOrgRcnStan() {
        return orgRcnStan;
    }

    public void setOrgRcnStan(String orgRcnStan) {
        this.orgRcnStan = orgRcnStan == null ? null : orgRcnStan.trim();
    }

    public String getMidStatus() {
        return midStatus;
    }

    public void setMidStatus(String midStatus) {
        this.midStatus = midStatus == null ? null : midStatus.trim();
    }

    public String getRcnStan() {
        return rcnStan;
    }

    public void setRcnStan(String rcnStan) {
        this.rcnStan = rcnStan == null ? null : rcnStan.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ChTbLoanInfo other = (ChTbLoanInfo) that;
        return (this.getLoanId() == null ? other.getLoanId() == null : this.getLoanId().equals(other.getLoanId()))
            && (this.getContractId() == null ? other.getContractId() == null : this.getContractId().equals(other.getContractId()))
            && (this.getLoanNum() == null ? other.getLoanNum() == null : this.getLoanNum().equals(other.getLoanNum()))
            && (this.getLoanSubject1() == null ? other.getLoanSubject1() == null : this.getLoanSubject1().equals(other.getLoanSubject1()))
            && (this.getLoanAmt() == null ? other.getLoanAmt() == null : this.getLoanAmt().equals(other.getLoanAmt()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getLoanTerm() == null ? other.getLoanTerm() == null : this.getLoanTerm().equals(other.getLoanTerm()))
            && (this.getCycleUnit() == null ? other.getCycleUnit() == null : this.getCycleUnit().equals(other.getCycleUnit()))
            && (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getLoanOrg() == null ? other.getLoanOrg() == null : this.getLoanOrg().equals(other.getLoanOrg()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getLoanStatus() == null ? other.getLoanStatus() == null : this.getLoanStatus().equals(other.getLoanStatus()))
            && (this.getSpecPaymentDate() == null ? other.getSpecPaymentDate() == null : this.getSpecPaymentDate().equals(other.getSpecPaymentDate()))
            && (this.getHolidayFlg() == null ? other.getHolidayFlg() == null : this.getHolidayFlg().equals(other.getHolidayFlg()))
            && (this.getHolidayItrWay() == null ? other.getHolidayItrWay() == null : this.getHolidayItrWay().equals(other.getHolidayItrWay()))
            && (this.getCounterFlg() == null ? other.getCounterFlg() == null : this.getCounterFlg().equals(other.getCounterFlg()))
            && (this.getBatFlg() == null ? other.getBatFlg() == null : this.getBatFlg().equals(other.getBatFlg()))
            && (this.getTrusToPayFlg() == null ? other.getTrusToPayFlg() == null : this.getTrusToPayFlg().equals(other.getTrusToPayFlg()))
            && (this.getStopPayFlg() == null ? other.getStopPayFlg() == null : this.getStopPayFlg().equals(other.getStopPayFlg()))
            && (this.getRepayType() == null ? other.getRepayType() == null : this.getRepayType().equals(other.getRepayType()))
            && (this.getSummaryNum() == null ? other.getSummaryNum() == null : this.getSummaryNum().equals(other.getSummaryNum()))
            && (this.getExchangeRate() == null ? other.getExchangeRate() == null : this.getExchangeRate().equals(other.getExchangeRate()))
            && (this.getRmbAmt() == null ? other.getRmbAmt() == null : this.getRmbAmt().equals(other.getRmbAmt()))
            && (this.getIfDataMove() == null ? other.getIfDataMove() == null : this.getIfDataMove().equals(other.getIfDataMove()))
            && (this.getFirstRepayTerm() == null ? other.getFirstRepayTerm() == null : this.getFirstRepayTerm().equals(other.getFirstRepayTerm()))
            && (this.getHpzs() == null ? other.getHpzs() == null : this.getHpzs().equals(other.getHpzs()))
            && (this.getHpbh() == null ? other.getHpbh() == null : this.getHpbh().equals(other.getHpbh()))
            && (this.getPjzl() == null ? other.getPjzl() == null : this.getPjzl().equals(other.getPjzl()))
            && (this.getDrweBnkNm() == null ? other.getDrweBnkNm() == null : this.getDrweBnkNm().equals(other.getDrweBnkNm()))
            && (this.getDrweBnkNo() == null ? other.getDrweBnkNo() == null : this.getDrweBnkNo().equals(other.getDrweBnkNo()))
            && (this.getDrweBnkAdr() == null ? other.getDrweBnkAdr() == null : this.getDrweBnkAdr().equals(other.getDrweBnkAdr()))
            && (this.getTxzq() == null ? other.getTxzq() == null : this.getTxzq().equals(other.getTxzq()))
            && (this.getComAmt() == null ? other.getComAmt() == null : this.getComAmt().equals(other.getComAmt()))
            && (this.getTerm() == null ? other.getTerm() == null : this.getTerm().equals(other.getTerm()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getPayOutFlag() == null ? other.getPayOutFlag() == null : this.getPayOutFlag().equals(other.getPayOutFlag()))
            && (this.getOrgRcnStan() == null ? other.getOrgRcnStan() == null : this.getOrgRcnStan().equals(other.getOrgRcnStan()))
            && (this.getMidStatus() == null ? other.getMidStatus() == null : this.getMidStatus().equals(other.getMidStatus()))
            && (this.getRcnStan() == null ? other.getRcnStan() == null : this.getRcnStan().equals(other.getRcnStan()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLoanId() == null) ? 0 : getLoanId().hashCode());
        result = prime * result + ((getContractId() == null) ? 0 : getContractId().hashCode());
        result = prime * result + ((getLoanNum() == null) ? 0 : getLoanNum().hashCode());
        result = prime * result + ((getLoanSubject1() == null) ? 0 : getLoanSubject1().hashCode());
        result = prime * result + ((getLoanAmt() == null) ? 0 : getLoanAmt().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getLoanTerm() == null) ? 0 : getLoanTerm().hashCode());
        result = prime * result + ((getCycleUnit() == null) ? 0 : getCycleUnit().hashCode());
        result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getLoanOrg() == null) ? 0 : getLoanOrg().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getLoanStatus() == null) ? 0 : getLoanStatus().hashCode());
        result = prime * result + ((getSpecPaymentDate() == null) ? 0 : getSpecPaymentDate().hashCode());
        result = prime * result + ((getHolidayFlg() == null) ? 0 : getHolidayFlg().hashCode());
        result = prime * result + ((getHolidayItrWay() == null) ? 0 : getHolidayItrWay().hashCode());
        result = prime * result + ((getCounterFlg() == null) ? 0 : getCounterFlg().hashCode());
        result = prime * result + ((getBatFlg() == null) ? 0 : getBatFlg().hashCode());
        result = prime * result + ((getTrusToPayFlg() == null) ? 0 : getTrusToPayFlg().hashCode());
        result = prime * result + ((getStopPayFlg() == null) ? 0 : getStopPayFlg().hashCode());
        result = prime * result + ((getRepayType() == null) ? 0 : getRepayType().hashCode());
        result = prime * result + ((getSummaryNum() == null) ? 0 : getSummaryNum().hashCode());
        result = prime * result + ((getExchangeRate() == null) ? 0 : getExchangeRate().hashCode());
        result = prime * result + ((getRmbAmt() == null) ? 0 : getRmbAmt().hashCode());
        result = prime * result + ((getIfDataMove() == null) ? 0 : getIfDataMove().hashCode());
        result = prime * result + ((getFirstRepayTerm() == null) ? 0 : getFirstRepayTerm().hashCode());
        result = prime * result + ((getHpzs() == null) ? 0 : getHpzs().hashCode());
        result = prime * result + ((getHpbh() == null) ? 0 : getHpbh().hashCode());
        result = prime * result + ((getPjzl() == null) ? 0 : getPjzl().hashCode());
        result = prime * result + ((getDrweBnkNm() == null) ? 0 : getDrweBnkNm().hashCode());
        result = prime * result + ((getDrweBnkNo() == null) ? 0 : getDrweBnkNo().hashCode());
        result = prime * result + ((getDrweBnkAdr() == null) ? 0 : getDrweBnkAdr().hashCode());
        result = prime * result + ((getTxzq() == null) ? 0 : getTxzq().hashCode());
        result = prime * result + ((getComAmt() == null) ? 0 : getComAmt().hashCode());
        result = prime * result + ((getTerm() == null) ? 0 : getTerm().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getPayOutFlag() == null) ? 0 : getPayOutFlag().hashCode());
        result = prime * result + ((getOrgRcnStan() == null) ? 0 : getOrgRcnStan().hashCode());
        result = prime * result + ((getMidStatus() == null) ? 0 : getMidStatus().hashCode());
        result = prime * result + ((getRcnStan() == null) ? 0 : getRcnStan().hashCode());
        return result;
    }
}