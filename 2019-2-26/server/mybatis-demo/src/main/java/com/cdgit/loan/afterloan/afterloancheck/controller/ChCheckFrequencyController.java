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
import com.cdgit.loan.afterloan.afterloancheck.resultbean.CheckFrequencyResult;
import com.cdgit.loan.afterloan.afterloancheck.service.ChAfterLoanCheckRosterServiceImpl;
import com.cdgit.loan.afterloan.afterloancheck.service.ChBeforeMatCheckServiceImpl;
import com.cdgit.loan.afterloan.afterloancheck.service.ChCheckFrequencyServiceImpl;
import com.cdgit.loan.afterloan.afterloancheck.service.ChDailycheckServiceImpl;
import com.cdgit.loan.afterloan.afterloancheck.service.ChTbAftFirstCheckServiceImpl;
import com.cdgit.loan.mycustomer.message.PageBean;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/CheckFrequency")
public class ChCheckFrequencyController {
	@Autowired
	ChCheckFrequencyServiceImpl chCheckFrequencyServiceImpl;
	
	//贷后检查频率列表
	@GetMapping("/queryCheckFrequency")
	public PageBean queryCheckFrequency(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="creditRatingCd",required=false) String creditRatingCd,
			@RequestParam(value="classificationResultCd",required=false) String classificationResultCd,
			@RequestParam(value="isDifferentPlace",required=false) String isDifferentPlace,
			@RequestParam(value="warningLevelCd",required=false) String warningLevelCd,
			@RequestParam(value="setRate",required=false) String setRate,
			@RequestParam(value="listStatus",required=false) String listStatus
			){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("orgNum", orgNum);
		map.put("isDifferentPlace", isDifferentPlace);
		map.put("listStatus", listStatus);
		map.put("userNum", userNum);
		map.put("creditRatingCd", creditRatingCd);
		map.put("classificationResultCd", classificationResultCd);
		map.put("warningLevelCd", warningLevelCd);
		map.put("setRate", setRate);
		PageInfo<CheckFrequencyResult> checkFrequencyResultList = 
				chCheckFrequencyServiceImpl.selectCheckFrequency(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(checkFrequencyResultList.getTotal());
		pageBean.setData(checkFrequencyResultList.getList());
		return pageBean;
	}
	
}
