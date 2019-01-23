package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizGdzcdkApprovePo;

public interface CsmTbBizGdzcdkApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizGdzcdkApprovePo record);

    int insertSelective(CsmTbBizGdzcdkApprovePo record);

    CsmTbBizGdzcdkApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizGdzcdkApprovePo record);

    int updateByPrimaryKey(CsmTbBizGdzcdkApprovePo record);
}