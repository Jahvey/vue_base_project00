package com.cdgit.loan.csm.bean;

import java.util.Date;
/**
 * TB_CON_CREDIT_INFO		综合授信协议信息表
 * @author Administrator
 *
 */

public class CsmConCreditInfo {
	
    private String contractId;				//协议ID（主键）

    private String applyId;					//业务申请ID

    private String partyId;					//客户ID

    private String contractNum;				//合同编号

    private Date contractDate;				//签约日期

    private String contractAddress;			//签约地点

    private String oldContractId;			//原协议ID（旧合同id）

    private String userNum;					//经办人

    private String orgNum;					//经办机构

    private Date createTime;				//创建时间

    private Date updateTime;				//更新时间

    private String conStatus;				//授信协议状态

    private String paperConNum;				//纸质合同编号

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum == null ? null : contractNum.trim();
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress == null ? null : contractAddress.trim();
    }

    public String getOldContractId() {
        return oldContractId;
    }

    public void setOldContractId(String oldContractId) {
        this.oldContractId = oldContractId == null ? null : oldContractId.trim();
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

    public String getConStatus() {
        return conStatus;
    }

    public void setConStatus(String conStatus) {
        this.conStatus = conStatus == null ? null : conStatus.trim();
    }

    public String getPaperConNum() {
        return paperConNum;
    }

    public void setPaperConNum(String paperConNum) {
        this.paperConNum = paperConNum == null ? null : paperConNum.trim();
    }
}