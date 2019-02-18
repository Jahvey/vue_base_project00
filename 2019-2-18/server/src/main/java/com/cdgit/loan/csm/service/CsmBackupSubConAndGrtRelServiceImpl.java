/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.csm.mapper.CsmBackupSubConAndGrtRelMapper;

/**
 * @author cwalk
 *
 */

@Service
@Transactional
public class CsmBackupSubConAndGrtRelServiceImpl {
	
	@Autowired
	CsmBackupSubConAndGrtRelMapper csmBackupSubConAndGrtRelMapper;
	
	
	//备份
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String backupSubConAndGrtRel(String subcontractId,String op){
		String msg="";
		
		//getUUID
		String uuid = UUIDGenerator.getUUID();
		System.err.println(uuid);
//		HashMap<String, String> map = new HashMap<>();
//		map.put("id", uuid);
//		map.put("subcontractId", uuid);
//		csmBackupSubConAndGrtRelMapper.insertDemo(map);
		msg="备份担保合同信息异常";
		
	
		        
    	return msg;
	}
	
	
	
	

}
