package com.cdgit.loan.customerManage.illegalRecord.bean;

import java.math.BigDecimal;
import java.util.Date;

public class IllegalRecord extends IllegalRecordKey {
    private String status;

    private String partyId;

    private Date beginDate;

    private Date endDate;

    private String overdueDate;

    private String repayDate;

    private BigDecimal rcvPrn;

    private BigDecimal padUpPrn;

    private BigDecimal rcvNorItr;

    private BigDecimal padUpNorItr;

    private BigDecimal rcvDftItr;

    private BigDecimal padUpDftItr;

    private BigDecimal rcvPnsItr;

    private BigDecimal padUpPnsItr;

    private BigDecimal dftOtdItr;

    private BigDecimal overdueCapi;

    private BigDecimal overdueItr;

    private BigDecimal overduePnsItr;

    private String userNum;

    private String orgNum;

    private Date createTime;

    private Date updateTime;

    private String remark;
    
    //查询字段
    private String partyNum;
    
    private String partyName;
    
    private String contractNum;
    
    private String yqAmt;

    
    public String getPartyNum() {
		return partyNum;
	}

	public void setPartyNum(String partyNum) {
		this.partyNum = partyNum;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public String getYqAmt() {
		return yqAmt;
	}

	public void setYqAmt(String yqAmt) {
		this.yqAmt = yqAmt;
	}

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
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

    public String getOverdueDate() {
        return overdueDate;
    }

    public void setOverdueDate(String overdueDate) {
        this.overdueDate = overdueDate;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public BigDecimal getRcvPrn() {
        return rcvPrn;
    }

    public void setRcvPrn(BigDecimal rcvPrn) {
        this.rcvPrn = rcvPrn;
    }

    public BigDecimal getPadUpPrn() {
        return padUpPrn;
    }

    public void setPadUpPrn(BigDecimal padUpPrn) {
        this.padUpPrn = padUpPrn;
    }

    public BigDecimal getRcvNorItr() {
        return rcvNorItr;
    }

    public void setRcvNorItr(BigDecimal rcvNorItr) {
        this.rcvNorItr = rcvNorItr;
    }

    public BigDecimal getPadUpNorItr() {
        return padUpNorItr;
    }

    public void setPadUpNorItr(BigDecimal padUpNorItr) {
        this.padUpNorItr = padUpNorItr;
    }

    public BigDecimal getRcvDftItr() {
        return rcvDftItr;
    }

    public void setRcvDftItr(BigDecimal rcvDftItr) {
        this.rcvDftItr = rcvDftItr;
    }

    public BigDecimal getPadUpDftItr() {
        return padUpDftItr;
    }

    public void setPadUpDftItr(BigDecimal padUpDftItr) {
        this.padUpDftItr = padUpDftItr;
    }

    public BigDecimal getRcvPnsItr() {
        return rcvPnsItr;
    }

    public void setRcvPnsItr(BigDecimal rcvPnsItr) {
        this.rcvPnsItr = rcvPnsItr;
    }

    public BigDecimal getPadUpPnsItr() {
        return padUpPnsItr;
    }

    public void setPadUpPnsItr(BigDecimal padUpPnsItr) {
        this.padUpPnsItr = padUpPnsItr;
    }

    public BigDecimal getDftOtdItr() {
        return dftOtdItr;
    }

    public void setDftOtdItr(BigDecimal dftOtdItr) {
        this.dftOtdItr = dftOtdItr;
    }

    public BigDecimal getOverdueCapi() {
        return overdueCapi;
    }

    public void setOverdueCapi(BigDecimal overdueCapi) {
        this.overdueCapi = overdueCapi;
    }

    public BigDecimal getOverdueItr() {
        return overdueItr;
    }

    public void setOverdueItr(BigDecimal overdueItr) {
        this.overdueItr = overdueItr;
    }

    public BigDecimal getOverduePnsItr() {
        return overduePnsItr;
    }

    public void setOverduePnsItr(BigDecimal overduePnsItr) {
        this.overduePnsItr = overduePnsItr;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
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
        IllegalRecord other = (IllegalRecord) that;
        return (this.getSummaryNum() == null ? other.getSummaryNum() == null : this.getSummaryNum().equals(other.getSummaryNum()))
            && (this.getCurrPeri() == null ? other.getCurrPeri() == null : this.getCurrPeri().equals(other.getCurrPeri()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getOverdueDate() == null ? other.getOverdueDate() == null : this.getOverdueDate().equals(other.getOverdueDate()))
            && (this.getRepayDate() == null ? other.getRepayDate() == null : this.getRepayDate().equals(other.getRepayDate()))
            && (this.getRcvPrn() == null ? other.getRcvPrn() == null : this.getRcvPrn().equals(other.getRcvPrn()))
            && (this.getPadUpPrn() == null ? other.getPadUpPrn() == null : this.getPadUpPrn().equals(other.getPadUpPrn()))
            && (this.getRcvNorItr() == null ? other.getRcvNorItr() == null : this.getRcvNorItr().equals(other.getRcvNorItr()))
            && (this.getPadUpNorItr() == null ? other.getPadUpNorItr() == null : this.getPadUpNorItr().equals(other.getPadUpNorItr()))
            && (this.getRcvDftItr() == null ? other.getRcvDftItr() == null : this.getRcvDftItr().equals(other.getRcvDftItr()))
            && (this.getPadUpDftItr() == null ? other.getPadUpDftItr() == null : this.getPadUpDftItr().equals(other.getPadUpDftItr()))
            && (this.getRcvPnsItr() == null ? other.getRcvPnsItr() == null : this.getRcvPnsItr().equals(other.getRcvPnsItr()))
            && (this.getPadUpPnsItr() == null ? other.getPadUpPnsItr() == null : this.getPadUpPnsItr().equals(other.getPadUpPnsItr()))
            && (this.getDftOtdItr() == null ? other.getDftOtdItr() == null : this.getDftOtdItr().equals(other.getDftOtdItr()))
            && (this.getOverdueCapi() == null ? other.getOverdueCapi() == null : this.getOverdueCapi().equals(other.getOverdueCapi()))
            && (this.getOverdueItr() == null ? other.getOverdueItr() == null : this.getOverdueItr().equals(other.getOverdueItr()))
            && (this.getOverduePnsItr() == null ? other.getOverduePnsItr() == null : this.getOverduePnsItr().equals(other.getOverduePnsItr()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSummaryNum() == null) ? 0 : getSummaryNum().hashCode());
        result = prime * result + ((getCurrPeri() == null) ? 0 : getCurrPeri().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getOverdueDate() == null) ? 0 : getOverdueDate().hashCode());
        result = prime * result + ((getRepayDate() == null) ? 0 : getRepayDate().hashCode());
        result = prime * result + ((getRcvPrn() == null) ? 0 : getRcvPrn().hashCode());
        result = prime * result + ((getPadUpPrn() == null) ? 0 : getPadUpPrn().hashCode());
        result = prime * result + ((getRcvNorItr() == null) ? 0 : getRcvNorItr().hashCode());
        result = prime * result + ((getPadUpNorItr() == null) ? 0 : getPadUpNorItr().hashCode());
        result = prime * result + ((getRcvDftItr() == null) ? 0 : getRcvDftItr().hashCode());
        result = prime * result + ((getPadUpDftItr() == null) ? 0 : getPadUpDftItr().hashCode());
        result = prime * result + ((getRcvPnsItr() == null) ? 0 : getRcvPnsItr().hashCode());
        result = prime * result + ((getPadUpPnsItr() == null) ? 0 : getPadUpPnsItr().hashCode());
        result = prime * result + ((getDftOtdItr() == null) ? 0 : getDftOtdItr().hashCode());
        result = prime * result + ((getOverdueCapi() == null) ? 0 : getOverdueCapi().hashCode());
        result = prime * result + ((getOverdueItr() == null) ? 0 : getOverdueItr().hashCode());
        result = prime * result + ((getOverduePnsItr() == null) ? 0 : getOverduePnsItr().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}