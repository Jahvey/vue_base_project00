package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbCsmBondInfo;

public interface TbCsmBondInfoMapper {
    int deleteByPrimaryKey(String bondId);

    int insert(TbCsmBondInfo record);

    int insertSelective(TbCsmBondInfo record);

    TbCsmBondInfo selectByPrimaryKey(String bondId);

    int updateByPrimaryKeySelective(TbCsmBondInfo record);

    int updateByPrimaryKey(TbCsmBondInfo record);
}