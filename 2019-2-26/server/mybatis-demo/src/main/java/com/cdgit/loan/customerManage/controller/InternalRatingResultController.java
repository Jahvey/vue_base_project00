package com.cdgit.loan.customerManage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.customerManage.service.InternalRatingResultServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/customer/internalRatingResult")
public class InternalRatingResultController {
	
	@Autowired
	InternalRatingResultServiceImpl internalRatingResultService;
	
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
	@PostMapping("/internalRatingResultList")
	@ResponseBody
	public Map<String, Object> selectByPartyId(@RequestBody Map<String, Object> params){
		String pageNum = "1";
		String pageSize = "20";
		String partyId = "";
		String userNum = "";
		String orgNum = "";
		String thirdPartyTypeCd = "";
		if(params.get("pageNum") != null){
			pageNum = params.get("pageNum").toString();
		}
		if(params.get("pageSize") != null){
			pageSize = params.get("pageSize").toString();
		}
		if(params.get("partyId") != null){
			partyId = params.get("partyId").toString();
		}
		if(params.get("curUserNum") != null){
			userNum = params.get("curUserNum").toString();
		}
		if(params.get("orgcode") != null){
			orgNum = params.get("orgcode").toString();
		}
		if(params.get("thirdPartyTypeCd") != null){
			thirdPartyTypeCd = params.get("thirdPartyTypeCd").toString();
		}
		Map<String, Object> map = internalRatingResultService.getdbjreslt(Integer.valueOf(pageNum), Integer.valueOf(pageSize)
				, partyId, userNum, orgNum, thirdPartyTypeCd);
		return map;
	}

}
