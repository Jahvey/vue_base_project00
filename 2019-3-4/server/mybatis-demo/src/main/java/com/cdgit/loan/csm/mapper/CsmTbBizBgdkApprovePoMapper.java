package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizBgdkApprovePo;

@Mapper
public interface CsmTbBizBgdkApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizBgdkApprovePo record);

    int insertSelective(CsmTbBizBgdkApprovePo record);

    CsmTbBizBgdkApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizBgdkApprovePo record);

    int updateByPrimaryKey(CsmTbBizBgdkApprovePo record);
    
    CsmTbBizBgdkApprovePo queryByAmountDetailId(String amountDetailId);
}