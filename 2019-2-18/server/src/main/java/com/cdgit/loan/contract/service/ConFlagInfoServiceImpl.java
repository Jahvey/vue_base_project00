package com.cdgit.loan.contract.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.ConFlagInfo;
import com.cdgit.loan.contract.mapper.ConFlagInfoMapper;

/**
 * 合同标志信息表	tb_Con_Flag_Info表
 * @author Administrator
 *
 */
@Service
@org.springframework.transaction.annotation.Transactional
public class ConFlagInfoServiceImpl {

	@Autowired
	ConFlagInfoMapper conFlagInfoMapper;
	
	public ConFlagInfo getselectByPrimaryKey(String flagId){
		return conFlagInfoMapper.selectByPrimaryKey(flagId);
	}
	
	public HashMap<String,String> getSomeThing(String flagId){
		return conFlagInfoMapper.getSomeThing(flagId);
	}
	
}
