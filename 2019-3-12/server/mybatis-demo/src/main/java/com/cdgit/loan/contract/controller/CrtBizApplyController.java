package com.cdgit.loan.contract.controller;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.service.CrtBizApplyServiceImpl;

/**
 * @author mch
 */
@RestController
@RequestMapping("/bizApply")
public class CrtBizApplyController {
	
	@Autowired
	CrtBizApplyServiceImpl bizApplyService;
	
//	@GetMapping("/getBasicrate")
//	public Serializable getBasicrate(){
//		String beginDate="1536422400000";
//		String endDate="1544284800000";
//		Serializable countRate = bizApplyService.countRate(beginDate, endDate);
//		return countRate;
//	}
	
	/**
	 * 获得基准利率
	 * 前台传过来的不是date格式，还是String类型	Date beginDate,Date endDate
	 * @param beginDate
	 * @param endDate
	 * @param productType
	 * @return
	 */
	@GetMapping("/getBasicrate")
	public Serializable getBasicrate(String beginDate,String endDate,String productType){
		Serializable countRate = bizApplyService.countRate(beginDate, endDate, productType);
		return countRate;
	}
	
}
