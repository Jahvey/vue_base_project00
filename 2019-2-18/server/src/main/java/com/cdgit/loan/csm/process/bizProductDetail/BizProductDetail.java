/**
 * 
 */
package com.cdgit.loan.csm.process.bizProductDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmTbBizProductInfoPoMapper;
import com.cdgit.loan.csm.po.TbBizProductInfoPo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class BizProductDetail {
	
	@Autowired
	CsmTbBizProductInfoPoMapper csmTbBizProductInfoPoMapper;
	
	//查询品种配置信息
	public TbBizProductInfoPo getProductInfo(String productCd){	
		return csmTbBizProductInfoPoMapper.queryByProductType(productCd);

	}
	
	

}
