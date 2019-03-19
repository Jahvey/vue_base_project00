/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author cwalk
 *
 */
@Mapper
public interface ConGrtMapper {
	
	//获取合同下关联的抵押合同信息
	List<HashMap<String, Object>> getConDyList(HashMap<String, Object> map);
}
