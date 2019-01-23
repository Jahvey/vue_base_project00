package com.cdgit.loan.customerManage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.customerManage.bean.AdditiveInfo;
import com.cdgit.loan.customerManage.service.AdditiveInfoServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/customer/additiveInfo")
public class AdditiveInfoController {
	
	@Autowired
	AdditiveInfoServiceImpl additiveInfoService;
	
	/**
	 * 
	 * startPgae(页码，每页几条数据)
	 * @ResponseBody()将返回的page转换为json对象由页面的js进行解析	
	 * 查询附加信息分页列表
	 * <p>Title: findUser</p>  	
	 * <p>Description: </p>  	
	 * @param omOrganizationCriteria
	 * @return
	 */
	@PostMapping("/additiveInfoList")
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
		Map<String, Object> map = additiveInfoService.selectByPartyId(Integer.valueOf(pageNum), Integer.valueOf(pageSize), partyId);
		return map;
	}
	
	/**
	 * 新增附加信息
	 * 
	 * */
	@PostMapping("/addAdditiveInfo")
	@ResponseBody
	public Map<String, Object> addAdditiveInfo(@RequestBody AdditiveInfo additiveInfo) {
		Map<String, Object> map = additiveInfoService.addAdditiveInfo(additiveInfo);
		return map;
	}
	
	/**
	 * 删除附加信息
	 * 
	 * */
	@PostMapping("/deleteAdditiveInfo")
	@ResponseBody
	public Map<String, Object> deleteAdditiveInfo(@RequestBody Map<String, Object> params) {
		String id = "";
		if(params.get("id") != null){
			id = params.get("id").toString();
		}
		Map<String, Object> map = additiveInfoService.deleteByPrimaryKey(id);
		return map;
	}
	
	/**
	 * 编辑附加信息
	 * 
	 * */
	@PostMapping("/updateAdditiveInfo")
	@ResponseBody
	public Map<String, Object> updateAdditiveInfo(@RequestBody AdditiveInfo additiveInfo) {
		Map<String, Object> map = additiveInfoService.editAdditiveInfo(additiveInfo);
		return map;
	}
}
