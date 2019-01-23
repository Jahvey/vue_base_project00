/**
 * 
 */
package com.cdgit.loan.csm.po;

/**
 * @author Administrator
 *
 */
//账户信息
public class TbConZhPo {//TB_CON_ZH
	private String id;
	
	private String zhbs;
	
	private String zhlx;
	
	private String kzbs;
	
	private String zh;
	
	private String zhkhjq;
	
	private String zhmc;
	
	private String contractId;
	
	private String accStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZhbs() {
		return zhbs;
	}

	public void setZhbs(String zhbs) {
		this.zhbs = zhbs;
	}

	public String getZhlx() {
		return zhlx;
	}

	public void setZhlx(String zhlx) {
		this.zhlx = zhlx;
	}

	public String getKzbs() {
		return kzbs;
	}

	public void setKzbs(String kzbs) {
		this.kzbs = kzbs;
	}

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	public String getZhkhjq() {
		return zhkhjq;
	}

	public void setZhkhjq(String zhkhjq) {
		this.zhkhjq = zhkhjq;
	}

	public String getZhmc() {
		return zhmc;
	}

	public void setZhmc(String zhmc) {
		this.zhmc = zhmc;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	@Override
	public String toString() {
		return "CsmTbConZh [id=" + id + ", zhbs=" + zhbs + ", zhlx=" + zhlx + ", kzbs=" + kzbs + ", zh=" + zh
				+ ", zhkhjq=" + zhkhjq + ", zhmc=" + zhmc + ", contractId=" + contractId + ", accStatus=" + accStatus
				+ "]";
	}

	
	
	
	
	

}
