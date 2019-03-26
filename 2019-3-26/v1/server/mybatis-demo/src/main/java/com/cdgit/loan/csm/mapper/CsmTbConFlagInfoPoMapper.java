package com.cdgit.loan.csm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConFlagInfoPo;

@Mapper
public interface CsmTbConFlagInfoPoMapper {
    int deleteByPrimaryKey(String flagId);

    int insert(CsmTbConFlagInfoPo record);

    int insertSelective(CsmTbConFlagInfoPo record);

    CsmTbConFlagInfoPo selectByPrimaryKey(String flagId);

    int updateByPrimaryKeySelective(CsmTbConFlagInfoPo record);

    int updateByPrimaryKey(CsmTbConFlagInfoPo record);
    
    CsmTbConFlagInfoPo queryOneByConId(String contractId);
}