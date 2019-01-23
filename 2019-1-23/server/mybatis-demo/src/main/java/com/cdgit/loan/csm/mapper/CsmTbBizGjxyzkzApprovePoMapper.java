package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizGjxyzkzApprovePo;

public interface CsmTbBizGjxyzkzApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizGjxyzkzApprovePo record);

    int insertSelective(CsmTbBizGjxyzkzApprovePo record);

    CsmTbBizGjxyzkzApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizGjxyzkzApprovePo record);

    int updateByPrimaryKey(CsmTbBizGjxyzkzApprovePo record);
}