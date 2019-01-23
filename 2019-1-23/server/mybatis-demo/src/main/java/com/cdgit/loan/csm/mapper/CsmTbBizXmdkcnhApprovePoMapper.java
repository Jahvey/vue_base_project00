package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizXmdkcnhApprovePo;

public interface CsmTbBizXmdkcnhApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizXmdkcnhApprovePo record);

    int insertSelective(CsmTbBizXmdkcnhApprovePo record);

    CsmTbBizXmdkcnhApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizXmdkcnhApprovePo record);

    int updateByPrimaryKey(CsmTbBizXmdkcnhApprovePo record);
}