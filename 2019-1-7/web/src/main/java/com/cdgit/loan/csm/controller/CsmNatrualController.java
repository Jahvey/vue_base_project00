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

import com.cdgit.loan.csm.bean.CsmNaturalInfoVo;
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
}
