package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbConKlyhcdhpPo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private BigDecimal bzjblbdy;

    private BigDecimal sfbz;

    private String contractId;

    private String cdrqc;

    private BigDecimal bzjbl;

    private BigDecimal bzjje;

    private Integer tgfpdclqx;

    private BigDecimal dkll;

    private Integer hpzs;

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

    public BigDecimal getBzjblbdy() {
        return bzjblbdy;
    }

    public void setBzjblbdy(BigDecimal bzjblbdy) {
        this.bzjblbdy = bzjblbdy;
    }

    public BigDecimal getSfbz() {
        return sfbz;
    }

    public void setSfbz(BigDecimal sfbz) {
        this.sfbz = sfbz;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getCdrqc() {
        return cdrqc;
    }

    public void setCdrqc(String cdrqc) {
        this.cdrqc = cdrqc == null ? null : cdrqc.trim();
    }

    public BigDecimal getBzjbl() {
        return bzjbl;
    }

    public void setBzjbl(BigDecimal bzjbl) {
        this.bzjbl = bzjbl;
    }

    public BigDecimal getBzjje() {
        return bzjje;
    }

    public void setBzjje(BigDecimal bzjje) {
        this.bzjje = bzjje;
    }

    public Integer getTgfpdclqx() {
        return tgfpdclqx;
    }

    public void setTgfpdclqx(Integer tgfpdclqx) {
        this.tgfpdclqx = tgfpdclqx;
    }

    public BigDecimal getDkll() {
        return dkll;
    }

    public void setDkll(BigDecimal dkll) {
        this.dkll = dkll;
    }

    public Integer getHpzs() {
        return hpzs;
    }

    public void setHpzs(Integer hpzs) {
        this.hpzs = hpzs;
    }
}