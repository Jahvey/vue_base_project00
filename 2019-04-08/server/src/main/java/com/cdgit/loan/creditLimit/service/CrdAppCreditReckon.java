package com.cdgit.loan.creditLimit.service;

import java.util.Map;


/**
 * 授信申请 额度计算(申请阶段额度) 只归集对应的明细额度即可，没有其他任何操作
 * 
 * @author crms18
 * 
 */
public class CrdAppCreditReckon extends ACreditReckon {

	@Override
	public void refurbish(String crdId) {
		newly(crdId);
	}

	@Override
	public void newly(String crdId) {
//		DatabaseExt.executeNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.credit.reckon.CreditReckonSql.updateCrdAppCredit", crdId);
	}

	@Override
	public void abateCreditMe(String bizId, String statusCd) {

	}

	@Override
	protected void updateCreditMe(String bizId, Map<String, Object> map) {

	}

	@Override
	public Map<String, Object> getCreditMap(String bizId) {
		return null;
	}

}
