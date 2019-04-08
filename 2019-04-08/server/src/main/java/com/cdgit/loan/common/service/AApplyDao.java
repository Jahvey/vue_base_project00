package com.cdgit.loan.common.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;


import com.cdgit.loan.common.bean.ApplyDaoParam;
import com.cdgit.loan.common.util.StringUtil;


public abstract class AApplyDao implements IApplyDao {
	private String flowName;
	private ApplyDaoParam daoParam;

	
	public AApplyDao() {
		
	}

	@Transactional
	@Override
	public Object create(Map<String, Object> apply) {
		String error = createValid(apply);
		if (error != null) {
			throw new RuntimeException(error);
		}
		Object applyObj = createApply(apply);
		return applyObj;
	}

	@Override
	public Object update(Map<String, Object> data) {
		throw new RuntimeException("没有实现" + this.getClass().getName() + ".update");
	}

	@Override
	public void remove(Object data) {
		throw new RuntimeException("没有实现" + this.getClass().getName() + ".remove");
	}

	@Override
	public void remove(String dataId) {
		throw new RuntimeException("没有实现" + this.getClass().getName() + ".remove(String)");
	}

	@Override
	public Object saveDetail(Map<String, Object> detail) {
		throw new RuntimeException("没有实现" + this.getClass().getName() + ".saveDetail");
	}

	@Override
	public void removeDetail(String detailId) {
		throw new RuntimeException("没有实现" + this.getClass().getName() + ".removeDetail");
	}

	@Override
	public void removeDetails(String applyId, String[] detailIds) {
		throw new RuntimeException("没有实现" + this.getClass().getName() + ".removeDetails");
	}

	public String createValid(Map<String, Object> dataMap) {
		return null;
	}

	public abstract Object createApply(Map<String, Object> dataMap);

	public abstract String getEntityId();

	public String createProcess(Object bizObj) {
		String flowName = getFlowName();
		if (StringUtil.isNull(flowName)) {
			return null;
		}
		return "";
	}

	public ApplyDaoParam getDaoParam() {
		try {
			return (ApplyDaoParam) daoParam.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException("获取ApplyDaoParam数据失败", e);
		}
	}

	@Override
	public void setDaoParam(ApplyDaoParam daoParam) {
		this.daoParam = daoParam;
	}

	@Override
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getFlowName() {
		return flowName;
	}

}
