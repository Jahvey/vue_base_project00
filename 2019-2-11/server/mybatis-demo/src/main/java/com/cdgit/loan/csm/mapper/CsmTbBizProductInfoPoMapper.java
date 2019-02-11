package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbBizProductInfoPo;

@Mapper
public interface CsmTbBizProductInfoPoMapper {
	//待测试
	TbBizProductInfoPo queryByProductType(String productType);
	
    int deleteCsmTbBizProductInfoById(String id);

    int insertCsmTbBizProductInfo(TbBizProductInfoPo record);

    int insertCsmTbBizProductInfoSelective(TbBizProductInfoPo record);

    TbBizProductInfoPo queryCsmTbBizProductInfoById(String id);

    int updateCsmTbBizProductInfoSelective(TbBizProductInfoPo record);

    int updateCsmTbBizProductInfo(TbBizProductInfoPo record);
}