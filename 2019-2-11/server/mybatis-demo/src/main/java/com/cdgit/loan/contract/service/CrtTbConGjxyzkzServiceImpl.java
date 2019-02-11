package com.cdgit.loan.contract.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.CrtTbConGjxyzkz;
import com.cdgit.loan.contract.mapper.CrtTbConGjxyzkzMapper;

/**
 * 国际信用开证
 * @author Administrator
 *
 */
@Service
@org.springframework.transaction.annotation.Transactional
public class CrtTbConGjxyzkzServiceImpl {

	@Autowired
	CrtTbConGjxyzkzMapper conGjxyzkzMapper;
	
	public CrtTbConGjxyzkz getOneCrtTbConGjxyzkzByapplyDetailId(String applyDetailId){
		return conGjxyzkzMapper.selectCrtTbConGjxyzkzByapplyDetailId(applyDetailId);
	};
	
	public CrtTbConGjxyzkz getOneCrtTbConGjxyzkzByContractInfo(String contractId,String amountDetailId){
		HashMap<String,String> map = new HashMap<>();
		map.put("contractId", contractId);
		map.put("amountDetailId", amountDetailId);
		return conGjxyzkzMapper.selectCrtTbConGjxyzkzByContractInfo(map);
	};
}
