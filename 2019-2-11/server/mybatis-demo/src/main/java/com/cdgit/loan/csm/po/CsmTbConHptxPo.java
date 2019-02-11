package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbConHptxPo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String txzjyt;

    private String hpzl;

    private String sfxyfx;

    private BigDecimal mfcnblBuy;

    private BigDecimal mfcnblSell;

    private Integer hpzs;

    private String contractId;

    private BigDecimal txyll;

    private String productType;

    private String hpbh;

    private Date txqq;

    private BigDecimal dkll;

    private String currencyCd;

    private BigDecimal hpTotalAmt;

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

    public String getTxzjyt() {
        return txzjyt;
    }

    public void setTxzjyt(String txzjyt) {
        this.txzjyt = txzjyt == null ? null : txzjyt.trim();
    }

    public String getHpzl() {
        return hpzl;
    }

    public void setHpzl(String hpzl) {
        this.hpzl = hpzl == null ? null : hpzl.trim();
    }

    public String getSfxyfx() {
        return sfxyfx;
    }

    public void setSfxyfx(String sfxyfx) {
        this.sfxyfx = sfxyfx == null ? null : sfxyfx.trim();
    }

    public BigDecimal getMfcnblBuy() {
        return mfcnblBuy;
    }

    public void setMfcnblBuy(BigDecimal mfcnblBuy) {
        this.mfcnblBuy = mfcnblBuy;
    }

    public BigDecimal getMfcnblSell() {
        return mfcnblSell;
    }

    public void setMfcnblSell(BigDecimal mfcnblSell) {
        this.mfcnblSell = mfcnblSell;
    }

    public Integer getHpzs() {
        return hpzs;
    }

    public void setHpzs(Integer hpzs) {
        this.hpzs = hpzs;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public BigDecimal getTxyll() {
        return txyll;
    }

    public void setTxyll(BigDecimal txyll) {
        this.txyll = txyll;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getHpbh() {
        return hpbh;
    }

    public void setHpbh(String hpbh) {
        this.hpbh = hpbh == null ? null : hpbh.trim();
    }

    public Date getTxqq() {
        return txqq;
    }

    public void setTxqq(Date txqq) {
        this.txqq = txqq;
    }

    public BigDecimal getDkll() {
        return dkll;
    }

    public void setDkll(BigDecimal dkll) {
        this.dkll = dkll;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getHpTotalAmt() {
        return hpTotalAmt;
    }

    public void setHpTotalAmt(BigDecimal hpTotalAmt) {
        this.hpTotalAmt = hpTotalAmt;
    }
}