package com.cdgit.loan.contract.bean;

/**
 * Tb_Biz_Product_Info：产品信息表
 * @author Administrator
 *
 */
public class CrtTbBizProductInfo {
	
    private String id;				//主键（这个id是怎么生成的？？有产品类型，也有数字）

    private String productCd;		//产品代码

    private String entityName;		//实体名称

    private String jspName;			//页面名称

    private String productName;		//品种名称

    private String tableName;		//表名

    private String rate;			//利率信息

    private String bizDon;			//业务别

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