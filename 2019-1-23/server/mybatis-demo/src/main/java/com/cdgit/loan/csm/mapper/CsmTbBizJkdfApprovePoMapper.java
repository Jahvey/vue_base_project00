package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizJkdfApprovePo;

public interface CsmTbBizJkdfApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizJkdfApprovePo record);

    int insertSelective(CsmTbBizJkdfApprovePo record);

    CsmTbBizJkdfApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizJkdfApprovePo record);

    int updateByPrimaryKey(CsmTbBizJkdfApprovePo record);
}