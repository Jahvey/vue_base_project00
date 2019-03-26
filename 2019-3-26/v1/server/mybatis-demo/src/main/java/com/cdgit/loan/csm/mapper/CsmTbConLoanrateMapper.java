package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmTbConLoanrate;

@Mapper
public interface CsmTbConLoanrateMapper {
    int deleteByPrimaryKey(String loanrateId);

    int insert(CsmTbConLoanrate record);

    int insertSelective(CsmTbConLoanrate record);

    CsmTbConLoanrate selectByPrimaryKey(String loanrateId);

    int updateByPrimaryKeySelective(CsmTbConLoanrate record);

    int updateByPrimaryKey(CsmTbConLoanrate record);
}