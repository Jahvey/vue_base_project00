package com.cdgit.loan.irm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.irm.bean.AdjustOption;
import com.cdgit.loan.irm.bean.IndexEntity;
import com.cdgit.loan.irm.bean.IrmCriteria;
import com.cdgit.loan.irm.bean.IrmInfoBean;
import com.cdgit.loan.irm.bean.IrmOverRecordInfo;
import com.cdgit.loan.irm.bean.NonFinancialPropertyInfo;
import com.cdgit.loan.irm.bean.ScoreBean;
import com.cdgit.loan.irm.bean.Selector;
import com.cdgit.loan.irm.bean.TbAccFinanceIndexData;
import com.cdgit.loan.irm.bean.TbIrmAdjustOptions;
import com.cdgit.loan.irm.bean.TbIrmFinancialInfo;
import com.cdgit.loan.irm.bean.TbIrmIndexCalc;
import com.cdgit.loan.irm.bean.TbIrmIndexScore;
import com.cdgit.loan.irm.bean.TbIrmModelIndex;
import com.cdgit.loan.irm.bean.TbIrmModelScale;
import com.cdgit.loan.irm.bean.TbIrmNonFinancialInfo;
import com.cdgit.loan.irm.bean.TbIrmRatingEngineCalc;
import com.cdgit.loan.irm.bean.TbIrmRatingFinIndex;
import com.cdgit.loan.irm.bean.TbIrmRatingIndexData;
import com.cdgit.loan.irm.bean.TbIrmRatingModel;
import com.cdgit.loan.irm.bean.TbIrmRatingPara;
import com.cdgit.loan.irm.bean.TbIrmScaleDef;
import com.cdgit.loan.irm.bean.irmReportNonFinanceInfo;
import com.cdgit.loan.mycustomer.corporation.bean.TbAccFinanceStatementData;

@Mapper
public interface IrmMapper {

	List<IrmInfoBean> queryPaginationIrm(IrmCriteria criteria);
	
	String getFinancedate(String iraApplyId);
	
	List<irmReportNonFinanceInfo> queryReportNonFinanceinfo(String iraApplyId);
	
	List<AdjustOption> queryOpitionInfo(String iraApplyId);
	
	List<IrmOverRecordInfo> queryOverRecordInfo(Map map);
	
	List<IrmOverRecordInfo> queryOverRecordInfo2(Map map);
	
	List<NonFinancialPropertyInfo> queryNonFinancialPropertyInfo(String applyId);
	
	List<TbIrmNonFinancialInfo> queryTbIrmNonFinancialInfo(Map map);
	
	int updateTbIrmNonFinancialInfo(TbIrmNonFinancialInfo tbIrmNonFinancialInfo);
	int insertTbIrmNonFinancialInfo(TbIrmNonFinancialInfo tbIrmNonFinancialInfo);
	List<TbIrmRatingModel> queryTbIrmRatingModelMap(Map map);
	
	List<TbIrmModelIndex> queryTbIrmModelIndexMap(Map map);
	
	List<TbIrmModelIndex> queryNonFinanceinfo(Map map);
	
	List<TbIrmIndexScore> queryTbIrmIndexScore(String indexId);
	
	List<TbIrmRatingFinIndex> queryTbIrmRatingFinIndexByApplyID(String applyId);
	List<TbIrmRatingFinIndex> queryTbIrmRatingFinIndex();
	List<TbIrmRatingPara> queryTbIrmRatingPara(Map map);
	
	TbIrmFinancialInfo queryTbIrmFinancialInfo(String applyId);
	int udateTbIrmFinancialInfo(TbIrmFinancialInfo tbIrmFinancialInfo);
	int insertTbIrmFinancialInfo(TbIrmFinancialInfo tbIrmFinancialInfo);
	
	int insertTbIrmRatingIndexData(TbIrmRatingIndexData tbIrmRatingIndexData);
	int deleteTbIrmRatingIndexDataByFinancialInfoId(String financialInfoId);
	List<TbAccFinanceIndexData> queryTbAccFinanceIndexData(String financeId);
	
	
	List<Selector> getModeScaleToCombobx(String modelTypeCd);
	
	List<TbAccFinanceStatementData> getFinanceIndexScore(String applyId);
	
	List<IndexEntity> getFinanceIndex(Map map);
	
	List<ScoreBean> getjlr(String applyId);
	List<ScoreBean> getyysr(String applyId);
	List<ScoreBean> getyysr1(String applyId);
	List<ScoreBean> getdbje(String applyId);
	
	List<TbIrmIndexScore> getNonFinanceIndexScore(String applyId);
	
	List<TbIrmModelScale> getModelScale(String modelId);
	
	List<TbIrmAdjustOptions> getMaxAdjustValue(String applyId);
	
	TbIrmScaleDef queryTbIrmScaleDef(Map map);
	
	Map getLoanMaxAndMinLevel();
	Map getNonLoanMaxAndMinLevel();
	
	int insertTbIrmRatingEngineCalc(TbIrmRatingEngineCalc tbIrmRatingEngineCalc);
	List<TbIrmRatingEngineCalc> queryTbIrmRatingEngineCalc(Map map);
	int insertTbIrmIndexCalc(TbIrmIndexCalc tbIrmIndexCalc);
	
    TbIrmAdjustOptions queryTbIrmAdjustOptions(String applyId);
    int updateTbIrmAdjustOptions(TbIrmAdjustOptions tbIrmAdjustOptions);
    int deleteTbIrmAdjustOptions(String applyId);
    int insertTbIrmAdjustOptions(TbIrmAdjustOptions tbIrmAdjustOptions);
    Map getRatingCd1(String applyId);
}
