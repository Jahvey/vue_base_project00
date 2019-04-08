package com.cdgit.loan.afterloan.afterloancheck.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.afterloan.afterloancheck.bean.ChTbAftFirstCheck;
import com.cdgit.loan.afterloan.afterloancheck.bean.ChTbLoanMoneyUse;
import com.cdgit.loan.afterloan.afterloancheck.mapper.ChTbAftFirstCheckMapper;
import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChTbAftFirstCheckServiceImpl {
	@Autowired
	ChTbAftFirstCheckMapper chTbAftFirstCheckMapper;
	
	//贷后首次检查借据列表查询
	public PageInfo<BorListResult> selectBorList(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		System.err.println(map);
		List<BorListResult> borListResultList = chTbAftFirstCheckMapper.selectBorList(map);
		System.err.println(borListResultList);
		PageInfo pageInfo = new PageInfo<>(borListResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	//授信资金使用用途列表
	public PageInfo<ChTbLoanMoneyUse> queryMoneyUse(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<ChTbLoanMoneyUse> chTbLoanMoneyUseList = chTbAftFirstCheckMapper.queryMoneyUse(map);
		PageInfo pageInfo = new PageInfo<>(chTbLoanMoneyUseList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	//新增授信资金使用用途
	public void insertMoneyUse(ChTbLoanMoneyUse moneyUse){
		chTbAftFirstCheckMapper.insertMoneyUse(moneyUse);
	}
	//通过借据Id查询首次检查信息
	public ChTbAftFirstCheck queryFirstCheckInfoBySummaryId(String summaryId){
		ChTbAftFirstCheck checkInfo = chTbAftFirstCheckMapper.queryFirstCheckInfoBySummaryId(summaryId);
		return checkInfo;
	}
	
	
}
