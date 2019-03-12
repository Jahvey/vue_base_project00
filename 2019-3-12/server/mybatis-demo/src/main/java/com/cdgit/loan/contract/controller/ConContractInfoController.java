package com.cdgit.loan.contract.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.contract.bean.ConApvList;
import com.cdgit.loan.contract.bean.TbConContractInfo;
import com.cdgit.loan.contract.message.PageBean;
import com.cdgit.loan.contract.query.ConApvListQuery;
import com.cdgit.loan.contract.query.ConInfoHtXwQuery;
import com.cdgit.loan.contract.service.ConContractInfoServiceImpl;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/conContractInfo")
public class ConContractInfoController {

	@Autowired
	ConContractInfoServiceImpl conContractInfoServiceImpl;
	
	@GetMapping("/getConContractInfoByContractId")
	public TbConContractInfo getConContractInfoByContractId(String contractId){
		return conContractInfoServiceImpl.getConContractInfoByContractId(contractId);
	}
	
	@GetMapping("/getOneConContractInfo")
	public Map<String,Object> getOneConContractInfo(String contractId){
		 TbConContractInfo contractInfo = conContractInfoServiceImpl.getConContractInfoByContractId(contractId);
		 ConInfoHtXwQuery baseInfo = conContractInfoServiceImpl.getContractBaseInfo(contractId);
		 Map<String,Object> map = new HashMap<>();
		 map.put("contractInfo", contractInfo);
		 map.put("baseInfo", baseInfo);
		 return map;
	
	}
	
	/**
	 * 分页
	 * @param pageNum：当前页
	 * @param pageSize：每页条数
	 * @return
	 * @RequestParam(value="pageSize",required=true)	默认是true？？？？
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/queryConApvList")
	public PageBean queryConApvList(@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="partyName",required=false)String partyName,
			@RequestParam(value="conStatus",required=false)String conStatus,
			@RequestParam(value="contractNum",required=false)String contractNum,
			@RequestParam(value="certType",required=false)String certType,
			@RequestParam(value="certNum",required=false)String certNum,
			@RequestParam(value="productType",required=false)String productType){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);
		map.put("conStatus", conStatus);
		map.put("contractNum", contractNum);
		map.put("certType", certType);
		map.put("certNum", certNum);
		map.put("productType", productType);
		PageInfo<ConApvList> conApvList = conContractInfoServiceImpl.queryConApvList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(conApvList.getTotal());
		pageBean.setData(conApvList.getList());
		return pageBean;
	}
	
	//自定义分页
	@GetMapping("/queryConApvList1")
	public PageInfo<ConApvList> queryConApvList1(ConApvListQuery conApvListQuery){
		
		return conContractInfoServiceImpl.queryConApvList1(conApvListQuery);

	}
	
	//有问题
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/getConInfoByContractNum")
	public ConInfoHtXwQuery getConInfoByContractNum(@RequestParam(value="contractNum",required=true)String contractNum,
			@RequestParam(value="conStatus",required=true)String conStatus,
			@RequestParam(value="userId",required=false)String userId,
			@RequestParam(value="orgNum",required=false)String orgNum){
		Map map=new HashMap<String,Object>();
		map.put("contractNum", contractNum);
		map.put("conStatus", conStatus);
		map.put("userId", userId);
		map.put("orgNum", orgNum);
		return conContractInfoServiceImpl.getConInfoByContractNum(map);
	}
	
	/**
	 * 查询主合同(小微)基本信息
	 * @param contractId
	 */
	@GetMapping("/getMainConInfoBaseInfo")
	public ConInfoHtXwQuery getMainCrtBaseInfo(String contractId){
		return conContractInfoServiceImpl.getContractBaseInfo(contractId);
	}
		
}
