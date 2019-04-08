package com.cdgit.loan.business.mapper;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.business.bean.TbBizAmountApply;
import com.cdgit.loan.business.bean.TbBizAmountApprove;
import com.cdgit.loan.business.bean.TbBizAmountDetailApply;
import com.cdgit.loan.business.bean.TbBizApply;
import com.cdgit.loan.business.bean.TbBizApplyLocking;
import com.cdgit.loan.business.bean.TbBizApprove;
import com.cdgit.loan.business.bean.TbBizYesornoApply;
import com.cdgit.loan.creditLimit.bean.TbCrdDetailApprove;


@Mapper
public interface BusinessMapper {

	int insertTbBizApply(TbBizApply record);
	
	int insertAmountApply(TbBizAmountApply record);
	
	int insertAmountDetailApply(TbBizAmountDetailApply record);
	
	Object[] getBizDtlInfos(String applyId);//
	
	void updateBizByMap(Map map);//直接根据map传递参数 applyId 更新
	
	void updateBiz(TbBizApply record);
	
	void updateBizA(Map map);//更新 Tb_Biz_Amount_Apply
	
	void insertLocking(TbBizApplyLocking locking);
	
	void insertYesorno(TbBizYesornoApply record);
	
	TbCrdDetailApprove selectCrdDtlApp(String crdDtlId);
	
	TbBizApply selectBizApp(String bizId);
	
	TbBizApprove selectBizApprove(String approveId);
	
	TbBizAmountApprove selectBizAmountApprove(String approveId);
}
