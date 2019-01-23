package com.cdgit.loan.customerManage.impornantEvent.bean;

import java.util.Date;

public class ImpornantEvent {
    private String importantEventId;

    private String partyId;

    private String eventTypeCd;

    private Date happenDate;

    private String eventState;

    private String remark;

    private String eventNum;

    private String eventName;

    private String groupImpornantEvent;

    private Date createTime;

    private Date updateTime;

    public String getImportantEventId() {
        return importantEventId;
    }

    public void setImportantEventId(String importantEventId) {
        this.importantEventId = importantEventId == null ? null : importantEventId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getEventTypeCd() {
        return eventTypeCd;
    }

    public void setEventTypeCd(String eventTypeCd) {
        this.eventTypeCd = eventTypeCd == null ? null : eventTypeCd.trim();
    }

    public Date getHappenDate() {
        return happenDate;
    }

    public void setHappenDate(Date happenDate) {
        this.happenDate = happenDate;
    }

    public String getEventState() {
        return eventState;
    }

    public void setEventState(String eventState) {
        this.eventState = eventState == null ? null : eventState.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getEventNum() {
        return eventNum;
    }

    public void setEventNum(String eventNum) {
        this.eventNum = eventNum == null ? null : eventNum.trim();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    public String getGroupImpornantEvent() {
        return groupImpornantEvent;
    }

    public void setGroupImpornantEvent(String groupImpornantEvent) {
        this.groupImpornantEvent = groupImpornantEvent == null ? null : groupImpornantEvent.trim();
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ImpornantEvent other = (ImpornantEvent) that;
        return (this.getImportantEventId() == null ? other.getImportantEventId() == null : this.getImportantEventId().equals(other.getImportantEventId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getEventTypeCd() == null ? other.getEventTypeCd() == null : this.getEventTypeCd().equals(other.getEventTypeCd()))
            && (this.getHappenDate() == null ? other.getHappenDate() == null : this.getHappenDate().equals(other.getHappenDate()))
            && (this.getEventState() == null ? other.getEventState() == null : this.getEventState().equals(other.getEventState()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getEventNum() == null ? other.getEventNum() == null : this.getEventNum().equals(other.getEventNum()))
            && (this.getEventName() == null ? other.getEventName() == null : this.getEventName().equals(other.getEventName()))
            && (this.getGroupImpornantEvent() == null ? other.getGroupImpornantEvent() == null : this.getGroupImpornantEvent().equals(other.getGroupImpornantEvent()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getImportantEventId() == null) ? 0 : getImportantEventId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getEventTypeCd() == null) ? 0 : getEventTypeCd().hashCode());
        result = prime * result + ((getHappenDate() == null) ? 0 : getHappenDate().hashCode());
        result = prime * result + ((getEventState() == null) ? 0 : getEventState().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getEventNum() == null) ? 0 : getEventNum().hashCode());
        result = prime * result + ((getEventName() == null) ? 0 : getEventName().hashCode());
        result = prime * result + ((getGroupImpornantEvent() == null) ? 0 : getGroupImpornantEvent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}