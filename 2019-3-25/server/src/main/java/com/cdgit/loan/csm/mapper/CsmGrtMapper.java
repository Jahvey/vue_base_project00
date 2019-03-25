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
public interface CsmGrtMapper {

	int delTbBizGrtRel(HashMap<String, Object> map);
	
	List<HashMap<String, Object>> selConInfo(String contractId);
	
	List<HashMap<String, Object>> selGuarInfo(String contractId);
	
	List<HashMap<String, Object>> selCollInfo(String contractId);
}
