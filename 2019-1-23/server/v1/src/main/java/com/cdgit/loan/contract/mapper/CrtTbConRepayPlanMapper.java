package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbConRepayPlan;

/**
 * 合同还款计划表:Tb_Con_Repay_Plan
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbConRepayPlanMapper {

    int insertSelective(CrtTbConRepayPlan record);

    CrtTbConRepayPlan selectByPrimaryKey(String repayPlanId);

    int updateByPrimaryKeySelective(CrtTbConRepayPlan record);

}