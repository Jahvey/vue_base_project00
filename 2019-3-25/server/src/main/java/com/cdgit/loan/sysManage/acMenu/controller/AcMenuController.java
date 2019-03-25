package com.cdgit.loan.sysManage.acMenu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.sysManage.acMenu.bean.AcMenu;
import com.cdgit.loan.sysManage.acMenu.service.AcMenuServiceImpl;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/acMenu")
public class AcMenuController {
	
	@Autowired
	AcMenuServiceImpl acMenuService;
		
	@PostMapping("/queryMenuById")
	@ResponseBody
	public AcMenu selectByPrimaryKey(@RequestBody Map<String, Object> params) {
		String menuid = params.get("menuid").toString();
		return acMenuService.selectByPrimaryKey(menuid);
	}
	
	@PostMapping("/queryMenuTreeByRole")
	@ResponseBody
	public Map<String, Object> queryMenuTreeByRole(@RequestBody Map<String, Object> params){
		Map<String, Object> map = new HashMap<>();
		String roleid = "";
		if(params.get("roleid") != null){
			roleid = params.get("roleid").toString();
		}
		if(StringUtils.isBlank(roleid)){
			map.put("code", "201");
			map.put("msg", "根据角色查询菜单树失败，角色编号不能为空");
			return map;
		}
		map = acMenuService.queryMenuTreeByRole(roleid);
		return map;
	}
	@PostMapping("/queryMenuTree")
	public Map<String, Object> queryMenuTree(){
		Map<String, Object> map = new HashMap<>();
		map = acMenuService.queryMenuTree();
		return map;
	}
	@PostMapping("queryMenuByParentsid")
	@ResponseBody
	public Map<String, Object> queryMenuByParentsid(@RequestBody Map<String, Object> params){
		String pageNum = "1";
		String pageSize = "20";
		String parentsid = "";
		if(params.get("pageNum") != null){
			pageNum = params.get("pageNum").toString();
		}
		if(params.get("pageSize") != null){
			pageSize = params.get("pageSize").toString();
		}
		if (params.get("parentsid") != null) {
			parentsid = params.get("parentsid").toString();
		}
		Map<String, Object> map = acMenuService.queryMenuByParentsid(Integer.valueOf(pageNum), Integer.valueOf(pageSize), parentsid);
		return map;
	}
	
	/**
	 * 新增菜单
	 * 
	 * */
	@PostMapping("/addMenu")
	@ResponseBody
	public Map<String, String> addMenu(@RequestBody AcMenu menu) {
		Map<String, String> map = new HashMap<>();
		map = acMenuService.addMenu(menu);
		return map;
	}
	
	/**
	 * 修改菜单信息
	 * 
	 * */
	@PostMapping("/editMenu")
	@ResponseBody
	public Map<String, String> editMenu(@RequestBody AcMenu menu) {
		Map<String, String> map = new HashMap<>();
		map = acMenuService.editMenu(menu);
		return map;
	}
	
	/**
	 * 删除菜单信息
	 * 
	 * */
	@PostMapping("/deleteMenu")
	@ResponseBody
	public Map<String, String> deleteMenu(@RequestBody Map<String, Object> params) {
		Map<String, String> map = new HashMap<>();
		String menuid = params.get("menuid").toString();
		map = acMenuService.deleteMenu(menuid);
		return map;
	}
	
}
