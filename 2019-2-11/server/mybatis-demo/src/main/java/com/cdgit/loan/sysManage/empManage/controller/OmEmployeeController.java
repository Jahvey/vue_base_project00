package com.cdgit.loan.sysManage.empManage.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.sysManage.empManage.bean.OmEmployee;
import com.cdgit.loan.sysManage.empManage.service.OmEmployeeServiceImpl;

import net.minidev.json.JSONArray;

@CrossOrigin
@RestController
@RequestMapping("/omEmployee")
public class OmEmployeeController {
	
	@Autowired
	OmEmployeeServiceImpl omEmployeeService;
		
	/**
	 * 
	 *startPgae(页码，每页几条数据)
	 *@ResponseBody()将返回的page转换为json对象由页面的js进行解析
	
	 * <p>Title: findUser</p>  
	
	 * <p>Description: </p>  
	
	 * @param omOrganizationCriteria
	 * @return
	 */
	@PostMapping("/queryEmployee")
	@ResponseBody
	public Map<String, Object> queryEmployee(@RequestBody Map<String, Object> params){
		String pageNum = "1";
		String pageSize = "20";
		String inorgid = "";
		String empcode = "";
		String empname = "";
		String orgname = "";
		String status = "";
		if(params.get("pageNum") != null){
			pageNum = params.get("pageNum").toString();
		}
		if(params.get("pageSize") != null){
			pageSize = params.get("pageSize").toString();
		}
		if(params.get("inorgid") != null){
			inorgid = params.get("inorgid").toString();
		}
		Long orgid = null;
		if (inorgid != null && !"".equals(inorgid)) {
		    orgid = Long.valueOf(inorgid);
		}
		if(params.get("empcode") != null){
			empcode = params.get("empcode").toString();
		}
		if(params.get("empname") != null){
			empname = params.get("empname").toString();
		}
		if(params.get("orgname") != null){
			orgname = params.get("orgname").toString();
		}
		if(params.get("status") != null){
			status = params.get("status").toString();
		}
		Map<String, Object> map = omEmployeeService.queryEmployee(Integer.valueOf(pageNum), Integer.valueOf(pageSize)
				, orgid, empcode, empname, orgname, status);
		return map;
	}
	
	/**
	 * 新增人员
	 * 
	 * */
	@PostMapping("/addEmp")
	@ResponseBody
	public Map<String, String> addEmp(@RequestBody OmEmployee emp) {
		Map<String, String> map = new HashMap<>();
		map = omEmployeeService.addEmp(emp);
		return map;
	}
	
	/**
	 * 修改人员信息
	 * 
	 * */
	@PostMapping("/editEmp")
	@ResponseBody
	public Map<String, String> editEmp(@RequestBody OmEmployee emp) {
		Map<String, String> map = new HashMap<>();
		map = omEmployeeService.editEmp(emp);
		return map;
	}
	
	/**
	 * 删除人员信息
	 * 
	 * */
	@PostMapping("/deleteEmp")
	@ResponseBody
	public Map<String, String> deleteEmp(@RequestBody Map<String, Object> params) {
		Map<String, String> map = new HashMap<>();
		String empid = params.get("empid").toString();
		map = omEmployeeService.deleteEmp(Long.valueOf(empid));
		return map;
	}

	@PostMapping("updateOperatorStatus")
	@ResponseBody
	public Map<String, String> updateOperatorStatus(@RequestBody Map<String, Object> params) {
		Map<String, String> map = new HashMap<>();
		String status = params.get("status").toString();
		String userid = params.get("userid").toString();
		map = omEmployeeService.updateOperatorStatus(status, userid);
		return map;
	}
	
	@PostMapping("insertOperatorRole")
	@ResponseBody
	public Map<String, Object> insertOperatorRole(@RequestBody Map<String, Object> params) {
		String operatorid = "";
		String orgid="";
		String[] roles = null;
		if(params.get("operatorid") != null){
			operatorid = params.get("operatorid").toString();
		}
		if(params.get("orgid") != null){
			orgid = params.get("orgid").toString();
		}
		if(params.get("roles") != null){
			roles = params.get("roles").toString().replaceAll(" ", "").replace("[", "").replace("]", "").split(",");
		}
		Map<String, Object> map = omEmployeeService.insertOperatorRole(orgid, operatorid, roles);
		
		return map;
	}
	
}
