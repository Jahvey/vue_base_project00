/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.HashMap;
import java.util.Map;

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
	public HashMap<String, Integer> disabValidateForCon(HashMap<String, String> map){
		System.err.println("[disabValidateForCon]map:"+map);
		String amountDetailId = map.get("amountDetailId");
		String contractId = map.get("contractId");
		
		
		Integer RCON_0026=csmRuleEngineMapper.ruleRCON_0026(amountDetailId);//amountDetailId

		Integer RCON_0040=csmRuleEngineMapper.ruleRCON_0040(contractId);//contractId

		Integer	RCON_0043=csmRuleEngineMapper.ruleRCON_0043(contractId);//contractId
	
		Integer	RGRT_0005=csmRuleEngineMapper.ruleRGRT_0005(contractId);//contractId
	
		Integer	RGRT_0012=csmRuleEngineMapper.ruleRGRT_0012(contractId);//contractId
			

			//新需求：合同下有临时出库的押品  不让做合同失效  add by shendl 2018/3/8
		Integer	RGRT_0017=csmRuleEngineMapper.ruleRGRT_0017(contractId);//contractId 
		HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("RCON_0026", RCON_0026);
		hashMap.put("RCON_0040", RCON_0040);
		hashMap.put("RCON_0043", RCON_0043);
		hashMap.put("RGRT_0005", RGRT_0005);
		hashMap.put("RGRT_0012", RGRT_0012);
		hashMap.put("RGRT_0017", RGRT_0017);
		
		
		return hashMap;
	}
	
	public Integer disabValidateForCon1(String name,String param){
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
	
	
	//modify by adonai 2019/2/19 重新修改了合同调整
	public HashMap<String, Integer> updateValidateForCon(HashMap<String, String> map){
		String contractId = map.get("contractId");
		String applyId=map.get("applyId");
		String amountDetailId=map.get("amountDetailId");
		
		Integer XFE_0004=csmRuleEngineMapper.ruleXFE_0004(contractId);



		Integer RCON_0026=csmRuleEngineMapper.ruleRCON_0026(amountDetailId); //amountDetailId
	
		Integer RCON_0060=csmRuleEngineMapper.ruleRCON_0060(contractId); //contractId

		Integer RCON_0039=csmRuleEngineMapper.ruleRCON_0039(contractId); //contractId
		
		Integer RCON_0040=csmRuleEngineMapper.ruleRCON_0040(contractId); //contractId

		//Integer RBIZ_0024=csmRuleEngineMapper.ruleRBIZ_0024(applyId); //applyId

		Integer RGRT_0005=csmRuleEngineMapper.ruleRGRT_0005(contractId); //contractId
			
		Integer RGRT_0012=csmRuleEngineMapper.ruleRGRT_0012(contractId); //contractId


		Integer RCON_0003=csmRuleEngineMapper.ruleRCON_0003(contractId); //contractId
		
		HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
		hashMap.put("XFE_0004", XFE_0004);

		hashMap.put("RCON_0026", RCON_0026);
		hashMap.put("RCON_0060", RCON_0060);
		hashMap.put("RCON_0039", RCON_0039);
		hashMap.put("RCON_0040", RCON_0040);
		
		hashMap.put("RGRT_0005", RGRT_0005);
		hashMap.put("RGRT_0012", RGRT_0012);
		hashMap.put("RCON_0003", RCON_0003);
		
		//hashMap.put("RBIZ_0024", RBIZ_0024);
		
		
		if(map.get("bizType")=="综合授信协议"){
			Integer RCON_0024=csmRuleEngineMapper.ruleRCON_0024(applyId); //applyId

			Integer RCON_0058=csmRuleEngineMapper.ruleRCON_0058(applyId); //applyId

			Integer RCON_0059=csmRuleEngineMapper.ruleRCON_0059(applyId); //applyId
			hashMap.put("RCON_0024", RCON_0024);
			hashMap.put("RCON_0058", RCON_0058);
			hashMap.put("RCON_0059", RCON_0059);
			
		}

		
		return hashMap;
		
		
	}
	
	
	
	//合同签约 合同调整校验
	public Integer updateValidateForCon1(String name,String param){
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
