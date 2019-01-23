package com.cdgit.loan.contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.CrtTbLoanHpAmt;
import com.cdgit.loan.contract.mapper.CrtTbLoanHpAmtMapper;

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
	
}
