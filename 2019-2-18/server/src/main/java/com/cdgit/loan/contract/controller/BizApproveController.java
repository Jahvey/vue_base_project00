package com.cdgit.loan.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.bean.BizApprove;
import com.cdgit.loan.contract.service.BizApproveServiceImpl;

@RestController
@RequestMapping("/bizApprove")
public class BizApproveController {

	@Autowired
	BizApproveServiceImpl bizApproveServiceImpl;
	
	@GetMapping("/getBizApproveByApproveId")
	@ResponseBody
	public BizApprove getBizApproveByApproveId(String approveId){
		return bizApproveServiceImpl.getBizApproveByApproveId(approveId);
	}
	
}
