/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbConAttachedInfoPo;

/**
 * @author Administrator
 *
 */
@Mapper
public interface CsmTbConAttachedInfoPoMapper {
	
	
	// 附属信息
	TbConAttachedInfoPo queryCsmTbConAttachedInfoPo(String contractId);

	
	
}
