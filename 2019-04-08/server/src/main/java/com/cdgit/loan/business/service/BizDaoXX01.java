package com.cdgit.loan.business.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.business.bean.TbBizAmountApply;
import com.cdgit.loan.business.bean.TbBizAmountDetailApply;
import com.cdgit.loan.business.bean.TbBizApply;
import com.cdgit.loan.business.mapper.BusinessMapper;
import com.cdgit.loan.common.bean.ApplyDaoParam;
import com.cdgit.loan.common.mapper.BizDaoUtilMapper;
import com.cdgit.loan.common.service.ApplyDaoUtils;
import com.cdgit.loan.common.service.IDao;
import com.cdgit.loan.common.util.BizDaoUtil;
import com.cdgit.loan.common.util.GitUtil;
import com.cdgit.loan.common.util.MoneyUtil;
import com.cdgit.loan.common.util.uid.UUIDGenerator;


public class BizDaoXX01 implements IDao {
	
	@Autowired
	BizDaoUtilMapper bizDaoUtilMapper;
	
	@Autowired
	BusinessMapper businessMapper;
	
	@Transactional
	@Override
	public Object create(Map<String, Object> dataMap) {
		TbBizApply biz = createBiz(dataMap);
		TbBizAmountApply bizA = createBizA(biz, dataMap);
		createBizOther(biz,dataMap);
		createBizDtl(biz,bizA,dataMap);
		return biz;
	}

	@Transactional
	@Override
	public Object update(Map<String, Object> dataMap) {
//		DataObject biz = DataObjectUtil.createDataObject(BizTableName.TB_BIZ_APPLY);
//		biz.set("applyId", dataMap.get("applyId"));
//		biz.set("termNum", dataMap.get("termNum"));
//		biz.set("guarantyType", dataMap.get("guarantyType"));
//		biz.set("whetherBzxzfdk", dataMap.get("whetherBzxzfdk"));
//		biz.set("busiPartner", dataMap.get("busiPartner"));
//		biz.set("updateTime", GitUtil.getCurrDate());
//		DatabaseUtil.updateEntity(DBUtil.DB_NAME_DEF, biz);
		dataMap.put("updateTime", GitUtil.getCurrDate());
		businessMapper.updateBizByMap(dataMap);
		businessMapper.updateBizA(dataMap);
		return null;
	}

	@Transactional
	@Override
	public void remove(Object biz) {
//		removeBizOther(biz);
//		removeBizDtlAll(biz);
//		removeBizA(biz);
//		DatabaseUtil.deleteEntity(DBUtil.DB_NAME_DEF, biz);
	}

	@Override
	public void remove(String bizId) {
//		DataObject biz = EntityUtil.getEntityById(BizTableName.TB_BIZ_APPLY, "applyId", bizId);
//		remove(biz);
	}

	protected TbBizApply createBiz(Map<String, Object> dataMap) {
		
		// biz.set("crdId", dataMap.get("crdId"));
		// biz.set("partyId", dataMap.get("partyId"));
		// biz.set("creditMode", dataMap.get("creditMode"));
		
		TbBizApply biz=new TbBizApply();
		biz.setApplyId(UUIDGenerator.getUUID());
		biz.setBizNum(BizDaoUtil.createBizNum());
		biz.setStatusType("01");
		biz.setOrgNum(GitUtil.getCurrentOrgCd());
		biz.setUserNum(GitUtil.getCurrentUserId());
		biz.setCreateTime(GitUtil.getCurrDate());
		biz.setApplyDate(GitUtil.getBusiDate());
		businessMapper.insertTbBizApply(biz);
		return biz;
	}

	protected TbBizAmountApply createBizA(TbBizApply biz, Map<String, Object> dataMap) {
		TbBizAmountApply amountApply=new TbBizAmountApply();
		amountApply.setAmountId(UUIDGenerator.getUUID());
		amountApply.setPartyId(biz.getPartyId());
		amountApply.setApplyId(biz.getApplyId());
		businessMapper.insertAmountApply(amountApply);
		return amountApply;
	}

	protected Object createBizDtl(TbBizApply biz,TbBizAmountApply bizA,Map<String, Object> dataMap) {
		TbBizAmountDetailApply bizDtl=new TbBizAmountDetailApply();
		bizDtl.setAmountDetailId(UUIDGenerator.getUUID());
		bizDtl.setApplyId(biz.getApplyId());
		bizDtl.setAmountId(bizA.getAmountId());//怎么获取？
		bizDtl.setCreditMode(biz.getCreditMode());
		bizDtl.setCycleInd("0");
		bizDtl.setCurrencyCd(MoneyUtil.CURRENCYCD_CNY);
		bizDtl.setCreateTime(GitUtil.getCurrDate());
		businessMapper.insertAmountDetailApply(bizDtl);
		return bizDtl;
	}

	protected void createBizOther(Object biz, Map<String, Object> dataMap) {
		
	}

	/**
	 * 以前参数传递都是DataObject
	
	 * <p>Title: removeBizOther</p>  
	
	 * <p>Description: </p>  
	
	 * @param biz
	 */
	protected void removeBizOther(TbBizApply biz) {
//		// 押品关联关系
//		GrtDaoUtil.removeTbBizGrtRel(biz.getString("applyId"));//后面根据需要实现
		// 最高额担保
		BizDaoUtil.removeTbBizGrtMaxloanconApply(biz.getApplyId());
		BizDaoUtil.removeTbBizXb(biz.getApplyId());
		BizDaoUtil.removeTbBizYesornoApply(biz.getApplyId());
		BizDaoUtil.removeTbBizTxxxApply(biz.getApplyId());
		// -------------
		BizDaoUtil.removeTbSysFlowTest(biz.getApplyId());

		BizDaoUtil.removeTbBizBankStructApply(biz.getApplyId());
		BizDaoUtil.removeTbBizTx(biz.getApplyId());
		BizDaoUtil.removeTbBizXmxxApply(biz.getApplyId());
	}

	protected void removeBizA(TbBizApply biz) {
		BizDaoUtil.removeTbBizAmountApply(biz.getApplyId());
	}

	protected void removeBizDtl(TbBizAmountDetailApply bizDtl) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("CREDIT_MODE", bizDtl.getCreditMode());
		map.put("PRODUCT_TYPE", bizDtl.getProductType());
		ApplyDaoUtils.getDetailDao(removeBizDtlDaoParam(map)).remove(bizDtl);
	}

	@SuppressWarnings("unchecked")
	protected void removeBizDtlAll(TbBizApply biz) {
		Object[] datas = getBizDtlIds(biz.getApplyId());
		for (int i = 0; i < datas.length; i++) {
			Map<String, String> map = (Map<String, String>) datas[i];
			TbBizAmountDetailApply bizDtl=new TbBizAmountDetailApply();
			bizDtl.setAmountDetailId(map.get("AMOUNT_DETAIL_ID"));
			bizDtl.setProductType(map.get("PRODUCT_TYPE"));
			ApplyDaoUtils.getDetailDao(removeBizDtlDaoParam(map)).remove(bizDtl);
		}
	}

	protected Object[] getBizDtlIds(String bizId) {
		return businessMapper.getBizDtlInfos(bizId);
	}

	protected ApplyDaoParam removeBizDtlDaoParam(Map<String, ?> map) {
		ApplyDaoParam param = new ApplyDaoParam("bizDtl", (String) map.get("CREDIT_MODE") + "01");
		param.setOrgCode(GitUtil.getCurrentOrgCd());
		param.setLegOrg(GitUtil.getLegorgByOrgCd(param.getOrgCode()));
		param.setProduct((String) map.get("PRODUCT_TYPE"));
		return param;
	}

}
