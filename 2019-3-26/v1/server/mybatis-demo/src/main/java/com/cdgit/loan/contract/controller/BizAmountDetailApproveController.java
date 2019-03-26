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
	
	/**
	 * 没有主键
	 * @param amountDetailId
	 * @return
	 */
	@RequestMapping("/getBizAmountDetailApproveByAmountDetailId")
	@ResponseBody
	public BizAmountDetailApprove getBizAmountDetailApproveByAmountDetailId(String amountDetailId){
		return amountDetailApproveServiceImpl.getBizAmountDetailApproveByAmountDetailId(amountDetailId);
	}

}
