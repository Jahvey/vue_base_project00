package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizGjxyzdbdkApprovePo;

@Mapper
public interface CsmTbBizGjxyzdbdkApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizGjxyzdbdkApprovePo record);

    int insertSelective(CsmTbBizGjxyzdbdkApprovePo record);

    CsmTbBizGjxyzdbdkApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizGjxyzdbdkApprovePo record);

    int updateByPrimaryKey(CsmTbBizGjxyzdbdkApprovePo record);
    
    CsmTbBizGjxyzdbdkApprovePo queryByAmountDetailId(String amountDetailId);
    
}