package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConJkttyhPo;

public interface CsmTbConJkttyhPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConJkttyhPo record);

    int insertSelective(CsmTbConJkttyhPo record);

    CsmTbConJkttyhPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConJkttyhPo record);

    int updateByPrimaryKey(CsmTbConJkttyhPo record);
}