package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbLoanLoanrate;

@Mapper
public interface CrtTbLoanLoanrateMapper {

    void insertLoanLoanrateSelective(CrtTbLoanLoanrate record);

    CrtTbLoanLoanrate selectLoanLoanrateByPrimaryKey(String loanrateId);
    
    //根据放款主键loanId查询多条利率信息
    List<CrtTbLoanLoanrate> queryLoanLoanrateListByLoanId(String loanId);

}