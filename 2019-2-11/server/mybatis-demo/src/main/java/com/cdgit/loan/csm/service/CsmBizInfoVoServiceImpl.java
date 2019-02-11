/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.CsmBizInfoBaseVo;
import com.cdgit.loan.csm.bean.CsmBizMainVo;
import com.cdgit.loan.csm.bean.CsmPartyBasisVo;
import com.cdgit.loan.csm.bean.CsmTbBizApprove;
import com.cdgit.loan.csm.mapper.CsmBizInfoVoMapper;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class CsmBizInfoVoServiceImpl {
	
	@Autowired
	CsmBizInfoVoMapper csmBizInfoVoMapper;

	
	//查询相对应的业务详情页面
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public  CsmBizInfoBaseVo getBizInfo(Map map) {
		String approveId=(String) map.get("approveId");
		CsmBizInfoBaseVo csmBizInfoVo=new CsmBizInfoBaseVo();
		//调用相应的业务逻辑
		
		CsmTbBizApprove  csmTbBizApprove=csmBizInfoVoMapper.getBizApproveBasic(approveId);

		CsmBizMainVo csmBizMainVo = csmBizInfoVoMapper.getBizMain(approveId);
		
		String partyId=csmTbBizApprove.getPartyId();
		CsmPartyBasisVo csmPartyBasisVo =csmBizInfoVoMapper.getPartyBasis(partyId);

		
		csmBizInfoVo.setApproveId(csmTbBizApprove.getApproveId());
		csmBizInfoVo.setPartyNum(csmPartyBasisVo.getPartyNum());
		csmBizInfoVo.setPartyName(csmPartyBasisVo.getPartyName());
		csmBizInfoVo.setCertType(csmPartyBasisVo.getCertType());
		csmBizInfoVo.setCertNum(csmPartyBasisVo.getCertNum());
		csmBizInfoVo.setCsmCrdLevel(csmTbBizApprove.getCsmCrdLevel());
		
		csmBizInfoVo.setProductType(csmTbBizApprove.getProductType());
		csmBizInfoVo.setBizHappenType(csmTbBizApprove.getBizHappenType());
		csmBizInfoVo.setBizNum(csmTbBizApprove.getBizNum());
		csmBizInfoVo.setRmbAmt(csmTbBizApprove.getRmbAmt());
		csmBizInfoVo.setTermNum(csmTbBizApprove.getTermNum());
		csmBizInfoVo.setTermUnit(csmTbBizApprove.getTermUnit());
		
		csmBizInfoVo.setGuarantyType(csmTbBizApprove.getGuarantyType());
		csmBizInfoVo.setIsBankTeamLoan(csmTbBizApprove.getIsBankTeamLoan());
		csmBizInfoVo.setBecomeEffectiveMark(csmTbBizApprove.getBecomeEffectiveMark());
		csmBizInfoVo.setBusiPartner(csmTbBizApprove.getBusiPartner());
		csmBizInfoVo.setWhetherBzxzfdk(csmTbBizApprove.getWhetherBzxzfdk());
		csmBizInfoVo.setLowRiskBizType(csmTbBizApprove.getLowRiskBizType());
		csmBizInfoVo.setOrgNum(csmTbBizApprove.getOrgNum());
		csmBizInfoVo.setUserNum(csmTbBizApprove.getUserNum());
		csmBizInfoVo.setApplyDate(csmTbBizApprove.getApplyDate());
		
		csmBizInfoVo.setApplyId(csmTbBizApprove.getApplyId());
		csmBizInfoVo.setAmountId(csmBizMainVo.getAmountId());
		
		
		
		
		
		csmBizInfoVo.setCsmBizMainVo(csmBizMainVo);
		csmBizInfoVo.setCsmTbBizApprove(csmTbBizApprove);
		csmBizInfoVo.setCsmPartyBasisVo(csmPartyBasisVo);
		
		
		return  csmBizInfoVo;

	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CsmPartyBasisVo getPartyBasis(String partyId){
		CsmPartyBasisVo CsmPartyBasisVoQuery = csmBizInfoVoMapper.getPartyBasis(partyId);
    	return CsmPartyBasisVoQuery;
	}
	


}
