package com.cdgit.loan.sysManage.orgManage.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.sysManage.orgManage.bean.OmOrganization;
import com.cdgit.loan.sysManage.orgManage.service.OmOrganizationServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/omOrg")
public class OmOrganizationController {
	
	@Autowired
	OmOrganizationServiceImpl omOrganizationService;
	
	/**
	 * 通过机构id查询机构
	 * 
	 * */
	@GetMapping("selectByPrimaryKey")
	public OmOrganization selectByPrimaryKey(Long orgid) {
		return omOrganizationService.selectByPrimaryKey(orgid);
	}
	/**
	 * 通过机构编码 和 名称查询机构
	 *startPgae(页码，每页几条数据)
	 *@ResponseBody()将返回的page转换为json对象由页面的js进行解析
	
	 * <p>Title: findUser</p>  
	
	 * <p>Description: </p>  
	
	 * @param omOrganizationCriteria
	 * @return
	 */
	@PostMapping("/queryOrgWithParams")
	@ResponseBody
	public Map<String, Object> queryOrgWithParams(@RequestBody Map<String, Object> params){
		String orgcode = "";
		String orgname = "";
		if (params.get("orgcode") != null) {
			orgcode = params.get("orgcode").toString();
		}
		if (params.get("orgname") != null) {
			orgname = params.get("orgname").toString();
		}
		Map<String, Object> map = omOrganizationService.queryOrgWithParams(orgcode, orgname);
		return map;
	}
	
	/**
	 * 查询所有机构
	 * 
	 * */
	@PostMapping("/queryOrg")
	@ResponseBody
	public Map<String, Object> queryOrg(@RequestBody Map<String, Object> params){
		String parentId = "";
		if (params.get("parentId") != null) {
			parentId = params.get("parentId").toString();
		}
		Map<String, Object> map = omOrganizationService.queryOrg(parentId);
		return map;
	}
	
	/**
	 * 新增机构
	 * 
	 * */
	@PostMapping("/addOrg")
	@ResponseBody
	public Map<String, String> addOrg(@RequestBody OmOrganization org) {
		Map<String, String> map = new HashMap<>();
		map = omOrganizationService.addOrg(org);
		return map;
	}
	
	/**
	 * 修改机构信息
	 * 
	 * */
	@PostMapping("/editOrg")
	@ResponseBody
	public Map<String, String> editOrg(@RequestBody OmOrganization org) {
		Map<String, String> map = new HashMap<>();
		map = omOrganizationService.editOrg(org);
		return map;
	}
	
	/**
	 * 根据id删除机构
	 * 
	 * */
	@PostMapping("/deleteOrg")
	@ResponseBody
	public Map<String, String> deleteOrg(@RequestBody Map<String, Object> params) {
		Map<String, String> map = new HashMap<>();
		String orgid = params.get("orgid").toString();
		map = omOrganizationService.deleteOrg(Long.valueOf(orgid));
		return map;
	}

}
