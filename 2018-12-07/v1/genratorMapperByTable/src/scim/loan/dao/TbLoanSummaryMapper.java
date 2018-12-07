package scim.loan.dao;

import scim.loan.domain.TbLoanSummary;

public interface TbLoanSummaryMapper {
    int deleteByPrimaryKey(String summaryId);

    int insert(TbLoanSummary record);

    int insertSelective(TbLoanSummary record);

    TbLoanSummary selectByPrimaryKey(String summaryId);

    int updateByPrimaryKeySelective(TbLoanSummary record);

    int updateByPrimaryKey(TbLoanSummary record);
}