package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConGnxyzPo;

public interface CsmTbConGnxyzPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConGnxyzPo record);

    int insertSelective(CsmTbConGnxyzPo record);

    CsmTbConGnxyzPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConGnxyzPo record);

    int updateByPrimaryKey(CsmTbConGnxyzPo record);
}