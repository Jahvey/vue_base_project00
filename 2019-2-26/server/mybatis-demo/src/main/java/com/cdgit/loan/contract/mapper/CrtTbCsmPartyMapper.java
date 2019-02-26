package com.cdgit.loan.contract.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbCsmParty;

@Mapper
public interface CrtTbCsmPartyMapper {

	//根据主键查询一条客户信息
    CrtTbCsmParty selectCsmPartyByPrimaryKey(String partyId);
    
    //根据主键查询多条客户信息
    List<HashMap<String,String>> getApplyIdByLoanId(String loanId);
}