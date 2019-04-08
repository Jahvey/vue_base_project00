package com.cdgit.loan.creditLimit.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdgit.loan.common.service.ApplyDaoUtils;
import com.cdgit.loan.creditLimit.bean.TbCrdDetailApprove;
import com.cdgit.loan.creditLimit.mapper.CrdDaoUtilMapper;
import com.cdgit.loan.creditLimit.mapper.CreditLimitMapper;


/**
 * 授信批复明细 额度计算
 * 
 * @author crms18
 * 
 */
public class CrdDtlCreditReckon extends ACreditReckon {
	private ICreditReckon crdReckon;

	@Autowired
	CreditLimitMapper creditLimitMapper;
	
	@Autowired
	CrdDaoUtilMapper crdDaoUtilMapper;
	
	
	@Override
	public void refurbish(String crdDtlId) {
		Map<String, Object> map = getCreditMap(crdDtlId);
		updateCreditMe(crdDtlId, map);
		crdReckon.refurbish((String) map.get("CRD_ID"));
	}

	@Override
	protected void updateCreditMe(String crdDtlId, Map<String, Object> map) {
//		BigDecimal boUse = (BigDecimal) map.get("RMB_AMT");
//		BigDecimal noUse = getRelNoUse(crdDtlId);
//		map.put("crdDtlId", crdDtlId);
//		map.put("cycleInd", map.get("CYCLE_IND"));
//		if (isBoUse(getStatus(map))) {
//			BigDecimal conOccupy = getConOccupy(map);
//			boUse = boUse.subtract(conOccupy).subtract(noUse);
//		} else {
//			boUse = BigDecimal.ZERO;
//		}
//		boUse = CreditReckonUtil.formatAmt(boUse);
//		map.put("crdDtlId", crdDtlId);
//		map.put("noUse", noUse);
//		map.put("boUse", boUse);
//		DatabaseExt.executeNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.credit.reckon.CreditReckonSql.updateCrdDtlCredit", map);
//		// 一体化同步更新额度信息
//		if (ApplyDaoUtils.CREDIT_MODE_UNITE.equals(map.get("CREDIT_MODE"))) {
//			DatabaseExt.executeNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.credit.reckon.CreditReckonSql.updateBizDtlCreditBy02", map);
//		}
	}

	@Override
	public void abateCreditMe(String crdDtlId, String statusCd) {
		if (statusCd == null || STATUS_DO.equals(statusCd)) {
			throw new RuntimeException("请传入正确的状态[" + statusCd + "]");
		}
		TbCrdDetailApprove crdDtl=new TbCrdDetailApprove();
		crdDtl.setCrdDtlId(crdDtlId);
		crdDtl.setCreditStatus(statusCd);
		crdDtl.setBoUse(BigDecimal.ZERO);
		creditLimitMapper.updateCrdDtlApprove(crdDtl);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getCreditMap(String crdDtlId) {
//		Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.credit.reckon.CreditReckonSql.getCrdDtlCredit", crdDtlId);
		
		Object[] datas = creditLimitMapper.getCrdDtlCredit(crdDtlId);
		
		if (datas == null || datas.length == 0) {
			return null;
		}
		return (Map<String, Object>) datas[0];
	}

	@Override
	public Object[] getSonIds(String crdDtlId) {
//		return DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.credit.reckon.CreditReckonSql.getBizDtlIdsByCrdDtlId", crdDtlId);
		return creditLimitMapper.getBizDtlIdsByCrdDtlId(crdDtlId);
	}

	@Override
	protected String getStatus(Map<String, Object> map) {
		return map == null ? null : (String) map.get("CREDIT_STATUS");
	}

	public BigDecimal getRelNoUse(String crdDtlId) {
//		Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.credit.reckon.CreditReckonSql.getFreezeAmt", crdDtlId);
		Object[] datas = creditLimitMapper.getFreezeAmt(crdDtlId);
		BigDecimal noUse = datas == null || datas.length == 0 ? BigDecimal.ZERO : (BigDecimal) datas[0];
		return noUse.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : noUse;
	}

	@SuppressWarnings("unchecked")
	public  BigDecimal getConOccupy(Map<String, Object> map) {//去掉static 调用看会否有影响
		if ("1".equals(map.get("CYCLE_IND"))) {
			map.put("conStatus", new String[] { "03" });
		} else {
			map.put("conStatus", new String[] { "03", "05" });
		}
//		Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.credit.reckon.CreditReckonSql.getConOccupyToCrd", map);
		
		Object[] datas = creditLimitMapper.getConOccupyToCrd(map);
		
		if (datas.length == 0 || datas[0] == null) {
			return BigDecimal.ZERO;
		}
		Map<String, Object> conMap;
		BigDecimal conOccupy = BigDecimal.ZERO;
		Set<String> filters = new HashSet<String>();
		Set<String> jxhjIds = new HashSet<String>();
		// 1.非循环授信才处理借新还旧
		// 2.使用jxhjIds储存借新还旧对应的原合同编号
		// 3.过滤掉原合同已经失效或者结清数据
		// 4.统计数据时，当jxhjIds存在原有合同，当前合同不统计
		for (int i = 0; i < datas.length; i++) {
			conMap = (Map<String, Object>) datas[i];
			filters.add((String) conMap.get("OLD_CONTRACT_ID"));
			if (conMap.get("JXHJ_ID") != null) {
				if (!"1".equals(map.get("CYCLE_IND"))) {
					jxhjIds.add((String) conMap.get("JXHJ_ID"));
				}
			}
		}
		// 去除借新还旧对应的原合同已失效或者占用结清数据
		Iterator<String> iter = jxhjIds.iterator();
		out: while (iter.hasNext()) {
			String conId = iter.next();
			for (int i = 0; i < datas.length; i++) {
				conMap = (Map<String, Object>) datas[i];
				if (conId.equals(conMap.get("CONTRACT_ID"))) {
					if (conMap.get("CON_OCCUPY") == null || ((BigDecimal) (conMap.get("CON_OCCUPY"))).compareTo(BigDecimal.ZERO) <= 0) {
						iter.remove();
					}
					continue out;
				}
			}
			iter.remove();
		}
		for (int i = 0; i < datas.length; i++) {
			conMap = (Map<String, Object>) datas[i];
			if (filters.contains(conMap.get("CONTRACT_ID")) || jxhjIds.contains(conMap.get("JXHJ_ID"))) {
				continue;
			}
			conOccupy = conOccupy.add(conMap.get("CON_OCCUPY") == null ? BigDecimal.ZERO : (BigDecimal) conMap.get("CON_OCCUPY"));
		}
		return conOccupy;
	}

	public void setCrdReckon(ICreditReckon crdReckon) {
		this.crdReckon = crdReckon;
	}

	public ICreditReckon getCrdReckon() {
		return crdReckon;
	}
}
