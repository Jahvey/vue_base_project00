package com.cdgit.loan.ledger.pubquery.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.ledger.pubquery.resultbean.BorrowQueryResult;
import com.cdgit.loan.ledger.pubquery.resultbean.ChangeAfterLoanResult;
import com.cdgit.loan.ledger.pubquery.resultbean.CustRateInfoResult;
import com.cdgit.loan.ledger.pubquery.resultbean.DeclineLoanResult;
import com.cdgit.loan.ledger.pubquery.resultbean.DetailedHistoryResult;
import com.cdgit.loan.ledger.pubquery.resultbean.FixedQueryResult;
import com.cdgit.loan.ledger.pubquery.resultbean.FundUseLedgerResult;
import com.cdgit.loan.ledger.pubquery.resultbean.PostLoanInspectResult;
import com.cdgit.loan.ledger.pubquery.resultbean.QuarStateResult;
import com.cdgit.loan.ledger.pubquery.resultbean.RecognEnterpriseScaleResult;
import com.cdgit.loan.ledger.pubquery.resultbean.RepaymentPlanResult;
import com.cdgit.loan.ledger.pubquery.resultbean.RiskClassResult;
import com.cdgit.loan.ledger.pubquery.resultbean.TechProcessResult;
import com.cdgit.loan.ledger.pubquery.service.ChTbIrmInternalRatingApplyImpl;
import com.cdgit.loan.mycustomer.message.PageBean;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/pubQuery")
public class ChPubQueryController {
	@Autowired
	ChTbIrmInternalRatingApplyImpl chTbIrmInternalRatingApplyImpl;
	
	//客户评级查询
	@GetMapping("/queryCustRateInfo")
	public PageBean queryCustRateInfo(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgname",required=false) String orgname,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="generalAdjustRatingCd",required=false) String generalAdjustRatingCd){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("certNum", certNum);
		map.put("certType", certType);
		map.put("generalAdjustRatingCd", generalAdjustRatingCd);
		map.put("orgname", orgname);
		PageInfo<CustRateInfoResult> custRateInfoResultList =
				   chTbIrmInternalRatingApplyImpl.selectCustRate(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(custRateInfoResultList.getTotal());
		pageBean.setData(custRateInfoResultList.getList());
		return pageBean;
	}
	
	//风险分类查询
	@GetMapping("/queryRiskClass")
	public PageBean queryRiskClass(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="claMethod",required=false) String claMethod){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("certNum", certNum);
		map.put("certType", certType);
		map.put("claMethod", claMethod);
		map.put("orgNum", orgNum);
		PageInfo<RiskClassResult> riskClassResultList =
				   chTbIrmInternalRatingApplyImpl.selectRiskClass(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(riskClassResultList.getTotal());
		pageBean.setData(riskClassResultList.getList());
		return pageBean;
	}
	//贷后变更查询
	@GetMapping("/queryChangeAfterLoan")
	public PageBean queryChangeAfterLoan(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="contractNum",required=false) String contractNum,
			@RequestParam(value="summaryNum",required=false) String summaryNum,
			@RequestParam(value="loanChangeType",required=false) String loanChangeType){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("certNum", certNum);
		map.put("certType", certType);
		map.put("orgNum", orgNum);
		map.put("contractNum", contractNum);
		map.put("summaryNum", summaryNum);
		map.put("loanChangeType", loanChangeType);
		PageInfo<ChangeAfterLoanResult> changeAfterLoanResultList =
				   chTbIrmInternalRatingApplyImpl.selectChangeAfterLoan(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(changeAfterLoanResultList.getTotal());
		pageBean.setData(changeAfterLoanResultList.getList());
		return pageBean;
	}
	//贷后检查查询
	@GetMapping("/queryPostLoanInspect")
	public PageBean queryPostLoanInspect(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="type",required=false) String type,
			@RequestParam(value="userNum",required=false) String userNum){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("certNum", certNum);
		map.put("certType", certType);
		map.put("orgNum", orgNum);
		map.put("type", type);
		map.put("userNum", userNum);
		PageInfo<PostLoanInspectResult> postLoanInspectResultList =
				   chTbIrmInternalRatingApplyImpl.selectPostLoanInspect(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(postLoanInspectResultList.getTotal());
		pageBean.setData(postLoanInspectResultList.getList());
		return pageBean;
	}
	
	//拒贷查询
	@GetMapping("/queryDeclineLoan")
	public PageBean queryDeclineLoan(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="certType",required=false) String certType){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("certNum", certNum);
		map.put("certType", certType);
		map.put("orgNum", orgNum);
		PageInfo<DeclineLoanResult> declineLoanResultList =
				   chTbIrmInternalRatingApplyImpl.selectDeclineLoan(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(declineLoanResultList.getTotal());
		pageBean.setData(declineLoanResultList.getList());
		return pageBean;
	}
	
	//资金使用台账查询
	@GetMapping("/queryFundUseLedger")
	public PageBean queryFundUseLedger(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="payTime",required=false) String payTime){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("certNum", certNum);
		map.put("certType", certType);
		map.put("orgNum", orgNum);
		map.put("payTime", payTime);
		PageInfo<FundUseLedgerResult> fundUseLedgerResultList =
				   chTbIrmInternalRatingApplyImpl.selectFundUseLedger(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(fundUseLedgerResultList.getTotal());
		pageBean.setData(fundUseLedgerResultList.getList());
		return pageBean;
	}
	
	//还款计划查询
	@GetMapping("/queryRepaymentPlan")
	public PageBean queryRepaymentPlan(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="contractNum",required=false) String contractNum,
			@RequestParam(value="summaryNum",required=false) String summaryNum,
			@RequestParam(value="endDate",required=false) String endDate){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("certNum", certNum);
		map.put("certType", certType);
		map.put("orgNum", orgNum);
		map.put("contractNum", contractNum);
		map.put("summaryNum", summaryNum);
		map.put("endDate", endDate);
		PageInfo<RepaymentPlanResult> repaymentPlanResultList =
				   chTbIrmInternalRatingApplyImpl.selectRepaymentPlan(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(repaymentPlanResultList.getTotal());
		pageBean.setData(repaymentPlanResultList.getList());
		return pageBean;
	}
	//历史流水查询
	@GetMapping("/queryDetailedHistory")
	public PageBean queryDetailedHistory(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="contractNum",required=false) String contractNum,
			@RequestParam(value="summaryNum",required=false) String summaryNum,
			@RequestParam(value="rcvDate",required=false) String rcvDate){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("certNum", certNum);
		map.put("certType", certType);
		map.put("orgNum", orgNum);
		map.put("contractNum", contractNum);
		map.put("summaryNum", summaryNum);
		map.put("rcvDate", rcvDate);
		PageInfo<DetailedHistoryResult> detailedHistoryResultList =
				   chTbIrmInternalRatingApplyImpl.selectDetailedHistory(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(detailedHistoryResultList.getTotal());
		pageBean.setData(detailedHistoryResultList.getList());
		return pageBean;
	}
	
	//流程查询
	@GetMapping("/queryTechProcess")
	public PageBean queryTechProcess(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="cusName",required=false) String cusName,
			@RequestParam(value="createOrgNum",required=false) String createOrgNum,
			@RequestParam(value="createUserName",required=false) String createUserName,
			@RequestParam(value="bizType",required=false) String bizType,
			@RequestParam(value="createTime",required=false) String createTime){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("createOrgNum", createOrgNum);	
		map.put("createUserName", createUserName);
		map.put("bizType", bizType);
		map.put("cusName", cusName);
		map.put("createTime", createTime);
		PageInfo<TechProcessResult> techProcessResultList =
				   chTbIrmInternalRatingApplyImpl.selectTechProcess(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(techProcessResultList.getTotal());
		pageBean.setData(techProcessResultList.getList());
		return pageBean;
	}	
		
	//季度对账单查询
	@GetMapping("/queryQuarState")
	public PageBean queryQuarState(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="summaryNum",required=false) String summaryNum,
			@RequestParam(value="contractNum",required=false) String contractNum,
			@RequestParam(value="tsDate",required=false) String tsDate,
			@RequestParam(value="ifAccount",required=false) String ifAccount,
			@RequestParam(value="ifPrint",required=false) String ifPrint){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("userNum", userNum);	
		map.put("partyName", partyName);
		map.put("summaryNum", summaryNum);
		map.put("orgNum", orgNum);
		map.put("contractNum", contractNum);
		map.put("tsDate", tsDate);
		map.put("ifAccount", ifAccount);
		map.put("ifPrint", ifPrint);
		PageInfo<QuarStateResult> quarStateResultList =
				   chTbIrmInternalRatingApplyImpl.selectQuarState(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(quarStateResultList.getTotal());
		pageBean.setData(quarStateResultList.getList());
		return pageBean;
	}	
	
	//企业规模认定查询结果
	@GetMapping("/queryRecognEnterpriseScale")
	public PageBean queryRecognEnterpriseScale(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="certType",required=false) String certType){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("userNum", userNum);	
		map.put("partyName", partyName);
		map.put("certNum", certNum);
		map.put("orgNum", orgNum);
		map.put("certType", certType);
		PageInfo<RecognEnterpriseScaleResult> recognEnterpriseScaleResultList =
				   chTbIrmInternalRatingApplyImpl.selectRecognEnterpriseScale(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(recognEnterpriseScaleResultList.getTotal());
		pageBean.setData(recognEnterpriseScaleResultList.getList());
		return pageBean;
	}
	
	
	//1.借据信息查询 
	@GetMapping("/queryBorrowQuery")
	public PageBean queryBorrowQuery(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="loanSubject1",required=false) String loanSubject1,
			@RequestParam(value="contractNum",required=false) String contractNum,
			@RequestParam(value="summaryNum",required=false) String summaryNum,
			@RequestParam(value="summaryStatusCd",required=false) String summaryStatusCd,
			@RequestParam(value="summaryAmt",required=false) String summaryAmt,
			@RequestParam(value="jjye",required=false) String jjye,
			@RequestParam(value="beginDate",required=false) String beginDate,
			@RequestParam(value="endDate",required=false) String endDate){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("userNum", userNum);	
		map.put("partyName", partyName);
		map.put("orgNum", orgNum);
		map.put("loanSubject1", loanSubject1);	
		map.put("contractNum", contractNum);
		map.put("summaryNum", summaryNum);
		map.put("summaryStatusCd", summaryStatusCd);	
		map.put("summaryAmt", summaryAmt);
		map.put("jjye", jjye);
		map.put("beginDate", beginDate);	
		map.put("endDate", endDate);
		PageInfo<BorrowQueryResult> borrowQueryResultList =
				   chTbIrmInternalRatingApplyImpl.selectBorrowQuery(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(borrowQueryResultList.getTotal());
		pageBean.setData(borrowQueryResultList.getList());
		return pageBean;
	}
	
	//  2.贷款交易明细查询
	@GetMapping("/queryLoadDetail")
	public PageBean queryLoadDetail(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="contractNum",required=false) String contractNum,
			@RequestParam(value="summaryNum",required=false) String summaryNum){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("userNum", userNum);	
		map.put("partyName", partyName);
		map.put("orgNum", orgNum);
		map.put("contractNum", contractNum);
		map.put("summaryNum", summaryNum);
		PageInfo<BorrowQueryResult> borrowQueryResultList =
				   chTbIrmInternalRatingApplyImpl.selectLoadDetail(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(borrowQueryResultList.getTotal());
		pageBean.setData(borrowQueryResultList.getList());
		return pageBean;
	}
	
	//固定查询（表内）
	@GetMapping("/queryBnFixed")
	public PageBean queryBnFixed(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="orgNum",required=false) String orgNum){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("orgNum", orgNum);
		map.put("userNum", userNum);
		PageInfo<FixedQueryResult> fixedQueryResultList =
				   chTbIrmInternalRatingApplyImpl.selectBnFixed(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(fixedQueryResultList.getTotal());
		pageBean.setData(fixedQueryResultList.getList());
		return pageBean;
	}
	//固定查询（表外）
	@GetMapping("/queryBwFixed")
	public PageBean queryBwFixed(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="orgNum",required=false) String orgNum){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("orgNum", orgNum);
		map.put("userNum", userNum);
		PageInfo<FixedQueryResult> fixedQueryResultList =
				   chTbIrmInternalRatingApplyImpl.selectBwFixed(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(fixedQueryResultList.getTotal());
		pageBean.setData(fixedQueryResultList.getList());
		return pageBean;
	}
	
		
}
