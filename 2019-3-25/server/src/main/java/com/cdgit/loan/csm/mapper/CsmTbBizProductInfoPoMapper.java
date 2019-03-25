package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizProductInfoPo;


@Mapper
public interface CsmTbBizProductInfoPoMapper {
	//待测试
	CsmTbBizProductInfoPo queryByProductType(String productType);
	
    int deleteCsmTbBizProductInfoById(String id);

    int insertCsmTbBizProductInfo(CsmTbBizProductInfoPo record);

    int insertCsmTbBizProductInfoSelective(CsmTbBizProductInfoPo record);

    CsmTbBizProductInfoPo queryCsmTbBizProductInfoById(String id);

    int updateCsmTbBizProductInfoSelective(CsmTbBizProductInfoPo record);

    int updateCsmTbBizProductInfo(CsmTbBizProductInfoPo record);
}