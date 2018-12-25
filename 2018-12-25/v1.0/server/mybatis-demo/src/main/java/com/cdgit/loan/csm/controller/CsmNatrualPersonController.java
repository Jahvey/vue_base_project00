package com.cdgit.loan.csm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.bean.CsmNatrualPersonVo;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.service.CsmNatrualPersonServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author cwalk
 * @Time   下午5:33:21
 * @filepath com.cdgit.loan.csm.controller
 * @filename CsmNatrualPersonController.java
 */
@RestController
@RequestMapping("natural")
public class CsmNatrualPersonController {
	
	
	@Autowired
	CsmNatrualPersonServiceImpl csmNatrualPersonServiceImpl;
	
	
	//使用RequestParam自定义分页
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/queryNaturalForDesk")
	public PageBean queryNaturalForDesk(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="certType",required=false)String certType,
			@RequestParam(value="certNum",required=false)String certNum,
			@RequestParam(value="middelCode",required=false)String middelCode,
			@RequestParam(value="partyName",required=false)String partyName){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		
		map.put("certType", certType);
		map.put("certNum", certNum);
		map.put("middelCode", middelCode);
		map.put("partyName", partyName);
	
		PageInfo<CsmNatrualPersonVo> CsmNatrualPersonVo = csmNatrualPersonServiceImpl.queryNaturalForDesk(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(CsmNatrualPersonVo.getTotal());
		pageBean.setData(CsmNatrualPersonVo.getList());
		
		return pageBean;

		
	}
	
	
	
	
	
	

}
