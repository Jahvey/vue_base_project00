package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbConCkxyzyhPo {
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String jyq;

    private String contractId;

    private String czzh;

    private String ywhm;

    private String xyzhm;

    private String yhtxbz;

    private String yfh;

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

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getCzzh() {
        return czzh;
    }

    public void setCzzh(String czzh) {
        this.czzh = czzh == null ? null : czzh.trim();
    }

    public String getYwhm() {
        return ywhm;
    }

    public void setYwhm(String ywhm) {
        this.ywhm = ywhm == null ? null : ywhm.trim();
    }

    public String getXyzhm() {
        return xyzhm;
    }

    public void setXyzhm(String xyzhm) {
        this.xyzhm = xyzhm == null ? null : xyzhm.trim();
    }

    public String getYhtxbz() {
        return yhtxbz;
    }

    public void setYhtxbz(String yhtxbz) {
        this.yhtxbz = yhtxbz == null ? null : yhtxbz.trim();
    }

    public String getYfh() {
        return yfh;
    }

    public void setYfh(String yfh) {
        this.yfh = yfh == null ? null : yfh.trim();
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
}