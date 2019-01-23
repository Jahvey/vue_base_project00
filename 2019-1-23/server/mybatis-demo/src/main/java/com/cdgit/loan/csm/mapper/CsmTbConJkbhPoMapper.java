package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConJkbhPo;

public interface CsmTbConJkbhPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConJkbhPo record);

    int insertSelective(CsmTbConJkbhPo record);

    CsmTbConJkbhPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConJkbhPo record);

    int updateByPrimaryKey(CsmTbConJkbhPo record);
}