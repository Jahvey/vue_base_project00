package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbConJkxyzPo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String jyq;

    private BigDecimal bzjblbdy;

    private String contractId;

    private BigDecimal kzsfbl;

    private BigDecimal kzxfbl;

    private String syrmc;

    private Date xyzyxq;

    private BigDecimal dkll;

    private String yqts;

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

    public String getJyq() {
        return jyq;
    }

    public void setJyq(String jyq) {
        this.jyq = jyq == null ? null : jyq.trim();
    }

    public BigDecimal getBzjblbdy() {
        return bzjblbdy;
    }

    public void setBzjblbdy(BigDecimal bzjblbdy) {
        this.bzjblbdy = bzjblbdy;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public BigDecimal getKzsfbl() {
        return kzsfbl;
    }

    public void setKzsfbl(BigDecimal kzsfbl) {
        this.kzsfbl = kzsfbl;
    }

    public BigDecimal getKzxfbl() {
        return kzxfbl;
    }

    public void setKzxfbl(BigDecimal kzxfbl) {
        this.kzxfbl = kzxfbl;
    }

    public String getSyrmc() {
        return syrmc;
    }

    public void setSyrmc(String syrmc) {
        this.syrmc = syrmc == null ? null : syrmc.trim();
    }

    public Date getXyzyxq() {
        return xyzyxq;
    }

    public void setXyzyxq(Date xyzyxq) {
        this.xyzyxq = xyzyxq;
    }

    public BigDecimal getDkll() {
        return dkll;
    }

    public void setDkll(BigDecimal dkll) {
        this.dkll = dkll;
    }

    public String getYqts() {
        return yqts;
    }

    public void setYqts(String yqts) {
        this.yqts = yqts == null ? null : yqts.trim();
    }

	@Override
	public String toString() {
		return "CsmTbConJkxyzPo [applyDetailId=" + applyDetailId + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", amountDetailId=" + amountDetailId + ", jyq=" + jyq + ", bzjblbdy=" + bzjblbdy
				+ ", contractId=" + contractId + ", kzsfbl=" + kzsfbl + ", kzxfbl=" + kzxfbl + ", syrmc=" + syrmc
				+ ", xyzyxq=" + xyzyxq + ", dkll=" + dkll + ", yqts=" + yqts + "]";
	}
    
    
}