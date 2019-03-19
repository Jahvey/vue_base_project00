package com.cdgit.loan.csm.po;

import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;

public class CsmTbConXmdkcnhPo extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String sfkwtjcx;

    private String contractId;

    private String itemName;

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

    public String getSfkwtjcx() {
        return sfkwtjcx;
    }

    public void setSfkwtjcx(String sfkwtjcx) {
        this.sfkwtjcx = sfkwtjcx == null ? null : sfkwtjcx.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

	@Override
	public String toString() {
		return "CsmTbConXmdkcnhPo [applyDetailId=" + applyDetailId + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", amountDetailId=" + amountDetailId + ", sfkwtjcx=" + sfkwtjcx + ", contractId="
				+ contractId + ", itemName=" + itemName + "]";
	}
    
    
}