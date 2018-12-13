package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbConLoanChange;

public interface TbConLoanChangeMapper {
    int deleteByPrimaryKey(String changeId);

    int insert(TbConLoanChange record);

    int insertSelective(TbConLoanChange record);

    TbConLoanChange selectByPrimaryKey(String changeId);

    int updateByPrimaryKeySelective(TbConLoanChange record);

    int updateByPrimaryKey(TbConLoanChange record);
}