package com.cdgit.loan.customerManage.contractInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.contractInfo.bean.ContractInfo;

@Mapper
public interface ContractInfoMapper {
    int insert(ContractInfo record);

    int insertSelective(ContractInfo record);

	List<ContractInfo> financingListYW(String partyId);
}