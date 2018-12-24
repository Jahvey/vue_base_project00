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

import com.cdgit.loan.csm.bean.OldContractListVo;
import com.cdgit.loan.csm.bean.OldDbListVo;
import com.cdgit.loan.csm.bean.CsmSubContractListVo;
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
@RestController
@RequestMapping("subContractManage")
public class SubContractManageController {
	
	
	@Autowired
	SubContractManageServiceImpl  subContractManageServiceImpl;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/findSubContractList")
	public PageBean findSubContractList(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="subcontractTypeName",required=false)String subcontractTypeName,
			@RequestParam(value="subcontractNum",required=false)String subcontractNum,
			@RequestParam(value="partyId",required=false)String partyId,
			@RequestParam(value="partyName",required=false)String partyName,
			@RequestParam(value="subcontractId",required=false)String subcontractId){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		
		map.put("subcontractTypeName", subcontractTypeName);
		map.put("subcontractNum", subcontractNum);
		map.put("partyId", partyId);
		map.put("partyName", partyName);
		map.put("subcontractId", subcontractId);
	
		PageInfo<CsmSubContractListVo> SubContractListVo = subContractManageServiceImpl.findSubContractList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(SubContractListVo.getTotal());
		pageBean.setData(SubContractListVo.getList());
		
		return pageBean;

		
	}
	
	
	
	
	//获取原担保合同中 对应的押品信息
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/findOldDbList")
	public PageBean findOldDbList(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="subcontractId",required=false)String subcontractId,
			@RequestParam(value="subcontractNum",required=false)String subcontractNum,
			@RequestParam(value="subconractType",required=false)String subconractType){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		
		map.put("subcontractId", subcontractId);
		map.put("subcontractNum", subcontractNum);
		map.put("subconractType", subconractType);

	
		PageInfo<OldDbListVo> OldDbListVo = subContractManageServiceImpl.findOldDbList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(OldDbListVo.getTotal());
		pageBean.setData(OldDbListVo.getList());
		
		return pageBean;

		
	}
	
	
	
	//查找原担保合同对应的主合同信息
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@GetMapping("/findOldContractList")
		public PageBean findOldContractList(
				@RequestParam(value="pageNum",required=true) int pageNum, 
				@RequestParam(value="pageSize",required=true) int pageSize,
				
				@RequestParam(value="subcontractId",required=false)String subcontractId){
			
			Map map=new HashMap<String,Object>();
			map.put("pageNum", pageNum);
			map.put("pageSize", pageSize);
			
			map.put("subcontractId", subcontractId);

			PageInfo<OldContractListVo> OldContractListVo = subContractManageServiceImpl.findOldContractList(map);
			PageBean pageBean=new PageBean();
			pageBean.setTotal(OldContractListVo.getTotal());
			pageBean.setData(OldContractListVo.getList());
			
			return pageBean;

			
		}
	

}
