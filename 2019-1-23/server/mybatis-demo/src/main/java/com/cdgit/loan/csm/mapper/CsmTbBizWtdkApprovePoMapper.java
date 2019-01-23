package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizWtdkApprovePo;

public interface CsmTbBizWtdkApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizWtdkApprovePo record);

    int insertSelective(CsmTbBizWtdkApprovePo record);

    CsmTbBizWtdkApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizWtdkApprovePo record);

    int updateByPrimaryKey(CsmTbBizWtdkApprovePo record);
}