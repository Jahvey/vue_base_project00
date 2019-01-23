package com.cdgit.loan.csm.po;


import java.util.Date;

public class TbBizAmountDetailApprovePo {//TB_BIZ_AMOUNT_DETAIL_APPROVE
    private String productType;

    private String currencyCd;

    private String exchangeRate;

    private String cycleUnit;

    private String creditTerm;

    private String loanUse;

    private String repaymentType;

    private String cycleInd;

    private String broadCycle;

    private String broadCycleUnit;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private Date exchangeRateDate;

    private String oldDetailId;

    private String detailAmt;

    private String amountId;

    private String payment;

    private String prepaymentPenalty;

    private String rmbAmt;

    private String cycleIndCon;

    private String holidayFlg;

    private String firstRepayTerm;

    private String detailBalance;

    private String detailUsed;

    private Date endDate;

    private String approveId;

    private String noUse;

    private String boUse;

    private String crdDtlId;

    private String creditMode;

    private Date beginDate;

    private String creditStatus;

    private String assurePer;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }



    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit == null ? null : cycleUnit.trim();
    }



    public String getLoanUse() {
        return loanUse;
    }

    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse == null ? null : loanUse.trim();
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType == null ? null : repaymentType.trim();
    }

    public String getCycleInd() {
        return cycleInd;
    }

    public void setCycleInd(String cycleInd) {
        this.cycleInd = cycleInd == null ? null : cycleInd.trim();
    }



    public String getBroadCycleUnit() {
        return broadCycleUnit;
    }

    public void setBroadCycleUnit(String broadCycleUnit) {
        this.broadCycleUnit = broadCycleUnit == null ? null : broadCycleUnit.trim();
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

    public String getAmountDetailId() {
        return amountDetailId;
    }

    public void setAmountDetailId(String amountDetailId) {
        this.amountDetailId = amountDetailId == null ? null : amountDetailId.trim();
    }

    public Date getExchangeRateDate() {
        return exchangeRateDate;
    }

    public void setExchangeRateDate(Date exchangeRateDate) {
        this.exchangeRateDate = exchangeRateDate;
    }

    public String getOldDetailId() {
        return oldDetailId;
    }

    public void setOldDetailId(String oldDetailId) {
        this.oldDetailId = oldDetailId == null ? null : oldDetailId.trim();
    }



    public String getAmountId() {
        return amountId;
    }

    public void setAmountId(String amountId) {
        this.amountId = amountId == null ? null : amountId.trim();
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    public String getPrepaymentPenalty() {
        return prepaymentPenalty;
    }

    public void setPrepaymentPenalty(String prepaymentPenalty) {
        this.prepaymentPenalty = prepaymentPenalty == null ? null : prepaymentPenalty.trim();
    }


    public String getCycleIndCon() {
        return cycleIndCon;
    }

    public void setCycleIndCon(String cycleIndCon) {
        this.cycleIndCon = cycleIndCon == null ? null : cycleIndCon.trim();
    }

    public String getHolidayFlg() {
        return holidayFlg;
    }

    public void setHolidayFlg(String holidayFlg) {
        this.holidayFlg = holidayFlg == null ? null : holidayFlg.trim();
    }

    public String getFirstRepayTerm() {
        return firstRepayTerm;
    }

    public void setFirstRepayTerm(String firstRepayTerm) {
        this.firstRepayTerm = firstRepayTerm == null ? null : firstRepayTerm.trim();
    }



    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId == null ? null : approveId.trim();
    }



    public String getCrdDtlId() {
        return crdDtlId;
    }

    public void setCrdDtlId(String crdDtlId) {
        this.crdDtlId = crdDtlId == null ? null : crdDtlId.trim();
    }

    public String getCreditMode() {
        return creditMode;
    }

    public void setCreditMode(String creditMode) {
        this.creditMode = creditMode == null ? null : creditMode.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus == null ? null : creditStatus.trim();
    }

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getCreditTerm() {
		return creditTerm;
	}

	public void setCreditTerm(String creditTerm) {
		this.creditTerm = creditTerm;
	}

	public String getBroadCycle() {
		return broadCycle;
	}

	public void setBroadCycle(String broadCycle) {
		this.broadCycle = broadCycle;
	}

	public String getDetailAmt() {
		return detailAmt;
	}

	public void setDetailAmt(String detailAmt) {
		this.detailAmt = detailAmt;
	}

	public String getRmbAmt() {
		return rmbAmt;
	}

	public void setRmbAmt(String rmbAmt) {
		this.rmbAmt = rmbAmt;
	}

	public String getDetailBalance() {
		return detailBalance;
	}

	public void setDetailBalance(String detailBalance) {
		this.detailBalance = detailBalance;
	}

	public String getDetailUsed() {
		return detailUsed;
	}

	public void setDetailUsed(String detailUsed) {
		this.detailUsed = detailUsed;
	}

	public String getNoUse() {
		return noUse;
	}

	public void setNoUse(String noUse) {
		this.noUse = noUse;
	}

	public String getBoUse() {
		return boUse;
	}

	public void setBoUse(String boUse) {
		this.boUse = boUse;
	}

	public String getAssurePer() {
		return assurePer;
	}

	public void setAssurePer(String assurePer) {
		this.assurePer = assurePer;
	}

	@Override
	public String toString() {
		return "TbBizAmountDetailApprovePo [productType=" + productType + ", currencyCd=" + currencyCd
				+ ", exchangeRate=" + exchangeRate + ", cycleUnit=" + cycleUnit + ", creditTerm=" + creditTerm
				+ ", loanUse=" + loanUse + ", repaymentType=" + repaymentType + ", cycleInd=" + cycleInd
				+ ", broadCycle=" + broadCycle + ", broadCycleUnit=" + broadCycleUnit + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", amountDetailId=" + amountDetailId + ", exchangeRateDate="
				+ exchangeRateDate + ", oldDetailId=" + oldDetailId + ", detailAmt=" + detailAmt + ", amountId="
				+ amountId + ", payment=" + payment + ", prepaymentPenalty=" + prepaymentPenalty + ", rmbAmt=" + rmbAmt
				+ ", cycleIndCon=" + cycleIndCon + ", holidayFlg=" + holidayFlg + ", firstRepayTerm=" + firstRepayTerm
				+ ", detailBalance=" + detailBalance + ", detailUsed=" + detailUsed + ", endDate=" + endDate
				+ ", approveId=" + approveId + ", noUse=" + noUse + ", boUse=" + boUse + ", crdDtlId=" + crdDtlId
				+ ", creditMode=" + creditMode + ", beginDate=" + beginDate + ", creditStatus=" + creditStatus
				+ ", assurePer=" + assurePer + "]";
	}

    
}