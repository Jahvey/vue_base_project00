/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbBizSummaryPo;

/**
 * @author Administrator
 *
 */
@Mapper
public interface CsmTbBizSummaryMapper {
	
	TbBizSummaryPo queryOneTbBizSummaryByApplyId(String applyId);
	
    int deleteCsmTbBizSummaryById(String id);

    int insertCsmTbBizSummary(TbBizSummaryPo record);

    int insertCsmTbBizSummarySelective(TbBizSummaryPo record);

    TbBizSummaryPo queryCsmTbBizSummaryById(String id);

    int updateCsmTbBizSummarySelective(TbBizSummaryPo record);

    int updateCsmTbBizSummary(TbBizSummaryPo record);
	
	
	

	
}
