package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbBizPjxxApplyPo {
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String cprqc;

    private String cprzh;

    private String skrqc;

    private String skrzh;

    private String skrkhh;

    private String pjhm;

    private String currencyCd;

    private BigDecimal hpje;

    private String hpxs;

    private Date hpcprq;

    private Date hpdqrq;

    private String dfdz;

    private String htbh;

    private String jlzt;

    private String remitterbankname;

    private String remitterbankno;

    private String payeebankname;

    private String payeebankno;

    private String acceptorbankname;

    private String acceptorbankno;

    private String billid;

    private String forbidflag;

    private String contractId;

    private BigDecimal sortOrder;

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

    public String getCprqc() {
        return cprqc;
    }

    public void setCprqc(String cprqc) {
        this.cprqc = cprqc == null ? null : cprqc.trim();
    }

    public String getCprzh() {
        return cprzh;
    }

    public void setCprzh(String cprzh) {
        this.cprzh = cprzh == null ? null : cprzh.trim();
    }

    public String getSkrqc() {
        return skrqc;
    }

    public void setSkrqc(String skrqc) {
        this.skrqc = skrqc == null ? null : skrqc.trim();
    }

    public String getSkrzh() {
        return skrzh;
    }

    public void setSkrzh(String skrzh) {
        this.skrzh = skrzh == null ? null : skrzh.trim();
    }

    public String getSkrkhh() {
        return skrkhh;
    }

    public void setSkrkhh(String skrkhh) {
        this.skrkhh = skrkhh == null ? null : skrkhh.trim();
    }

    public String getPjhm() {
        return pjhm;
    }

    public void setPjhm(String pjhm) {
        this.pjhm = pjhm == null ? null : pjhm.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getHpje() {
        return hpje;
    }

    public void setHpje(BigDecimal hpje) {
        this.hpje = hpje;
    }

    public String getHpxs() {
        return hpxs;
    }

    public void setHpxs(String hpxs) {
        this.hpxs = hpxs == null ? null : hpxs.trim();
    }

    public Date getHpcprq() {
        return hpcprq;
    }

    public void setHpcprq(Date hpcprq) {
        this.hpcprq = hpcprq;
    }

    public Date getHpdqrq() {
        return hpdqrq;
    }

    public void setHpdqrq(Date hpdqrq) {
        this.hpdqrq = hpdqrq;
    }

    public String getDfdz() {
        return dfdz;
    }

    public void setDfdz(String dfdz) {
        this.dfdz = dfdz == null ? null : dfdz.trim();
    }

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh == null ? null : htbh.trim();
    }

    public String getJlzt() {
        return jlzt;
    }

    public void setJlzt(String jlzt) {
        this.jlzt = jlzt == null ? null : jlzt.trim();
    }

    public String getRemitterbankname() {
        return remitterbankname;
    }

    public void setRemitterbankname(String remitterbankname) {
        this.remitterbankname = remitterbankname == null ? null : remitterbankname.trim();
    }

    public String getRemitterbankno() {
        return remitterbankno;
    }

    public void setRemitterbankno(String remitterbankno) {
        this.remitterbankno = remitterbankno == null ? null : remitterbankno.trim();
    }

    public String getPayeebankname() {
        return payeebankname;
    }

    public void setPayeebankname(String payeebankname) {
        this.payeebankname = payeebankname == null ? null : payeebankname.trim();
    }

    public String getPayeebankno() {
        return payeebankno;
    }

    public void setPayeebankno(String payeebankno) {
        this.payeebankno = payeebankno == null ? null : payeebankno.trim();
    }

    public String getAcceptorbankname() {
        return acceptorbankname;
    }

    public void setAcceptorbankname(String acceptorbankname) {
        this.acceptorbankname = acceptorbankname == null ? null : acceptorbankname.trim();
    }

    public String getAcceptorbankno() {
        return acceptorbankno;
    }

    public void setAcceptorbankno(String acceptorbankno) {
        this.acceptorbankno = acceptorbankno == null ? null : acceptorbankno.trim();
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid == null ? null : billid.trim();
    }

    public String getForbidflag() {
        return forbidflag;
    }

    public void setForbidflag(String forbidflag) {
        this.forbidflag = forbidflag == null ? null : forbidflag.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public BigDecimal getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(BigDecimal sortOrder) {
        this.sortOrder = sortOrder;
    }
}