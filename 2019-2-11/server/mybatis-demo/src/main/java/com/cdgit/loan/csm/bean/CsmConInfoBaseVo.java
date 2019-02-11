/**
 * 
 */
package com.cdgit.loan.csm.bean;

import java.util.HashMap;

import com.cdgit.loan.csm.po.CsmTbCsmPartyPo;
import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;

/**
 * @author cwalk
 *
 */
//com.bos.conInfo.conInfoSxxy.getConInfoByContarctId.biz.ext

public class CsmConInfoBaseVo {
	
	private String contractId;
	
	private TbConContractInfoPo conInfo2;//如果tbConCreditInfo/partyId 为空，则使用这个conInfo
	
	private CsmConCreditInfo conInfo1;
	
	private CsmTbBizApprove tbBizApprove;
	
	private CsmBizAmountApprove tbBizAmountApprove;
	
	private CsmTbCsmPartyPo  party;
	
	private TbBizAmountDetailApprovePo tbBizAmountDetailApprove;
	
	private CsmConFlagInfo conFlagInfo;
	
	
	private String contractType;
	
	private String proFlag1;
	
	private HashMap<String,String> bizInfo;
	
	private HashMap<String, String> bizDtInfo;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public TbConContractInfoPo getConInfo2() {
		return conInfo2;
	}

	public void setConInfo2(TbConContractInfoPo conInfo2) {
		this.conInfo2 = conInfo2;
	}

	public CsmConCreditInfo getConInfo1() {
		return conInfo1;
	}

	public void setConInfo1(CsmConCreditInfo conInfo1) {
		this.conInfo1 = conInfo1;
	}

	public CsmTbBizApprove getTbBizApprove() {
		return tbBizApprove;
	}

	public void setTbBizApprove(CsmTbBizApprove tbBizApprove) {
		this.tbBizApprove = tbBizApprove;
	}

	public CsmBizAmountApprove getTbBizAmountApprove() {
		return tbBizAmountApprove;
	}

	public void setTbBizAmountApprove(CsmBizAmountApprove tbBizAmountApprove) {
		this.tbBizAmountApprove = tbBizAmountApprove;
	}

	

	public CsmTbCsmPartyPo getParty() {
		return party;
	}

	public void setParty(CsmTbCsmPartyPo party) {
		this.party = party;
	}

	public TbBizAmountDetailApprovePo getTbBizAmountDetailApprove() {
		return tbBizAmountDetailApprove;
	}

	public void setTbBizAmountDetailApprove(TbBizAmountDetailApprovePo tbBizAmountDetailApprove) {
		this.tbBizAmountDetailApprove = tbBizAmountDetailApprove;
	}

	public CsmConFlagInfo getConFlagInfo() {
		return conFlagInfo;
	}

	public void setConFlagInfo(CsmConFlagInfo conFlagInfo) {
		this.conFlagInfo = conFlagInfo;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getProFlag1() {
		return proFlag1;
	}

	public void setProFlag1(String proFlag1) {
		this.proFlag1 = proFlag1;
	}

	public HashMap<String, String> getBizInfo() {
		return bizInfo;
	}

	public void setBizInfo(HashMap<String, String> bizInfo) {
		this.bizInfo = bizInfo;
	}

	public HashMap<String, String> getBizDtInfo() {
		return bizDtInfo;
	}

	public void setBizDtInfo(HashMap<String, String> bizDtInfo) {
		this.bizDtInfo = bizDtInfo;
	}
	
	
	
	

}
