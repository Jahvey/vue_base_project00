package com.cdgit.loan.csm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.bean.TbLoanSummary;
import com.cdgit.loan.csm.service.TbLoanSummaryServiceImpl;

@RestController
@RequestMapping("/TbLoanSummary")
public class TbLoanSummaryController {
	
	@Autowired
	TbLoanSummaryServiceImpl tbLoanSummaryServiceImpl;
	
	
	@GetMapping("/selectByPrimaryKey")
	public  TbLoanSummary selectByPrimaryKey(@RequestParam("summaryId") String summaryId) {
		return  tbLoanSummaryServiceImpl.selectByPrimaryKey(summaryId);
	}

}
