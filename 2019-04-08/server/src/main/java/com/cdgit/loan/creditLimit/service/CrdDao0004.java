package com.cdgit.loan.creditLimit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.business.bean.TbBizApply;
import com.cdgit.loan.business.bean.TbBizYesornoApply;
import com.cdgit.loan.business.mapper.BusinessMapper;
import com.cdgit.loan.common.bean.ApplyDaoParam;
import com.cdgit.loan.common.service.ApplyDaoUtils;
import com.cdgit.loan.common.util.BeanUtil;
import com.cdgit.loan.common.util.GitUtil;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.creditLimit.bean.TbCrdApply;
import com.cdgit.loan.creditLimit.bean.TbCrdApprove;
import com.cdgit.loan.creditLimit.bean.TbCrdDetailApply;
import com.cdgit.loan.creditLimit.bean.TbCrdDetailApprove;
import com.cdgit.loan.creditLimit.mapper.CrdDaoUtilMapper;
import com.cdgit.loan.creditLimit.mapper.CreditLimitMapper;



/**
 * 授信-分离式-调整
 * 
 * @author crms18
 * 
 */
@Repository
public class CrdDao0004 extends CrdDao0001 {  

	@Autowired
	CreditLimitMapper creditLimitMapper;
	
	@Autowired
	BusinessMapper businessMapper;
	
	@Autowired
	CrdDaoUtilMapper crdDaoUtilMapper;
	
	@Override
	public String createValid(Map<String, Object> map) {
		TbCrdApprove crd=creditLimitMapper.selectCrdApproveByPrimaryKey((String) map.get("crdId"));
		if (!"03".equals(crd.getStatusCd())) {
			throw new RuntimeException("非[生效]状态数据不允许操作");
		} else if (!GitUtil.getCurrentUserId().equals(crd.getUserNum())) {
			throw new RuntimeException("非本人管理数据，请勿操作");
		}
		map.put("bizId", crd.getCrdId());
		map.put("abateType", "10");
//		RuleUtil.runRules(map, "RBIZ_0203"// 存在在途失效申请
//				, "RCRD_0212"// 存在在途授信调整
//				, "RCRD_0207"// 是否存在冻结申请
//				, "RCRD_0208"// 是否存在解冻申请
//				, "RCRD_0213"// 存在在途业务申请
//				, "RCRD_0214"// 存在在途合同签署或调整
//				, "RCRD_0215"// 存在在途出账
//		);
		map.put("partyId", crd.getCrdId());
		map.put("db_approve", crd);
		return null;
	}

	@Transactional
	@Override
	public Object createApply(Map<String, Object> dataMap) {
		TbCrdApply crd = createCrd(dataMap);
		createCrdOther(crd);
		Map<String, String> matchMap = createCrdDtl(crd);
		if (crd.getBizId() == null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("crdId", crd.getCrdId());
			map.put("partyId", crd.getPartyId());
			map.put("csmCrdLevel", crd.getCsmCrdLevel());
			map.put("termUnit", crd.getTermUnit());
			map.put("happenType", crd.getHappenType());
			createBiz(crd, map);
		} else {
			dataMap.put("bizId", crd.getBizId());
			dataMap.put("crdId", crd.getCrdId());
			dataMap.put("matchMap", matchMap);
			createBiz04(crd, dataMap);
		}
		return crd;
	}

	@Override
	public TbCrdApply createCrd(Map<String, Object> dataMap) {
//		Object oldCrd = (DataObject) dataMap.get("db_approve");
//		Object appCrd = DataObjectUtil.convertDataObject(oldCrd, CrdTableName.TB_CRD_APPLY, true);
		
		TbCrdApprove oldCrd=(TbCrdApprove)dataMap.get("db_approve");
		TbCrdApply appCrd=new TbCrdApply();
		BeanUtil.copyBeanProperties(oldCrd, appCrd);
		appCrd.setCrdId(UUIDGenerator.getUUID());
		appCrd.setStatusCd("01");
		appCrd.setHappenType("04");
		appCrd.setBizId(null);//appCrd.unset("bizId");  不知道是不是这个意思 要确定一下
		appCrd.setCsmCrdLevel(CsmUtil.getCreditLevel(appCrd.getPartyId(), null));
		appCrd.setOldCrdId(oldCrd.getCrdId());
//		appCrd.setCreateTime(GitUtil.getCurrDate());
		appCrd.setApplyDate(GitUtil.getBusiDate());
		appCrd.setUserNum(GitUtil.getCurrentUserId());
		appCrd.setOrgNum(GitUtil.getCurrentOrgCd());

		crdDaoUtilMapper.insertCrd(appCrd);
		appCrd.setBizId(oldCrd.getBizId());//插入过后放进bizId是什么意思
		return appCrd;
	}

	protected Object createBiz04(TbCrdApply crd, Map<String, Object> dataMap) {
		ApplyDaoParam param = getDaoParam();
		param.setPhase("biz");
		param.setCode("0204");
		Object biz = ApplyDaoUtils.getApplyDao(param).create(dataMap);
		// 在crd中缓存bizid方便后续处理
//		DataObject temp = DataObjectUtil.createDataObject(CrdTableName.TB_CRD_APPLY);
//		temp.set("crdId", crd.getString("crdId"));
//		temp.set("bizId", biz.get("applyId"));
//		DatabaseUtil.updateEntity(DBUtil.DB_NAME_DEF, temp);
		
		crd.setBizId(((TbBizApply)biz).getApplyId());
		crdDaoUtilMapper.updateCrdApp(crd);//可否和前序的insert合并一块插入？待测试
		return biz;
	}

	@Override
	protected TbCrdDetailApply saveDetailValid(Map<String, Object> dataMap) {
		TbCrdDetailApply crdDtl = super.saveDetailValid(dataMap);
		if (crdDtl != null && !crdDtl.getCreditMode().equals(dataMap.get("creditMode"))) {
			throw new RuntimeException("调整时不允许变动[授信模式]");
		}
		return crdDtl;
	}

	protected Map<String, String> createCrdDtl(TbCrdApply appCrd) {
//		DataObject[] datas = EntityUtil.searchEntitysByTemplate(CrdTableName.TB_CRD_DETAIL_APPROVE, "crdId", appCrd.getString("oldCrdId"));
		
//		TbCrdDetailApprove detailApprove=new TbCrdDetailApprove();
//		detailApprove.setCrdId(appCrd.getOldCrdId());
		List<TbCrdDetailApprove> approve=creditLimitMapper.getCrdApprove(appCrd.getOldCrdId());
		Map<String, String> map = new HashMap<String, String>();
		if(null != approve && approve.size() > 0){
			for(int i=0;i<approve.size();++i){
				TbCrdDetailApply crdD=new TbCrdDetailApply();
				crdD.setCrdId(approve.get(i).getCrdId());
				crdD.setOldCrdDtlId(approve.get(i).getCrdDtlId());
				TbCrdDetailApply appDtl=new TbCrdDetailApply();
				BeanUtil.copyBeanProperties(approve.get(i), appDtl);//暂定理解为从原对象拷贝属性
				appDtl.setCrdId(appCrd.getCrdId());
				appDtl.setOldCrdDtlId(appDtl.getCrdDtlId());
				appDtl.setCrdDtlId(UUIDGenerator.getUUID());//appDtl.unset("crdDtlId");
				appDtl.setBoUse(appDtl.getRmbAmt().subtract(appDtl.getBoUse()));
				creditLimitMapper.insertCrdAppDtl(appDtl);
				map.put("crdDtlId", appDtl.getCrdDtlId());//map.put(oldDtl.getString("crdDtlId"), appDtl.getString("crdDtlId"));
			}
		}
		return map;
	}

	protected void createCrdOther(TbCrdApply crdApp) {
		// 监管报送
		saveTbBizYesornoApply(crdApp);
	}

	protected void saveTbBizYesornoApply(TbCrdApply crdApp) {
//		Object yesOrNo = EntityUtil.searchEntityByTemplate(BizTableName.TB_BIZ_YESORNO_APPLY, "applyId", crdApp.getOldCrdId());
		TbBizYesornoApply yesOrNo=new TbBizYesornoApply();
		yesOrNo.setApplyId(crdApp.getOldCrdId());
		if (yesOrNo == null) {
			return;
		}
		yesOrNo.setYesornoId(null);
		yesOrNo.setApplyId(crdApp.getCrdId());
		businessMapper.insertYesorno(yesOrNo);	
	}
}
