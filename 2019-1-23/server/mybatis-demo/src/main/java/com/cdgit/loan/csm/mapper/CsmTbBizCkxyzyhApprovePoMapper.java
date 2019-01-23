package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizCkxyzyhApprovePo;

public interface CsmTbBizCkxyzyhApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizCkxyzyhApprovePo record);

    int insertSelective(CsmTbBizCkxyzyhApprovePo record);

    CsmTbBizCkxyzyhApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizCkxyzyhApprovePo record);

    int updateByPrimaryKey(CsmTbBizCkxyzyhApprovePo record);
}