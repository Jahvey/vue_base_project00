package com.cdgit.loan.workflow.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.mycustomer.message.PageBean;
import com.cdgit.loan.workflow.service.WorkFlowServiceImpl;
import com.github.pagehelper.PageInfo;
import com.netflix.governator.annotations.binding.Request;

@RestController
@RequestMapping("/workFlow")
public class WorkFlowController {

	@Autowired
	private WorkFlowServiceImpl workFlowServiceImpl;
	
	@RequestMapping(value="/queryWorkingList",method=RequestMethod.POST)
	public PageBean queryWorkingList(@RequestBody Map map){
		Map result=workFlowServiceImpl.queryWorkingList(map);
		PageBean pageBean=new PageBean();
//		pageBean.setTotal(pageInfo.getTotal());
		pageBean.setTotal((Integer)result.get("total"));//暂时默认设定20条
		pageBean.setData((List)result.get("traceList"));
		return pageBean;
	}

	@RequestMapping(value="/queryWorkedList",method=RequestMethod.POST)
	public PageBean queryWorkedList(@RequestBody Map map){
		Map result=workFlowServiceImpl.queryWorkedList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal((Integer)result.get("total"));//暂时默认设定20条
		pageBean.setData((List)result.get("traceList"));
		return null;
	}
	
	@RequestMapping(value="/queryRemindInfoGroup",method=RequestMethod.POST)
	public PageBean queryRemindInfoGroup(@RequestBody Map map){
		workFlowServiceImpl.queryRemindInfoGroup(map);
		return null;
	}
	
}
