package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.cdgit.loan.csm.common.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 抵质押物bean
 * @author wuyong
 * @date 2018.12.25
 *
 */
public class GrtCollateral {
    private String guarantyId;

    private String collateralTypeCd;

    private String partyTypeCd;

    private String collateralNum;

    private String collateralStatusCd;

    private String collateralName;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal bookValue;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal bookNetValue;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal marketValue;

    private String evalValueCurrencyCd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal evalValue;

    private String ccbAssessedValueCurrencyCd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal ccbAssessedValue;

    private String acquireWayOfCollateralCd;

    private String commonAssetsInd;

    private String commonOwnerName;

    private String wayGuarantyEffectiveCd;

    private String collateralSetupInd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal setGuarantyAmtInCcb;

    private String rentedLicensedInd;

    private String renterName;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal setGuarantyAmtOutCcb;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date leaseExpirationDate;

    private String customerNum;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date submittingDate;

    private String currencyCd;

    private String collateralDispose;

    private String otherNote;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal setGuarantyAmt;

    private String provinceCd;

    private String cityCd;

    private String districtCd;

    private String streetAddress;

    private String nationalityCd;

    private String merchandiseType;

    private String rightCertTypeCd;

    private String rightCertificationNum;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date sysUpdateTime;

    private String collateralCatalogCd;

    private String dataCreatUserNum;

    private String dataCreatorOrgCd;

    private String lastUpdateUserNum;

    private String lastUpdateOrgCd;

    private String takeoverInd;

    private String allPledgeInd;

    private String forbidCirculateInd;

    private String nationalisationInd;

    private String propertyDisputedInd;

    private String invalidInd;

    private String blemishInd;

    private String mpType;

    private String blemishNote;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date handoverDate;

    private String k75zcms;

    private String keepSpecialReq;

    private String valuator;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date evaluateDate;

    private String assetStatus;
    
    private String customerType;
    
    private String settledAssetsInd;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date timeMark;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal impawnAmount;

    private String impawnAmountCd;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date impawnExpireDate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date impawnGetDate;

    private String registerInd;

    private String collateralCardDepartment;

    private String isStateAsset;

    private String isStateSectorApproval;

    private String isMortgageAllAsset;

    private String settledSource;

    private String assetsSourceBackup;

    private String collateralSeq;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getCollateralTypeCd() {
        return collateralTypeCd;
    }

    public void setCollateralTypeCd(String collateralTypeCd) {
        this.collateralTypeCd = collateralTypeCd == null ? null : collateralTypeCd.trim();
    }

    public String getPartyTypeCd() {
        return partyTypeCd;
    }

    public void setPartyTypeCd(String partyTypeCd) {
        this.partyTypeCd = partyTypeCd == null ? null : partyTypeCd.trim();
    }

    public String getCollateralNum() {
        return collateralNum;
    }

    public void setCollateralNum(String collateralNum) {
        this.collateralNum = collateralNum == null ? null : collateralNum.trim();
    }

    public String getCollateralStatusCd() {
        return collateralStatusCd;
    }

    public void setCollateralStatusCd(String collateralStatusCd) {
        this.collateralStatusCd = collateralStatusCd == null ? null : collateralStatusCd.trim();
    }

    public String getCollateralName() {
        return collateralName;
    }

    public void setCollateralName(String collateralName) {
        this.collateralName = collateralName == null ? null : collateralName.trim();
    }

    public BigDecimal getBookValue() {
        return bookValue;
    }

    public void setBookValue(BigDecimal bookValue) {
        this.bookValue = bookValue;
    }

    public BigDecimal getBookNetValue() {
        return bookNetValue;
    }

    public void setBookNetValue(BigDecimal bookNetValue) {
        this.bookNetValue = bookNetValue;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    public String getEvalValueCurrencyCd() {
        return evalValueCurrencyCd;
    }

    public void setEvalValueCurrencyCd(String evalValueCurrencyCd) {
        this.evalValueCurrencyCd = evalValueCurrencyCd == null ? null : evalValueCurrencyCd.trim();
    }

    public BigDecimal getEvalValue() {
        return evalValue;
    }

    public void setEvalValue(BigDecimal evalValue) {
        this.evalValue = evalValue;
    }

    public String getCcbAssessedValueCurrencyCd() {
        return ccbAssessedValueCurrencyCd;
    }

    public void setCcbAssessedValueCurrencyCd(String ccbAssessedValueCurrencyCd) {
        this.ccbAssessedValueCurrencyCd = ccbAssessedValueCurrencyCd == null ? null : ccbAssessedValueCurrencyCd.trim();
    }

    public BigDecimal getCcbAssessedValue() {
        return ccbAssessedValue;
    }

    public void setCcbAssessedValue(BigDecimal ccbAssessedValue) {
        this.ccbAssessedValue = ccbAssessedValue;
    }

    public String getAcquireWayOfCollateralCd() {
        return acquireWayOfCollateralCd;
    }

    public void setAcquireWayOfCollateralCd(String acquireWayOfCollateralCd) {
        this.acquireWayOfCollateralCd = acquireWayOfCollateralCd == null ? null : acquireWayOfCollateralCd.trim();
    }

    public String getCommonAssetsInd() {
        return commonAssetsInd;
    }

    public void setCommonAssetsInd(String commonAssetsInd) {
        this.commonAssetsInd = commonAssetsInd == null ? null : commonAssetsInd.trim();
    }

    public String getCommonOwnerName() {
        return commonOwnerName;
    }

    public void setCommonOwnerName(String commonOwnerName) {
        this.commonOwnerName = commonOwnerName == null ? null : commonOwnerName.trim();
    }

    public String getWayGuarantyEffectiveCd() {
        return wayGuarantyEffectiveCd;
    }

    public void setWayGuarantyEffectiveCd(String wayGuarantyEffectiveCd) {
        this.wayGuarantyEffectiveCd = wayGuarantyEffectiveCd == null ? null : wayGuarantyEffectiveCd.trim();
    }

    public String getCollateralSetupInd() {
        return collateralSetupInd;
    }

    public void setCollateralSetupInd(String collateralSetupInd) {
        this.collateralSetupInd = collateralSetupInd == null ? null : collateralSetupInd.trim();
    }

    public BigDecimal getSetGuarantyAmtInCcb() {
        return setGuarantyAmtInCcb;
    }

    public void setSetGuarantyAmtInCcb(BigDecimal setGuarantyAmtInCcb) {
        this.setGuarantyAmtInCcb = setGuarantyAmtInCcb;
    }

    public String getRentedLicensedInd() {
        return rentedLicensedInd;
    }

    public void setRentedLicensedInd(String rentedLicensedInd) {
        this.rentedLicensedInd = rentedLicensedInd == null ? null : rentedLicensedInd.trim();
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName == null ? null : renterName.trim();
    }

    public BigDecimal getSetGuarantyAmtOutCcb() {
        return setGuarantyAmtOutCcb;
    }

    public void setSetGuarantyAmtOutCcb(BigDecimal setGuarantyAmtOutCcb) {
        this.setGuarantyAmtOutCcb = setGuarantyAmtOutCcb;
    }

    public Date getLeaseExpirationDate() {
        return leaseExpirationDate;
    }

    public void setLeaseExpirationDate(Date leaseExpirationDate) {
        this.leaseExpirationDate = leaseExpirationDate;
    }

    public String getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(String customerNum) {
        this.customerNum = customerNum == null ? null : customerNum.trim();
    }

    public Date getSubmittingDate() {
        return submittingDate;
    }

    public void setSubmittingDate(Date submittingDate) {
        this.submittingDate = submittingDate;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public String getCollateralDispose() {
        return collateralDispose;
    }

    public void setCollateralDispose(String collateralDispose) {
        this.collateralDispose = collateralDispose == null ? null : collateralDispose.trim();
    }

    public String getOtherNote() {
        return otherNote;
    }

    public void setOtherNote(String otherNote) {
        this.otherNote = otherNote == null ? null : otherNote.trim();
    }

    public BigDecimal getSetGuarantyAmt() {
        return setGuarantyAmt;
    }

    public void setSetGuarantyAmt(BigDecimal setGuarantyAmt) {
        this.setGuarantyAmt = setGuarantyAmt;
    }

    public String getProvinceCd() {
        return provinceCd;
    }

    public void setProvinceCd(String provinceCd) {
        this.provinceCd = provinceCd == null ? null : provinceCd.trim();
    }

    public String getCityCd() {
        return cityCd;
    }

    public void setCityCd(String cityCd) {
        this.cityCd = cityCd == null ? null : cityCd.trim();
    }

    public String getDistrictCd() {
        return districtCd;
    }

    public void setDistrictCd(String districtCd) {
        this.districtCd = districtCd == null ? null : districtCd.trim();
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress == null ? null : streetAddress.trim();
    }

    public String getNationalityCd() {
        return nationalityCd;
    }

    public void setNationalityCd(String nationalityCd) {
        this.nationalityCd = nationalityCd == null ? null : nationalityCd.trim();
    }

    public String getMerchandiseType() {
        return merchandiseType;
    }

    public void setMerchandiseType(String merchandiseType) {
        this.merchandiseType = merchandiseType == null ? null : merchandiseType.trim();
    }

    public String getRightCertTypeCd() {
        return rightCertTypeCd;
    }

    public void setRightCertTypeCd(String rightCertTypeCd) {
        this.rightCertTypeCd = rightCertTypeCd == null ? null : rightCertTypeCd.trim();
    }

    public String getRightCertificationNum() {
        return rightCertificationNum;
    }

    public void setRightCertificationNum(String rightCertificationNum) {
        this.rightCertificationNum = rightCertificationNum == null ? null : rightCertificationNum.trim();
    }

    public Date getSysUpdateTime() {
        return sysUpdateTime;
    }

    public void setSysUpdateTime(Date sysUpdateTime) {
        this.sysUpdateTime = sysUpdateTime;
    }

    public String getCollateralCatalogCd() {
        return collateralCatalogCd;
    }

    public void setCollateralCatalogCd(String collateralCatalogCd) {
        this.collateralCatalogCd = collateralCatalogCd == null ? null : collateralCatalogCd.trim();
    }

    public String getDataCreatUserNum() {
        return dataCreatUserNum;
    }

    public void setDataCreatUserNum(String dataCreatUserNum) {
        this.dataCreatUserNum = dataCreatUserNum == null ? null : dataCreatUserNum.trim();
    }

    public String getDataCreatorOrgCd() {
        return dataCreatorOrgCd;
    }

    public void setDataCreatorOrgCd(String dataCreatorOrgCd) {
        this.dataCreatorOrgCd = dataCreatorOrgCd == null ? null : dataCreatorOrgCd.trim();
    }

    public String getLastUpdateUserNum() {
        return lastUpdateUserNum;
    }

    public void setLastUpdateUserNum(String lastUpdateUserNum) {
        this.lastUpdateUserNum = lastUpdateUserNum == null ? null : lastUpdateUserNum.trim();
    }

    public String getLastUpdateOrgCd() {
        return lastUpdateOrgCd;
    }

    public void setLastUpdateOrgCd(String lastUpdateOrgCd) {
        this.lastUpdateOrgCd = lastUpdateOrgCd == null ? null : lastUpdateOrgCd.trim();
    }

    public String getTakeoverInd() {
        return takeoverInd;
    }

    public void setTakeoverInd(String takeoverInd) {
        this.takeoverInd = takeoverInd == null ? null : takeoverInd.trim();
    }

    public String getAllPledgeInd() {
        return allPledgeInd;
    }

    public void setAllPledgeInd(String allPledgeInd) {
        this.allPledgeInd = allPledgeInd == null ? null : allPledgeInd.trim();
    }

    public String getForbidCirculateInd() {
        return forbidCirculateInd;
    }

    public void setForbidCirculateInd(String forbidCirculateInd) {
        this.forbidCirculateInd = forbidCirculateInd == null ? null : forbidCirculateInd.trim();
    }

    public String getNationalisationInd() {
        return nationalisationInd;
    }

    public void setNationalisationInd(String nationalisationInd) {
        this.nationalisationInd = nationalisationInd == null ? null : nationalisationInd.trim();
    }

    public String getPropertyDisputedInd() {
        return propertyDisputedInd;
    }

    public void setPropertyDisputedInd(String propertyDisputedInd) {
        this.propertyDisputedInd = propertyDisputedInd == null ? null : propertyDisputedInd.trim();
    }

    public String getInvalidInd() {
        return invalidInd;
    }

    public void setInvalidInd(String invalidInd) {
        this.invalidInd = invalidInd == null ? null : invalidInd.trim();
    }

    public String getBlemishInd() {
        return blemishInd;
    }

    public void setBlemishInd(String blemishInd) {
        this.blemishInd = blemishInd == null ? null : blemishInd.trim();
    }

    public String getMpType() {
        return mpType;
    }

    public void setMpType(String mpType) {
        this.mpType = mpType == null ? null : mpType.trim();
    }

    public String getBlemishNote() {
        return blemishNote;
    }

    public void setBlemishNote(String blemishNote) {
        this.blemishNote = blemishNote == null ? null : blemishNote.trim();
    }

    public Date getHandoverDate() {
        return handoverDate;
    }

    public void setHandoverDate(Date handoverDate) {
        this.handoverDate = handoverDate;
    }

    public String getK75zcms() {
        return k75zcms;
    }

    public void setK75zcms(String k75zcms) {
        this.k75zcms = k75zcms == null ? null : k75zcms.trim();
    }

    public String getKeepSpecialReq() {
        return keepSpecialReq;
    }

    public void setKeepSpecialReq(String keepSpecialReq) {
        this.keepSpecialReq = keepSpecialReq == null ? null : keepSpecialReq.trim();
    }

    public String getValuator() {
        return valuator;
    }

    public void setValuator(String valuator) {
        this.valuator = valuator == null ? null : valuator.trim();
    }

    public Date getEvaluateDate() {
        return evaluateDate;
    }

    public void setEvaluateDate(Date evaluateDate) {
        this.evaluateDate = evaluateDate;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus == null ? null : assetStatus.trim();
    }
    @JSONField(name="客户类型")
    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType == null ? null : customerType.trim();
    }

    public String getSettledAssetsInd() {
        return settledAssetsInd;
    }

    public void setSettledAssetsInd(String settledAssetsInd) {
        this.settledAssetsInd = settledAssetsInd == null ? null : settledAssetsInd.trim();
    }

    public Date getTimeMark() {
        return timeMark;
    }

    public void setTimeMark(Date timeMark) {
        this.timeMark = timeMark;
    }

    public BigDecimal getImpawnAmount() {
        return impawnAmount;
    }

    public void setImpawnAmount(BigDecimal impawnAmount) {
        this.impawnAmount = impawnAmount;
    }

    public String getImpawnAmountCd() {
        return impawnAmountCd;
    }

    public void setImpawnAmountCd(String impawnAmountCd) {
        this.impawnAmountCd = impawnAmountCd == null ? null : impawnAmountCd.trim();
    }

    public Date getImpawnExpireDate() {
        return impawnExpireDate;
    }

    public void setImpawnExpireDate(Date impawnExpireDate) {
        this.impawnExpireDate = impawnExpireDate;
    }

    public Date getImpawnGetDate() {
        return impawnGetDate;
    }

    public void setImpawnGetDate(Date impawnGetDate) {
        this.impawnGetDate = impawnGetDate;
    }

    public String getRegisterInd() {
        return registerInd;
    }

    public void setRegisterInd(String registerInd) {
        this.registerInd = registerInd == null ? null : registerInd.trim();
    }

    public String getCollateralCardDepartment() {
        return collateralCardDepartment;
    }

    public void setCollateralCardDepartment(String collateralCardDepartment) {
        this.collateralCardDepartment = collateralCardDepartment == null ? null : collateralCardDepartment.trim();
    }

    public String getIsStateAsset() {
        return isStateAsset;
    }

    public void setIsStateAsset(String isStateAsset) {
        this.isStateAsset = isStateAsset == null ? null : isStateAsset.trim();
    }

    public String getIsStateSectorApproval() {
        return isStateSectorApproval;
    }

    public void setIsStateSectorApproval(String isStateSectorApproval) {
        this.isStateSectorApproval = isStateSectorApproval == null ? null : isStateSectorApproval.trim();
    }

    public String getIsMortgageAllAsset() {
        return isMortgageAllAsset;
    }

    public void setIsMortgageAllAsset(String isMortgageAllAsset) {
        this.isMortgageAllAsset = isMortgageAllAsset == null ? null : isMortgageAllAsset.trim();
    }

    public String getSettledSource() {
        return settledSource;
    }

    public void setSettledSource(String settledSource) {
        this.settledSource = settledSource == null ? null : settledSource.trim();
    }

    public String getAssetsSourceBackup() {
        return assetsSourceBackup;
    }

    public void setAssetsSourceBackup(String assetsSourceBackup) {
        this.assetsSourceBackup = assetsSourceBackup == null ? null : assetsSourceBackup.trim();
    }

    public String getCollateralSeq() {
        return collateralSeq;
    }

    public void setCollateralSeq(String collateralSeq) {
        this.collateralSeq = collateralSeq == null ? null : collateralSeq.trim();
    }

	@Override
	public String toString() {
		return "GrtCollateral [guarantyId=" + guarantyId + ", collateralTypeCd=" + collateralTypeCd + ", partyTypeCd="
				+ partyTypeCd + ", collateralNum=" + collateralNum + ", collateralStatusCd=" + collateralStatusCd
				+ ", collateralName=" + collateralName + ", bookValue=" + bookValue + ", bookNetValue=" + bookNetValue
				+ ", marketValue=" + marketValue + ", evalValueCurrencyCd=" + evalValueCurrencyCd + ", evalValue="
				+ evalValue + ", ccbAssessedValueCurrencyCd=" + ccbAssessedValueCurrencyCd + ", ccbAssessedValue="
				+ ccbAssessedValue + ", acquireWayOfCollateralCd=" + acquireWayOfCollateralCd + ", commonAssetsInd="
				+ commonAssetsInd + ", commonOwnerName=" + commonOwnerName + ", wayGuarantyEffectiveCd="
				+ wayGuarantyEffectiveCd + ", collateralSetupInd=" + collateralSetupInd + ", setGuarantyAmtInCcb="
				+ setGuarantyAmtInCcb + ", rentedLicensedInd=" + rentedLicensedInd + ", renterName=" + renterName
				+ ", setGuarantyAmtOutCcb=" + setGuarantyAmtOutCcb + ", leaseExpirationDate=" + leaseExpirationDate
				+ ", customerNum=" + customerNum + ", submittingDate=" + submittingDate + ", currencyCd=" + currencyCd
				+ ", collateralDispose=" + collateralDispose + ", otherNote=" + otherNote + ", setGuarantyAmt="
				+ setGuarantyAmt + ", provinceCd=" + provinceCd + ", cityCd=" + cityCd + ", districtCd=" + districtCd
				+ ", streetAddress=" + streetAddress + ", nationalityCd=" + nationalityCd + ", merchandiseType="
				+ merchandiseType + ", rightCertTypeCd=" + rightCertTypeCd + ", rightCertificationNum="
				+ rightCertificationNum + ", sysUpdateTime=" + sysUpdateTime + ", collateralCatalogCd="
				+ collateralCatalogCd + ", dataCreatUserNum=" + dataCreatUserNum + ", dataCreatorOrgCd="
				+ dataCreatorOrgCd + ", lastUpdateUserNum=" + lastUpdateUserNum + ", lastUpdateOrgCd=" + lastUpdateOrgCd
				+ ", takeoverInd=" + takeoverInd + ", allPledgeInd=" + allPledgeInd + ", forbidCirculateInd="
				+ forbidCirculateInd + ", nationalisationInd=" + nationalisationInd + ", propertyDisputedInd="
				+ propertyDisputedInd + ", invalidInd=" + invalidInd + ", blemishInd=" + blemishInd + ", mpType="
				+ mpType + ", blemishNote=" + blemishNote + ", handoverDate=" + handoverDate + ", k75zcms=" + k75zcms
				+ ", keepSpecialReq=" + keepSpecialReq + ", valuator=" + valuator + ", evaluateDate=" + evaluateDate
				+ ", assetStatus=" + assetStatus + ", customerType=" + customerType + ", settledAssetsInd="
				+ settledAssetsInd + ", timeMark=" + timeMark + ", impawnAmount=" + impawnAmount + ", impawnAmountCd="
				+ impawnAmountCd + ", impawnExpireDate=" + impawnExpireDate + ", impawnGetDate=" + impawnGetDate
				+ ", registerInd=" + registerInd + ", collateralCardDepartment=" + collateralCardDepartment
				+ ", isStateAsset=" + isStateAsset + ", isStateSectorApproval=" + isStateSectorApproval
				+ ", isMortgageAllAsset=" + isMortgageAllAsset + ", settledSource=" + settledSource
				+ ", assetsSourceBackup=" + assetsSourceBackup + ", collateralSeq=" + collateralSeq + "]";
	}
    
}