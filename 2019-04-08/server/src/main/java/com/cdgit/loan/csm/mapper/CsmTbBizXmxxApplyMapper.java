package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmTbBizXmxxApply;

@Mapper
public interface CsmTbBizXmxxApplyMapper {
    int deleteByPrimaryKey(String relateId);

    int insert(CsmTbBizXmxxApply record);

    int insertSelective(CsmTbBizXmxxApply record);

    CsmTbBizXmxxApply selectByPrimaryKey(String relateId);

    int updateByPrimaryKeySelective(CsmTbBizXmxxApply record);

    int updateByPrimaryKey(CsmTbBizXmxxApply record);
}