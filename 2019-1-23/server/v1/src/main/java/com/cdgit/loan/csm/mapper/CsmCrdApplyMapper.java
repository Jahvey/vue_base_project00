/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmCrdApplyCorpHisVo;

/**
 * @author cwalk
 *
 */
@Mapper
public interface CsmCrdApplyMapper {

	//查询对公、自然人、同业额度历史列表
	List<CsmCrdApplyCorpHisVo> queryCorpHis(Map map);
	
}
