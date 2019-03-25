package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmTbBizAmoutApply;

@Mapper
public interface CsmTbBizAmoutApplyMapper {
    int deleteByPrimaryKey(String amountId);

    int insert(CsmTbBizAmoutApply record);

    int insertSelective(CsmTbBizAmoutApply record);

    CsmTbBizAmoutApply selectByPrimaryKey(String amountId);

    int updateByPrimaryKeySelective(CsmTbBizAmoutApply record);

    int updateByPrimaryKey(CsmTbBizAmoutApply record);
}