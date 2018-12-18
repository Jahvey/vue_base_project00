package com.cdgit.loan.sysManage.acMenu.controller;

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
	
	/**
	 * 
	 *startPgae(页码，每页几条数据)
	 *@ResponseBody()将返回的page转换为json对象由页面的js进行解析
	
	 * <p>Title: findUser</p>  
	
	 * <p>Description: </p>  
	
	 * @param omOrganizationCriteria
	 * @return
	 */
	@PostMapping("/queryMenuTree")
	@ResponseBody
	public Map<String, Object> queryPosition(){
		return acMenuService.queryMenuTree();
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
