package com.cdgit.loan.customerManage.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ContractInfo {
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

    private String beginDate;

    private String endDate;

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
    
    //查询字段
    private String bizType;
    
    private BigDecimal bzjje;
    
    private BigDecimal yqts;
    
    private BigDecimal jjyqbj;
    
    private BigDecimal arrearItr;

    
    
    public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public BigDecimal getBzjje() {
		return bzjje;
	}

	public void setBzjje(BigDecimal bzjje) {
		this.bzjje = bzjje;
	}

	public BigDecimal getYqts() {
		return yqts;
	}

	public void setYqts(BigDecimal yqts) {
		this.yqts = yqts;
	}

	public BigDecimal getJjyqbj() {
		return jjyqbj;
	}

	public void setJjyqbj(BigDecimal jjyqbj) {
		this.jjyqbj = jjyqbj;
	}

	public BigDecimal getArrearItr() {
		return arrearItr;
	}

	public void setArrearItr(BigDecimal arrearItr) {
		this.arrearItr = arrearItr;
	}

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

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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
        ContractInfo other = (ContractInfo) that;
        return (this.getContractId() == null ? other.getContractId() == null : this.getContractId().equals(other.getContractId()))
            && (this.getAmountDetailId() == null ? other.getAmountDetailId() == null : this.getAmountDetailId().equals(other.getAmountDetailId()))
            && (this.getContractNum() == null ? other.getContractNum() == null : this.getContractNum().equals(other.getContractNum()))
            && (this.getContractAddress() == null ? other.getContractAddress() == null : this.getContractAddress().equals(other.getContractAddress()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getOldContractId() == null ? other.getOldContractId() == null : this.getOldContractId().equals(other.getOldContractId()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getContractAmt() == null ? other.getContractAmt() == null : this.getContractAmt().equals(other.getContractAmt()))
            && (this.getContractTerm() == null ? other.getContractTerm() == null : this.getContractTerm().equals(other.getContractTerm()))
            && (this.getCycleUnit() == null ? other.getCycleUnit() == null : this.getCycleUnit().equals(other.getCycleUnit()))
            && (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getContractDate() == null ? other.getContractDate() == null : this.getContractDate().equals(other.getContractDate()))
            && (this.getLoanUse() == null ? other.getLoanUse() == null : this.getLoanUse().equals(other.getLoanUse()))
            && (this.getGuarantyType() == null ? other.getGuarantyType() == null : this.getGuarantyType().equals(other.getGuarantyType()))
            && (this.getLoanTurn() == null ? other.getLoanTurn() == null : this.getLoanTurn().equals(other.getLoanTurn()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getConStatus() == null ? other.getConStatus() == null : this.getConStatus().equals(other.getConStatus()))
            && (this.getTrusToPayFlg() == null ? other.getTrusToPayFlg() == null : this.getTrusToPayFlg().equals(other.getTrusToPayFlg()))
            && (this.getStopPayFlg() == null ? other.getStopPayFlg() == null : this.getStopPayFlg().equals(other.getStopPayFlg()))
            && (this.getSpecPaymentDate() == null ? other.getSpecPaymentDate() == null : this.getSpecPaymentDate().equals(other.getSpecPaymentDate()))
            && (this.getExchangeRate() == null ? other.getExchangeRate() == null : this.getExchangeRate().equals(other.getExchangeRate()))
            && (this.getRmbAmt() == null ? other.getRmbAmt() == null : this.getRmbAmt().equals(other.getRmbAmt()))
            && (this.getConBalance() == null ? other.getConBalance() == null : this.getConBalance().equals(other.getConBalance()))
            && (this.getCycleIndCon() == null ? other.getCycleIndCon() == null : this.getCycleIndCon().equals(other.getCycleIndCon()))
            && (this.getRepaymentType() == null ? other.getRepaymentType() == null : this.getRepaymentType().equals(other.getRepaymentType()))
            && (this.getTkDate() == null ? other.getTkDate() == null : this.getTkDate().equals(other.getTkDate()))
            && (this.getHolidayFlg() == null ? other.getHolidayFlg() == null : this.getHolidayFlg().equals(other.getHolidayFlg()))
            && (this.getMainGuarantyType() == null ? other.getMainGuarantyType() == null : this.getMainGuarantyType().equals(other.getMainGuarantyType()))
            && (this.getXyId() == null ? other.getXyId() == null : this.getXyId().equals(other.getXyId()))
            && (this.getPaperConNum() == null ? other.getPaperConNum() == null : this.getPaperConNum().equals(other.getPaperConNum()))
            && (this.getInternalDays() == null ? other.getInternalDays() == null : this.getInternalDays().equals(other.getInternalDays()))
            && (this.getClsResult() == null ? other.getClsResult() == null : this.getClsResult().equals(other.getClsResult()))
            && (this.getIfDataMove() == null ? other.getIfDataMove() == null : this.getIfDataMove().equals(other.getIfDataMove()))
            && (this.getFirstRepayTerm() == null ? other.getFirstRepayTerm() == null : this.getFirstRepayTerm().equals(other.getFirstRepayTerm()))
            && (this.getConYuE() == null ? other.getConYuE() == null : this.getConYuE().equals(other.getConYuE()))
            && (this.getPayWay() == null ? other.getPayWay() == null : this.getPayWay().equals(other.getPayWay()))
            && (this.getPayDepend1() == null ? other.getPayDepend1() == null : this.getPayDepend1().equals(other.getPayDepend1()))
            && (this.getPayDepend2() == null ? other.getPayDepend2() == null : this.getPayDepend2().equals(other.getPayDepend2()))
            && (this.getPayDepend3() == null ? other.getPayDepend3() == null : this.getPayDepend3().equals(other.getPayDepend3()))
            && (this.getPrepaymentPenalty() == null ? other.getPrepaymentPenalty() == null : this.getPrepaymentPenalty().equals(other.getPrepaymentPenalty()))
            && (this.getPrepayMakeupRate() == null ? other.getPrepayMakeupRate() == null : this.getPrepayMakeupRate().equals(other.getPrepayMakeupRate()))
            && (this.getLeastPrepayAmount() == null ? other.getLeastPrepayAmount() == null : this.getLeastPrepayAmount().equals(other.getLeastPrepayAmount()))
            && (this.getPrepayJs() == null ? other.getPrepayJs() == null : this.getPrepayJs().equals(other.getPrepayJs()))
            && (this.getBzjbl() == null ? other.getBzjbl() == null : this.getBzjbl().equals(other.getBzjbl()))
            && (this.getCrdCent() == null ? other.getCrdCent() == null : this.getCrdCent().equals(other.getCrdCent()))
            && (this.getApplyModeType() == null ? other.getApplyModeType() == null : this.getApplyModeType().equals(other.getApplyModeType()))
            && (this.getLowRiskBizType() == null ? other.getLowRiskBizType() == null : this.getLowRiskBizType().equals(other.getLowRiskBizType()))
            && (this.getAgriculLoans() == null ? other.getAgriculLoans() == null : this.getAgriculLoans().equals(other.getAgriculLoans()))
            && (this.getConOccupy() == null ? other.getConOccupy() == null : this.getConOccupy().equals(other.getConOccupy()))
            && (this.getCrdDtlId() == null ? other.getCrdDtlId() == null : this.getCrdDtlId().equals(other.getCrdDtlId()))
            && (this.getCreditMode() == null ? other.getCreditMode() == null : this.getCreditMode().equals(other.getCreditMode()))
            && (this.getCreditStatus() == null ? other.getCreditStatus() == null : this.getCreditStatus().equals(other.getCreditStatus()))
            && (this.getJxhjId() == null ? other.getJxhjId() == null : this.getJxhjId().equals(other.getJxhjId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getContractId() == null) ? 0 : getContractId().hashCode());
        result = prime * result + ((getAmountDetailId() == null) ? 0 : getAmountDetailId().hashCode());
        result = prime * result + ((getContractNum() == null) ? 0 : getContractNum().hashCode());
        result = prime * result + ((getContractAddress() == null) ? 0 : getContractAddress().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getOldContractId() == null) ? 0 : getOldContractId().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getContractAmt() == null) ? 0 : getContractAmt().hashCode());
        result = prime * result + ((getContractTerm() == null) ? 0 : getContractTerm().hashCode());
        result = prime * result + ((getCycleUnit() == null) ? 0 : getCycleUnit().hashCode());
        result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getContractDate() == null) ? 0 : getContractDate().hashCode());
        result = prime * result + ((getLoanUse() == null) ? 0 : getLoanUse().hashCode());
        result = prime * result + ((getGuarantyType() == null) ? 0 : getGuarantyType().hashCode());
        result = prime * result + ((getLoanTurn() == null) ? 0 : getLoanTurn().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getConStatus() == null) ? 0 : getConStatus().hashCode());
        result = prime * result + ((getTrusToPayFlg() == null) ? 0 : getTrusToPayFlg().hashCode());
        result = prime * result + ((getStopPayFlg() == null) ? 0 : getStopPayFlg().hashCode());
        result = prime * result + ((getSpecPaymentDate() == null) ? 0 : getSpecPaymentDate().hashCode());
        result = prime * result + ((getExchangeRate() == null) ? 0 : getExchangeRate().hashCode());
        result = prime * result + ((getRmbAmt() == null) ? 0 : getRmbAmt().hashCode());
        result = prime * result + ((getConBalance() == null) ? 0 : getConBalance().hashCode());
        result = prime * result + ((getCycleIndCon() == null) ? 0 : getCycleIndCon().hashCode());
        result = prime * result + ((getRepaymentType() == null) ? 0 : getRepaymentType().hashCode());
        result = prime * result + ((getTkDate() == null) ? 0 : getTkDate().hashCode());
        result = prime * result + ((getHolidayFlg() == null) ? 0 : getHolidayFlg().hashCode());
        result = prime * result + ((getMainGuarantyType() == null) ? 0 : getMainGuarantyType().hashCode());
        result = prime * result + ((getXyId() == null) ? 0 : getXyId().hashCode());
        result = prime * result + ((getPaperConNum() == null) ? 0 : getPaperConNum().hashCode());
        result = prime * result + ((getInternalDays() == null) ? 0 : getInternalDays().hashCode());
        result = prime * result + ((getClsResult() == null) ? 0 : getClsResult().hashCode());
        result = prime * result + ((getIfDataMove() == null) ? 0 : getIfDataMove().hashCode());
        result = prime * result + ((getFirstRepayTerm() == null) ? 0 : getFirstRepayTerm().hashCode());
        result = prime * result + ((getConYuE() == null) ? 0 : getConYuE().hashCode());
        result = prime * result + ((getPayWay() == null) ? 0 : getPayWay().hashCode());
        result = prime * result + ((getPayDepend1() == null) ? 0 : getPayDepend1().hashCode());
        result = prime * result + ((getPayDepend2() == null) ? 0 : getPayDepend2().hashCode());
        result = prime * result + ((getPayDepend3() == null) ? 0 : getPayDepend3().hashCode());
        result = prime * result + ((getPrepaymentPenalty() == null) ? 0 : getPrepaymentPenalty().hashCode());
        result = prime * result + ((getPrepayMakeupRate() == null) ? 0 : getPrepayMakeupRate().hashCode());
        result = prime * result + ((getLeastPrepayAmount() == null) ? 0 : getLeastPrepayAmount().hashCode());
        result = prime * result + ((getPrepayJs() == null) ? 0 : getPrepayJs().hashCode());
        result = prime * result + ((getBzjbl() == null) ? 0 : getBzjbl().hashCode());
        result = prime * result + ((getCrdCent() == null) ? 0 : getCrdCent().hashCode());
        result = prime * result + ((getApplyModeType() == null) ? 0 : getApplyModeType().hashCode());
        result = prime * result + ((getLowRiskBizType() == null) ? 0 : getLowRiskBizType().hashCode());
        result = prime * result + ((getAgriculLoans() == null) ? 0 : getAgriculLoans().hashCode());
        result = prime * result + ((getConOccupy() == null) ? 0 : getConOccupy().hashCode());
        result = prime * result + ((getCrdDtlId() == null) ? 0 : getCrdDtlId().hashCode());
        result = prime * result + ((getCreditMode() == null) ? 0 : getCreditMode().hashCode());
        result = prime * result + ((getCreditStatus() == null) ? 0 : getCreditStatus().hashCode());
        result = prime * result + ((getJxhjId() == null) ? 0 : getJxhjId().hashCode());
        return result;
    }
}