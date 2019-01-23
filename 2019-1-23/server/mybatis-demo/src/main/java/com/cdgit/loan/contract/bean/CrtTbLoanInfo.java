package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * tb_loan_info 放款信息表
 * @author Administrator
 *
 */
public class CrtTbLoanInfo {
	
    private String loanId;					//放款id，主键

    private String contractId;				//合同id

    private String loanNum;					//放款编号

    private String loanSubject1;			//贷款科目

    private BigDecimal loanAmt;				//本次出账金额

    private String currencyCd;				//币种(:CD000001)

    private Long loanTerm;					//期限

    private String cycleUnit;				//期限单位(:XD_GGCD6009)

    private Date beginDate;					//开始日期

    private Date endDate;					//到期日期

    private String loanOrg;					//出账机构

    private String userNum;					//经办人

    private String orgNum;					//经办机构

    private Date createTime;				//创建时间

    private Date updateTime;				//更新时间

    private String productType;				//业务品种(:tb_sys_product)

    private String partyId;					//参与人id（客户id）

    private String loanStatus;				//出账状态(:XD_SXCD8003)

    private Short specPaymentDate;			//指定还息日期

    private String holidayFlg;				//节假日标志

    private String holidayItrWay;			//节假日利息处理方式

    private String counterFlg;				//柜面交易使用标志

    private String batFlg;					//批量扣款标志(:XD_0002)

    private String trusToPayFlg;			//受托支付标志(:XD_0002)

    private String stopPayFlg;				//止付标志(:XD_0002)

    private String repayType;				//还款方式(:XD_SXCD1162)

    private String summaryNum;				//借据编号

    private BigDecimal exchangeRate;		//汇率

    private BigDecimal rmbAmt;				//折算人民币金额

    private String ifDataMove;				//是否迁移数据

    private String firstRepayTerm;			//首次还款期次

    private Integer hpzs;					//汇票张数

    private String hpbh;					//汇票编号

    private String pjzl;					//票据种类(:XD_SXCD1123)

    private String drweBnkNm;				//付款行全称

    private String drweBnkNo;				//付款行行号

    private String drweBnkAdr;

    private Date txzq;						//贴息止期

    private BigDecimal comAmt;				//承诺费(银承)

    private String term;					//放款期限(放款时从页面保存)

    private String unit;					//期限单位(放款时从页面保存)

    private String payOutFlag;				//借新还旧是否归还利息0-不还  1-归还

    private String orgRcnStan;				//?????????

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
}