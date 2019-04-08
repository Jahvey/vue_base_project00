package com.cdgit.loan.business.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdgit.loan.business.bean.TbBizAmountApply;
import com.cdgit.loan.business.bean.TbBizApply;
import com.cdgit.loan.business.mapper.BusinessMapper;
import com.cdgit.loan.common.service.ApplyDaoUtils;
import com.cdgit.loan.common.util.GitUtil;


/**
 * 用信-一体化-创建
 * 
 * 一体化用信层是随授信同步创建 <br/>
 * 1.不需要单独的校验规则<br/>
 * 2.不需要中途更新用信总表，在流程结束后统一更新
 * 
 * @author crms18
 * 
 */
public class BizDao0201 extends BizDao0001 {
	
	@Autowired
	BusinessMapper businessMapper;
	
	@Override
	protected void setBizType(Map<String, Object> dataMap) {
		dataMap.put("creditMode", ApplyDaoUtils.CREDIT_MODE_UNITE);
		dataMap.put("bizType", "02");
		dataMap.put("bizTypeFlag", "02");
		dataMap.put("applyModeType", "01");
	}

	public BizDao0201() {
		dao = new BizDaoXX01() {
			@Override
			protected Object createBizDtl(TbBizApply biz, TbBizAmountApply bizA,Map<String, Object> dataMap) {
				// 一体化用信没有创建功能
				return null;
			}
		};
		daoValid = new BizDaoValid0201();
	}
	
	@Override
	public Object update(Map<String, Object> dataMap) {
		// 一体化授信联动更新		
		TbBizApply biz=new TbBizApply();
		biz.setApplyId((String)dataMap.get("bizId"));
		biz.setTermNum((Integer)dataMap.get("termNum"));
		biz.setGuarantyType((String)dataMap.get("guarantyType"));
		biz.setUpdateTime(GitUtil.getCurrDate());
		businessMapper.updateBiz(biz);
		return biz;
	}

}
