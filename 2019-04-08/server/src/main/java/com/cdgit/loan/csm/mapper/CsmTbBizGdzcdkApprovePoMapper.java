package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizGdzcdkApprovePo;

@Mapper
public interface CsmTbBizGdzcdkApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizGdzcdkApprovePo record);

    int insertSelective(CsmTbBizGdzcdkApprovePo record);

    CsmTbBizGdzcdkApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizGdzcdkApprovePo record);

    int updateByPrimaryKey(CsmTbBizGdzcdkApprovePo record);
    
    CsmTbBizGdzcdkApprovePo queryByAmountDetailId(String amountDetailId);
}