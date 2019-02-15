package com.cdgit.afterloan.afterloancheck.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.afterloan.afterloancheck.resultbean.BorListResult;
import com.cdgit.afterloan.afterloancheck.service.ChDailyCheckReportServiceImpl;
import com.cdgit.afterloan.afterloancheck.service.ChDailycheckServiceImpl;
import com.cdgit.afterloan.afterloancheck.service.ChFirstCheckReportServiceImpl;
import com.cdgit.afterloan.afterloancheck.service.ChTbAftFirstCheckServiceImpl;
import com.cdgit.loan.mycustomer.message.PageBean;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/dailyCheckReport")
public class ChDailyCheckReportController {
	@Autowired
	ChDailyCheckReportServiceImpl chDailyCheckReportServiceImpl;
	
	//日常检查报告列表
	@GetMapping("/queryDailyCheckReport")
	public PageBean queryDailyCheckReport(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="reportNum",required=false) String reportNum
			){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("orgNum", orgNum);
		map.put("reportNum", reportNum);
		map.put("userNum", userNum);
		PageInfo<BorListResult> borListResultList=chDailyCheckReportServiceImpl.selectDailyCheckReport(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(borListResultList.getTotal());
		pageBean.setData(borListResultList.getList());
		return pageBean;
	}
	
}
