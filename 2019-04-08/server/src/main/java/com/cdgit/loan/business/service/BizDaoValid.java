package com.cdgit.loan.business.service;

import java.util.Map;


public interface BizDaoValid {
	public String createValid(Map<String, Object> map);

	public void updateValid(Map<String, Object> dataMap);

	public void removeValid(Object biz);

	public void createDtlValid(Map<String, Object> dataMap);

	public void saveDtlValid(Map<String, Object> dataMap);
}
