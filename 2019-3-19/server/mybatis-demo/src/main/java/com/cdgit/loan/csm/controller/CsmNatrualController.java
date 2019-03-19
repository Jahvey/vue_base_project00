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

import com.cdgit.loan.csm.bean.CsmIllegalListVo;
import com.cdgit.loan.csm.bean.CsmNaturalAdditiveListVo;
import com.cdgit.loan.csm.bean.CsmNaturalBusinessVo;
import com.cdgit.loan.csm.bean.CsmNaturalCreditListVo;
import com.cdgit.loan.csm.bean.CsmNaturalInfoVo;
import com.cdgit.loan.csm.bean.CsmNaturalSchoolVo;
import com.cdgit.loan.csm.bean.CsmRelativePsnListVo;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.service.CsmNatrualServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@RestController
@RequestMapping("natural")
public class CsmNatrualController {

	@Autowired
	CsmNatrualServiceImpl csmNatrualServiceImpl;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getNaturalInfo")
	public PageBean getNaturalInfo(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		

		map.put("partyId", partyId);
	
		PageInfo<CsmNaturalInfoVo> CsmNaturalInfoVo = csmNatrualServiceImpl.getNaturalInfo(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmNaturalInfoVo.getTotal());
		pageBean.setData(CsmNaturalInfoVo.getList());
		
		return pageBean;

		
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getRelativePsnList")
	public PageBean getRelativePsnList(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		

		map.put("partyId", partyId);
	
		PageInfo<CsmRelativePsnListVo> CsmRelativePsnListVo = csmNatrualServiceImpl.getRelativePsnList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmRelativePsnListVo.getTotal());
		pageBean.setData(CsmRelativePsnListVo.getList());
		
		return pageBean;

		
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/queryNaturalBusiness")
	public PageBean queryNaturalBusiness(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		

		map.put("partyId", partyId);
	
		PageInfo<CsmNaturalBusinessVo> CsmNaturalBusinessVo = csmNatrualServiceImpl.queryNaturalBusiness(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmNaturalBusinessVo.getTotal());
		pageBean.setData(CsmNaturalBusinessVo.getList());
		
		return pageBean;

		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/queryNaturalSchool")
	public PageBean queryNaturalSchool(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId,
			@RequestParam(value="qote",required=false)String qote,
			@RequestParam(value="partyNum",required=false)String partyNum,
			@RequestParam(value="partyTypeCd",required=false)String partyTypeCd){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		

		map.put("partyId", partyId);
		map.put("qote", qote);
		map.put("partyNum", partyNum);
		map.put("partyTypeCd", partyTypeCd);
	
		PageInfo<CsmNaturalSchoolVo> CsmNaturalSchoolVo = csmNatrualServiceImpl.queryNaturalSchool(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmNaturalSchoolVo.getTotal());
		pageBean.setData(CsmNaturalSchoolVo.getList());
		
		return pageBean;

		
	}
	
	
	//自然人客户信用信息
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getNaturalCreditList")
	public PageBean getNaturalCreditList(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId,
			@RequestParam(value="qote",required=false)String qote,
			@RequestParam(value="partyTypeCd",required=false)String partyTypeCd){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		

		map.put("partyId", partyId);
		map.put("qote", qote);
		map.put("partyTypeCd", partyTypeCd);
	
		PageInfo<CsmNaturalCreditListVo> CsmNaturalCreditListVo = csmNatrualServiceImpl.getNaturalCreditList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmNaturalCreditListVo.getTotal());
		pageBean.setData(CsmNaturalCreditListVo.getList());
		
		return pageBean;

		
	}
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getAdditiveList")
	public PageBean getAdditiveList(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId,
			@RequestParam(value="qote",required=false)String qote,
			@RequestParam(value="partyTypeCd",required=false)String partyTypeCd){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		

		map.put("partyId", partyId);
		map.put("qote", qote);
		map.put("partyTypeCd", partyTypeCd);
	
		PageInfo<CsmNaturalAdditiveListVo> CsmNaturalAdditiveListVo = csmNatrualServiceImpl.getAdditiveList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmNaturalAdditiveListVo.getTotal());
		pageBean.setData(CsmNaturalAdditiveListVo.getList());
		
		return pageBean;

		
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getIllegalList")
	public PageBean getIllegalList(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId,
			@RequestParam(value="qote",required=false)String qote,
			@RequestParam(value="partyTypeCd",required=false)String partyTypeCd){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		

		map.put("partyId", partyId);
		map.put("qote", qote);
		map.put("partyTypeCd", partyTypeCd);
	
		PageInfo<CsmIllegalListVo> CsmIllegalListVo = csmNatrualServiceImpl.getIllegalList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmIllegalListVo.getTotal());
		pageBean.setData(CsmIllegalListVo.getList());
		
		return pageBean;

		
	}
}
