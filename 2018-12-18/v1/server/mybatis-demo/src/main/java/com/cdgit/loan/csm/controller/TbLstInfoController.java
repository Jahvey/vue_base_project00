package com.cdgit.loan.csm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.bean.TbLstInfo;
import com.cdgit.loan.csm.service.TbLstInfoServiceImpl;


@RestController
@RequestMapping("/TbLstInfo")
public class TbLstInfoController {

	@Autowired
	TbLstInfoServiceImpl tbLstInfoServiceImpl;
	
	@GetMapping("/selectByPrimaryKey")
	public TbLstInfo selectByPrimaryKey(@RequestParam("partyId") String partyId) {
		return tbLstInfoServiceImpl.selectByPrimaryKey(partyId);
	}
	
	
	
}
