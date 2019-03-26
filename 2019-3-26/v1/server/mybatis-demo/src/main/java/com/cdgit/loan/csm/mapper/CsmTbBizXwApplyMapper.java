package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmTbBizXwApply;

@Mapper
public interface CsmTbBizXwApplyMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizXwApply record);

    int insertSelective(CsmTbBizXwApply record);

    CsmTbBizXwApply selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizXwApply record);

    int updateByPrimaryKey(CsmTbBizXwApply record);
}