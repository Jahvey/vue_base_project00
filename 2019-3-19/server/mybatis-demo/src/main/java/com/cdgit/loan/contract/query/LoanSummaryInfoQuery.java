package com.cdgit.loan.contract.query;

/**
 * 查询基本借据信息 tb_loan_info t, tb_loan_summary ta , tb_loan_loanrate r
 * 
 * @author Administrator
 *
 */
public class LoanSummaryInfoQuery {
	private String loanId;				// t：放款主键
	private String summaryId;			// ta：借款主键
	private String jjye;				// ta：借据余额
	private String summaryAmt;			// ta：借据金额
	private String productType;			// t：业务品种(:tb_sys_product)
	private String summaryCurrencyCd;	// ta：借据币种
	private String summaryStatusCd;		// ta：借据状态(:XD_SXYW0226)
	private String summaryNum;			// ta：借据编号
	private String orgNum;				// ta：经办机构
	private String userNum;				// ta：经办人
	private String partyId;				// ta：客户id
	private String yearRate;			// r：申请利率
	private String beginDate;			// ta：
	private String endDate;				// ta：
	private String rcnStan;				// ta对账流水号：
	private String nftNo;				// ta通知书编号：
	private String trusToPayFlg;		// t：受托支付标志(:XD_0002)

	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public String getSummaryId() {
		return summaryId;
	}
	public void setSummaryId(String summaryId) {
		this.summaryId = summaryId;
	}
	public String getJjye() {
		return jjye;
	}
	public void setJjye(String jjye) {
		this.jjye = jjye;
	}
	public String getSummaryAmt() {
		return summaryAmt;
	}
	public void setSummaryAmt(String summaryAmt) {
		this.summaryAmt = summaryAmt;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getSummaryCurrencyCd() {
		return summaryCurrencyCd;
	}
	public void setSummaryCurrencyCd(String summaryCurrencyCd) {
		this.summaryCurrencyCd = summaryCurrencyCd;
	}
	public String getSummaryStatusCd() {
		return summaryStatusCd;
	}
	public void setSummaryStatusCd(String summaryStatusCd) {
		this.summaryStatusCd = summaryStatusCd;
	}
	public String getSummaryNum() {
		return summaryNum;
	}
	public void setSummaryNum(String summaryNum) {
		this.summaryNum = summaryNum;
	}
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getYearRate() {
		return yearRate;
	}
	public void setYearRate(String yearRate) {
		this.yearRate = yearRate;
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
	public String getRcnStan() {
		return rcnStan;
	}
	public void setRcnStan(String rcnStan) {
		this.rcnStan = rcnStan;
	}
	public String getNftNo() {
		return nftNo;
	}
	public void setNftNo(String nftNo) {
		this.nftNo = nftNo;
	}
	public String getTrusToPayFlg() {
		return trusToPayFlg;
	}
	public void setTrusToPayFlg(String trusToPayFlg) {
		this.trusToPayFlg = trusToPayFlg;
	}
	
	

}
