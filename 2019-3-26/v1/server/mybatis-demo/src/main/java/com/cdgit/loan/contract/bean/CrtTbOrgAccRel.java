package com.cdgit.loan.contract.bean;

import java.util.Date;

/**
 * 经办机构与会计机构关联表：TB_ORG_ACC_REL
 * @author mch
 *
 */
public class CrtTbOrgAccRel {
	
    private String orgRelId;		//主键

    private String accOrgId;		//会计机构ID

    private String accOrgNo;		//会计机构编号

    private String oprOrgId;		//经办机构ID

    private String oprOrgNo;		//经办机构编号

    private String oprUserId;		//操作员ID

    private String oprUserNo;		//操作员编号

    private String productId;		//产品ID

    private String productNo;		//产品编号

    private String status;			//状态

    private Date createTime;		//创建时间

    private Date updateTime;		//更新时间

    private String col1;			//是否手工数据

    private String col2;			//入账类型:(XD_RZLX)

    private String col3;			//备流3

    public String getOrgRelId() {
        return orgRelId;
    }

    public void setOrgRelId(String orgRelId) {
        this.orgRelId = orgRelId == null ? null : orgRelId.trim();
    }

    public String getAccOrgId() {
        return accOrgId;
    }

    public void setAccOrgId(String accOrgId) {
        this.accOrgId = accOrgId == null ? null : accOrgId.trim();
    }

    public String getAccOrgNo() {
        return accOrgNo;
    }

    public void setAccOrgNo(String accOrgNo) {
        this.accOrgNo = accOrgNo == null ? null : accOrgNo.trim();
    }

    public String getOprOrgId() {
        return oprOrgId;
    }

    public void setOprOrgId(String oprOrgId) {
        this.oprOrgId = oprOrgId == null ? null : oprOrgId.trim();
    }

    public String getOprOrgNo() {
        return oprOrgNo;
    }

    public void setOprOrgNo(String oprOrgNo) {
        this.oprOrgNo = oprOrgNo == null ? null : oprOrgNo.trim();
    }

    public String getOprUserId() {
        return oprUserId;
    }

    public void setOprUserId(String oprUserId) {
        this.oprUserId = oprUserId == null ? null : oprUserId.trim();
    }

    public String getOprUserNo() {
        return oprUserNo;
    }

    public void setOprUserNo(String oprUserNo) {
        this.oprUserNo = oprUserNo == null ? null : oprUserNo.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1 == null ? null : col1.trim();
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2 == null ? null : col2.trim();
    }

    public String getCol3() {
        return col3;
    }

    public void setCol3(String col3) {
        this.col3 = col3 == null ? null : col3.trim();
    }
}