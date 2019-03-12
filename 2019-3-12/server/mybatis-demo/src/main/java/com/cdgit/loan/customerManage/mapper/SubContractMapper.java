package com.cdgit.loan.customerManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.bean.SubContract;

@Mapper
public interface SubContractMapper {
    int deleteByPrimaryKey(String subcontractId);

    int insert(SubContract record);

    int insertSelective(SubContract record);

    SubContract selectByPrimaryKey(String subcontractId);

    int updateByPrimaryKeySelective(SubContract record);

    int updateByPrimaryKey(SubContract record);

	List<SubContract> guaranteeListDY(String partyId);

	List<SubContract> guaranteeList(String partyId);
}