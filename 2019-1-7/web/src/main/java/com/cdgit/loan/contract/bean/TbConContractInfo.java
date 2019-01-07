package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

/*
 * 业务合同信息表	TB_CON_CONTRACT_INFO
 * 资料表有53个，这里有58个
 */
public class TbConContractInfo {

	private String contractId;					//合同ID
	private String amountDetailId;				//业务明细ID
	private String contractNum;					//合同编号
	private String contractAddress;				//签约地点
	private String partyId;						//客户ID
	private String oldContractId;				//原合同ID
	private String currencyCd;					//币种
	private BigDecimal contractAmt;				//合同金额
	private String contractTerm;				//期限
	private String cycleUnit;					//期限单位(:XD_GGCD6009)
	private Date beginDate;						//开始时间（起始日）	TIMESTAMP(6)时间戳
	private Date endDate;						//结束时间（到期日）
	private Date contractDate;					//签约日期
	private String loanUse;						//贷款用途
	private String guarantyType;				//担保方式
	private String loanTurn;					//行业投向(:CDXY0300)
	private String userNum;						//经办人
	private String orgNum;						//经办机构
	private Date createTime;					//创建时间
	private Date updateTime;					//更新时间
	private String productType;					//业务品种(:tb_sys_product)
	private String conStatus;					//合同状态(:XD_SXCD8003)
	private String trusToPayFlg;				//受托支付标志
	private String stopPayFlg;					//止付标志
	private Integer specPaymentDate;			//指定还款日
	private BigDecimal exchangeRate;			//汇率	number(16,8)
	private BigDecimal rmbAmt;					//折算人民币金额	NUMBER(26,8)
	private BigDecimal conBalance;				//合同可用余额		NUMBER(26,8)
	private String cycleIndCon;					//合同是否循环(:XD_0002)	含义？？？
	private String repaymentType;				//还款方式(:XD_SXCD1162)
	private Date tkDate;						//提款期限	DATE
	private String holidayFlg;					//节假日标志
	private String mainGuarantyType;			//主要担保方式	(:CDZC0005)
	private String xyId;						//协议ID
	private String paperConNum;					//纸质合同编号
	private Integer internalDays;				//间隔天数	NUMBER(6)
	private String clsResult;					//风险分类结果(:XD_FLCD0001)
	private String ifDataMove;					//是否迁移数据
	private String firstRepayTerm;				//首次还款期次
	private BigDecimal conYuE;					//合同余额	NUMBER(26,8)
	private String payWay;						//资金支付方式(:CDXY0144)
	private String payDepend1;					//受托支付支付依据1
	private String payDepend2;					//受托支付支付依据2
	private String payDepend3;					//受托支付支付依据3
	private String prepaymentPenalty;			//提前还款是否收取违约金(:XD_0002)
	private BigDecimal prepayMakeupRate;		//提前还款补偿率	NUMBER(10,5)	不懂这个字段？？
	private BigDecimal leastPrepayAmount; 		//提前还款最低金额	NUMBER(26,8)
	private BigDecimal prepayJs;				//提前还款基数	NUMBER(26,8)		这个字段含义？？
	private BigDecimal bzjbl;					//保证金比例	NUMBER(10,5)
	private String crdCent;						//是否放贷中心发放
	private String applyModeType;				//申报模式(:XD_SXYW0003):01常规业务02低风险业务
	private String lowRiskBizType;				//低风险业务类别(:XD_SXYW0225)
	private String agriculLoans;				//是否长虹融单 XD_0002
	private BigDecimal conOccupy;				//		NUMBER(26,8)
	private String crdDtlId;
	private String creditMode;					//信誉模式？？？
	private String creditStatus;				//信誉状态
	private String jxhjId;
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getAmountDetailId() {
		return amountDetailId;
	}
	public void setAmountDetailId(String amountDetailId) {
		this.amountDetailId = amountDetailId;
	}
	public String getContractNum() {
		return contractNum;
	}
	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}
	public String getContractAddress() {
		return contractAddress;
	}
	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getOldContractId() {
		return oldContractId;
	}
	public void setOldContractId(String oldContractId) {
		this.oldContractId = oldContractId;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
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
		this.contractTerm = contractTerm;
	}
	public String getCycleUnit() {
		return cycleUnit;
	}
	public void setCycleUnit(String cycleUnit) {
		this.cycleUnit = cycleUnit;
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
		this.loanUse = loanUse;
	}
	public String getGuarantyType() {
		return guarantyType;
	}
	public void setGuarantyType(String guarantyType) {
		this.guarantyType = guarantyType;
	}
	public String getLoanTurn() {
		return loanTurn;
	}
	public void setLoanTurn(String loanTurn) {
		this.loanTurn = loanTurn;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
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
		this.productType = productType;
	}
	public String getConStatus() {
		return conStatus;
	}
	public void setConStatus(String conStatus) {
		this.conStatus = conStatus;
	}
	public String getTrusToPayFlg() {
		return trusToPayFlg;
	}
	public void setTrusToPayFlg(String trusToPayFlg) {
		this.trusToPayFlg = trusToPayFlg;
	}
	public String getStopPayFlg() {
		return stopPayFlg;
	}
	public void setStopPayFlg(String stopPayFlg) {
		this.stopPayFlg = stopPayFlg;
	}
	public Integer getSpecPaymentDate() {
		return specPaymentDate;
	}
	public void setSpecPaymentDate(Integer specPaymentDate) {
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
		this.cycleIndCon = cycleIndCon;
	}
	public String getRepaymentType() {
		return repaymentType;
	}
	public void setRepaymentType(String repaymentType) {
		this.repaymentType = repaymentType;
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
		this.holidayFlg = holidayFlg;
	}
	public String getMainGuarantyType() {
		return mainGuarantyType;
	}
	public void setMainGuarantyType(String mainGuarantyType) {
		this.mainGuarantyType = mainGuarantyType;
	}
	public String getXyId() {
		return xyId;
	}
	public void setXyId(String xyId) {
		this.xyId = xyId;
	}
	public String getPaperConNum() {
		return paperConNum;
	}
	public void setPaperConNum(String paperConNum) {
		this.paperConNum = paperConNum;
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
		this.clsResult = clsResult;
	}
	public String getIfDataMove() {
		return ifDataMove;
	}
	public void setIfDataMove(String ifDataMove) {
		this.ifDataMove = ifDataMove;
	}
	public String getFirstRepayTerm() {
		return firstRepayTerm;
	}
	public void setFirstRepayTerm(String firstRepayTerm) {
		this.firstRepayTerm = firstRepayTerm;
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
		this.payWay = payWay;
	}
	public String getPayDepend1() {
		return payDepend1;
	}
	public void setPayDepend1(String payDepend1) {
		this.payDepend1 = payDepend1;
	}
	public String getPayDepend2() {
		return payDepend2;
	}
	public void setPayDepend2(String payDepend2) {
		this.payDepend2 = payDepend2;
	}
	public String getPayDepend3() {
		return payDepend3;
	}
	public void setPayDepend3(String payDepend3) {
		this.payDepend3 = payDepend3;
	}
	public String getPrepaymentPenalty() {
		return prepaymentPenalty;
	}
	public void setPrepaymentPenalty(String prepaymentPenalty) {
		this.prepaymentPenalty = prepaymentPenalty;
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
		this.crdCent = crdCent;
	}
	public String getApplyModeType() {
		return applyModeType;
	}
	public void setApplyModeType(String applyModeType) {
		this.applyModeType = applyModeType;
	}
	public String getLowRiskBizType() {
		return lowRiskBizType;
	}
	public void setLowRiskBizType(String lowRiskBizType) {
		this.lowRiskBizType = lowRiskBizType;
	}
	public String getAgriculLoans() {
		return agriculLoans;
	}
	public void setAgriculLoans(String agriculLoans) {
		this.agriculLoans = agriculLoans;
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
		this.crdDtlId = crdDtlId;
	}
	public String getCreditMode() {
		return creditMode;
	}
	public void setCreditMode(String creditMode) {
		this.creditMode = creditMode;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	public String getJxhjId() {
		return jxhjId;
	}
	public void setJxhjId(String jxhjId) {
		this.jxhjId = jxhjId;
	}
	
	@Override
	public String toString() {
		return "TbConContractInfo [contractId=" + contractId + ", amountDetailId=" + amountDetailId + ", contractNum="
				+ contractNum + ", contractAddress=" + contractAddress + ", partyId=" + partyId + ", oldContractId="
				+ oldContractId + ", currencyCd=" + currencyCd + ", contractAmt=" + contractAmt + ", contractTerm="
				+ contractTerm + ", cycleUnit=" + cycleUnit + ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", contractDate=" + contractDate + ", loanUse=" + loanUse + ", guarantyType=" + guarantyType
				+ ", loanTurn=" + loanTurn + ", userNum=" + userNum + ", orgNum=" + orgNum + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", productType=" + productType + ", conStatus="
				+ conStatus + ", trusToPayFlg=" + trusToPayFlg + ", stopPayFlg=" + stopPayFlg + ", specPaymentDate="
				+ specPaymentDate + ", exchangeRate=" + exchangeRate + ", rmbAmt=" + rmbAmt + ", conBalance="
				+ conBalance + ", cycleIndCon=" + cycleIndCon + ", repaymentType=" + repaymentType + ", tkDate="
				+ tkDate + ", holidayFlg=" + holidayFlg + ", mainGuarantyType=" + mainGuarantyType + ", xyId=" + xyId
				+ ", paperConNum=" + paperConNum + ", internalDays=" + internalDays + ", clsResult=" + clsResult
				+ ", ifDataMove=" + ifDataMove + ", firstRepayTerm=" + firstRepayTerm + ", conYuE=" + conYuE
				+ ", payWay=" + payWay + ", payDepend1=" + payDepend1 + ", payDepend2=" + payDepend2 + ", payDepend3="
				+ payDepend3 + ", prepaymentPenalty=" + prepaymentPenalty + ", prepayMakeupRate=" + prepayMakeupRate
				+ ", leastPrepayAmount=" + leastPrepayAmount + ", prepayJs=" + prepayJs + ", bzjbl=" + bzjbl
				+ ", crdCent=" + crdCent + ", applyModeType=" + applyModeType + ", lowRiskBizType=" + lowRiskBizType
				+ ", agriculLoans=" + agriculLoans + ", conOccupy=" + conOccupy + ", crdDtlId=" + crdDtlId
				+ ", creditMode=" + creditMode + ", creditStatus=" + creditStatus + ", jxhjId=" + jxhjId + "]";
	}
	
}
