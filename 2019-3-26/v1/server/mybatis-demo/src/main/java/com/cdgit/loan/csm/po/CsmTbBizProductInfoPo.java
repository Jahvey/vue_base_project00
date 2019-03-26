package com.cdgit.loan.csm.po;

public class CsmTbBizProductInfoPo {
    private String id;

    private String productCd;

    private String entityName;

    private String jspName;

    private String productName;

    private String tableName;

    private String rate;

    private String bizDon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProductCd() {
        return productCd;
    }

    public void setProductCd(String productCd) {
        this.productCd = productCd == null ? null : productCd.trim();
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName == null ? null : entityName.trim();
    }

    public String getJspName() {
        return jspName;
    }

    public void setJspName(String jspName) {
        this.jspName = jspName == null ? null : jspName.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    public String getBizDon() {
        return bizDon;
    }

    public void setBizDon(String bizDon) {
        this.bizDon = bizDon == null ? null : bizDon.trim();
    }
}