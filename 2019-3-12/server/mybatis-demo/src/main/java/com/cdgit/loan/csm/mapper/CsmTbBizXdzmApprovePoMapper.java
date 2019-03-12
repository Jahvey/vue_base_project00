package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizXdzmApprovePo;

@Mapper
public interface CsmTbBizXdzmApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizXdzmApprovePo record);

    int insertSelective(CsmTbBizXdzmApprovePo record);

    CsmTbBizXdzmApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizXdzmApprovePo record);

    int updateByPrimaryKey(CsmTbBizXdzmApprovePo record);
    
    CsmTbBizXdzmApprovePo queryByAmountDetailId(String amountDetailId);
}