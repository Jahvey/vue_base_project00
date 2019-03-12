package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConLoanratePo;

@Mapper
public interface CsmTbConLoanratePoMapper {
    int deleteByPrimaryKey(String loanrateId);

    int insert(CsmTbConLoanratePo record);

    int insertSelective(CsmTbConLoanratePo record);

    CsmTbConLoanratePo selectByPrimaryKey(String loanrateId);

    int updateByPrimaryKeySelective(CsmTbConLoanratePo record);

    int updateByPrimaryKey(CsmTbConLoanratePo record);
    
    CsmTbConLoanratePo queryTbConLoanratePoByConId(String contractId);
}