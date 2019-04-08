/**
 * 
 */
package com.cdgit.loan.csm.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.service.ConGrtServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@RestController
@RequestMapping("conGrt")
public class ConGrtController {

	@Autowired
	ConGrtServiceImpl conGrtServiceImpl;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getConGrtList")
	public PageBean getPrintCons(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="subcontractType",required=true)String subcontractType,
			
			@RequestParam(value="applyId",required=false)String applyId,
			@RequestParam(value="contractId",required=false)String contractId ){
		
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		
		map.put("subcontractType", subcontractType);
		map.put("applyId", applyId);
		map.put("contractId", contractId);
	
		PageInfo<HashMap<String, Object>> ApproveConsVo = conGrtServiceImpl.getConGrtList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(ApproveConsVo.getTotal());
		pageBean.setData(ApproveConsVo.getList());
		
		return pageBean;
	
		
	}
}
