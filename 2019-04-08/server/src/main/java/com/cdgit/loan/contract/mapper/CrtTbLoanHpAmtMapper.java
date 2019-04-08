package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbLoanHpAmt;
import com.cdgit.loan.contract.query.HpxxsQuery;

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
    
    //根据loanId查询汇票出账金额总和
    List<java.math.BigDecimal> queryForLoanAmt(String loanId);
    
    //查询汇票信息
    List<HpxxsQuery> queryHpxxs(String loanId);
    
    //银承纸票更新起始日期和到期日期, 电票不更新
    void updateHpEndDate(String loanId);

}