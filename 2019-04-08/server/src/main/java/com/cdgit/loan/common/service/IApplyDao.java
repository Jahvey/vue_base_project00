package com.cdgit.loan.common.service;

import java.util.Map;

import com.cdgit.loan.common.bean.ApplyDaoParam;



public interface IApplyDao extends IDao {
	public String createValid(Map<String, Object> data);

	/**
	 * 设置流程名称
	 */
	public void setFlowName(String flowName);

	/**
	 * 创建明细
	 * 
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	public Object saveDetail(Map<String, Object> detail);

	/**
	 * 删除明细
	 * 
	 * @param detailId
	 * @throws Exception
	 */
	public void removeDetail(String detailId);

	public void removeDetails(String applyId, String[] detailIds);

	public void setDaoParam(ApplyDaoParam param);

}
