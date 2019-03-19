package com.cdgit.loan.contract.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.bean.TbLoanSummary;
import com.cdgit.loan.contract.message.PageBean;
import com.cdgit.loan.contract.query.LoanSummaryInfoQuery;
import com.cdgit.loan.contract.query.SummaryViewQuery;
import com.cdgit.loan.contract.service.CrtLoanSummaryServiceImpl;
import com.github.pagehelper.PageInfo;


@RestController
@RequestMapping("/loanSummary")
public class LoanSummaryController {
	
	@Autowired
	private CrtLoanSummaryServiceImpl loanSummaryServiceImpl;
	
	@GetMapping("/getTbLoanSummaryByPrimaryKey")
	public TbLoanSummary getTbLoanSummaryByPrimaryKey(String summaryId){
		return loanSummaryServiceImpl.selectByPrimaryKey(summaryId);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getLoanSummaryInfoList")
	public PageBean getLoanSummaryInfoList(@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="contractId",required=false)String contractId){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("contractId", contractId);
		PageInfo<LoanSummaryInfoQuery> loanSummaryInfo = loanSummaryServiceImpl.getLoanSummaryInfo(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(loanSummaryInfo.getTotal());
		pageBean.setData(loanSummaryInfo.getList());
		return pageBean;
	}
	
	@GetMapping("/getSummaryInfoBySummaryId")
	public SummaryViewQuery getSummaryInfoBySummaryId(String summaryId){
		return loanSummaryServiceImpl.getSummaryViewBySummaryId(summaryId);
	}
	
}
