package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConXmdkcnhPo;

public interface CsmTbConXmdkcnhPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConXmdkcnhPo record);

    int insertSelective(CsmTbConXmdkcnhPo record);

    CsmTbConXmdkcnhPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConXmdkcnhPo record);

    int updateByPrimaryKey(CsmTbConXmdkcnhPo record);
}