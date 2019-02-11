package com.cdgit.afterloan.afterloancheck.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.afterloan.afterloancheck.mapper.ChDailycheckMapper;
import com.cdgit.afterloan.afterloancheck.mapper.ChImportantCheckMapper;
import com.cdgit.afterloan.afterloancheck.resultbean.BorListResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChImportantCheckServiceImpl {
	@Autowired
	ChImportantCheckMapper chImportantCheckMapper;
	
	//重点常检查客户合同列表查询
	public PageInfo<BorListResult> selectImportantCheck(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<BorListResult> borListResultList = chImportantCheckMapper.selectImportantCheck(map);
		PageInfo pageInfo = new PageInfo<>(borListResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
}
