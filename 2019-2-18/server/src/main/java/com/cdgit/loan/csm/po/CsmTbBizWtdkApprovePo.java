package com.cdgit.loan.csm.po;

import java.util.Date;

import com.cdgit.loan.csm.bean.CsmConDetailVo;



public class CsmTbBizWtdkApprovePo  extends CsmConDetailVo{
    private String applyDetailId;

    private Date createTime;

    private Date updateTime;

    private String amountDetailId;

    private String wtr;

    private String wtrlx;

    private String wtdkxz;

    private String wtxmId;

    public String getApplyDetailId() {
        return applyDetailId;
    }

    public void setApplyDetailId(String applyDetailId) {
        this.applyDetailId = applyDetailId == null ? null : applyDetailId.trim();
    }

    

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }



    public Date getCreateTime() {
		return createTime;
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

    public String getWtr() {
        return wtr;
    }

    public void setWtr(String wtr) {
        this.wtr = wtr == null ? null : wtr.trim();
    }

    public String getWtrlx() {
        return wtrlx;
    }

    public void setWtrlx(String wtrlx) {
        this.wtrlx = wtrlx == null ? null : wtrlx.trim();
    }

    public String getWtdkxz() {
        return wtdkxz;
    }

    public void setWtdkxz(String wtdkxz) {
        this.wtdkxz = wtdkxz == null ? null : wtdkxz.trim();
    }

    public String getWtxmId() {
        return wtxmId;
    }

    public void setWtxmId(String wtxmId) {
        this.wtxmId = wtxmId == null ? null : wtxmId.trim();
    }
}