package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbCsmNaturalPerson;

public interface TbCsmNaturalPersonMapper {
    int deleteByPrimaryKey(String partyId);

    int insert(TbCsmNaturalPerson record);

    int insertSelective(TbCsmNaturalPerson record);

    TbCsmNaturalPerson selectByPrimaryKey(String partyId);

    int updateByPrimaryKeySelective(TbCsmNaturalPerson record);

    int updateByPrimaryKey(TbCsmNaturalPerson record);
}