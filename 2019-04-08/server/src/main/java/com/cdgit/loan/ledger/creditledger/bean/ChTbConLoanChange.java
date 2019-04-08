package com.cdgit.loan.ledger.creditledger.bean ;

import java.math.BigDecimal;
import java.util.Date;

public class ChTbConLoanChange {
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
        ChTbConLoanChange other = (ChTbConLoanChange) that;
        return (this.getChangeId() == null ? other.getChangeId() == null : this.getChangeId().equals(other.getChangeId()))
            && (this.getContractId() == null ? other.getContractId() == null : this.getContractId().equals(other.getContractId()))
            && (this.getSummaryId() == null ? other.getSummaryId() == null : this.getSummaryId().equals(other.getSummaryId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getConChangeType() == null ? other.getConChangeType() == null : this.getConChangeType().equals(other.getConChangeType()))
            && (this.getLoanChangeType() == null ? other.getLoanChangeType() == null : this.getLoanChangeType().equals(other.getLoanChangeType()))
            && (this.getChangeReason() == null ? other.getChangeReason() == null : this.getChangeReason().equals(other.getChangeReason()))
            && (this.getChangeDate() == null ? other.getChangeDate() == null : this.getChangeDate().equals(other.getChangeDate()))
            && (this.getChangeStatus() == null ? other.getChangeStatus() == null : this.getChangeStatus().equals(other.getChangeStatus()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getOldRateType() == null ? other.getOldRateType() == null : this.getOldRateType().equals(other.getOldRateType()))
            && (this.getOldFloatType() == null ? other.getOldFloatType() == null : this.getOldFloatType().equals(other.getOldFloatType()))
            && (this.getOldFloatWay() == null ? other.getOldFloatWay() == null : this.getOldFloatWay().equals(other.getOldFloatWay()))
            && (this.getOldBaseRateValue() == null ? other.getOldBaseRateValue() == null : this.getOldBaseRateValue().equals(other.getOldBaseRateValue()))
            && (this.getOldRateFloatProportion() == null ? other.getOldRateFloatProportion() == null : this.getOldRateFloatProportion().equals(other.getOldRateFloatProportion()))
            && (this.getOldYearRate() == null ? other.getOldYearRate() == null : this.getOldYearRate().equals(other.getOldYearRate()))
            && (this.getOldIrUpdateFrequency() == null ? other.getOldIrUpdateFrequency() == null : this.getOldIrUpdateFrequency().equals(other.getOldIrUpdateFrequency()))
            && (this.getOldInterestCollectType() == null ? other.getOldInterestCollectType() == null : this.getOldInterestCollectType().equals(other.getOldInterestCollectType()))
            && (this.getNewRateType() == null ? other.getNewRateType() == null : this.getNewRateType().equals(other.getNewRateType()))
            && (this.getNewFloatType() == null ? other.getNewFloatType() == null : this.getNewFloatType().equals(other.getNewFloatType()))
            && (this.getNewFloatWay() == null ? other.getNewFloatWay() == null : this.getNewFloatWay().equals(other.getNewFloatWay()))
            && (this.getNewBaseRateValue() == null ? other.getNewBaseRateValue() == null : this.getNewBaseRateValue().equals(other.getNewBaseRateValue()))
            && (this.getNewRateFloatProportion() == null ? other.getNewRateFloatProportion() == null : this.getNewRateFloatProportion().equals(other.getNewRateFloatProportion()))
            && (this.getNewYearRate() == null ? other.getNewYearRate() == null : this.getNewYearRate().equals(other.getNewYearRate()))
            && (this.getNewIrUpdateFrequency() == null ? other.getNewIrUpdateFrequency() == null : this.getNewIrUpdateFrequency().equals(other.getNewIrUpdateFrequency()))
            && (this.getNewInterestCollectType() == null ? other.getNewInterestCollectType() == null : this.getNewInterestCollectType().equals(other.getNewInterestCollectType()))
            && (this.getOldTerm() == null ? other.getOldTerm() == null : this.getOldTerm().equals(other.getOldTerm()))
            && (this.getOldEndDate() == null ? other.getOldEndDate() == null : this.getOldEndDate().equals(other.getOldEndDate()))
            && (this.getTermChangeWay() == null ? other.getTermChangeWay() == null : this.getTermChangeWay().equals(other.getTermChangeWay()))
            && (this.getNewTerm() == null ? other.getNewTerm() == null : this.getNewTerm().equals(other.getNewTerm()))
            && (this.getNewEndDate() == null ? other.getNewEndDate() == null : this.getNewEndDate().equals(other.getNewEndDate()))
            && (this.getOldRepayWay() == null ? other.getOldRepayWay() == null : this.getOldRepayWay().equals(other.getOldRepayWay()))
            && (this.getNewRepayWay() == null ? other.getNewRepayWay() == null : this.getNewRepayWay().equals(other.getNewRepayWay()))
            && (this.getOldRepayDay() == null ? other.getOldRepayDay() == null : this.getOldRepayDay().equals(other.getOldRepayDay()))
            && (this.getNewRepayDay() == null ? other.getNewRepayDay() == null : this.getNewRepayDay().equals(other.getNewRepayDay()))
            && (this.getOldRepayAccount() == null ? other.getOldRepayAccount() == null : this.getOldRepayAccount().equals(other.getOldRepayAccount()))
            && (this.getNewRepayAccount() == null ? other.getNewRepayAccount() == null : this.getNewRepayAccount().equals(other.getNewRepayAccount()))
            && (this.getOldGuarantyType() == null ? other.getOldGuarantyType() == null : this.getOldGuarantyType().equals(other.getOldGuarantyType()))
            && (this.getNewGuarantyType() == null ? other.getNewGuarantyType() == null : this.getNewGuarantyType().equals(other.getNewGuarantyType()))
            && (this.getIsSettle() == null ? other.getIsSettle() == null : this.getIsSettle().equals(other.getIsSettle()))
            && (this.getRepayAmt() == null ? other.getRepayAmt() == null : this.getRepayAmt().equals(other.getRepayAmt()))
            && (this.getRepayCapital() == null ? other.getRepayCapital() == null : this.getRepayCapital().equals(other.getRepayCapital()))
            && (this.getDealWay() == null ? other.getDealWay() == null : this.getDealWay().equals(other.getDealWay()))
            && (this.getIsModifyPlan() == null ? other.getIsModifyPlan() == null : this.getIsModifyPlan().equals(other.getIsModifyPlan()))
            && (this.getOldSummaryamt() == null ? other.getOldSummaryamt() == null : this.getOldSummaryamt().equals(other.getOldSummaryamt()))
            && (this.getNewSummaryamt() == null ? other.getNewSummaryamt() == null : this.getNewSummaryamt().equals(other.getNewSummaryamt()))
            && (this.getOldRateUp() == null ? other.getOldRateUp() == null : this.getOldRateUp().equals(other.getOldRateUp()))
            && (this.getNewRateUp() == null ? other.getNewRateUp() == null : this.getNewRateUp().equals(other.getNewRateUp()))
            && (this.getOldRateDown() == null ? other.getOldRateDown() == null : this.getOldRateDown().equals(other.getOldRateDown()))
            && (this.getNewRateDown() == null ? other.getNewRateDown() == null : this.getNewRateDown().equals(other.getNewRateDown()))
            && (this.getIsSmall() == null ? other.getIsSmall() == null : this.getIsSmall().equals(other.getIsSmall()))
            && (this.getRepayType() == null ? other.getRepayType() == null : this.getRepayType().equals(other.getRepayType()))
            && (this.getYhzclx() == null ? other.getYhzclx() == null : this.getYhzclx().equals(other.getYhzclx()))
            && (this.getYhtqlx() == null ? other.getYhtqlx() == null : this.getYhtqlx().equals(other.getYhtqlx()))
            && (this.getYhfx() == null ? other.getYhfx() == null : this.getYhfx().equals(other.getYhfx()))
            && (this.getOldTiexiStatus() == null ? other.getOldTiexiStatus() == null : this.getOldTiexiStatus().equals(other.getOldTiexiStatus()))
            && (this.getNewTiexiStatus() == null ? other.getNewTiexiStatus() == null : this.getNewTiexiStatus().equals(other.getNewTiexiStatus()))
            && (this.getOldTingxiStatus() == null ? other.getOldTingxiStatus() == null : this.getOldTingxiStatus().equals(other.getOldTingxiStatus()))
            && (this.getNewTingxiStatus() == null ? other.getNewTingxiStatus() == null : this.getNewTingxiStatus().equals(other.getNewTingxiStatus()))
            && (this.getRepayOrder() == null ? other.getRepayOrder() == null : this.getRepayOrder().equals(other.getRepayOrder()))
            && (this.getChangeNum() == null ? other.getChangeNum() == null : this.getChangeNum().equals(other.getChangeNum()))
            && (this.getStopRateType() == null ? other.getStopRateType() == null : this.getStopRateType().equals(other.getStopRateType()))
            && (this.getStopZcRate() == null ? other.getStopZcRate() == null : this.getStopZcRate().equals(other.getStopZcRate()))
            && (this.getStopTqRate() == null ? other.getStopTqRate() == null : this.getStopTqRate().equals(other.getStopTqRate()))
            && (this.getStopFx() == null ? other.getStopFx() == null : this.getStopFx().equals(other.getStopFx()))
            && (this.getStopZcRateOut() == null ? other.getStopZcRateOut() == null : this.getStopZcRateOut().equals(other.getStopZcRateOut()))
            && (this.getStopTqRateOut() == null ? other.getStopTqRateOut() == null : this.getStopTqRateOut().equals(other.getStopTqRateOut()))
            && (this.getStopFxOut() == null ? other.getStopFxOut() == null : this.getStopFxOut().equals(other.getStopFxOut()))
            && (this.getOldZhmc() == null ? other.getOldZhmc() == null : this.getOldZhmc().equals(other.getOldZhmc()))
            && (this.getOldKzbs() == null ? other.getOldKzbs() == null : this.getOldKzbs().equals(other.getOldKzbs()))
            && (this.getOldZhkhjg() == null ? other.getOldZhkhjg() == null : this.getOldZhkhjg().equals(other.getOldZhkhjg()))
            && (this.getOldZhbs() == null ? other.getOldZhbs() == null : this.getOldZhbs().equals(other.getOldZhbs()))
            && (this.getNewZhmc() == null ? other.getNewZhmc() == null : this.getNewZhmc().equals(other.getNewZhmc()))
            && (this.getNewKzbs() == null ? other.getNewKzbs() == null : this.getNewKzbs().equals(other.getNewKzbs()))
            && (this.getNewZhkhjg() == null ? other.getNewZhkhjg() == null : this.getNewZhkhjg().equals(other.getNewZhkhjg()))
            && (this.getNewZhbs() == null ? other.getNewZhbs() == null : this.getNewZhbs().equals(other.getNewZhbs()))
            && (this.getFirstPeriods() == null ? other.getFirstPeriods() == null : this.getFirstPeriods().equals(other.getFirstPeriods()))
            && (this.getYhbj() == null ? other.getYhbj() == null : this.getYhbj().equals(other.getYhbj()))
            && (this.getYhze() == null ? other.getYhze() == null : this.getYhze().equals(other.getYhze()))
            && (this.getNewWtrhbzh() == null ? other.getNewWtrhbzh() == null : this.getNewWtrhbzh().equals(other.getNewWtrhbzh()))
            && (this.getNewWtrhxzh() == null ? other.getNewWtrhxzh() == null : this.getNewWtrhxzh().equals(other.getNewWtrhxzh()))
            && (this.getWtrnm() == null ? other.getWtrnm() == null : this.getWtrnm().equals(other.getWtrnm()))
            && (this.getHzsnm() == null ? other.getHzsnm() == null : this.getHzsnm().equals(other.getHzsnm()))
            && (this.getHzszh() == null ? other.getHzszh() == null : this.getHzszh().equals(other.getHzszh()))
            && (this.getAdjItrFlg() == null ? other.getAdjItrFlg() == null : this.getAdjItrFlg().equals(other.getAdjItrFlg()))
            && (this.getNorItrIn() == null ? other.getNorItrIn() == null : this.getNorItrIn().equals(other.getNorItrIn()))
            && (this.getDftItrIn() == null ? other.getDftItrIn() == null : this.getDftItrIn().equals(other.getDftItrIn()))
            && (this.getPnsItrIn() == null ? other.getPnsItrIn() == null : this.getPnsItrIn().equals(other.getPnsItrIn()))
            && (this.getNorOtdItr() == null ? other.getNorOtdItr() == null : this.getNorOtdItr().equals(other.getNorOtdItr()))
            && (this.getPnsOtdItr() == null ? other.getPnsOtdItr() == null : this.getPnsOtdItr().equals(other.getPnsOtdItr()))
            && (this.getBeNorItrIn() == null ? other.getBeNorItrIn() == null : this.getBeNorItrIn().equals(other.getBeNorItrIn()))
            && (this.getBeDftItrIn() == null ? other.getBeDftItrIn() == null : this.getBeDftItrIn().equals(other.getBeDftItrIn()))
            && (this.getBePnsItrIn() == null ? other.getBePnsItrIn() == null : this.getBePnsItrIn().equals(other.getBePnsItrIn()))
            && (this.getBeNorOtdItr() == null ? other.getBeNorOtdItr() == null : this.getBeNorOtdItr().equals(other.getBeNorOtdItr()))
            && (this.getBePnsOtdItr() == null ? other.getBePnsOtdItr() == null : this.getBePnsOtdItr().equals(other.getBePnsOtdItr()))
            && (this.getOldWtrhbzh() == null ? other.getOldWtrhbzh() == null : this.getOldWtrhbzh().equals(other.getOldWtrhbzh()))
            && (this.getOldWtrhxzh() == null ? other.getOldWtrhxzh() == null : this.getOldWtrhxzh().equals(other.getOldWtrhxzh()))
            && (this.getNorItrOut() == null ? other.getNorItrOut() == null : this.getNorItrOut().equals(other.getNorItrOut()))
            && (this.getDftItrOut() == null ? other.getDftItrOut() == null : this.getDftItrOut().equals(other.getDftItrOut()))
            && (this.getPnsItrOut() == null ? other.getPnsItrOut() == null : this.getPnsItrOut().equals(other.getPnsItrOut()))
            && (this.getCpdItrOut() == null ? other.getCpdItrOut() == null : this.getCpdItrOut().equals(other.getCpdItrOut()))
            && (this.getBeNorItrOut() == null ? other.getBeNorItrOut() == null : this.getBeNorItrOut().equals(other.getBeNorItrOut()))
            && (this.getBeDftItrOut() == null ? other.getBeDftItrOut() == null : this.getBeDftItrOut().equals(other.getBeDftItrOut()))
            && (this.getBePnsItrOut() == null ? other.getBePnsItrOut() == null : this.getBePnsItrOut().equals(other.getBePnsItrOut()))
            && (this.getBeCpdItrOut() == null ? other.getBeCpdItrOut() == null : this.getBeCpdItrOut().equals(other.getBeCpdItrOut()))
            && (this.getCpdItrIn() == null ? other.getCpdItrIn() == null : this.getCpdItrIn().equals(other.getCpdItrIn()))
            && (this.getBeCpdItrIn() == null ? other.getBeCpdItrIn() == null : this.getBeCpdItrIn().equals(other.getBeCpdItrIn()))
            && (this.getOtdCpd() == null ? other.getOtdCpd() == null : this.getOtdCpd().equals(other.getOtdCpd()))
            && (this.getBeOtdCpd() == null ? other.getBeOtdCpd() == null : this.getBeOtdCpd().equals(other.getBeOtdCpd()))
            && (this.getOtdItrIn() == null ? other.getOtdItrIn() == null : this.getOtdItrIn().equals(other.getOtdItrIn()))
            && (this.getBeOtdItrIn() == null ? other.getBeOtdItrIn() == null : this.getBeOtdItrIn().equals(other.getBeOtdItrIn()))
            && (this.getStopFl() == null ? other.getStopFl() == null : this.getStopFl().equals(other.getStopFl()))
            && (this.getOldOverdueRate() == null ? other.getOldOverdueRate() == null : this.getOldOverdueRate().equals(other.getOldOverdueRate()))
            && (this.getNewOverdueRate() == null ? other.getNewOverdueRate() == null : this.getNewOverdueRate().equals(other.getNewOverdueRate()))
            && (this.getOldBzjblbdy() == null ? other.getOldBzjblbdy() == null : this.getOldBzjblbdy().equals(other.getOldBzjblbdy()))
            && (this.getNewBzjblbdy() == null ? other.getNewBzjblbdy() == null : this.getNewBzjblbdy().equals(other.getNewBzjblbdy()))
            && (this.getOldBzjje() == null ? other.getOldBzjje() == null : this.getOldBzjje().equals(other.getOldBzjje()))
            && (this.getNewBzjje() == null ? other.getNewBzjje() == null : this.getNewBzjje().equals(other.getNewBzjje()))
            && (this.getOldXyzDqrq() == null ? other.getOldXyzDqrq() == null : this.getOldXyzDqrq().equals(other.getOldXyzDqrq()))
            && (this.getNewXyzDqrq() == null ? other.getNewXyzDqrq() == null : this.getNewXyzDqrq().equals(other.getNewXyzDqrq()))
            && (this.getOldBhDqrq() == null ? other.getOldBhDqrq() == null : this.getOldBhDqrq().equals(other.getOldBhDqrq()))
            && (this.getNewBhDqrq() == null ? other.getNewBhDqrq() == null : this.getNewBhDqrq().equals(other.getNewBhDqrq()))
            && (this.getOldBhBzjblbdy() == null ? other.getOldBhBzjblbdy() == null : this.getOldBhBzjblbdy().equals(other.getOldBhBzjblbdy()))
            && (this.getNewBhBzjblbdy() == null ? other.getNewBhBzjblbdy() == null : this.getNewBhBzjblbdy().equals(other.getNewBhBzjblbdy()))
            && (this.getOldBhBzjje() == null ? other.getOldBhBzjje() == null : this.getOldBhBzjje().equals(other.getOldBhBzjje()))
            && (this.getNewBhBzjje() == null ? other.getNewBhBzjje() == null : this.getNewBhBzjje().equals(other.getNewBhBzjje()))
            && (this.getOldXyzJyq() == null ? other.getOldXyzJyq() == null : this.getOldXyzJyq().equals(other.getOldXyzJyq()))
            && (this.getNewXyzJyq() == null ? other.getNewXyzJyq() == null : this.getNewXyzJyq().equals(other.getNewXyzJyq()))
            && (this.getOldXyzYqts() == null ? other.getOldXyzYqts() == null : this.getOldXyzYqts().equals(other.getOldXyzYqts()))
            && (this.getNewXyzYqts() == null ? other.getNewXyzYqts() == null : this.getNewXyzYqts().equals(other.getNewXyzYqts()))
            && (this.getOldBhBhlx() == null ? other.getOldBhBhlx() == null : this.getOldBhBhlx().equals(other.getOldBhBhlx()))
            && (this.getNewBhBhlx() == null ? other.getNewBhBhlx() == null : this.getNewBhBhlx().equals(other.getNewBhBhlx()))
            && (this.getGjFlowNo() == null ? other.getGjFlowNo() == null : this.getGjFlowNo().equals(other.getGjFlowNo()))
            && (this.getYhfl() == null ? other.getYhfl() == null : this.getYhfl().equals(other.getYhfl()))
            && (this.getOldKzje() == null ? other.getOldKzje() == null : this.getOldKzje().equals(other.getOldKzje()))
            && (this.getNewKzje() == null ? other.getNewKzje() == null : this.getNewKzje().equals(other.getNewKzje()))
            && (this.getPeriodNum() == null ? other.getPeriodNum() == null : this.getPeriodNum().equals(other.getPeriodNum()))
            && (this.getPeriodState() == null ? other.getPeriodState() == null : this.getPeriodState().equals(other.getPeriodState()))
            && (this.getShbj() == null ? other.getShbj() == null : this.getShbj().equals(other.getShbj()))
            && (this.getShzclx() == null ? other.getShzclx() == null : this.getShzclx().equals(other.getShzclx()))
            && (this.getShtqlx() == null ? other.getShtqlx() == null : this.getShtqlx().equals(other.getShtqlx()))
            && (this.getShfx() == null ? other.getShfx() == null : this.getShfx().equals(other.getShfx()))
            && (this.getShfl() == null ? other.getShfl() == null : this.getShfl().equals(other.getShfl()))
            && (this.getAdjOtdPns() == null ? other.getAdjOtdPns() == null : this.getAdjOtdPns().equals(other.getAdjOtdPns()))
            && (this.getAdjOtdCpd() == null ? other.getAdjOtdCpd() == null : this.getAdjOtdCpd().equals(other.getAdjOtdCpd()))
            && (this.getPadUpAdjOtdItr() == null ? other.getPadUpAdjOtdItr() == null : this.getPadUpAdjOtdItr().equals(other.getPadUpAdjOtdItr()))
            && (this.getPadUpAdjOtdPns() == null ? other.getPadUpAdjOtdPns() == null : this.getPadUpAdjOtdPns().equals(other.getPadUpAdjOtdPns()))
            && (this.getPadUpAdjOtdCpd() == null ? other.getPadUpAdjOtdCpd() == null : this.getPadUpAdjOtdCpd().equals(other.getPadUpAdjOtdCpd()))
            && (this.getPadUpAdjOtdItrPre() == null ? other.getPadUpAdjOtdItrPre() == null : this.getPadUpAdjOtdItrPre().equals(other.getPadUpAdjOtdItrPre()))
            && (this.getOldSecondRepayAccount() == null ? other.getOldSecondRepayAccount() == null : this.getOldSecondRepayAccount().equals(other.getOldSecondRepayAccount()))
            && (this.getOldSecondZhmc() == null ? other.getOldSecondZhmc() == null : this.getOldSecondZhmc().equals(other.getOldSecondZhmc()))
            && (this.getOldSecondKzbs() == null ? other.getOldSecondKzbs() == null : this.getOldSecondKzbs().equals(other.getOldSecondKzbs()))
            && (this.getOldSecondZhkhjg() == null ? other.getOldSecondZhkhjg() == null : this.getOldSecondZhkhjg().equals(other.getOldSecondZhkhjg()))
            && (this.getOldSecondZhbs() == null ? other.getOldSecondZhbs() == null : this.getOldSecondZhbs().equals(other.getOldSecondZhbs()))
            && (this.getNewSecondRepayAccount() == null ? other.getNewSecondRepayAccount() == null : this.getNewSecondRepayAccount().equals(other.getNewSecondRepayAccount()))
            && (this.getNewSecondZhmc() == null ? other.getNewSecondZhmc() == null : this.getNewSecondZhmc().equals(other.getNewSecondZhmc()))
            && (this.getNewSecondKzbs() == null ? other.getNewSecondKzbs() == null : this.getNewSecondKzbs().equals(other.getNewSecondKzbs()))
            && (this.getNewSecondZhkhjg() == null ? other.getNewSecondZhkhjg() == null : this.getNewSecondZhkhjg().equals(other.getNewSecondZhkhjg()))
            && (this.getNewSecondZhbs() == null ? other.getNewSecondZhbs() == null : this.getNewSecondZhbs().equals(other.getNewSecondZhbs()))
            && (this.getOldThirdRepayAccount() == null ? other.getOldThirdRepayAccount() == null : this.getOldThirdRepayAccount().equals(other.getOldThirdRepayAccount()))
            && (this.getOldThirdZhmc() == null ? other.getOldThirdZhmc() == null : this.getOldThirdZhmc().equals(other.getOldThirdZhmc()))
            && (this.getOldThirdKzbs() == null ? other.getOldThirdKzbs() == null : this.getOldThirdKzbs().equals(other.getOldThirdKzbs()))
            && (this.getOldThirdZhkhjg() == null ? other.getOldThirdZhkhjg() == null : this.getOldThirdZhkhjg().equals(other.getOldThirdZhkhjg()))
            && (this.getOldThirdZhbs() == null ? other.getOldThirdZhbs() == null : this.getOldThirdZhbs().equals(other.getOldThirdZhbs()))
            && (this.getNewThirdRepayAccount() == null ? other.getNewThirdRepayAccount() == null : this.getNewThirdRepayAccount().equals(other.getNewThirdRepayAccount()))
            && (this.getNewThirdZhmc() == null ? other.getNewThirdZhmc() == null : this.getNewThirdZhmc().equals(other.getNewThirdZhmc()))
            && (this.getNewThirdKzbs() == null ? other.getNewThirdKzbs() == null : this.getNewThirdKzbs().equals(other.getNewThirdKzbs()))
            && (this.getNewThirdZhkhjg() == null ? other.getNewThirdZhkhjg() == null : this.getNewThirdZhkhjg().equals(other.getNewThirdZhkhjg()))
            && (this.getNewThirdZhbs() == null ? other.getNewThirdZhbs() == null : this.getNewThirdZhbs().equals(other.getNewThirdZhbs()))
            && (this.getIsCredit() == null ? other.getIsCredit() == null : this.getIsCredit().equals(other.getIsCredit()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChangeId() == null) ? 0 : getChangeId().hashCode());
        result = prime * result + ((getContractId() == null) ? 0 : getContractId().hashCode());
        result = prime * result + ((getSummaryId() == null) ? 0 : getSummaryId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getConChangeType() == null) ? 0 : getConChangeType().hashCode());
        result = prime * result + ((getLoanChangeType() == null) ? 0 : getLoanChangeType().hashCode());
        result = prime * result + ((getChangeReason() == null) ? 0 : getChangeReason().hashCode());
        result = prime * result + ((getChangeDate() == null) ? 0 : getChangeDate().hashCode());
        result = prime * result + ((getChangeStatus() == null) ? 0 : getChangeStatus().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getOldRateType() == null) ? 0 : getOldRateType().hashCode());
        result = prime * result + ((getOldFloatType() == null) ? 0 : getOldFloatType().hashCode());
        result = prime * result + ((getOldFloatWay() == null) ? 0 : getOldFloatWay().hashCode());
        result = prime * result + ((getOldBaseRateValue() == null) ? 0 : getOldBaseRateValue().hashCode());
        result = prime * result + ((getOldRateFloatProportion() == null) ? 0 : getOldRateFloatProportion().hashCode());
        result = prime * result + ((getOldYearRate() == null) ? 0 : getOldYearRate().hashCode());
        result = prime * result + ((getOldIrUpdateFrequency() == null) ? 0 : getOldIrUpdateFrequency().hashCode());
        result = prime * result + ((getOldInterestCollectType() == null) ? 0 : getOldInterestCollectType().hashCode());
        result = prime * result + ((getNewRateType() == null) ? 0 : getNewRateType().hashCode());
        result = prime * result + ((getNewFloatType() == null) ? 0 : getNewFloatType().hashCode());
        result = prime * result + ((getNewFloatWay() == null) ? 0 : getNewFloatWay().hashCode());
        result = prime * result + ((getNewBaseRateValue() == null) ? 0 : getNewBaseRateValue().hashCode());
        result = prime * result + ((getNewRateFloatProportion() == null) ? 0 : getNewRateFloatProportion().hashCode());
        result = prime * result + ((getNewYearRate() == null) ? 0 : getNewYearRate().hashCode());
        result = prime * result + ((getNewIrUpdateFrequency() == null) ? 0 : getNewIrUpdateFrequency().hashCode());
        result = prime * result + ((getNewInterestCollectType() == null) ? 0 : getNewInterestCollectType().hashCode());
        result = prime * result + ((getOldTerm() == null) ? 0 : getOldTerm().hashCode());
        result = prime * result + ((getOldEndDate() == null) ? 0 : getOldEndDate().hashCode());
        result = prime * result + ((getTermChangeWay() == null) ? 0 : getTermChangeWay().hashCode());
        result = prime * result + ((getNewTerm() == null) ? 0 : getNewTerm().hashCode());
        result = prime * result + ((getNewEndDate() == null) ? 0 : getNewEndDate().hashCode());
        result = prime * result + ((getOldRepayWay() == null) ? 0 : getOldRepayWay().hashCode());
        result = prime * result + ((getNewRepayWay() == null) ? 0 : getNewRepayWay().hashCode());
        result = prime * result + ((getOldRepayDay() == null) ? 0 : getOldRepayDay().hashCode());
        result = prime * result + ((getNewRepayDay() == null) ? 0 : getNewRepayDay().hashCode());
        result = prime * result + ((getOldRepayAccount() == null) ? 0 : getOldRepayAccount().hashCode());
        result = prime * result + ((getNewRepayAccount() == null) ? 0 : getNewRepayAccount().hashCode());
        result = prime * result + ((getOldGuarantyType() == null) ? 0 : getOldGuarantyType().hashCode());
        result = prime * result + ((getNewGuarantyType() == null) ? 0 : getNewGuarantyType().hashCode());
        result = prime * result + ((getIsSettle() == null) ? 0 : getIsSettle().hashCode());
        result = prime * result + ((getRepayAmt() == null) ? 0 : getRepayAmt().hashCode());
        result = prime * result + ((getRepayCapital() == null) ? 0 : getRepayCapital().hashCode());
        result = prime * result + ((getDealWay() == null) ? 0 : getDealWay().hashCode());
        result = prime * result + ((getIsModifyPlan() == null) ? 0 : getIsModifyPlan().hashCode());
        result = prime * result + ((getOldSummaryamt() == null) ? 0 : getOldSummaryamt().hashCode());
        result = prime * result + ((getNewSummaryamt() == null) ? 0 : getNewSummaryamt().hashCode());
        result = prime * result + ((getOldRateUp() == null) ? 0 : getOldRateUp().hashCode());
        result = prime * result + ((getNewRateUp() == null) ? 0 : getNewRateUp().hashCode());
        result = prime * result + ((getOldRateDown() == null) ? 0 : getOldRateDown().hashCode());
        result = prime * result + ((getNewRateDown() == null) ? 0 : getNewRateDown().hashCode());
        result = prime * result + ((getIsSmall() == null) ? 0 : getIsSmall().hashCode());
        result = prime * result + ((getRepayType() == null) ? 0 : getRepayType().hashCode());
        result = prime * result + ((getYhzclx() == null) ? 0 : getYhzclx().hashCode());
        result = prime * result + ((getYhtqlx() == null) ? 0 : getYhtqlx().hashCode());
        result = prime * result + ((getYhfx() == null) ? 0 : getYhfx().hashCode());
        result = prime * result + ((getOldTiexiStatus() == null) ? 0 : getOldTiexiStatus().hashCode());
        result = prime * result + ((getNewTiexiStatus() == null) ? 0 : getNewTiexiStatus().hashCode());
        result = prime * result + ((getOldTingxiStatus() == null) ? 0 : getOldTingxiStatus().hashCode());
        result = prime * result + ((getNewTingxiStatus() == null) ? 0 : getNewTingxiStatus().hashCode());
        result = prime * result + ((getRepayOrder() == null) ? 0 : getRepayOrder().hashCode());
        result = prime * result + ((getChangeNum() == null) ? 0 : getChangeNum().hashCode());
        result = prime * result + ((getStopRateType() == null) ? 0 : getStopRateType().hashCode());
        result = prime * result + ((getStopZcRate() == null) ? 0 : getStopZcRate().hashCode());
        result = prime * result + ((getStopTqRate() == null) ? 0 : getStopTqRate().hashCode());
        result = prime * result + ((getStopFx() == null) ? 0 : getStopFx().hashCode());
        result = prime * result + ((getStopZcRateOut() == null) ? 0 : getStopZcRateOut().hashCode());
        result = prime * result + ((getStopTqRateOut() == null) ? 0 : getStopTqRateOut().hashCode());
        result = prime * result + ((getStopFxOut() == null) ? 0 : getStopFxOut().hashCode());
        result = prime * result + ((getOldZhmc() == null) ? 0 : getOldZhmc().hashCode());
        result = prime * result + ((getOldKzbs() == null) ? 0 : getOldKzbs().hashCode());
        result = prime * result + ((getOldZhkhjg() == null) ? 0 : getOldZhkhjg().hashCode());
        result = prime * result + ((getOldZhbs() == null) ? 0 : getOldZhbs().hashCode());
        result = prime * result + ((getNewZhmc() == null) ? 0 : getNewZhmc().hashCode());
        result = prime * result + ((getNewKzbs() == null) ? 0 : getNewKzbs().hashCode());
        result = prime * result + ((getNewZhkhjg() == null) ? 0 : getNewZhkhjg().hashCode());
        result = prime * result + ((getNewZhbs() == null) ? 0 : getNewZhbs().hashCode());
        result = prime * result + ((getFirstPeriods() == null) ? 0 : getFirstPeriods().hashCode());
        result = prime * result + ((getYhbj() == null) ? 0 : getYhbj().hashCode());
        result = prime * result + ((getYhze() == null) ? 0 : getYhze().hashCode());
        result = prime * result + ((getNewWtrhbzh() == null) ? 0 : getNewWtrhbzh().hashCode());
        result = prime * result + ((getNewWtrhxzh() == null) ? 0 : getNewWtrhxzh().hashCode());
        result = prime * result + ((getWtrnm() == null) ? 0 : getWtrnm().hashCode());
        result = prime * result + ((getHzsnm() == null) ? 0 : getHzsnm().hashCode());
        result = prime * result + ((getHzszh() == null) ? 0 : getHzszh().hashCode());
        result = prime * result + ((getAdjItrFlg() == null) ? 0 : getAdjItrFlg().hashCode());
        result = prime * result + ((getNorItrIn() == null) ? 0 : getNorItrIn().hashCode());
        result = prime * result + ((getDftItrIn() == null) ? 0 : getDftItrIn().hashCode());
        result = prime * result + ((getPnsItrIn() == null) ? 0 : getPnsItrIn().hashCode());
        result = prime * result + ((getNorOtdItr() == null) ? 0 : getNorOtdItr().hashCode());
        result = prime * result + ((getPnsOtdItr() == null) ? 0 : getPnsOtdItr().hashCode());
        result = prime * result + ((getBeNorItrIn() == null) ? 0 : getBeNorItrIn().hashCode());
        result = prime * result + ((getBeDftItrIn() == null) ? 0 : getBeDftItrIn().hashCode());
        result = prime * result + ((getBePnsItrIn() == null) ? 0 : getBePnsItrIn().hashCode());
        result = prime * result + ((getBeNorOtdItr() == null) ? 0 : getBeNorOtdItr().hashCode());
        result = prime * result + ((getBePnsOtdItr() == null) ? 0 : getBePnsOtdItr().hashCode());
        result = prime * result + ((getOldWtrhbzh() == null) ? 0 : getOldWtrhbzh().hashCode());
        result = prime * result + ((getOldWtrhxzh() == null) ? 0 : getOldWtrhxzh().hashCode());
        result = prime * result + ((getNorItrOut() == null) ? 0 : getNorItrOut().hashCode());
        result = prime * result + ((getDftItrOut() == null) ? 0 : getDftItrOut().hashCode());
        result = prime * result + ((getPnsItrOut() == null) ? 0 : getPnsItrOut().hashCode());
        result = prime * result + ((getCpdItrOut() == null) ? 0 : getCpdItrOut().hashCode());
        result = prime * result + ((getBeNorItrOut() == null) ? 0 : getBeNorItrOut().hashCode());
        result = prime * result + ((getBeDftItrOut() == null) ? 0 : getBeDftItrOut().hashCode());
        result = prime * result + ((getBePnsItrOut() == null) ? 0 : getBePnsItrOut().hashCode());
        result = prime * result + ((getBeCpdItrOut() == null) ? 0 : getBeCpdItrOut().hashCode());
        result = prime * result + ((getCpdItrIn() == null) ? 0 : getCpdItrIn().hashCode());
        result = prime * result + ((getBeCpdItrIn() == null) ? 0 : getBeCpdItrIn().hashCode());
        result = prime * result + ((getOtdCpd() == null) ? 0 : getOtdCpd().hashCode());
        result = prime * result + ((getBeOtdCpd() == null) ? 0 : getBeOtdCpd().hashCode());
        result = prime * result + ((getOtdItrIn() == null) ? 0 : getOtdItrIn().hashCode());
        result = prime * result + ((getBeOtdItrIn() == null) ? 0 : getBeOtdItrIn().hashCode());
        result = prime * result + ((getStopFl() == null) ? 0 : getStopFl().hashCode());
        result = prime * result + ((getOldOverdueRate() == null) ? 0 : getOldOverdueRate().hashCode());
        result = prime * result + ((getNewOverdueRate() == null) ? 0 : getNewOverdueRate().hashCode());
        result = prime * result + ((getOldBzjblbdy() == null) ? 0 : getOldBzjblbdy().hashCode());
        result = prime * result + ((getNewBzjblbdy() == null) ? 0 : getNewBzjblbdy().hashCode());
        result = prime * result + ((getOldBzjje() == null) ? 0 : getOldBzjje().hashCode());
        result = prime * result + ((getNewBzjje() == null) ? 0 : getNewBzjje().hashCode());
        result = prime * result + ((getOldXyzDqrq() == null) ? 0 : getOldXyzDqrq().hashCode());
        result = prime * result + ((getNewXyzDqrq() == null) ? 0 : getNewXyzDqrq().hashCode());
        result = prime * result + ((getOldBhDqrq() == null) ? 0 : getOldBhDqrq().hashCode());
        result = prime * result + ((getNewBhDqrq() == null) ? 0 : getNewBhDqrq().hashCode());
        result = prime * result + ((getOldBhBzjblbdy() == null) ? 0 : getOldBhBzjblbdy().hashCode());
        result = prime * result + ((getNewBhBzjblbdy() == null) ? 0 : getNewBhBzjblbdy().hashCode());
        result = prime * result + ((getOldBhBzjje() == null) ? 0 : getOldBhBzjje().hashCode());
        result = prime * result + ((getNewBhBzjje() == null) ? 0 : getNewBhBzjje().hashCode());
        result = prime * result + ((getOldXyzJyq() == null) ? 0 : getOldXyzJyq().hashCode());
        result = prime * result + ((getNewXyzJyq() == null) ? 0 : getNewXyzJyq().hashCode());
        result = prime * result + ((getOldXyzYqts() == null) ? 0 : getOldXyzYqts().hashCode());
        result = prime * result + ((getNewXyzYqts() == null) ? 0 : getNewXyzYqts().hashCode());
        result = prime * result + ((getOldBhBhlx() == null) ? 0 : getOldBhBhlx().hashCode());
        result = prime * result + ((getNewBhBhlx() == null) ? 0 : getNewBhBhlx().hashCode());
        result = prime * result + ((getGjFlowNo() == null) ? 0 : getGjFlowNo().hashCode());
        result = prime * result + ((getYhfl() == null) ? 0 : getYhfl().hashCode());
        result = prime * result + ((getOldKzje() == null) ? 0 : getOldKzje().hashCode());
        result = prime * result + ((getNewKzje() == null) ? 0 : getNewKzje().hashCode());
        result = prime * result + ((getPeriodNum() == null) ? 0 : getPeriodNum().hashCode());
        result = prime * result + ((getPeriodState() == null) ? 0 : getPeriodState().hashCode());
        result = prime * result + ((getShbj() == null) ? 0 : getShbj().hashCode());
        result = prime * result + ((getShzclx() == null) ? 0 : getShzclx().hashCode());
        result = prime * result + ((getShtqlx() == null) ? 0 : getShtqlx().hashCode());
        result = prime * result + ((getShfx() == null) ? 0 : getShfx().hashCode());
        result = prime * result + ((getShfl() == null) ? 0 : getShfl().hashCode());
        result = prime * result + ((getAdjOtdPns() == null) ? 0 : getAdjOtdPns().hashCode());
        result = prime * result + ((getAdjOtdCpd() == null) ? 0 : getAdjOtdCpd().hashCode());
        result = prime * result + ((getPadUpAdjOtdItr() == null) ? 0 : getPadUpAdjOtdItr().hashCode());
        result = prime * result + ((getPadUpAdjOtdPns() == null) ? 0 : getPadUpAdjOtdPns().hashCode());
        result = prime * result + ((getPadUpAdjOtdCpd() == null) ? 0 : getPadUpAdjOtdCpd().hashCode());
        result = prime * result + ((getPadUpAdjOtdItrPre() == null) ? 0 : getPadUpAdjOtdItrPre().hashCode());
        result = prime * result + ((getOldSecondRepayAccount() == null) ? 0 : getOldSecondRepayAccount().hashCode());
        result = prime * result + ((getOldSecondZhmc() == null) ? 0 : getOldSecondZhmc().hashCode());
        result = prime * result + ((getOldSecondKzbs() == null) ? 0 : getOldSecondKzbs().hashCode());
        result = prime * result + ((getOldSecondZhkhjg() == null) ? 0 : getOldSecondZhkhjg().hashCode());
        result = prime * result + ((getOldSecondZhbs() == null) ? 0 : getOldSecondZhbs().hashCode());
        result = prime * result + ((getNewSecondRepayAccount() == null) ? 0 : getNewSecondRepayAccount().hashCode());
        result = prime * result + ((getNewSecondZhmc() == null) ? 0 : getNewSecondZhmc().hashCode());
        result = prime * result + ((getNewSecondKzbs() == null) ? 0 : getNewSecondKzbs().hashCode());
        result = prime * result + ((getNewSecondZhkhjg() == null) ? 0 : getNewSecondZhkhjg().hashCode());
        result = prime * result + ((getNewSecondZhbs() == null) ? 0 : getNewSecondZhbs().hashCode());
        result = prime * result + ((getOldThirdRepayAccount() == null) ? 0 : getOldThirdRepayAccount().hashCode());
        result = prime * result + ((getOldThirdZhmc() == null) ? 0 : getOldThirdZhmc().hashCode());
        result = prime * result + ((getOldThirdKzbs() == null) ? 0 : getOldThirdKzbs().hashCode());
        result = prime * result + ((getOldThirdZhkhjg() == null) ? 0 : getOldThirdZhkhjg().hashCode());
        result = prime * result + ((getOldThirdZhbs() == null) ? 0 : getOldThirdZhbs().hashCode());
        result = prime * result + ((getNewThirdRepayAccount() == null) ? 0 : getNewThirdRepayAccount().hashCode());
        result = prime * result + ((getNewThirdZhmc() == null) ? 0 : getNewThirdZhmc().hashCode());
        result = prime * result + ((getNewThirdKzbs() == null) ? 0 : getNewThirdKzbs().hashCode());
        result = prime * result + ((getNewThirdZhkhjg() == null) ? 0 : getNewThirdZhkhjg().hashCode());
        result = prime * result + ((getNewThirdZhbs() == null) ? 0 : getNewThirdZhbs().hashCode());
        result = prime * result + ((getIsCredit() == null) ? 0 : getIsCredit().hashCode());
        return result;
    }
}