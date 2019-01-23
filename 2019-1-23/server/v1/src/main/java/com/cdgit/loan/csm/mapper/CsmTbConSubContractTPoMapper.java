/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbConSubContractTPo;

/**
 * @author Administrator
 *
 */
//TODO  待测试........
@Mapper
public interface CsmTbConSubContractTPoMapper {
	
	
	TbConSubContractTPo	queryOneTbConSubContractTPoInfo(String subcontractId);

	
}
