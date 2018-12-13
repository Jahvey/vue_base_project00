/**
 * 
 */
package com.cdgit.loan.csm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdgit.loan.csm.bean.ApproveConsVo;
import com.cdgit.loan.csm.bean.SubContractListVo;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.service.SubContractManageServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 * @createTime 下午3:06:36
 * mybatis-demo
 * com.cdgit.loan.csm.controller
 * SubContractManageController.java
 */
@Controller
@RequestMapping("subContractManage")
public class SubContractManageController {
	
	
	@Autowired
	SubContractManageServiceImpl  subContractManageServiceImpl;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/findSubContractList")
	public PageBean getPrintCons(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="subContractType",required=false)String subContractType,
			@RequestParam(value="subContractNum",required=false)String subContractNum,
			@RequestParam(value="partyId",required=false)String partyId,
			@RequestParam(value="subcontractId",required=false)String subcontractId){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("subContractType", subContractType);
		map.put("subContractNum", subContractNum);
		map.put("partyId", partyId);
		map.put("subcontractId", subcontractId);
	
		PageInfo<SubContractListVo> SubContractListVo = subContractManageServiceImpl.findSubContractList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(SubContractListVo.getTotal());
		pageBean.setData(SubContractListVo.getList());
		
		return pageBean;

		
	}
	
	

}
