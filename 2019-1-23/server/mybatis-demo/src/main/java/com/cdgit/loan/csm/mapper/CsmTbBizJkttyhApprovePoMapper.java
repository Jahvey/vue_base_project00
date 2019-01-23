package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizJkttyhApprovePo;

public interface CsmTbBizJkttyhApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizJkttyhApprovePo record);

    int insertSelective(CsmTbBizJkttyhApprovePo record);

    CsmTbBizJkttyhApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizJkttyhApprovePo record);

    int updateByPrimaryKey(CsmTbBizJkttyhApprovePo record);
}