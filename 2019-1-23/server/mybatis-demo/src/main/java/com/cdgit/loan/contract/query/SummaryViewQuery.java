package com.cdgit.loan.contract.query;

/**
 * 查看借据	summary_view
 */
public class SummaryViewQuery {
	
	private String summaryNum;			//借据编号		tb_loan_summary
	private String billNo;				//票据号			Tb_Loan_Hp_Amt
	private String ywbh;				//业务号码		tb_loan_summary
	private String loanNum;				//放款通知书编号	tb_loan_info
	private String summaryStatusCd;		//借据状态		tb_loan_summary
	private String productType;			//业务品种		tb_loan_info
	private String loanSubject1;		//业务别(贷款科目)	tb_loan_info
	private String summaryCurrencyCd;	//币种			tb_loan_summary
	private String summaryAmt;			//借据金额		tb_loan_summary		BigDecimal
	private String beginDate;			//起始日			tb_loan_summary		Date
	private String endDate;				//到期日			tb_loan_summary		Date
	private String repayType;			//还款方式		tb_loan_info
	private String specPaymentDate;		//约定还款日		tb_loan_info		Short
	private String zh;					//还款账号		Tb_Loan_Zh
	private String rateType;			//利率类型		tb_loan_loanrate
	private String floatWay;			//浮动方式		tb_loan_loanrate
	private String rateFloatProportion;	//浮动比例(%)		tb_loan_loanrate	BigDecimal
	private String yearRate;			//利率(%)		tb_loan_loanrate	BigDecimal
	private String irUpdateFrequency;	//利率调整方式		tb_loan_loanrate
	private String interestCollectType;	//结息周期		tb_loan_loanrate
	private String holidayFlg;			//节假日顺延标志	tb_loan_loanrate
	private String holidayIntFlg;		//节假日利息处理方式	tb_loan_loanrate
	private String loanOrg;				//出账机构		tb_loan_info
	private String userNum;				//经办人			tb_loan_info
	private String orgNum;				//经办机构		tb_loan_info
	
	public String getSummaryNum() {
		return summaryNum;
	}
	public void setSummaryNum(String summaryNum) {
		this.summaryNum = summaryNum;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getYwbh() {
		return ywbh;
	}
	public void setYwbh(String ywbh) {
		this.ywbh = ywbh;
	}
	public String getLoanNum() {
		return loanNum;
	}
	public void setLoanNum(String loanNum) {
		this.loanNum = loanNum;
	}
	public String getSummaryStatusCd() {
		return summaryStatusCd;
	}
	public void setSummaryStatusCd(String summaryStatusCd) {
		this.summaryStatusCd = summaryStatusCd;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getLoanSubject1() {
		return loanSubject1;
	}
	public void setLoanSubject1(String loanSubject1) {
		this.loanSubject1 = loanSubject1;
	}
	public String getSummaryCurrencyCd() {
		return summaryCurrencyCd;
	}
	public void setSummaryCurrencyCd(String summaryCurrencyCd) {
		this.summaryCurrencyCd = summaryCurrencyCd;
	}
	public String getSummaryAmt() {
		return summaryAmt;
	}
	public void setSummaryAmt(String summaryAmt) {
		this.summaryAmt = summaryAmt;
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
	public String getRepayType() {
		return repayType;
	}
	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}
	public String getSpecPaymentDate() {
		return specPaymentDate;
	}
	public void setSpecPaymentDate(String specPaymentDate) {
		this.specPaymentDate = specPaymentDate;
	}
	public String getZh() {
		return zh;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	public String getFloatWay() {
		return floatWay;
	}
	public void setFloatWay(String floatWay) {
		this.floatWay = floatWay;
	}
	public String getRateFloatProportion() {
		return rateFloatProportion;
	}
	public void setRateFloatProportion(String rateFloatProportion) {
		this.rateFloatProportion = rateFloatProportion;
	}
	public String getYearRate() {
		return yearRate;
	}
	public void setYearRate(String yearRate) {
		this.yearRate = yearRate;
	}
	public String getIrUpdateFrequency() {
		return irUpdateFrequency;
	}
	public void setIrUpdateFrequency(String irUpdateFrequency) {
		this.irUpdateFrequency = irUpdateFrequency;
	}
	public String getInterestCollectType() {
		return interestCollectType;
	}
	public void setInterestCollectType(String interestCollectType) {
		this.interestCollectType = interestCollectType;
	}
	public String getHolidayFlg() {
		return holidayFlg;
	}
	public void setHolidayFlg(String holidayFlg) {
		this.holidayFlg = holidayFlg;
	}
	public String getHolidayIntFlg() {
		return holidayIntFlg;
	}
	public void setHolidayIntFlg(String holidayIntFlg) {
		this.holidayIntFlg = holidayIntFlg;
	}
	public String getLoanOrg() {
		return loanOrg;
	}
	public void setLoanOrg(String loanOrg) {
		this.loanOrg = loanOrg;
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
	
}
