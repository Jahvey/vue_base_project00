package com.cdgit.loan.user.mapper;

import com.cdgit.loan.user.bean.TbCsmNaturalPerson;

public interface TbCsmNaturalPersonMapper {
    int deleteByPrimaryKey(String partyId);

    int insert(TbCsmNaturalPerson record);

    int insertSelective(TbCsmNaturalPerson record);

    TbCsmNaturalPerson selectByPrimaryKey(String partyId);

    int updateByPrimaryKeySelective(TbCsmNaturalPerson record);

    int updateByPrimaryKey(TbCsmNaturalPerson record);
}