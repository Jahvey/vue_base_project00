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
		
	/**
	 * 获得基准利率
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
	

	/**
	 * 计算到期日期
	 * @param qxdw
	 * @param qx
	 * @param rq
	 * @return
	 */
	@GetMapping("/monthAddDate")
	public String monthAddDate(String qxdw, int qx, String rq){
		String countRate = bizApplyService.addDate(qxdw, qx, rq);
		return countRate;
	}
	
	/**
	 * 按期限单位计算两日期间期限
	 * @param qxdw	期限单位（Y 年,M 月,D 天）
	 * @param qsrq 	起始日期 yyyy-mm-dd(使用时间戳)
	 * @param dqrq  到期日期 yyyy-mm-dd(使用时间戳)
	 * @return
	 */
	@GetMapping("/getTermByEndDate")
	public Integer getTermByEndDate(String qxdw, String qsrq, String dqrq){
		Integer retDateTerm = bizApplyService.retDateTerm(qxdw, qsrq, dqrq);
		return retDateTerm;
	}
	
}
