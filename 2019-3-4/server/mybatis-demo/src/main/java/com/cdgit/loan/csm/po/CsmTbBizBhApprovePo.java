package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbBizBhApprovePo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String bhzl;

    private BigDecimal bzjblbdy;

    private String syr;

    private String syrfddz;

    private String sfbz;

    private BigDecimal dkll;

    private Date klrq;

    private Date dqrq;

    private String bzjzh;

    private String myhth;

    private BigDecimal myhtje;

    private BigDecimal bzjje;

    private String bzjbz;

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

    public String getBhzl() {
        return bhzl;
    }

    public void setBhzl(String bhzl) {
        this.bhzl = bhzl == null ? null : bhzl.trim();
    }

    public BigDecimal getBzjblbdy() {
        return bzjblbdy;
    }

    public void setBzjblbdy(BigDecimal bzjblbdy) {
        this.bzjblbdy = bzjblbdy;
    }

    public String getSyr() {
        return syr;
    }

    public void setSyr(String syr) {
        this.syr = syr == null ? null : syr.trim();
    }

    public String getSyrfddz() {
        return syrfddz;
    }

    public void setSyrfddz(String syrfddz) {
        this.syrfddz = syrfddz == null ? null : syrfddz.trim();
    }

    public String getSfbz() {
        return sfbz;
    }

    public void setSfbz(String sfbz) {
        this.sfbz = sfbz == null ? null : sfbz.trim();
    }

    public BigDecimal getDkll() {
        return dkll;
    }

    public void setDkll(BigDecimal dkll) {
        this.dkll = dkll;
    }

    public Date getKlrq() {
        return klrq;
    }

    public void setKlrq(Date klrq) {
        this.klrq = klrq;
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
}