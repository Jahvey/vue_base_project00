package com.cdgit.loan.contract.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.bean.ConApvList;
import com.cdgit.loan.contract.bean.TbConContractInfo;
import com.cdgit.loan.contract.message.PageBean;
import com.cdgit.loan.contract.service.ConContractInfoServiceImpl;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/conContractInfo")
public class ConContractInfoController {

	@Autowired
	ConContractInfoServiceImpl conContractInfoServiceImpl;
	
	@GetMapping("/getTbConContractInfoById")
	public TbConContractInfo getTbConContractInfoById(String contractId){
		return conContractInfoServiceImpl.getTbCsmNaturalPersonById(contractId);
	}
	
	/**
	 * 分页
	 * @param pageNum：当前页
	 * @param pageSize：每页条数
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/queryConApvList")
	public PageBean queryConApvList(@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			String partyName){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);
		PageInfo<ConApvList> conApvList = conContractInfoServiceImpl.queryConApvList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(conApvList.getTotal());
		pageBean.setData(conApvList.getList());
		return pageBean;
	}
	
}
