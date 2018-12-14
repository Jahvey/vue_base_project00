package com.cdgit.loan.csm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.csm.bean.TbLstInfo;
import com.cdgit.loan.csm.mapper.TbLstInfoMapper;




@Service
@org.springframework.transaction.annotation.Transactional
public class TbLstInfoServiceImpl {
	
	@Autowired
	TbLstInfoMapper tbLstInfoMapper;
	
	public TbLstInfo selectByPrimaryKey(String partyId){
		return tbLstInfoMapper.selectByPrimaryKey(partyId);
	}

}
