package com.cdgit.afterloan.afterloancheck.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.afterloan.afterloancheck.mapper.ChFirstCheckReportMapper;
import com.cdgit.afterloan.afterloancheck.mapper.ChTbAftFirstCheckMapper;
import com.cdgit.afterloan.afterloancheck.resultbean.BorListResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChFirstCheckReportServiceImpl {
	@Autowired
	ChFirstCheckReportMapper chFirstCheckReportMapper;
	
	//首次检查报告列表
	public PageInfo<BorListResult> selectFirstCheckReport(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<BorListResult> borListResultList = chFirstCheckReportMapper.selectFirstCheckReport(map);
		PageInfo pageInfo = new PageInfo<>(borListResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
}
