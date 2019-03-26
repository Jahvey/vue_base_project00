package com.cdgit.loan.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.bean.BizAmountApprove;
import com.cdgit.loan.contract.service.BizAmountApproveServiceImpl;

/**
 * 申请基本信息表	tb_Biz_Amount_Approve
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/bizAmountApprove")
public class BizAmountApproveController {

	@Autowired
	BizAmountApproveServiceImpl amountApproveServiceImpl;
	
	@GetMapping("/selectByPrimaryKey")
	@ResponseBody
	public BizAmountApprove getBizAmountApproveByAmountId(String amountId){
		return amountApproveServiceImpl.getBizAmountApproveByAmountId(amountId);
	}
	
}
