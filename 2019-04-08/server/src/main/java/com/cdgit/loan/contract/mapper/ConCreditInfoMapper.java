package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.ConCreditInfo;

@Mapper
public interface ConCreditInfoMapper {

	/**
	 * 根据contractId查询一条完整的信息
	 * @param contractId
	 * @return
	 */
    ConCreditInfo queryConCreditInfoByContractId(String contractId);

}