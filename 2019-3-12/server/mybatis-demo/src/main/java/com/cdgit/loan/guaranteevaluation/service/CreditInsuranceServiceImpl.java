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
import com.cdgit.loan.guaranteevaluation.bean.GrtGuaranteeBasic;
import com.cdgit.loan.guaranteevaluation.mapper.BizGrtRelMapper;
import com.cdgit.loan.guaranteevaluation.mapper.GrtCreditsafeMapper;
import com.cdgit.loan.guaranteevaluation.mapper.GrtGuaranteeBasicMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class CreditInsuranceServiceImpl {
	@Autowired
	private GrtCreditsafeMapper grtCreditsafeMapper;
	@Autowired
	private GrtGuaranteeBasicMapper grtGuaranteeBasicMapper;
	@Autowired
	private BizGrtRelMapper bizGrtRelMapper;
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
	public Map<String, Object> addGuaranteeApplyTbGrtCreditsafe(GrtGuaranteeBasic grtGuaranteeBasic,
			GrtCreditsafe grtCreditsafe, BizGrtRel bizGrtRel) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = grtGuaranteeBasicMapper.insertSelective(grtGuaranteeBasic);
		if(i<=0){
			throw new RuntimeException("保存信用保险失败==>GrtGuaranteeBasic");
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
		GrtGuaranteeBasic grtGuaranteeBasic = grtGuaranteeBasicMapper.selectByPrimaryKey(suretyId);
		if(grtGuaranteeBasic==null){
			throw new RuntimeException("查询信用保险失败==>GrtGuaranteeBasic");
		}
		GrtCreditsafe grtCreditsafe = grtCreditsafeMapper.selectByPrimaryKey(suretyId);
		if(grtCreditsafe==null){
			throw new RuntimeException("查询信用保险失败==>GrtCreditsafe");
		}
		map.put("grtGuaranteeBasic",grtGuaranteeBasic);
		map.put("grtCreditsafe", grtCreditsafe);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> updateGuaranteeApplyTbGrtCreditsafe(GrtGuaranteeBasic grtGuaranteeBasic,
			GrtCreditsafe grtCreditsafe, BizGrtRel bizGrtRel) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = grtGuaranteeBasicMapper.updateByPrimaryKey(grtGuaranteeBasic);
		if(i<=0){
			throw new RuntimeException("更新信用保险失败==>GrtGuaranteeBasic");
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
		i = grtGuaranteeBasicMapper.deleteByPrimaryKey(suretyId);
		if(i<=0){
			throw new RuntimeException("删除信用保险失败==>GrtGuaranteeBasic:"+suretyId);
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}

}
