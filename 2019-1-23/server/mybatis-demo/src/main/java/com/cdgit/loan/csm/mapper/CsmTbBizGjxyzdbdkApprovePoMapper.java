package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizGjxyzdbdkApprovePo;

public interface CsmTbBizGjxyzdbdkApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizGjxyzdbdkApprovePo record);

    int insertSelective(CsmTbBizGjxyzdbdkApprovePo record);

    CsmTbBizGjxyzdbdkApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizGjxyzdbdkApprovePo record);

    int updateByPrimaryKey(CsmTbBizGjxyzdbdkApprovePo record);
}