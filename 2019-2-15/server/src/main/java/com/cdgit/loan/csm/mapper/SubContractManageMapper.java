/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.OldContractListVo;
import com.cdgit.loan.csm.bean.OldDbListVo;
import com.cdgit.loan.csm.bean.CsmSubContractListVo;

/**
 * @author cwalk
 * @createTime 下午3:07:25
 * mybatis-demo
 * com.cdgit.loan.csm.mapper
 * SubContractManageMapper.java
 */
@Mapper
public interface SubContractManageMapper {
	
	
	//查询所有担保合同列表
	List<CsmSubContractListVo> findSubContractList(Map map);
	
	//查找担保合同对应的主合同信息
	
	
	//获取原担保合同中 对应的押品信息
	List<OldDbListVo> findOldDbList(Map map);
	
	
	//查找原担保合同对应的主合同信息
	List<OldContractListVo> findOldContractList(Map map);
	
	
	
	
	
	
	
	
	

}
