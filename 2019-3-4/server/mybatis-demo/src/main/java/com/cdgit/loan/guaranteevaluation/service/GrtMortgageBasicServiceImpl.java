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
import com.cdgit.loan.guaranteevaluation.bean.GrtMortgageBasic;
import com.cdgit.loan.guaranteevaluation.bean.MortgageBasicBean;
import com.cdgit.loan.guaranteevaluation.mapper.BizGrtRelMapper;
import com.cdgit.loan.guaranteevaluation.mapper.GrtMortgageBasicMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class GrtMortgageBasicServiceImpl {
	
	@Autowired
	private GrtMortgageBasicMapper grtMortgageBasicMapper;
	@Autowired
	private BizGrtRelMapper bizGrtRelMapper;
	public Map<String, Object> getMortgageList(Integer pageNum, Integer pageSize, String collType, String applyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum,pageSize);
		List<MortgageBasicBean> list = grtMortgageBasicMapper.getMortgageList(applyId,collType);
		PageInfo<MortgageBasicBean> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> getCollateralList(Integer pageNum, Integer pageSize, String customerType,String collType,
			String partyName,String certType,String certNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum,pageSize);
		List<MortgageBasicBean> list = grtMortgageBasicMapper.getCollateralList(customerType,collType,partyName,certType,certNum);
		PageInfo<MortgageBasicBean> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> saveMortgageBasic(GrtMortgageBasic grtMortgageBasic, BizGrtRel bizGrtRel) {
		Map<String, Object> map = new HashMap<String, Object>();
		//1核对抵质押率是否大于90%
		if(grtMortgageBasic.getMortgageRate().compareTo(new BigDecimal(Constant.MORTGAGE_RATE_MAX))>0){
			throw new RuntimeException("抵质押率不能超过90%");
		}
		//2该抵质押物对当前申请applyId是否已经绑定过
		List<Map<String,Object>> list = grtMortgageBasicMapper.selectBySuretyIdAndApplyId(grtMortgageBasic.getSuretyId(),bizGrtRel.getApplyId());
		if(list!=null && list.size()>0){
			throw new RuntimeException(grtMortgageBasic.getSuretyName()+"已经担保了此业务");
		}
		int i = grtMortgageBasicMapper.insertSelective(grtMortgageBasic);
		if(i<=0){
			throw new RuntimeException("保存失败！===》grtMortgageBasic");
		}
		i = bizGrtRelMapper.insertSelective(bizGrtRel);
		if(i<=0){
			throw new RuntimeException("保存失败！===》bizGrtRel");
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectMortgageBasicBySuretyId(String suretyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		MortgageBasicBean mortgageBasicBean = grtMortgageBasicMapper.selectMortgageBasicBySuretyId(suretyId);
		if(mortgageBasicBean==null){
			throw new RuntimeException("该suretyId未查到对应的数据");
		}
		map.put("mortgageBasicBean",mortgageBasicBean);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> updateMortgageBasic(GrtMortgageBasic grtMortgageBasic, BizGrtRel bizGrtRel) {
		Map<String, Object> map = new HashMap<String, Object>();
		//1核对抵质押率是否大于90%
		if(grtMortgageBasic.getMortgageRate().compareTo(new BigDecimal(Constant.MORTGAGE_RATE_MAX))>0){
			throw new RuntimeException("抵质押率不能超过90%");
		}
		int i = grtMortgageBasicMapper.updateByPrimaryKeySelective(grtMortgageBasic);
		if(i<=0){
			throw new RuntimeException("更新失败！===》grtMortgageBasic");
		}
		i = bizGrtRelMapper.updateByPrimaryKeySelective(bizGrtRel);
		if(i<=0){
			throw new RuntimeException("更新失败！===》bizGrtRel");
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> deleteMortgageBasicBySuretyId(String suretyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		//TODO 删除逻辑
		int i = bizGrtRelMapper.deleteBySuretyId(suretyId);
		if(i<=0){
			throw new RuntimeException("删除失败！===》bizGrtRel");
		}
		i = grtMortgageBasicMapper.deleteByPrimaryKey(suretyId);
		if(i<=0){
			throw new RuntimeException("删除失败！===》grtMortgageBasic");
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}

}
