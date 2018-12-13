package com.cdgit.loan.csm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.csm.bean.TbConContractInfo;
import com.cdgit.loan.csm.mapper.TbConContractInfoMapper;

@Service
@org.springframework.transaction.annotation.Transactional
public class TbConContractInfoServiceImpl {

	@Autowired
	TbConContractInfoMapper tbConContractInfoMapper;
	
	
	public TbConContractInfo selectByPrimaryKey(String contractId) {
		return tbConContractInfoMapper.selectByPrimaryKey(contractId);
		
	}
	
	
	
	
	
	
	
}
