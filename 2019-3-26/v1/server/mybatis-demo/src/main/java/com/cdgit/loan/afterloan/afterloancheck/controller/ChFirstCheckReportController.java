package com.cdgit.loan.afterloan.afterloancheck.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
import com.cdgit.loan.afterloan.afterloancheck.service.ChDailycheckServiceImpl;
import com.cdgit.loan.afterloan.afterloancheck.service.ChFirstCheckReportServiceImpl;
import com.cdgit.loan.afterloan.afterloancheck.service.ChTbAftFirstCheckServiceImpl;
import com.cdgit.loan.mycustomer.message.PageBean;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/firstCheckReport")
public class ChFirstCheckReportController {
	@Autowired
	ChFirstCheckReportServiceImpl chFirstCheckReportServiceImpl;
	
	//首次检查报告列表
	@GetMapping("/queryFirstCheckReport")
	public PageBean queryFirstCheckReport(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="summaryNum",required=false) String summaryNum,
			@RequestParam(value="reportNum",required=false) String reportNum
			){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("orgNum", orgNum);
		map.put("summaryNum", summaryNum);
		map.put("reportNum", reportNum);
		map.put("userNum", userNum);
		PageInfo<BorListResult> borListResultList=chFirstCheckReportServiceImpl.selectFirstCheckReport(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(borListResultList.getTotal());
		pageBean.setData(borListResultList.getList());
		return pageBean;
	}
	
}
