package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizBhApprovePo;

@Mapper
public interface CsmTbBizBhApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizBhApprovePo record);

    int insertSelective(CsmTbBizBhApprovePo record);

    CsmTbBizBhApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizBhApprovePo record);

    int updateByPrimaryKey(CsmTbBizBhApprovePo record);
    
    CsmTbBizBhApprovePo queryByAmountDetailId(String amountDetailId);
}