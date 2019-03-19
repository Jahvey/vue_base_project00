package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConMyhtxxPo;

@Mapper
public interface CsmTbConMyhtxxPoMapper {
    int deleteByPrimaryKey(String htId);

    int insert(CsmTbConMyhtxxPo record);

    int insertSelective(CsmTbConMyhtxxPo record);

    CsmTbConMyhtxxPo selectByPrimaryKey(String htId);

    int updateByPrimaryKeySelective(CsmTbConMyhtxxPo record);

    int updateByPrimaryKey(CsmTbConMyhtxxPo record);
}