package com.cdgit.loan.customerManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.bean.NaturalBusiness;

@Mapper
public interface NaturalBusinessMapper {
    int deleteByPrimaryKey(String businessId);

    int insert(NaturalBusiness record);

    int insertSelective(NaturalBusiness record);

    NaturalBusiness selectByPrimaryKey(String businessId);

    int updateByPrimaryKeySelective(NaturalBusiness record);

    int updateByPrimaryKey(NaturalBusiness record);

	List<NaturalBusiness> selectByPartyId(String partyId);
}