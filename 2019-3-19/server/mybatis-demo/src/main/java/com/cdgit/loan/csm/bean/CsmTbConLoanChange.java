package com.cdgit.loan.csm.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbConLoanChange {
    private String changeId;

    private String contractId;

    private String summaryId;

    private String partyId;

    private String conChangeType;

    private String loanChangeType;

    private String changeReason;

    private Date changeDate;

    private String changeStatus;

    private String userNum;

    private String orgNum;

    private String oldRateType;

    private String oldFloatType;

    private String oldFloatWay;

    private BigDecimal oldBaseRateValue;

    private BigDecimal oldRateFloatProportion;

    private BigDecimal oldYearRate;

    private String oldIrUpdateFrequency;

    private String oldInterestCollectType;

    private String newRateType;

    private String newFloatType;

    private String newFloatWay;

    private BigDecimal newBaseRateValue;

    private BigDecimal newRateFloatProportion;

    private BigDecimal newYearRate;

    private String newIrUpdateFrequency;

    private String newInterestCollectType;

    private Integer oldTerm;

    private Date oldEndDate;

    private String termChangeWay;

    private Integer newTerm;

    private Date newEndDate;

    private String oldRepayWay;

    private String newRepayWay;

    private Short oldRepayDay;

    private Short newRepayDay;

    private String oldRepayAccount;

    private String newRepayAccount;

    private String oldGuarantyType;

    private String newGuarantyType;

    private String isSettle;

    private BigDecimal repayAmt;

    private BigDecimal repayCapital;

    private String dealWay;

    private String isModifyPlan;

    private BigDecimal oldSummaryamt;

    private BigDecimal newSummaryamt;

    private BigDecimal oldRateUp;

    private BigDecimal newRateUp;

    private BigDecimal oldRateDown;

    private BigDecimal newRateDown;

    private String isSmall;

    private String repayType;

    private BigDecimal yhzclx;

    private BigDecimal yhtqlx;

    private BigDecimal yhfx;

    private String oldTiexiStatus;

    private String newTiexiStatus;

    private String oldTingxiStatus;

    private String newTingxiStatus;

    private String repayOrder;

    private String changeNum;

    private String stopRateType;

    private BigDecimal stopZcRate;

    private BigDecimal stopTqRate;

    private BigDecimal stopFx;

    private BigDecimal stopZcRateOut;

    private BigDecimal stopTqRateOut;

    private BigDecimal stopFxOut;

    private String oldZhmc;

    private String oldKzbs;

    private String oldZhkhjg;

    private String oldZhbs;

    private String newZhmc;

    private String newKzbs;

    private String newZhkhjg;

    private String newZhbs;

    private Integer firstPeriods;

    private BigDecimal yhbj;

    private BigDecimal yhze;

    private String newWtrhbzh;

    private String newWtrhxzh;

    private String wtrnm;

    private String hzsnm;

    private String hzszh;

    private String adjItrFlg;

    private BigDecimal norItrIn;

    private BigDecimal dftItrIn;

    private BigDecimal pnsItrIn;

    private BigDecimal norOtdItr;

    private BigDecimal pnsOtdItr;

    private BigDecimal beNorItrIn;

    private BigDecimal beDftItrIn;

    private BigDecimal bePnsItrIn;

    private BigDecimal beNorOtdItr;

    private BigDecimal bePnsOtdItr;

    private String oldWtrhbzh;

    private String oldWtrhxzh;

    private BigDecimal norItrOut;

    private BigDecimal dftItrOut;

    private BigDecimal pnsItrOut;

    private BigDecimal cpdItrOut;

    private BigDecimal beNorItrOut;

    private BigDecimal beDftItrOut;

    private BigDecimal bePnsItrOut;

    private BigDecimal beCpdItrOut;

    private BigDecimal cpdItrIn;

    private BigDecimal beCpdItrIn;

    private BigDecimal otdCpd;

    private BigDecimal beOtdCpd;

    private BigDecimal otdItrIn;

    private BigDecimal beOtdItrIn;

    private BigDecimal stopFl;

    private BigDecimal oldOverdueRate;

    private BigDecimal newOverdueRate;

    private BigDecimal oldBzjblbdy;

    private BigDecimal newBzjblbdy;

    private BigDecimal oldBzjje;

    private BigDecimal newBzjje;

    private Date oldXyzDqrq;

    private Date newXyzDqrq;

    private Date oldBhDqrq;

    private Date newBhDqrq;

    private BigDecimal oldBhBzjblbdy;

    private BigDecimal newBhBzjblbdy;

    private BigDecimal oldBhBzjje;

    private BigDecimal newBhBzjje;

    private String oldXyzJyq;

    private String newXyzJyq;

    private String oldXyzYqts;

    private String newXyzYqts;

    private String oldBhBhlx;

    private String newBhBhlx;

    private String gjFlowNo;

    private BigDecimal yhfl;

    private BigDecimal oldKzje;

    private BigDecimal newKzje;

    private String periodNum;

    private String periodState;

    private BigDecimal shbj;

    private BigDecimal shzclx;

    private BigDecimal shtqlx;

    private BigDecimal shfx;

    private BigDecimal shfl;

    private BigDecimal adjOtdPns;

    private BigDecimal adjOtdCpd;

    private BigDecimal padUpAdjOtdItr;

    private BigDecimal padUpAdjOtdPns;

    private BigDecimal padUpAdjOtdCpd;

    private BigDecimal padUpAdjOtdItrPre;

    private String oldSecondRepayAccount;

    private String oldSecondZhmc;

    private String oldSecondKzbs;

    private String oldSecondZhkhjg;

    private String oldSecondZhbs;

    private String newSecondRepayAccount;

    private String newSecondZhmc;

    private String newSecondKzbs;

    private String newSecondZhkhjg;

    private String newSecondZhbs;

    private String oldThirdRepayAccount;

    private String oldThirdZhmc;

    private String oldThirdKzbs;

    private String oldThirdZhkhjg;

    private String oldThirdZhbs;

    private String newThirdRepayAccount;

    private String newThirdZhmc;

    private String newThirdKzbs;

    private String newThirdZhkhjg;

    private String newThirdZhbs;

    private String isCredit;

    public String getChangeId() {
        return changeId;
    }

    public void setChangeId(String changeId) {
        this.changeId = changeId == null ? null : changeId.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(String summaryId) {
        this.summaryId = summaryId == null ? null : summaryId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getConChangeType() {
        return conChangeType;
    }

    public void setConChangeType(String conChangeType) {
        this.conChangeType = conChangeType == null ? null : conChangeType.trim();
    }

    public String getLoanChangeType() {
        return loanChangeType;
    }

    public void setLoanChangeType(String loanChangeType) {
        this.loanChangeType = loanChangeType == null ? null : loanChangeType.trim();
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason == null ? null : changeReason.trim();
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getChangeStatus() {
        return changeStatus;
    }

    public void setChangeStatus(String changeStatus) {
        this.changeStatus = changeStatus == null ? null : changeStatus.trim();
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

    public String getOldRateType() {
        return oldRateType;
    }

    public void setOldRateType(String oldRateType) {
        this.oldRateType = oldRateType == null ? null : oldRateType.trim();
    }

    public String getOldFloatType() {
        return oldFloatType;
    }

    public void setOldFloatType(String oldFloatType) {
        this.oldFloatType = oldFloatType == null ? null : oldFloatType.trim();
    }

    public String getOldFloatWay() {
        return oldFloatWay;
    }

    public void setOldFloatWay(String oldFloatWay) {
        this.oldFloatWay = oldFloatWay == null ? null : oldFloatWay.trim();
    }

    public BigDecimal getOldBaseRateValue() {
        return oldBaseRateValue;
    }

    public void setOldBaseRateValue(BigDecimal oldBaseRateValue) {
        this.oldBaseRateValue = oldBaseRateValue;
    }

    public BigDecimal getOldRateFloatProportion() {
        return oldRateFloatProportion;
    }

    public void setOldRateFloatProportion(BigDecimal oldRateFloatProportion) {
        this.oldRateFloatProportion = oldRateFloatProportion;
    }

    public BigDecimal getOldYearRate() {
        return oldYearRate;
    }

    public void setOldYearRate(BigDecimal oldYearRate) {
        this.oldYearRate = oldYearRate;
    }

    public String getOldIrUpdateFrequency() {
        return oldIrUpdateFrequency;
    }

    public void setOldIrUpdateFrequency(String oldIrUpdateFrequency) {
        this.oldIrUpdateFrequency = oldIrUpdateFrequency == null ? null : oldIrUpdateFrequency.trim();
    }

    public String getOldInterestCollectType() {
        return oldInterestCollectType;
    }

    public void setOldInterestCollectType(String oldInterestCollectType) {
        this.oldInterestCollectType = oldInterestCollectType == null ? null : oldInterestCollectType.trim();
    }

    public String getNewRateType() {
        return newRateType;
    }

    public void setNewRateType(String newRateType) {
        this.newRateType = newRateType == null ? null : newRateType.trim();
    }

    public String getNewFloatType() {
        return newFloatType;
    }

    public void setNewFloatType(String newFloatType) {
        this.newFloatType = newFloatType == null ? null : newFloatType.trim();
    }

    public String getNewFloatWay() {
        return newFloatWay;
    }

    public void setNewFloatWay(String newFloatWay) {
        this.newFloatWay = newFloatWay == null ? null : newFloatWay.trim();
    }

    public BigDecimal getNewBaseRateValue() {
        return newBaseRateValue;
    }

    public void setNewBaseRateValue(BigDecimal newBaseRateValue) {
        this.newBaseRateValue = newBaseRateValue;
    }

    public BigDecimal getNewRateFloatProportion() {
        return newRateFloatProportion;
    }

    public void setNewRateFloatProportion(BigDecimal newRateFloatProportion) {
        this.newRateFloatProportion = newRateFloatProportion;
    }

    public BigDecimal getNewYearRate() {
        return newYearRate;
    }

    public void setNewYearRate(BigDecimal newYearRate) {
        this.newYearRate = newYearRate;
    }

    public String getNewIrUpdateFrequency() {
        return newIrUpdateFrequency;
    }

    public void setNewIrUpdateFrequency(String newIrUpdateFrequency) {
        this.newIrUpdateFrequency = newIrUpdateFrequency == null ? null : newIrUpdateFrequency.trim();
    }

    public String getNewInterestCollectType() {
        return newInterestCollectType;
    }

    public void setNewInterestCollectType(String newInterestCollectType) {
        this.newInterestCollectType = newInterestCollectType == null ? null : newInterestCollectType.trim();
    }

    public Integer getOldTerm() {
        return oldTerm;
    }

    public void setOldTerm(Integer oldTerm) {
        this.oldTerm = oldTerm;
    }

    public Date getOldEndDate() {
        return oldEndDate;
    }

    public void setOldEndDate(Date oldEndDate) {
        this.oldEndDate = oldEndDate;
    }

    public String getTermChangeWay() {
        return termChangeWay;
    }

    public void setTermChangeWay(String termChangeWay) {
        this.termChangeWay = termChangeWay == null ? null : termChangeWay.trim();
    }

    public Integer getNewTerm() {
        return newTerm;
    }

    public void setNewTerm(Integer newTerm) {
        this.newTerm = newTerm;
    }

    public Date getNewEndDate() {
        return newEndDate;
    }

    public void setNewEndDate(Date newEndDate) {
        this.newEndDate = newEndDate;
    }

    public String getOldRepayWay() {
        return oldRepayWay;
    }

    public void setOldRepayWay(String oldRepayWay) {
        this.oldRepayWay = oldRepayWay == null ? null : oldRepayWay.trim();
    }

    public String getNewRepayWay() {
        return newRepayWay;
    }

    public void setNewRepayWay(String newRepayWay) {
        this.newRepayWay = newRepayWay == null ? null : newRepayWay.trim();
    }

    public Short getOldRepayDay() {
        return oldRepayDay;
    }

    public void setOldRepayDay(Short oldRepayDay) {
        this.oldRepayDay = oldRepayDay;
    }

    public Short getNewRepayDay() {
        return newRepayDay;
    }

    public void setNewRepayDay(Short newRepayDay) {
        this.newRepayDay = newRepayDay;
    }

    public String getOldRepayAccount() {
        return oldRepayAccount;
    }

    public void setOldRepayAccount(String oldRepayAccount) {
        this.oldRepayAccount = oldRepayAccount == null ? null : oldRepayAccount.trim();
    }

    public String getNewRepayAccount() {
        return newRepayAccount;
    }

    public void setNewRepayAccount(String newRepayAccount) {
        this.newRepayAccount = newRepayAccount == null ? null : newRepayAccount.trim();
    }

    public String getOldGuarantyType() {
        return oldGuarantyType;
    }

    public void setOldGuarantyType(String oldGuarantyType) {
        this.oldGuarantyType = oldGuarantyType == null ? null : oldGuarantyType.trim();
    }

    public String getNewGuarantyType() {
        return newGuarantyType;
    }

    public void setNewGuarantyType(String newGuarantyType) {
        this.newGuarantyType = newGuarantyType == null ? null : newGuarantyType.trim();
    }

    public String getIsSettle() {
        return isSettle;
    }

    public void setIsSettle(String isSettle) {
        this.isSettle = isSettle == null ? null : isSettle.trim();
    }

    public BigDecimal getRepayAmt() {
        return repayAmt;
    }

    public void setRepayAmt(BigDecimal repayAmt) {
        this.repayAmt = repayAmt;
    }

    public BigDecimal getRepayCapital() {
        return repayCapital;
    }

    public void setRepayCapital(BigDecimal repayCapital) {
        this.repayCapital = repayCapital;
    }

    public String getDealWay() {
        return dealWay;
    }

    public void setDealWay(String dealWay) {
        this.dealWay = dealWay == null ? null : dealWay.trim();
    }

    public String getIsModifyPlan() {
        return isModifyPlan;
    }

    public void setIsModifyPlan(String isModifyPlan) {
        this.isModifyPlan = isModifyPlan == null ? null : isModifyPlan.trim();
    }

    public BigDecimal getOldSummaryamt() {
        return oldSummaryamt;
    }

    public void setOldSummaryamt(BigDecimal oldSummaryamt) {
        this.oldSummaryamt = oldSummaryamt;
    }

    public BigDecimal getNewSummaryamt() {
        return newSummaryamt;
    }

    public void setNewSummaryamt(BigDecimal newSummaryamt) {
        this.newSummaryamt = newSummaryamt;
    }

    public BigDecimal getOldRateUp() {
        return oldRateUp;
    }

    public void setOldRateUp(BigDecimal oldRateUp) {
        this.oldRateUp = oldRateUp;
    }

    public BigDecimal getNewRateUp() {
        return newRateUp;
    }

    public void setNewRateUp(BigDecimal newRateUp) {
        this.newRateUp = newRateUp;
    }

    public BigDecimal getOldRateDown() {
        return oldRateDown;
    }

    public void setOldRateDown(BigDecimal oldRateDown) {
        this.oldRateDown = oldRateDown;
    }

    public BigDecimal getNewRateDown() {
        return newRateDown;
    }

    public void setNewRateDown(BigDecimal newRateDown) {
        this.newRateDown = newRateDown;
    }

    public String getIsSmall() {
        return isSmall;
    }

    public void setIsSmall(String isSmall) {
        this.isSmall = isSmall == null ? null : isSmall.trim();
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType == null ? null : repayType.trim();
    }

    public BigDecimal getYhzclx() {
        return yhzclx;
    }

    public void setYhzclx(BigDecimal yhzclx) {
        this.yhzclx = yhzclx;
    }

    public BigDecimal getYhtqlx() {
        return yhtqlx;
    }

    public void setYhtqlx(BigDecimal yhtqlx) {
        this.yhtqlx = yhtqlx;
    }

    public BigDecimal getYhfx() {
        return yhfx;
    }

    public void setYhfx(BigDecimal yhfx) {
        this.yhfx = yhfx;
    }

    public String getOldTiexiStatus() {
        return oldTiexiStatus;
    }

    public void setOldTiexiStatus(String oldTiexiStatus) {
        this.oldTiexiStatus = oldTiexiStatus == null ? null : oldTiexiStatus.trim();
    }

    public String getNewTiexiStatus() {
        return newTiexiStatus;
    }

    public void setNewTiexiStatus(String newTiexiStatus) {
        this.newTiexiStatus = newTiexiStatus == null ? null : newTiexiStatus.trim();
    }

    public String getOldTingxiStatus() {
        return oldTingxiStatus;
    }

    public void setOldTingxiStatus(String oldTingxiStatus) {
        this.oldTingxiStatus = oldTingxiStatus == null ? null : oldTingxiStatus.trim();
    }

    public String getNewTingxiStatus() {
        return newTingxiStatus;
    }

    public void setNewTingxiStatus(String newTingxiStatus) {
        this.newTingxiStatus = newTingxiStatus == null ? null : newTingxiStatus.trim();
    }

    public String getRepayOrder() {
        return repayOrder;
    }

    public void setRepayOrder(String repayOrder) {
        this.repayOrder = repayOrder == null ? null : repayOrder.trim();
    }

    public String getChangeNum() {
        return changeNum;
    }

    public void setChangeNum(String changeNum) {
        this.changeNum = changeNum == null ? null : changeNum.trim();
    }

    public String getStopRateType() {
        return stopRateType;
    }

    public void setStopRateType(String stopRateType) {
        this.stopRateType = stopRateType == null ? null : stopRateType.trim();
    }

    public BigDecimal getStopZcRate() {
        return stopZcRate;
    }

    public void setStopZcRate(BigDecimal stopZcRate) {
        this.stopZcRate = stopZcRate;
    }

    public BigDecimal getStopTqRate() {
        return stopTqRate;
    }

    public void setStopTqRate(BigDecimal stopTqRate) {
        this.stopTqRate = stopTqRate;
    }

    public BigDecimal getStopFx() {
        return stopFx;
    }

    public void setStopFx(BigDecimal stopFx) {
        this.stopFx = stopFx;
    }

    public BigDecimal getStopZcRateOut() {
        return stopZcRateOut;
    }

    public void setStopZcRateOut(BigDecimal stopZcRateOut) {
        this.stopZcRateOut = stopZcRateOut;
    }

    public BigDecimal getStopTqRateOut() {
        return stopTqRateOut;
    }

    public void setStopTqRateOut(BigDecimal stopTqRateOut) {
        this.stopTqRateOut = stopTqRateOut;
    }

    public BigDecimal getStopFxOut() {
        return stopFxOut;
    }

    public void setStopFxOut(BigDecimal stopFxOut) {
        this.stopFxOut = stopFxOut;
    }

    public String getOldZhmc() {
        return oldZhmc;
    }

    public void setOldZhmc(String oldZhmc) {
        this.oldZhmc = oldZhmc == null ? null : oldZhmc.trim();
    }

    public String getOldKzbs() {
        return oldKzbs;
    }

    public void setOldKzbs(String oldKzbs) {
        this.oldKzbs = oldKzbs == null ? null : oldKzbs.trim();
    }

    public String getOldZhkhjg() {
        return oldZhkhjg;
    }

    public void setOldZhkhjg(String oldZhkhjg) {
        this.oldZhkhjg = oldZhkhjg == null ? null : oldZhkhjg.trim();
    }

    public String getOldZhbs() {
        return oldZhbs;
    }

    public void setOldZhbs(String oldZhbs) {
        this.oldZhbs = oldZhbs == null ? null : oldZhbs.trim();
    }

    public String getNewZhmc() {
        return newZhmc;
    }

    public void setNewZhmc(String newZhmc) {
        this.newZhmc = newZhmc == null ? null : newZhmc.trim();
    }

    public String getNewKzbs() {
        return newKzbs;
    }

    public void setNewKzbs(String newKzbs) {
        this.newKzbs = newKzbs == null ? null : newKzbs.trim();
    }

    public String getNewZhkhjg() {
        return newZhkhjg;
    }

    public void setNewZhkhjg(String newZhkhjg) {
        this.newZhkhjg = newZhkhjg == null ? null : newZhkhjg.trim();
    }

    public String getNewZhbs() {
        return newZhbs;
    }

    public void setNewZhbs(String newZhbs) {
        this.newZhbs = newZhbs == null ? null : newZhbs.trim();
    }

    public Integer getFirstPeriods() {
        return firstPeriods;
    }

    public void setFirstPeriods(Integer firstPeriods) {
        this.firstPeriods = firstPeriods;
    }

    public BigDecimal getYhbj() {
        return yhbj;
    }

    public void setYhbj(BigDecimal yhbj) {
        this.yhbj = yhbj;
    }

    public BigDecimal getYhze() {
        return yhze;
    }

    public void setYhze(BigDecimal yhze) {
        this.yhze = yhze;
    }

    public String getNewWtrhbzh() {
        return newWtrhbzh;
    }

    public void setNewWtrhbzh(String newWtrhbzh) {
        this.newWtrhbzh = newWtrhbzh == null ? null : newWtrhbzh.trim();
    }

    public String getNewWtrhxzh() {
        return newWtrhxzh;
    }

    public void setNewWtrhxzh(String newWtrhxzh) {
        this.newWtrhxzh = newWtrhxzh == null ? null : newWtrhxzh.trim();
    }

    public String getWtrnm() {
        return wtrnm;
    }

    public void setWtrnm(String wtrnm) {
        this.wtrnm = wtrnm == null ? null : wtrnm.trim();
    }

    public String getHzsnm() {
        return hzsnm;
    }

    public void setHzsnm(String hzsnm) {
        this.hzsnm = hzsnm == null ? null : hzsnm.trim();
    }

    public String getHzszh() {
        return hzszh;
    }

    public void setHzszh(String hzszh) {
        this.hzszh = hzszh == null ? null : hzszh.trim();
    }

    public String getAdjItrFlg() {
        return adjItrFlg;
    }

    public void setAdjItrFlg(String adjItrFlg) {
        this.adjItrFlg = adjItrFlg == null ? null : adjItrFlg.trim();
    }

    public BigDecimal getNorItrIn() {
        return norItrIn;
    }

    public void setNorItrIn(BigDecimal norItrIn) {
        this.norItrIn = norItrIn;
    }

    public BigDecimal getDftItrIn() {
        return dftItrIn;
    }

    public void setDftItrIn(BigDecimal dftItrIn) {
        this.dftItrIn = dftItrIn;
    }

    public BigDecimal getPnsItrIn() {
        return pnsItrIn;
    }

    public void setPnsItrIn(BigDecimal pnsItrIn) {
        this.pnsItrIn = pnsItrIn;
    }

    public BigDecimal getNorOtdItr() {
        return norOtdItr;
    }

    public void setNorOtdItr(BigDecimal norOtdItr) {
        this.norOtdItr = norOtdItr;
    }

    public BigDecimal getPnsOtdItr() {
        return pnsOtdItr;
    }

    public void setPnsOtdItr(BigDecimal pnsOtdItr) {
        this.pnsOtdItr = pnsOtdItr;
    }

    public BigDecimal getBeNorItrIn() {
        return beNorItrIn;
    }

    public void setBeNorItrIn(BigDecimal beNorItrIn) {
        this.beNorItrIn = beNorItrIn;
    }

    public BigDecimal getBeDftItrIn() {
        return beDftItrIn;
    }

    public void setBeDftItrIn(BigDecimal beDftItrIn) {
        this.beDftItrIn = beDftItrIn;
    }

    public BigDecimal getBePnsItrIn() {
        return bePnsItrIn;
    }

    public void setBePnsItrIn(BigDecimal bePnsItrIn) {
        this.bePnsItrIn = bePnsItrIn;
    }

    public BigDecimal getBeNorOtdItr() {
        return beNorOtdItr;
    }

    public void setBeNorOtdItr(BigDecimal beNorOtdItr) {
        this.beNorOtdItr = beNorOtdItr;
    }

    public BigDecimal getBePnsOtdItr() {
        return bePnsOtdItr;
    }

    public void setBePnsOtdItr(BigDecimal bePnsOtdItr) {
        this.bePnsOtdItr = bePnsOtdItr;
    }

    public String getOldWtrhbzh() {
        return oldWtrhbzh;
    }

    public void setOldWtrhbzh(String oldWtrhbzh) {
        this.oldWtrhbzh = oldWtrhbzh == null ? null : oldWtrhbzh.trim();
    }

    public String getOldWtrhxzh() {
        return oldWtrhxzh;
    }

    public void setOldWtrhxzh(String oldWtrhxzh) {
        this.oldWtrhxzh = oldWtrhxzh == null ? null : oldWtrhxzh.trim();
    }

    public BigDecimal getNorItrOut() {
        return norItrOut;
    }

    public void setNorItrOut(BigDecimal norItrOut) {
        this.norItrOut = norItrOut;
    }

    public BigDecimal getDftItrOut() {
        return dftItrOut;
    }

    public void setDftItrOut(BigDecimal dftItrOut) {
        this.dftItrOut = dftItrOut;
    }

    public BigDecimal getPnsItrOut() {
        return pnsItrOut;
    }

    public void setPnsItrOut(BigDecimal pnsItrOut) {
        this.pnsItrOut = pnsItrOut;
    }

    public BigDecimal getCpdItrOut() {
        return cpdItrOut;
    }

    public void setCpdItrOut(BigDecimal cpdItrOut) {
        this.cpdItrOut = cpdItrOut;
    }

    public BigDecimal getBeNorItrOut() {
        return beNorItrOut;
    }

    public void setBeNorItrOut(BigDecimal beNorItrOut) {
        this.beNorItrOut = beNorItrOut;
    }

    public BigDecimal getBeDftItrOut() {
        return beDftItrOut;
    }

    public void setBeDftItrOut(BigDecimal beDftItrOut) {
        this.beDftItrOut = beDftItrOut;
    }

    public BigDecimal getBePnsItrOut() {
        return bePnsItrOut;
    }

    public void setBePnsItrOut(BigDecimal bePnsItrOut) {
        this.bePnsItrOut = bePnsItrOut;
    }

    public BigDecimal getBeCpdItrOut() {
        return beCpdItrOut;
    }

    public void setBeCpdItrOut(BigDecimal beCpdItrOut) {
        this.beCpdItrOut = beCpdItrOut;
    }

    public BigDecimal getCpdItrIn() {
        return cpdItrIn;
    }

    public void setCpdItrIn(BigDecimal cpdItrIn) {
        this.cpdItrIn = cpdItrIn;
    }

    public BigDecimal getBeCpdItrIn() {
        return beCpdItrIn;
    }

    public void setBeCpdItrIn(BigDecimal beCpdItrIn) {
        this.beCpdItrIn = beCpdItrIn;
    }

    public BigDecimal getOtdCpd() {
        return otdCpd;
    }

    public void setOtdCpd(BigDecimal otdCpd) {
        this.otdCpd = otdCpd;
    }

    public BigDecimal getBeOtdCpd() {
        return beOtdCpd;
    }

    public void setBeOtdCpd(BigDecimal beOtdCpd) {
        this.beOtdCpd = beOtdCpd;
    }

    public BigDecimal getOtdItrIn() {
        return otdItrIn;
    }

    public void setOtdItrIn(BigDecimal otdItrIn) {
        this.otdItrIn = otdItrIn;
    }

    public BigDecimal getBeOtdItrIn() {
        return beOtdItrIn;
    }

    public void setBeOtdItrIn(BigDecimal beOtdItrIn) {
        this.beOtdItrIn = beOtdItrIn;
    }

    public BigDecimal getStopFl() {
        return stopFl;
    }

    public void setStopFl(BigDecimal stopFl) {
        this.stopFl = stopFl;
    }

    public BigDecimal getOldOverdueRate() {
        return oldOverdueRate;
    }

    public void setOldOverdueRate(BigDecimal oldOverdueRate) {
        this.oldOverdueRate = oldOverdueRate;
    }

    public BigDecimal getNewOverdueRate() {
        return newOverdueRate;
    }

    public void setNewOverdueRate(BigDecimal newOverdueRate) {
        this.newOverdueRate = newOverdueRate;
    }

    public BigDecimal getOldBzjblbdy() {
        return oldBzjblbdy;
    }

    public void setOldBzjblbdy(BigDecimal oldBzjblbdy) {
        this.oldBzjblbdy = oldBzjblbdy;
    }

    public BigDecimal getNewBzjblbdy() {
        return newBzjblbdy;
    }

    public void setNewBzjblbdy(BigDecimal newBzjblbdy) {
        this.newBzjblbdy = newBzjblbdy;
    }

    public BigDecimal getOldBzjje() {
        return oldBzjje;
    }

    public void setOldBzjje(BigDecimal oldBzjje) {
        this.oldBzjje = oldBzjje;
    }

    public BigDecimal getNewBzjje() {
        return newBzjje;
    }

    public void setNewBzjje(BigDecimal newBzjje) {
        this.newBzjje = newBzjje;
    }

    public Date getOldXyzDqrq() {
        return oldXyzDqrq;
    }

    public void setOldXyzDqrq(Date oldXyzDqrq) {
        this.oldXyzDqrq = oldXyzDqrq;
    }

    public Date getNewXyzDqrq() {
        return newXyzDqrq;
    }

    public void setNewXyzDqrq(Date newXyzDqrq) {
        this.newXyzDqrq = newXyzDqrq;
    }

    public Date getOldBhDqrq() {
        return oldBhDqrq;
    }

    public void setOldBhDqrq(Date oldBhDqrq) {
        this.oldBhDqrq = oldBhDqrq;
    }

    public Date getNewBhDqrq() {
        return newBhDqrq;
    }

    public void setNewBhDqrq(Date newBhDqrq) {
        this.newBhDqrq = newBhDqrq;
    }

    public BigDecimal getOldBhBzjblbdy() {
        return oldBhBzjblbdy;
    }

    public void setOldBhBzjblbdy(BigDecimal oldBhBzjblbdy) {
        this.oldBhBzjblbdy = oldBhBzjblbdy;
    }

    public BigDecimal getNewBhBzjblbdy() {
        return newBhBzjblbdy;
    }

    public void setNewBhBzjblbdy(BigDecimal newBhBzjblbdy) {
        this.newBhBzjblbdy = newBhBzjblbdy;
    }

    public BigDecimal getOldBhBzjje() {
        return oldBhBzjje;
    }

    public void setOldBhBzjje(BigDecimal oldBhBzjje) {
        this.oldBhBzjje = oldBhBzjje;
    }

    public BigDecimal getNewBhBzjje() {
        return newBhBzjje;
    }

    public void setNewBhBzjje(BigDecimal newBhBzjje) {
        this.newBhBzjje = newBhBzjje;
    }

    public String getOldXyzJyq() {
        return oldXyzJyq;
    }

    public void setOldXyzJyq(String oldXyzJyq) {
        this.oldXyzJyq = oldXyzJyq == null ? null : oldXyzJyq.trim();
    }

    public String getNewXyzJyq() {
        return newXyzJyq;
    }

    public void setNewXyzJyq(String newXyzJyq) {
        this.newXyzJyq = newXyzJyq == null ? null : newXyzJyq.trim();
    }

    public String getOldXyzYqts() {
        return oldXyzYqts;
    }

    public void setOldXyzYqts(String oldXyzYqts) {
        this.oldXyzYqts = oldXyzYqts == null ? null : oldXyzYqts.trim();
    }

    public String getNewXyzYqts() {
        return newXyzYqts;
    }

    public void setNewXyzYqts(String newXyzYqts) {
        this.newXyzYqts = newXyzYqts == null ? null : newXyzYqts.trim();
    }

    public String getOldBhBhlx() {
        return oldBhBhlx;
    }

    public void setOldBhBhlx(String oldBhBhlx) {
        this.oldBhBhlx = oldBhBhlx == null ? null : oldBhBhlx.trim();
    }

    public String getNewBhBhlx() {
        return newBhBhlx;
    }

    public void setNewBhBhlx(String newBhBhlx) {
        this.newBhBhlx = newBhBhlx == null ? null : newBhBhlx.trim();
    }

    public String getGjFlowNo() {
        return gjFlowNo;
    }

    public void setGjFlowNo(String gjFlowNo) {
        this.gjFlowNo = gjFlowNo == null ? null : gjFlowNo.trim();
    }

    public BigDecimal getYhfl() {
        return yhfl;
    }

    public void setYhfl(BigDecimal yhfl) {
        this.yhfl = yhfl;
    }

    public BigDecimal getOldKzje() {
        return oldKzje;
    }

    public void setOldKzje(BigDecimal oldKzje) {
        this.oldKzje = oldKzje;
    }

    public BigDecimal getNewKzje() {
        return newKzje;
    }

    public void setNewKzje(BigDecimal newKzje) {
        this.newKzje = newKzje;
    }

    public String getPeriodNum() {
        return periodNum;
    }

    public void setPeriodNum(String periodNum) {
        this.periodNum = periodNum == null ? null : periodNum.trim();
    }

    public String getPeriodState() {
        return periodState;
    }

    public void setPeriodState(String periodState) {
        this.periodState = periodState == null ? null : periodState.trim();
    }

    public BigDecimal getShbj() {
        return shbj;
    }

    public void setShbj(BigDecimal shbj) {
        this.shbj = shbj;
    }

    public BigDecimal getShzclx() {
        return shzclx;
    }

    public void setShzclx(BigDecimal shzclx) {
        this.shzclx = shzclx;
    }

    public BigDecimal getShtqlx() {
        return shtqlx;
    }

    public void setShtqlx(BigDecimal shtqlx) {
        this.shtqlx = shtqlx;
    }

    public BigDecimal getShfx() {
        return shfx;
    }

    public void setShfx(BigDecimal shfx) {
        this.shfx = shfx;
    }

    public BigDecimal getShfl() {
        return shfl;
    }

    public void setShfl(BigDecimal shfl) {
        this.shfl = shfl;
    }

    public BigDecimal getAdjOtdPns() {
        return adjOtdPns;
    }

    public void setAdjOtdPns(BigDecimal adjOtdPns) {
        this.adjOtdPns = adjOtdPns;
    }

    public BigDecimal getAdjOtdCpd() {
        return adjOtdCpd;
    }

    public void setAdjOtdCpd(BigDecimal adjOtdCpd) {
        this.adjOtdCpd = adjOtdCpd;
    }

    public BigDecimal getPadUpAdjOtdItr() {
        return padUpAdjOtdItr;
    }

    public void setPadUpAdjOtdItr(BigDecimal padUpAdjOtdItr) {
        this.padUpAdjOtdItr = padUpAdjOtdItr;
    }

    public BigDecimal getPadUpAdjOtdPns() {
        return padUpAdjOtdPns;
    }

    public void setPadUpAdjOtdPns(BigDecimal padUpAdjOtdPns) {
        this.padUpAdjOtdPns = padUpAdjOtdPns;
    }

    public BigDecimal getPadUpAdjOtdCpd() {
        return padUpAdjOtdCpd;
    }

    public void setPadUpAdjOtdCpd(BigDecimal padUpAdjOtdCpd) {
        this.padUpAdjOtdCpd = padUpAdjOtdCpd;
    }

    public BigDecimal getPadUpAdjOtdItrPre() {
        return padUpAdjOtdItrPre;
    }

    public void setPadUpAdjOtdItrPre(BigDecimal padUpAdjOtdItrPre) {
        this.padUpAdjOtdItrPre = padUpAdjOtdItrPre;
    }

    public String getOldSecondRepayAccount() {
        return oldSecondRepayAccount;
    }

    public void setOldSecondRepayAccount(String oldSecondRepayAccount) {
        this.oldSecondRepayAccount = oldSecondRepayAccount == null ? null : oldSecondRepayAccount.trim();
    }

    public String getOldSecondZhmc() {
        return oldSecondZhmc;
    }

    public void setOldSecondZhmc(String oldSecondZhmc) {
        this.oldSecondZhmc = oldSecondZhmc == null ? null : oldSecondZhmc.trim();
    }

    public String getOldSecondKzbs() {
        return oldSecondKzbs;
    }

    public void setOldSecondKzbs(String oldSecondKzbs) {
        this.oldSecondKzbs = oldSecondKzbs == null ? null : oldSecondKzbs.trim();
    }

    public String getOldSecondZhkhjg() {
        return oldSecondZhkhjg;
    }

    public void setOldSecondZhkhjg(String oldSecondZhkhjg) {
        this.oldSecondZhkhjg = oldSecondZhkhjg == null ? null : oldSecondZhkhjg.trim();
    }

    public String getOldSecondZhbs() {
        return oldSecondZhbs;
    }

    public void setOldSecondZhbs(String oldSecondZhbs) {
        this.oldSecondZhbs = oldSecondZhbs == null ? null : oldSecondZhbs.trim();
    }

    public String getNewSecondRepayAccount() {
        return newSecondRepayAccount;
    }

    public void setNewSecondRepayAccount(String newSecondRepayAccount) {
        this.newSecondRepayAccount = newSecondRepayAccount == null ? null : newSecondRepayAccount.trim();
    }

    public String getNewSecondZhmc() {
        return newSecondZhmc;
    }

    public void setNewSecondZhmc(String newSecondZhmc) {
        this.newSecondZhmc = newSecondZhmc == null ? null : newSecondZhmc.trim();
    }

    public String getNewSecondKzbs() {
        return newSecondKzbs;
    }

    public void setNewSecondKzbs(String newSecondKzbs) {
        this.newSecondKzbs = newSecondKzbs == null ? null : newSecondKzbs.trim();
    }

    public String getNewSecondZhkhjg() {
        return newSecondZhkhjg;
    }

    public void setNewSecondZhkhjg(String newSecondZhkhjg) {
        this.newSecondZhkhjg = newSecondZhkhjg == null ? null : newSecondZhkhjg.trim();
    }

    public String getNewSecondZhbs() {
        return newSecondZhbs;
    }

    public void setNewSecondZhbs(String newSecondZhbs) {
        this.newSecondZhbs = newSecondZhbs == null ? null : newSecondZhbs.trim();
    }

    public String getOldThirdRepayAccount() {
        return oldThirdRepayAccount;
    }

    public void setOldThirdRepayAccount(String oldThirdRepayAccount) {
        this.oldThirdRepayAccount = oldThirdRepayAccount == null ? null : oldThirdRepayAccount.trim();
    }

    public String getOldThirdZhmc() {
        return oldThirdZhmc;
    }

    public void setOldThirdZhmc(String oldThirdZhmc) {
        this.oldThirdZhmc = oldThirdZhmc == null ? null : oldThirdZhmc.trim();
    }

    public String getOldThirdKzbs() {
        return oldThirdKzbs;
    }

    public void setOldThirdKzbs(String oldThirdKzbs) {
        this.oldThirdKzbs = oldThirdKzbs == null ? null : oldThirdKzbs.trim();
    }

    public String getOldThirdZhkhjg() {
        return oldThirdZhkhjg;
    }

    public void setOldThirdZhkhjg(String oldThirdZhkhjg) {
        this.oldThirdZhkhjg = oldThirdZhkhjg == null ? null : oldThirdZhkhjg.trim();
    }

    public String getOldThirdZhbs() {
        return oldThirdZhbs;
    }

    public void setOldThirdZhbs(String oldThirdZhbs) {
        this.oldThirdZhbs = oldThirdZhbs == null ? null : oldThirdZhbs.trim();
    }

    public String getNewThirdRepayAccount() {
        return newThirdRepayAccount;
    }

    public void setNewThirdRepayAccount(String newThirdRepayAccount) {
        this.newThirdRepayAccount = newThirdRepayAccount == null ? null : newThirdRepayAccount.trim();
    }

    public String getNewThirdZhmc() {
        return newThirdZhmc;
    }

    public void setNewThirdZhmc(String newThirdZhmc) {
        this.newThirdZhmc = newThirdZhmc == null ? null : newThirdZhmc.trim();
    }

    public String getNewThirdKzbs() {
        return newThirdKzbs;
    }

    public void setNewThirdKzbs(String newThirdKzbs) {
        this.newThirdKzbs = newThirdKzbs == null ? null : newThirdKzbs.trim();
    }

    public String getNewThirdZhkhjg() {
        return newThirdZhkhjg;
    }

    public void setNewThirdZhkhjg(String newThirdZhkhjg) {
        this.newThirdZhkhjg = newThirdZhkhjg == null ? null : newThirdZhkhjg.trim();
    }

    public String getNewThirdZhbs() {
        return newThirdZhbs;
    }

    public void setNewThirdZhbs(String newThirdZhbs) {
        this.newThirdZhbs = newThirdZhbs == null ? null : newThirdZhbs.trim();
    }

    public String getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(String isCredit) {
        this.isCredit = isCredit == null ? null : isCredit.trim();
    }
}