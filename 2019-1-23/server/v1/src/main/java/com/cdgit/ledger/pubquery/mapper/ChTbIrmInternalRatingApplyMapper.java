package com.cdgit.ledger.pubquery.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

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
@Mapper
public interface ChTbIrmInternalRatingApplyMapper {
    //客户评级查询
	List<CustRateInfoResult> selectCustRate(Map map);
	//风险分类查询
	List<RiskClassResult> selectRiskClass(Map map);
	//贷后变更查询
	List<ChangeAfterLoanResult> selectChangeAfterLoan(Map map);
	//贷后检查查询
	List<PostLoanInspectResult> selectPostLoanInspect(Map map);
	//拒贷查询
	List<DeclineLoanResult> selectDeclineLoan(Map map);
	//资金使用台账查询
	List<FundUseLedgerResult> selectFundUseLedger(Map map);
	//还款计划查询
	List<RepaymentPlanResult> selectRepaymentPlan(Map map);
	//历史流水查询
	List<DetailedHistoryResult> selectDetailedHistory(Map map);	
	//历史流水查询
	List<TechProcessResult> selectTechProcess(Map map);
	//季度对账单查询
	List<QuarStateResult> selectQuarState(Map map);
	//企业规模认定查询结果
	List<RecognEnterpriseScaleResult> selectRecognEnterpriseScale(Map map);
	//借据信息查询
	List<BorrowQueryResult> selectBorrowQuery(Map map);
	//贷款交易明细查询
	List<BorrowQueryResult> selectLoadDetail(Map map);
	//固定查询（表内）
    List<FixedQueryResult> selectBnFixed(Map map);
    //固定查询（表外）
    List<FixedQueryResult> selectBwFixed(Map map);
    
}