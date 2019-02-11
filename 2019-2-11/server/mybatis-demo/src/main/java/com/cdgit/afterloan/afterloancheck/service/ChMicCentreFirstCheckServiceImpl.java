package com.cdgit.afterloan.afterloancheck.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.afterloan.afterloancheck.mapper.ChMicCentreFirstCheckMapper;
import com.cdgit.afterloan.afterloancheck.mapper.ChTbAftFirstCheckMapper;
import com.cdgit.afterloan.afterloancheck.resultbean.BorListResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChMicCentreFirstCheckServiceImpl {
	@Autowired
	ChMicCentreFirstCheckMapper chMicCentreFirstCheckMapper;
	
	//小贷中心首次检查 
	public PageInfo<BorListResult> selectMicCentreFirstCheck(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<BorListResult> borListResultList = chMicCentreFirstCheckMapper.selectMicCentreFirstCheck(map);
		PageInfo pageInfo = new PageInfo<>(borListResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
}
