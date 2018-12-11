package com.cdgit.loan.user.mapper;

import com.cdgit.loan.user.bean.TbCsmBankScale;

public interface TbCsmBankScaleMapper {
    int deleteByPrimaryKey(String ID);

    int insert(TbCsmBankScale record);

    int insertSelective(TbCsmBankScale record);

    TbCsmBankScale selectByPrimaryKey(String ID);

    int updateByPrimaryKeySelective(TbCsmBankScale record);

    int updateByPrimaryKey(TbCsmBankScale record);
}