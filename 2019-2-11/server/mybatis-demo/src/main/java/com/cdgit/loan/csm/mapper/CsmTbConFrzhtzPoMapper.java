package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConFrzhtzPo;
@Mapper
public interface CsmTbConFrzhtzPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConFrzhtzPo record);

    int insertSelective(CsmTbConFrzhtzPo record);

    CsmTbConFrzhtzPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConFrzhtzPo record);

    int updateByPrimaryKey(CsmTbConFrzhtzPo record);
}