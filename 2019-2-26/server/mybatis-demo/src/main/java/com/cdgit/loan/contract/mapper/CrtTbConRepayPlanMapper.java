package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbConRepayPlan;

/**
 * 合同还款计划表:Tb_Con_Repay_Plan
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbConRepayPlanMapper {

	//根据合同id查询多条合同还款信息
	List<CrtTbConRepayPlan> selectAllConRepayPlanByContractId(String contractId);

}