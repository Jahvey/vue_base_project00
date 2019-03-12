/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.csm.bean.CsmBizListVo;

/**
 * @author cwalk
 *
 */
@Mapper
public interface CsmBizListMapper {

	List<CsmBizListVo> getBizList(@Param(value = "partyId") String partyId);
		
}
