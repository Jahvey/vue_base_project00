package com.cdgit.loan.workflow.bean;

public class TbWfmWorkitemmapping {
    private String workitemMappingId;

    private String activityName;

    private String orgLvCd;

    private String orgName;

    private String postNum;

    private String ruleId;

    private String doUrl;

    private String viewUrl;

    private String serviceName;

    private String serviceVersion;

    private String saveUrl;

    private String selectType;

    private String userVariable;

    private String templateName;

    private String templateVersion;

    private String reTarget;

    private String finalJudge;

    private String processMappingId;

    private String activityDefId;

    public String getWorkitemMappingId() {
        return workitemMappingId;
    }

    public void setWorkitemMappingId(String workitemMappingId) {
        this.workitemMappingId = workitemMappingId == null ? null : workitemMappingId.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getOrgLvCd() {
        return orgLvCd;
    }

    public void setOrgLvCd(String orgLvCd) {
        this.orgLvCd = orgLvCd == null ? null : orgLvCd.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum == null ? null : postNum.trim();
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    public String getDoUrl() {
        return doUrl;
    }

    public void setDoUrl(String doUrl) {
        this.doUrl = doUrl == null ? null : doUrl.trim();
    }

    public String getViewUrl() {
        return viewUrl;
    }

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl == null ? null : viewUrl.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion == null ? null : serviceVersion.trim();
    }

    public String getSaveUrl() {
        return saveUrl;
    }

    public void setSaveUrl(String saveUrl) {
        this.saveUrl = saveUrl == null ? null : saveUrl.trim();
    }

    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType == null ? null : selectType.trim();
    }

    public String getUserVariable() {
        return userVariable;
    }

    public void setUserVariable(String userVariable) {
        this.userVariable = userVariable == null ? null : userVariable.trim();
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public String getTemplateVersion() {
        return templateVersion;
    }

    public void setTemplateVersion(String templateVersion) {
        this.templateVersion = templateVersion == null ? null : templateVersion.trim();
    }

    public String getReTarget() {
        return reTarget;
    }

    public void setReTarget(String reTarget) {
        this.reTarget = reTarget == null ? null : reTarget.trim();
    }

    public String getFinalJudge() {
        return finalJudge;
    }

    public void setFinalJudge(String finalJudge) {
        this.finalJudge = finalJudge == null ? null : finalJudge.trim();
    }

    public String getProcessMappingId() {
        return processMappingId;
    }

    public void setProcessMappingId(String processMappingId) {
        this.processMappingId = processMappingId == null ? null : processMappingId.trim();
    }

    public String getActivityDefId() {
        return activityDefId;
    }

    public void setActivityDefId(String activityDefId) {
        this.activityDefId = activityDefId == null ? null : activityDefId.trim();
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
        TbWfmWorkitemmapping other = (TbWfmWorkitemmapping) that;
        return (this.getWorkitemMappingId() == null ? other.getWorkitemMappingId() == null : this.getWorkitemMappingId().equals(other.getWorkitemMappingId()))
            && (this.getActivityName() == null ? other.getActivityName() == null : this.getActivityName().equals(other.getActivityName()))
            && (this.getOrgLvCd() == null ? other.getOrgLvCd() == null : this.getOrgLvCd().equals(other.getOrgLvCd()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getPostNum() == null ? other.getPostNum() == null : this.getPostNum().equals(other.getPostNum()))
            && (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getDoUrl() == null ? other.getDoUrl() == null : this.getDoUrl().equals(other.getDoUrl()))
            && (this.getViewUrl() == null ? other.getViewUrl() == null : this.getViewUrl().equals(other.getViewUrl()))
            && (this.getServiceName() == null ? other.getServiceName() == null : this.getServiceName().equals(other.getServiceName()))
            && (this.getServiceVersion() == null ? other.getServiceVersion() == null : this.getServiceVersion().equals(other.getServiceVersion()))
            && (this.getSaveUrl() == null ? other.getSaveUrl() == null : this.getSaveUrl().equals(other.getSaveUrl()))
            && (this.getSelectType() == null ? other.getSelectType() == null : this.getSelectType().equals(other.getSelectType()))
            && (this.getUserVariable() == null ? other.getUserVariable() == null : this.getUserVariable().equals(other.getUserVariable()))
            && (this.getTemplateName() == null ? other.getTemplateName() == null : this.getTemplateName().equals(other.getTemplateName()))
            && (this.getTemplateVersion() == null ? other.getTemplateVersion() == null : this.getTemplateVersion().equals(other.getTemplateVersion()))
            && (this.getReTarget() == null ? other.getReTarget() == null : this.getReTarget().equals(other.getReTarget()))
            && (this.getFinalJudge() == null ? other.getFinalJudge() == null : this.getFinalJudge().equals(other.getFinalJudge()))
            && (this.getProcessMappingId() == null ? other.getProcessMappingId() == null : this.getProcessMappingId().equals(other.getProcessMappingId()))
            && (this.getActivityDefId() == null ? other.getActivityDefId() == null : this.getActivityDefId().equals(other.getActivityDefId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWorkitemMappingId() == null) ? 0 : getWorkitemMappingId().hashCode());
        result = prime * result + ((getActivityName() == null) ? 0 : getActivityName().hashCode());
        result = prime * result + ((getOrgLvCd() == null) ? 0 : getOrgLvCd().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getPostNum() == null) ? 0 : getPostNum().hashCode());
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getDoUrl() == null) ? 0 : getDoUrl().hashCode());
        result = prime * result + ((getViewUrl() == null) ? 0 : getViewUrl().hashCode());
        result = prime * result + ((getServiceName() == null) ? 0 : getServiceName().hashCode());
        result = prime * result + ((getServiceVersion() == null) ? 0 : getServiceVersion().hashCode());
        result = prime * result + ((getSaveUrl() == null) ? 0 : getSaveUrl().hashCode());
        result = prime * result + ((getSelectType() == null) ? 0 : getSelectType().hashCode());
        result = prime * result + ((getUserVariable() == null) ? 0 : getUserVariable().hashCode());
        result = prime * result + ((getTemplateName() == null) ? 0 : getTemplateName().hashCode());
        result = prime * result + ((getTemplateVersion() == null) ? 0 : getTemplateVersion().hashCode());
        result = prime * result + ((getReTarget() == null) ? 0 : getReTarget().hashCode());
        result = prime * result + ((getFinalJudge() == null) ? 0 : getFinalJudge().hashCode());
        result = prime * result + ((getProcessMappingId() == null) ? 0 : getProcessMappingId().hashCode());
        result = prime * result + ((getActivityDefId() == null) ? 0 : getActivityDefId().hashCode());
        return result;
    }
}