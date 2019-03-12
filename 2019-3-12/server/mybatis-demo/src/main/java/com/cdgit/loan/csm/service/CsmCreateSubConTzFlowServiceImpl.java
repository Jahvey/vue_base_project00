
package com.cdgit.loan.csm.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmCreateSubConTzFlowMapper;


@Service
@Transactional
public class CsmCreateSubConTzFlowServiceImpl {

	
	@Autowired
	CsmCreateSubConTzFlowMapper csmCreateSubConTzFlowMapper;
	
	
	@Autowired
	CsmBackupSubConAndGrtRelServiceImpl csmBackupSubConAndGrtRelServiceImpl;
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashMap<String, String> createSubConTzFlow(String subcontractId,String op){
		String msg="";
		HashMap<String, String> response = new HashMap<String,String>();
		
		
		//备份数据到零时表
		msg=csmBackupSubConAndGrtRelServiceImpl.backupSubConAndGrtRel(subcontractId, op);
		if(msg.equals("备份担保合同信息异常")){
			
			throw new RuntimeException(msg);//已经测试通过，可以进行回滚操作

		}
		
		
		
	
		response.put("msg", msg);        
    	return response;
	}
	
	
	
	
	
	
}
