package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizXwApprovePo;
@Mapper
public interface CsmTbBizXwApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizXwApprovePo record);

    int insertSelective(CsmTbBizXwApprovePo record);

    CsmTbBizXwApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizXwApprovePo record);

    int updateByPrimaryKey(CsmTbBizXwApprovePo record);
    
    CsmTbBizXwApprovePo queryByAmountDetailId(String amountDetailId);
}