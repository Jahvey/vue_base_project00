package com.cdgit.loan.user.mapper;

import com.cdgit.loan.user.bean.TbCsmBondInfo;

public interface TbCsmBondInfoMapper {
    int deleteByPrimaryKey(String bondId);

    int insert(TbCsmBondInfo record);

    int insertSelective(TbCsmBondInfo record);

    TbCsmBondInfo selectByPrimaryKey(String bondId);

    int updateByPrimaryKeySelective(TbCsmBondInfo record);

    int updateByPrimaryKey(TbCsmBondInfo record);
}