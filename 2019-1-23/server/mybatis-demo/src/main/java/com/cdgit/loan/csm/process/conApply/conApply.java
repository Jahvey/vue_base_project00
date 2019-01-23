package com.cdgit.loan.csm.process.conApply;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class conApply {
	
	
	
	
	
	
	
	//TODO 需要完善的地方 写完合同发起流程.......
	//合同发起流程
	public HashMap<String, String> createBpsProcess(String bizId,String type) {
		HashMap<String,String>resMap=new HashMap<String,String>();
		String processInstId="";
		String msg="";
		
		
		
		
		
		
		
		resMap.put("processInstId", processInstId);
		resMap.put("msg", msg);
		return resMap;
		
	}
	
	
	
	
	
	
	

}
