package com.cdgit.loan.workflow.bean;

public class TbWfmProcessmapping {
    private String processMappingId;

    private String templateName;

    private String templageVersion;

    private String productType;

    private String bizType;

    private String bizViewUrl;

    private String versionStatus;

    public String getProcessMappingId() {
        return processMappingId;
    }

    public void setProcessMappingId(String processMappingId) {
        this.processMappingId = processMappingId == null ? null : processMappingId.trim();
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public String getTemplageVersion() {
        return templageVersion;
    }

    public void setTemplageVersion(String templageVersion) {
        this.templageVersion = templageVersion == null ? null : templageVersion.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getBizViewUrl() {
        return bizViewUrl;
    }

    public void setBizViewUrl(String bizViewUrl) {
        this.bizViewUrl = bizViewUrl == null ? null : bizViewUrl.trim();
    }

    public String getVersionStatus() {
        return versionStatus;
    }

    public void setVersionStatus(String versionStatus) {
        this.versionStatus = versionStatus == null ? null : versionStatus.trim();
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
        TbWfmProcessmapping other = (TbWfmProcessmapping) that;
        return (this.getProcessMappingId() == null ? other.getProcessMappingId() == null : this.getProcessMappingId().equals(other.getProcessMappingId()))
            && (this.getTemplateName() == null ? other.getTemplateName() == null : this.getTemplateName().equals(other.getTemplateName()))
            && (this.getTemplageVersion() == null ? other.getTemplageVersion() == null : this.getTemplageVersion().equals(other.getTemplageVersion()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getBizType() == null ? other.getBizType() == null : this.getBizType().equals(other.getBizType()))
            && (this.getBizViewUrl() == null ? other.getBizViewUrl() == null : this.getBizViewUrl().equals(other.getBizViewUrl()))
            && (this.getVersionStatus() == null ? other.getVersionStatus() == null : this.getVersionStatus().equals(other.getVersionStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProcessMappingId() == null) ? 0 : getProcessMappingId().hashCode());
        result = prime * result + ((getTemplateName() == null) ? 0 : getTemplateName().hashCode());
        result = prime * result + ((getTemplageVersion() == null) ? 0 : getTemplageVersion().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getBizType() == null) ? 0 : getBizType().hashCode());
        result = prime * result + ((getBizViewUrl() == null) ? 0 : getBizViewUrl().hashCode());
        result = prime * result + ((getVersionStatus() == null) ? 0 : getVersionStatus().hashCode());
        return result;
    }
}