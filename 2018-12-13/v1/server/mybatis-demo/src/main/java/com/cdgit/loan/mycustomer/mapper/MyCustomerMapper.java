package com.cdgit.loan.mycustomer.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.user.bean.NaturealCriteria;
import com.cdgit.loan.user.bean.NaturealInfo;
import com.cdgit.loan.user.bean.TbCsmNaturalPerson;
import com.cdgit.loan.user.bean.TbCsmParty;

/**
 * @MapperScan("com.springms.cloud.mapper.**") 或者在每个 Mapper 接口文件上添加 @Mapper 也可以；

* <p>Title: UserMapper</p>  

* <p>Description: </p>  

* @author xujianming  

* @date 2018年10月26日
 */
@Mapper
public interface MyCustomerMapper {
	
	//获取参与人信息
	TbCsmParty getTbCsmParty(NaturealInfo naturalInfo);
	
	//获取自然人客户信息
	TbCsmNaturalPerson getTbCsmNaturalPerson(NaturealInfo naturalInfo);
	
	//获取参与人信息
	TbCsmParty getTbCsmPartyById(String partyId);
		
	//获取自然人客户信息
	TbCsmNaturalPerson getTbCsmNaturalPersonById(String partyId);

//	//我的客户-查询自然人客户列表
//	List<NaturealInfo> queryNaturalForDesk(NaturealCriteria naturealCriteria);
	
	//2018-11-29 新增 我的客户-查询自然人客户列表
	List<NaturealInfo> queryNaturalForDesk1(Map map);
	
	//我的客户-查询自然人客户列表
	List<NaturealInfo> queryNaturalForDesk(Map map);
	
}
