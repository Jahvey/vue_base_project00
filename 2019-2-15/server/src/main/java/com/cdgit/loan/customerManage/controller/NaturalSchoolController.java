package com.cdgit.loan.customerManage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.customerManage.bean.NaturalSchool;
import com.cdgit.loan.customerManage.service.NaturalSchoolServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/customer/naturalSchool")
public class NaturalSchoolController {
	
	@Autowired
	NaturalSchoolServiceImpl naturalSchoolService;
	
	/**
	 * 
	 * startPgae(页码，每页几条数据)
	 * @ResponseBody()将返回的page转换为json对象由页面的js进行解析	
	 * 查询高校信息分页列表
	 * <p>Title: findUser</p>  	
	 * <p>Description: </p>  	
	 * @param omOrganizationCriteria
	 * @return
	 */
	@PostMapping("/naturalSchoolList")
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
		Map<String, Object> map = naturalSchoolService.selectByPartyId(Integer.valueOf(pageNum), Integer.valueOf(pageSize), partyId);
		return map;
	}
	
	/**
	 * 新增高校信息
	 * 
	 * */
	@PostMapping("/addNaturalSchool")
	@ResponseBody
	public Map<String, Object> addnaturalSchool(@RequestBody NaturalSchool naturalSchool) {
		Map<String, Object> map = naturalSchoolService.addNaturalSchool(naturalSchool);
		return map;
	}
	
	/**
	 * 删除高校信息
	 * 
	 * */
	@PostMapping("/deleteNaturalSchool")
	@ResponseBody
	public Map<String, Object> deletenaturalSchool(@RequestBody Map<String, Object> params) {
		String schoolId = "";
		if(params.get("schoolId") != null){
			schoolId = params.get("schoolId").toString();
		}
		Map<String, Object> map = naturalSchoolService.deleteByPrimaryKey(schoolId);
		return map;
	}
	
	/**
	 * 编辑高校信息
	 * 
	 * */
	@PostMapping("/updateNaturalSchool")
	@ResponseBody
	public Map<String, Object> updatenaturalSchool(@RequestBody NaturalSchool naturalSchool) {
		Map<String, Object> map = naturalSchoolService.editNaturalSchool(naturalSchool);
		return map;
	}
}
