package com.cdgit.ledger.pubquery.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.ledger.pubquery.resultbean.CustRateInfoResult;
import com.cdgit.ledger.pubquery.resultbean.MonitorLedgerResult;
import com.cdgit.ledger.pubquery.service.ChTbLoanZhMapperImpl;
import com.cdgit.loan.mycustomer.message.PageBean;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/monitorQuery")
public class ChTbLoanZhController {
	
	@Autowired
	ChTbLoanZhMapperImpl chTbLoanZhMapperImpl;
	
	//监控查询
	@GetMapping("/queryMonitorLedger")
	public PageBean queryMonitorLedger(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="productType",required=false) String productType,
			@RequestParam(value="contractNum",required=false) String contractNum,
			@RequestParam(value="summaryNum",required=false) String summaryNum,
			@RequestParam(value="beginDate",required=false) String beginDate,
			@RequestParam(value="endDate",required=false) String endDate,
			@RequestParam(value="summaryAmt1",required=false) String summaryAmt1,
			@RequestParam(value="ts",required=false) String ts,
			@RequestParam(value="jklx",required=false) String jklx){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("certNum", certNum);
		map.put("certType", certType);
		map.put("jklx", jklx);
		map.put("orgNum", orgNum);
		map.put("productType", productType);
		map.put("contractNum", contractNum);	
		map.put("summaryNum", summaryNum);
		map.put("beginDate", beginDate);
		map.put("endDate", endDate);
		map.put("summaryAmt1", summaryAmt1);
		map.put("ts", ts);
		PageInfo<MonitorLedgerResult> monitorLedgerResultList =
				chTbLoanZhMapperImpl.selectMonitorLedger(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(monitorLedgerResultList.getTotal());
		pageBean.setData(monitorLedgerResultList.getList());
		return pageBean;
	}
	

	
	
	
}
