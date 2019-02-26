package com.cdgit.loan.contract.bean;

import java.util.Date;

/**
 * 	TB_LOAN_LDZJ:01-流动资金贷款批复
 * @author Administrator
 *
 */
public class CrtTbLoanLdzj {
	
    private String applyDetailId;	//主键

    private Date createTime;

    private Date updateTime;		

    private String amountDetailId;	//额度申请明细ID

    private String contractId;		//合同id

    private String loanId;			//放款id

    private String jmrhsx;			//军民融合属性(XD_JMRHSX001)

    private String sfjmrhsx;		//是否军民融合属性(YesOrNo)

    public String getApplyDetailId() {
        return applyDetailId;
    }

    public void setApplyDetailId(String applyDetailId) {
        this.applyDetailId = applyDetailId == null ? null : applyDetailId.trim();
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

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

    public String getJmrhsx() {
        return jmrhsx;
    }

    public void setJmrhsx(String jmrhsx) {
        this.jmrhsx = jmrhsx == null ? null : jmrhsx.trim();
    }

    public String getSfjmrhsx() {
        return sfjmrhsx;
    }

    public void setSfjmrhsx(String sfjmrhsx) {
        this.sfjmrhsx = sfjmrhsx == null ? null : sfjmrhsx.trim();
    }
}