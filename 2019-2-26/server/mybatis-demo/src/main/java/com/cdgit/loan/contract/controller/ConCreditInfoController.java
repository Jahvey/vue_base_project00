package com.cdgit.loan.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.bean.ConCreditInfo;
import com.cdgit.loan.contract.service.ConCreditInfoServiceImpl;

/**
 * 综合协议授信信息表
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/conCreditInfo")
public class ConCreditInfoController {

	@Autowired
	ConCreditInfoServiceImpl conCreditInfoServiceImpl;
	
	@GetMapping("/getConCreditInfoByContractId")
	public ConCreditInfo getConCreditInfoByContractId(String contractId){
		return conCreditInfoServiceImpl.getConCreditInfoByContractId(contractId);
	}
	
}
