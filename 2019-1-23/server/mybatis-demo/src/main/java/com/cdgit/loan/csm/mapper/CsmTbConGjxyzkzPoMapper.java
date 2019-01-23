package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConGjxyzkzPo;

public interface CsmTbConGjxyzkzPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConGjxyzkzPo record);

    int insertSelective(CsmTbConGjxyzkzPo record);

    CsmTbConGjxyzkzPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConGjxyzkzPo record);

    int updateByPrimaryKey(CsmTbConGjxyzkzPo record);
}