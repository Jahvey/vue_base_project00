package com.cdgit.ledger.pubquery.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.ledger.pubquery.mapper.ChTbIrmInternalRatingApplyMapper;
import com.cdgit.ledger.pubquery.resultbean.BorrowQueryResult;
import com.cdgit.ledger.pubquery.resultbean.ChangeAfterLoanResult;
import com.cdgit.ledger.pubquery.resultbean.CustRateInfoResult;
import com.cdgit.ledger.pubquery.resultbean.DeclineLoanResult;
import com.cdgit.ledger.pubquery.resultbean.DetailedHistoryResult;
import com.cdgit.ledger.pubquery.resultbean.FixedQueryResult;
import com.cdgit.ledger.pubquery.resultbean.FundUseLedgerResult;
import com.cdgit.ledger.pubquery.resultbean.PostLoanInspectResult;
import com.cdgit.ledger.pubquery.resultbean.QuarStateResult;
import com.cdgit.ledger.pubquery.resultbean.RecognEnterpriseScaleResult;
import com.cdgit.ledger.pubquery.resultbean.RepaymentPlanResult;
import com.cdgit.ledger.pubquery.resultbean.RiskClassResult;
import com.cdgit.ledger.pubquery.resultbean.TechProcessResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChTbIrmInternalRatingApplyImpl {
	@Autowired
	ChTbIrmInternalRatingApplyMapper chTbIrmInternalRatingApplyMapper;
	
	//客户评级查询
	public PageInfo<CustRateInfoResult> selectCustRate(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CustRateInfoResult> custRateInfoResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectCustRate(map);
		PageInfo pageInfo = new PageInfo<>(custRateInfoResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//风险分类查询
	public PageInfo<RiskClassResult> selectRiskClass(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<RiskClassResult> riskClassResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectRiskClass(map);
		PageInfo pageInfo = new PageInfo<>(riskClassResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//贷后变更查询
	public PageInfo<ChangeAfterLoanResult> selectChangeAfterLoan(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<ChangeAfterLoanResult> changeAfterLoanResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectChangeAfterLoan(map);
		PageInfo pageInfo = new PageInfo<>(changeAfterLoanResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//贷后检查查询
	public PageInfo<PostLoanInspectResult> selectPostLoanInspect(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<PostLoanInspectResult> postLoanInspectResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectPostLoanInspect(map);
		PageInfo pageInfo = new PageInfo<>(postLoanInspectResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//贷后检查查询
	public PageInfo<DeclineLoanResult> selectDeclineLoan(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<DeclineLoanResult> declineLoanResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectDeclineLoan(map);
		PageInfo pageInfo = new PageInfo<>(declineLoanResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//资金使用台账查询
	public PageInfo<FundUseLedgerResult> selectFundUseLedger(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<FundUseLedgerResult> fundUseLedgerResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectFundUseLedger(map);
		PageInfo pageInfo = new PageInfo<>(fundUseLedgerResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//还款计划查询
	public PageInfo<RepaymentPlanResult> selectRepaymentPlan(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<RepaymentPlanResult> repaymentPlanResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectRepaymentPlan(map);
		PageInfo pageInfo = new PageInfo<>(repaymentPlanResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	//历史流水查询
	public PageInfo<DetailedHistoryResult> selectDetailedHistory(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<DetailedHistoryResult> detailedHistoryResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectDetailedHistory(map);
		PageInfo pageInfo = new PageInfo<>(detailedHistoryResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//流程查询
	public PageInfo<TechProcessResult> selectTechProcess(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<TechProcessResult> techProcessResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectTechProcess(map);
		PageInfo pageInfo = new PageInfo<>(techProcessResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	
	//季度对账单查询
	public PageInfo<QuarStateResult> selectQuarState(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<QuarStateResult> quarStateResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectQuarState(map);
		PageInfo pageInfo = new PageInfo<>(quarStateResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//企业规模认定查询结果
	public PageInfo<RecognEnterpriseScaleResult> selectRecognEnterpriseScale(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<RecognEnterpriseScaleResult> recognEnterpriseScaleResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectRecognEnterpriseScale(map);
		PageInfo pageInfo = new PageInfo<>(recognEnterpriseScaleResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//1.借据信息查询 
	public PageInfo<BorrowQueryResult> selectBorrowQuery(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<BorrowQueryResult> borrowQueryResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectBorrowQuery(map);
		PageInfo pageInfo = new PageInfo<>(borrowQueryResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//贷款交易明细查询
	public PageInfo<BorrowQueryResult> selectLoadDetail(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<BorrowQueryResult> borrowQueryResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectLoadDetail(map);
		PageInfo pageInfo = new PageInfo<>(borrowQueryResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	//固定查询（表内）
	public PageInfo<FixedQueryResult> selectBnFixed(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<FixedQueryResult> fixedQueryResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectBnFixed(map);
		PageInfo pageInfo = new PageInfo<>(fixedQueryResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	//固定查询（表外）
	public PageInfo<FixedQueryResult> selectBwFixed(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<FixedQueryResult> fixedQueryResultList = 
				                 chTbIrmInternalRatingApplyMapper.selectBwFixed(map);
		PageInfo pageInfo = new PageInfo<>(fixedQueryResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
}
