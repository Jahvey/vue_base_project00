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

import com.cdgit.loan.csm.bean.CsmHisIrmVo;
import com.cdgit.loan.csm.bean.CsmImpornantEventVo;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.service.CsmIrmApplyServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@RestController
@RequestMapping("corporation")
public class CsmIrmApplyController {

	@Autowired
	CsmIrmApplyServiceImpl csmIrmApplyServiceImpl;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getHisIrmByParty")
	public PageBean getHisIrmByParty(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="thirdPartyTypeCd",required=false)String thirdPartyTypeCd,
			@RequestParam(value="userNum",required=false)String userNum,
			@RequestParam(value="orgNum",required=false)String orgNum,
			@RequestParam(value="partyId",required=false)String partyId){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		

		map.put("partyId", partyId);
		map.put("thirdPartyTypeCd", thirdPartyTypeCd);
		map.put("userNum", userNum);
		map.put("orgNum", orgNum);
	
		PageInfo<CsmHisIrmVo> CsmHisIrmVo =csmIrmApplyServiceImpl.getHisIrmByParty(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmHisIrmVo.getTotal());
		pageBean.setData(CsmHisIrmVo.getList());
		
		return pageBean;

		
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getCsmImpornantEventInfo")
	public PageBean getCsmImpornantEventInfo(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="qote",required=false)String qote,
			@RequestParam(value="zdsjlx",required=false)String zdsjlx,
			@RequestParam(value="zdsjbz",required=false)String zdsjbz,
			@RequestParam(value="partyId",required=false)String partyId){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		

		map.put("partyId", partyId);
		map.put("qote", qote);
		map.put("zdsjlx", zdsjlx);
		map.put("zdsjbz", zdsjbz);
	
		PageInfo<CsmImpornantEventVo> CsmImpornantEventVo =csmIrmApplyServiceImpl.getCsmImpornantEventInfo(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmImpornantEventVo.getTotal());
		pageBean.setData(CsmImpornantEventVo.getList());
		
		return pageBean;

		
	}
	

}
