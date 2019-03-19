package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbConZh;

/**
 * 合同账户信息表:Tb_Con_Zh
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbConZhMapper {

	//根据合同id查询多条合同账户信息
	List<CrtTbConZh> selectAllConZhByContractId(String contractId);

}