package com.cdgit.loan.customerManage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.customerManage.bean.ImpornantEvent;
import com.cdgit.loan.customerManage.service.ImpornantEventServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/customer/impornantEvent")
public class ImpornantEventController {
	
	@Autowired
	ImpornantEventServiceImpl impornantEventService;
	
	/**
	 * 
	 * startPgae(页码，每页几条数据)
	 * @ResponseBody()将返回的page转换为json对象由页面的js进行解析	
	 * 查询重大事件分页列表
	 * <p>Title: findUser</p>  	
	 * <p>Description: </p>  	
	 * @param omOrganizationCriteria
	 * @return
	 */
	@PostMapping("/impornantEventList")
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
		Map<String, Object> map = impornantEventService.selectByPartyId(Integer.valueOf(pageNum), Integer.valueOf(pageSize), partyId);
		return map;
	}
	
	/**
	 * 新增重大事件
	 * 
	 * */
	@PostMapping("/addImpornantEvent")
	@ResponseBody
	public Map<String, Object> addimpornantEvent(@RequestBody ImpornantEvent impornantEvent) {
		Map<String, Object> map = impornantEventService.addImpornantEvent(impornantEvent);
		return map;
	}
	
	/**
	 * 删除重大事件
	 * 
	 * */
	@PostMapping("/deleteImpornantEvent")
	@ResponseBody
	public Map<String, Object> deleteimpornantEvent(@RequestBody Map<String, Object> params) {
		String importantEventId = "";
		if(params.get("importantEventId") != null){
			importantEventId = params.get("importantEventId").toString();
		}
		Map<String, Object> map = impornantEventService.deleteByPrimaryKey(importantEventId);
		return map;
	}
	
	/**
	 * 编辑重大事件
	 * 
	 * */
	@PostMapping("/updateImpornantEvent")
	@ResponseBody
	public Map<String, Object> updateImpornantEvent(@RequestBody ImpornantEvent impornantEvent) {
		Map<String, Object> map = impornantEventService.editImpornantEvent(impornantEvent);
		return map;
	}
}
