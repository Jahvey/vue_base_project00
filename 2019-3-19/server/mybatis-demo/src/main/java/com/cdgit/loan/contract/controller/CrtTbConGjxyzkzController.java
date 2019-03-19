package com.cdgit.loan.contract.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.bean.CrtTbConGjxyzkz;
import com.cdgit.loan.contract.bean.CrtTbConJkbh;
import com.cdgit.loan.contract.service.CrtTbConGjxyzkzServiceImpl;

@RestController
@RequestMapping("/crtTbConGjxyzkz")
public class CrtTbConGjxyzkzController {

	@Autowired
	CrtTbConGjxyzkzServiceImpl conGjxyzkzService;
	
	@GetMapping("/getCrtTbConGjxyzkzByApplyDetailId")//ff80808165c6555f0165c68526ea00ee
	public CrtTbConGjxyzkz getCrtTbConGjxyzkzByApplyDetailId(String applyDetailId){
		return conGjxyzkzService.getOneCrtTbConGjxyzkzByapplyDetailId(applyDetailId);
	}
	
//	@GetMapping("/testDemo")//yingshoushiren
//	public CrtTbConGjxyzkz getOneCrtTbConGjxyzkzByContractInfo(){
//		HashMap<String,String> map = new HashMap<>();
//		map.put("contractId", "ff80808165c6555f0165c68526e000ed");
//		map.put("amountDetailId", "ff80808165c6555f0165c666ee3e008a");
//		return conGjxyzkzService.getOneCrtTbConGjxyzkzByContractInfo(map);
//	}
	
}
