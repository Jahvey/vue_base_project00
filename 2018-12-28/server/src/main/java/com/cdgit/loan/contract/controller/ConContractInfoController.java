package com.cdgit.loan.contract.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
	private static final Log log =  LogFactory.getLog(ConContractInfoController.class);

	@Autowired
	ConContractInfoServiceImpl conContractInfoServiceImpl;
	
	@GetMapping("/getTbConContractInfoById")
	public TbConContractInfo getTbConContractInfoById(String contractId){
		return conContractInfoServiceImpl.getTbCsmNaturalPersonById(contractId);
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
	
	/**
	 * 根据合同编号查询详细信息
	 * 除了合同号之外，前台必须传递：
	 * 	经办人userId（对应合同表TB_CON_CONTRACT_INFO字段USER_NUM）	必填，先在sql写死
	 * 	经办机构orgNum（对应合同表TB_CON_CONTRACT_INFO字段ORG_NUM）	必填，先在sql写死
	 * 	合同状态conStatus（对应合同表TB_CON_CONTRACT_INFO字段CON_STATUS，默认03已生效）
	 * @param contractNum
	 * @return
	 */
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
//		for (int i = 0; i < 20; i++) {
//			log.debug("my conStatus........................"+conStatus);
//		}
//		
		
		return conContractInfoServiceImpl.getConInfoByContractNum(map);
	}
	
}
