package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConXwPo;

public interface CsmTbConXwPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConXwPo record);

    int insertSelective(CsmTbConXwPo record);

    CsmTbConXwPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConXwPo record);

    int updateByPrimaryKey(CsmTbConXwPo record);
}