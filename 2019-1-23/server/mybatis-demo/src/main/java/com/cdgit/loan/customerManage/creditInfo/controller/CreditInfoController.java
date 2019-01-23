package com.cdgit.loan.customerManage.creditInfo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.customerManage.creditInfo.bean.CreditInfo;
import com.cdgit.loan.customerManage.creditInfo.service.CreditInfoServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/customer/creditInfo")
public class CreditInfoController {
	
	@Autowired
	CreditInfoServiceImpl creditInfoService;
	
	/**
	 * 
	 * startPgae(页码，每页几条数据)
	 * @ResponseBody()将返回的page转换为json对象由页面的js进行解析	
	 * 查询信用信息分页列表
	 * <p>Title: findUser</p>  	
	 * <p>Description: </p>  	
	 * @param omOrganizationCriteria
	 * @return
	 */
	@PostMapping("/creditInfoList")
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
		Map<String, Object> map = creditInfoService.selectByPartyId(Integer.valueOf(pageNum), Integer.valueOf(pageSize), partyId);
		return map;
	}
	
	/**
	 * 新增信用信息
	 * 
	 * */
	@PostMapping("/addCreditInfo")
	@ResponseBody
	public Map<String, Object> addCreditInfo(@RequestBody CreditInfo creditInfo) {
		Map<String, Object> map = creditInfoService.addCreditInfo(creditInfo);
		return map;
	}
	
	/**
	 * 删除信用信息
	 * 
	 * */
	@PostMapping("/deleteCreditInfo")
	@ResponseBody
	public Map<String, Object> deleteCreditInfo(@RequestBody Map<String, Object> params) {
		String id = "";
		if(params.get("id") != null){
			id = params.get("id").toString();
		}
		Map<String, Object> map = creditInfoService.deleteByPrimaryKey(id);
		return map;
	}
	
	/**
	 * 编辑信用信息
	 * 
	 * */
	@PostMapping("/updateCreditInfo")
	@ResponseBody
	public Map<String, Object> updateCreditInfo(@RequestBody CreditInfo creditInfo) {
		Map<String, Object> map = creditInfoService.editCreditInfo(creditInfo);
		return map;
	}
}
