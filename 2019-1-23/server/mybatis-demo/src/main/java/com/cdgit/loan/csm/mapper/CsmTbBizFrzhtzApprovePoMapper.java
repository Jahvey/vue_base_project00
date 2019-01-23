package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizFrzhtzApprovePo;

public interface CsmTbBizFrzhtzApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizFrzhtzApprovePo record);

    int insertSelective(CsmTbBizFrzhtzApprovePo record);

    CsmTbBizFrzhtzApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizFrzhtzApprovePo record);

    int updateByPrimaryKey(CsmTbBizFrzhtzApprovePo record);
}