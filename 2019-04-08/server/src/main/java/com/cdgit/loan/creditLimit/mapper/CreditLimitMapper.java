package com.cdgit.loan.creditLimit.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.creditLimit.bean.TbBizAbate;
import com.cdgit.loan.creditLimit.bean.TbBizCreditLineMeasure;
import com.cdgit.loan.creditLimit.bean.TbConGuarantOrgInfo;
import com.cdgit.loan.creditLimit.bean.TbCrdApprove;
import com.cdgit.loan.creditLimit.bean.TbCrdDetailApply;
import com.cdgit.loan.creditLimit.bean.TbCrdDetailApprove;
import com.cdgit.loan.creditLimit.bean.TbCrdFreeze;
import com.cdgit.loan.creditLimit.bean.TbCrdThirdPartyLimit;


/**
 * 

* <p>Title: CreditLimitMapper</p>  

* <p>Description: </p>  

* @author xujianming  

* @date 2019年2月20日
 */
@Mapper
public interface CreditLimitMapper {

	List queryThirdHis_protocol(Map map);
	List queryThirdHis_corp(Map map);
	
	int RCRD_0013(Map map);
	
	int RCONDB_0003(Map map);
	
//	int insert(TbCrdThirdPartyLimit record);
	
	int insertSelective(TbCrdThirdPartyLimit record);
	
	TbCrdThirdPartyLimit selectByPrimaryKey(String limitId);
	
	int insertAdjustThirdLimit(Map map);//测试直接查询插入
	
	void insertNewZh(Map map);//原来的limit_id 新 limit_id
	
	void insertCrdProRel(Map map);//
	
	TbCrdThirdPartyLimit getThirdPartyCrdByLimitId(Map map);
	
	int insertGuarant(TbConGuarantOrgInfo record);

	void insertconZh(TbConGuarantOrgInfo record);
	
//    int insertSelective(TbConGuarantOrgInfo record);
	
	String getGrtCreditLevel(String partyId);
	
	String[] getBizIds(String partyId);//根据partyId查询业务批复信息
	
	String[] getPartyCreditLevel(Map map);//
	
	void insertUnfrzDtl(Map map);//
	
	void insertFrzDtl(Map map);//
	
	void deleteFrzByPrimaryKey(String frzId);
	
	void deleteFrzDtlByPrimaryKey(Map map);//
	
	void removeFrzDtl(String frzId);//
	
	TbCrdApprove selectCrdApproveByPrimaryKey(String crdId);
	
	void insertFrz(TbCrdFreeze frz);
	
	List getCrdApprove(String crdId);//获取额度明细批复列表
	
	void insertCrdAppDtl(TbCrdDetailApply apply);
	
	TbCrdFreeze selectCrdFrzByPrimaryKey(String frzId);
	
	void updateCrdFrz(TbCrdFreeze frz);
	
	Map getCrdDtlList(Map map);
	
	String getIsSXcrd(Map map);
	
	String getIsSXProcess(Map map);
	
	Object[] getBizIdAndHaveDtl(Map map);//Map getBizIdAndHaveDtl(Map map)
	
	Object[] getCreditLineLimit(Map map);//
	
	TbBizCreditLineMeasure selectMeasureByPrimaryKey(String id);
	
	void insertAbate(TbBizAbate abate);
	
	void insertAbateDtl(Map map);//移植以前失效方法
	
	TbBizAbate selectAbate(String abateId);
	
	void updateAbate(TbBizAbate abate);
	
	void deleteAbateDtl(String abateId);
	
	void deleteAbateDtlByMap(Map map);
	
	void deleteAbate(String abateId);
	
	void deleteCrdDtl(String crdDtlId);
	
	void updateCrdDtlApply(TbCrdDetailApply crdDtlApply);
	
	
	
	Object[] getCrdDtlCredit(String crdDtlId);
	
	Object[] getBizDtlIdsByCrdDtlId(String crdDtlId);
	
	Object[] getFreezeAmt(String crdDtlId);
	
	Object[] getConOccupyToCrd(Map map);
	
	void updateCrdDtlApprove(TbCrdDetailApprove crdDtlApprove);
	
	void updateCrdCredit(String crdId);
	
	Object[] getCrdCredit(String crdId);
	
	Object[] getCrdDtlIds(String crdId);
	
	Object[] getBizIdsByCrdId(String crdId);//原来里面的getBizIds
	
}
