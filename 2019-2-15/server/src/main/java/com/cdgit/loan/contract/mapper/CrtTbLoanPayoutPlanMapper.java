package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbLoanPayoutPlan;

/**
 * 用款计划表：Tb_Loan_Payout_Plan
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbLoanPayoutPlanMapper {

    int insertSelective(CrtTbLoanPayoutPlan record);

    CrtTbLoanPayoutPlan selectByPrimaryKey(String payoutPlanId);

    int updateByPrimaryKeySelective(CrtTbLoanPayoutPlan record);

}