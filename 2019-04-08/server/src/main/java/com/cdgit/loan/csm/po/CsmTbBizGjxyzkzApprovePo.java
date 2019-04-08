package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbBizGjxyzkzApprovePo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String jyq;

    private String yqts;

    private Date dqrq;

    private BigDecimal yzbl;

    private BigDecimal dzbl;

    private String bzjzh;

    private BigDecimal bzjje;

    private String bzjbz;

    private BigDecimal bzjblbdy;

    private String myhth;

    private BigDecimal myhtje;

    private String gngjz;

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

    public String getYqts() {
        return yqts;
    }

    public void setYqts(String yqts) {
        this.yqts = yqts == null ? null : yqts.trim();
    }

    public Date getDqrq() {
        return dqrq;
    }

    public void setDqrq(Date dqrq) {
        this.dqrq = dqrq;
    }

    public BigDecimal getYzbl() {
        return yzbl;
    }

    public void setYzbl(BigDecimal yzbl) {
        this.yzbl = yzbl;
    }

    public BigDecimal getDzbl() {
        return dzbl;
    }

    public void setDzbl(BigDecimal dzbl) {
        this.dzbl = dzbl;
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

    public String getMyhth() {
        return myhth;
    }

    public void setMyhth(String myhth) {
        this.myhth = myhth == null ? null : myhth.trim();
    }

    public BigDecimal getMyhtje() {
        return myhtje;
    }

    public void setMyhtje(BigDecimal myhtje) {
        this.myhtje = myhtje;
    }

    public String getGngjz() {
        return gngjz;
    }

    public void setGngjz(String gngjz) {
        this.gngjz = gngjz == null ? null : gngjz.trim();
    }

    public BigDecimal getDkll() {
        return dkll;
    }

    public void setDkll(BigDecimal dkll) {
        this.dkll = dkll;
    }
}