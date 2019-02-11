package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConThdbPo;
@Mapper
public interface CsmTbConThdbPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConThdbPo record);

    int insertSelective(CsmTbConThdbPo record);

    CsmTbConThdbPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConThdbPo record);

    int updateByPrimaryKey(CsmTbConThdbPo record);
}