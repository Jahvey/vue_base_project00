package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizJkxyzApprovePo;

@Mapper
public interface CsmTbBizJkxyzApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizJkxyzApprovePo record);

    int insertSelective(CsmTbBizJkxyzApprovePo record);

    CsmTbBizJkxyzApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizJkxyzApprovePo record);

    int updateByPrimaryKey(CsmTbBizJkxyzApprovePo record);
    
    CsmTbBizJkxyzApprovePo queryByAmountDetailId(String amountDetailId);
}