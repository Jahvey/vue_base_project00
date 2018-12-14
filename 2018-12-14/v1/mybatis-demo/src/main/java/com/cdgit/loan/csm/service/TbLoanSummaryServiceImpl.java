package com.cdgit.loan.csm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.csm.bean.TbLoanSummary;
import com.cdgit.loan.csm.bean.TbLstInfo;
import com.cdgit.loan.csm.mapper.TbLoanSummaryMapper;

@Service
@org.springframework.transaction.annotation.Transactional
public class TbLoanSummaryServiceImpl {

	@Autowired
	TbLoanSummaryMapper tbLoanSummaryMapper;
	
	
	
	
	public TbLoanSummary selectByPrimaryKey(String summaryId){
		return tbLoanSummaryMapper.selectByPrimaryKey(summaryId);
	}

	
	
	
	
}
