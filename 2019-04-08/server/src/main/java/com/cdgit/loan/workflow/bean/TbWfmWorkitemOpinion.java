package com.cdgit.loan.workflow.bean;

import java.util.Date;

public class TbWfmWorkitemOpinion {
    private String id;

    private Date createTime;

    private String opinionType;

    private String extend1;

    private String extend2;

    private String extend3;

    private String activitydefid;

    private String operatorName;

    private String opinion;

    private String activityinstname;

    private String operatorNum;

    private String processId;

    private String workitemId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOpinionType() {
        return opinionType;
    }

    public void setOpinionType(String opinionType) {
        this.opinionType = opinionType == null ? null : opinionType.trim();
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1 == null ? null : extend1.trim();
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2 == null ? null : extend2.trim();
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3 == null ? null : extend3.trim();
    }

    public String getActivitydefid() {
        return activitydefid;
    }

    public void setActivitydefid(String activitydefid) {
        this.activitydefid = activitydefid == null ? null : activitydefid.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }

    public String getActivityinstname() {
        return activityinstname;
    }

    public void setActivityinstname(String activityinstname) {
        this.activityinstname = activityinstname == null ? null : activityinstname.trim();
    }

    public String getOperatorNum() {
        return operatorNum;
    }

    public void setOperatorNum(String operatorNum) {
        this.operatorNum = operatorNum == null ? null : operatorNum.trim();
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getWorkitemId() {
        return workitemId;
    }

    public void setWorkitemId(String workitemId) {
        this.workitemId = workitemId == null ? null : workitemId.trim();
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
        TbWfmWorkitemOpinion other = (TbWfmWorkitemOpinion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getOpinionType() == null ? other.getOpinionType() == null : this.getOpinionType().equals(other.getOpinionType()))
            && (this.getExtend1() == null ? other.getExtend1() == null : this.getExtend1().equals(other.getExtend1()))
            && (this.getExtend2() == null ? other.getExtend2() == null : this.getExtend2().equals(other.getExtend2()))
            && (this.getExtend3() == null ? other.getExtend3() == null : this.getExtend3().equals(other.getExtend3()))
            && (this.getActivitydefid() == null ? other.getActivitydefid() == null : this.getActivitydefid().equals(other.getActivitydefid()))
            && (this.getOperatorName() == null ? other.getOperatorName() == null : this.getOperatorName().equals(other.getOperatorName()))
            && (this.getOpinion() == null ? other.getOpinion() == null : this.getOpinion().equals(other.getOpinion()))
            && (this.getActivityinstname() == null ? other.getActivityinstname() == null : this.getActivityinstname().equals(other.getActivityinstname()))
            && (this.getOperatorNum() == null ? other.getOperatorNum() == null : this.getOperatorNum().equals(other.getOperatorNum()))
            && (this.getProcessId() == null ? other.getProcessId() == null : this.getProcessId().equals(other.getProcessId()))
            && (this.getWorkitemId() == null ? other.getWorkitemId() == null : this.getWorkitemId().equals(other.getWorkitemId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getOpinionType() == null) ? 0 : getOpinionType().hashCode());
        result = prime * result + ((getExtend1() == null) ? 0 : getExtend1().hashCode());
        result = prime * result + ((getExtend2() == null) ? 0 : getExtend2().hashCode());
        result = prime * result + ((getExtend3() == null) ? 0 : getExtend3().hashCode());
        result = prime * result + ((getActivitydefid() == null) ? 0 : getActivitydefid().hashCode());
        result = prime * result + ((getOperatorName() == null) ? 0 : getOperatorName().hashCode());
        result = prime * result + ((getOpinion() == null) ? 0 : getOpinion().hashCode());
        result = prime * result + ((getActivityinstname() == null) ? 0 : getActivityinstname().hashCode());
        result = prime * result + ((getOperatorNum() == null) ? 0 : getOperatorNum().hashCode());
        result = prime * result + ((getProcessId() == null) ? 0 : getProcessId().hashCode());
        result = prime * result + ((getWorkitemId() == null) ? 0 : getWorkitemId().hashCode());
        return result;
    }
}