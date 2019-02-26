package com.cdgit.loan.contract.controller;

import java.util.HashMap;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.bean.CrtTbConJkbh;
import com.cdgit.loan.contract.service.CrtTbConJkbhServiceImpl;

@RestController
@RequestMapping("/CrtTbConJkbh")
public class CrtTbConjkbhController {

	@Autowired
	CrtTbConJkbhServiceImpl conJkbhService;
	
	@GetMapping("/getCrtTbConJkbhByApplyDetailId")//yingshoushiren
	public CrtTbConJkbh getCrtTbConJkbhByApplyDetailId(String applyDetailId){
		return conJkbhService.getOneCrtTbConJkbhByapplyDetailId(applyDetailId);
	}
	
//	@GetMapping("/testDemo")//yingshoushiren
//	public CrtTbConJkbh getOneCrtTbConJkbhByContractInfo(){
//		HashMap<String,String> map = new HashMap<>();
//		map.put("contractId", "woshicontractid");
//		map.put("amountDetailId", "woshiamountdetailid");
//		return conJkbhService.getOneCrtTbConJkbhByContractInfo(map);
//	}
	
}
