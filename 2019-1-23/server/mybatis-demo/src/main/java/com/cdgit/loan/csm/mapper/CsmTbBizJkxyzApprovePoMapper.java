package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizJkxyzApprovePo;

public interface CsmTbBizJkxyzApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizJkxyzApprovePo record);

    int insertSelective(CsmTbBizJkxyzApprovePo record);

    CsmTbBizJkxyzApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizJkxyzApprovePo record);

    int updateByPrimaryKey(CsmTbBizJkxyzApprovePo record);
}