package com.cdgit.loan.securitymanagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.securitymanagement.bean.GrtCollateralAccident;
import com.cdgit.loan.securitymanagement.mapper.GrtCollateralAccidentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 意外service
 * @author wuyong
 * @date 2018.12.29
 *
 */
@Service
@Transactional
public class GrtCollateralAccidentServiceImpl {
	@Autowired
	private GrtCollateralAccidentMapper grtCollateralAccidentMapper;
	public Map<String, Object> getAllCollateralAccident(Integer pageNum, Integer pageSize, String guarantyId,
			String accidentTypeCd, String currencyCd) {
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(pageNum,pageSize);
		List<GrtCollateralAccident> list = grtCollateralAccidentMapper.selectAll(guarantyId,
				accidentTypeCd,currencyCd);
		PageInfo<GrtCollateralAccident> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> deleteCollateralAccidentById(String accidentId) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralAccidentMapper.deleteByPrimaryKey(accidentId);
		if(i>0){
			map.put("flag", "true");
			map.put("message", "操作成功!");
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException();
		}
		return map;
	}
	public Map<String, Object> deleteCollateralAccidentBatch(String[] ids) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralAccidentMapper.deleteBatch(ids);
		if(i>0){
			map.put("flag", "true");
			map.put("message", "操作成功!");
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException();
		}
		return map;
	}
	public Map<String, Object> saveCollateralAccident(GrtCollateralAccident grtCollateralAccident) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralAccidentMapper.insertSelective(grtCollateralAccident);
		if(i>0){
			map.put("flag", "true");
			map.put("message", "操作成功!");
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException();
		}
		return map;
	}
	public Map<String, Object> updateCollateralAccident(GrtCollateralAccident grtCollateralAccident) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralAccidentMapper.updateByPrimaryKeySelective(grtCollateralAccident);
		if(i>0){
			map.put("flag", "true");
			map.put("message", "操作成功!");
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException();
		}
		return map;
	}
	
}
