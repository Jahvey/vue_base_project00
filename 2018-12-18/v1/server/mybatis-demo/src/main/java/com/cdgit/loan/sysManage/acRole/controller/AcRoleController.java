package com.cdgit.loan.sysManage.acRole.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.sysManage.acRole.bean.AcRole;
import com.cdgit.loan.sysManage.acRole.service.AcRoleServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/acRole")
public class AcRoleController {
	
	@Autowired
	AcRoleServiceImpl acRoleService;
		
	@PostMapping("/queryRoleById")
	@ResponseBody
	public AcRole selectByPrimaryKey(@RequestBody Map<String, Object> params) {
		String menuid = params.get("roleid").toString();
		return acRoleService.selectByPrimaryKey(menuid);
	}
	
	@PostMapping("queryAllRole")
	@ResponseBody
	public Map<String, Object> queryAllRole(@RequestBody Map<String, Object> params){
		String pageNum = "1";
		String pageSize = "20";
		String rolename = "";
		if(params.get("pageNum") != null){
			pageNum = params.get("pageNum").toString();
		}
		if(params.get("pageSize") != null){
			pageSize = params.get("pageSize").toString();
		}
		if (params.get("rolename") != null) {
			rolename = params.get("rolename").toString();
		}
		Map<String, Object> map = acRoleService.queryAllRole(Integer.valueOf(pageNum), Integer.valueOf(pageSize), rolename);
		return map;
	}	
	
	/**
	 * 新增菜单
	 * 
	 * *//*
	@PostMapping("/addMenu")
	@ResponseBody
	public Map<String, String> addMenu(@RequestBody AcRole menu) {
		Map<String, String> map = new HashMap<>();
		map = acRoleService.addMenu(menu);
		return map;
	}
	
	*//**
	 * 修改菜单信息
	 * 
	 * *//*
	@PostMapping("/editMenu")
	@ResponseBody
	public Map<String, String> editMenu(@RequestBody AcRole menu) {
		Map<String, String> map = new HashMap<>();
		map = acRoleService.editMenu(menu);
		return map;
	}
	
	*//**
	 * 删除菜单信息
	 * 
	 * *//*
	@PostMapping("/deleteMenu")
	@ResponseBody
	public Map<String, String> deleteMenu(@RequestBody Map<String, Object> params) {
		Map<String, String> map = new HashMap<>();
		String menuid = params.get("menuid").toString();
		map = acRoleService.deleteMenu(menuid);
		return map;
	}*/
	
}
