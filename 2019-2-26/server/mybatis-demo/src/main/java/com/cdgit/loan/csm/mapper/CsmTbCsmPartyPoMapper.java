package com.cdgit.loan.csm.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbCsmPartyPo;

@Mapper
public interface CsmTbCsmPartyPoMapper {
    int deleteByPrimaryKey(String partyId);

    int insert(CsmTbCsmPartyPo record);

    int insertSelective(CsmTbCsmPartyPo record);

    CsmTbCsmPartyPo selectByPrimaryKey(String partyId);

    int updateByPrimaryKeySelective(CsmTbCsmPartyPo record);

    int updateByPrimaryKey(CsmTbCsmPartyPo record);
}