/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author cwalk
 *
 */
@Mapper
public interface CsmConDetailVoMapper {
	
	
	int insert(HashMap<String, Object> map);
	
	int insertSelective(HashMap<String, Object> map);
	
	
	int updateByPrimaryKeySelective(HashMap<String, Object> map);
	

}
