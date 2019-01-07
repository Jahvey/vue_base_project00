package com.cdgit.loan.contract.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.ConApvList;
import com.cdgit.loan.contract.bean.TbLoanSummary;
import com.cdgit.loan.contract.mapper.TbLoanSummaryMapper;
import com.cdgit.loan.user.bean.NaturealInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class LoanSummaryServiceImpl {

	@Autowired
	TbLoanSummaryMapper loanSummaryMapper;
	
	public TbLoanSummary selectByPrimaryKey(String summaryId){
		return loanSummaryMapper.selectByPrimaryKey(summaryId);
	}
	
}
