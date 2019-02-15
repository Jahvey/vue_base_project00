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

import com.cdgit.loan.csm.bean.CsmBizInfoBaseVo;
import com.cdgit.loan.csm.bean.CsmBizMainVo;
import com.cdgit.loan.csm.bean.CsmPartyBasisVo;
import com.cdgit.loan.csm.bean.CsmTbBizApprove;
import com.cdgit.loan.csm.mapper.CsmBizInfoVoMapper;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.service.CsmBizInfoVoServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@RestController
@RequestMapping("BizInfo")
public class CsmBizInfoVoController {
	
	@Autowired
	CsmBizInfoVoServiceImpl csmBizInfoVoServiceImpl;
	
	@Autowired
	CsmBizInfoVoMapper csmBizInfoVoMapper;
	
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getBizInfo")
	public CsmBizInfoBaseVo getBizInfo(
			@RequestParam(value="qcsm",required=false)String qcsm,
			@RequestParam(value="approveId",required=false)String approveId){
		
		Map map=new HashMap<String,Object>();
		map.put("approveId", approveId);
		map.put("qcsm","1");

		CsmBizInfoBaseVo CsmBizInfoVo =csmBizInfoVoServiceImpl.getBizInfo(map);		
		return CsmBizInfoVo;
		
	}
	

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getPartyBasis")
	public CsmPartyBasisVo getPartyBasis(
			@RequestParam(value="partyId",required=true)String partyId){
		CsmPartyBasisVo CsmPartyBasisVo =csmBizInfoVoServiceImpl.getPartyBasis(partyId);
		return CsmPartyBasisVo;
	
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getBizMain")
	public CsmBizMainVo getBizMain(
			@RequestParam(value="approveId",required=false)String approveId){
		CsmBizMainVo CsmBizMainVo =csmBizInfoVoMapper.getBizMain(approveId);
		return CsmBizMainVo;
			
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getBizApproveBasic")
	public CsmTbBizApprove getBizApproveBasic(
			@RequestParam(value="approveId",required=true)String approveId){
		
		CsmTbBizApprove CsmBizMainVo =csmBizInfoVoMapper.getBizApproveBasic(approveId);
		return CsmBizMainVo;
			
	}
	
	


}
