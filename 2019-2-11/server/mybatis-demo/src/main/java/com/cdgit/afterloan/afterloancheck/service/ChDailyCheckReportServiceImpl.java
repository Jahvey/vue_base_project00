package com.cdgit.afterloan.afterloancheck.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.afterloan.afterloancheck.mapper.ChDailyCheckReportMapper;
import com.cdgit.afterloan.afterloancheck.resultbean.BorListResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChDailyCheckReportServiceImpl {
	@Autowired
	ChDailyCheckReportMapper chDailyCheckReportMapper;
	
	//日常检查报告列表
	public PageInfo<BorListResult> selectDailyCheckReport(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<BorListResult> borListResultList = chDailyCheckReportMapper.selectDailyCheckReport(map);
		PageInfo pageInfo = new PageInfo<>(borListResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
}
