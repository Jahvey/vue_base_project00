package com.cdgit.loan.csm.process.conApply;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.po.CsmTbConCreditInfoPo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.process.accInfo.ContractApply;

@Service
@Transactional
public class ConApply {
	
	@Autowired
	ContractApply contractApply;
	
	//业务性质XD_SXYW0002
//    '01': '单笔业务',
//    '02': '综合授信',
//    '03': '统一授信',
//    '04': '单笔业务',
//    '05': '集团成员授信',
//    '06': '集团成员授信',
//    '07': '低风险业务',
//    '10': '用信业务'
	//调整合同
	public HashMap<String,Object> tzContractInfo(String contractId,String bizType){
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		HashMap<String,Object> map;
		if(!"01".equals(bizType)||!"04".equals(bizType)){//调整综合授信协议
			CsmTbConCreditInfoPo tzCreditInfo = contractApply.tzCreditInfo(contractId);
			hashMap.put("conInfo",tzCreditInfo);
			
			//合同发起流程
			map=createBpsProcess(tzCreditInfo.getContractId(), "crt");
		}else{//合同调整
			TbConContractInfoPo tzConInfo = contractApply.tzConInfo(contractId);
			hashMap.put("conInfo",tzConInfo);
			
			//合同发起流程
			map=createBpsProcess(tzConInfo.getContractId(), "crt");
		}
		
		
		hashMap.put("processInstId", map.get("processInstId"));
		hashMap.put("msg", map.get("map"));
		
		
		return hashMap;
	}
		
	
	
	
	//TODO 需要完善的地方 写完合同发起流程.......
	//合同发起流程
	public HashMap<String, Object> createBpsProcess(String bizId,String type) {
		HashMap<String,Object>resMap=new HashMap<String,Object>();
		String processInstId="";
		String msg="";
		
		System.err.println("发起合同流程：[bizID="+bizId+",type="+type+"]");
		
		
		
		
		
		resMap.put("processInstId", processInstId);
		resMap.put("msg", msg);
		return resMap;
		
	}
	
	
	
	
	
	
	

}
