package com.cdgit.loan.mycustomer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.mycustomer.mapper.MyCustomerMapper;
import com.cdgit.loan.user.bean.NaturealInfo;
import com.cdgit.loan.user.bean.TbCsmNaturalPerson;
import com.cdgit.loan.user.bean.TbCsmParty;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class MyNaturealServiceImpl {

	@Autowired
	MyCustomerMapper myCustomerMapper;
	
	/**
	 * 第一个参数从第几页开始  第二个参数每页显示数量
	
	 * <p>Title: queryNaturalForDesk</p>  
	
	 * <p>Description: </p>  
	
	 * @param naturealCriteria
	 * @return
	 */
//	public PageInfo<NaturealInfo> queryNaturalForDesk(NaturealCriteria naturealCriteria){
//		PageHelper.startPage(naturealCriteria.getPageNum(),naturealCriteria.getPageSize());
////		Map queryMap=new HashMap<String,Object>();
////		queryMap.put("curUserNum", naturealCriteria.getCurUserNum());
////		queryMap.put("orgcode", naturealCriteria.getOrgcode());
////    	List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk(queryMap);
//		List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk(naturealCriteria);
//        PageInfo pageInfo=new PageInfo(userList,naturealCriteria.getPageSize());
//    	return pageInfo;
//	}
	
	public PageInfo<NaturealInfo> queryNaturalForDesk(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
//		Map queryMap=new HashMap<String,Object>();
//		queryMap.put("curUserNum", naturealCriteria.getCurUserNum());
//		queryMap.put("orgcode", naturealCriteria.getOrgcode());
//    	List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk(queryMap);
		List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk(map);
        PageInfo pageInfo=new PageInfo(userList,(Integer)map.get("pageSize"));
    	return pageInfo;
	}
	/**
	 * 传递map参数用requestParam
	  为什么feign调用时失败
	 * <p>Title: queryNaturalForDesk3</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	public PageInfo<NaturealInfo> queryNaturalForDesk3(Map map){
		PageHelper.startPage(Integer.valueOf((String)map.get("pageNum")),Integer.valueOf((String)map.get("pageSize")));
//		Map queryMap=new HashMap<String,Object>();
//		queryMap.put("curUserNum", naturealCriteria.getCurUserNum());
//		queryMap.put("orgcode", naturealCriteria.getOrgcode());
//    	List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk(queryMap);
		List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk(map);
        PageInfo pageInfo=new PageInfo(userList,Integer.valueOf((String)map.get("pageSize")));
    	return pageInfo;
	}
	
	/**
	 * 传递map参数用requestBody
	
	 * <p>Title: queryNaturalForDesk5</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	public PageInfo<NaturealInfo> queryNaturalForDesk5(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
//		Map queryMap=new HashMap<String,Object>();
//		queryMap.put("curUserNum", naturealCriteria.getCurUserNum());
//		queryMap.put("orgcode", naturealCriteria.getOrgcode());
//    	List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk(queryMap);
		List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk(map);
        PageInfo pageInfo=new PageInfo(userList,(Integer)map.get("pageSize"));
    	return pageInfo;
	}
	
	public PageInfo<NaturealInfo> queryNaturalForDesk4(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
//		Map queryMap=new HashMap<String,Object>();
//		queryMap.put("curUserNum", naturealCriteria.getCurUserNum());
//		queryMap.put("orgcode", naturealCriteria.getOrgcode());
//    	List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk(queryMap);
		List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk(map);
        PageInfo pageInfo=new PageInfo(userList,(Integer)map.get("pageSize"));
    	return pageInfo;
	}
	
	/**
	 * 2018-11-19 修改
	
	 * <p>Title: queryNaturalForDesk1</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	public PageInfo<NaturealInfo> queryNaturalForDesk1(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
//		Map queryMap=new HashMap<String,Object>();
//		queryMap.put("curUserNum", naturealCriteria.getCurUserNum());
//		queryMap.put("orgcode", naturealCriteria.getOrgcode());
//    	List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk(queryMap);
		List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk1(map);
        PageInfo pageInfo=new PageInfo(userList,(Integer)map.get("pageSize"));
    	return pageInfo;
	}
	
	/**
	 * 2018-11-19 修改
	
	 * <p>Title: queryNaturalForDesk1</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	public Page<NaturealInfo> queryNaturalForDesk2(Map map){
		Page<NaturealInfo> page=PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
//		Map queryMap=new HashMap<String,Object>();
//		queryMap.put("curUserNum", naturealCriteria.getCurUserNum());
//		queryMap.put("orgcode", naturealCriteria.getOrgcode());
//    	List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk(queryMap);
		List<NaturealInfo> userList=myCustomerMapper.queryNaturalForDesk1(map);
    	return page;
	}
	
	public TbCsmParty gerTbCsmParty(NaturealInfo naturalInfo){
		return myCustomerMapper.getTbCsmParty(naturalInfo);
	}
	
	public TbCsmNaturalPerson getTbCsmNaturalPerson(NaturealInfo naturalInfo){
		return myCustomerMapper.getTbCsmNaturalPerson(naturalInfo);
	}
	
	public TbCsmParty getTbCsmPartyById(String partyId){
		return myCustomerMapper.getTbCsmPartyById(partyId);
	}
	
	public TbCsmNaturalPerson getTbCsmNaturalPersonById(String partyId){
		return myCustomerMapper.getTbCsmNaturalPersonById(partyId);
	}
//	public PageInfo<GradeInfo> queryGradeinfo(Map map){
//		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
//		List<GradeInfo> userList=myCustomerMapper.queryGradeinfo(map);
//        PageInfo pageInfo=new PageInfo(userList,(Integer)map.get("pageSize"));
//    	return pageInfo;
//	}
}
