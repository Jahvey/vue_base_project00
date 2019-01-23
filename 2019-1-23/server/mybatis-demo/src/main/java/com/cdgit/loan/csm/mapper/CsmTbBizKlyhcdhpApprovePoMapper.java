package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbBizKlyhcdhpApprovePo;

public interface CsmTbBizKlyhcdhpApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizKlyhcdhpApprovePo record);

    int insertSelective(CsmTbBizKlyhcdhpApprovePo record);

    CsmTbBizKlyhcdhpApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizKlyhcdhpApprovePo record);

    int updateByPrimaryKey(CsmTbBizKlyhcdhpApprovePo record);
}