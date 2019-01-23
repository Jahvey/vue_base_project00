package com.cdgit.loan.customerManage.additiveInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.additiveInfo.bean.AdditiveInfo;

@Mapper
public interface AdditiveInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdditiveInfo record);

    int insertSelective(AdditiveInfo record);

    AdditiveInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdditiveInfo record);

    int updateByPrimaryKey(AdditiveInfo record);

	List<AdditiveInfo> selectByPartyId(String partyId);
}