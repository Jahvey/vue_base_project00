package com.cdgit.loan.contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.BizAmountApprove;
import com.cdgit.loan.contract.mapper.BizAmountApproveMapper;

/**
 * 申请基本信息表		tb_Biz_Amount_Approve
 * @author Administrator
 *
 */
@Service
@org.springframework.transaction.annotation.Transactional
public class BizAmountApproveServiceImpl {

	@Autowired
	BizAmountApproveMapper amountApproveMapper;
	
	public BizAmountApprove getBizAmountApproveByAmountId(String amountId){
		return amountApproveMapper.queryBizAmountApproveByAmountId(amountId);
	}
	
}
