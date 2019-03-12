package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbLoanZh;

@Mapper
public interface CrtTbLoanZhMapper {

    void insertLoanZhSelective(CrtTbLoanZh record);

    CrtTbLoanZh selectLoanZhByPrimaryKey(String id);
    
    //根据出账id查询多条账户信息
    List<CrtTbLoanZh> getLoanAccInfoList(String loanId);

}