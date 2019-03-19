package com.cdgit.loan.afterloan.afterloancheck.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.afterloan.afterloancheck.mapper.ChAfterLoanCheckRosterMapper;
import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChAfterLoanCheckRosterServiceImpl {
	@Autowired
	ChAfterLoanCheckRosterMapper chAfterLoanCheckRosterMapper;
	
	//贷后检查名单列表查询
	public PageInfo<BorListResult> selectAfterLoanCheckRoster(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<BorListResult> borListResultList = chAfterLoanCheckRosterMapper.selectAfterLoanCheckRoster(map);
		PageInfo pageInfo = new PageInfo<>(borListResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
}
