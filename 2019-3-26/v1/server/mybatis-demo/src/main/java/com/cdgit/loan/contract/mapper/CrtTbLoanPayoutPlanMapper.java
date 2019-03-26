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

	//选择插入一条放款信息的用款计划
    void insertLoanPayoutPlanSelective(CrtTbLoanPayoutPlan record);

    CrtTbLoanPayoutPlan selectLoanPayoutPlanByPrimaryKey(String payoutPlanId);

    void updateByPrimaryKeySelective(CrtTbLoanPayoutPlan record);

}