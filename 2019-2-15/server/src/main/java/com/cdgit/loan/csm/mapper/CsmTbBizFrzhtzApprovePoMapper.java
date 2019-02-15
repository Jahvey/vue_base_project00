package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizFrzhtzApprovePo;

@Mapper
public interface CsmTbBizFrzhtzApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizFrzhtzApprovePo record);

    int insertSelective(CsmTbBizFrzhtzApprovePo record);

    CsmTbBizFrzhtzApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizFrzhtzApprovePo record);

    int updateByPrimaryKey(CsmTbBizFrzhtzApprovePo record);
    
    CsmTbBizFrzhtzApprovePo queryByAmountDetailId(String amountDetailId);
}