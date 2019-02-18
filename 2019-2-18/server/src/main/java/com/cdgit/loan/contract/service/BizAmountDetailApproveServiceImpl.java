package com.cdgit.loan.contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.BizAmountDetailApprove;
import com.cdgit.loan.contract.mapper.BizAmountDetailApproveMapper;

@Service
@org.springframework.transaction.annotation.Transactional
public class BizAmountDetailApproveServiceImpl {

	@Autowired
	BizAmountDetailApproveMapper amountDetailApproveMapper;
	
	public BizAmountDetailApprove getBizAmountDetailApproveByAmountDetailId(String amountDetailId){
		return amountDetailApproveMapper.queryBizAmountDetailApproveByAmountDetailId(amountDetailId);
	}
	
}
