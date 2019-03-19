/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.ApproveAndSxxyVo;
import com.cdgit.loan.csm.bean.ApproveConsVo;
import com.cdgit.loan.csm.po.CsmTbConRepayPlanPo;

/**
 * @author cwalk
 * @createTime 2018年12月11日
 * mybatis-demo
 * com.cdgit.loan.csm.mapper
 * conApplyMapper.java
 */
@Mapper
public interface ConApplyMapper {
	
	//使用requestParam方式请求
	List<ApproveConsVo> getApproveCons(Map map);
	
	//
	List<ApproveConsVo> getPrintCons(Map map);
	
	//使用了实体类的方式请求
	List<ApproveConsVo> getApproveCons1(Map map);
	
	//
	String queryJxhjOldConId(String applyId);
	
	//查询老合同编号信息
	String getJxhjContractNum(String applyId);
	
	
	List<ApproveAndSxxyVo> getApproveAndSxxy(Map map);

	//根据合同id查询 业务性质
	HashMap<String, Object>  getConInfoBizType(String contractId);
	
	//合同失效处理更新主合同信息
	int updateConInfoStatus(String contractId);

	//合同失效处理额度重新计算
	int updateCreditLimit(String partyId);
	
	//合同失效处理更新从合同信息
	int updateConInfoRelStatus(String contractId);
	
	//合同失效处理非综合授信批复失效
	int updateCancelPF(String amountDetailId);
	
	
	List<BigDecimal> getJxhjAmt(String contractId);
	
	
	//根据contranctId查询该合同的业务发生方式
	List<HashMap<String, Object>> getBizHappenTypeByContractId(String contractId);
	
	
	List<CsmTbConRepayPlanPo> getHkjhsByConId(String contractId);
	
}
