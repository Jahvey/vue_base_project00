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
	
	TbBizAmountApprovePo queryByApproveId(String approveId);
	
	TbBizAmountApprovePo queryOneTbBizAmountApproveByAmountId(String amountId);
	
    int deleteOneCsmTbBizAmountApprove(String amountId);

    int insertCsmTbBizAmountApprove(TbBizAmountApprovePo record);

    int insertCsmTbBizAmountApproveSelective(TbBizAmountApprovePo record);

    int updateCsmTbBizAmountApproveSelective(TbBizAmountApprovePo record);

    int updateCsmTbBizAmountApprove(TbBizAmountApprovePo record);
	

}
