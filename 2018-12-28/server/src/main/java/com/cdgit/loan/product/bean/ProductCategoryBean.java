package com.cdgit.loan.product.bean;

import java.util.List;

public class ProductCategoryBean {

	private String label;// 节点名字  或者叫name
	
	private String parentId;//父节点id
	
	private String childId;//当前节点id
	
	private List<?> childList;//子节点数据

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getChildId() {
		return childId;
	}

	public void setChildId(String childId) {
		this.childId = childId;
	}

	public List<?> getChildList() {
		return childList;
	}

	public void setChildList(List<?> childList) {
		this.childList = childList;
	}
}
