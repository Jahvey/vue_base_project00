package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbConLoanrate;

/**
 * Tb_Con_Loanrate：记录合同的业务利率结构
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbConLoanrateMapper {
	
    //根据合同id查询多条合同利率信息
	List<CrtTbConLoanrate> selectAllConLoanrateByContractId(String contractId);

}