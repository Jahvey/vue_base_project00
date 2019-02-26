package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizApplyPo;

@Mapper
public interface CsmTbBizApplyPoMapper {
    int deleteByPrimaryKey(String applyId);

    int insert(CsmTbBizApplyPo record);

    int insertSelective(CsmTbBizApplyPo record);

    CsmTbBizApplyPo selectByPrimaryKey(String applyId);

    int updateByPrimaryKeySelective(CsmTbBizApplyPo record);

    int updateByPrimaryKey(CsmTbBizApplyPo record);
}