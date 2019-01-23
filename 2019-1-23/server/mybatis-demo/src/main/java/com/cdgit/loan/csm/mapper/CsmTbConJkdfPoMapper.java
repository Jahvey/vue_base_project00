package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConJkdfPo;

public interface CsmTbConJkdfPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConJkdfPo record);

    int insertSelective(CsmTbConJkdfPo record);

    CsmTbConJkdfPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConJkdfPo record);

    int updateByPrimaryKey(CsmTbConJkdfPo record);
}