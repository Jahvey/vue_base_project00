/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmNaturalInfoVo;



/**
 * @author cwalk
 *
 */
@Mapper
public interface CsmNatrualMapper {
	
	//
	List<CsmNaturalInfoVo> getNaturalInfo(Map map);
	

}
