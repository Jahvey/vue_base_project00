package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizJkdsyhApprovePo;

public interface CsmTbBizJkdsyhApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizJkdsyhApprovePo record);

    int insertSelective(CsmTbBizJkdsyhApprovePo record);

    CsmTbBizJkdsyhApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizJkdsyhApprovePo record);

    int updateByPrimaryKey(CsmTbBizJkdsyhApprovePo record);
}