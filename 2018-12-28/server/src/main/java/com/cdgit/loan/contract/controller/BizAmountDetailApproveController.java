package com.cdgit.loan.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdgit.loan.contract.bean.BizAmountDetailApprove;
import com.cdgit.loan.contract.service.BizAmountDetailApproveServiceImpl;


@Controller
@RequestMapping("/bizAmountDetailApprove")
public class BizAmountDetailApproveController {
	
	@Autowired
	private BizAmountDetailApproveServiceImpl amountDetailApproveServiceImpl;
	
	@RequestMapping("/getBizAmountDetailApproveById")
	@ResponseBody
	public BizAmountDetailApprove getBizAmountDetailApproveById(String approveId){
		return amountDetailApproveServiceImpl.getTbCsmNaturalPersonById(approveId);
	}

}
