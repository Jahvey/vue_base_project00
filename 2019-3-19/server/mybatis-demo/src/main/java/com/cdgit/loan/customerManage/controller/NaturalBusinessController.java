package com.cdgit.loan.customerManage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.customerManage.bean.NaturalBusiness;
import com.cdgit.loan.customerManage.service.NaturalBusinessServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/customer/naturalBusiness")
public class NaturalBusinessController {
	
	@Autowired
	NaturalBusinessServiceImpl NaturalBusinessService;
	
	/**
	 * 
	 * startPgae(页码，每页几条数据)
	 * @ResponseBody()将返回的page转换为json对象由页面的js进行解析	
	 * 查询经营信息分页列表
	 * <p>Title: findUser</p>  	
	 * <p>Description: </p>  	
	 * @param omOrganizationCriteria
	 * @return
	 */
	@PostMapping("/naturalBusinessList")
	@ResponseBody
	public Map<String, Object> selectByPartyId(@RequestBody Map<String, Object> params){
		String pageNum = "1";
		String pageSize = "20";
		String partyId = "";
		if(params.get("pageNum") != null){
			pageNum = params.get("pageNum").toString();
		}
		if(params.get("pageSize") != null){
			pageSize = params.get("pageSize").toString();
		}
		if(params.get("partyId") != null){
			partyId = params.get("partyId").toString();
		}
		Map<String, Object> map = NaturalBusinessService.selectByPartyId(Integer.valueOf(pageNum), Integer.valueOf(pageSize), partyId);
		return map;
	}
	
	/**
	 * 新增经营信息
	 * 
	 * */
	@PostMapping("/addNaturalBusiness")
	@ResponseBody
	public Map<String, Object> addNaturalBusiness(@RequestBody NaturalBusiness naturalBusiness) {
		Map<String, Object> map = NaturalBusinessService.addNaturalBusiness(naturalBusiness);
		return map;
	}
	
	/**
	 * 删除经营信息
	 * 
	 * */
	@PostMapping("/deleteNaturalBusiness")
	@ResponseBody
	public Map<String, Object> deleteNaturalBusiness(@RequestBody Map<String, Object> params) {
		String businessId = "";
		if(params.get("businessId") != null){
			businessId = params.get("businessId").toString();
		}
		Map<String, Object> map = NaturalBusinessService.deleteByPrimaryKey(businessId);
		return map;
	}
	
	/**
	 * 编辑经营信息
	 * 
	 * */
	@PostMapping("/updateNaturalBusiness")
	@ResponseBody
	public Map<String, Object> updateNaturalBusiness(@RequestBody NaturalBusiness naturalBusiness) {
		Map<String, Object> map = NaturalBusinessService.editNaturalBusiness(naturalBusiness);
		return map;
	}
}
