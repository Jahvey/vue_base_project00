package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConGjxyzdbdkPo;

public interface CsmTbConGjxyzdbdkPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConGjxyzdbdkPo record);

    int insertSelective(CsmTbConGjxyzdbdkPo record);

    CsmTbConGjxyzdbdkPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConGjxyzdbdkPo record);

    int updateByPrimaryKey(CsmTbConGjxyzdbdkPo record);
}