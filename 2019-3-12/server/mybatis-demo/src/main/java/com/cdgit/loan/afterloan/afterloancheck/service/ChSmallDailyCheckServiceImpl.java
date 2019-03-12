package com.cdgit.loan.afterloan.afterloancheck.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.afterloan.afterloancheck.mapper.ChMicCentreFirstCheckMapper;
import com.cdgit.loan.afterloan.afterloancheck.mapper.ChSmallDailyCheckMapper;
import com.cdgit.loan.afterloan.afterloancheck.mapper.ChTbAftFirstCheckMapper;
import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChSmallDailyCheckServiceImpl {
	@Autowired
	ChSmallDailyCheckMapper chSmallDailyCheckMapper;
	
	//小贷中心日常检查 
	public PageInfo<BorListResult> selectSmallDailyCheck(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<BorListResult> borListResultList = chSmallDailyCheckMapper.selectSmallDailyCheck(map);
		PageInfo pageInfo = new PageInfo<>(borListResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
}
