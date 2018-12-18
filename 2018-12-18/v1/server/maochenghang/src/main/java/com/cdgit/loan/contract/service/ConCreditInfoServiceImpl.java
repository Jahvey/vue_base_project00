package com.cdgit.loan.contract.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.ConApvList;
import com.cdgit.loan.contract.bean.ConCreditInfo;
import com.cdgit.loan.contract.mapper.ConCreditInfoMapper;
import com.cdgit.loan.contract.query.ConApvListQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 综合授信协议信息表
 * @author Administrator
 *
 */
@Service
@org.springframework.transaction.annotation.Transactional
public class ConCreditInfoServiceImpl {

	@Autowired
	ConCreditInfoMapper conCreditInfoMapper;
	
	public ConCreditInfo getselectByPrimaryKey(String contractId){
		return conCreditInfoMapper.selectByPrimaryKey(contractId);
	}
	
}
