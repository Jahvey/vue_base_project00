package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbCsmInvestmentInfo;

public interface TbCsmInvestmentInfoMapper {
    int deleteByPrimaryKey(String investmentId);

    int insert(TbCsmInvestmentInfo record);

    int insertSelective(TbCsmInvestmentInfo record);

    TbCsmInvestmentInfo selectByPrimaryKey(String investmentId);

    int updateByPrimaryKeySelective(TbCsmInvestmentInfo record);

    int updateByPrimaryKey(TbCsmInvestmentInfo record);
}