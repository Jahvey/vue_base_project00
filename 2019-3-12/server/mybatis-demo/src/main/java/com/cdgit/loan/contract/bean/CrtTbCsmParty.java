package com.cdgit.loan.contract.bean;

import java.util.Date;

/**
 * 参与人表：tb_csm_party
 * @author Administrator
 *
 */
public class CrtTbCsmParty {
	
    private String partyId;						//参与人（主键）

    private String partyNum;					//参与人编号

    private String partyTypeCd;					//参与人类型代码 (:XD_KHCD1001)

    private String partyName;					//参与人名称

    private String ecifPartyNum;				//ECIF系统客户编号

    private Date createTime;					//创建日期

    private Date updateTime;					//更新日期

    private String examineState;				//审核状态

    private String custPropertyStatus;			//客户类型: small 自然人/小微客户 big 非自然人/小微客户

    private String ifDataMove;					//是否迁移数据

    private String isPotentialCust;				//是否授信客户(:YesOrNo)

    private String legOrg;						//法人标识

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getPartyNum() {
        return partyNum;
    }

    public void setPartyNum(String partyNum) {
        this.partyNum = partyNum == null ? null : partyNum.trim();
    }

    public String getPartyTypeCd() {
        return partyTypeCd;
    }

    public void setPartyTypeCd(String partyTypeCd) {
        this.partyTypeCd = partyTypeCd == null ? null : partyTypeCd.trim();
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName == null ? null : partyName.trim();
    }

    public String getEcifPartyNum() {
        return ecifPartyNum;
    }

    public void setEcifPartyNum(String ecifPartyNum) {
        this.ecifPartyNum = ecifPartyNum == null ? null : ecifPartyNum.trim();
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

    public String getExamineState() {
        return examineState;
    }

    public void setExamineState(String examineState) {
        this.examineState = examineState == null ? null : examineState.trim();
    }

    public String getCustPropertyStatus() {
        return custPropertyStatus;
    }

    public void setCustPropertyStatus(String custPropertyStatus) {
        this.custPropertyStatus = custPropertyStatus == null ? null : custPropertyStatus.trim();
    }

    public String getIfDataMove() {
        return ifDataMove;
    }

    public void setIfDataMove(String ifDataMove) {
        this.ifDataMove = ifDataMove == null ? null : ifDataMove.trim();
    }

    public String getIsPotentialCust() {
        return isPotentialCust;
    }

    public void setIsPotentialCust(String isPotentialCust) {
        this.isPotentialCust = isPotentialCust == null ? null : isPotentialCust.trim();
    }

    public String getLegOrg() {
        return legOrg;
    }

    public void setLegOrg(String legOrg) {
        this.legOrg = legOrg == null ? null : legOrg.trim();
    }
}