package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizGjxyzkzApprovePo;

@Mapper
public interface CsmTbBizGjxyzkzApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizGjxyzkzApprovePo record);

    int insertSelective(CsmTbBizGjxyzkzApprovePo record);

    CsmTbBizGjxyzkzApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizGjxyzkzApprovePo record);

    int updateByPrimaryKey(CsmTbBizGjxyzkzApprovePo record);
    
    CsmTbBizGjxyzkzApprovePo queryByAmountDetailId(String amountDetailId);
}