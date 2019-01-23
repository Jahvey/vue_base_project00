package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizHptxApprovePo;

public interface CsmTbBizHptxApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizHptxApprovePo record);

    int insertSelective(CsmTbBizHptxApprovePo record);

    CsmTbBizHptxApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizHptxApprovePo record);

    int updateByPrimaryKey(CsmTbBizHptxApprovePo record);
}