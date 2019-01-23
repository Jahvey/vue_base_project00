package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConGjfftPo;

public interface CsmTbConGjfftPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConGjfftPo record);

    int insertSelective(CsmTbConGjfftPo record);

    CsmTbConGjfftPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConGjfftPo record);

    int updateByPrimaryKey(CsmTbConGjfftPo record);
}