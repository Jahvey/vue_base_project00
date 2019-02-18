package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbLoanRepayPlan;

/**
 * TB_LOAN_REPAY_PLAN:还款计划表
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbLoanRepayPlanMapper {

    int insertSelective(CrtTbLoanRepayPlan record);

    CrtTbLoanRepayPlan selectByPrimaryKey(String repayPlanId);

    int updateByPrimaryKeySelective(CrtTbLoanRepayPlan record);

}