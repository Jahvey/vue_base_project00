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
import com.cdgit.loan.afterloan.riskclass.resultbean.HistoriyAdjustRecordResult;
import com.cdgit.loan.afterloan.riskclass.resultbean.QuarSmallNaturalResult;
import com.cdgit.loan.afterloan.riskclass.service.ChHistoriyAdjustRecordServiceImpl;
import com.cdgit.loan.afterloan.riskclass.service.ChQuarterAdjustServiceImpl;
import com.cdgit.loan.mycustomer.message.PageBean;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/RiskClassHistory")
public class ChHistoriyAdjustRecordController {
	@Autowired
	ChHistoriyAdjustRecordServiceImpl chHistoriyAdjustRecordServiceImpl;
	
	//风险分类-历史调整记录
	@GetMapping("/queryHistoriyAdjustRecord")
	public PageBean queryHistoriyAdjustRecord(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="contractNum",required=false) String contractNum
			){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("orgNum", orgNum);
		map.put("certType", certType);
		map.put("certNum", certNum);
		map.put("userNum", userNum);
		map.put("contractNum", contractNum);
		PageInfo<HistoriyAdjustRecordResult> historiyAdjustRecordResultList = 
				chHistoriyAdjustRecordServiceImpl.selectHistoriyAdjustRecord(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(historiyAdjustRecordResultList.getTotal());
		pageBean.setData(historiyAdjustRecordResultList.getList());
		return pageBean;
	}
	
}
