package com.cdgit.loan.customerManage.party.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.party.bean.Party;

@Mapper
public interface PartyMapper {
    int deleteByPrimaryKey(String partyId);

    int insert(Party record);

    int insertSelective(Party record);

    Party selectByPrimaryKey(String partyId);

    int updateByPrimaryKeySelective(Party record);

    int updateByPrimaryKey(Party record);
}