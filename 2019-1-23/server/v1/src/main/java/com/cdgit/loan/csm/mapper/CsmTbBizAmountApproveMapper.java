/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbBizAmountApprovePo;

/**
 * @author Administrator
 *
 */
@Mapper
public interface CsmTbBizAmountApproveMapper {
	
	
	TbBizAmountApprovePo queryOneTbBizAmountApproveByAmountId(String amountId);
	
	

}
