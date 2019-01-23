package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizXdzmApprovePo;

public interface CsmTbBizXdzmApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizXdzmApprovePo record);

    int insertSelective(CsmTbBizXdzmApprovePo record);

    CsmTbBizXdzmApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizXdzmApprovePo record);

    int updateByPrimaryKey(CsmTbBizXdzmApprovePo record);
}