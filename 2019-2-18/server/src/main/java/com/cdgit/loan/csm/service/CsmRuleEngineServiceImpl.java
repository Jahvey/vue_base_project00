/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmRuleEngineMapper;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class CsmRuleEngineServiceImpl {
	
	@Autowired
	CsmRuleEngineMapper csmRuleEngineMapper;
	
	//TODO 主合同管理调整
	public void MainConConractUpdateValidate(HashMap<String, Object> map){
		String contractId = (String) map.get("contractId");
		
		if(0!=csmRuleEngineMapper.ruleXFE_0004(contractId)){
			throw new RuntimeException("[XFE_0004]该合同已被纳入[移交申请],在业务结束前无法处理");
		}
		
		
	}
	
	
	//合同签约 失效校验
	public Integer disabValidateForCon(String name,String param){
		System.err.println("disabValidateForCon{name:"+name+",param:"+param+"}");
		int res=1;
		switch (name) {
		case "RCON_0026":
			res=csmRuleEngineMapper.ruleRCON_0026(param);//amountDetailId
			break;
		case "RCON_0040":
			res=csmRuleEngineMapper.ruleRCON_0040(param);//contractId
			break;
		case "RCON_0043":
			res=csmRuleEngineMapper.ruleRCON_0043(param);//contractId
			break;			
		case "RGRT_0005":
			res=csmRuleEngineMapper.ruleRGRT_0005(param);//contractId
			break;	
		case "RGRT_0012":
			res=csmRuleEngineMapper.ruleRGRT_0012(param);//contractId
			break;				
		case "RGRT_0017":
			//新需求：合同下有临时出库的押品  不让做合同失效  add by shendl 2018/3/8
			res=csmRuleEngineMapper.ruleRGRT_0017(param);//contractId 
			break;	
			
		default:
			res=1;
			break;
		}
		
		
		
		return res;
	}
	
	//合同签约 合同调整校验
	public Integer updateValidateForCon(String name,String param){
		System.err.println("updateValidateForCon:{name:"+name+",param:"+param+"}");
		int res=1;
		switch (name) {
		case "XFE_0004":
			res=csmRuleEngineMapper.ruleXFE_0004(param); //contractId
			break;
		case "RCON_0024":
			res=csmRuleEngineMapper.ruleRCON_0024(param); //applyId
			break;
		case "RCON_0058":
			res=csmRuleEngineMapper.ruleRCON_0058(param); //applyId
			break;			
		case "RCON_0059":
			res=csmRuleEngineMapper.ruleRCON_0059(param); //applyId
			break;
		case "RCON_0026":
			res=csmRuleEngineMapper.ruleRCON_0026(param); //amountDetailId
			break;
		case "RCON_0060":
			res=csmRuleEngineMapper.ruleRCON_0060(param); //contractId
			break;
		case "RCON_0039":
			res=csmRuleEngineMapper.ruleRCON_0039(param); //contractId
			break;			
		case "RCON_0040":
			res=csmRuleEngineMapper.ruleRCON_0040(param); //contractId
			break;				
		case "RBIZ_0024":
			res=csmRuleEngineMapper.ruleRBIZ_0024(param); //applyId
			break;	
		case "RGRT_0005":
			res=csmRuleEngineMapper.ruleRGRT_0005(param); //contractId
			break;				
		case "RGRT_0012":
			res=csmRuleEngineMapper.ruleRGRT_0012(param); //contractId
			break;
		case "RCON_0003":
			res=csmRuleEngineMapper.ruleRCON_0003(param); //contractId
			break;
			
		default:
			res=1;
			break;
		}
			
		
		return res;
	}
	
	

	
}
