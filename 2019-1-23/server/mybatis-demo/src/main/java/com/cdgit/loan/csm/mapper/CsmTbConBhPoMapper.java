package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConBhPo;

public interface CsmTbConBhPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConBhPo record);

    int insertSelective(CsmTbConBhPo record);

    CsmTbConBhPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConBhPo record);

    int updateByPrimaryKey(CsmTbConBhPo record);
}