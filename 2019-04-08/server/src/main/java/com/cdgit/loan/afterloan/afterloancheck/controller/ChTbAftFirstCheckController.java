package com.cdgit.loan.afterloan.afterloancheck.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.afterloan.afterloancheck.bean.ChTbAftFirstCheck;
import com.cdgit.loan.afterloan.afterloancheck.bean.ChTbLoanMoneyUse;
import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
import com.cdgit.loan.afterloan.afterloancheck.service.ChTbAftFirstCheckServiceImpl;
import com.cdgit.loan.mycustomer.message.PageBean;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/afterloancheck")
public class ChTbAftFirstCheckController {
	@Autowired
	ChTbAftFirstCheckServiceImpl chTbAftFirstCheckServiceImpl;
	
	//贷后首次检查借据列表查询
	@GetMapping("/queryBorList")
	public PageBean queryBorList(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="contractNum",required=false) String contractNum,
			@RequestParam(value="summaryNum",required=false) String summaryNum,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="certNum",required=false) String certNum
			){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("orgNum", orgNum);
		map.put("contractNum", contractNum);
		map.put("summaryNum", summaryNum);
		map.put("certType", certType);
		map.put("certNum", certNum);
		map.put("userNum", userNum);
		PageInfo<BorListResult> borListResultList=chTbAftFirstCheckServiceImpl.selectBorList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(borListResultList.getTotal());
		pageBean.setData(borListResultList.getList());
		return pageBean;
	}
	//授信资金使用用途列表
		@GetMapping("/queryMoneyUse")
		public PageBean queryMoneyUse(
				@RequestParam(value="pageNum",required=true) int pageNum,
				@RequestParam(value="pageSize",required=true) int pageSize,
				@RequestParam(value="firstCheckId",required=false) String firstCheckId,
				@RequestParam(value="checkStatus",required=false) String checkStatus
				){
			Map map=new HashMap<String,Object>();
			map.put("pageNum", pageNum);
			map.put("pageSize", pageSize);
			map.put("firstCheckId", firstCheckId);
			map.put("checkStatus", checkStatus);
			PageInfo<ChTbLoanMoneyUse> chTbLoanMoneyUseList=chTbAftFirstCheckServiceImpl.queryMoneyUse(map);
			PageBean pageBean=new PageBean();
			pageBean.setTotal(chTbLoanMoneyUseList.getTotal());
			pageBean.setData(chTbLoanMoneyUseList.getList());
			return pageBean;
		}
		
		@PostMapping("/addMoneyUse")
		public void addMoneyUse(@RequestBody ChTbLoanMoneyUse moneyUse){
			System.err.println("[addMoneyUse] "+moneyUse);
			chTbAftFirstCheckServiceImpl.insertMoneyUse(moneyUse);
		}
		//根据借据Id查询检查信息
		@GetMapping("/queryFirstCheckInfoBySummaryId")
		public ChTbAftFirstCheck queryFirstCheckInfoBySummaryId(@RequestParam(value="summaryId",required=true) String summaryId){
			ChTbAftFirstCheck checkInfo = 
					chTbAftFirstCheckServiceImpl.queryFirstCheckInfoBySummaryId(summaryId);
			return checkInfo;
			
		}
		
}
