package com.cdgit.loan.guaranteevaluation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.guaranteevaluation.bean.BizGrtRel;
import com.cdgit.loan.guaranteevaluation.bean.CashDepositBean;
import com.cdgit.loan.guaranteevaluation.bean.GrtMargin;
import com.cdgit.loan.guaranteevaluation.bean.GrtMortgageBasic;
import com.cdgit.loan.guaranteevaluation.mapper.BizGrtRelMapper;
import com.cdgit.loan.guaranteevaluation.mapper.GrtMarginMapper;
import com.cdgit.loan.guaranteevaluation.mapper.GrtMortgageBasicMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class DepositServiceImpl {
	@Autowired
	private GrtMarginMapper grtMarginMapper;
	@Autowired
	private GrtMortgageBasicMapper grtMortgageBasicMapper;
	@Autowired
	private BizGrtRelMapper bizGrtRelMapper;
	public Map<String, Object> getCashDepositList(Integer pageNum,Integer pageSize,String applyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum,pageSize);
		List<CashDepositBean> list = grtMarginMapper.getCashDepositList(applyId);
		PageInfo<CashDepositBean> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> saveDeposit(GrtMortgageBasic grtMortgageBasic, GrtMargin grtMargin,
			BizGrtRel bizGrtRel) {
		Map<String, Object> map = new HashMap<String, Object>();
		//TODO 去从校验
		int i = grtMortgageBasicMapper.insertSelective(grtMortgageBasic);
		if(i<=0){
			throw new RuntimeException("保存失败!==>grtMortgageBasic");
		}
		i = bizGrtRelMapper.insertSelective(bizGrtRel);
		if(i<=0){
			throw new RuntimeException("保存失败!==>bizGrtRel");
		}
		i = grtMarginMapper.insertSelective(grtMargin);
		if(i<=0){
			throw new RuntimeException("保存失败!==>grtMargin");
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> deleteDepositBySuretyKeyId(String suretyKeyId,String suretyId,String relationId) {
		//TODO 删除逻辑
		Map<String, Object> map = new HashMap<String, Object>();
		int i = grtMarginMapper.deleteByPrimaryKey(suretyKeyId);
		if(i<=0){
			throw new RuntimeException("删除失败!==>grtMargin");
		}
		i = bizGrtRelMapper.deleteByPrimaryKey(relationId);
		if(i<=0){
			throw new RuntimeException("删除失败!==>bizGrtRel");
		}
		i = grtMortgageBasicMapper.deleteByPrimaryKey(suretyId);
		if(i<=0){
			throw new RuntimeException("删除失败!==>grtMortgageBasic");
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectDepositBySuretyKeyId(String suretyKeyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		CashDepositBean cashDepositBean = grtMarginMapper.selectDepositBySuretyKeyId(suretyKeyId);
		if(cashDepositBean==null){
			throw new RuntimeException("查询失败!suretyKeyId:"+suretyKeyId+"，没有相关信息");
		}
		map.put("cashDepositBean", cashDepositBean);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> updateDeposit(GrtMortgageBasic grtMortgageBasic, GrtMargin grtMargin,
			BizGrtRel bizGrtRel) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = grtMortgageBasicMapper.updateByPrimaryKeySelective(grtMortgageBasic);
		if(i<=0){
			throw new RuntimeException("更新失败!==>grtMortgageBasic");
		}
		i = bizGrtRelMapper.updateByPrimaryKeySelective(bizGrtRel);
		if(i<=0){
			throw new RuntimeException("更新失败!==>bizGrtRel");
		}
		i = grtMarginMapper.updateByPrimaryKeySelective(grtMargin);
		if(i<=0){
			throw new RuntimeException("更新失败!==>grtMargin");
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}

}
