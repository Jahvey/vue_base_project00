package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizCktsyhApprovePo;

public interface CsmTbBizCktsyhApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizCktsyhApprovePo record);

    int insertSelective(CsmTbBizCktsyhApprovePo record);

    CsmTbBizCktsyhApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizCktsyhApprovePo record);

    int updateByPrimaryKey(CsmTbBizCktsyhApprovePo record);
}