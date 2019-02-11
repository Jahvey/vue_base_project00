package com.cdgit.afterloan.afterloancheck.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.afterloan.afterloancheck.mapper.ChCheckFrequencyMapper;
import com.cdgit.afterloan.afterloancheck.resultbean.CheckFrequencyResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChCheckFrequencyServiceImpl {
	@Autowired
	ChCheckFrequencyMapper chCheckFrequencyMapper;
	
	//贷后检查频率列表
	public PageInfo<CheckFrequencyResult> selectCheckFrequency(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CheckFrequencyResult> checkFrequencyResultList = chCheckFrequencyMapper.selectCheckFrequency(map);
		PageInfo pageInfo = new PageInfo<>(checkFrequencyResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
}
