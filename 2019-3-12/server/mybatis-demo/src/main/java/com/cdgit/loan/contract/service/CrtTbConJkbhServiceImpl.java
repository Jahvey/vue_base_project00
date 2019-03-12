package com.cdgit.loan.contract.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.CrtTbConJkbh;
import com.cdgit.loan.contract.mapper.CrtTbConJkbhMapper;

/**
 * 国际保函
 * @author Administrator
 *
 */
@Service
@org.springframework.transaction.annotation.Transactional
public class CrtTbConJkbhServiceImpl {

	@Autowired
	CrtTbConJkbhMapper conJkbhMapper;
	
	public CrtTbConJkbh getOneCrtTbConJkbhByapplyDetailId(String applyDetailId){
		return conJkbhMapper.selectCrtTbConJkbhByapplyDetailId(applyDetailId);
	};
	
	public CrtTbConJkbh getOneCrtTbConJkbhByContractInfo(String contractId,String amountDetailId){
		HashMap<String,String> map = new HashMap<>();
		map.put("contractId", contractId);
		map.put("amountDetailId", amountDetailId);
		return conJkbhMapper.selectCrtTbConJkbhByContractInfo(map);
	};
	
}
