/**
 * 
 */
package com.cdgit.loan.csm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.bean.CsmBankFinancingListVo;
import com.cdgit.loan.csm.bean.CsmBankFinancingListYWVo;
import com.cdgit.loan.csm.bean.CsmBankGuaranteeListVo;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.service.CsmBankInfoServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@RestController
@RequestMapping("myBank")
public class CsmBankInfoController {
	
	@Autowired
	CsmBankInfoServiceImpl csmBankInfoServiceImpl;
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getGuaranteeListDY")
	public PageBean getGuaranteeListDY(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId
	
			){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		
		map.put("partyId", partyId);
		

	
		PageInfo<CsmBankGuaranteeListVo> CsmBankGuaranteeListVo = csmBankInfoServiceImpl.getGuaranteeListDY(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmBankGuaranteeListVo.getTotal());
		pageBean.setData(CsmBankGuaranteeListVo.getList());
		
		return pageBean;

		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getGuaranteeList")
	public PageBean getGuaranteeList(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId
	
			){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		
		map.put("partyId", partyId);
		

	
		PageInfo<CsmBankGuaranteeListVo> CsmBankGuaranteeListVo = csmBankInfoServiceImpl.getGuaranteeList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmBankGuaranteeListVo.getTotal());
		pageBean.setData(CsmBankGuaranteeListVo.getList());
		
		return pageBean;

		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getfinancingListYW")
	public PageBean getfinancingListYW(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId,
			@RequestParam(value="partyTypeCd",required=false)String partyTypeCd
			){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		
		map.put("partyId", partyId);
		map.put("partyTypeCd", partyTypeCd);

	
		PageInfo<CsmBankFinancingListYWVo> CsmBankFinancingListYWVo = csmBankInfoServiceImpl.getfinancingListYW(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmBankFinancingListYWVo.getTotal());
		pageBean.setData(CsmBankFinancingListYWVo.getList());
		
		return pageBean;

		
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getfinancingList")
	public PageBean getfinancingList(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId
			){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		

		map.put("partyId", partyId);

	
		PageInfo<CsmBankFinancingListVo> CsmBankFinancingListVo = csmBankInfoServiceImpl.getfinancingList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmBankFinancingListVo.getTotal());
		pageBean.setData(CsmBankFinancingListVo.getList());
		
		return pageBean;

		
	}
	
	
}
