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
import com.cdgit.afterloan.afterloancheck.service.ChImportantCheckServiceImpl;
import com.cdgit.afterloan.afterloancheck.service.ChTbAftFirstCheckServiceImpl;
import com.cdgit.loan.mycustomer.message.PageBean;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/importantCheck")
public class ChImportantCheckController {
	@Autowired
	ChImportantCheckServiceImpl chImportantCheckServiceImpl;
	
	//重点常检查客户合同列表查询
	@GetMapping("/queryImportantCheck")
	public PageBean queryImportantCheck(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="contractNum",required=false) String contractNum,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="certNum",required=false) String certNum
			){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("orgNum", orgNum);
		map.put("contractNum", contractNum);
		map.put("certType", certType);
		map.put("certNum", certNum);
		map.put("userNum", userNum);
		PageInfo<BorListResult> borListResultList=chImportantCheckServiceImpl.selectImportantCheck(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(borListResultList.getTotal());
		pageBean.setData(borListResultList.getList());
		return pageBean;
	}
	
}
