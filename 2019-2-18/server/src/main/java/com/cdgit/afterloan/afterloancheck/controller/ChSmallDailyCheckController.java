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
import com.cdgit.afterloan.afterloancheck.service.ChDailycheckServiceImpl;
import com.cdgit.afterloan.afterloancheck.service.ChMicCentreFirstCheckServiceImpl;
import com.cdgit.afterloan.afterloancheck.service.ChSmallDailyCheckServiceImpl;
import com.cdgit.afterloan.afterloancheck.service.ChTbAftFirstCheckServiceImpl;
import com.cdgit.loan.mycustomer.message.PageBean;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/smallDailyCheck")
public class ChSmallDailyCheckController {
	@Autowired
	ChSmallDailyCheckServiceImpl chSmallDailyCheckServiceImpl;
	
	//小贷中心首次检查 
	@GetMapping("/querySmallDailyCheck")
	public PageBean querySmallDailyCheck(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="middleCode",required=false) String middleCode,
			@RequestParam(value="certNum",required=false) String certNum
			){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("orgNum", orgNum);
		map.put("certType", certType);
		map.put("certNum", certNum);
		map.put("userNum", userNum);
		map.put("middleCode", middleCode);
		PageInfo<BorListResult> borListResultList=chSmallDailyCheckServiceImpl.selectSmallDailyCheck(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(borListResultList.getTotal());
		pageBean.setData(borListResultList.getList());
		return pageBean;
	}
	
}
