package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbConPayoutPlan;

/**
 * 合同用款计划表：TB_CON_PAYOUT_PLAN
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbConPayoutPlanMapper {

	//根据合同id查询多条合同用款计划
    List<CrtTbConPayoutPlan> selectAllConPayoutPlanByContractId(String contractId);

}