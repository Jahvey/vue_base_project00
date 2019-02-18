package com.cdgit.loan.contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.BizApprove;
import com.cdgit.loan.contract.mapper.BizApproveMapper;

@Service
@org.springframework.transaction.annotation.Transactional
public class BizApproveServiceImpl {

	@Autowired
	BizApproveMapper bizApproveMapper;
	
	public BizApprove getBizApproveByApproveId(String approveId){
		return bizApproveMapper.queryBizApproveByApproveId(approveId);
	}
	
}
