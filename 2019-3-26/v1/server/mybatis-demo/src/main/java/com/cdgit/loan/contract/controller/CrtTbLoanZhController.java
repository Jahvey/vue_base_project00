package com.cdgit.loan.contract.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.bean.CrtTbLoanZh;
import com.cdgit.loan.contract.message.PageBean;
import com.cdgit.loan.contract.service.CrtTbLoanZhServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * @author mch
 */
@RestController
@RequestMapping("/loanZh")
public class CrtTbLoanZhController {
	
	@Autowired
	CrtTbLoanZhServiceImpl loanZhService;
	
	@GetMapping("/getLoanAccInfoList")
	public PageBean queryLoanAccInfoList(@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="loanId",required=true)String loanId){
		HashMap<String,Object> map=new HashMap<>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("loanId", loanId);
		PageInfo<CrtTbLoanZh> queryloanZhList = loanZhService.queryloanZhService(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(queryloanZhList.getTotal());
		pageBean.setData(queryloanZhList.getList());
		return pageBean;
	}
	
	@GetMapping("/getOneLoanZhById")
	public CrtTbLoanZh getOneLoanZhById(String Id){
		return loanZhService.queryCrtTbLoanZhById(Id);
	}
	
//	@GetMapping("/getOneLoanZhById")
//	public HashMap<String,CrtTbLoanZh> getOneLoanZhById(String Id){
//		HashMap<String,CrtTbLoanZh> map = new HashMap<>();
//		
//		CrtTbLoanZh loanZh = loanZhService.queryCrtTbLoanZhById(Id);
//		map.put("loanZh", loanZh);
//		return map;
//	}
	
}
