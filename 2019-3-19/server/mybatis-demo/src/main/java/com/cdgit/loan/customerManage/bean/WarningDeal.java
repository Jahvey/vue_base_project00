package com.cdgit.loan.customerManage.bean;

import java.util.Date;

public class WarningDeal {
    private String warnNo;

    private String ruleNo;

    private String ecifCustNum;

    private String warnType;

    private String warnDate;

    private String warnInfo;

    private String warnLevel;

    private String warnStatus;

    private String closeFlag;

    private String closeReason;

    private Date closeDate;

    private String closeUser;

    private String closeOrg;

    private Date validDate;

    private String remark;
    
    //查询字段
    private String ruleAbstract;
    
    private String stopFlag;


    public String getRuleAbstract() {
		return ruleAbstract;
	}

	public void setRuleAbstract(String ruleAbstract) {
		this.ruleAbstract = ruleAbstract;
	}

	public String getStopFlag() {
		return stopFlag;
	}

	public void setStopFlag(String stopFlag) {
		this.stopFlag = stopFlag;
	}

	public String getWarnNo() {
        return warnNo;
    }

    public void setWarnNo(String warnNo) {
        this.warnNo = warnNo == null ? null : warnNo.trim();
    }

    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo == null ? null : ruleNo.trim();
    }

    public String getEcifCustNum() {
        return ecifCustNum;
    }

    public void setEcifCustNum(String ecifCustNum) {
        this.ecifCustNum = ecifCustNum == null ? null : ecifCustNum.trim();
    }

    public String getWarnType() {
        return warnType;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType == null ? null : warnType.trim();
    }

    public String getWarnDate() {
        return warnDate;
    }

    public void setWarnDate(String warnDate) {
        this.warnDate = warnDate == null ? null : warnDate.trim();
    }

    public String getWarnInfo() {
        return warnInfo;
    }

    public void setWarnInfo(String warnInfo) {
        this.warnInfo = warnInfo == null ? null : warnInfo.trim();
    }

    public String getWarnLevel() {
        return warnLevel;
    }

    public void setWarnLevel(String warnLevel) {
        this.warnLevel = warnLevel == null ? null : warnLevel.trim();
    }

    public String getWarnStatus() {
        return warnStatus;
    }

    public void setWarnStatus(String warnStatus) {
        this.warnStatus = warnStatus == null ? null : warnStatus.trim();
    }

    public String getCloseFlag() {
        return closeFlag;
    }

    public void setCloseFlag(String closeFlag) {
        this.closeFlag = closeFlag == null ? null : closeFlag.trim();
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason == null ? null : closeReason.trim();
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getCloseUser() {
        return closeUser;
    }

    public void setCloseUser(String closeUser) {
        this.closeUser = closeUser == null ? null : closeUser.trim();
    }

    public String getCloseOrg() {
        return closeOrg;
    }

    public void setCloseOrg(String closeOrg) {
        this.closeOrg = closeOrg == null ? null : closeOrg.trim();
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        WarningDeal other = (WarningDeal) that;
        return (this.getWarnNo() == null ? other.getWarnNo() == null : this.getWarnNo().equals(other.getWarnNo()))
            && (this.getRuleNo() == null ? other.getRuleNo() == null : this.getRuleNo().equals(other.getRuleNo()))
            && (this.getEcifCustNum() == null ? other.getEcifCustNum() == null : this.getEcifCustNum().equals(other.getEcifCustNum()))
            && (this.getWarnType() == null ? other.getWarnType() == null : this.getWarnType().equals(other.getWarnType()))
            && (this.getWarnDate() == null ? other.getWarnDate() == null : this.getWarnDate().equals(other.getWarnDate()))
            && (this.getWarnInfo() == null ? other.getWarnInfo() == null : this.getWarnInfo().equals(other.getWarnInfo()))
            && (this.getWarnLevel() == null ? other.getWarnLevel() == null : this.getWarnLevel().equals(other.getWarnLevel()))
            && (this.getWarnStatus() == null ? other.getWarnStatus() == null : this.getWarnStatus().equals(other.getWarnStatus()))
            && (this.getCloseFlag() == null ? other.getCloseFlag() == null : this.getCloseFlag().equals(other.getCloseFlag()))
            && (this.getCloseReason() == null ? other.getCloseReason() == null : this.getCloseReason().equals(other.getCloseReason()))
            && (this.getCloseDate() == null ? other.getCloseDate() == null : this.getCloseDate().equals(other.getCloseDate()))
            && (this.getCloseUser() == null ? other.getCloseUser() == null : this.getCloseUser().equals(other.getCloseUser()))
            && (this.getCloseOrg() == null ? other.getCloseOrg() == null : this.getCloseOrg().equals(other.getCloseOrg()))
            && (this.getValidDate() == null ? other.getValidDate() == null : this.getValidDate().equals(other.getValidDate()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWarnNo() == null) ? 0 : getWarnNo().hashCode());
        result = prime * result + ((getRuleNo() == null) ? 0 : getRuleNo().hashCode());
        result = prime * result + ((getEcifCustNum() == null) ? 0 : getEcifCustNum().hashCode());
        result = prime * result + ((getWarnType() == null) ? 0 : getWarnType().hashCode());
        result = prime * result + ((getWarnDate() == null) ? 0 : getWarnDate().hashCode());
        result = prime * result + ((getWarnInfo() == null) ? 0 : getWarnInfo().hashCode());
        result = prime * result + ((getWarnLevel() == null) ? 0 : getWarnLevel().hashCode());
        result = prime * result + ((getWarnStatus() == null) ? 0 : getWarnStatus().hashCode());
        result = prime * result + ((getCloseFlag() == null) ? 0 : getCloseFlag().hashCode());
        result = prime * result + ((getCloseReason() == null) ? 0 : getCloseReason().hashCode());
        result = prime * result + ((getCloseDate() == null) ? 0 : getCloseDate().hashCode());
        result = prime * result + ((getCloseUser() == null) ? 0 : getCloseUser().hashCode());
        result = prime * result + ((getCloseOrg() == null) ? 0 : getCloseOrg().hashCode());
        result = prime * result + ((getValidDate() == null) ? 0 : getValidDate().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}