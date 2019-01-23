package com.cdgit.loan.customerManage.entrustAccount.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.entrustAccount.bean.EntrustAccount;

@Mapper
public interface EntrustAccountMapper {
    int deleteByPrimaryKey(String accId);

    int insert(EntrustAccount record);

    int insertSelective(EntrustAccount record);

    EntrustAccount selectByPrimaryKey(String accId);

    int updateByPrimaryKeySelective(EntrustAccount record);

    int updateByPrimaryKey(EntrustAccount record);
    
    List<EntrustAccount> selectByPartyId(String partyId);
}