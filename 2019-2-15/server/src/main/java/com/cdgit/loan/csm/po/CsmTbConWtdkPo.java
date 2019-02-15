package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbConWtdkPo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String wtr;

    private String wtrlx;

    private String wtdkxz;

    private String contractId;

    private String dkyt;

    private String dkzl;

    private String dkxm;

    private String dzywjqzbgf;

    private String wtxmId;

    private String sxfPayWay;

    private String qtfPayWay;

    private String dbSxWay;

    private String dkPayWay;

    private BigDecimal disYtFx;

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

    public String getWtr() {
        return wtr;
    }

    public void setWtr(String wtr) {
        this.wtr = wtr == null ? null : wtr.trim();
    }

    public String getWtrlx() {
        return wtrlx;
    }

    public void setWtrlx(String wtrlx) {
        this.wtrlx = wtrlx == null ? null : wtrlx.trim();
    }

    public String getWtdkxz() {
        return wtdkxz;
    }

    public void setWtdkxz(String wtdkxz) {
        this.wtdkxz = wtdkxz == null ? null : wtdkxz.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getDkyt() {
        return dkyt;
    }

    public void setDkyt(String dkyt) {
        this.dkyt = dkyt == null ? null : dkyt.trim();
    }

    public String getDkzl() {
        return dkzl;
    }

    public void setDkzl(String dkzl) {
        this.dkzl = dkzl == null ? null : dkzl.trim();
    }

    public String getDkxm() {
        return dkxm;
    }

    public void setDkxm(String dkxm) {
        this.dkxm = dkxm == null ? null : dkxm.trim();
    }

    public String getDzywjqzbgf() {
        return dzywjqzbgf;
    }

    public void setDzywjqzbgf(String dzywjqzbgf) {
        this.dzywjqzbgf = dzywjqzbgf == null ? null : dzywjqzbgf.trim();
    }

    public String getWtxmId() {
        return wtxmId;
    }

    public void setWtxmId(String wtxmId) {
        this.wtxmId = wtxmId == null ? null : wtxmId.trim();
    }

    public String getSxfPayWay() {
        return sxfPayWay;
    }

    public void setSxfPayWay(String sxfPayWay) {
        this.sxfPayWay = sxfPayWay == null ? null : sxfPayWay.trim();
    }

    public String getQtfPayWay() {
        return qtfPayWay;
    }

    public void setQtfPayWay(String qtfPayWay) {
        this.qtfPayWay = qtfPayWay == null ? null : qtfPayWay.trim();
    }

    public String getDbSxWay() {
        return dbSxWay;
    }

    public void setDbSxWay(String dbSxWay) {
        this.dbSxWay = dbSxWay == null ? null : dbSxWay.trim();
    }

    public String getDkPayWay() {
        return dkPayWay;
    }

    public void setDkPayWay(String dkPayWay) {
        this.dkPayWay = dkPayWay == null ? null : dkPayWay.trim();
    }

    public BigDecimal getDisYtFx() {
        return disYtFx;
    }

    public void setDisYtFx(BigDecimal disYtFx) {
        this.disYtFx = disYtFx;
    }
}