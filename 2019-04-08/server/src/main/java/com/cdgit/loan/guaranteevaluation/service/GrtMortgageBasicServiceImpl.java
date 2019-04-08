package com.cdgit.loan.guaranteevaluation.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.constants.Constant;
import com.cdgit.loan.guaranteevaluation.bean.BizGrtRel;
import com.cdgit.loan.guaranteevaluation.bean.MortgageBasicBean;
import com.cdgit.loan.guaranteevaluation.mapper.BizGrtRelMapper;
import com.cdgit.loan.guaranteevaluation.mapper.GrtMortgageBasicMapper;
import com.cdgit.loan.securitymanagement.bean.GrtCollateral;
import com.cdgit.loan.securitymanagement.mapper.GrtCollateralMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class GrtMortgageBasicServiceImpl {
	
	@Autowired
	private GrtMortgageBasicMapper grtMortgageBasicMapper;
	@Autowired
	private BizGrtRelMapper bizGrtRelMapper;
	@Autowired
	private GrtCollateralMapper grtCollateralMapper;
	public Map<String, Object> getMortgageList(Integer pageNum, Integer pageSize, String suretyType, String applyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum,pageSize);
		List<MortgageBasicBean> list = grtMortgageBasicMapper.getMortgageList(applyId,suretyType);
		PageInfo<MortgageBasicBean> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> getCollateralList(Integer pageNum, Integer pageSize, String customerType,String mpType,
			String partyName,String certType,String certNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum,pageSize);
		List<MortgageBasicBean> list = grtMortgageBasicMapper.getCollateralList(customerType,mpType,partyName,certType,certNum);
		PageInfo<MortgageBasicBean> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> saveMortgageBasic( GrtCollateral grtCollateral,BizGrtRel bizGrtRel) {
		Map<String, Object> map = new HashMap<String, Object>();
		//1核对抵质押率是否大于90%
		if(bizGrtRel.getMortgageRate().compareTo(new BigDecimal(Constant.MORTGAGE_RATE_MAX))>0){
			throw new RuntimeException("抵质押率不能超过90%");
		}
		//2该抵质押物对当前申请applyId是否已经绑定过
		Map<String,Object> result = bizGrtRelMapper.selectBySuretyIdAndApplyId(bizGrtRel.getSuretyId(),bizGrtRel.getApplyId());
		if(result!=null){
			throw new RuntimeException("此押品已经担保了此业务");
		}
		int i = bizGrtRelMapper.insertSelective(bizGrtRel);
		if(i<=0){
			throw new RuntimeException("保存失败！===》bizGrtRel");
		}
		i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i<=0){
			throw new RuntimeException("更新失败！===》grtCollateral");
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectMortgageBasicByRelationId(String relationId) {
		Map<String, Object> map = new HashMap<String, Object>();
		MortgageBasicBean mortgageBasicBean = grtMortgageBasicMapper.selectMortgageBasicByRelationId(relationId);
		if(mortgageBasicBean==null){
			throw new RuntimeException("该suretyId未查到对应的数据");
		}
		map.put("mortgageBasicBean",mortgageBasicBean);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> updateMortgageBasic(GrtCollateral grtCollateral, BizGrtRel bizGrtRel) {
		Map<String, Object> map = new HashMap<String, Object>();
		//1核对抵质押率是否大于90%
		if(bizGrtRel.getMortgageRate().compareTo(new BigDecimal(Constant.MORTGAGE_RATE_MAX))>0){
			throw new RuntimeException("抵质押率不能超过90%");
		}
		int i = bizGrtRelMapper.updateByPrimaryKeySelective(bizGrtRel);
		if(i<=0){
			throw new RuntimeException("更新失败！===》bizGrtRel");
		}
		if(grtCollateral.getSetGuarantyAmt().compareTo(new BigDecimal("0"))<0){
			throw new RuntimeException("已设定担保额数据异常！不能为负数");
		}
		i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i<=0){
			throw new RuntimeException("更新失败！===》grtCollateral");
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> deleteMortgageByRelationId(String relationId) {
		Map<String, Object> map = new HashMap<String, Object>();
		BizGrtRel grtRel = bizGrtRelMapper.selectByPrimaryKey(relationId);
		GrtCollateral grtCollateral2 = grtCollateralMapper.selectByPrimaryKey(grtRel.getSuretyId());
		GrtCollateral grtCollateral = new GrtCollateral();
		grtCollateral.setGuarantyId(grtRel.getSuretyId());
		BigDecimal setGuarantyAmt = grtCollateral2.getSetGuarantyAmt().subtract(grtRel.getMortgageValue());
		if(setGuarantyAmt.compareTo(new BigDecimal("0"))<0){
			throw new RuntimeException("已设定担保额数据异常！不能为负数");
		}
		grtCollateral.setSetGuarantyAmt(setGuarantyAmt);
		//TODO 删除逻辑
		int i = bizGrtRelMapper.deleteByPrimaryKey(relationId);
		if(i<=0){
			throw new RuntimeException("删除失败！===》bizGrtRel");
		}
		//更新表担保品表
		i= grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i<=0){
			throw new RuntimeException("更新失败！===》grtCollateral");
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}

}
