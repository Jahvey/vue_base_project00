package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbConSubcontractPo;


@Mapper
public interface CsmTbConSubcontractMapper {
	
	//担保合同信息
	TbConSubcontractPo queryCsmTbConSubcontractPo(String subcontractId);
	
	//更新相关信息
	int updateCsmTbConSubcontract(TbConSubcontractPo subCon);
	
	
    int deleteCsmTbConSubcontractBySubcontractId(String subcontractId);

    int insertOneCsmTbConSubcontract(TbConSubcontractPo record);

    int insertOneCsmTbConSubcontractSelective(TbConSubcontractPo record);


    int updateCsmTbConSubcontractByPrimaryKeySelective(TbConSubcontractPo subCon);

	
	

}