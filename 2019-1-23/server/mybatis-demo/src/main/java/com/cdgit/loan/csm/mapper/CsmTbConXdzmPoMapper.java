package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConXdzmPo;

public interface CsmTbConXdzmPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConXdzmPo record);

    int insertSelective(CsmTbConXdzmPo record);

    CsmTbConXdzmPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConXdzmPo record);

    int updateByPrimaryKey(CsmTbConXdzmPo record);
}