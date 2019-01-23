package com.cdgit.loan.customerManage.creditInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.creditInfo.bean.CreditInfo;

@Mapper
public interface CreditInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(CreditInfo record);

    int insertSelective(CreditInfo record);

    CreditInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CreditInfo record);

    int updateByPrimaryKey(CreditInfo record);

	List<CreditInfo> selectByPartyId(String partyId);
}