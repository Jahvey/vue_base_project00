package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbConPayoutPlan;

/**
 * 合同用款计划表：TB_CON_PAYOUT_PLAN
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbConPayoutPlanMapper {

    int insertSelective(CrtTbConPayoutPlan record);

    CrtTbConPayoutPlan selectByPrimaryKey(String payoutPlanId);

    int updateByPrimaryKeySelective(CrtTbConPayoutPlan record);

}