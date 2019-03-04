package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbConJkttyhPo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String jyq;

    private String contractId;

    private String rzzh;

    private String fph;

    private String ywbh;

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

    public String getJyq() {
        return jyq;
    }

    public void setJyq(String jyq) {
        this.jyq = jyq == null ? null : jyq.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getRzzh() {
        return rzzh;
    }

    public void setRzzh(String rzzh) {
        this.rzzh = rzzh == null ? null : rzzh.trim();
    }

    public String getFph() {
        return fph;
    }

    public void setFph(String fph) {
        this.fph = fph == null ? null : fph.trim();
    }

    public String getYwbh() {
        return ywbh;
    }

    public void setYwbh(String ywbh) {
        this.ywbh = ywbh == null ? null : ywbh.trim();
    }

    public BigDecimal getDkll() {
        return dkll;
    }

    public void setDkll(BigDecimal dkll) {
        this.dkll = dkll;
    }

	@Override
	public String toString() {
		return "CsmTbConJkttyhPo [applyDetailId=" + applyDetailId + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", amountDetailId=" + amountDetailId + ", jyq=" + jyq + ", contractId=" + contractId
				+ ", rzzh=" + rzzh + ", fph=" + fph + ", ywbh=" + ywbh + ", dkll=" + dkll + "]";
	}
    
}