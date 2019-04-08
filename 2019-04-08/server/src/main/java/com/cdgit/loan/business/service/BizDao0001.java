package com.cdgit.loan.business.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.service.AApplyDao;
import com.cdgit.loan.common.service.ApplyDaoUtils;
import com.cdgit.loan.common.service.IDao;
import com.cdgit.loan.common.util.BizDaoUtil;
import com.cdgit.loan.creditLimit.service.CsmUtil;


/**
 * 用信-分离式-创建
 * 
 * @author crms18
 * 
 */
public class BizDao0001 extends AApplyDao {
	protected IDao dao;
	protected BizDaoValid daoValid;

	public BizDao0001() {
		dao = new BizDaoXX01();
		daoValid = new BizDaoValid0001();
	}

	@Override
	public String getEntityId() {
		return "applyId";
	}

	protected void setBizType(Map<String, Object> dataMap) {
		dataMap.put("creditMode", ApplyDaoUtils.CREDIT_MODE_CLEFT);
		dataMap.put("bizType", "02");
		dataMap.put("bizTypeFlag", "10");
		dataMap.put("applyModeType", "01");
	}

	@Override
	public String createValid(Map<String, Object> map) {
		return daoValid.createValid(map);
	}

	@Transactional
	@Override
	public Object createApply(Map<String, Object> dataMap) {
		setBizInfo(dataMap);
		setBizType(dataMap);
		return dao.create(dataMap);
	}

	@Transactional
	@Override
	public Object update(Map<String, Object> dataMap) {
		daoValid.updateValid(dataMap);
		return dao.update(dataMap);
	}

	@Override
	public void remove(String applyId) {
		dao.remove(applyId);
	}

	@Transactional
	@Override
	public void remove(Object biz) {
		daoValid.removeValid(biz);
		dao.remove(biz);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Object saveDetail(Map<String, Object> dataMap) {
//		DataObject bizDtl = EosUtil.createDataObjectByMap(BizTableName.TB_BIZ_AMOUNT_DETAIL_APPLY, (Map<String, Object>) dataMap.get("amountDetail"));
//		String productType = bizDtl.getString("productType");
//		if (StringUtil.isNull(productType)) {
//			throw new RuntimeException("保存明细失败：无法获取明细对应的产品编号");
//		}
//		MoneyUtil.validRmb(bizDtl);
//		ApplyDaoParam param = getDaoParam();
//		param.setProduct(productType);
//		dataMap.put("amountDetail", bizDtl);
//		if (bizDtl.get("amountDetailId") == null) {
//			daoValid.createValid(dataMap);
//			bizDtl = ApplyDaoUtil.getDetailDao(param).create(dataMap);
//		} else {
//			daoValid.saveDtlValid(dataMap);
//			bizDtl = ApplyDaoUtil.getDetailDao(param).update(dataMap);
//		}
//		CreditReckonUtil.getBizApp().refurbish(bizDtl.getString("applyId"));
//		return bizDtl;
		return new Object();
	}

	protected void setBizInfo(Map<String, Object> dataMap) {
		if (dataMap.get("bizHappenType") == null) {
			dataMap.put("bizHappenType", BizDaoUtil.getHappenType((String) dataMap.get("partyId")));
		}
		if (dataMap.get("loanType") == null) {
			dataMap.put("loanType", "0");
		}
		if (dataMap.get("termUnit") == null) {
			dataMap.put("termUnit", "04");
		}
		if (dataMap.get("isBankTeamLoan") == null) {
			dataMap.put("isBankTeamLoan", "0");
		}
		if (dataMap.get("csmCrdLevel") == null) {
			dataMap.put("csmCrdLevel", CsmUtil.getCreditLevel((String) dataMap.get("partyId"), null));
		}
	}
}
