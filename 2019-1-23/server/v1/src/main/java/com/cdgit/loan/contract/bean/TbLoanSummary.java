package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

/*
 * 借据信息表	tb_loan_summary
 */
public class TbLoanSummary {
	
    private String summaryId;					//借款ID	

    private String loanId;						//放款ID

    private String partyId;						//客户ID

    private BigDecimal summaryAmt;				//借据金额

    private String summaryCurrencyCd;			//借据币种

    private Date beginDate;						//借据起始日

    private Date endDate;						//借据到期日

    private Long summaryTerm;					//借据期限

    private String cycleUnit;					//期限单位(:XD_GGCD6009)

    private String userNum;						//经办人

    private String orgNum;						//经办机构

    private Date createTime;					//创建时间

    private Date updateTime;					//更新时间

    private String summaryStatusCd;				//借据状态(:XD_SXYW0226)

    private String summaryNum;					//借据编号

    private String nftNo;						//通知书编号

    private BigDecimal jjye;					//借据余额

    private Integer yqts;						//逾期天数

    private String fljg;						//分类结果

    private BigDecimal exchangeRate;			//汇率

    private BigDecimal rmbAmt;					//折算人民币金额

    private String guarantyType;				//担保方式(:CDZC0005)

    private BigDecimal dftItr;					//累计欠息

    private BigDecimal dftItrIn;				//累计表内欠息

    private BigDecimal dftItrOut;				//累计表外欠息

    private String contractId;					//合同ID

    private BigDecimal ljyqcs;					//累计逾期次数

    private BigDecimal lxyqcs;					//连续逾期次数

    private String tiexiStatus;					//贴息状态(01-贴息 02-正常)

    private String tingxiStatus;				//停息状态(01-停息 02-正常)

    private BigDecimal jjyqbj;					//借据逾期本金

    private BigDecimal ljfx;					//累计罚息

    private BigDecimal byjezd;					//????

    private String bydmzd;						//????

    private BigDecimal normalItr;				//正常利息

    private BigDecimal arrearItr;				//拖欠利息

    private BigDecimal punishItr;				//罚息

    private String deavSts;						//减值状态

    private String entrustReturnPrincipalAcc;	//委托人收本账号

    private String entrustReturnInterestAcc;	//委托人收息账号

    private String rcnStan;						//对账流水号

    private String ywbh;						//业务编号(调用国结出账国结系统返回的业务号码)

    private String backCd;						//撤销状态（放款还款撤销专用）:XD_SXYW0226

    private String ifDataMove;					//迁移数据

    private String ifDataMove1;					//迁移数据

    private String periodFlag;					//展期标志:XD_0002

    private String periodNum;					//展期协议号

    private String exextFlg;					//展期相对后一次是否失效:XD_ZQZT0001

    private BigDecimal bzjbl;					//保证金比例(票据需求)

    private BigDecimal bzjje;					//保证金金额(票据需求)

    private BigDecimal newPnsItr;				//罚息

    private BigDecimal newFlItr;				//复利

    private String autoFljg;					//系统自动风险分类结果

    private String adjustFlg;					//人工调整标志 1 已调整 0 未调整

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

    public BigDecimal getLjyqcs() {
        return ljyqcs;
    }

    public void setLjyqcs(BigDecimal ljyqcs) {
        this.ljyqcs = ljyqcs;
    }

    public BigDecimal getLxyqcs() {
        return lxyqcs;
    }

    public void setLxyqcs(BigDecimal lxyqcs) {
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
	public String toString() {
		return "TbLoanSummary [summaryId=" + summaryId + ", loanId=" + loanId + ", partyId=" + partyId + ", summaryAmt="
				+ summaryAmt + ", summaryCurrencyCd=" + summaryCurrencyCd + ", beginDate=" + beginDate + ", endDate="
				+ endDate + ", summaryTerm=" + summaryTerm + ", cycleUnit=" + cycleUnit + ", userNum=" + userNum
				+ ", orgNum=" + orgNum + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", summaryStatusCd=" + summaryStatusCd + ", summaryNum=" + summaryNum + ", nftNo=" + nftNo + ", jjye="
				+ jjye + ", yqts=" + yqts + ", fljg=" + fljg + ", exchangeRate=" + exchangeRate + ", rmbAmt=" + rmbAmt
				+ ", guarantyType=" + guarantyType + ", dftItr=" + dftItr + ", dftItrIn=" + dftItrIn + ", dftItrOut="
				+ dftItrOut + ", contractId=" + contractId + ", ljyqcs=" + ljyqcs + ", lxyqcs=" + lxyqcs
				+ ", tiexiStatus=" + tiexiStatus + ", tingxiStatus=" + tingxiStatus + ", jjyqbj=" + jjyqbj + ", ljfx="
				+ ljfx + ", byjezd=" + byjezd + ", bydmzd=" + bydmzd + ", normalItr=" + normalItr + ", arrearItr="
				+ arrearItr + ", punishItr=" + punishItr + ", deavSts=" + deavSts + ", entrustReturnPrincipalAcc="
				+ entrustReturnPrincipalAcc + ", entrustReturnInterestAcc=" + entrustReturnInterestAcc + ", rcnStan="
				+ rcnStan + ", ywbh=" + ywbh + ", backCd=" + backCd + ", ifDataMove=" + ifDataMove + ", ifDataMove1="
				+ ifDataMove1 + ", periodFlag=" + periodFlag + ", periodNum=" + periodNum + ", exextFlg=" + exextFlg
				+ ", bzjbl=" + bzjbl + ", bzjje=" + bzjje + ", newPnsItr=" + newPnsItr + ", newFlItr=" + newFlItr
				+ ", autoFljg=" + autoFljg + ", adjustFlg=" + adjustFlg + ", settleDate=" + settleDate
				+ ", lastPayDate=" + lastPayDate + ", bjYqts=" + bjYqts + ", lxYqts=" + lxYqts + "]";
	}
    
    
}