package com.cdgit.loan.sysManage.position.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.sysManage.position.bean.OmPosition;
import com.cdgit.loan.sysManage.position.service.OmPositionServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/omPosition")
public class OmPositionController {
	
	@Autowired
	OmPositionServiceImpl omPositionService;
		
	/**
	 * 
	 *startPgae(页码，每页几条数据)
	 *@ResponseBody()将返回的page转换为json对象由页面的js进行解析
	
	 * <p>Title: findUser</p>  
	
	 * <p>Description: </p>  
	
	 * @param omOrganizationCriteria
	 * @return
	 */
	@PostMapping("/queryPosition")
	@ResponseBody
	public Map<String, Object> queryPosition(@RequestBody Map<String, Object> params){
		String pageNum = "1";
		String pageSize = "20";
		String posiname = "";
		if(params.get("pageNum") != null){
			pageNum = params.get("pageNum").toString();
		}
		if(params.get("pageSize") != null){
			pageSize = params.get("pageSize").toString();
		}
		if(params.get("posiname") != null){
			posiname = params.get("posiname").toString();
		}
		Map<String, Object> map = omPositionService.queryPositionInfo(Integer.valueOf(pageNum), Integer.valueOf(pageSize), posiname);
		return map;
	}
	
	/**
	 * 新增岗位
	 * 
	 * */
	@PostMapping("/addPosition")
	@ResponseBody
	public Map<String, String> addPosition(@RequestBody OmPosition position) {
		Map<String, String> map = new HashMap<>();
		map = omPositionService.addPosition(position);
		return map;
	}
	
	/**
	 * 修改岗位信息
	 * 
	 * */
	@PostMapping("/editPosition")
	@ResponseBody
	public Map<String, String> editPosition(@RequestBody OmPosition position) {
		Map<String, String> map = new HashMap<>();
		map = omPositionService.editPosition(position);
		return map;
	}
	
	/**
	 * 删除岗位信息
	 * 
	 * */
	@PostMapping("/deletePosition")
	@ResponseBody
	public Map<String, String> deletePosition(@RequestBody Map<String, Object> params) {
		Map<String, String> map = new HashMap<>();
		String positionid = params.get("positionid").toString();
		map = omPositionService.deletePosition(Long.valueOf(positionid));
		return map;
	}
	
}
