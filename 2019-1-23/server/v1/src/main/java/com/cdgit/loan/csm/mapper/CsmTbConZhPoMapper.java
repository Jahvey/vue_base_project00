/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbConZhPo;

/**
 * @author Administrator
 *
 */

@Mapper
public interface CsmTbConZhPoMapper {
	
	//账户信息
	List<TbConZhPo> queryListCsmTbConZhInfo(String contractId);

	
	
}
