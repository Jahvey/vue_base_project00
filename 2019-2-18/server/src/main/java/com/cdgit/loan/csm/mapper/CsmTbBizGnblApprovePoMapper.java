package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizGnblApprovePo;

@Mapper
public interface CsmTbBizGnblApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizGnblApprovePo record);

    int insertSelective(CsmTbBizGnblApprovePo record);

    CsmTbBizGnblApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizGnblApprovePo record);

    int updateByPrimaryKey(CsmTbBizGnblApprovePo record);
    
    CsmTbBizGnblApprovePo queryByAmountDetailId(String amountDetailId);
}