package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbConMyhtxxPo {
    private String htId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String htbh;

    private String htgf;

    private String htxf;

    private Date htqdrq;

    private Date htdqrq;

    private BigDecimal htzje;

    private String currencyCd;

    private String bz;

    private String contractId;

    public String getHtId() {
        return htId;
    }

    public void setHtId(String htId) {
        this.htId = htId == null ? null : htId.trim();
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

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh == null ? null : htbh.trim();
    }

    public String getHtgf() {
        return htgf;
    }

    public void setHtgf(String htgf) {
        this.htgf = htgf == null ? null : htgf.trim();
    }

    public String getHtxf() {
        return htxf;
    }

    public void setHtxf(String htxf) {
        this.htxf = htxf == null ? null : htxf.trim();
    }

    public Date getHtqdrq() {
        return htqdrq;
    }

    public void setHtqdrq(Date htqdrq) {
        this.htqdrq = htqdrq;
    }

    public Date getHtdqrq() {
        return htdqrq;
    }

    public void setHtdqrq(Date htdqrq) {
        this.htdqrq = htdqrq;
    }

    public BigDecimal getHtzje() {
        return htzje;
    }

    public void setHtzje(BigDecimal htzje) {
        this.htzje = htzje;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }
}