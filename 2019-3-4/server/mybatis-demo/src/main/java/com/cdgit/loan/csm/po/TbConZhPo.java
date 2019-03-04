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
	
	private String zhkhjg;
	
	private String zhmc;
	
	private String contractId;
	
	private String accStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getZhbs() {
        return zhbs;
    }

    public void setZhbs(String zhbs) {
        this.zhbs = zhbs == null ? null : zhbs.trim();
    }

    public String getZhlx() {
        return zhlx;
    }

    public void setZhlx(String zhlx) {
        this.zhlx = zhlx == null ? null : zhlx.trim();
    }

    public String getKzbs() {
        return kzbs;
    }

    public void setKzbs(String kzbs) {
        this.kzbs = kzbs == null ? null : kzbs.trim();
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh == null ? null : zh.trim();
    }

    public String getZhkhjg() {
        return zhkhjg;
    }

    public void setZhkhjg(String zhkhjg) {
        this.zhkhjg = zhkhjg == null ? null : zhkhjg.trim();
    }

    public String getZhmc() {
        return zhmc;
    }

    public void setZhmc(String zhmc) {
        this.zhmc = zhmc == null ? null : zhmc.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(String accStatus) {
        this.accStatus = accStatus == null ? null : accStatus.trim();
    }

	@Override
	public String toString() {
		return "TbConZhPo [id=" + id + ", zhbs=" + zhbs + ", zhlx=" + zhlx + ", kzbs=" + kzbs + ", zh=" + zh
				+ ", zhkhjg=" + zhkhjg + ", zhmc=" + zhmc + ", contractId=" + contractId + ", accStatus=" + accStatus
				+ "]";
	}
    
    
}
