package com.cdgit.loan.business.service;

import java.util.Map;


/**
 * 用信-一体化-调整
 * 
 * 
 * @author crms18
 * 
 */
public class BizDao0204 extends BizDao0201 {
	public BizDao0204() {
		dao = new BizDaoXX04();
		daoValid = new BizDaoValid0201();
	}

	@Override
	protected void setBizInfo(Map<String, Object> dataMap) {
		super.setBizInfo(dataMap);
		dataMap.put("happenType", "04");
	}
}
