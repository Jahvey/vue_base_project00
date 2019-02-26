package com.cdgit.loan.business.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.business.bean.BizApplicationVO;
import com.cdgit.loan.business.service.BusinessEntryServiceImpl;
import com.cdgit.loan.common.bean.PageBean;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/businessEntry")
public class BusinessEntryController {
	
	@Autowired
	BusinessEntryServiceImpl  businessEntryServiceImpl;
	
//	@CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
//			RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
//			RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
//	@GetMapping("/queryNaturalForDesk")
//	public PageInfo<NaturealInfo> queryNaturalForDesk(@RequestBody NaturealCriteria naturealCriteria){
//		return myNaturealServiceImpl.queryNaturalForDesk(naturealCriteria);
//	}
	
	/**
	 * 创建流程申请demo
		参考原绵阳信贷业务逻辑实现
	 * <p>Title: createBizApply</p>  
	
	 * <p>Description: </p>
	 */
	@GetMapping("/checkBizApply")
	public void checkBizApply(@RequestBody BizApplicationVO bizApplicationVO){
		
		businessEntryServiceImpl.createBizApply(bizApplicationVO);
	}
	
	/**
	 * 创建流程申请demo
		参考原绵阳信贷业务逻辑实现
	 * <p>Title: createBizApply</p>  
	
	 * <p>Description: </p>
	 */
	@PostMapping("/createBizApply")
	public void createBizApply(@RequestBody BizApplicationVO bizApplicationVO){
		
		businessEntryServiceImpl.createBizApply(bizApplicationVO);
	}
	
	/**
	 * 根据客户partyId查询业务批复列表
	
	 * <p>Title: getBizList</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	@GetMapping("/getBizList")
	public PageBean getBizList(@RequestParam(value="pageNum",required=true) int pageNum, @RequestParam(value="pageSize",required=true) int pageSize
			,@RequestParam(value="partyId",required=true) String partyId){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyId", partyId);
		PageInfo pageInfo=businessEntryServiceImpl.getBizList(map);
		PageBean pageBean=new PageBean();
		if(null!=pageInfo.getList() && pageInfo.getList().size()>0){
			pageBean.setData(pageInfo.getList());
		}else{
			pageBean.setData(new ArrayList());
		}
		return pageBean;
		
	}
	
	/**
	 * 根据客户partyId查询业务批复列表
	
	 * <p>Title: getBizList</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	@GetMapping("/getBizList1")
	public PageBean getBizList1(@RequestParam(value="pageNum",required=true) int pageNum, @RequestParam(value="pageSize",required=true) int pageSize
			,@RequestParam(value="partyId",required=true) String partyId){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyId", partyId);
		PageInfo pageInfo=businessEntryServiceImpl.getBizList1(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(pageInfo.getTotal());
		if(null!=pageInfo.getList() && pageInfo.getList().size()>0){
			pageBean.setData(pageInfo.getList());
		}else{
			pageBean.setData(new ArrayList());
		}
		
		return pageBean;
		
	}
	
	/**
	 * 根据客户partyId查询业务批复列表
	
	 * <p>Title: getBizList</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	@GetMapping("/getEnumsValue")
	public List getEnumsValue(@RequestParam(value="dicttypeid",required=true) String dicttypeid){
		
		return businessEntryServiceImpl.getEnumsValue(dicttypeid);
	}
	
	/**
	 * 根据客户partyId查询业务批复列表
	
	 * <p>Title: getBizList</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	@GetMapping("/queryOmPosition")
	public List queryOmPosition(@RequestParam(value="legorg",required=true) String legorg){
		
		return businessEntryServiceImpl.queryOmPosition(legorg);
	}
	
	/**
	 * 根据客户partyId查询业务批复列表
	
	 * <p>Title: getBizList</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	@GetMapping("/getBizList2")
	public PageBean getBizList2(@RequestParam Map<String,Object> map){
		PageInfo pageInfo=businessEntryServiceImpl.getBizList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(pageInfo.getTotal());
		pageBean.setData(pageInfo.getList());
		return pageBean;
		
	}
	
	@GetMapping("/submitBusiness")
	public String submitBusiness(){
		return "";
	}
	
	/**
	 * 获取下一审批人岗位
	
	 * <p>Title: getNextUser</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	@GetMapping("/getNextPosition")
	public String getNextPosition(@RequestParam("procDefId") String procDefId,@RequestParam("procDefNodeId") String procDefNodeId){
		Map processMap=new HashMap<>();
		processMap.put("procDefId", procDefId);
		processMap.put("procDefNodeId", procDefNodeId);
		return businessEntryServiceImpl.getNextPosition(processMap);
	}
	
	/**
	 * 获取下一审批人是否有代办
	
	 * <p>Title: getNextUser</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	@GetMapping("/getTaskagencyConfig")
	public String getTaskagencyConfig(@RequestParam("beAgentPersonNo") String beAgentPersonNo){
		Map map=new HashMap<>();
		map.put("beAgentPersonNo", beAgentPersonNo);
		return businessEntryServiceImpl.getTaskagencyConfig(map);
	}
	
	/**
	 * 获取下一审批人是否有代办
	
	 * <p>Title: getNextUser</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	@GetMapping("/getTaskagencyConfig1")
	public String getTaskagencyConfig1(@RequestParam Map map){
		return businessEntryServiceImpl.getTaskagencyConfig(map);
	}
	
	/**
	 * 获取下一审批人岗位
	
	 * <p>Title: getNextUser</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	@GetMapping("/getNextPosition1")
	public String getNextPosition1(@RequestParam Map map){
		return businessEntryServiceImpl.getNextPosition(map);
	}
	
	@GetMapping("/taskCommit")
	public String taskCommit(@RequestParam Map map){
		return businessEntryServiceImpl.taskCommit(map);
	}
	
	@GetMapping("/taskEnd")
	public String taskEnd(@RequestParam Map map){
		return businessEntryServiceImpl.taskEnd(map);
	}
	
	/**
	 * 获取下一审批人
	          根据调用流程中心的结果，根据岗位查询下一审批人
	 * <p>Title: getNextUser</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
//	@GetMapping("/getNextUser")
//	public List<Users> getNextUser(@RequestParam("procDefId") String procDefId,@RequestParam("procDefNodeId") String procDefNodeId){
//		
//	}
	
}
