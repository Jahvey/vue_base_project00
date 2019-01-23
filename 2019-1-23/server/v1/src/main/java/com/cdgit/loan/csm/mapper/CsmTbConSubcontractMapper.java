package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbConSubcontractPo;


@Mapper
public interface CsmTbConSubcontractMapper {
	
	//担保合同信息
	TbConSubcontractPo queryCsmTbConSubcontractPo(String subcontractId);
	
	

}