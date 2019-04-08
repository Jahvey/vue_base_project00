package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmTbBizApply;

@Mapper
public interface CsmTbBizApplyMapper {
    int deleteByPrimaryKey(String applyId);

    int insert(CsmTbBizApply record);

    int insertSelective(CsmTbBizApply record);

    CsmTbBizApply selectByPrimaryKey(String applyId);

    int updateByPrimaryKeySelective(CsmTbBizApply record);

    int updateByPrimaryKey(CsmTbBizApply record);
}