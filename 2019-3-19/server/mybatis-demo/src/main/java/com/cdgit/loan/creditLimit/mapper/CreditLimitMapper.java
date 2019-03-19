package com.cdgit.loan.creditLimit.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.creditLimit.bean.TbConGuarantOrgInfo;
import com.cdgit.loan.creditLimit.bean.TbCrdThirdPartyLimit;

/**
 * 

* <p>Title: CreditLimitMapper</p>  

* <p>Description: </p>  

* @author xujianming  

* @date 2019年2月20日
 */
@Mapper
public interface CreditLimitMapper {

	List queryThirdHis_protocol(Map map);
	List queryThirdHis_corp(Map map);
	
	int RCRD_0013(Map map);
	
	int RCONDB_0003(Map map);
	
//	int insert(TbCrdThirdPartyLimit record);
	
	int insertSelective(TbCrdThirdPartyLimit record);
	
	TbCrdThirdPartyLimit selectByPrimaryKey(String limitId);
	
	int insertAdjustThirdLimit(Map map);//测试直接查询插入
	
	void insertNewZh(Map map);//原来的limit_id 新 limit_id
	
	void insertCrdProRel(Map map);//
	
	TbCrdThirdPartyLimit getThirdPartyCrdByLimitId(Map map);
	
	int insertGuarant(TbConGuarantOrgInfo record);

	void insertconZh(TbConGuarantOrgInfo record);
	
//    int insertSelective(TbConGuarantOrgInfo record);
	
}
