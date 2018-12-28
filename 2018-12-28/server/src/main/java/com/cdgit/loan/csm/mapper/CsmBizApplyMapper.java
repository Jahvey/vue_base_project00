/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.ApplyJxhjBizInfoVo;


/**
 * @author cwalk
 *
 */
@Mapper
public interface CsmBizApplyMapper {
	
	//借新还旧(循环通/续借贷)
	List<ApplyJxhjBizInfoVo> getApplyJxhjBizInfo(Map map);
	
	
}
