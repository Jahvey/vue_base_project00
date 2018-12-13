/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import com.cdgit.loan.csm.bean.SubContractListVo;

/**
 * @author cwalk
 * @createTime 下午3:07:25
 * mybatis-demo
 * com.cdgit.loan.csm.mapper
 * SubContractManageMapper.java
 */
public interface SubContractManageMapper {
	
	
	//查询所有担保合同列表
	List<SubContractListVo> findSubContractList(Map map);
	
	
	
	

}
