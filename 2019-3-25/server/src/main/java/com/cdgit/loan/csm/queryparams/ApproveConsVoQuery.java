package com.cdgit.loan.csm.queryparams;


public class ApproveConsVoQuery {
	//包含了分页查询的 两个基本条件 当前页面 和页面大小
	private Integer pageNum; //pageNum
	
	private Integer pageSize;//pageSize

	private String userNum;
	


	private String partyId;
	
	private String contractNum;


	

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}



	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	
	
	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}


	
	



}
