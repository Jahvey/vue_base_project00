package com.cdgit.loan.common.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.bean.ApplyDaoParam;


public abstract class AApplyApprove implements IApplyDao, IApplyApprove {
	private String flowName;
	private ApplyDaoParam daoParam;

	@Transactional
	@Override
	public Object create(Map<String, Object> dataMap) {
		return approve(dataMap);
	}

	@Override
	public Object update(Map<String, Object> dataMap) {
		return null;
	}

	@Override
	public void remove(String dataId) {

	}

	@Override
	public void remove(Object data) {

	}

	@Override
	public String createValid(Map<String, Object> dataMap) {
		return null;
	}

	@Override
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getFlowName() {
		return flowName;
	}

	@Override
	public Object saveDetail(Map<String, Object> detail) {
		return null;
	}

	@Override
	public void removeDetail(String detailId) {

	}

	@Override
	public void removeDetails(String applyId, String[] detailIds) {

	}

	@Override
	public void setDaoParam(ApplyDaoParam param) {
		this.daoParam = param;
	}

	public ApplyDaoParam getDaoParam() {
		try {
			return (ApplyDaoParam) daoParam.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException("获取ApplyDaoParam数据失败", e);
		}
	}
}
