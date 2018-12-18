package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.TbConContractInfo;
import com.cdgit.loan.csm.bean.TbLoanSummary;

@Mapper
public interface TbConContractInfoMapper {
    int insert(TbConContractInfo record);

    int insertSelective(TbConContractInfo record);
    
    TbConContractInfo selectByPrimaryKey(String contractId);
    
}