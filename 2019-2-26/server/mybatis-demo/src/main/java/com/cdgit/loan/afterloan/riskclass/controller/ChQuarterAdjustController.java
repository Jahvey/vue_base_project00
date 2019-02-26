package com.cdgit.loan.afterloan.riskclass.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
import com.cdgit.loan.afterloan.afterloancheck.service.ChAfterLoanCheckRosterServiceImpl;
import com.cdgit.loan.afterloan.afterloancheck.service.ChBeforeMatCheckServiceImpl;
import com.cdgit.loan.afterloan.afterloancheck.service.ChDailycheckServiceImpl;
import com.cdgit.loan.afterloan.afterloancheck.service.ChTbAftFirstCheckServiceImpl;
import com.cdgit.loan.afterloan.riskclass.resultbean.QuarSmallNaturalResult;
import com.cdgit.loan.afterloan.riskclass.service.ChQuarterAdjustServiceImpl;
import com.cdgit.loan.mycustomer.message.PageBean;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/RiskClassQuar")
public class ChQuarterAdjustController {
	@Autowired
	ChQuarterAdjustServiceImpl chQuarterAdjustServiceImpl;
	
	//风险分类-季度调整-小企业自然人/非小企业自然人
	@GetMapping("/queryQuarSmallNatural")
	public PageBean queryQuarSmallNatural(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="custtype",required=false) String custtype
			){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("orgNum", orgNum);
		map.put("certType", certType);
		map.put("certNum", certNum);
		map.put("userNum", userNum);
		map.put("custtype", custtype);
		PageInfo<QuarSmallNaturalResult> quarSmallNaturalResultList = 
				chQuarterAdjustServiceImpl.selectQuarSmallNatural(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(quarSmallNaturalResultList.getTotal());
		pageBean.setData(quarSmallNaturalResultList.getList());
		return pageBean;
	}
	
}
