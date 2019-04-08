package com.cdgit.loan.contract.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.bean.CrtTbLoanInfo;
import com.cdgit.loan.contract.bean.TbConContractInfo;
import com.cdgit.loan.contract.gitUtil.LoanSubject;
import com.cdgit.loan.contract.mapper.TbConContractInfoMapper;
import com.cdgit.loan.contract.query.PayInfoForm;
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
	
	@Autowired	TbConContractInfoMapper contractInfoMapper;	//合同
	
	@Autowired CrtRuleEngineServiceImpl ruleEngineService;	//验证规则
	
	@GetMapping("/getCrtTbLoanInfoByLoanId")
	public CrtTbLoanInfo getCrtTbLoanInfoByLoanId(String loanId){
		return loanInfoService.selectLoanInfoByPrimaryKey(loanId);
	}
	
	/**
	 * 	执行规则校验，在执行规则校验成功之后才调用出账
	 * @param contractId
	 * @param amountDetailId
	 * @return
	 */
	@GetMapping("/LoanRuleEngines")
	public HashMap<String,Object> ruleEngines(String contractId){
		String amountDetailId = contractInfoMapper.queryOneConContractInfoByContractId(contractId).getAmountDetailId();
		HashMap<String,String> map = new HashMap<>();
		map.put("contractId", contractId);
		map.put("amountDetailId", amountDetailId);
		
		HashMap<String,Integer> ruleEngines = ruleEngineService.checkRuleEngines(map);
		String checkAnjie = ruleEngineService.checkAnjie(contractId);
		String productType = contractInfoMapper.queryOneConContractInfoByContractId(contractId).getProductType();
		
		HashMap<String,Object> result = new HashMap<>();
		result.put("ruleEngines", ruleEngines);
		result.put("checkAnjie", checkAnjie);
		result.put("productType", productType);
		return result;
	}
	
	/**
	 * 在执行规则完全通过之后对外暴露的接口（出账）,有些从session里面获取的东西暂时在这里写死
	 * 	1.contractId是必须的
	 * 	2.partyId:客户id，原文也是session获取，先写上，我使用的是根据合同id查出来的partyId
	 * 	3.productType原文界面初始化的时候存session
	 * 	4.amountDetailId原文界面初始化的时候存session
	 * 	5.flag：界面标志，不过被注释掉了，没使用
	 * 	6.userId：当前操作员的id
	 * @param contractId
	 * @return
	 */
	@GetMapping("/createLoanInfoAndSave")
	public String createLoanInfoAndSave(String contractId){
		//根据合同id获取完整的合同信息
		TbConContractInfo contractInfo= contractInfoMapper.queryOneConContractInfoByContractId(contractId);
		
//		String partyId = contractInfo.getPartyId();	//客户id
		String productType = contractInfo.getProductType();//产品类型
		String amountDetailId = contractInfo.getAmountDetailId();//业务明细id
		
		String flag=null;//界面传过来的，不过没使用	1231
		String orgNum="0700";//这个也是session里面获取的，目前暂时在这里写死，写死成0700
		String userNum="200555";//当前操作员
		
		String loanId = loanInfoService.createLoanInfo(contractInfo, flag, orgNum, userNum);
		CrtTbLoanInfo loanInfo = loanInfoService.selectLoanInfoByPrimaryKey(loanId);
		
		if("01008001".equals(productType) || "01008010".equals(productType) ||
		   "01008002".equals(productType) || "01006001".equals(productType) ||
		   "01006010".equals(productType) || "01006002".equals(productType)){
			
			loanInfoService.insertXXXX(amountDetailId, productType, loanInfo,orgNum);	//插入票据信息	（贴息和票据直接硬编码写的 0700，记得修改）
		}
//		System.err.println(loanId);
//		int k= 1/0;//无法控制到第二个事务
		loanInfoService.saveConToLoan(loanId);//将合同信息保存到放款数据
		
//		return loanInfoService.selectLoanInfoByPrimaryKey(loanId);//返回最新的放款表，看看哪里用得上
		return loanId;//返回出账id就好
	}
	

	//初始化pay_info页面的接口	402881e967bb828101686fbaa3be0122
	@GetMapping("/getPayInfo")
	public HashMap<String,Object> getInitPayInfo(String loanId,String processInstId){
		String userNum="200555";
		HashMap<String,Object> payInfo = loanInfoService.getPayInfo(loanId, processInstId, userNum);
		return payInfo;
	}
	
	/**
	 * 初始化pay_tree的信息
	 * @param loanId
	 * @return
	 */
	@GetMapping("/getProductType")
	public HashMap<String,Object> getInitProductType(String loanId){
		HashMap<String,Object> hashMap = loanInfoService.initProductType(loanId);
		return hashMap;
	}
	

	/**
	 * 保存修改的出账信息,使用post提交
	 * @param payInfo
	 * @return
	 */
	@PostMapping("/savePayInfo")
	public String savePayInfo(@RequestBody PayInfoForm payInfo){
		String msg="";
		try {
			loanInfoService.savePayInfo(payInfo);
			msg="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
//			msg="保存失败，"+e.getMessage();
			msg="保存失败，你所面对的正是：哈哈哈哈哈哈哈嗝！！！！";
		}
		return msg;
	}
	
	


	/**
	 * 插入一条放款信息
	 * 合同id，组织机构，操作员和标志信息先写死
	 * @return
	 
	@GetMapping("/insertCrtTbLoanInfo")
	public String insertCrtTbLoanInfo(){
		String contractId = "5AF812FCF10B00CAE05010AC57DD7D12";//2019年1月22日12:01:32
		String flag ="1231";
		String loanId = loanInfoService.createLoanInfo(contractId, flag, "0700", "200555");
		return loanId;
	}
	*/
	
	//测试合同数据迁移到放款信息2019年1月22日12:01:26
/*	@GetMapping("/saveConToLoan")
	public HashMap<String,String> saveConToLoan(){
		String loanId="dd9cbfbcb4e555c90b642b07fb3c8577";//用插入放款信息生成的id写在这里
//		BeanUtil.copyBeanProperties(src, tar);
		HashMap<String,String> hashMap = loanInfoService.saveConToLoan(loanId);
		return hashMap;
	}*/
	
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
