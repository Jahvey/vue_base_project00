package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizThdbApprovePo;

@Mapper
public interface CsmTbBizThdbApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizThdbApprovePo record);

    int insertSelective(CsmTbBizThdbApprovePo record);

    CsmTbBizThdbApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizThdbApprovePo record);

    int updateByPrimaryKey(CsmTbBizThdbApprovePo record);
    
    CsmTbBizThdbApprovePo queryByAmountDetailId(String amountDetailId);
}