package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConCkxyzyhPo;

public interface CsmTbConCkxyzyhPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConCkxyzyhPo record);

    int insertSelective(CsmTbConCkxyzyhPo record);

    CsmTbConCkxyzyhPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConCkxyzyhPo record);

    int updateByPrimaryKey(CsmTbConCkxyzyhPo record);
}