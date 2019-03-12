package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 基础利率表：Tb_Sys_Basic_Rate
 * @author mch
 *
 */
public class CrtTbSysBasicRate {
	
    private String intRateId;

    private BigDecimal intRate;

    private Date validDate;

    private Date dataDate;

    private Date invalidDate;

    private String status;

    private String intRateCd;

    private String currencyCd;

    private String intRateName;

    public String getIntRateId() {
        return intRateId;
    }

    public void setIntRateId(String intRateId) {
        this.intRateId = intRateId == null ? null : intRateId.trim();
    }

    public BigDecimal getIntRate() {
        return intRate;
    }

    public void setIntRate(BigDecimal intRate) {
        this.intRate = intRate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Date getDataDate() {
        return dataDate;
    }

    public void setDataDate(Date dataDate) {
        this.dataDate = dataDate;
    }

    public Date getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIntRateCd() {
        return intRateCd;
    }

    public void setIntRateCd(String intRateCd) {
        this.intRateCd = intRateCd == null ? null : intRateCd.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public String getIntRateName() {
        return intRateName;
    }

    public void setIntRateName(String intRateName) {
        this.intRateName = intRateName == null ? null : intRateName.trim();
    }
}