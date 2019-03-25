/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmHisIrmVo;
import com.cdgit.loan.csm.bean.CsmImpornantEventVo;

/**
 * @author cwalk
 *
 */
@Mapper
public interface CsmIrmApplyMapper {

	//评级历史列表查询生效的评级信息
	List<CsmHisIrmVo> getHisIrmByParty(Map map);
	
	
	List<CsmImpornantEventVo> getCsmImpornantEventInfo(Map map);
	
	
}
