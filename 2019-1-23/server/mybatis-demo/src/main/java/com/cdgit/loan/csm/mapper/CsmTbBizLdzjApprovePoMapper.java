package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizLdzjApprovePo;

public interface CsmTbBizLdzjApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizLdzjApprovePo record);

    int insertSelective(CsmTbBizLdzjApprovePo record);

    CsmTbBizLdzjApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizLdzjApprovePo record);

    int updateByPrimaryKey(CsmTbBizLdzjApprovePo record);
}