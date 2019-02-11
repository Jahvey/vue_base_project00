package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConJkdsyhPo;
@Mapper
public interface CsmTbConJkdsyhPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConJkdsyhPo record);

    int insertSelective(CsmTbConJkdsyhPo record);

    CsmTbConJkdsyhPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConJkdsyhPo record);

    int updateByPrimaryKey(CsmTbConJkdsyhPo record);
}