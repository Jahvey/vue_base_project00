package com.cdgit.loan.contract.controller;

import java.util.HashMap;

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
	public ConFlagInfo getselectByPrimaryKey(String flagId){
		return conFlagInfoServiceImpl.getselectByPrimaryKey(flagId);
	}
	
	@GetMapping("/getSomeThing")
	public HashMap<String,String> getSomeThing(String flagId){
		return conFlagInfoServiceImpl.getSomeThing(flagId);
	}
	
}
