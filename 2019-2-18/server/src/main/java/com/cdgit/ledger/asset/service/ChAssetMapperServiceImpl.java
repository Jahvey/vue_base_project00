package com.cdgit.ledger.asset.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.ledger.asset.bean.ChSelectWriteOffResult;
import com.cdgit.ledger.asset.mapper.ChTbAssetVerifyOffMapper;
import com.cdgit.ledger.naturalperson.bean.NaturealCust;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChAssetMapperServiceImpl {
	
	@Autowired
	ChTbAssetVerifyOffMapper tbAssetVerifyOffMapper;
	//1.核销查询 2.不良资产处置
	public PageInfo<ChSelectWriteOffResult> selectWriteOff(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<ChSelectWriteOffResult> selectWriteOffResultList = tbAssetVerifyOffMapper.selectWriteOff(map);
		PageInfo pageInfo = new PageInfo<>(selectWriteOffResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}

}
