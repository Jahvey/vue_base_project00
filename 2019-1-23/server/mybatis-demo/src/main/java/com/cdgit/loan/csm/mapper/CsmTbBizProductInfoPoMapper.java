package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.TbBizProductInfoPo;

public interface CsmTbBizProductInfoPoMapper {
    int deleteCsmTbBizProductInfoById(String id);

    int insertCsmTbBizProductInfo(TbBizProductInfoPo record);

    int insertCsmTbBizProductInfoSelective(TbBizProductInfoPo record);

    TbBizProductInfoPo queryCsmTbBizProductInfoById(String id);

    int updateCsmTbBizProductInfoSelective(TbBizProductInfoPo record);

    int updateCsmTbBizProductInfo(TbBizProductInfoPo record);
}