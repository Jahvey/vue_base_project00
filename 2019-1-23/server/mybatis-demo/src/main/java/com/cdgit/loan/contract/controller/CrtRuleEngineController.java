package com.cdgit.loan.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.service.CrtGitUtilServiceImpl;
import com.cdgit.loan.contract.service.CrtRuleEngineServiceImpl;

/**
 * 放款执行规则和验证相关
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/CrtRuleEngine")
public class CrtRuleEngineController {

	@Autowired
	CrtRuleEngineServiceImpl crtRuleEngineService;
	
	@Autowired
	CrtGitUtilServiceImpl crtGitUtilServiceImpl;	//测试
	
	@GetMapping("/testSome")
	public String getBizAmountApproveByAmountId(){//String contractId
//		return crtRuleEngineService.checkAnjie(contractId);
		return crtGitUtilServiceImpl.getSeqNo("FK", "0700");
	}
	
}
