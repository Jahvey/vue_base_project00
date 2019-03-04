package com.cdgit.loan.csm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.bean.CsmTbLstInfo;
import com.cdgit.loan.csm.service.CsmTbLstInfoServiceImpl;


@RestController
@RequestMapping("/TbLstInfo")
public class CsmTbLstInfoController {

	@Autowired
	CsmTbLstInfoServiceImpl tbLstInfoServiceImpl;
	
	@GetMapping("/selectByPrimaryKey")
	public CsmTbLstInfo selectByPrimaryKey(@RequestParam("partyId") String partyId) {
		return tbLstInfoServiceImpl.selectByPrimaryKey(partyId);
	}
	
	
	
}
