package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbCsmParty;

public interface TbCsmPartyMapper {
    int deleteByPrimaryKey(String partyId);

    int insert(TbCsmParty record);

    int insertSelective(TbCsmParty record);

    TbCsmParty selectByPrimaryKey(String partyId);

    int updateByPrimaryKeySelective(TbCsmParty record);

    int updateByPrimaryKey(TbCsmParty record);
}