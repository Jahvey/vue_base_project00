package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbConLoanrate;

/**
 * Tb_Con_Loanrate：记录合同的业务利率结构
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbConLoanrateMapper {
	
    int insertSelective(CrtTbConLoanrate record);

    CrtTbConLoanrate selectByPrimaryKey(String loanrateId);

    int updateByPrimaryKeySelective(CrtTbConLoanrate record);

}