package com.cdgit.loan.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.contract.bean.CrtTbLoanHpAmt;
import com.cdgit.loan.contract.service.CrtTbLoanHpAmtServiceImpl;

@RestController
@RequestMapping("/loanHpAmt")
public class CrtTbLoanHpAmtController {

	@Autowired
	CrtTbLoanHpAmtServiceImpl loanHpAmtService;
	
	@GetMapping("/getLoanHpAmtByMoneyUseId")//yingshoushiren
	public CrtTbLoanHpAmt getCrtTbLoanHpAmtByMoneyUseId(String moneyUseId){
		return loanHpAmtService.getLoanHpAmtInfoByMoneyUseId(moneyUseId);
	}
	
	@GetMapping("/insertLoanHpAmt")//yingshoushiren
	public String insertLoanHpAmt(){
		CrtTbLoanHpAmt record = new CrtTbLoanHpAmt();
		String uuid = UUIDGenerator.getUUID();
		record.setMoneyUseId(uuid);
		loanHpAmtService.insertCrtTbLoanHpAmtSelective(record);
		return uuid;
	}
	
	
}
