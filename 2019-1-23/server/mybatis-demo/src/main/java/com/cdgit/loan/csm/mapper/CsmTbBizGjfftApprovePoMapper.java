package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizGjfftApprovePo;

public interface CsmTbBizGjfftApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizGjfftApprovePo record);

    int insertSelective(CsmTbBizGjfftApprovePo record);

    CsmTbBizGjfftApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizGjfftApprovePo record);

    int updateByPrimaryKey(CsmTbBizGjfftApprovePo record);
}