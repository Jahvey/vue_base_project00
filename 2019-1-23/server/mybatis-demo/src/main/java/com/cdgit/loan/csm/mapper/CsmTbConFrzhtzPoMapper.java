package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConFrzhtzPo;

public interface CsmTbConFrzhtzPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConFrzhtzPo record);

    int insertSelective(CsmTbConFrzhtzPo record);

    CsmTbConFrzhtzPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConFrzhtzPo record);

    int updateByPrimaryKey(CsmTbConFrzhtzPo record);
}