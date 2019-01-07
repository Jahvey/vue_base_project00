package com.cdgit.loan.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdgit.loan.contract.bean.TbLoanSummary;
import com.cdgit.loan.contract.service.LoanSummaryServiceImpl;


@Controller
@RequestMapping("/loanSummary")
public class LoanSummaryController {
	
	@Autowired
	private LoanSummaryServiceImpl loanSummaryServiceImpl;
	
	@RequestMapping("/getTbLoanSummaryByPrimaryKey")
	@ResponseBody
	public TbLoanSummary getTbLoanSummaryByPrimaryKey(String summaryId){
		return loanSummaryServiceImpl.selectByPrimaryKey(summaryId);
	}

}
