package com.cdgit.loan.csm.process.products;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbBizProductInfoPo;

@Mapper
public interface CsmProductMapper {
	
	List<TbBizProductInfoPo> queryProductInfo(String productCd);

	
}
