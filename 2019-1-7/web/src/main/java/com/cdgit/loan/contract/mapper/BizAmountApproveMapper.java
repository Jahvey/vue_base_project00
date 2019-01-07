package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.BizAmountApprove;
/**
 * 申请基本信息表	tb_Biz_Amount_Approve
 * @author Administrator
 *
 */
@Mapper
public interface BizAmountApproveMapper {

	/**
	 * 测试用
	 * @param amountId
	 * @return
	 */
    BizAmountApprove selectByPrimaryKey(String amountId);

}