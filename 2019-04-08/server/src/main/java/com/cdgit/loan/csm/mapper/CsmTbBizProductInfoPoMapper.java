package com.cdgit.loan.csm.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizProductInfoPo;


@Mapper
public interface CsmTbBizProductInfoPoMapper {
	
	//查询产品期限
	List<HashMap<String, Object>> getBizTerm(HashMap<String, Object> map);
	
	//待测试
	CsmTbBizProductInfoPo queryByProductType(String productType);
	
    int deleteCsmTbBizProductInfoById(String id);

    int insertCsmTbBizProductInfo(CsmTbBizProductInfoPo record);

    int insertCsmTbBizProductInfoSelective(CsmTbBizProductInfoPo record);

    CsmTbBizProductInfoPo queryCsmTbBizProductInfoById(String id);

    int updateCsmTbBizProductInfoSelective(CsmTbBizProductInfoPo record);

    int updateCsmTbBizProductInfo(CsmTbBizProductInfoPo record);
}