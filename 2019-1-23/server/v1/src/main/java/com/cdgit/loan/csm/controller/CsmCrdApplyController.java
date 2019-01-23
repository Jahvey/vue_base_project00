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

import com.cdgit.loan.csm.bean.CsmCrdApplyCorpHisVo;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.service.CsmCrdApplyServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@RestController
@RequestMapping("CrdApply")
public class CsmCrdApplyController {
	
	@Autowired
	CsmCrdApplyServiceImpl crdApplyServiceImpl;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/queryCorpHis")
	public PageBean queryCorpHis(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		
		map.put("partyId", partyId);
		PageInfo<CsmCrdApplyCorpHisVo> CsmCrdApplyCorpHisVo =crdApplyServiceImpl.queryCorpHis(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmCrdApplyCorpHisVo.getTotal());
		pageBean.setData(CsmCrdApplyCorpHisVo.getList());
		
		return pageBean;
	
		
	}
	

}
