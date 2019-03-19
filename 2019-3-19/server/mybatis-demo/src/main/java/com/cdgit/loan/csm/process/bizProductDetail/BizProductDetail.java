/**
 * 
 */
package com.cdgit.loan.csm.process.bizProductDetail;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmTbBizProductInfoPoMapper;
import com.cdgit.loan.csm.po.CsmTbBizProductInfoPo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class BizProductDetail {
	
	@Autowired
	CsmTbBizProductInfoPoMapper csmTbBizProductInfoPoMapper;
	
	/**
	 * 查询品种配置信息
	 * @param productCd
	 * @return
	 */
	public CsmTbBizProductInfoPo getProductInfo(String productCd){	
		return csmTbBizProductInfoPoMapper.queryByProductType(productCd);

	}
	
	/**
	 * TODO 贸易融资的业务在做申请的时候 需要调用国结的接口校验业务编号
	 * @param map
	 * @return
	 */
	public HashMap<String, String> checkYwbh(HashMap<String, String> map){
		
		HashMap<String,String> hashMap = new HashMap<String, String>();
		
		return hashMap;
		
	}

	
}
