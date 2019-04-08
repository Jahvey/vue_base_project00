package com.cdgit.loan.creditLimit.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.creditLimit.bean.TbCrdApply;
import com.cdgit.loan.creditLimit.bean.TbCrdDetailApply;



/**
 * 

* <p>Title: CrdDaoUtilMapper</p>  

* <p>Description: </p>  

* @author xujianming  

* @date 2019年2月20日
 */
@Mapper
public interface CrdDaoUtilMapper {
	
	List getAvailConToCrdDtl(Map map);
	
	int insertCrd(TbCrdApply record);
	
	int insertCrdDtl(TbCrdDetailApply record);
	
	void updateCrdAppCredit(String crdId);
	
	void updateCrdApp(TbCrdApply record);
	
	TbCrdApply selectCrdAppByPrimaryKey(String crdId);
	
	TbCrdDetailApply selectCrdDtlApp(String crdDtlId);
}
