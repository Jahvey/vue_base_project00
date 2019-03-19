package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbCsmGroupCompanyPo {
    private String partyId;

    private String groupNatureCd;

    private String registerNum;

    private String groupManageWayCd;

    private Date balanceSheetDate;

    private BigDecimal totalAssets;

    private BigDecimal liabilitySum;

    private String status;

    private String channel;

    private String entmark;

    private String tmpentmark;

    private Integer groupMemberNum;

    private Date createTime;

    private Date updateTime;

    private String updateOrgNum;

    private String updateUserNum;

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getGroupNatureCd() {
        return groupNatureCd;
    }

    public void setGroupNatureCd(String groupNatureCd) {
        this.groupNatureCd = groupNatureCd == null ? null : groupNatureCd.trim();
    }

    public String getRegisterNum() {
        return registerNum;
    }

    public void setRegisterNum(String registerNum) {
        this.registerNum = registerNum == null ? null : registerNum.trim();
    }

    public String getGroupManageWayCd() {
        return groupManageWayCd;
    }

    public void setGroupManageWayCd(String groupManageWayCd) {
        this.groupManageWayCd = groupManageWayCd == null ? null : groupManageWayCd.trim();
    }

    public Date getBalanceSheetDate() {
        return balanceSheetDate;
    }

    public void setBalanceSheetDate(Date balanceSheetDate) {
        this.balanceSheetDate = balanceSheetDate;
    }

    public BigDecimal getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(BigDecimal totalAssets) {
        this.totalAssets = totalAssets;
    }

    public BigDecimal getLiabilitySum() {
        return liabilitySum;
    }

    public void setLiabilitySum(BigDecimal liabilitySum) {
        this.liabilitySum = liabilitySum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getEntmark() {
        return entmark;
    }

    public void setEntmark(String entmark) {
        this.entmark = entmark == null ? null : entmark.trim();
    }

    public String getTmpentmark() {
        return tmpentmark;
    }

    public void setTmpentmark(String tmpentmark) {
        this.tmpentmark = tmpentmark == null ? null : tmpentmark.trim();
    }

    public Integer getGroupMemberNum() {
        return groupMemberNum;
    }

    public void setGroupMemberNum(Integer groupMemberNum) {
        this.groupMemberNum = groupMemberNum;
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

    public String getUpdateOrgNum() {
        return updateOrgNum;
    }

    public void setUpdateOrgNum(String updateOrgNum) {
        this.updateOrgNum = updateOrgNum == null ? null : updateOrgNum.trim();
    }

    public String getUpdateUserNum() {
        return updateUserNum;
    }

    public void setUpdateUserNum(String updateUserNum) {
        this.updateUserNum = updateUserNum == null ? null : updateUserNum.trim();
    }
}