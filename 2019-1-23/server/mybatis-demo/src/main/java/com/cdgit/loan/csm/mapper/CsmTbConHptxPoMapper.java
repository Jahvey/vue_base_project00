package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConHptxPo;

public interface CsmTbConHptxPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConHptxPo record);

    int insertSelective(CsmTbConHptxPo record);

    CsmTbConHptxPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConHptxPo record);

    int updateByPrimaryKey(CsmTbConHptxPo record);
}