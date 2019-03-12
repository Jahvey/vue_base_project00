/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbBizAmountLoanrateApprovePo;

/**
 * @author Administrator
 *
 */
@Mapper
public interface CsmTbBizAmountLoanrateApproveMapper {
	
	
	TbBizAmountLoanrateApprovePo queryOneCsmTbBizAmountLoanrateApprove(String amountDetailId);
	
    int deleteOneCsmTbBizAmountLoanrateApprove(String loanrateId);

    int insertCsmTbBizAmountLoanrateApprove(TbBizAmountLoanrateApprovePo record);

    int insertCsmTbBizAmountLoanrateApproveSelective(TbBizAmountLoanrateApprovePo record);

    TbBizAmountLoanrateApprovePo queryCsmTbBizAmountLoanrateApproveByLoanrateId(String loanrateId);

    int updateCsmTbBizAmountLoanrateApproveSelective(TbBizAmountLoanrateApprovePo record);

    int updateCsmTbBizAmountLoanrateApprove(TbBizAmountLoanrateApprovePo record);

}
