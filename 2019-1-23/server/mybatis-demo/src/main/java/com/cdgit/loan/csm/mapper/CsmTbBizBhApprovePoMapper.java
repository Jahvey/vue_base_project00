package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizBhApprovePo;

public interface CsmTbBizBhApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizBhApprovePo record);

    int insertSelective(CsmTbBizBhApprovePo record);

    CsmTbBizBhApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizBhApprovePo record);

    int updateByPrimaryKey(CsmTbBizBhApprovePo record);
}