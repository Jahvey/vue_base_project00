package com.cdgit.loan.csm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.bean.TbConContractInfo;
import com.cdgit.loan.csm.service.TbConContractInfoServiceImpl;

@RestController
@RequestMapping("/TbConContractInfo")
public class TbConContractInfoController {
	
	
	@Autowired
	TbConContractInfoServiceImpl tbConContractInfoServiceImpl;
	
	@GetMapping("/selectByPrimaryKey")
	public TbConContractInfo selectByPrimaryKey(@RequestParam("contractId")String contractId) {
		return tbConContractInfoServiceImpl.selectByPrimaryKey(contractId);
		
	}

}
