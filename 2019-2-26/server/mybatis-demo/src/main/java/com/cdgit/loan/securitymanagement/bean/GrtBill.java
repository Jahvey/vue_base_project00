package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 票据bean
 * @author wuyong
 * @date 2019.1.10
 *
 */
public class GrtBill {
    private String guarantyId;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal billAmt;

    private String billCurrencyCd;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date billSignupDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date billExpireDate;

    private String billType;

    private String remitterName;

    private String remitterAccount;

    private String remitterBank;

    private String payeeName;

    private String payeeAccount;

    private String payeeBank;

    private String searchResult;

    private String acceptorBank;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal billTerm;

    private String billTermCd;

    private String billNum;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public BigDecimal getBillAmt() {
        return billAmt;
    }

    public void setBillAmt(BigDecimal billAmt) {
        this.billAmt = billAmt;
    }

    public String getBillCurrencyCd() {
        return billCurrencyCd;
    }

    public void setBillCurrencyCd(String billCurrencyCd) {
        this.billCurrencyCd = billCurrencyCd == null ? null : billCurrencyCd.trim();
    }

    public Date getBillSignupDate() {
        return billSignupDate;
    }

    public void setBillSignupDate(Date billSignupDate) {
        this.billSignupDate = billSignupDate;
    }

    public Date getBillExpireDate() {
        return billExpireDate;
    }

    public void setBillExpireDate(Date billExpireDate) {
        this.billExpireDate = billExpireDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    public String getRemitterName() {
        return remitterName;
    }

    public void setRemitterName(String remitterName) {
        this.remitterName = remitterName == null ? null : remitterName.trim();
    }

    public String getRemitterAccount() {
        return remitterAccount;
    }

    public void setRemitterAccount(String remitterAccount) {
        this.remitterAccount = remitterAccount == null ? null : remitterAccount.trim();
    }

    public String getRemitterBank() {
        return remitterBank;
    }

    public void setRemitterBank(String remitterBank) {
        this.remitterBank = remitterBank == null ? null : remitterBank.trim();
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName == null ? null : payeeName.trim();
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount == null ? null : payeeAccount.trim();
    }

    public String getPayeeBank() {
        return payeeBank;
    }

    public void setPayeeBank(String payeeBank) {
        this.payeeBank = payeeBank == null ? null : payeeBank.trim();
    }

    public String getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(String searchResult) {
        this.searchResult = searchResult == null ? null : searchResult.trim();
    }

    public String getAcceptorBank() {
        return acceptorBank;
    }

    public void setAcceptorBank(String acceptorBank) {
        this.acceptorBank = acceptorBank == null ? null : acceptorBank.trim();
    }

    public BigDecimal getBillTerm() {
        return billTerm;
    }

    public void setBillTerm(BigDecimal billTerm) {
        this.billTerm = billTerm;
    }

    public String getBillTermCd() {
        return billTermCd;
    }

    public void setBillTermCd(String billTermCd) {
        this.billTermCd = billTermCd == null ? null : billTermCd.trim();
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum == null ? null : billNum.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GrtBill other = (GrtBill) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getBillAmt() == null ? other.getBillAmt() == null : this.getBillAmt().equals(other.getBillAmt()))
            && (this.getBillCurrencyCd() == null ? other.getBillCurrencyCd() == null : this.getBillCurrencyCd().equals(other.getBillCurrencyCd()))
            && (this.getBillSignupDate() == null ? other.getBillSignupDate() == null : this.getBillSignupDate().equals(other.getBillSignupDate()))
            && (this.getBillExpireDate() == null ? other.getBillExpireDate() == null : this.getBillExpireDate().equals(other.getBillExpireDate()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()))
            && (this.getRemitterName() == null ? other.getRemitterName() == null : this.getRemitterName().equals(other.getRemitterName()))
            && (this.getRemitterAccount() == null ? other.getRemitterAccount() == null : this.getRemitterAccount().equals(other.getRemitterAccount()))
            && (this.getRemitterBank() == null ? other.getRemitterBank() == null : this.getRemitterBank().equals(other.getRemitterBank()))
            && (this.getPayeeName() == null ? other.getPayeeName() == null : this.getPayeeName().equals(other.getPayeeName()))
            && (this.getPayeeAccount() == null ? other.getPayeeAccount() == null : this.getPayeeAccount().equals(other.getPayeeAccount()))
            && (this.getPayeeBank() == null ? other.getPayeeBank() == null : this.getPayeeBank().equals(other.getPayeeBank()))
            && (this.getSearchResult() == null ? other.getSearchResult() == null : this.getSearchResult().equals(other.getSearchResult()))
            && (this.getAcceptorBank() == null ? other.getAcceptorBank() == null : this.getAcceptorBank().equals(other.getAcceptorBank()))
            && (this.getBillTerm() == null ? other.getBillTerm() == null : this.getBillTerm().equals(other.getBillTerm()))
            && (this.getBillTermCd() == null ? other.getBillTermCd() == null : this.getBillTermCd().equals(other.getBillTermCd()))
            && (this.getBillNum() == null ? other.getBillNum() == null : this.getBillNum().equals(other.getBillNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getBillAmt() == null) ? 0 : getBillAmt().hashCode());
        result = prime * result + ((getBillCurrencyCd() == null) ? 0 : getBillCurrencyCd().hashCode());
        result = prime * result + ((getBillSignupDate() == null) ? 0 : getBillSignupDate().hashCode());
        result = prime * result + ((getBillExpireDate() == null) ? 0 : getBillExpireDate().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        result = prime * result + ((getRemitterName() == null) ? 0 : getRemitterName().hashCode());
        result = prime * result + ((getRemitterAccount() == null) ? 0 : getRemitterAccount().hashCode());
        result = prime * result + ((getRemitterBank() == null) ? 0 : getRemitterBank().hashCode());
        result = prime * result + ((getPayeeName() == null) ? 0 : getPayeeName().hashCode());
        result = prime * result + ((getPayeeAccount() == null) ? 0 : getPayeeAccount().hashCode());
        result = prime * result + ((getPayeeBank() == null) ? 0 : getPayeeBank().hashCode());
        result = prime * result + ((getSearchResult() == null) ? 0 : getSearchResult().hashCode());
        result = prime * result + ((getAcceptorBank() == null) ? 0 : getAcceptorBank().hashCode());
        result = prime * result + ((getBillTerm() == null) ? 0 : getBillTerm().hashCode());
        result = prime * result + ((getBillTermCd() == null) ? 0 : getBillTermCd().hashCode());
        result = prime * result + ((getBillNum() == null) ? 0 : getBillNum().hashCode());
        return result;
    }
}