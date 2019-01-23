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

import com.cdgit.loan.csm.bean.CsmBizListVo;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.service.CsmBizListServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@RestController
@RequestMapping("BizSql")
public class CsmBizListController {
	
	@Autowired
	CsmBizListServiceImpl csmBizListServiceImpl;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getBizList")
	public PageBean getBizList(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		
		map.put("partyId", partyId);
		PageInfo<CsmBizListVo> CsmBizListVo =csmBizListServiceImpl.getBizList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmBizListVo.getTotal());
		pageBean.setData(CsmBizListVo.getList());
		
		return pageBean;
	
		
	}

}
