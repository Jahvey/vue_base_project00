package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmNatrualPersonVo;

/**
 * 
 * @author cwalk
 * @Time   下午5:04:06
 * @filepath com.cdgit.loan.csm.mapper
 * @filename CsmNatrualPersonMapper.java
 */
@Mapper
public interface CsmNatrualPersonMapper {
	
	//我的客户：自然人客户
	List<CsmNatrualPersonVo> queryNaturalForDesk(Map map);
	
	

}
