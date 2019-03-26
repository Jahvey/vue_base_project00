package com.cdgit.loan.afterloan.riskclass.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.afterloan.afterloancheck.mapper.ChAfterLoanCheckRosterMapper;
import com.cdgit.loan.afterloan.afterloancheck.mapper.ChTbAftFirstCheckMapper;
import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
import com.cdgit.loan.afterloan.riskclass.mapper.ChHistoriyAdjustRecordMapper;
import com.cdgit.loan.afterloan.riskclass.mapper.ChQuarterAdjustMapper;
import com.cdgit.loan.afterloan.riskclass.resultbean.HistoriyAdjustRecordResult;
import com.cdgit.loan.afterloan.riskclass.resultbean.QuarSmallNaturalResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChHistoriyAdjustRecordServiceImpl {
	@Autowired
	ChHistoriyAdjustRecordMapper chHistoriyAdjustRecordMapper;
	
	//风险分类-历史调整记录
	public PageInfo<HistoriyAdjustRecordResult> selectHistoriyAdjustRecord(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<HistoriyAdjustRecordResult> historiyAdjustRecordResultList = chHistoriyAdjustRecordMapper.selectHistoriyAdjustRecord(map);
		PageInfo pageInfo = new PageInfo<>(historiyAdjustRecordResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
}
