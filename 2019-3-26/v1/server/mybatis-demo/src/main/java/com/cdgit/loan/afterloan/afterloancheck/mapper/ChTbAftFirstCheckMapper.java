package com.cdgit.loan.afterloan.afterloancheck.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.afterloan.afterloancheck.bean.ChTbAftFirstCheck;
import com.cdgit.loan.afterloan.afterloancheck.bean.ChTbLoanMoneyUse;
import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
@Mapper
public interface ChTbAftFirstCheckMapper {
    //贷后首次检查借据列表查询
	List<BorListResult> selectBorList(Map map);
	//授信资金使用用途列表
	List<ChTbLoanMoneyUse> queryMoneyUse(Map map);
	//新增授信资金用途
	void insertMoneyUse(ChTbLoanMoneyUse moneyUse);
	//查询首次检查信息
	ChTbAftFirstCheck queryFirstCheckInfoBySummaryId(String SummaryId);
   
}