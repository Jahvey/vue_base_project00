package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizJkbhApprovePo;

@Mapper
public interface CsmTbBizJkbhApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizJkbhApprovePo record);

    int insertSelective(CsmTbBizJkbhApprovePo record);

    CsmTbBizJkbhApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizJkbhApprovePo record);

    int updateByPrimaryKey(CsmTbBizJkbhApprovePo record);
    
    CsmTbBizJkbhApprovePo queryByAmountDetailId(String amountDetailId);
}