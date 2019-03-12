package com.cdgit.loan.creditLimit.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbConGuarantOrgInfo {
    private String contractId;

    private String partyId;

    private String khh;

    private String zhhm;

    private String zhzh;

    private BigDecimal fdbs;

    private BigDecimal bzjbl;

    private BigDecimal ye;

    private String statusCd;

    private Date createTime;

    private Date updateTime;

    private BigDecimal creditAmount;

    private BigDecimal simpleAmount;

    private String accnoWay;

    private String creditType;

    private String creditStatus;

    private BigDecimal creditApport;

    private BigDecimal creditAbroad;

    private BigDecimal creditOneRepay;

    private BigDecimal creditTwoRepay;

    private BigDecimal creditTwoOtherRepay;

    private BigDecimal creditLoan;

    private BigDecimal creditOtherAmount;

    private String innerCret;

    private BigDecimal deferAssets;

    private BigDecimal waitAssets;

    private BigDecimal goodsStock;

    private String userNum;

    private Integer orgNum;

    private String dealTime;

    private String remark;

    private BigDecimal creditTwoPayable;

    private BigDecimal lastYearAmount;

    private BigDecimal outerAssets;

    private BigDecimal fixedAssets;

    private BigDecimal invisibleAssets;

    private String printModel;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getKhh() {
        return khh;
    }

    public void setKhh(String khh) {
        this.khh = khh == null ? null : khh.trim();
    }

    public String getZhhm() {
        return zhhm;
    }

    public void setZhhm(String zhhm) {
        this.zhhm = zhhm == null ? null : zhhm.trim();
    }

    public String getZhzh() {
        return zhzh;
    }

    public void setZhzh(String zhzh) {
        this.zhzh = zhzh == null ? null : zhzh.trim();
    }

    public BigDecimal getFdbs() {
        return fdbs;
    }

    public void setFdbs(BigDecimal fdbs) {
        this.fdbs = fdbs;
    }

    public BigDecimal getBzjbl() {
        return bzjbl;
    }

    public void setBzjbl(BigDecimal bzjbl) {
        this.bzjbl = bzjbl;
    }

    public BigDecimal getYe() {
        return ye;
    }

    public void setYe(BigDecimal ye) {
        this.ye = ye;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd == null ? null : statusCd.trim();
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

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public BigDecimal getSimpleAmount() {
        return simpleAmount;
    }

    public void setSimpleAmount(BigDecimal simpleAmount) {
        this.simpleAmount = simpleAmount;
    }

    public String getAccnoWay() {
        return accnoWay;
    }

    public void setAccnoWay(String accnoWay) {
        this.accnoWay = accnoWay == null ? null : accnoWay.trim();
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType == null ? null : creditType.trim();
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus == null ? null : creditStatus.trim();
    }

    public BigDecimal getCreditApport() {
        return creditApport;
    }

    public void setCreditApport(BigDecimal creditApport) {
        this.creditApport = creditApport;
    }

    public BigDecimal getCreditAbroad() {
        return creditAbroad;
    }

    public void setCreditAbroad(BigDecimal creditAbroad) {
        this.creditAbroad = creditAbroad;
    }

    public BigDecimal getCreditOneRepay() {
        return creditOneRepay;
    }

    public void setCreditOneRepay(BigDecimal creditOneRepay) {
        this.creditOneRepay = creditOneRepay;
    }

    public BigDecimal getCreditTwoRepay() {
        return creditTwoRepay;
    }

    public void setCreditTwoRepay(BigDecimal creditTwoRepay) {
        this.creditTwoRepay = creditTwoRepay;
    }

    public BigDecimal getCreditTwoOtherRepay() {
        return creditTwoOtherRepay;
    }

    public void setCreditTwoOtherRepay(BigDecimal creditTwoOtherRepay) {
        this.creditTwoOtherRepay = creditTwoOtherRepay;
    }

    public BigDecimal getCreditLoan() {
        return creditLoan;
    }

    public void setCreditLoan(BigDecimal creditLoan) {
        this.creditLoan = creditLoan;
    }

    public BigDecimal getCreditOtherAmount() {
        return creditOtherAmount;
    }

    public void setCreditOtherAmount(BigDecimal creditOtherAmount) {
        this.creditOtherAmount = creditOtherAmount;
    }

    public String getInnerCret() {
        return innerCret;
    }

    public void setInnerCret(String innerCret) {
        this.innerCret = innerCret == null ? null : innerCret.trim();
    }

    public BigDecimal getDeferAssets() {
        return deferAssets;
    }

    public void setDeferAssets(BigDecimal deferAssets) {
        this.deferAssets = deferAssets;
    }

    public BigDecimal getWaitAssets() {
        return waitAssets;
    }

    public void setWaitAssets(BigDecimal waitAssets) {
        this.waitAssets = waitAssets;
    }

    public BigDecimal getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(BigDecimal goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public Integer getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(Integer orgNum) {
        this.orgNum = orgNum;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime == null ? null : dealTime.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getCreditTwoPayable() {
        return creditTwoPayable;
    }

    public void setCreditTwoPayable(BigDecimal creditTwoPayable) {
        this.creditTwoPayable = creditTwoPayable;
    }

    public BigDecimal getLastYearAmount() {
        return lastYearAmount;
    }

    public void setLastYearAmount(BigDecimal lastYearAmount) {
        this.lastYearAmount = lastYearAmount;
    }

    public BigDecimal getOuterAssets() {
        return outerAssets;
    }

    public void setOuterAssets(BigDecimal outerAssets) {
        this.outerAssets = outerAssets;
    }

    public BigDecimal getFixedAssets() {
        return fixedAssets;
    }

    public void setFixedAssets(BigDecimal fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    public BigDecimal getInvisibleAssets() {
        return invisibleAssets;
    }

    public void setInvisibleAssets(BigDecimal invisibleAssets) {
        this.invisibleAssets = invisibleAssets;
    }

    public String getPrintModel() {
        return printModel;
    }

    public void setPrintModel(String printModel) {
        this.printModel = printModel == null ? null : printModel.trim();
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
        TbConGuarantOrgInfo other = (TbConGuarantOrgInfo) that;
        return (this.getContractId() == null ? other.getContractId() == null : this.getContractId().equals(other.getContractId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getKhh() == null ? other.getKhh() == null : this.getKhh().equals(other.getKhh()))
            && (this.getZhhm() == null ? other.getZhhm() == null : this.getZhhm().equals(other.getZhhm()))
            && (this.getZhzh() == null ? other.getZhzh() == null : this.getZhzh().equals(other.getZhzh()))
            && (this.getFdbs() == null ? other.getFdbs() == null : this.getFdbs().equals(other.getFdbs()))
            && (this.getBzjbl() == null ? other.getBzjbl() == null : this.getBzjbl().equals(other.getBzjbl()))
            && (this.getYe() == null ? other.getYe() == null : this.getYe().equals(other.getYe()))
            && (this.getStatusCd() == null ? other.getStatusCd() == null : this.getStatusCd().equals(other.getStatusCd()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreditAmount() == null ? other.getCreditAmount() == null : this.getCreditAmount().equals(other.getCreditAmount()))
            && (this.getSimpleAmount() == null ? other.getSimpleAmount() == null : this.getSimpleAmount().equals(other.getSimpleAmount()))
            && (this.getAccnoWay() == null ? other.getAccnoWay() == null : this.getAccnoWay().equals(other.getAccnoWay()))
            && (this.getCreditType() == null ? other.getCreditType() == null : this.getCreditType().equals(other.getCreditType()))
            && (this.getCreditStatus() == null ? other.getCreditStatus() == null : this.getCreditStatus().equals(other.getCreditStatus()))
            && (this.getCreditApport() == null ? other.getCreditApport() == null : this.getCreditApport().equals(other.getCreditApport()))
            && (this.getCreditAbroad() == null ? other.getCreditAbroad() == null : this.getCreditAbroad().equals(other.getCreditAbroad()))
            && (this.getCreditOneRepay() == null ? other.getCreditOneRepay() == null : this.getCreditOneRepay().equals(other.getCreditOneRepay()))
            && (this.getCreditTwoRepay() == null ? other.getCreditTwoRepay() == null : this.getCreditTwoRepay().equals(other.getCreditTwoRepay()))
            && (this.getCreditTwoOtherRepay() == null ? other.getCreditTwoOtherRepay() == null : this.getCreditTwoOtherRepay().equals(other.getCreditTwoOtherRepay()))
            && (this.getCreditLoan() == null ? other.getCreditLoan() == null : this.getCreditLoan().equals(other.getCreditLoan()))
            && (this.getCreditOtherAmount() == null ? other.getCreditOtherAmount() == null : this.getCreditOtherAmount().equals(other.getCreditOtherAmount()))
            && (this.getInnerCret() == null ? other.getInnerCret() == null : this.getInnerCret().equals(other.getInnerCret()))
            && (this.getDeferAssets() == null ? other.getDeferAssets() == null : this.getDeferAssets().equals(other.getDeferAssets()))
            && (this.getWaitAssets() == null ? other.getWaitAssets() == null : this.getWaitAssets().equals(other.getWaitAssets()))
            && (this.getGoodsStock() == null ? other.getGoodsStock() == null : this.getGoodsStock().equals(other.getGoodsStock()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getDealTime() == null ? other.getDealTime() == null : this.getDealTime().equals(other.getDealTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreditTwoPayable() == null ? other.getCreditTwoPayable() == null : this.getCreditTwoPayable().equals(other.getCreditTwoPayable()))
            && (this.getLastYearAmount() == null ? other.getLastYearAmount() == null : this.getLastYearAmount().equals(other.getLastYearAmount()))
            && (this.getOuterAssets() == null ? other.getOuterAssets() == null : this.getOuterAssets().equals(other.getOuterAssets()))
            && (this.getFixedAssets() == null ? other.getFixedAssets() == null : this.getFixedAssets().equals(other.getFixedAssets()))
            && (this.getInvisibleAssets() == null ? other.getInvisibleAssets() == null : this.getInvisibleAssets().equals(other.getInvisibleAssets()))
            && (this.getPrintModel() == null ? other.getPrintModel() == null : this.getPrintModel().equals(other.getPrintModel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getContractId() == null) ? 0 : getContractId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getKhh() == null) ? 0 : getKhh().hashCode());
        result = prime * result + ((getZhhm() == null) ? 0 : getZhhm().hashCode());
        result = prime * result + ((getZhzh() == null) ? 0 : getZhzh().hashCode());
        result = prime * result + ((getFdbs() == null) ? 0 : getFdbs().hashCode());
        result = prime * result + ((getBzjbl() == null) ? 0 : getBzjbl().hashCode());
        result = prime * result + ((getYe() == null) ? 0 : getYe().hashCode());
        result = prime * result + ((getStatusCd() == null) ? 0 : getStatusCd().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreditAmount() == null) ? 0 : getCreditAmount().hashCode());
        result = prime * result + ((getSimpleAmount() == null) ? 0 : getSimpleAmount().hashCode());
        result = prime * result + ((getAccnoWay() == null) ? 0 : getAccnoWay().hashCode());
        result = prime * result + ((getCreditType() == null) ? 0 : getCreditType().hashCode());
        result = prime * result + ((getCreditStatus() == null) ? 0 : getCreditStatus().hashCode());
        result = prime * result + ((getCreditApport() == null) ? 0 : getCreditApport().hashCode());
        result = prime * result + ((getCreditAbroad() == null) ? 0 : getCreditAbroad().hashCode());
        result = prime * result + ((getCreditOneRepay() == null) ? 0 : getCreditOneRepay().hashCode());
        result = prime * result + ((getCreditTwoRepay() == null) ? 0 : getCreditTwoRepay().hashCode());
        result = prime * result + ((getCreditTwoOtherRepay() == null) ? 0 : getCreditTwoOtherRepay().hashCode());
        result = prime * result + ((getCreditLoan() == null) ? 0 : getCreditLoan().hashCode());
        result = prime * result + ((getCreditOtherAmount() == null) ? 0 : getCreditOtherAmount().hashCode());
        result = prime * result + ((getInnerCret() == null) ? 0 : getInnerCret().hashCode());
        result = prime * result + ((getDeferAssets() == null) ? 0 : getDeferAssets().hashCode());
        result = prime * result + ((getWaitAssets() == null) ? 0 : getWaitAssets().hashCode());
        result = prime * result + ((getGoodsStock() == null) ? 0 : getGoodsStock().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getDealTime() == null) ? 0 : getDealTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreditTwoPayable() == null) ? 0 : getCreditTwoPayable().hashCode());
        result = prime * result + ((getLastYearAmount() == null) ? 0 : getLastYearAmount().hashCode());
        result = prime * result + ((getOuterAssets() == null) ? 0 : getOuterAssets().hashCode());
        result = prime * result + ((getFixedAssets() == null) ? 0 : getFixedAssets().hashCode());
        result = prime * result + ((getInvisibleAssets() == null) ? 0 : getInvisibleAssets().hashCode());
        result = prime * result + ((getPrintModel() == null) ? 0 : getPrintModel().hashCode());
        return result;
    }
}