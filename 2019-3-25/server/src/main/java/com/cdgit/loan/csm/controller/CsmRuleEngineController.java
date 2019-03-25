package com.cdgit.loan.csm.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.mapper.CsmRuleEngineMapper;
import com.cdgit.loan.csm.service.CsmRuleEngineServiceImpl;

@RestController
@RequestMapping("ruleEngine")
public class CsmRuleEngineController {

	@Autowired
	CsmRuleEngineServiceImpl csmRuleEngineServiceImpl;
	

	
	@GetMapping("/MainConConractUpdateValidate")
	@ResponseBody
	public void MainConConractUpdateValidate(@RequestParam HashMap<String, Object> map){
		//TODO 参数已经拿到了，可以向后面传递

		System.err.println(map.toString());
		System.err.println("拿到数据了!"+map.get("contractId"));
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("contractId", map.get("contractId"));
		
		 csmRuleEngineServiceImpl.MainConConractUpdateValidate(hashMap);
		
	}
	
	
	@GetMapping("/updateValidateForCon")
	@ResponseBody
	public HashMap<String, Integer> updateValidateForCon(@RequestParam HashMap<String, String> map){
		System.err.println("[updateValidateForCon]"+map);
		return csmRuleEngineServiceImpl.updateValidateForCon(map);
	}
	
	
	@GetMapping("/disabValidateForCon")
	@ResponseBody
	public HashMap<String, Integer> disabValidateForCon(@RequestParam HashMap<String, String> map){
		System.err.println("[disabValidateForCon]"+map);
		return csmRuleEngineServiceImpl.disabValidateForCon(map);
	}
	
	
	
	
}
