package com.cdgit.loan.securitymanagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.securitymanagement.bean.GrtCollateralRegistration;
import com.cdgit.loan.securitymanagerment.mapper.GrtCollateralRegistrationMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 登记信息service
 * @author wuyong
 * @date 2018.12.29
 *
 */
@Service
@Transactional
public class GrtCollateralRegistrationServiceImpl {
	@Autowired
	private GrtCollateralRegistrationMapper grtCollateralRegistrationMapper;
	public Map<String, Object> getAllCollateralRegistration(Integer pageNum, Integer pageSize, String guarantyId,
			String registerNum, String registerOrgTypeCd, String registerOrgName,String contractNum) {
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(pageNum,pageSize);
		List<GrtCollateralRegistration> list = grtCollateralRegistrationMapper.selectAll(guarantyId,
				registerNum,registerOrgTypeCd,registerOrgName,contractNum);
		PageInfo<GrtCollateralRegistration> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> deleteCollateralRegistrationById(String collateralRegistrationId) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralRegistrationMapper.deleteByPrimaryKey(collateralRegistrationId);
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
	public Map<String, Object> deleteCollateralRegistrationBatch(String[] ids) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralRegistrationMapper.deleteBatch(ids);
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
	public Map<String, Object> saveCollateralRegistration(GrtCollateralRegistration grtCollateralRegistration) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralRegistrationMapper.insertSelective(grtCollateralRegistration);
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
	public Map<String, Object> updateCollateralRegistration(GrtCollateralRegistration grtCollateralRegistration) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralRegistrationMapper.updateByPrimaryKeySelective(grtCollateralRegistration);
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
