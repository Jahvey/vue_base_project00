/**
 * 
 */
package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 *
 */
public class TbGrtMortgageBasicPo {
	
	  private String suretyId;

	    private String suretyNo;

	    private String partyId;

	    private String sortType;

	    private String collType;

	    private String assessForm;

	    private Date assessDate;

	    private Date assessEndDate;

	    private String currencyCd;

	    private BigDecimal assessValue;

	    private BigDecimal mortgageValue;

	    private BigDecimal mybankSetValue;

	    private String ifOtherCommon;

	    private String mortgageStatus;

	    private String mortgageGainWay;

	    private String cashAbility;

	    private String mortgageMobility;

	    private String orgNum;

	    private String userNum;

	    private Date createTime;

	    private Date updateTime;

	    private BigDecimal mybankAffirmValue;

	    private BigDecimal suretyAmt;

	    private BigDecimal mortgageRate;

	    private BigDecimal totalAmt;

	    private BigDecimal aviAmt;

	    private String ifDataMove;

	    private String ownershipNum;

	    private String insuranceCondition;

	    private String insuranceCompany;

	    private String insuranceNum;

	    private String suretyName;

	    private String transFlag;

	    private BigDecimal mortgagaAmt;

	    private String isDoneZykh;

	    private BigDecimal totalKhAmt;

	    public String getSuretyId() {
	        return suretyId;
	    }

	    public void setSuretyId(String suretyId) {
	        this.suretyId = suretyId == null ? null : suretyId.trim();
	    }

	    public String getSuretyNo() {
	        return suretyNo;
	    }

	    public void setSuretyNo(String suretyNo) {
	        this.suretyNo = suretyNo == null ? null : suretyNo.trim();
	    }

	    public String getPartyId() {
	        return partyId;
	    }

	    public void setPartyId(String partyId) {
	        this.partyId = partyId == null ? null : partyId.trim();
	    }

	    public String getSortType() {
	        return sortType;
	    }

	    public void setSortType(String sortType) {
	        this.sortType = sortType == null ? null : sortType.trim();
	    }

	    public String getCollType() {
	        return collType;
	    }

	    public void setCollType(String collType) {
	        this.collType = collType == null ? null : collType.trim();
	    }

	    public String getAssessForm() {
	        return assessForm;
	    }

	    public void setAssessForm(String assessForm) {
	        this.assessForm = assessForm == null ? null : assessForm.trim();
	    }

	    public Date getAssessDate() {
	        return assessDate;
	    }

	    public void setAssessDate(Date assessDate) {
	        this.assessDate = assessDate;
	    }

	    public Date getAssessEndDate() {
	        return assessEndDate;
	    }

	    public void setAssessEndDate(Date assessEndDate) {
	        this.assessEndDate = assessEndDate;
	    }

	    public String getCurrencyCd() {
	        return currencyCd;
	    }

	    public void setCurrencyCd(String currencyCd) {
	        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
	    }

	    public BigDecimal getAssessValue() {
	        return assessValue;
	    }

	    public void setAssessValue(BigDecimal assessValue) {
	        this.assessValue = assessValue;
	    }

	    public BigDecimal getMortgageValue() {
	        return mortgageValue;
	    }

	    public void setMortgageValue(BigDecimal mortgageValue) {
	        this.mortgageValue = mortgageValue;
	    }

	    public BigDecimal getMybankSetValue() {
	        return mybankSetValue;
	    }

	    public void setMybankSetValue(BigDecimal mybankSetValue) {
	        this.mybankSetValue = mybankSetValue;
	    }

	    public String getIfOtherCommon() {
	        return ifOtherCommon;
	    }

	    public void setIfOtherCommon(String ifOtherCommon) {
	        this.ifOtherCommon = ifOtherCommon == null ? null : ifOtherCommon.trim();
	    }

	    public String getMortgageStatus() {
	        return mortgageStatus;
	    }

	    public void setMortgageStatus(String mortgageStatus) {
	        this.mortgageStatus = mortgageStatus == null ? null : mortgageStatus.trim();
	    }

	    public String getMortgageGainWay() {
	        return mortgageGainWay;
	    }

	    public void setMortgageGainWay(String mortgageGainWay) {
	        this.mortgageGainWay = mortgageGainWay == null ? null : mortgageGainWay.trim();
	    }

	    public String getCashAbility() {
	        return cashAbility;
	    }

	    public void setCashAbility(String cashAbility) {
	        this.cashAbility = cashAbility == null ? null : cashAbility.trim();
	    }

	    public String getMortgageMobility() {
	        return mortgageMobility;
	    }

	    public void setMortgageMobility(String mortgageMobility) {
	        this.mortgageMobility = mortgageMobility == null ? null : mortgageMobility.trim();
	    }

	    public String getOrgNum() {
	        return orgNum;
	    }

	    public void setOrgNum(String orgNum) {
	        this.orgNum = orgNum == null ? null : orgNum.trim();
	    }

	    public String getUserNum() {
	        return userNum;
	    }

	    public void setUserNum(String userNum) {
	        this.userNum = userNum == null ? null : userNum.trim();
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

	    public BigDecimal getMybankAffirmValue() {
	        return mybankAffirmValue;
	    }

	    public void setMybankAffirmValue(BigDecimal mybankAffirmValue) {
	        this.mybankAffirmValue = mybankAffirmValue;
	    }

	    public BigDecimal getSuretyAmt() {
	        return suretyAmt;
	    }

	    public void setSuretyAmt(BigDecimal suretyAmt) {
	        this.suretyAmt = suretyAmt;
	    }

	    public BigDecimal getMortgageRate() {
	        return mortgageRate;
	    }

	    public void setMortgageRate(BigDecimal mortgageRate) {
	        this.mortgageRate = mortgageRate;
	    }

	    public BigDecimal getTotalAmt() {
	        return totalAmt;
	    }

	    public void setTotalAmt(BigDecimal totalAmt) {
	        this.totalAmt = totalAmt;
	    }

	    public BigDecimal getAviAmt() {
	        return aviAmt;
	    }

	    public void setAviAmt(BigDecimal aviAmt) {
	        this.aviAmt = aviAmt;
	    }

	    public String getIfDataMove() {
	        return ifDataMove;
	    }

	    public void setIfDataMove(String ifDataMove) {
	        this.ifDataMove = ifDataMove == null ? null : ifDataMove.trim();
	    }

	    public String getOwnershipNum() {
	        return ownershipNum;
	    }

	    public void setOwnershipNum(String ownershipNum) {
	        this.ownershipNum = ownershipNum == null ? null : ownershipNum.trim();
	    }

	    public String getInsuranceCondition() {
	        return insuranceCondition;
	    }

	    public void setInsuranceCondition(String insuranceCondition) {
	        this.insuranceCondition = insuranceCondition == null ? null : insuranceCondition.trim();
	    }

	    public String getInsuranceCompany() {
	        return insuranceCompany;
	    }

	    public void setInsuranceCompany(String insuranceCompany) {
	        this.insuranceCompany = insuranceCompany == null ? null : insuranceCompany.trim();
	    }

	    public String getInsuranceNum() {
	        return insuranceNum;
	    }

	    public void setInsuranceNum(String insuranceNum) {
	        this.insuranceNum = insuranceNum == null ? null : insuranceNum.trim();
	    }

	    public String getSuretyName() {
	        return suretyName;
	    }

	    public void setSuretyName(String suretyName) {
	        this.suretyName = suretyName == null ? null : suretyName.trim();
	    }

	    public String getTransFlag() {
	        return transFlag;
	    }

	    public void setTransFlag(String transFlag) {
	        this.transFlag = transFlag == null ? null : transFlag.trim();
	    }

	    public BigDecimal getMortgagaAmt() {
	        return mortgagaAmt;
	    }

	    public void setMortgagaAmt(BigDecimal mortgagaAmt) {
	        this.mortgagaAmt = mortgagaAmt;
	    }

	    public String getIsDoneZykh() {
	        return isDoneZykh;
	    }

	    public void setIsDoneZykh(String isDoneZykh) {
	        this.isDoneZykh = isDoneZykh == null ? null : isDoneZykh.trim();
	    }

	    public BigDecimal getTotalKhAmt() {
	        return totalKhAmt;
	    }

	    public void setTotalKhAmt(BigDecimal totalKhAmt) {
	        this.totalKhAmt = totalKhAmt;
	    }

		@Override
		public String toString() {
			return "TbGrtMortgageBasicPo [suretyId=" + suretyId + ", suretyNo=" + suretyNo + ", partyId=" + partyId
					+ ", sortType=" + sortType + ", collType=" + collType + ", assessForm=" + assessForm
					+ ", assessDate=" + assessDate + ", assessEndDate=" + assessEndDate + ", currencyCd=" + currencyCd
					+ ", assessValue=" + assessValue + ", mortgageValue=" + mortgageValue + ", mybankSetValue="
					+ mybankSetValue + ", ifOtherCommon=" + ifOtherCommon + ", mortgageStatus=" + mortgageStatus
					+ ", mortgageGainWay=" + mortgageGainWay + ", cashAbility=" + cashAbility + ", mortgageMobility="
					+ mortgageMobility + ", orgNum=" + orgNum + ", userNum=" + userNum + ", createTime=" + createTime
					+ ", updateTime=" + updateTime + ", mybankAffirmValue=" + mybankAffirmValue + ", suretyAmt="
					+ suretyAmt + ", mortgageRate=" + mortgageRate + ", totalAmt=" + totalAmt + ", aviAmt=" + aviAmt
					+ ", ifDataMove=" + ifDataMove + ", ownershipNum=" + ownershipNum + ", insuranceCondition="
					+ insuranceCondition + ", insuranceCompany=" + insuranceCompany + ", insuranceNum=" + insuranceNum
					+ ", suretyName=" + suretyName + ", transFlag=" + transFlag + ", mortgagaAmt=" + mortgagaAmt
					+ ", isDoneZykh=" + isDoneZykh + ", totalKhAmt=" + totalKhAmt + "]";
		}
	    
	    
	
	

	

}
