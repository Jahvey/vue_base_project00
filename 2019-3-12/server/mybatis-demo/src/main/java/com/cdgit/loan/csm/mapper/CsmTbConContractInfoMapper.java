package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbConContractInfoPo;

@Mapper
public interface CsmTbConContractInfoMapper {
	
	int insertCsmTbConContractInfo(TbConContractInfoPo contractInfo);
	
	int insertCsmTbConContractInfoSelective(TbConContractInfoPo contractInfo);
	
	TbConContractInfoPo selectByPrimaryKey(String contractId);
	
	int updateByPrimaryKeySelective(String contractId);
	

}