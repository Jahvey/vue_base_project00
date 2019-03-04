package com.cdgit.loan.afterloan.afterloancheck.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.afterloan.afterloancheck.mapper.ChDailycheckMapper;
import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChDailycheckServiceImpl {
	@Autowired
	ChDailycheckMapper chDailycheckMapper;
	
	//可日常检查客户列表查询
	public PageInfo<BorListResult> selectDailycheckCust(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<BorListResult> borListResultList = chDailycheckMapper.selectDailycheckCust(map);
		PageInfo pageInfo = new PageInfo<>(borListResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
}
