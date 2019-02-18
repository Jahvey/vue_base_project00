package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 再建工程Mapper
 * @author wuyong
 * @date 2018.1.3
 *
 */
public class GrtBuildingProject {
    private String guarantyId;

    private String landFour;

    private String projectPurpose;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal buildedArea;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal investBudget;

    private String proOriDesignSizeCd;

    private String proProcess;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal finishedMoney;

    private String projectPresentStatus;

    private String buildUnit;

    private String proPlanLicInd;

    private String startWorkLicInd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal patchLandMoney;

    private String k58pwh;

    private String k58jsxk;

    private String k58tdxk;

    private String k58kgxkzh;

    private String k58xmxzyjs;

    private String k58ysxkzh;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date k58begdate;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date k58enddate;

    private String k58szd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal k58ydmj;

    private String k58zyyt;

    private String k58bzsm;

    private String landUseNumber;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal costOfBudget;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal mortgageArea;

    private String isPaymentArrears;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal arrearsAmt;

    private String isPaymentLandTransfer;

    private String isHasLandLicense;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getLandFour() {
        return landFour;
    }

    public void setLandFour(String landFour) {
        this.landFour = landFour == null ? null : landFour.trim();
    }

    public String getProjectPurpose() {
        return projectPurpose;
    }

    public void setProjectPurpose(String projectPurpose) {
        this.projectPurpose = projectPurpose == null ? null : projectPurpose.trim();
    }

    public BigDecimal getBuildedArea() {
        return buildedArea;
    }

    public void setBuildedArea(BigDecimal buildedArea) {
        this.buildedArea = buildedArea;
    }

    public BigDecimal getInvestBudget() {
        return investBudget;
    }

    public void setInvestBudget(BigDecimal investBudget) {
        this.investBudget = investBudget;
    }

    public String getProOriDesignSizeCd() {
        return proOriDesignSizeCd;
    }

    public void setProOriDesignSizeCd(String proOriDesignSizeCd) {
        this.proOriDesignSizeCd = proOriDesignSizeCd == null ? null : proOriDesignSizeCd.trim();
    }

    public String getProProcess() {
        return proProcess;
    }

    public void setProProcess(String proProcess) {
        this.proProcess = proProcess == null ? null : proProcess.trim();
    }

    public BigDecimal getFinishedMoney() {
        return finishedMoney;
    }

    public void setFinishedMoney(BigDecimal finishedMoney) {
        this.finishedMoney = finishedMoney;
    }

    public String getProjectPresentStatus() {
        return projectPresentStatus;
    }

    public void setProjectPresentStatus(String projectPresentStatus) {
        this.projectPresentStatus = projectPresentStatus == null ? null : projectPresentStatus.trim();
    }

    public String getBuildUnit() {
        return buildUnit;
    }

    public void setBuildUnit(String buildUnit) {
        this.buildUnit = buildUnit == null ? null : buildUnit.trim();
    }

    public String getProPlanLicInd() {
        return proPlanLicInd;
    }

    public void setProPlanLicInd(String proPlanLicInd) {
        this.proPlanLicInd = proPlanLicInd == null ? null : proPlanLicInd.trim();
    }

    public String getStartWorkLicInd() {
        return startWorkLicInd;
    }

    public void setStartWorkLicInd(String startWorkLicInd) {
        this.startWorkLicInd = startWorkLicInd == null ? null : startWorkLicInd.trim();
    }

    public BigDecimal getPatchLandMoney() {
        return patchLandMoney;
    }

    public void setPatchLandMoney(BigDecimal patchLandMoney) {
        this.patchLandMoney = patchLandMoney;
    }

    public String getK58pwh() {
        return k58pwh;
    }

    public void setK58pwh(String k58pwh) {
        this.k58pwh = k58pwh == null ? null : k58pwh.trim();
    }

    public String getK58jsxk() {
        return k58jsxk;
    }

    public void setK58jsxk(String k58jsxk) {
        this.k58jsxk = k58jsxk == null ? null : k58jsxk.trim();
    }

    public String getK58tdxk() {
        return k58tdxk;
    }

    public void setK58tdxk(String k58tdxk) {
        this.k58tdxk = k58tdxk == null ? null : k58tdxk.trim();
    }

    public String getK58kgxkzh() {
        return k58kgxkzh;
    }

    public void setK58kgxkzh(String k58kgxkzh) {
        this.k58kgxkzh = k58kgxkzh == null ? null : k58kgxkzh.trim();
    }

    public String getK58xmxzyjs() {
        return k58xmxzyjs;
    }

    public void setK58xmxzyjs(String k58xmxzyjs) {
        this.k58xmxzyjs = k58xmxzyjs == null ? null : k58xmxzyjs.trim();
    }

    public String getK58ysxkzh() {
        return k58ysxkzh;
    }

    public void setK58ysxkzh(String k58ysxkzh) {
        this.k58ysxkzh = k58ysxkzh == null ? null : k58ysxkzh.trim();
    }

    public Date getK58begdate() {
        return k58begdate;
    }

    public void setK58begdate(Date k58begdate) {
        this.k58begdate = k58begdate;
    }

    public Date getK58enddate() {
        return k58enddate;
    }

    public void setK58enddate(Date k58enddate) {
        this.k58enddate = k58enddate;
    }

    public String getK58szd() {
        return k58szd;
    }

    public void setK58szd(String k58szd) {
        this.k58szd = k58szd == null ? null : k58szd.trim();
    }

    public BigDecimal getK58ydmj() {
        return k58ydmj;
    }

    public void setK58ydmj(BigDecimal k58ydmj) {
        this.k58ydmj = k58ydmj;
    }

    public String getK58zyyt() {
        return k58zyyt;
    }

    public void setK58zyyt(String k58zyyt) {
        this.k58zyyt = k58zyyt == null ? null : k58zyyt.trim();
    }

    public String getK58bzsm() {
        return k58bzsm;
    }

    public void setK58bzsm(String k58bzsm) {
        this.k58bzsm = k58bzsm == null ? null : k58bzsm.trim();
    }

    public String getLandUseNumber() {
        return landUseNumber;
    }

    public void setLandUseNumber(String landUseNumber) {
        this.landUseNumber = landUseNumber == null ? null : landUseNumber.trim();
    }

    public BigDecimal getCostOfBudget() {
        return costOfBudget;
    }

    public void setCostOfBudget(BigDecimal costOfBudget) {
        this.costOfBudget = costOfBudget;
    }

    public BigDecimal getMortgageArea() {
        return mortgageArea;
    }

    public void setMortgageArea(BigDecimal mortgageArea) {
        this.mortgageArea = mortgageArea;
    }

    public String getIsPaymentArrears() {
        return isPaymentArrears;
    }

    public void setIsPaymentArrears(String isPaymentArrears) {
        this.isPaymentArrears = isPaymentArrears == null ? null : isPaymentArrears.trim();
    }

    public BigDecimal getArrearsAmt() {
        return arrearsAmt;
    }

    public void setArrearsAmt(BigDecimal arrearsAmt) {
        this.arrearsAmt = arrearsAmt;
    }

    public String getIsPaymentLandTransfer() {
        return isPaymentLandTransfer;
    }

    public void setIsPaymentLandTransfer(String isPaymentLandTransfer) {
        this.isPaymentLandTransfer = isPaymentLandTransfer == null ? null : isPaymentLandTransfer.trim();
    }

    public String getIsHasLandLicense() {
        return isHasLandLicense;
    }

    public void setIsHasLandLicense(String isHasLandLicense) {
        this.isHasLandLicense = isHasLandLicense == null ? null : isHasLandLicense.trim();
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
        GrtBuildingProject other = (GrtBuildingProject) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getLandFour() == null ? other.getLandFour() == null : this.getLandFour().equals(other.getLandFour()))
            && (this.getProjectPurpose() == null ? other.getProjectPurpose() == null : this.getProjectPurpose().equals(other.getProjectPurpose()))
            && (this.getBuildedArea() == null ? other.getBuildedArea() == null : this.getBuildedArea().equals(other.getBuildedArea()))
            && (this.getInvestBudget() == null ? other.getInvestBudget() == null : this.getInvestBudget().equals(other.getInvestBudget()))
            && (this.getProOriDesignSizeCd() == null ? other.getProOriDesignSizeCd() == null : this.getProOriDesignSizeCd().equals(other.getProOriDesignSizeCd()))
            && (this.getProProcess() == null ? other.getProProcess() == null : this.getProProcess().equals(other.getProProcess()))
            && (this.getFinishedMoney() == null ? other.getFinishedMoney() == null : this.getFinishedMoney().equals(other.getFinishedMoney()))
            && (this.getProjectPresentStatus() == null ? other.getProjectPresentStatus() == null : this.getProjectPresentStatus().equals(other.getProjectPresentStatus()))
            && (this.getBuildUnit() == null ? other.getBuildUnit() == null : this.getBuildUnit().equals(other.getBuildUnit()))
            && (this.getProPlanLicInd() == null ? other.getProPlanLicInd() == null : this.getProPlanLicInd().equals(other.getProPlanLicInd()))
            && (this.getStartWorkLicInd() == null ? other.getStartWorkLicInd() == null : this.getStartWorkLicInd().equals(other.getStartWorkLicInd()))
            && (this.getPatchLandMoney() == null ? other.getPatchLandMoney() == null : this.getPatchLandMoney().equals(other.getPatchLandMoney()))
            && (this.getK58pwh() == null ? other.getK58pwh() == null : this.getK58pwh().equals(other.getK58pwh()))
            && (this.getK58jsxk() == null ? other.getK58jsxk() == null : this.getK58jsxk().equals(other.getK58jsxk()))
            && (this.getK58tdxk() == null ? other.getK58tdxk() == null : this.getK58tdxk().equals(other.getK58tdxk()))
            && (this.getK58kgxkzh() == null ? other.getK58kgxkzh() == null : this.getK58kgxkzh().equals(other.getK58kgxkzh()))
            && (this.getK58xmxzyjs() == null ? other.getK58xmxzyjs() == null : this.getK58xmxzyjs().equals(other.getK58xmxzyjs()))
            && (this.getK58ysxkzh() == null ? other.getK58ysxkzh() == null : this.getK58ysxkzh().equals(other.getK58ysxkzh()))
            && (this.getK58begdate() == null ? other.getK58begdate() == null : this.getK58begdate().equals(other.getK58begdate()))
            && (this.getK58enddate() == null ? other.getK58enddate() == null : this.getK58enddate().equals(other.getK58enddate()))
            && (this.getK58szd() == null ? other.getK58szd() == null : this.getK58szd().equals(other.getK58szd()))
            && (this.getK58ydmj() == null ? other.getK58ydmj() == null : this.getK58ydmj().equals(other.getK58ydmj()))
            && (this.getK58zyyt() == null ? other.getK58zyyt() == null : this.getK58zyyt().equals(other.getK58zyyt()))
            && (this.getK58bzsm() == null ? other.getK58bzsm() == null : this.getK58bzsm().equals(other.getK58bzsm()))
            && (this.getLandUseNumber() == null ? other.getLandUseNumber() == null : this.getLandUseNumber().equals(other.getLandUseNumber()))
            && (this.getCostOfBudget() == null ? other.getCostOfBudget() == null : this.getCostOfBudget().equals(other.getCostOfBudget()))
            && (this.getMortgageArea() == null ? other.getMortgageArea() == null : this.getMortgageArea().equals(other.getMortgageArea()))
            && (this.getIsPaymentArrears() == null ? other.getIsPaymentArrears() == null : this.getIsPaymentArrears().equals(other.getIsPaymentArrears()))
            && (this.getArrearsAmt() == null ? other.getArrearsAmt() == null : this.getArrearsAmt().equals(other.getArrearsAmt()))
            && (this.getIsPaymentLandTransfer() == null ? other.getIsPaymentLandTransfer() == null : this.getIsPaymentLandTransfer().equals(other.getIsPaymentLandTransfer()))
            && (this.getIsHasLandLicense() == null ? other.getIsHasLandLicense() == null : this.getIsHasLandLicense().equals(other.getIsHasLandLicense()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getLandFour() == null) ? 0 : getLandFour().hashCode());
        result = prime * result + ((getProjectPurpose() == null) ? 0 : getProjectPurpose().hashCode());
        result = prime * result + ((getBuildedArea() == null) ? 0 : getBuildedArea().hashCode());
        result = prime * result + ((getInvestBudget() == null) ? 0 : getInvestBudget().hashCode());
        result = prime * result + ((getProOriDesignSizeCd() == null) ? 0 : getProOriDesignSizeCd().hashCode());
        result = prime * result + ((getProProcess() == null) ? 0 : getProProcess().hashCode());
        result = prime * result + ((getFinishedMoney() == null) ? 0 : getFinishedMoney().hashCode());
        result = prime * result + ((getProjectPresentStatus() == null) ? 0 : getProjectPresentStatus().hashCode());
        result = prime * result + ((getBuildUnit() == null) ? 0 : getBuildUnit().hashCode());
        result = prime * result + ((getProPlanLicInd() == null) ? 0 : getProPlanLicInd().hashCode());
        result = prime * result + ((getStartWorkLicInd() == null) ? 0 : getStartWorkLicInd().hashCode());
        result = prime * result + ((getPatchLandMoney() == null) ? 0 : getPatchLandMoney().hashCode());
        result = prime * result + ((getK58pwh() == null) ? 0 : getK58pwh().hashCode());
        result = prime * result + ((getK58jsxk() == null) ? 0 : getK58jsxk().hashCode());
        result = prime * result + ((getK58tdxk() == null) ? 0 : getK58tdxk().hashCode());
        result = prime * result + ((getK58kgxkzh() == null) ? 0 : getK58kgxkzh().hashCode());
        result = prime * result + ((getK58xmxzyjs() == null) ? 0 : getK58xmxzyjs().hashCode());
        result = prime * result + ((getK58ysxkzh() == null) ? 0 : getK58ysxkzh().hashCode());
        result = prime * result + ((getK58begdate() == null) ? 0 : getK58begdate().hashCode());
        result = prime * result + ((getK58enddate() == null) ? 0 : getK58enddate().hashCode());
        result = prime * result + ((getK58szd() == null) ? 0 : getK58szd().hashCode());
        result = prime * result + ((getK58ydmj() == null) ? 0 : getK58ydmj().hashCode());
        result = prime * result + ((getK58zyyt() == null) ? 0 : getK58zyyt().hashCode());
        result = prime * result + ((getK58bzsm() == null) ? 0 : getK58bzsm().hashCode());
        result = prime * result + ((getLandUseNumber() == null) ? 0 : getLandUseNumber().hashCode());
        result = prime * result + ((getCostOfBudget() == null) ? 0 : getCostOfBudget().hashCode());
        result = prime * result + ((getMortgageArea() == null) ? 0 : getMortgageArea().hashCode());
        result = prime * result + ((getIsPaymentArrears() == null) ? 0 : getIsPaymentArrears().hashCode());
        result = prime * result + ((getArrearsAmt() == null) ? 0 : getArrearsAmt().hashCode());
        result = prime * result + ((getIsPaymentLandTransfer() == null) ? 0 : getIsPaymentLandTransfer().hashCode());
        result = prime * result + ((getIsHasLandLicense() == null) ? 0 : getIsHasLandLicense().hashCode());
        return result;
    }

	@Override
	public String toString() {
		return "GrtBuildingProject [guarantyId=" + guarantyId + ", landFour=" + landFour + ", projectPurpose="
				+ projectPurpose + ", buildedArea=" + buildedArea + ", investBudget=" + investBudget
				+ ", proOriDesignSizeCd=" + proOriDesignSizeCd + ", proProcess=" + proProcess + ", finishedMoney="
				+ finishedMoney + ", projectPresentStatus=" + projectPresentStatus + ", buildUnit=" + buildUnit
				+ ", proPlanLicInd=" + proPlanLicInd + ", startWorkLicInd=" + startWorkLicInd + ", patchLandMoney="
				+ patchLandMoney + ", k58pwh=" + k58pwh + ", k58jsxk=" + k58jsxk + ", k58tdxk=" + k58tdxk
				+ ", k58kgxkzh=" + k58kgxkzh + ", k58xmxzyjs=" + k58xmxzyjs + ", k58ysxkzh=" + k58ysxkzh
				+ ", k58begdate=" + k58begdate + ", k58enddate=" + k58enddate + ", k58szd=" + k58szd + ", k58ydmj="
				+ k58ydmj + ", k58zyyt=" + k58zyyt + ", k58bzsm=" + k58bzsm + ", landUseNumber=" + landUseNumber
				+ ", costOfBudget=" + costOfBudget + ", mortgageArea=" + mortgageArea + ", isPaymentArrears="
				+ isPaymentArrears + ", arrearsAmt=" + arrearsAmt + ", isPaymentLandTransfer=" + isPaymentLandTransfer
				+ ", isHasLandLicense=" + isHasLandLicense + "]";
	}
    
}