package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizGnxyzApprovePo;

@Mapper
public interface CsmTbBizGnxyzApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizGnxyzApprovePo record);

    int insertSelective(CsmTbBizGnxyzApprovePo record);

    CsmTbBizGnxyzApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizGnxyzApprovePo record);

    int updateByPrimaryKey(CsmTbBizGnxyzApprovePo record);
    
    CsmTbBizGnxyzApprovePo queryByAmountDetailId(String amountDetailId);
}