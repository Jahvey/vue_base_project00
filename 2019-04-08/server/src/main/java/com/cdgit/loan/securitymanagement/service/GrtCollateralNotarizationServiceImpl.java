package com.cdgit.loan.securitymanagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.securitymanagement.bean.GrtCollateralNotarization;
import com.cdgit.loan.securitymanagement.mapper.GrtCollateralNotarizationMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 公证service
 * @author wuyong
 * @date 2018.12.29
 *
 */
@Service
@Transactional
public class GrtCollateralNotarizationServiceImpl {
	@Autowired
	private GrtCollateralNotarizationMapper grtCollateralNotarizationMapper;
	public Map<String, Object> getAllCollateralNotarization(Integer pageNum, Integer pageSize, String guarantyId,
			String loanContractNum, String loanManName, String loanCertificateType,String certificateCode,String notarialDeedNo,String notarialOrg) {
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(pageNum,pageSize);
		List<GrtCollateralNotarization> list = grtCollateralNotarizationMapper.selectAll(guarantyId,
				loanContractNum,loanManName,loanCertificateType,certificateCode,notarialDeedNo,notarialOrg);
		PageInfo<GrtCollateralNotarization> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> deleteCollateralNotarizationById(String notarizationId) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralNotarizationMapper.deleteByPrimaryKey(notarizationId);
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
	public Map<String, Object> deleteCollateralNotarizationBatch(String[] ids) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralNotarizationMapper.deleteBatch(ids);
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
	public Map<String, Object> saveCollateralNotarization(GrtCollateralNotarization grtCollateralNotarization) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralNotarizationMapper.insertSelective(grtCollateralNotarization);
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
	public Map<String, Object> updateCollateralNotarization(GrtCollateralNotarization grtCollateralNotarization) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralNotarizationMapper.updateByPrimaryKeySelective(grtCollateralNotarization);
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
