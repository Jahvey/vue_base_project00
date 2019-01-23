package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizXwApprovePo;

public interface CsmTbBizXwApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizXwApprovePo record);

    int insertSelective(CsmTbBizXwApprovePo record);

    CsmTbBizXwApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizXwApprovePo record);

    int updateByPrimaryKey(CsmTbBizXwApprovePo record);
}