package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.ConCreditInfo;

@Mapper
public interface ConCreditInfoMapper {

	/**
	 * 测试：根据ID查询一条完整的信息
	 * @param contractId
	 * @return
	 */
    ConCreditInfo selectByPrimaryKey(String contractId);

}