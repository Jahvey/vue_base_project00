package com.cdgit.loan.creditLimit.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdgit.loan.common.util.GitUtil;
import com.cdgit.loan.creditLimit.mapper.CreditLimitMapper;


/**
 * 授信批复 额度计算(实际授信额度)
 * 
 * @author crms18
 * 
 */
public class CrdCreditReckon extends ACreditReckon {
	private ICreditReckon bizReckon;

	@Autowired
	CreditLimitMapper creditLimitMapper;
	
	@Override
	public void refurbish(String crdId) {
//		DatabaseExt.executeNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.credit.reckon.CreditReckonSql.updateCrdCredit", crdId);
		creditLimitMapper.updateCrdCredit(crdId);
	}

	@Override
	public void updateCredit(String crdId, Map<String, Object> map) {
		super.updateCredit(crdId, map);
		Object[] bizIds = getBizIds(crdId);
		if (bizIds != null && bizIds.length > 0) {
			for (int i = 0; i < bizIds.length; i++) {
				bizReckon.refurbish((String) bizIds[i]);
			}
		}
	}

	@Override
	protected void updateCreditMe(String crdId, Map<String, Object> map) {
		refurbish(crdId);
	}

	@Override
	public void abateCredit(String crdId, String statusCd) {
//		super.abateCredit(crdId, statusCd);
//		Object[] bizIds = getBizIds(crdId);
//		if (bizIds != null && bizIds.length > 0) {
//			for (int i = 0; i < bizIds.length; i++) {
//				// 额度明细会关联刷新用信明细状态，所以此处不需要级联刷新
//				DataObject biz = DataObjectUtil.createDataObject(BizTableName.TB_BIZ_APPROVE);
//				biz.set("approveId", bizIds[i]);
//				biz.set("becomeEffectiveMark", statusCd);
//				DatabaseUtil.updateEntity(DBUtil.DB_NAME_DEF, biz);
//			}
//		}
	}

	@Override
	public void abateCreditMe(String crdId, String statusCd) {
//		if (statusCd == null || "03".equals(statusCd)) {
//			throw new RuntimeException("请传入正确的状态[" + statusCd + "]");
//		}
//		DataObject crd = DataObjectUtil.createDataObject(CrdTableName.TB_CRD_APPROVE);
//		crd.set("crdId", crdId);
//		crd.set("statusCd", statusCd);
//		DatabaseUtil.updateEntity(DBUtil.DB_NAME_DEF, crd);
//		// 总额度失效，级联失效明细额度
//		Object[] sonIds = getSonIds(crdId);
//		for (int i = 0; i < sonIds.length; i++) {
//			sonReckon.abateCredit((String) sonIds[i], statusCd);
//		}
//		// 存在一体化明细时，同时失效一体化明细
//		String bizId = CrdDaoUtil.getCrdBizId(crdId);
//		if (bizId != null) {
//			CreditReckonUtil.getBiz().abateCredit(bizId, statusCd);
//		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getCreditMap(String crdId) {
//		Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.credit.reckon.CreditReckonSql.getCrdCredit", crdId);
		Object[] datas = creditLimitMapper.getCrdCredit(crdId);
		if (datas == null || datas.length == 0) {
			return null;
		}
		return (Map<String, Object>) datas[0];
	}

	@Override
	protected String getStatus(Map<String, Object> map) {
		String status = (String) map.get("STATUS_CD");
		if (GitUtil.contain(status, new String[] { "01", "02", "06" })) {
			return null;
		} else if ("03".equals(status)) {
			return STATUS_DO;
		}
		return status;
	}

	@Override
	public Object[] getSonIds(String crdId) {
//		return DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.credit.reckon.CreditReckonSql.getCrdDtlIds", crdId);
		return creditLimitMapper.getCrdDtlIds(crdId);
	}

	public Object[] getBizIds(String crdId) {
//		return DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.credit.reckon.CreditReckonSql.getBizIds", crdId);
		return creditLimitMapper.getBizIdsByCrdId(crdId);
	}

	public ICreditReckon getBizReckon() {
		return bizReckon;
	}

	public void setBizReckon(ICreditReckon bizReckon) {
		this.bizReckon = bizReckon;
	}

}
