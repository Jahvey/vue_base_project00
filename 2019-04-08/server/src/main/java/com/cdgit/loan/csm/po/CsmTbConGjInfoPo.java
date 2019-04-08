package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbConGjInfoPo {
    private String contractId;

    private Date createTime;

    private Date updateTime;

    private String ywbh;

    private String loanCur;

    private BigDecimal loanAmt;

    private String loanDay;

    private String knotMsg;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
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

    public String getYwbh() {
        return ywbh;
    }

    public void setYwbh(String ywbh) {
        this.ywbh = ywbh == null ? null : ywbh.trim();
    }

    public String getLoanCur() {
        return loanCur;
    }

    public void setLoanCur(String loanCur) {
        this.loanCur = loanCur == null ? null : loanCur.trim();
    }

    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(BigDecimal loanAmt) {
        this.loanAmt = loanAmt;
    }

    public String getLoanDay() {
        return loanDay;
    }

    public void setLoanDay(String loanDay) {
        this.loanDay = loanDay == null ? null : loanDay.trim();
    }

    public String getKnotMsg() {
        return knotMsg;
    }

    public void setKnotMsg(String knotMsg) {
        this.knotMsg = knotMsg == null ? null : knotMsg.trim();
    }
}