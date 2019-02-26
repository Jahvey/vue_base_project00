package com.cdgit.loan.contract.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.TbLoanSummary;
import com.cdgit.loan.contract.query.LoanSummaryInfoQuery;
import com.cdgit.loan.contract.query.SummaryViewQuery;

/**
 * 借据信息表	tb_loan_summary
 */
@Mapper
public interface CrtTbLoanSummaryMapper {
	
    /**
     * 根据主键查询一条数据
     * @param summaryId
     * @return
     */
    TbLoanSummary selectByPrimaryKey(String summaryId);
    
    /**
     * 	查询多条信息，可以传合同idString contractId
     * @return
     */
    List<LoanSummaryInfoQuery> selectTbLoanSummaryList(Map map);
    
    //根据借据id查询一条借据的详细信息
    SummaryViewQuery	querySummaryViewBySummaryId(String summaryId);
    
    //根据放款id查询借旧换新相关信息
    List<HashMap<String,String>> getIsJjhx(String loanId);
}