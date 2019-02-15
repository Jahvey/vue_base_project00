package com.cdgit.loan.contract.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.bean.CrtTbLoanInfo;
import com.cdgit.loan.contract.service.CrtLoanInfoServiceImpl;
import com.cdgit.loan.contract.service.CrtRuleEngineServiceImpl;

/**
 * 执行一堆验证规则
 * 流程执行步骤：
 * 	1.先要生成一条放款信息createLoanInfo
 * 	2.如果产品类型有？？？，则需要插入票据信息insertXXXX
 * 	3.把合同数据迁移到放款数据里面去
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/crtTbLoanInfo")
public class CrtTbLoanInfoController {

	@Autowired CrtLoanInfoServiceImpl loanInfoService;	//放款
	
	@Autowired CrtRuleEngineServiceImpl ruleEngineService;	//验证规则
	
	@GetMapping("/getCrtTbLoanInfoByLoanId")
	public CrtTbLoanInfo getCrtTbLoanInfoByApproveId(String loanId){
		return loanInfoService.selectByPrimaryKey(loanId);
	}
	
	/**
	 * 插入一条放款信息
	 * 合同id，组织机构，操作员和标志信息先写死
	 * @return
	 */
	@GetMapping("/insertCrtTbLoanInfo")
	public String insertCrtTbLoanInfo(){
		String contractId = "ff80808163919a530163a5ef83434784";
		String flag ="1231";
		String loanId = loanInfoService.createLoanInfo(contractId, flag, "0700", "200555");
		return loanId;
	}
	
	/**
	 * 出账：
	 * 	问题：
	 * 		1. 怎么从session里面获取到contractId？这个问题非常的关键，根据合同id才能查询对应的明细id，然后做验证
	 * 	1. 执行规则的校验
	 * @param loanId
	 * @param amountDetailId
	 * @param productType
	 * @return
	 */
	@GetMapping("/ruleEngines")
	public HashMap<String,Integer> ruleEngines(String contractId,String amountDetailId){
		HashMap<String,String> map = new HashMap<>();
		map.put("contractId", contractId);
		map.put("amountDetailId", amountDetailId);
		HashMap<String,Integer> ruleEngines = ruleEngineService.checkRuleEngines(map);
		return ruleEngines;
	}

	@GetMapping("/updateCrtTbLoanInfo")
	public CrtTbLoanInfo updateCrtTbLoanInfo(String loanId, String amountDetailId, String productType){
		return null;
	}
	
	/**
	 * 测试：插入贴息明细，此时会修改一条放款明细
	 * @return
	 */
/*	@GetMapping("/insertTXXX")
	public List<String> insertTXXX(){
//		String contractId = "5AF812FCFC2100CAE05010AC57DD7D12";
		String amountDetailId="5AF812FE2C1200CAE05010AC57DD7D12";
		String loanId = "ba7cb3db8ff84766032d7c1fddc73dad";	//随时在变
		CrtTbLoanInfo loanInfo = loanInfoService.selectByPrimaryKey(loanId);
		return loanInfoService.insertTXXX(amountDetailId, loanInfo);
	}*/
	
	/**
	 * 测试：插入票据明细，此时会修改一条放款明细
	 * @return
	 */
/*	@GetMapping("/insertPJXX")
	public List<String> insertPJXX(){
//		String contractId = "5AF812FCFC2100CAE05010AC57DD7D12";
		String amountDetailId="ff80808163919a53016394ecd03005eb";
		String loanId = "9c1777da95f3b51316d4f90cd83b7067";	//随时在变
		CrtTbLoanInfo loanInfo = loanInfoService.selectByPrimaryKey(loanId);
		return loanInfoService.insertPJXX(amountDetailId, loanInfo);
	}*/
	
}
