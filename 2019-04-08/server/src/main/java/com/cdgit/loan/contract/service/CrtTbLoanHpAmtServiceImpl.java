package com.cdgit.loan.contract.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.CrtTbLoanHpAmt;
import com.cdgit.loan.contract.mapper.CrtTbLoanHpAmtMapper;
import com.cdgit.loan.contract.query.HpxxsQuery;

/**
 * Tb_Loan_Hp_Amt 汇票出账金额表
 * @author Administrator
 *
 */
@Service
@org.springframework.transaction.annotation.Transactional
public class CrtTbLoanHpAmtServiceImpl {

	@Autowired
	CrtTbLoanHpAmtMapper loanHpAmtMapper;
	
	public CrtTbLoanHpAmt getLoanHpAmtInfoByMoneyUseId(String moneyUseId){
		return loanHpAmtMapper.selectCrtTbLoanHpAmtByPrimaryKey(moneyUseId);
	}
	
	
	public void insertCrtTbLoanHpAmtSelective(CrtTbLoanHpAmt record){
		loanHpAmtMapper.insertCrtTbLoanHpAmtSelective(record);
	}
	
	//根据loanId查询多条汇票信息并返回第一条汇票相关信息
	public HpxxsQuery queryHpxxs(String loanId){
		List<HpxxsQuery> queryHpxxsList = loanHpAmtMapper.queryHpxxs(loanId);
		if(queryHpxxsList.size()>0){
			HpxxsQuery hpxxsQuery = queryHpxxsList.get(0);
			return hpxxsQuery;
		}
		return null;
	}
	
}
