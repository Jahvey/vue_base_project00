package com.cdgit.loan.business.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.business.bean.TbBizApprove;
import com.cdgit.loan.user.bean.NaturealInfo;

/**
 * @MapperScan("com.springms.cloud.mapper.**") 或者在每个 Mapper 接口文件上添加 @Mapper 也可以；

* <p>Title: UserMapper</p>  

* <p>Description: </p>  

* @author xujianming  

* @date 2018年10月26日
 */
@Mapper
public interface QueryMapper {

	 
	List<TbBizApprove> queryTbBizApproveList(String partyId);
	 
	List<Map<String,Object>> getBizList1(Map map);
	
	List<TbBizApprove> getBizList(Map map);
	
//	List<TbBizApprove> queryTbBizApproveList(Map map);
	
	
}
