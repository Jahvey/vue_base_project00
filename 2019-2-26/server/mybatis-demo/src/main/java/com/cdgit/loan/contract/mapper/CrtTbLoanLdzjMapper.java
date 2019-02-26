package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbLoanLdzj;

/**
 * TB_LOAN_LDZJ:01-流动资金贷款批复
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbLoanLdzjMapper {

    void insertLoanLdzjSelective(CrtTbLoanLdzj record);

    CrtTbLoanLdzj selectLoanLdzjByPrimaryKey(String applyDetailId);

    int updateLoanLdzj(CrtTbLoanLdzj record);

}