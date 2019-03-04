package com.cdgit.loan.guaranteevaluation.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 第三方客户额度表  
 * @author wuyong
 *
 */
public class CrdThirdPartyLimit {
    private String limitId;

    private String partyId;

    private String currencyCd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal guarantAmt;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal lowestGuarantAmt;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal amplifyInd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal guarantTerm;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal guarantOrgReal;

    private String mainOrgId;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date dealDate;

    private String remark;

    private String itemType;

    private String itemName;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date itemBeginDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date itemEndDate;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal itemAmt;

    private String itemCurrencyCd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal longestLoanTerm;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal highestLoanRate;

    private String itemRemark;

    private String userNum;

    private String creditNum;

    private String limitType;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;

    private String orgNum;

    private String statusCd;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date beginDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date endDate;

    private String crdControlType;

    private String settleAccno;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal depositPercentOne;

    private String depositAccOrgOne;

    private String depositAccnoOne;

    private String depositAccnameOne;

    private BigDecimal depositPercentTwo;

    private String depositAccOrgTwo;

    private String depositAccnoTwo;

    private String depositAccnameTwo;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal depositPercentThree;

    private String depositAccOrgThree;

    private String depositAccnoThree;

    private String depositAccnameThree;

    private String accOneStatus;

    private String accTwoStatus;

    private String accThreeStatus;

    private String oldLimitId;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date updateTime;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal itemUsed;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal itemAvi;

    private String houseLoanType;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal creditAmount;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal simpleAmount;

    private String accnoWay;

    private String creditType;

    private String creditStatus;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal creditApport;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal creditAbroad;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal creditOneRepay;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal creditTwoRepay;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal creditTwoOtherRepay;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal creditLoan;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal creditOtherAmount;

    private String innerCret;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal deferAssets;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal waitAssets;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal goodsStock;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal creditTwoPayable;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal lastYearAmount;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal outerAssets;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal fixedAssets;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal invisibleAssets;

    private String printModel;

    public String getLimitId() {
        return limitId;
    }

    public void setLimitId(String limitId) {
        this.limitId = limitId == null ? null : limitId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getGuarantAmt() {
        return guarantAmt;
    }

    public void setGuarantAmt(BigDecimal guarantAmt) {
        this.guarantAmt = guarantAmt;
    }

    public BigDecimal getLowestGuarantAmt() {
        return lowestGuarantAmt;
    }

    public void setLowestGuarantAmt(BigDecimal lowestGuarantAmt) {
        this.lowestGuarantAmt = lowestGuarantAmt;
    }

    public BigDecimal getAmplifyInd() {
        return amplifyInd;
    }

    public void setAmplifyInd(BigDecimal amplifyInd) {
        this.amplifyInd = amplifyInd;
    }

    public BigDecimal getGuarantTerm() {
        return guarantTerm;
    }

    public void setGuarantTerm(BigDecimal guarantTerm) {
        this.guarantTerm = guarantTerm;
    }

    public BigDecimal getGuarantOrgReal() {
        return guarantOrgReal;
    }

    public void setGuarantOrgReal(BigDecimal guarantOrgReal) {
        this.guarantOrgReal = guarantOrgReal;
    }

    public String getMainOrgId() {
        return mainOrgId;
    }

    public void setMainOrgId(String mainOrgId) {
        this.mainOrgId = mainOrgId == null ? null : mainOrgId.trim();
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Date getItemBeginDate() {
        return itemBeginDate;
    }

    public void setItemBeginDate(Date itemBeginDate) {
        this.itemBeginDate = itemBeginDate;
    }

    public Date getItemEndDate() {
        return itemEndDate;
    }

    public void setItemEndDate(Date itemEndDate) {
        this.itemEndDate = itemEndDate;
    }

    public BigDecimal getItemAmt() {
        return itemAmt;
    }

    public void setItemAmt(BigDecimal itemAmt) {
        this.itemAmt = itemAmt;
    }

    public String getItemCurrencyCd() {
        return itemCurrencyCd;
    }

    public void setItemCurrencyCd(String itemCurrencyCd) {
        this.itemCurrencyCd = itemCurrencyCd == null ? null : itemCurrencyCd.trim();
    }

    public BigDecimal getLongestLoanTerm() {
        return longestLoanTerm;
    }

    public void setLongestLoanTerm(BigDecimal longestLoanTerm) {
        this.longestLoanTerm = longestLoanTerm;
    }

    public BigDecimal getHighestLoanRate() {
        return highestLoanRate;
    }

    public void setHighestLoanRate(BigDecimal highestLoanRate) {
        this.highestLoanRate = highestLoanRate;
    }

    public String getItemRemark() {
        return itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark == null ? null : itemRemark.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getCreditNum() {
        return creditNum;
    }

    public void setCreditNum(String creditNum) {
        this.creditNum = creditNum == null ? null : creditNum.trim();
    }

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType == null ? null : limitType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd == null ? null : statusCd.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCrdControlType() {
        return crdControlType;
    }

    public void setCrdControlType(String crdControlType) {
        this.crdControlType = crdControlType == null ? null : crdControlType.trim();
    }

    public String getSettleAccno() {
        return settleAccno;
    }

    public void setSettleAccno(String settleAccno) {
        this.settleAccno = settleAccno == null ? null : settleAccno.trim();
    }

    public BigDecimal getDepositPercentOne() {
        return depositPercentOne;
    }

    public void setDepositPercentOne(BigDecimal depositPercentOne) {
        this.depositPercentOne = depositPercentOne;
    }

    public String getDepositAccOrgOne() {
        return depositAccOrgOne;
    }

    public void setDepositAccOrgOne(String depositAccOrgOne) {
        this.depositAccOrgOne = depositAccOrgOne == null ? null : depositAccOrgOne.trim();
    }

    public String getDepositAccnoOne() {
        return depositAccnoOne;
    }

    public void setDepositAccnoOne(String depositAccnoOne) {
        this.depositAccnoOne = depositAccnoOne == null ? null : depositAccnoOne.trim();
    }

    public String getDepositAccnameOne() {
        return depositAccnameOne;
    }

    public void setDepositAccnameOne(String depositAccnameOne) {
        this.depositAccnameOne = depositAccnameOne == null ? null : depositAccnameOne.trim();
    }

    public BigDecimal getDepositPercentTwo() {
        return depositPercentTwo;
    }

    public void setDepositPercentTwo(BigDecimal depositPercentTwo) {
        this.depositPercentTwo = depositPercentTwo;
    }

    public String getDepositAccOrgTwo() {
        return depositAccOrgTwo;
    }

    public void setDepositAccOrgTwo(String depositAccOrgTwo) {
        this.depositAccOrgTwo = depositAccOrgTwo == null ? null : depositAccOrgTwo.trim();
    }

    public String getDepositAccnoTwo() {
        return depositAccnoTwo;
    }

    public void setDepositAccnoTwo(String depositAccnoTwo) {
        this.depositAccnoTwo = depositAccnoTwo == null ? null : depositAccnoTwo.trim();
    }

    public String getDepositAccnameTwo() {
        return depositAccnameTwo;
    }

    public void setDepositAccnameTwo(String depositAccnameTwo) {
        this.depositAccnameTwo = depositAccnameTwo == null ? null : depositAccnameTwo.trim();
    }

    public BigDecimal getDepositPercentThree() {
        return depositPercentThree;
    }

    public void setDepositPercentThree(BigDecimal depositPercentThree) {
        this.depositPercentThree = depositPercentThree;
    }

    public String getDepositAccOrgThree() {
        return depositAccOrgThree;
    }

    public void setDepositAccOrgThree(String depositAccOrgThree) {
        this.depositAccOrgThree = depositAccOrgThree == null ? null : depositAccOrgThree.trim();
    }

    public String getDepositAccnoThree() {
        return depositAccnoThree;
    }

    public void setDepositAccnoThree(String depositAccnoThree) {
        this.depositAccnoThree = depositAccnoThree == null ? null : depositAccnoThree.trim();
    }

    public String getDepositAccnameThree() {
        return depositAccnameThree;
    }

    public void setDepositAccnameThree(String depositAccnameThree) {
        this.depositAccnameThree = depositAccnameThree == null ? null : depositAccnameThree.trim();
    }

    public String getAccOneStatus() {
        return accOneStatus;
    }

    public void setAccOneStatus(String accOneStatus) {
        this.accOneStatus = accOneStatus == null ? null : accOneStatus.trim();
    }

    public String getAccTwoStatus() {
        return accTwoStatus;
    }

    public void setAccTwoStatus(String accTwoStatus) {
        this.accTwoStatus = accTwoStatus == null ? null : accTwoStatus.trim();
    }

    public String getAccThreeStatus() {
        return accThreeStatus;
    }

    public void setAccThreeStatus(String accThreeStatus) {
        this.accThreeStatus = accThreeStatus == null ? null : accThreeStatus.trim();
    }

    public String getOldLimitId() {
        return oldLimitId;
    }

    public void setOldLimitId(String oldLimitId) {
        this.oldLimitId = oldLimitId == null ? null : oldLimitId.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getItemUsed() {
        return itemUsed;
    }

    public void setItemUsed(BigDecimal itemUsed) {
        this.itemUsed = itemUsed;
    }

    public BigDecimal getItemAvi() {
        return itemAvi;
    }

    public void setItemAvi(BigDecimal itemAvi) {
        this.itemAvi = itemAvi;
    }

    public String getHouseLoanType() {
        return houseLoanType;
    }

    public void setHouseLoanType(String houseLoanType) {
        this.houseLoanType = houseLoanType == null ? null : houseLoanType.trim();
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
        CrdThirdPartyLimit other = (CrdThirdPartyLimit) that;
        return (this.getLimitId() == null ? other.getLimitId() == null : this.getLimitId().equals(other.getLimitId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getGuarantAmt() == null ? other.getGuarantAmt() == null : this.getGuarantAmt().equals(other.getGuarantAmt()))
            && (this.getLowestGuarantAmt() == null ? other.getLowestGuarantAmt() == null : this.getLowestGuarantAmt().equals(other.getLowestGuarantAmt()))
            && (this.getAmplifyInd() == null ? other.getAmplifyInd() == null : this.getAmplifyInd().equals(other.getAmplifyInd()))
            && (this.getGuarantTerm() == null ? other.getGuarantTerm() == null : this.getGuarantTerm().equals(other.getGuarantTerm()))
            && (this.getGuarantOrgReal() == null ? other.getGuarantOrgReal() == null : this.getGuarantOrgReal().equals(other.getGuarantOrgReal()))
            && (this.getMainOrgId() == null ? other.getMainOrgId() == null : this.getMainOrgId().equals(other.getMainOrgId()))
            && (this.getDealDate() == null ? other.getDealDate() == null : this.getDealDate().equals(other.getDealDate()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getItemType() == null ? other.getItemType() == null : this.getItemType().equals(other.getItemType()))
            && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
            && (this.getItemBeginDate() == null ? other.getItemBeginDate() == null : this.getItemBeginDate().equals(other.getItemBeginDate()))
            && (this.getItemEndDate() == null ? other.getItemEndDate() == null : this.getItemEndDate().equals(other.getItemEndDate()))
            && (this.getItemAmt() == null ? other.getItemAmt() == null : this.getItemAmt().equals(other.getItemAmt()))
            && (this.getItemCurrencyCd() == null ? other.getItemCurrencyCd() == null : this.getItemCurrencyCd().equals(other.getItemCurrencyCd()))
            && (this.getLongestLoanTerm() == null ? other.getLongestLoanTerm() == null : this.getLongestLoanTerm().equals(other.getLongestLoanTerm()))
            && (this.getHighestLoanRate() == null ? other.getHighestLoanRate() == null : this.getHighestLoanRate().equals(other.getHighestLoanRate()))
            && (this.getItemRemark() == null ? other.getItemRemark() == null : this.getItemRemark().equals(other.getItemRemark()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getCreditNum() == null ? other.getCreditNum() == null : this.getCreditNum().equals(other.getCreditNum()))
            && (this.getLimitType() == null ? other.getLimitType() == null : this.getLimitType().equals(other.getLimitType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getStatusCd() == null ? other.getStatusCd() == null : this.getStatusCd().equals(other.getStatusCd()))
            && (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getCrdControlType() == null ? other.getCrdControlType() == null : this.getCrdControlType().equals(other.getCrdControlType()))
            && (this.getSettleAccno() == null ? other.getSettleAccno() == null : this.getSettleAccno().equals(other.getSettleAccno()))
            && (this.getDepositPercentOne() == null ? other.getDepositPercentOne() == null : this.getDepositPercentOne().equals(other.getDepositPercentOne()))
            && (this.getDepositAccOrgOne() == null ? other.getDepositAccOrgOne() == null : this.getDepositAccOrgOne().equals(other.getDepositAccOrgOne()))
            && (this.getDepositAccnoOne() == null ? other.getDepositAccnoOne() == null : this.getDepositAccnoOne().equals(other.getDepositAccnoOne()))
            && (this.getDepositAccnameOne() == null ? other.getDepositAccnameOne() == null : this.getDepositAccnameOne().equals(other.getDepositAccnameOne()))
            && (this.getDepositPercentTwo() == null ? other.getDepositPercentTwo() == null : this.getDepositPercentTwo().equals(other.getDepositPercentTwo()))
            && (this.getDepositAccOrgTwo() == null ? other.getDepositAccOrgTwo() == null : this.getDepositAccOrgTwo().equals(other.getDepositAccOrgTwo()))
            && (this.getDepositAccnoTwo() == null ? other.getDepositAccnoTwo() == null : this.getDepositAccnoTwo().equals(other.getDepositAccnoTwo()))
            && (this.getDepositAccnameTwo() == null ? other.getDepositAccnameTwo() == null : this.getDepositAccnameTwo().equals(other.getDepositAccnameTwo()))
            && (this.getDepositPercentThree() == null ? other.getDepositPercentThree() == null : this.getDepositPercentThree().equals(other.getDepositPercentThree()))
            && (this.getDepositAccOrgThree() == null ? other.getDepositAccOrgThree() == null : this.getDepositAccOrgThree().equals(other.getDepositAccOrgThree()))
            && (this.getDepositAccnoThree() == null ? other.getDepositAccnoThree() == null : this.getDepositAccnoThree().equals(other.getDepositAccnoThree()))
            && (this.getDepositAccnameThree() == null ? other.getDepositAccnameThree() == null : this.getDepositAccnameThree().equals(other.getDepositAccnameThree()))
            && (this.getAccOneStatus() == null ? other.getAccOneStatus() == null : this.getAccOneStatus().equals(other.getAccOneStatus()))
            && (this.getAccTwoStatus() == null ? other.getAccTwoStatus() == null : this.getAccTwoStatus().equals(other.getAccTwoStatus()))
            && (this.getAccThreeStatus() == null ? other.getAccThreeStatus() == null : this.getAccThreeStatus().equals(other.getAccThreeStatus()))
            && (this.getOldLimitId() == null ? other.getOldLimitId() == null : this.getOldLimitId().equals(other.getOldLimitId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getItemUsed() == null ? other.getItemUsed() == null : this.getItemUsed().equals(other.getItemUsed()))
            && (this.getItemAvi() == null ? other.getItemAvi() == null : this.getItemAvi().equals(other.getItemAvi()))
            && (this.getHouseLoanType() == null ? other.getHouseLoanType() == null : this.getHouseLoanType().equals(other.getHouseLoanType()))
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
        result = prime * result + ((getLimitId() == null) ? 0 : getLimitId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getGuarantAmt() == null) ? 0 : getGuarantAmt().hashCode());
        result = prime * result + ((getLowestGuarantAmt() == null) ? 0 : getLowestGuarantAmt().hashCode());
        result = prime * result + ((getAmplifyInd() == null) ? 0 : getAmplifyInd().hashCode());
        result = prime * result + ((getGuarantTerm() == null) ? 0 : getGuarantTerm().hashCode());
        result = prime * result + ((getGuarantOrgReal() == null) ? 0 : getGuarantOrgReal().hashCode());
        result = prime * result + ((getMainOrgId() == null) ? 0 : getMainOrgId().hashCode());
        result = prime * result + ((getDealDate() == null) ? 0 : getDealDate().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getItemType() == null) ? 0 : getItemType().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getItemBeginDate() == null) ? 0 : getItemBeginDate().hashCode());
        result = prime * result + ((getItemEndDate() == null) ? 0 : getItemEndDate().hashCode());
        result = prime * result + ((getItemAmt() == null) ? 0 : getItemAmt().hashCode());
        result = prime * result + ((getItemCurrencyCd() == null) ? 0 : getItemCurrencyCd().hashCode());
        result = prime * result + ((getLongestLoanTerm() == null) ? 0 : getLongestLoanTerm().hashCode());
        result = prime * result + ((getHighestLoanRate() == null) ? 0 : getHighestLoanRate().hashCode());
        result = prime * result + ((getItemRemark() == null) ? 0 : getItemRemark().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getCreditNum() == null) ? 0 : getCreditNum().hashCode());
        result = prime * result + ((getLimitType() == null) ? 0 : getLimitType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getStatusCd() == null) ? 0 : getStatusCd().hashCode());
        result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getCrdControlType() == null) ? 0 : getCrdControlType().hashCode());
        result = prime * result + ((getSettleAccno() == null) ? 0 : getSettleAccno().hashCode());
        result = prime * result + ((getDepositPercentOne() == null) ? 0 : getDepositPercentOne().hashCode());
        result = prime * result + ((getDepositAccOrgOne() == null) ? 0 : getDepositAccOrgOne().hashCode());
        result = prime * result + ((getDepositAccnoOne() == null) ? 0 : getDepositAccnoOne().hashCode());
        result = prime * result + ((getDepositAccnameOne() == null) ? 0 : getDepositAccnameOne().hashCode());
        result = prime * result + ((getDepositPercentTwo() == null) ? 0 : getDepositPercentTwo().hashCode());
        result = prime * result + ((getDepositAccOrgTwo() == null) ? 0 : getDepositAccOrgTwo().hashCode());
        result = prime * result + ((getDepositAccnoTwo() == null) ? 0 : getDepositAccnoTwo().hashCode());
        result = prime * result + ((getDepositAccnameTwo() == null) ? 0 : getDepositAccnameTwo().hashCode());
        result = prime * result + ((getDepositPercentThree() == null) ? 0 : getDepositPercentThree().hashCode());
        result = prime * result + ((getDepositAccOrgThree() == null) ? 0 : getDepositAccOrgThree().hashCode());
        result = prime * result + ((getDepositAccnoThree() == null) ? 0 : getDepositAccnoThree().hashCode());
        result = prime * result + ((getDepositAccnameThree() == null) ? 0 : getDepositAccnameThree().hashCode());
        result = prime * result + ((getAccOneStatus() == null) ? 0 : getAccOneStatus().hashCode());
        result = prime * result + ((getAccTwoStatus() == null) ? 0 : getAccTwoStatus().hashCode());
        result = prime * result + ((getAccThreeStatus() == null) ? 0 : getAccThreeStatus().hashCode());
        result = prime * result + ((getOldLimitId() == null) ? 0 : getOldLimitId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getItemUsed() == null) ? 0 : getItemUsed().hashCode());
        result = prime * result + ((getItemAvi() == null) ? 0 : getItemAvi().hashCode());
        result = prime * result + ((getHouseLoanType() == null) ? 0 : getHouseLoanType().hashCode());
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
        result = prime * result + ((getCreditTwoPayable() == null) ? 0 : getCreditTwoPayable().hashCode());
        result = prime * result + ((getLastYearAmount() == null) ? 0 : getLastYearAmount().hashCode());
        result = prime * result + ((getOuterAssets() == null) ? 0 : getOuterAssets().hashCode());
        result = prime * result + ((getFixedAssets() == null) ? 0 : getFixedAssets().hashCode());
        result = prime * result + ((getInvisibleAssets() == null) ? 0 : getInvisibleAssets().hashCode());
        result = prime * result + ((getPrintModel() == null) ? 0 : getPrintModel().hashCode());
        return result;
    }
}