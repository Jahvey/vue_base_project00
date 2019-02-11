package com.cdgit.loan.csm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.csm.bean.CsmTbLstInfo;
import com.cdgit.loan.csm.mapper.CsmTbLstInfoMapper;




@Service
@org.springframework.transaction.annotation.Transactional
public class CsmTbLstInfoServiceImpl {
	
	@Autowired
	CsmTbLstInfoMapper tbLstInfoMapper;
	
	public CsmTbLstInfo selectByPrimaryKey(String partyId){
		return tbLstInfoMapper.selectByPrimaryKey(partyId);
	}

}
