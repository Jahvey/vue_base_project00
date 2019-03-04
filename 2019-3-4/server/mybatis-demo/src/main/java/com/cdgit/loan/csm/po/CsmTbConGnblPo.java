package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbConGnblPo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String bllx;

    private String sfyzsq;

    private String bltffs;

    private String contractId;

    private String yszkhszhhm;

    private String yszkhszhzh;

    private String sfwbzjzh;

    private Integer gracePeriod;

    private String rzfsqfs;

    private BigDecimal jbsgkbl;

    private BigDecimal kcfy1;

    private BigDecimal kcfy2;

    private BigDecimal zdsxbdje;

    private BigDecimal sgkbl;

    private BigDecimal zjsgcs;

    private BigDecimal dkll;

    public String getApplyDetailId() {
        return applyDetailId;
    }

    public void setApplyDetailId(String applyDetailId) {
        this.applyDetailId = applyDetailId == null ? null : applyDetailId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAmountDetailId() {
        return amountDetailId;
    }

    public void setAmountDetailId(String amountDetailId) {
        this.amountDetailId = amountDetailId == null ? null : amountDetailId.trim();
    }

    public String getBllx() {
        return bllx;
    }

    public void setBllx(String bllx) {
        this.bllx = bllx == null ? null : bllx.trim();
    }

    public String getSfyzsq() {
        return sfyzsq;
    }

    public void setSfyzsq(String sfyzsq) {
        this.sfyzsq = sfyzsq == null ? null : sfyzsq.trim();
    }

    public String getBltffs() {
        return bltffs;
    }

    public void setBltffs(String bltffs) {
        this.bltffs = bltffs == null ? null : bltffs.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getYszkhszhhm() {
        return yszkhszhhm;
    }

    public void setYszkhszhhm(String yszkhszhhm) {
        this.yszkhszhhm = yszkhszhhm == null ? null : yszkhszhhm.trim();
    }

    public String getYszkhszhzh() {
        return yszkhszhzh;
    }

    public void setYszkhszhzh(String yszkhszhzh) {
        this.yszkhszhzh = yszkhszhzh == null ? null : yszkhszhzh.trim();
    }

    public String getSfwbzjzh() {
        return sfwbzjzh;
    }

    public void setSfwbzjzh(String sfwbzjzh) {
        this.sfwbzjzh = sfwbzjzh == null ? null : sfwbzjzh.trim();
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public String getRzfsqfs() {
        return rzfsqfs;
    }

    public void setRzfsqfs(String rzfsqfs) {
        this.rzfsqfs = rzfsqfs == null ? null : rzfsqfs.trim();
    }

    public BigDecimal getJbsgkbl() {
        return jbsgkbl;
    }

    public void setJbsgkbl(BigDecimal jbsgkbl) {
        this.jbsgkbl = jbsgkbl;
    }

    public BigDecimal getKcfy1() {
        return kcfy1;
    }

    public void setKcfy1(BigDecimal kcfy1) {
        this.kcfy1 = kcfy1;
    }

    public BigDecimal getKcfy2() {
        return kcfy2;
    }

    public void setKcfy2(BigDecimal kcfy2) {
        this.kcfy2 = kcfy2;
    }

    public BigDecimal getZdsxbdje() {
        return zdsxbdje;
    }

    public void setZdsxbdje(BigDecimal zdsxbdje) {
        this.zdsxbdje = zdsxbdje;
    }

    public BigDecimal getSgkbl() {
        return sgkbl;
    }

    public void setSgkbl(BigDecimal sgkbl) {
        this.sgkbl = sgkbl;
    }

    public BigDecimal getZjsgcs() {
        return zjsgcs;
    }

    public void setZjsgcs(BigDecimal zjsgcs) {
        this.zjsgcs = zjsgcs;
    }

    public BigDecimal getDkll() {
        return dkll;
    }

    public void setDkll(BigDecimal dkll) {
        this.dkll = dkll;
    }

	@Override
	public String toString() {
		return "CsmTbConGnblPo [applyDetailId=" + applyDetailId + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", amountDetailId=" + amountDetailId + ", bllx=" + bllx + ", sfyzsq=" + sfyzsq
				+ ", bltffs=" + bltffs + ", contractId=" + contractId + ", yszkhszhhm=" + yszkhszhhm + ", yszkhszhzh="
				+ yszkhszhzh + ", sfwbzjzh=" + sfwbzjzh + ", gracePeriod=" + gracePeriod + ", rzfsqfs=" + rzfsqfs
				+ ", jbsgkbl=" + jbsgkbl + ", kcfy1=" + kcfy1 + ", kcfy2=" + kcfy2 + ", zdsxbdje=" + zdsxbdje
				+ ", sgkbl=" + sgkbl + ", zjsgcs=" + zjsgcs + ", dkll=" + dkll + "]";
	}
    
    
}