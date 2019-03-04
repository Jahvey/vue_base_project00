package com.cdgit.loan.sysManage.acRole.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.sysManage.acRole.bean.AcRole;
import com.cdgit.loan.sysManage.acRole.bean.AcRoleMenu;
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
	
	@PostMapping("/queryPaginationRole")
	@ResponseBody
	public Map<String, Object> queryPaginationRole(@RequestBody Map<String, Object> params){
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
	@PostMapping("/queryAllRole")
	public Map<String, Object> queryAllRole(){
		Map<String, Object> map = acRoleService.queryAllRole();
		return map;
	}
	/*@PostMapping("/getRolesByUserId")
	@ResponseBody
	public Map<String, Object> getRolesByUserId(@RequestBody Map<String, Object> params){
		Map<String, Object> map = new HashMap<String, Object>();
		String userId = "";
		if (params.get("userId") != null && !"".equals(params.get("userId").toString())) {
			userId = params.get("userId").toString();
			map = acRoleService.getRolesByUserId(userId);
		}else{
			map.put("code", "201");
			map.put("msg", "查询失败！用户号不能为空");
		}
		return map;
	}*/
	
	@PostMapping("/getRolesSelectBoxData")
	@ResponseBody
	public Map<String, Object> getRolesSelectBoxData(@RequestBody Map<String, Object> params){
		Map<String, Object> map = new HashMap<String, Object>();
		String userId = "";
		if (params.get("userId") != null && !"".equals(params.get("userId").toString())) {
			userId = params.get("userId").toString();
			map = acRoleService.getRolesSelectBoxData(userId);
		}else{
			map.put("code", "201");
			map.put("msg", "查询失败！用户号不能为空");
		}
		return map;
	}
	
	
	@PostMapping("/findRoleMenus")
	@ResponseBody
	public Map<String, Object> findRoleMenus(@RequestBody Map<String, Object> params){
		String roleId = "";
		if(params.get("roleId") != null){
			roleId = params.get("roleId").toString();
		}
		Map<String, Object> map = acRoleService.findRoleMenus(roleId);
		return map;
	}
	@PostMapping("/saveRoleMenus")
	@ResponseBody
	public Map<String, Object> saveRoleMenus(@RequestBody List<AcRoleMenu> params){
		
		Map<String, Object> map = acRoleService.addRoleMenus(params);
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
