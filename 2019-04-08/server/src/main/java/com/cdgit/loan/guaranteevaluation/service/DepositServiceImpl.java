package com.cdgit.loan.guaranteevaluation.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.contract.mapper.CrtGitUtilMapper;
import com.cdgit.loan.guaranteevaluation.bean.BizGrtRel;
import com.cdgit.loan.guaranteevaluation.bean.CashDepositBean;
import com.cdgit.loan.guaranteevaluation.bean.GrtMargin;
import com.cdgit.loan.guaranteevaluation.mapper.BizGrtRelMapper;
import com.cdgit.loan.guaranteevaluation.mapper.GrtMarginMapper;
import com.cdgit.loan.securitymanagement.bean.GrtCollateral;
import com.cdgit.loan.securitymanagement.mapper.GrtCollateralMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class DepositServiceImpl {
	@Autowired
	private GrtMarginMapper grtMarginMapper;
	@Autowired
	private GrtCollateralMapper grtCollateralMapper;
	@Autowired
	private BizGrtRelMapper bizGrtRelMapper;
	@Autowired
	private CrtGitUtilMapper crtGitUtilMapper;
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
	public Map<String, Object> saveDeposit(GrtCollateral grtCollateral, GrtMargin grtMargin,
			BizGrtRel bizGrtRel) {
		Map<String, Object> map = new HashMap<String, Object>();
		//TODO 去从校验
		int i = grtCollateralMapper.insertSelective(grtCollateral);
		if(i<=0){
			throw new RuntimeException("保存失败!==>grtCollateral");
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
		i = grtCollateralMapper.deleteByPrimaryKey(suretyId);
		if(i<=0){
			throw new RuntimeException("删除失败!==>grtCollateral");
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
	public Map<String, Object> updateDeposit(GrtCollateral grtCollateral, GrtMargin grtMargin,
			BizGrtRel bizGrtRel) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i<=0){
			throw new RuntimeException("更新失败!==>grtCollateral");
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
	public Date getOperateDate(String str) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat(str);
		Date date = format.parse(crtGitUtilMapper.queryOperatingDate());
		return date;
	}
}
