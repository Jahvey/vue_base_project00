package com.cdgit.loan.workflow.bean;

import java.util.Date;

public class TbWfmProcessinstance {
    private String processId;

    private String productCd;

    private String productId;

    private String createPostName;

    private String createPostCd;

    private String createUserName;

    private String createUserNum;

    private String createOrgName;

    private String createOrgNum;

    private Date createTime;

    private Date finishTime;

    private String activityName;

    private String postCd;

    private String appointUserName;

    private String appointUserNum;

    private String appointOrgCd;

    private String appointOrgName;

    private String templateVersion;

    private String processStatus;

    private String appType;

    private String cusName;

    private String bizStatus;

    private String productName;

    private String bizViewUrl;

    private Date lastupdatetime;

    private String processdefname;

    private String processinstancename;

    private String custId;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getProductCd() {
        return productCd;
    }

    public void setProductCd(String productCd) {
        this.productCd = productCd == null ? null : productCd.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getCreatePostName() {
        return createPostName;
    }

    public void setCreatePostName(String createPostName) {
        this.createPostName = createPostName == null ? null : createPostName.trim();
    }

    public String getCreatePostCd() {
        return createPostCd;
    }

    public void setCreatePostCd(String createPostCd) {
        this.createPostCd = createPostCd == null ? null : createPostCd.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public String getCreateUserNum() {
        return createUserNum;
    }

    public void setCreateUserNum(String createUserNum) {
        this.createUserNum = createUserNum == null ? null : createUserNum.trim();
    }

    public String getCreateOrgName() {
        return createOrgName;
    }

    public void setCreateOrgName(String createOrgName) {
        this.createOrgName = createOrgName == null ? null : createOrgName.trim();
    }

    public String getCreateOrgNum() {
        return createOrgNum;
    }

    public void setCreateOrgNum(String createOrgNum) {
        this.createOrgNum = createOrgNum == null ? null : createOrgNum.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getPostCd() {
        return postCd;
    }

    public void setPostCd(String postCd) {
        this.postCd = postCd == null ? null : postCd.trim();
    }

    public String getAppointUserName() {
        return appointUserName;
    }

    public void setAppointUserName(String appointUserName) {
        this.appointUserName = appointUserName == null ? null : appointUserName.trim();
    }

    public String getAppointUserNum() {
        return appointUserNum;
    }

    public void setAppointUserNum(String appointUserNum) {
        this.appointUserNum = appointUserNum == null ? null : appointUserNum.trim();
    }

    public String getAppointOrgCd() {
        return appointOrgCd;
    }

    public void setAppointOrgCd(String appointOrgCd) {
        this.appointOrgCd = appointOrgCd == null ? null : appointOrgCd.trim();
    }

    public String getAppointOrgName() {
        return appointOrgName;
    }

    public void setAppointOrgName(String appointOrgName) {
        this.appointOrgName = appointOrgName == null ? null : appointOrgName.trim();
    }

    public String getTemplateVersion() {
        return templateVersion;
    }

    public void setTemplateVersion(String templateVersion) {
        this.templateVersion = templateVersion == null ? null : templateVersion.trim();
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
    }

    public String getBizStatus() {
        return bizStatus;
    }

    public void setBizStatus(String bizStatus) {
        this.bizStatus = bizStatus == null ? null : bizStatus.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getBizViewUrl() {
        return bizViewUrl;
    }

    public void setBizViewUrl(String bizViewUrl) {
        this.bizViewUrl = bizViewUrl == null ? null : bizViewUrl.trim();
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public String getProcessdefname() {
        return processdefname;
    }

    public void setProcessdefname(String processdefname) {
        this.processdefname = processdefname == null ? null : processdefname.trim();
    }

    public String getProcessinstancename() {
        return processinstancename;
    }

    public void setProcessinstancename(String processinstancename) {
        this.processinstancename = processinstancename == null ? null : processinstancename.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
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
        TbWfmProcessinstance other = (TbWfmProcessinstance) that;
        return (this.getProcessId() == null ? other.getProcessId() == null : this.getProcessId().equals(other.getProcessId()))
            && (this.getProductCd() == null ? other.getProductCd() == null : this.getProductCd().equals(other.getProductCd()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getCreatePostName() == null ? other.getCreatePostName() == null : this.getCreatePostName().equals(other.getCreatePostName()))
            && (this.getCreatePostCd() == null ? other.getCreatePostCd() == null : this.getCreatePostCd().equals(other.getCreatePostCd()))
            && (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName()))
            && (this.getCreateUserNum() == null ? other.getCreateUserNum() == null : this.getCreateUserNum().equals(other.getCreateUserNum()))
            && (this.getCreateOrgName() == null ? other.getCreateOrgName() == null : this.getCreateOrgName().equals(other.getCreateOrgName()))
            && (this.getCreateOrgNum() == null ? other.getCreateOrgNum() == null : this.getCreateOrgNum().equals(other.getCreateOrgNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getActivityName() == null ? other.getActivityName() == null : this.getActivityName().equals(other.getActivityName()))
            && (this.getPostCd() == null ? other.getPostCd() == null : this.getPostCd().equals(other.getPostCd()))
            && (this.getAppointUserName() == null ? other.getAppointUserName() == null : this.getAppointUserName().equals(other.getAppointUserName()))
            && (this.getAppointUserNum() == null ? other.getAppointUserNum() == null : this.getAppointUserNum().equals(other.getAppointUserNum()))
            && (this.getAppointOrgCd() == null ? other.getAppointOrgCd() == null : this.getAppointOrgCd().equals(other.getAppointOrgCd()))
            && (this.getAppointOrgName() == null ? other.getAppointOrgName() == null : this.getAppointOrgName().equals(other.getAppointOrgName()))
            && (this.getTemplateVersion() == null ? other.getTemplateVersion() == null : this.getTemplateVersion().equals(other.getTemplateVersion()))
            && (this.getProcessStatus() == null ? other.getProcessStatus() == null : this.getProcessStatus().equals(other.getProcessStatus()))
            && (this.getAppType() == null ? other.getAppType() == null : this.getAppType().equals(other.getAppType()))
            && (this.getCusName() == null ? other.getCusName() == null : this.getCusName().equals(other.getCusName()))
            && (this.getBizStatus() == null ? other.getBizStatus() == null : this.getBizStatus().equals(other.getBizStatus()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getBizViewUrl() == null ? other.getBizViewUrl() == null : this.getBizViewUrl().equals(other.getBizViewUrl()))
            && (this.getLastupdatetime() == null ? other.getLastupdatetime() == null : this.getLastupdatetime().equals(other.getLastupdatetime()))
            && (this.getProcessdefname() == null ? other.getProcessdefname() == null : this.getProcessdefname().equals(other.getProcessdefname()))
            && (this.getProcessinstancename() == null ? other.getProcessinstancename() == null : this.getProcessinstancename().equals(other.getProcessinstancename()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProcessId() == null) ? 0 : getProcessId().hashCode());
        result = prime * result + ((getProductCd() == null) ? 0 : getProductCd().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getCreatePostName() == null) ? 0 : getCreatePostName().hashCode());
        result = prime * result + ((getCreatePostCd() == null) ? 0 : getCreatePostCd().hashCode());
        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
        result = prime * result + ((getCreateUserNum() == null) ? 0 : getCreateUserNum().hashCode());
        result = prime * result + ((getCreateOrgName() == null) ? 0 : getCreateOrgName().hashCode());
        result = prime * result + ((getCreateOrgNum() == null) ? 0 : getCreateOrgNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getActivityName() == null) ? 0 : getActivityName().hashCode());
        result = prime * result + ((getPostCd() == null) ? 0 : getPostCd().hashCode());
        result = prime * result + ((getAppointUserName() == null) ? 0 : getAppointUserName().hashCode());
        result = prime * result + ((getAppointUserNum() == null) ? 0 : getAppointUserNum().hashCode());
        result = prime * result + ((getAppointOrgCd() == null) ? 0 : getAppointOrgCd().hashCode());
        result = prime * result + ((getAppointOrgName() == null) ? 0 : getAppointOrgName().hashCode());
        result = prime * result + ((getTemplateVersion() == null) ? 0 : getTemplateVersion().hashCode());
        result = prime * result + ((getProcessStatus() == null) ? 0 : getProcessStatus().hashCode());
        result = prime * result + ((getAppType() == null) ? 0 : getAppType().hashCode());
        result = prime * result + ((getCusName() == null) ? 0 : getCusName().hashCode());
        result = prime * result + ((getBizStatus() == null) ? 0 : getBizStatus().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getBizViewUrl() == null) ? 0 : getBizViewUrl().hashCode());
        result = prime * result + ((getLastupdatetime() == null) ? 0 : getLastupdatetime().hashCode());
        result = prime * result + ((getProcessdefname() == null) ? 0 : getProcessdefname().hashCode());
        result = prime * result + ((getProcessinstancename() == null) ? 0 : getProcessinstancename().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        return result;
    }
}