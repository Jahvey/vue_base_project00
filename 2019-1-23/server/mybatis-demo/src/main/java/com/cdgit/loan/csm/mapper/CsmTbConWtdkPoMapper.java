package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConWtdkPo;

public interface CsmTbConWtdkPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConWtdkPo record);

    int insertSelective(CsmTbConWtdkPo record);

    CsmTbConWtdkPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConWtdkPo record);

    int updateByPrimaryKey(CsmTbConWtdkPo record);
}