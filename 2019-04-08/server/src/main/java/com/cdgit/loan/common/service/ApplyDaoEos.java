package com.cdgit.loan.common.service;

import java.util.Map;

import com.cdgit.loan.common.bean.ApplyDaoParam;
import com.cdgit.loan.common.util.GitUtil;

public class ApplyDaoEos {

	private static void initParam(ApplyDaoParam param) {
		if (param.getOrgCode() == null) {
			param.setOrgCode(GitUtil.getCurrentOrgCd());
		}
		if (param.getLegOrg() == null) {
			param.setLegOrg(GitUtil.getLegorg());
		}
	}

	public String createValid(ApplyDaoParam param, Map<String, Object> data) throws Throwable {
		initParam(param);
		IApplyDao dao = ApplyDaoUtils.getApplyDao(param);
		return dao.createValid(data);
	}

	public static Object create(ApplyDaoParam param, Map<String, Object> data) throws Throwable {
		initParam(param);
		IApplyDao dao = ApplyDaoUtils.getApplyDao(param);
		return dao.create(data);
	}

//	public void update(ApplyDaoParam param, Map<String, Object> data) throws Throwable {
//		initParam(param);
//		IApplyDao dao = ApplyDaoUtils.getApplyDao(param);
//		dao.update(data);
//	}
//
//
//	public Object saveDetail(ApplyDaoParam param, Map<String, Object> data) throws Throwable {
//		initParam(param);
//		IApplyDao dao = ApplyDaoUtils.getApplyDao(param);
//		return dao.saveDetail(data);
//	}
//
//	public void remove(ApplyDaoParam param, String id) throws Throwable {
//		initParam(param);
//		IApplyDao dao = ApplyDaoUtil.getApplyDao(param);
//		dao.remove(id);
//	}
//
//	public void removeDetail(ApplyDaoParam param, String detailId) throws Throwable {
//		initParam(param);
//		IApplyDao dao = ApplyDaoUtil.getApplyDao(param);
//		dao.removeDetail(detailId);
//	}
//
//	public void removeDetails(ApplyDaoParam param, String applyId, String[] detailIds) throws Throwable {
//		initParam(param);
//		IApplyDao dao = ApplyDaoUtil.getApplyDao(param);
//		dao.removeDetails(applyId, detailIds);
//	}
}
