package com.cdgit.loan.contract.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.bean.CrtTbOrgAccRel;
import com.cdgit.loan.contract.message.PageBean;
import com.cdgit.loan.contract.service.CrtOrganizationServiceImpl;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/organization")
public class CrtOrganizationController {

	@Autowired
	CrtOrganizationServiceImpl organizationService;
	
	
	/**
	 * 分页
	 * @param pageNum：当前页
	 * @param pageSize：每页条数
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/searchOrgAccRelList")
	public PageBean getOrgAccRelList(@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="accOrgId",required=false)String accOrgId,
			@RequestParam(value="productId",required=false)String productId,
			@RequestParam(value="status",required=false)String status,
			@RequestParam(value="col1",required=false)String col1,
			@RequestParam(value="col2",required=false)String col2){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("accOrgId", accOrgId);
		map.put("productId", productId);
		map.put("status", status);
		map.put("col1", col1);
		map.put("col2", col2);
		PageInfo<CrtTbOrgAccRel> searchOrgAccRelList = organizationService.searchOrgAccRelList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(searchOrgAccRelList.getTotal());
		pageBean.setData(searchOrgAccRelList.getList());
		return pageBean;
	}
	
}
