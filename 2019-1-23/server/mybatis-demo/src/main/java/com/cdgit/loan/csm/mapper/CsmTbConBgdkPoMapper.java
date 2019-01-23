package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConBgdkPo;

public interface CsmTbConBgdkPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConBgdkPo record);

    int insertSelective(CsmTbConBgdkPo record);

    CsmTbConBgdkPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConBgdkPo record);

    int updateByPrimaryKey(CsmTbConBgdkPo record);
}