package com.cdgit.loan.csm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.bean.ApproveConsVo;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.queryparams.ApproveConsVoQuery;
import com.cdgit.loan.csm.service.ConApplyServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author cwalk
 * @createTime 2018年12月11日
 * mybatis-demo
 * com.cdgit.loan.csm.controller
 * conApplyController.java
 */
@RestController
@RequestMapping("conApply")
public class ConApplyController {
	
	@Autowired
	ConApplyServiceImpl conApplyServiceImpl;
	
	
	//使用RequestParam自定义分页
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@GetMapping("/getPrintCons")
		public PageBean getPrintCons(
				@RequestParam(value="pageNum",required=true) int pageNum, 
				@RequestParam(value="pageSize",required=true) int pageSize,
				
				@RequestParam(value="partyId",required=false)String partyId,
				@RequestParam(value="conTypeCn",required=false)String conTypeCn,
				@RequestParam(value="contractNum",required=false)String contractNum){
			
			Map map=new HashMap<String,Object>();
			map.put("pageNum", pageNum);
			map.put("pageSize", pageSize);
			map.put("conTypeCn", conTypeCn);
			map.put("partyId", partyId);
			map.put("contractNum", contractNum);
		
			PageInfo<ApproveConsVo> ApproveConsVo = conApplyServiceImpl.getPrintCons(map);
			PageBean pageBean=new PageBean();
			pageBean.setTotal(ApproveConsVo.getTotal());
			pageBean.setData(ApproveConsVo.getList());
			
			return pageBean;

			
		}
	
	
	
	
	
	
	//使用RequestParam自定义分页
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getApproveCons")
	public PageBean getApproveCons(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="userNum",required=false)String userNum,
			@RequestParam(value="partyId",required=false)String partyId,
			@RequestParam(value="contractNum",required=false)String contractNum){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("userNum", userNum);
		map.put("partyId", partyId);
		map.put("contractNum", contractNum);
	
		PageInfo<ApproveConsVo> ApproveConsVo = conApplyServiceImpl.getApproveCons(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(ApproveConsVo.getTotal());
		pageBean.setData(ApproveConsVo.getList());
		
		return pageBean;

		
	}
	
	
	
	
	
	
	
	
	//自定义分页
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getApproveCons1")
	public PageInfo<ApproveConsVo> getApproveCons1(ApproveConsVoQuery approveConsVoQuery){

		return conApplyServiceImpl.getApproveCons1(approveConsVoQuery);
	}
	
	
	
	
	
	

}
