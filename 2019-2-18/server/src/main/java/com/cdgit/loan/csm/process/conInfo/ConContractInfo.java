package com.cdgit.loan.csm.process.conInfo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmTbBizProductInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConContractInfoMapper;
import com.cdgit.loan.csm.po.TbBizProductInfoPo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.process.bizProductDetail.BizProductDetail;

@Service
@Transactional
public class ConContractInfo {
	
	@Autowired
	CsmTbConContractInfoMapper 	csmTbConContractInfoMapper;
	
	@Autowired
	CsmTbBizProductInfoPoMapper csmTbBizProductInfoPoMapper;
	
	
	@Autowired
	BizProductDetail bizProductDetail;

	//根据合同id查询合同明细页面
	public Map<String, Object> getDetailJspByContractId(String contractId){
		HashMap<String,Object> map = new HashMap<String,Object>();

		
		TbConContractInfoPo tbConContractInfo = csmTbConContractInfoMapper.queryOneCsmTbConContractInfoByConId(contractId);
		String cycleIndCon=tbConContractInfo.getCycleIndCon();
		String productType=tbConContractInfo.getProductType();
		TbBizProductInfoPo tbBizProductInfo = bizProductDetail.getProductInfo(productType);
		String jspAddress=tbBizProductInfo.getJspName();
		
		String tableName=tbBizProductInfo.getTableName().replace("biz","con").replace("_apply","");
		
		
		map.put("jspAddress", jspAddress);
		map.put("productType", productType);
		map.put("tableName", tableName);
		map.put("cycleIndCon", cycleIndCon);
		return map;
		
	}
	
	
	
}
