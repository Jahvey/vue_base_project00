package com.cdgit.loan.ledger.asset.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.ledger.asset.bean.ChSelectWriteOffResult;
import com.cdgit.loan.ledger.asset.service.ChAssetMapperServiceImpl;
import com.cdgit.loan.ledger.naturalperson.bean.NaturealCust;
import com.cdgit.loan.mycustomer.message.PageBean;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/asset")
public class ChAssetController {
	@Autowired
	ChAssetMapperServiceImpl assetMapperServiceImpl;
	//1.核销查询 2.不良资产处置
		@GetMapping("/queryWriteOff")
		public PageBean queryWriteOff(
				@RequestParam(value="pageNum",required=true) int pageNum,
				@RequestParam(value="pageSize",required=true) int pageSize,
				@RequestParam(value="regOrgId",required=false) String regOrgId, 
				@RequestParam(value="userNum",required=false) String userNum,
				@RequestParam(value="partyName",required=false) String partyName,
				@RequestParam(value="certType",required=false) String certType,
				@RequestParam(value="certNum",required=false) String certNum,
				@RequestParam(value="contractNum",required=false) String contractNum,
				@RequestParam(value="summaryNum",required=false) String summaryNum){
			Map map=new HashMap<String,Object>();
			map.put("pageNum", pageNum);
			map.put("pageSize", pageSize);
			map.put("regOrgId", regOrgId);
			map.put("userNum", userNum);	
			map.put("partyName", partyName);
			map.put("certType", certType);
			map.put("certNum", certNum);
			map.put("contractNum", contractNum);
			map.put("summaryNum", summaryNum);
			PageInfo<ChSelectWriteOffResult> selectWriteOffResultList=assetMapperServiceImpl.selectWriteOff(map);
			PageBean pageBean=new PageBean();
			pageBean.setTotal(selectWriteOffResultList.getTotal());
			pageBean.setData(selectWriteOffResultList.getList());
			return pageBean;
		}
	
	
	
}
