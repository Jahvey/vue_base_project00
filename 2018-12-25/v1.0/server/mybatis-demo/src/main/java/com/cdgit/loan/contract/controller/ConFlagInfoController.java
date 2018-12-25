package com.cdgit.loan.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.bean.ConFlagInfo;
import com.cdgit.loan.contract.service.ConFlagInfoServiceImpl;

/**
 * 综合协议授信信息表
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/conFlagInfo")
public class ConFlagInfoController {

	@Autowired
	ConFlagInfoServiceImpl conFlagInfoServiceImpl;
	
	@GetMapping("/selectByPrimaryKey")
	@ResponseBody
	public ConFlagInfo getselectByPrimaryKey(String flagId){
		return conFlagInfoServiceImpl.getselectByPrimaryKey(flagId);
	}
	
}
