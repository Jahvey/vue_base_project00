package com.cdgit.loan.irm.bean;

public class TbIrmRatingPara {

	private String ratingParaId;//评级常规参数ID
	
	private String paraType;//评级参数类型
	
	private String paraContent;//评级参数内容

	public String getRatingParaId() {
		return ratingParaId;
	}

	public void setRatingParaId(String ratingParaId) {
		this.ratingParaId = ratingParaId;
	}

	public String getParaType() {
		return paraType;
	}

	public void setParaType(String paraType) {
		this.paraType = paraType;
	}

	public String getParaContent() {
		return paraContent;
	}

	public void setParaContent(String paraContent) {
		this.paraContent = paraContent;
	}
	
	
}
