package com.cdgit.loan.customerManage.entrustAccount.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.customerManage.entrustAccount.bean.EntrustAccount;
import com.cdgit.loan.customerManage.entrustAccount.service.EntrustAccountServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/customer/entrustAccount")
public class EntrustAccountController {
	
	@Autowired
	EntrustAccountServiceImpl entrustAccountService;
	
	/**
	 * 
	 * startPgae(页码，每页几条数据)
	 * @ResponseBody()将返回的page转换为json对象由页面的js进行解析	
	 * 查询委托方账户信息分页列表
	 * <p>Title: findUser</p>  	
	 * <p>Description: </p>  	
	 * @param omOrganizationCriteria
	 * @return
	 */
	@PostMapping("/entrustAccountList")
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
		Map<String, Object> map = entrustAccountService.selectByPartyId(Integer.valueOf(pageNum), Integer.valueOf(pageSize), partyId);
		return map;
	}
	
	/**
	 * 新增委托方账户信息
	 * 
	 * */
	@PostMapping("/addEntrustAccount")
	@ResponseBody
	public Map<String, Object> addEntrustAccount(@RequestBody EntrustAccount entrustAccount) {
		Map<String, Object> map = entrustAccountService.addEntrustAccount(entrustAccount);
		return map;
	}
	
	/**
	 * 删除委托方账户信息
	 * 
	 * */
	@PostMapping("/deleteEntrustAccount")
	@ResponseBody
	public Map<String, Object> deleteEntrustAccount(@RequestBody Map<String, Object> params) {
		String accId = "";
		if(params.get("accId") != null){
			accId = params.get("accId").toString();
		}
		Map<String, Object> map = entrustAccountService.deleteByPrimaryKey(accId);
		return map;
	}
	
	/**
	 * 编辑委托方账户信息
	 * 
	 * */
	@PostMapping("/updateEntrustAccount")
	@ResponseBody
	public Map<String, Object> updateEntrustAccount(@RequestBody EntrustAccount entrustAccount) {
		Map<String, Object> map = entrustAccountService.editEntrustAccount(entrustAccount);
		return map;
	}
}
