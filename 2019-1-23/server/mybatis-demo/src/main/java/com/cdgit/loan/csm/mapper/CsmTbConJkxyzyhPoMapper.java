package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConJkxyzyhPo;

public interface CsmTbConJkxyzyhPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConJkxyzyhPo record);

    int insertSelective(CsmTbConJkxyzyhPo record);

    CsmTbConJkxyzyhPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConJkxyzyhPo record);

    int updateByPrimaryKey(CsmTbConJkxyzyhPo record);
}