package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbLoanHpAmt;

/**
 * Tb_Loan_Hp_Amt 汇票出账金额表
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbLoanHpAmtMapper {

	//插入一条数据
    void insertCrtTbLoanHpAmtSelective(CrtTbLoanHpAmt record);

    //根据主键查询一条汇票出账金额信息
    CrtTbLoanHpAmt selectCrtTbLoanHpAmtByPrimaryKey(String moneyUseId);
    
    //插入多条数据
    int insertManyCrtTbLoanHpAmt(List<CrtTbLoanHpAmt> list);

}