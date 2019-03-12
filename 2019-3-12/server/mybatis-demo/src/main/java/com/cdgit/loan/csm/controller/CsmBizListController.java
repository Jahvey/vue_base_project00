/**
 * 
 */
package com.cdgit.loan.csm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.service.CsmBizListServiceImpl;

/**
 * @author cwalk
 *
 */
@RestController
@RequestMapping("bizSql")
public class CsmBizListController {
	
	@Autowired
	CsmBizListServiceImpl csmBizListServiceImpl;
	
	@PostMapping("/getBizList")
	public Map<String, Object> getBizList(@RequestBody Map<String, Object> params){
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
		Map<String, Object> map = csmBizListServiceImpl.getBizList(Integer.valueOf(pageNum), Integer.valueOf(pageSize), partyId);
		
		return map;
	
		
	}
	
	/**
	 * 重算额度
	 * 
	 * 
	 * */
	@PostMapping("/newly")
	public Map<String, Object> newly(@RequestBody Map<String, Object> params){
		String 	bizId = "";
		if(params.get("bizId") != null){
			bizId = params.get("bizId").toString();
		}
		Map<String, Object> map = csmBizListServiceImpl.newly(bizId);
		
		return map;
	
		
	}

}
