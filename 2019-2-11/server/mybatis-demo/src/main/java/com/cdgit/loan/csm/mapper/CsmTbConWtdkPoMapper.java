package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConWtdkPo;
@Mapper
public interface CsmTbConWtdkPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConWtdkPo record);

    int insertSelective(CsmTbConWtdkPo record);

    CsmTbConWtdkPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConWtdkPo record);

    int updateByPrimaryKey(CsmTbConWtdkPo record);
}