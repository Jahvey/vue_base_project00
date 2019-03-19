package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizJkxyzyhApprovePo;

@Mapper
public interface CsmTbBizJkxyzyhApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizJkxyzyhApprovePo record);

    int insertSelective(CsmTbBizJkxyzyhApprovePo record);

    CsmTbBizJkxyzyhApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizJkxyzyhApprovePo record);

    int updateByPrimaryKey(CsmTbBizJkxyzyhApprovePo record);
    
    CsmTbBizJkxyzyhApprovePo queryByAmountDetailId(String amountDetailId);
}