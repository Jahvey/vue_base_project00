package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbCsmCorporation;

@Mapper
public interface CrtTbCsmCorporationMapper {

	//根据主键查询一条公司客户信息
    CrtTbCsmCorporation selectCsmCorporationByPrimaryKey(String partyId);

}