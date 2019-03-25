package com.cdgit.loan.guaranteevaluation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.guaranteevaluation.bean.BizGrtRel;
import com.cdgit.loan.guaranteevaluation.bean.CreditsafeBean;
import com.cdgit.loan.guaranteevaluation.bean.GrtCreditsafe;
import com.cdgit.loan.guaranteevaluation.mapper.BizGrtRelMapper;
import com.cdgit.loan.guaranteevaluation.mapper.GrtCreditsafeMapper;
import com.cdgit.loan.guaranteevaluation.mapper.GrtGuaranteeBasicMapper;
import com.cdgit.loan.securitymanagement.bean.GrtCollateral;
import com.cdgit.loan.securitymanagement.mapper.GrtCollateralMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class CreditInsuranceServiceImpl {
	@Autowired
	private GrtCreditsafeMapper grtCreditsafeMapper;
	@Autowired
	private BizGrtRelMapper bizGrtRelMapper;
	@Autowired
	private GrtCollateralMapper grtCollateralMapper;
	public Map<String, Object> getCashDepositList(Integer pageNum, Integer pageSize, String applyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum,pageSize);
		List<CreditsafeBean> list = grtCreditsafeMapper.getCreditsafeList(applyId);
		PageInfo<CreditsafeBean> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> addGuaranteeApplyTbGrtCreditsafe(GrtCollateral grtCollateral,
			GrtCreditsafe grtCreditsafe, BizGrtRel bizGrtRel) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = grtCollateralMapper.insertSelective(grtCollateral);
		if(i<=0){
			throw new RuntimeException("保存信用保险失败==>grtCollateral");
		}
		i = grtCreditsafeMapper.insertSelective(grtCreditsafe);
		if(i<=0){
			throw new RuntimeException("保存信用保险失败==>grtCreditsafe");
		}
		i = bizGrtRelMapper.insertSelective(bizGrtRel);
		if(i<=0){
			throw new RuntimeException("保存信用保险失败==>bizGrtRel");
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> getTbGrtCreditsafeBySuretyId(String suretyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(suretyId);
		if(grtCollateral==null){
			throw new RuntimeException("查询信用保险失败==>GrtCollateral");
		}
		GrtCreditsafe grtCreditsafe = grtCreditsafeMapper.selectByPrimaryKey(suretyId);
		if(grtCreditsafe==null){
			throw new RuntimeException("查询信用保险失败==>GrtCreditsafe");
		}
		map.put("grtCollateral",grtCollateral);
		map.put("grtCreditsafe", grtCreditsafe);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> updateGuaranteeApplyTbGrtCreditsafe(GrtCollateral grtCollateral,
			GrtCreditsafe grtCreditsafe, BizGrtRel bizGrtRel) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = grtCollateralMapper.updateByPrimaryKey(grtCollateral);
		if(i<=0){
			throw new RuntimeException("更新信用保险失败==>grtCollateral");
		}
		i = grtCreditsafeMapper.updateByPrimaryKeySelective(grtCreditsafe);
		if(i<=0){
			throw new RuntimeException("更新信用保险失败==>grtCreditsafe");
		}
		i = bizGrtRelMapper.updateBySuretyIdSelective(bizGrtRel);
		if(i<=0){
			throw new RuntimeException("更新信用保险失败==>bizGrtRel");
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> delTbGrtCreditsafeBySuretyId(String suretyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = bizGrtRelMapper.deleteBySuretyId(suretyId);
		if(i<=0){
			throw new RuntimeException("删除信用保险失败==>bizGrtRel:"+suretyId);
		}
		i = grtCreditsafeMapper.deleteByPrimaryKey(suretyId);
		if(i<=0){
			throw new RuntimeException("删除信用保险失败==>grtCreditsafe:"+suretyId);
		}
		i = grtCollateralMapper.deleteByPrimaryKey(suretyId);
		if(i<=0){
			throw new RuntimeException("删除信用保险失败==>grtCollateral:"+suretyId);
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}

}
