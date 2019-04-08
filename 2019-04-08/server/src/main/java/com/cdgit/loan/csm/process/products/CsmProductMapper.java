package com.cdgit.loan.csm.process.products;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizProductInfoPo;

@Mapper
public interface CsmProductMapper {
	
	List<CsmTbBizProductInfoPo> queryProductInfo(String productCd);

	
}
