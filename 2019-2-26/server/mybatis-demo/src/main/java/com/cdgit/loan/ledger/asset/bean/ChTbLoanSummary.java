package com.cdgit.loan.ledger.asset.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ChTbLoanSummary {
    private String summaryId;

    private String loanId;

    private String partyId;

    private BigDecimal summaryAmt;

    private String summaryCurrencyCd;

    private Date beginDate;

    private Date endDate;

    private Long summaryTerm;

    private String cycleUnit;

    private String userNum;

    private String orgNum;

    private Date createTime;

    private Date updateTime;

    private String summaryStatusCd;

    private String summaryNum;

    private String nftNo;

    private BigDecimal jjye;

    private Integer yqts;

    private String fljg;

    private BigDecimal exchangeRate;

    private BigDecimal rmbAmt;

    private String guarantyType;

    private BigDecimal dftItr;

    private BigDecimal dftItrIn;

    private BigDecimal dftItrOut;

    private String contractId;

    private Short ljyqcs;

    private Short lxyqcs;

    private String tiexiStatus;

    private String tingxiStatus;

    private BigDecimal jjyqbj;

    private BigDecimal ljfx;

    private BigDecimal byjezd;

    private String bydmzd;

    private BigDecimal normalItr;

    private BigDecimal arrearItr;

    private BigDecimal punishItr;

    private String deavSts;

    private String entrustReturnPrincipalAcc;

    private String entrustReturnInterestAcc;

    private String rcnStan;

    private String ywbh;

    private String backCd;

    private String ifDataMove;

    private String ifDataMove1;

    private String periodFlag;

    private String periodNum;

    private String exextFlg;

    private BigDecimal bzjbl;

    private BigDecimal bzjje;

    private BigDecimal newPnsItr;

    private BigDecimal newFlItr;

    private String autoFljg;

    private String adjustFlg;

    private Date settleDate;

    private Date lastPayDate;

    private Integer bjYqts;

    private Integer lxYqts;

    public String getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(String summaryId) {
        this.summaryId = summaryId == null ? null : summaryId.trim();
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public BigDecimal getSummaryAmt() {
        return summaryAmt;
    }

    public void setSummaryAmt(BigDecimal summaryAmt) {
        this.summaryAmt = summaryAmt;
    }

    public String getSummaryCurrencyCd() {
        return summaryCurrencyCd;
    }

    public void setSummaryCurrencyCd(String summaryCurrencyCd) {
        this.summaryCurrencyCd = summaryCurrencyCd == null ? null : summaryCurrencyCd.trim();
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

    public Long getSummaryTerm() {
        return summaryTerm;
    }

    public void setSummaryTerm(Long summaryTerm) {
        this.summaryTerm = summaryTerm;
    }

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit == null ? null : cycleUnit.trim();
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

    public String getSummaryStatusCd() {
        return summaryStatusCd;
    }

    public void setSummaryStatusCd(String summaryStatusCd) {
        this.summaryStatusCd = summaryStatusCd == null ? null : summaryStatusCd.trim();
    }

    public String getSummaryNum() {
        return summaryNum;
    }

    public void setSummaryNum(String summaryNum) {
        this.summaryNum = summaryNum == null ? null : summaryNum.trim();
    }

    public String getNftNo() {
        return nftNo;
    }

    public void setNftNo(String nftNo) {
        this.nftNo = nftNo == null ? null : nftNo.trim();
    }

    public BigDecimal getJjye() {
        return jjye;
    }

    public void setJjye(BigDecimal jjye) {
        this.jjye = jjye;
    }

    public Integer getYqts() {
        return yqts;
    }

    public void setYqts(Integer yqts) {
        this.yqts = yqts;
    }

    public String getFljg() {
        return fljg;
    }

    public void setFljg(String fljg) {
        this.fljg = fljg == null ? null : fljg.trim();
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

    public String getGuarantyType() {
        return guarantyType;
    }

    public void setGuarantyType(String guarantyType) {
        this.guarantyType = guarantyType == null ? null : guarantyType.trim();
    }

    public BigDecimal getDftItr() {
        return dftItr;
    }

    public void setDftItr(BigDecimal dftItr) {
        this.dftItr = dftItr;
    }

    public BigDecimal getDftItrIn() {
        return dftItrIn;
    }

    public void setDftItrIn(BigDecimal dftItrIn) {
        this.dftItrIn = dftItrIn;
    }

    public BigDecimal getDftItrOut() {
        return dftItrOut;
    }

    public void setDftItrOut(BigDecimal dftItrOut) {
        this.dftItrOut = dftItrOut;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public Short getLjyqcs() {
        return ljyqcs;
    }

    public void setLjyqcs(Short ljyqcs) {
        this.ljyqcs = ljyqcs;
    }

    public Short getLxyqcs() {
        return lxyqcs;
    }

    public void setLxyqcs(Short lxyqcs) {
        this.lxyqcs = lxyqcs;
    }

    public String getTiexiStatus() {
        return tiexiStatus;
    }

    public void setTiexiStatus(String tiexiStatus) {
        this.tiexiStatus = tiexiStatus == null ? null : tiexiStatus.trim();
    }

    public String getTingxiStatus() {
        return tingxiStatus;
    }

    public void setTingxiStatus(String tingxiStatus) {
        this.tingxiStatus = tingxiStatus == null ? null : tingxiStatus.trim();
    }

    public BigDecimal getJjyqbj() {
        return jjyqbj;
    }

    public void setJjyqbj(BigDecimal jjyqbj) {
        this.jjyqbj = jjyqbj;
    }

    public BigDecimal getLjfx() {
        return ljfx;
    }

    public void setLjfx(BigDecimal ljfx) {
        this.ljfx = ljfx;
    }

    public BigDecimal getByjezd() {
        return byjezd;
    }

    public void setByjezd(BigDecimal byjezd) {
        this.byjezd = byjezd;
    }

    public String getBydmzd() {
        return bydmzd;
    }

    public void setBydmzd(String bydmzd) {
        this.bydmzd = bydmzd == null ? null : bydmzd.trim();
    }

    public BigDecimal getNormalItr() {
        return normalItr;
    }

    public void setNormalItr(BigDecimal normalItr) {
        this.normalItr = normalItr;
    }

    public BigDecimal getArrearItr() {
        return arrearItr;
    }

    public void setArrearItr(BigDecimal arrearItr) {
        this.arrearItr = arrearItr;
    }

    public BigDecimal getPunishItr() {
        return punishItr;
    }

    public void setPunishItr(BigDecimal punishItr) {
        this.punishItr = punishItr;
    }

    public String getDeavSts() {
        return deavSts;
    }

    public void setDeavSts(String deavSts) {
        this.deavSts = deavSts == null ? null : deavSts.trim();
    }

    public String getEntrustReturnPrincipalAcc() {
        return entrustReturnPrincipalAcc;
    }

    public void setEntrustReturnPrincipalAcc(String entrustReturnPrincipalAcc) {
        this.entrustReturnPrincipalAcc = entrustReturnPrincipalAcc == null ? null : entrustReturnPrincipalAcc.trim();
    }

    public String getEntrustReturnInterestAcc() {
        return entrustReturnInterestAcc;
    }

    public void setEntrustReturnInterestAcc(String entrustReturnInterestAcc) {
        this.entrustReturnInterestAcc = entrustReturnInterestAcc == null ? null : entrustReturnInterestAcc.trim();
    }

    public String getRcnStan() {
        return rcnStan;
    }

    public void setRcnStan(String rcnStan) {
        this.rcnStan = rcnStan == null ? null : rcnStan.trim();
    }

    public String getYwbh() {
        return ywbh;
    }

    public void setYwbh(String ywbh) {
        this.ywbh = ywbh == null ? null : ywbh.trim();
    }

    public String getBackCd() {
        return backCd;
    }

    public void setBackCd(String backCd) {
        this.backCd = backCd == null ? null : backCd.trim();
    }

    public String getIfDataMove() {
        return ifDataMove;
    }

    public void setIfDataMove(String ifDataMove) {
        this.ifDataMove = ifDataMove == null ? null : ifDataMove.trim();
    }

    public String getIfDataMove1() {
        return ifDataMove1;
    }

    public void setIfDataMove1(String ifDataMove1) {
        this.ifDataMove1 = ifDataMove1 == null ? null : ifDataMove1.trim();
    }

    public String getPeriodFlag() {
        return periodFlag;
    }

    public void setPeriodFlag(String periodFlag) {
        this.periodFlag = periodFlag == null ? null : periodFlag.trim();
    }

    public String getPeriodNum() {
        return periodNum;
    }

    public void setPeriodNum(String periodNum) {
        this.periodNum = periodNum == null ? null : periodNum.trim();
    }

    public String getExextFlg() {
        return exextFlg;
    }

    public void setExextFlg(String exextFlg) {
        this.exextFlg = exextFlg == null ? null : exextFlg.trim();
    }

    public BigDecimal getBzjbl() {
        return bzjbl;
    }

    public void setBzjbl(BigDecimal bzjbl) {
        this.bzjbl = bzjbl;
    }

    public BigDecimal getBzjje() {
        return bzjje;
    }

    public void setBzjje(BigDecimal bzjje) {
        this.bzjje = bzjje;
    }

    public BigDecimal getNewPnsItr() {
        return newPnsItr;
    }

    public void setNewPnsItr(BigDecimal newPnsItr) {
        this.newPnsItr = newPnsItr;
    }

    public BigDecimal getNewFlItr() {
        return newFlItr;
    }

    public void setNewFlItr(BigDecimal newFlItr) {
        this.newFlItr = newFlItr;
    }

    public String getAutoFljg() {
        return autoFljg;
    }

    public void setAutoFljg(String autoFljg) {
        this.autoFljg = autoFljg == null ? null : autoFljg.trim();
    }

    public String getAdjustFlg() {
        return adjustFlg;
    }

    public void setAdjustFlg(String adjustFlg) {
        this.adjustFlg = adjustFlg == null ? null : adjustFlg.trim();
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    public Date getLastPayDate() {
        return lastPayDate;
    }

    public void setLastPayDate(Date lastPayDate) {
        this.lastPayDate = lastPayDate;
    }

    public Integer getBjYqts() {
        return bjYqts;
    }

    public void setBjYqts(Integer bjYqts) {
        this.bjYqts = bjYqts;
    }

    public Integer getLxYqts() {
        return lxYqts;
    }

    public void setLxYqts(Integer lxYqts) {
        this.lxYqts = lxYqts;
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
        ChTbLoanSummary other = (ChTbLoanSummary) that;
        return (this.getSummaryId() == null ? other.getSummaryId() == null : this.getSummaryId().equals(other.getSummaryId()))
            && (this.getLoanId() == null ? other.getLoanId() == null : this.getLoanId().equals(other.getLoanId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getSummaryAmt() == null ? other.getSummaryAmt() == null : this.getSummaryAmt().equals(other.getSummaryAmt()))
            && (this.getSummaryCurrencyCd() == null ? other.getSummaryCurrencyCd() == null : this.getSummaryCurrencyCd().equals(other.getSummaryCurrencyCd()))
            && (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getSummaryTerm() == null ? other.getSummaryTerm() == null : this.getSummaryTerm().equals(other.getSummaryTerm()))
            && (this.getCycleUnit() == null ? other.getCycleUnit() == null : this.getCycleUnit().equals(other.getCycleUnit()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getSummaryStatusCd() == null ? other.getSummaryStatusCd() == null : this.getSummaryStatusCd().equals(other.getSummaryStatusCd()))
            && (this.getSummaryNum() == null ? other.getSummaryNum() == null : this.getSummaryNum().equals(other.getSummaryNum()))
            && (this.getNftNo() == null ? other.getNftNo() == null : this.getNftNo().equals(other.getNftNo()))
            && (this.getJjye() == null ? other.getJjye() == null : this.getJjye().equals(other.getJjye()))
            && (this.getYqts() == null ? other.getYqts() == null : this.getYqts().equals(other.getYqts()))
            && (this.getFljg() == null ? other.getFljg() == null : this.getFljg().equals(other.getFljg()))
            && (this.getExchangeRate() == null ? other.getExchangeRate() == null : this.getExchangeRate().equals(other.getExchangeRate()))
            && (this.getRmbAmt() == null ? other.getRmbAmt() == null : this.getRmbAmt().equals(other.getRmbAmt()))
            && (this.getGuarantyType() == null ? other.getGuarantyType() == null : this.getGuarantyType().equals(other.getGuarantyType()))
            && (this.getDftItr() == null ? other.getDftItr() == null : this.getDftItr().equals(other.getDftItr()))
            && (this.getDftItrIn() == null ? other.getDftItrIn() == null : this.getDftItrIn().equals(other.getDftItrIn()))
            && (this.getDftItrOut() == null ? other.getDftItrOut() == null : this.getDftItrOut().equals(other.getDftItrOut()))
            && (this.getContractId() == null ? other.getContractId() == null : this.getContractId().equals(other.getContractId()))
            && (this.getLjyqcs() == null ? other.getLjyqcs() == null : this.getLjyqcs().equals(other.getLjyqcs()))
            && (this.getLxyqcs() == null ? other.getLxyqcs() == null : this.getLxyqcs().equals(other.getLxyqcs()))
            && (this.getTiexiStatus() == null ? other.getTiexiStatus() == null : this.getTiexiStatus().equals(other.getTiexiStatus()))
            && (this.getTingxiStatus() == null ? other.getTingxiStatus() == null : this.getTingxiStatus().equals(other.getTingxiStatus()))
            && (this.getJjyqbj() == null ? other.getJjyqbj() == null : this.getJjyqbj().equals(other.getJjyqbj()))
            && (this.getLjfx() == null ? other.getLjfx() == null : this.getLjfx().equals(other.getLjfx()))
            && (this.getByjezd() == null ? other.getByjezd() == null : this.getByjezd().equals(other.getByjezd()))
            && (this.getBydmzd() == null ? other.getBydmzd() == null : this.getBydmzd().equals(other.getBydmzd()))
            && (this.getNormalItr() == null ? other.getNormalItr() == null : this.getNormalItr().equals(other.getNormalItr()))
            && (this.getArrearItr() == null ? other.getArrearItr() == null : this.getArrearItr().equals(other.getArrearItr()))
            && (this.getPunishItr() == null ? other.getPunishItr() == null : this.getPunishItr().equals(other.getPunishItr()))
            && (this.getDeavSts() == null ? other.getDeavSts() == null : this.getDeavSts().equals(other.getDeavSts()))
            && (this.getEntrustReturnPrincipalAcc() == null ? other.getEntrustReturnPrincipalAcc() == null : this.getEntrustReturnPrincipalAcc().equals(other.getEntrustReturnPrincipalAcc()))
            && (this.getEntrustReturnInterestAcc() == null ? other.getEntrustReturnInterestAcc() == null : this.getEntrustReturnInterestAcc().equals(other.getEntrustReturnInterestAcc()))
            && (this.getRcnStan() == null ? other.getRcnStan() == null : this.getRcnStan().equals(other.getRcnStan()))
            && (this.getYwbh() == null ? other.getYwbh() == null : this.getYwbh().equals(other.getYwbh()))
            && (this.getBackCd() == null ? other.getBackCd() == null : this.getBackCd().equals(other.getBackCd()))
            && (this.getIfDataMove() == null ? other.getIfDataMove() == null : this.getIfDataMove().equals(other.getIfDataMove()))
            && (this.getIfDataMove1() == null ? other.getIfDataMove1() == null : this.getIfDataMove1().equals(other.getIfDataMove1()))
            && (this.getPeriodFlag() == null ? other.getPeriodFlag() == null : this.getPeriodFlag().equals(other.getPeriodFlag()))
            && (this.getPeriodNum() == null ? other.getPeriodNum() == null : this.getPeriodNum().equals(other.getPeriodNum()))
            && (this.getExextFlg() == null ? other.getExextFlg() == null : this.getExextFlg().equals(other.getExextFlg()))
            && (this.getBzjbl() == null ? other.getBzjbl() == null : this.getBzjbl().equals(other.getBzjbl()))
            && (this.getBzjje() == null ? other.getBzjje() == null : this.getBzjje().equals(other.getBzjje()))
            && (this.getNewPnsItr() == null ? other.getNewPnsItr() == null : this.getNewPnsItr().equals(other.getNewPnsItr()))
            && (this.getNewFlItr() == null ? other.getNewFlItr() == null : this.getNewFlItr().equals(other.getNewFlItr()))
            && (this.getAutoFljg() == null ? other.getAutoFljg() == null : this.getAutoFljg().equals(other.getAutoFljg()))
            && (this.getAdjustFlg() == null ? other.getAdjustFlg() == null : this.getAdjustFlg().equals(other.getAdjustFlg()))
            && (this.getSettleDate() == null ? other.getSettleDate() == null : this.getSettleDate().equals(other.getSettleDate()))
            && (this.getLastPayDate() == null ? other.getLastPayDate() == null : this.getLastPayDate().equals(other.getLastPayDate()))
            && (this.getBjYqts() == null ? other.getBjYqts() == null : this.getBjYqts().equals(other.getBjYqts()))
            && (this.getLxYqts() == null ? other.getLxYqts() == null : this.getLxYqts().equals(other.getLxYqts()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSummaryId() == null) ? 0 : getSummaryId().hashCode());
        result = prime * result + ((getLoanId() == null) ? 0 : getLoanId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getSummaryAmt() == null) ? 0 : getSummaryAmt().hashCode());
        result = prime * result + ((getSummaryCurrencyCd() == null) ? 0 : getSummaryCurrencyCd().hashCode());
        result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getSummaryTerm() == null) ? 0 : getSummaryTerm().hashCode());
        result = prime * result + ((getCycleUnit() == null) ? 0 : getCycleUnit().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getSummaryStatusCd() == null) ? 0 : getSummaryStatusCd().hashCode());
        result = prime * result + ((getSummaryNum() == null) ? 0 : getSummaryNum().hashCode());
        result = prime * result + ((getNftNo() == null) ? 0 : getNftNo().hashCode());
        result = prime * result + ((getJjye() == null) ? 0 : getJjye().hashCode());
        result = prime * result + ((getYqts() == null) ? 0 : getYqts().hashCode());
        result = prime * result + ((getFljg() == null) ? 0 : getFljg().hashCode());
        result = prime * result + ((getExchangeRate() == null) ? 0 : getExchangeRate().hashCode());
        result = prime * result + ((getRmbAmt() == null) ? 0 : getRmbAmt().hashCode());
        result = prime * result + ((getGuarantyType() == null) ? 0 : getGuarantyType().hashCode());
        result = prime * result + ((getDftItr() == null) ? 0 : getDftItr().hashCode());
        result = prime * result + ((getDftItrIn() == null) ? 0 : getDftItrIn().hashCode());
        result = prime * result + ((getDftItrOut() == null) ? 0 : getDftItrOut().hashCode());
        result = prime * result + ((getContractId() == null) ? 0 : getContractId().hashCode());
        result = prime * result + ((getLjyqcs() == null) ? 0 : getLjyqcs().hashCode());
        result = prime * result + ((getLxyqcs() == null) ? 0 : getLxyqcs().hashCode());
        result = prime * result + ((getTiexiStatus() == null) ? 0 : getTiexiStatus().hashCode());
        result = prime * result + ((getTingxiStatus() == null) ? 0 : getTingxiStatus().hashCode());
        result = prime * result + ((getJjyqbj() == null) ? 0 : getJjyqbj().hashCode());
        result = prime * result + ((getLjfx() == null) ? 0 : getLjfx().hashCode());
        result = prime * result + ((getByjezd() == null) ? 0 : getByjezd().hashCode());
        result = prime * result + ((getBydmzd() == null) ? 0 : getBydmzd().hashCode());
        result = prime * result + ((getNormalItr() == null) ? 0 : getNormalItr().hashCode());
        result = prime * result + ((getArrearItr() == null) ? 0 : getArrearItr().hashCode());
        result = prime * result + ((getPunishItr() == null) ? 0 : getPunishItr().hashCode());
        result = prime * result + ((getDeavSts() == null) ? 0 : getDeavSts().hashCode());
        result = prime * result + ((getEntrustReturnPrincipalAcc() == null) ? 0 : getEntrustReturnPrincipalAcc().hashCode());
        result = prime * result + ((getEntrustReturnInterestAcc() == null) ? 0 : getEntrustReturnInterestAcc().hashCode());
        result = prime * result + ((getRcnStan() == null) ? 0 : getRcnStan().hashCode());
        result = prime * result + ((getYwbh() == null) ? 0 : getYwbh().hashCode());
        result = prime * result + ((getBackCd() == null) ? 0 : getBackCd().hashCode());
        result = prime * result + ((getIfDataMove() == null) ? 0 : getIfDataMove().hashCode());
        result = prime * result + ((getIfDataMove1() == null) ? 0 : getIfDataMove1().hashCode());
        result = prime * result + ((getPeriodFlag() == null) ? 0 : getPeriodFlag().hashCode());
        result = prime * result + ((getPeriodNum() == null) ? 0 : getPeriodNum().hashCode());
        result = prime * result + ((getExextFlg() == null) ? 0 : getExextFlg().hashCode());
        result = prime * result + ((getBzjbl() == null) ? 0 : getBzjbl().hashCode());
        result = prime * result + ((getBzjje() == null) ? 0 : getBzjje().hashCode());
        result = prime * result + ((getNewPnsItr() == null) ? 0 : getNewPnsItr().hashCode());
        result = prime * result + ((getNewFlItr() == null) ? 0 : getNewFlItr().hashCode());
        result = prime * result + ((getAutoFljg() == null) ? 0 : getAutoFljg().hashCode());
        result = prime * result + ((getAdjustFlg() == null) ? 0 : getAdjustFlg().hashCode());
        result = prime * result + ((getSettleDate() == null) ? 0 : getSettleDate().hashCode());
        result = prime * result + ((getLastPayDate() == null) ? 0 : getLastPayDate().hashCode());
        result = prime * result + ((getBjYqts() == null) ? 0 : getBjYqts().hashCode());
        result = prime * result + ((getLxYqts() == null) ? 0 : getLxYqts().hashCode());
        return result;
    }
}