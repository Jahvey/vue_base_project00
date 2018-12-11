package com.cdgit.loan.mycustomer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.mycustomer.message.PageBean;
import com.cdgit.loan.mycustomer.message.ResponseMsg;
import com.cdgit.loan.mycustomer.service.MyNaturealServiceImpl;
import com.cdgit.loan.user.bean.NaturalPersonInfo;
import com.cdgit.loan.user.bean.NaturealInfo;
import com.cdgit.loan.user.bean.TbCsmNaturalPerson;
import com.cdgit.loan.user.bean.TbCsmParty;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/mynatureal")
public class MyNaturealController {
	
	@Autowired
	MyNaturealServiceImpl  myNaturealServiceImpl;
	
//	@CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
//			RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
//			RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
//	@GetMapping("/queryNaturalForDesk")
//	public PageInfo<NaturealInfo> queryNaturalForDesk(@RequestBody NaturealCriteria naturealCriteria){
//		return myNaturealServiceImpl.queryNaturalForDesk(naturealCriteria);
//	}
	
	@GetMapping("/queryNaturalForDesk")
	public PageBean queryNaturalForDesk(@RequestParam(value="pageNum",required=true) int pageNum, @RequestParam(value="pageSize",required=true) int pageSize
			,@RequestParam(value="curUserNum",required=true) String curUserNum, @RequestParam(value="orgcode",required=true) String orgcode){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("curUserNum", curUserNum);
		map.put("orgcode", orgcode);
		
		PageInfo<NaturealInfo> pageInfo=myNaturealServiceImpl.queryNaturalForDesk(map);
		
		PageBean pageBean=new PageBean();
		pageBean.setTotal(pageInfo.getTotal());
		pageBean.setData(pageInfo.getList());
		return pageBean;
	}
	
	/**
	 * 2018-11-29 待测试分页查询
	
	 * <p>Title: queryNaturalForDesk1</p>  
	
	 * <p>Description: </p>  
	
	 * @param pageNum
	 * @param pageSize
	 * @param curUserNum
	 * @param orgcode
	 * @return
	 */
	@GetMapping("/queryNaturalForDesk1")
	public ResponseMsg queryNaturalForDesk2(@RequestParam(value="pageNum",required=true) int pageNum, @RequestParam(value="pageSize",required=true) int pageSize
			,@RequestParam(value="curUserNum",required=true) String curUserNum, @RequestParam(value="orgcode",required=true) String orgcode){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("curUserNum", curUserNum);
		map.put("orgcode", orgcode);
		
//		HashMap<String, Object> studentMap = new HashMap<String, Object>();
//		Page<Student> page = iStudentService.getStudents(parameter, pageNum, pageSize);
//		studentMap.put("studentdata", page);
//		studentMap.put("number", page.getTotal());
//		return studentMap;
		
		PageInfo<NaturealInfo> userList=myNaturealServiceImpl.queryNaturalForDesk1(map);
		ResponseMsg res=new ResponseMsg();
        res.setTotalRec(userList.getSize());//赋值分页查询总记录数
        res.setData(userList);
        res.setTotal(userList.getSize());
		return res;
	}
	
	/**
	 * 2018-11-29 待测试分页查询
	
	 * <p>Title: queryNaturalForDesk1</p>  
	
	 * <p>Description: </p>  
	
	 * @param pageNum
	 * @param pageSize
	 * @param curUserNum
	 * @param orgcode
	 * @return
	 */
//	@GetMapping("/queryNaturalForDesk1")
//	public PageInfo<NaturealInfo> queryNaturalForDesk1(@RequestParam(value="pageNum",required=true) int pageNum, @RequestParam(value="pageSize",required=true) int pageSize
//			,@RequestParam(value="curUserNum",required=true) String curUserNum, @RequestParam(value="orgcode",required=true) String orgcode){
//		Map map=new HashMap<String,Object>();
//		map.put("pageNum", pageNum);
//		map.put("pageSize", pageSize);
//		map.put("curUserNum", curUserNum);
//		map.put("orgcode", orgcode);
//		
////		HashMap<String, Object> studentMap = new HashMap<String, Object>();
////		Page<Student> page = iStudentService.getStudents(parameter, pageNum, pageSize);
////		studentMap.put("studentdata", page);
////		studentMap.put("number", page.getTotal());
////		return studentMap;
//		
//		
//		
//        
//		return myNaturealServiceImpl.queryNaturalForDesk1(map);
//	}
	
	@GetMapping("/getNaturalPersonInfo")
	public NaturalPersonInfo getNaturalPersonInfo(@RequestBody NaturealInfo naturealInfo){
		TbCsmParty tbCsmParty=myNaturealServiceImpl.gerTbCsmParty(naturealInfo);
		TbCsmNaturalPerson tbCsmNaturalPerson=myNaturealServiceImpl.getTbCsmNaturalPerson(naturealInfo);
		
		NaturalPersonInfo naturalPersonInfo=new NaturalPersonInfo();
		naturalPersonInfo.setTbCsmParty(tbCsmParty);
		naturalPersonInfo.setTbCsmNaturalPerson(tbCsmNaturalPerson);
		return naturalPersonInfo;
		
	}
	
	@GetMapping("/getTbCsmNaturalPersonInfoById")
	public TbCsmNaturalPerson getTbCsmNaturalPersonInfoById(@RequestParam("partyId") String partyId){
		TbCsmNaturalPerson tbCsmNaturalPerson=myNaturealServiceImpl.getTbCsmNaturalPersonById(partyId);
		return tbCsmNaturalPerson;
	}
	
	@GetMapping("/getTbCsmPartyInfoById")
	public TbCsmParty getTbCsmPartyInfoById(@RequestParam("partyId") String partyId){
		TbCsmParty tbCsmParty=myNaturealServiceImpl.getTbCsmPartyById(partyId);
		return tbCsmParty;
	}
	
	@GetMapping("/getNaturalPersonInfoById")
	public NaturalPersonInfo getNaturalPersonInfoById(@RequestParam("partyId") String partyId){
		TbCsmParty tbCsmParty=myNaturealServiceImpl.getTbCsmPartyById(partyId);
		TbCsmNaturalPerson tbCsmNaturalPerson=myNaturealServiceImpl.getTbCsmNaturalPersonById(partyId);
		
		NaturalPersonInfo naturalPersonInfo=new NaturalPersonInfo();
		naturalPersonInfo.setTbCsmParty(tbCsmParty);
		naturalPersonInfo.setTbCsmNaturalPerson(tbCsmNaturalPerson);
		return naturalPersonInfo;
		
	}
	
}
