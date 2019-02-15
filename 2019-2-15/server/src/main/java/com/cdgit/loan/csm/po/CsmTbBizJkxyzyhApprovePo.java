package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbBizJkxyzyhApprovePo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String jyq;

    private BigDecimal dkll;

    private String yfh;

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

    public BigDecimal getDkll() {
        return dkll;
    }

    public void setDkll(BigDecimal dkll) {
        this.dkll = dkll;
    }

    public String getYfh() {
        return yfh;
    }

    public void setYfh(String yfh) {
        this.yfh = yfh == null ? null : yfh.trim();
    }

    public String getYqts() {
        return yqts;
    }

    public void setYqts(String yqts) {
        this.yqts = yqts == null ? null : yqts.trim();
    }
}