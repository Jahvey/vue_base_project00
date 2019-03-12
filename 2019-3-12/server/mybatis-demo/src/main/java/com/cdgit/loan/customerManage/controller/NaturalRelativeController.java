package com.cdgit.loan.customerManage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.customerManage.bean.NaturalRelative;
import com.cdgit.loan.customerManage.service.NaturalRelativeServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/customer/naturalRelative")
public class NaturalRelativeController {
	
	@Autowired
	NaturalRelativeServiceImpl naturalRelativeService;
	
	/**
	 * 
	 * startPgae(页码，每页几条数据)
	 * @ResponseBody()将返回的page转换为json对象由页面的js进行解析	
	 * 查询关系人信息分页列表
	 * <p>Title: findUser</p>  	
	 * <p>Description: </p>  	
	 * @param omOrganizationCriteria
	 * @return
	 */
	@PostMapping("/naturalRelativeList")
	@ResponseBody
	public Map<String, Object> selectByPartyId(@RequestBody Map<String, Object> params){
		String pageNum = "1";
		String pageSize = "20";
		String partyId = "";
		String cType = "";
		if(params.get("cType") != null){
			cType = params.get("cType").toString();
		}
		if(params.get("pageNum") != null){
			pageNum = params.get("pageNum").toString();
		}
		if(params.get("pageSize") != null){
			pageSize = params.get("pageSize").toString();
		}
		if(params.get("partyId") != null){
			partyId = params.get("partyId").toString();
		}
		Map<String, Object> map = naturalRelativeService.selectByPartyId(Integer.valueOf(pageNum), Integer.valueOf(pageSize), partyId, cType);
		return map;
	}
	
	/**
	 * 新增关系人信息
	 * 
	 * */
	@PostMapping("/addNaturalRelative")
	@ResponseBody
	public Map<String, Object> addnaturalRelative(@RequestBody NaturalRelative naturalRelative) {
		Map<String, Object> map = naturalRelativeService.addnaturalRelative(naturalRelative);
		return map;
	}
	
	/**
	 * 删除关系人信息
	 * 
	 * */
	@PostMapping("/deleteNaturalRelative")
	@ResponseBody
	public Map<String, Object> deletenaturalRelative(@RequestBody Map<String, Object> params) {
		String naturalRelativeId = "";
		String custType = "";
		if(params.get("naturalRelativeId") != null){
			naturalRelativeId = params.get("naturalRelativeId").toString();
		}
		if(params.get("custType") != null){
			custType = params.get("custType").toString();
		}
		Map<String, Object> map = naturalRelativeService.deleteByPrimaryKey(naturalRelativeId,custType);
		return map;
	}
	
	/**
	 * 编辑关系人信息
	 * 
	 * */
	@PostMapping("/updateNaturalRelative")
	@ResponseBody
	public Map<String, Object> updatenaturalRelative(@RequestBody NaturalRelative naturalRelative) {
		Map<String, Object> map = naturalRelativeService.editnaturalRelative(naturalRelative);
		return map;
	}
}
