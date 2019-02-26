package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;


public class CsmTbBizThdbApprovePo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String tdhm;

    private String xyzhm;

    private Date tdrq;

    private Date dqrq;

    private String bzjzh;

    private BigDecimal bzjje;

    private String bzjbz;

    private BigDecimal bzjblbdy;

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

    public String getTdhm() {
        return tdhm;
    }

    public void setTdhm(String tdhm) {
        this.tdhm = tdhm == null ? null : tdhm.trim();
    }

    public String getXyzhm() {
        return xyzhm;
    }

    public void setXyzhm(String xyzhm) {
        this.xyzhm = xyzhm == null ? null : xyzhm.trim();
    }

    public Date getTdrq() {
        return tdrq;
    }

    public void setTdrq(Date tdrq) {
        this.tdrq = tdrq;
    }

    public Date getDqrq() {
        return dqrq;
    }

    public void setDqrq(Date dqrq) {
        this.dqrq = dqrq;
    }

    public String getBzjzh() {
        return bzjzh;
    }

    public void setBzjzh(String bzjzh) {
        this.bzjzh = bzjzh == null ? null : bzjzh.trim();
    }

    public BigDecimal getBzjje() {
        return bzjje;
    }

    public void setBzjje(BigDecimal bzjje) {
        this.bzjje = bzjje;
    }

    public String getBzjbz() {
        return bzjbz;
    }

    public void setBzjbz(String bzjbz) {
        this.bzjbz = bzjbz == null ? null : bzjbz.trim();
    }

    public BigDecimal getBzjblbdy() {
        return bzjblbdy;
    }

    public void setBzjblbdy(BigDecimal bzjblbdy) {
        this.bzjblbdy = bzjblbdy;
    }

    public BigDecimal getDkll() {
        return dkll;
    }

    public void setDkll(BigDecimal dkll) {
        this.dkll = dkll;
    }

	@Override
	public String toString() {
		return "CsmTbBizThdbApprovePo [applyDetailId=" + applyDetailId + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", amountDetailId=" + amountDetailId + ", tdhm=" + tdhm + ", xyzhm=" + xyzhm + ", tdrq="
				+ tdrq + ", dqrq=" + dqrq + ", bzjzh=" + bzjzh + ", bzjje=" + bzjje + ", bzjbz=" + bzjbz + ", bzjblbdy="
				+ bzjblbdy + ", dkll=" + dkll + "]";
	}
    
    
}