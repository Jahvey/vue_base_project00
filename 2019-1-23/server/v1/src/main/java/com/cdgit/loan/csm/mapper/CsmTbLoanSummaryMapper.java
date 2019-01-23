package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbLoanSummaryPo;

@Mapper
public interface CsmTbLoanSummaryMapper {
	
	
	TbLoanSummaryPo queryOneTbLoanSummaryBySummaryId(String summaryId);

}