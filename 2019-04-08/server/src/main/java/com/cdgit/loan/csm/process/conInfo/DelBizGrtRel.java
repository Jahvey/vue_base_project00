package com.cdgit.loan.csm.process.conInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmTbBizApproveMapper;

@Service
@Transactional
public class DelBizGrtRel {
	
	@Autowired
	CsmTbBizApproveMapper   csmTbBizApproveMapper;
	/**
	 * TODO 删除业务申请与押品的关联关系 
	 * @param contractId
	 */
	public void delBizGrtRel(String contractId){
		System.err.println("删除【业务申请】与【押品】的关联关系开始...");
		List<HashMap<String,Object>> applySuretyObjs = csmTbBizApproveMapper.getBizGrtRel(contractId);
		
		if(applySuretyObjs.size()>0){
			
			for (int i = 0; i < applySuretyObjs.size(); i++) {
				Map<String,Object> map = new HashMap<String,Object>();
				
				HashMap<String,Object> applySuretyObject = applySuretyObjs.get(i);
				
				//先删除信贷本地的业务申请和押品关系
				map.put("cltNo", applySuretyObject.get("suretyNo"));
				map.put("suretyId", applySuretyObject.get("suretyId"));
				map.put("applyId", applySuretyObject.get("applyId"));

				
				//TODO 调押品系统接口，同步数据
				
				map.put("trans_code", "1114");//接口交易码
				map.put("ope_flag", "delapply");//操作标志
				
				System.err.println("押品与业务关联信息删除------applyId="+map.get("applyId")+"------>开始!"+i);
			}
			
			
		}
		
		
		
		
		System.err.println("删除【业务申请】与【押品】的关联关系结束!");
		
	}
	

}
