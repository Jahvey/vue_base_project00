package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizThdbApprovePo;

public interface CsmTbBizThdbApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizThdbApprovePo record);

    int insertSelective(CsmTbBizThdbApprovePo record);

    CsmTbBizThdbApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizThdbApprovePo record);

    int updateByPrimaryKey(CsmTbBizThdbApprovePo record);
}