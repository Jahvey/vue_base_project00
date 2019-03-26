package com.cdgit.loan.irm.bean;

import com.cdgit.loan.user.bean.TbIrmInternalRatingApply;

public class AdJustInfoBean {

	private TbIrmInternalRatingApply ratingApply;
	private TbIrmAdjustOptions adjustOptions;
	public TbIrmInternalRatingApply getRatingApply() {
		return ratingApply;
	}
	public void setRatingApply(TbIrmInternalRatingApply ratingApply) {
		this.ratingApply = ratingApply;
	}
	public TbIrmAdjustOptions getAdjustOptions() {
		return adjustOptions;
	}
	public void setAdjustOptions(TbIrmAdjustOptions adjustOptions) {
		this.adjustOptions = adjustOptions;
	}
	
}
