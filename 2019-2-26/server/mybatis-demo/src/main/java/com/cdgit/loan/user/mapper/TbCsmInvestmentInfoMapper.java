package com.cdgit.loan.user.mapper;

import com.cdgit.loan.user.bean.TbCsmInvestmentInfo;

public interface TbCsmInvestmentInfoMapper {
    int deleteByPrimaryKey(String investmentId);

    int insert(TbCsmInvestmentInfo record);

    int insertSelective(TbCsmInvestmentInfo record);

    TbCsmInvestmentInfo selectByPrimaryKey(String investmentId);

    int updateByPrimaryKeySelective(TbCsmInvestmentInfo record);

    int updateByPrimaryKey(TbCsmInvestmentInfo record);
}