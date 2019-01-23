package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConJkxyzPo;

public interface CsmTbConJkxyzPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConJkxyzPo record);

    int insertSelective(CsmTbConJkxyzPo record);

    CsmTbConJkxyzPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConJkxyzPo record);

    int updateByPrimaryKey(CsmTbConJkxyzPo record);
}