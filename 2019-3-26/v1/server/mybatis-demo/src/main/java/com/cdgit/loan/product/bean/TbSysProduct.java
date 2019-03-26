package com.cdgit.loan.product.bean;

import java.util.Date;
import java.util.List;

public class TbSysProduct {
    
    private String productCd;
    
    private String productId;
    
    private String productName;
    
    private String superiorId;
    
    private String department;
    
    private String ywlb;
    
    private String legOrg;
    
   private String productLevel;
   
   private List childList;//目前先定义在这里

public String getProductCd() {
	return productCd;
}

public void setProductCd(String productCd) {
	this.productCd = productCd;
}

public String getProductId() {
	return productId;
}

public void setProductId(String productId) {
	this.productId = productId;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getSuperiorId() {
	return superiorId;
}

public void setSuperiorId(String superiorId) {
	this.superiorId = superiorId;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public String getYwlb() {
	return ywlb;
}

public void setYwlb(String ywlb) {
	this.ywlb = ywlb;
}

public String getLegOrg() {
	return legOrg;
}

public void setLegOrg(String legOrg) {
	this.legOrg = legOrg;
}

public String getProductLevel() {
	return productLevel;
}

public void setProductLevel(String productLevel) {
	this.productLevel = productLevel;
}

public List getChildList() {
	return childList;
}

public void setChildList(List childList) {
	this.childList = childList;
}
}