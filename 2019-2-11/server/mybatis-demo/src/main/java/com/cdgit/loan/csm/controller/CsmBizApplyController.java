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

import com.cdgit.loan.csm.bean.ApplyJxhjBizInfoVo;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.service.CsmBizApplyServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@RestController
@RequestMapping("bizApply")
public class CsmBizApplyController {
	
	@Autowired
	CsmBizApplyServiceImpl csmBizApplyServiceImpl;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getApplyJxhjBizInfo")
	public PageBean getApplyJxhjBizInfo(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId,
			@RequestParam(value="bizNum",required=false)String bizNum,
			@RequestParam(value="summaryNum",required=false)String summaryNum){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		
		map.put("bizNum", bizNum);
		map.put("partyId", partyId);
		map.put("summaryNum", summaryNum);
	
		PageInfo<ApplyJxhjBizInfoVo> ApplyJxhjBizInfoVo = csmBizApplyServiceImpl.getApplyJxhjBizInfo(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(ApplyJxhjBizInfoVo.getTotal());
		pageBean.setData(ApplyJxhjBizInfoVo.getList());
		
		return pageBean;
	
		
	}
	

}
