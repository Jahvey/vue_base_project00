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
	
	
    int deleteCsmTbConAttachedInfoByAttached(String attached);

    int insertCsmTbConAttachedInfo(TbConAttachedInfoPo record);

    int insertCsmTbConAttachedInfoSelective(TbConAttachedInfoPo record);

    TbConAttachedInfoPo queryCsmTbConAttachedInfoByAttached(String attached);

    int updateCsmTbConAttachedInfoSelective(TbConAttachedInfoPo record);

    int updateCsmTbConAttachedInfo(TbConAttachedInfoPo record);
	
	
	

	
	
}
