package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbConLdzj;
/**
 * 01-流动资金贷款批复表：Tb_Con_Ldzj
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbConLdzjMapper {

	//根据合同id查询多条信息
	List<CrtTbConLdzj> selectConLdzjListByContractId(String contractId);

}