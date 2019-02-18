/**
 * 
 */
package com.cdgit.loan.csm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.bean.ApproveAndSxxyVo;
import com.cdgit.loan.csm.bean.ApproveConsVo;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.po.CsmTbBizBankStructApplyPo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.process.bizInfo.BizInfo;
import com.cdgit.loan.csm.process.conApply.ConApply;
import com.cdgit.loan.csm.process.conApply.ConSynToCollByWebService;
import com.cdgit.loan.csm.process.conInfo.ConContractInfo;
import com.cdgit.loan.csm.process.conInfo.ConInfoPub;
import com.cdgit.loan.csm.process.conInfo.ConInfoSxxy;
import com.cdgit.loan.csm.process.cons.ConInfoCreateDao;
import com.cdgit.loan.csm.service.ConApplyServiceImpl;
import com.cdgit.loan.csm.service.CsmRuleEngineServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 * TODO 合同签约所有流程接口 待测试
 */
@RestController
@RequestMapping("process")
public class CsmProcessorController {

	@Autowired
	ConInfoPub conInfoPub;
	
	@Autowired
	ConSynToCollByWebService conSynToCollByWebService;
	
	@Autowired
	ConApply conApply;
	
	@Autowired
	ConApplyServiceImpl conApplyServiceImpl;
	
	@Autowired
	ConInfoCreateDao conInfoCreateDao;
	
	@Autowired
	ConContractInfo conContractInfo;
	
	@Autowired
	ConInfoSxxy conInfoSxxy;
	
	@Autowired
	BizInfo bizInfo;
	
	@Autowired
	CsmRuleEngineServiceImpl csmRuleEngineServiceImpl;
	
	
	//TODO 合同失效 待测
	
	//获取业务信息
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conApply/getConInfoBizType")
	public String getConInfoBizType(String contractId){
		
		return conApply.getConInfoBizType(contractId);
		
	}
	
	
	//获取相应的合同信息
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/ConInfoPub/selConInfo")
	public Map<String, Object> selConInfo(String contractId){
		
		return conInfoPub.selConInfo(contractId);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conApply/disConInfo")
	public String disConInfo(String contractId,String flag){
		
		
		return conApply.disConInfo(contractId, flag);
		
	}
	
	
	
	//调用押品系统
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conSynToCollByWebService/disConSynColl")
	public String disConSynColl(String contractId){
		
		return conSynToCollByWebService.disConSynColl(contractId);
		
	}
	
	
	//TODO 合同调整 待测
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conApply/tzContractInfo")
	public HashMap<String, Object> tzContractInfo(String contractId,String bizType){
		
		return conApply.tzContractInfo(contractId, bizType);
		
	}
	
	//TODO 合同查看 待测 con_tree.jsp
	
	//先将品种对应的合同明细页面取出来
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conContractInfo/getDetailJspByContractId")
	public HashMap<String, Object> getDetailJspByContractId(String contractId){
		
		return (HashMap<String, Object>) conContractInfo.getDetailJspByContractId(contractId);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conInfoSxxy/getConInfoByContarctId")
	public HashMap<String, Object> getConInfoByContarctId(String contractId){		
		return (HashMap<String, Object>) conInfoSxxy.getConInfoByContarctId(contractId);	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/bizInfo/getBankTeamStruct")
	public CsmTbBizBankStructApplyPo getBankTeamStruct(String applyId){	
		return bizInfo.getBankTeamStruct(applyId);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conApply/saveConInfoToPro")
	public String saveConInfoToPro(String contractId,String processInstId){		
		 conApply.saveConInfoToPro(contractId, processInstId);
		 return "success";
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/rule/RuleEngineMapper")  
	public Integer RuleEngineMapper(String name,String param){	//可以直接调用校验接口	
		 return csmRuleEngineServiceImpl.updateValidateForCon(name, param);
	}
	
	
	
	
	
	//TODO 合同插入 前台测试的时候注意要使用json格式
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/ApplyDaoEos/create")
	@ResponseBody
	public TbConContractInfoPo createConByBizDtl(@RequestParam Map<String, Object> apply ){
		//HashMap<String,Object> apply = new HashMap<String,Object>();
		System.err.println("create contract..."+apply);
		return conInfoCreateDao.create(apply);
		
	}
	
	
	
	@GetMapping("/getApproveAndSxxy")
	public PageBean getApproveAndSxxy(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="bizNum",required=false)String bizNum,
			@RequestParam(value="partyId",required=false)String partyId,
			@RequestParam(value="userId",required=false)String userId,
			@RequestParam(value="amountDetailId",required=false)String amountDetailId){
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("bizNum", bizNum);
		hashMap.put("partyId", partyId);
		hashMap.put("userId", userId);
		hashMap.put("amountDetailId", amountDetailId);
		hashMap.put("pageNum", pageNum);
		hashMap.put("pageSize", pageSize);
		
		PageInfo<ApproveAndSxxyVo> ApproveAndSxxyVo = conApplyServiceImpl.getApproveAndSxxy(hashMap);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(ApproveAndSxxyVo.getTotal());
		pageBean.setData(ApproveAndSxxyVo.getList());
		
		return  pageBean;
		
		
	}
	
	
}
