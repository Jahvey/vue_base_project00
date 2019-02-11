package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConCktsyhPo;
@Mapper
public interface CsmTbConCktsyhPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConCktsyhPo record);

    int insertSelective(CsmTbConCktsyhPo record);

    CsmTbConCktsyhPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConCktsyhPo record);

    int updateByPrimaryKey(CsmTbConCktsyhPo record);
}