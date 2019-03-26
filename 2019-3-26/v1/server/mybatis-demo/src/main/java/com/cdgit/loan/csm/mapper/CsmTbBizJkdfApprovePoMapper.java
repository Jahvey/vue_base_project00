package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizJkdfApprovePo;

@Mapper
public interface CsmTbBizJkdfApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizJkdfApprovePo record);

    int insertSelective(CsmTbBizJkdfApprovePo record);

    CsmTbBizJkdfApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizJkdfApprovePo record);

    int updateByPrimaryKey(CsmTbBizJkdfApprovePo record);
    
    CsmTbBizJkdfApprovePo queryByAmountDetailId(String amountDetailId);
}