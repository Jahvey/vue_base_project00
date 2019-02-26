package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizGjfftApprovePo;

@Mapper
public interface CsmTbBizGjfftApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizGjfftApprovePo record);

    int insertSelective(CsmTbBizGjfftApprovePo record);

    CsmTbBizGjfftApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizGjfftApprovePo record);

    int updateByPrimaryKey(CsmTbBizGjfftApprovePo record);
    
    CsmTbBizGjfftApprovePo queryByAmountDetailId(String amountDetailId);
}