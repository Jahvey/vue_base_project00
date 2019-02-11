/**
 * 
 */
package com.cdgit.loan.csm.bean;

import com.cdgit.loan.csm.po.TbConContractInfoPo;

/**
 * @author Administrator
 *
 */
//主合同调整 update方法
//com.bos.conApply.conApply.tzContractInfo.biz.ext
public class CsmTzContractInfoVo {
	
	private String contractId;
	
	private String bizType;
	
	//返回值
	private String  processInstId;
	
	private String msg;
	
	private CsmConCreditInfo conInfo1;
	
	private TbConContractInfoPo conInfo2;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getProcessInstId() {
		return processInstId;
	}

	public void setProcessInstId(String processInstId) {
		this.processInstId = processInstId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public CsmConCreditInfo getConInfo1() {
		return conInfo1;
	}

	public void setConInfo1(CsmConCreditInfo conInfo1) {
		this.conInfo1 = conInfo1;
	}

	public TbConContractInfoPo getConInfo2() {
		return conInfo2;
	}

	public void setConInfo2(TbConContractInfoPo conInfo2) {
		this.conInfo2 = conInfo2;
	}
	
	
	
	

}
