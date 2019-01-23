package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizJkxyzyhApprovePo;

public interface CsmTbBizJkxyzyhApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizJkxyzyhApprovePo record);

    int insertSelective(CsmTbBizJkxyzyhApprovePo record);

    CsmTbBizJkxyzyhApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizJkxyzyhApprovePo record);

    int updateByPrimaryKey(CsmTbBizJkxyzyhApprovePo record);
}