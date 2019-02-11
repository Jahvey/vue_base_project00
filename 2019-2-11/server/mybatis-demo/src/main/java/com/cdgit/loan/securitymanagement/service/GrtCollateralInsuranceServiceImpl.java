package com.cdgit.loan.securitymanagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.securitymanagement.bean.GrtCollateralInsurance;
import com.cdgit.loan.securitymanagement.mapper.GrtCollateralInsuranceMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 保险service
 * @author wuyong
 * @date 2018.12.29
 *
 */
@Service
@Transactional
public class GrtCollateralInsuranceServiceImpl {
	@Autowired
	private GrtCollateralInsuranceMapper grtCollateralInsuranceMapper;
	public Map<String, Object> getAllCollateralInsurance(Integer pageNum, Integer pageSize, String guarantyId,
			String insuranceCompanyName, String insurancePolicyNum, String policyHolder) {
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(pageNum,pageSize);
		List<GrtCollateralInsurance> list = grtCollateralInsuranceMapper.selectAll(guarantyId,
				insuranceCompanyName,insurancePolicyNum,policyHolder);
		PageInfo<GrtCollateralInsurance> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> deleteCollateralInsuranceById(String insuranceId) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralInsuranceMapper.deleteByPrimaryKey(insuranceId);
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
	public Map<String, Object> deleteCollateralInsuranceBatch(String[] ids) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralInsuranceMapper.deleteBatch(ids);
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
	public Map<String, Object> saveCollateralInsurance(GrtCollateralInsurance grtCollateralInsurance) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralInsuranceMapper.insertSelective(grtCollateralInsurance);
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
	public Map<String, Object> updateCollateralInsurance(GrtCollateralInsurance grtCollateralInsurance) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralInsuranceMapper.updateByPrimaryKeySelective(grtCollateralInsurance);
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
