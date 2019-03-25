package com.cdgit.loan.contractsign.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 主合同与、从合同公共bean
 * @author wuyong
 *
 */
public class ContractBean {
   private String contractId;//主合同id
   private String subcontractId;//担保合同id
   private String conSubconId;//贷款合同与担保合同关系表id
   private String uuid;//通知书和文书送达主键
   private String attached;//仲裁方式及签署信息主键
   private String subcontractNum;//抵押合同编号
   private String partyName;//抵押人名称
   private String paperConNum;//抵押合同纸质编号
   private String ifTopSubcon;//是否最高额抵押
   private String guarantyType;//主合同 中的担保方式
   private String proguarantyWay;//担保合同保证担保方式
   private String proguarantyType;//担保合同保证担保类型
   private String proguarantyForm;//担保合同保证担保形式
   //保证金相关内容
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal jrncrbzj;//几日内存入保证金
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal bzjbl;//保证金比例(%)
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal bzjje;//保证金金额
   private String bzjlx;//保证金类型
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal anlljx;//按年利率计息(%)
   private String qtjsxfs;//其他计收利息方式
   private String bzjjxzq;//保证金结息周期
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal jrtzkh;//若保证金价值下降，应在几日内通知客户补充保证金
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal contractAmt;//主合同 中合同金额
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal changePercent;//保证人股权变更达到（）%时，应取得债权人的书面同意
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal dbRate;//担保债务百分比(%)
   private String bz;//币种
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal subcontractAmt;//抵押合同金额
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal zgbjxe;//抵押最高本金限额
   @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
   private Date beginDate;//抵押额度起期
   @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
   private Date endDate;//抵押额度止期
   @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
   private Date signDate;//签订日期
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal jggzrbldj;//几个工作日内办理登记
   private String subScope;//担保范围
   /*主合同*/
   private String productType;//业务品种
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal mBzjbl;//主合同的保证金比例
   /*通知和文书送达*/
   private String aSendAddr;
   private String aPostcode;
   private String aReceiver;
   private String aPhone;
   private String aEmail;
   private String aOther;
   private String bSendAddr;
   private String bPostcode;
   private String bReceiver;
   private String bPhone;
   private String bEmail;
   private String cSendAddr;
   private String cPostcode;
   private String cReceiver;
   private String cPhone;
   private String cEmail;
   private String dSendAddr;
   private String dPostcode;
   private String dReceiver;
   private String dPhone;
   private String dEmail;
   /*仲裁方式*/
   private String arbitrateType;//仲裁方式
   private String arbitrateName;//仲裁委员会名称
   private String arbitrateAddress;//仲裁委员会地址
   private String legalCourt;//指定诉讼法院
   /*协议签署*/
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal aHoldCount;//甲方持有份数
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal bHoldCount;//乙方持有份数
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal dHoldCount;//丙方持有份数
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal eHoldCount;//丁方持有份数
   private String cName;//第三方名称
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal cHoldCount;//第三方名称持有份数
   @JsonSerialize(using=BigDecimalConvertToString.class)
   private BigDecimal totalCount;//共计份数
   /*补充条款*/
   private String addClause;//补充条款
 
   
public BigDecimal getmBzjbl() {
	return mBzjbl;
}
public void setmBzjbl(BigDecimal mBzjbl) {
	this.mBzjbl = mBzjbl;
}
public String getProductType() {
	return productType;
}
public void setProductType(String productType) {
	this.productType = productType;
}
public BigDecimal getJrncrbzj() {
	return jrncrbzj;
}
public void setJrncrbzj(BigDecimal jrncrbzj) {
	this.jrncrbzj = jrncrbzj;
}
public BigDecimal getBzjbl() {
	return bzjbl;
}
public void setBzjbl(BigDecimal bzjbl) {
	this.bzjbl = bzjbl;
}
public BigDecimal getBzjje() {
	return bzjje;
}
public void setBzjje(BigDecimal bzjje) {
	this.bzjje = bzjje;
}
public String getBzjlx() {
	return bzjlx;
}
public void setBzjlx(String bzjlx) {
	this.bzjlx = bzjlx;
}
public BigDecimal getAnlljx() {
	return anlljx;
}
public void setAnlljx(BigDecimal anlljx) {
	this.anlljx = anlljx;
}
public String getQtjsxfs() {
	return qtjsxfs;
}
public void setQtjsxfs(String qtjsxfs) {
	this.qtjsxfs = qtjsxfs;
}
public String getBzjjxzq() {
	return bzjjxzq;
}
public void setBzjjxzq(String bzjjxzq) {
	this.bzjjxzq = bzjjxzq;
}
public BigDecimal getJrtzkh() {
	return jrtzkh;
}
public void setJrtzkh(BigDecimal jrtzkh) {
	this.jrtzkh = jrtzkh;
}
public String getProguarantyWay() {
	return proguarantyWay;
}
public void setProguarantyWay(String proguarantyWay) {
	this.proguarantyWay = proguarantyWay;
}
public String getProguarantyType() {
	return proguarantyType;
}
public void setProguarantyType(String proguarantyType) {
	this.proguarantyType = proguarantyType;
}
public String getProguarantyForm() {
	return proguarantyForm;
}
public void setProguarantyForm(String proguarantyForm) {
	this.proguarantyForm = proguarantyForm;
}
public BigDecimal getContractAmt() {
	return contractAmt;
}
public void setContractAmt(BigDecimal contractAmt) {
	this.contractAmt = contractAmt;
}
public String getGuarantyType() {
	return guarantyType;
}
public void setGuarantyType(String guarantyType) {
	this.guarantyType = guarantyType;
}
public BigDecimal getChangePercent() {
	return changePercent;
}
public void setChangePercent(BigDecimal changePercent) {
	this.changePercent = changePercent;
}
public BigDecimal getDbRate() {
	return dbRate;
}
public void setDbRate(BigDecimal dbRate) {
	this.dbRate = dbRate;
}
public String getUuid() {
	return uuid;
}
public void setUuid(String uuid) {
	this.uuid = uuid;
}
public String getAttached() {
	return attached;
}
public void setAttached(String attached) {
	this.attached = attached;
}
public String getContractId() {
	return contractId;
}
public void setContractId(String contractId) {
	this.contractId = contractId;
}
public String getSubcontractId() {
	return subcontractId;
}
public void setSubcontractId(String subcontractId) {
	this.subcontractId = subcontractId;
}
public String getConSubconId() {
	return conSubconId;
}
public void setConSubconId(String conSubconId) {
	this.conSubconId = conSubconId;
}
public String getSubcontractNum() {
	return subcontractNum;
}
public void setSubcontractNum(String subcontractNum) {
	this.subcontractNum = subcontractNum;
}
public String getPartyName() {
	return partyName;
}
public void setPartyName(String partyName) {
	this.partyName = partyName;
}
public String getPaperConNum() {
	return paperConNum;
}
public void setPaperConNum(String paperConNum) {
	this.paperConNum = paperConNum;
}
public String getIfTopSubcon() {
	return ifTopSubcon;
}
public void setIfTopSubcon(String ifTopSubcon) {
	this.ifTopSubcon = ifTopSubcon;
}
public String getBz() {
	return bz;
}
public void setBz(String bz) {
	this.bz = bz;
}
public BigDecimal getSubcontractAmt() {
	return subcontractAmt;
}
public void setSubcontractAmt(BigDecimal subcontractAmt) {
	this.subcontractAmt = subcontractAmt;
}
public BigDecimal getZgbjxe() {
	return zgbjxe;
}
public void setZgbjxe(BigDecimal zgbjxe) {
	this.zgbjxe = zgbjxe;
}
public Date getBeginDate() {
	return beginDate;
}
public void setBeginDate(Date beginDate) {
	this.beginDate = beginDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public Date getSignDate() {
	return signDate;
}
public void setSignDate(Date signDate) {
	this.signDate = signDate;
}
public BigDecimal getJggzrbldj() {
	return jggzrbldj;
}
public void setJggzrbldj(BigDecimal jggzrbldj) {
	this.jggzrbldj = jggzrbldj;
}
public String getSubScope() {
	return subScope;
}
public void setSubScope(String subScope) {
	this.subScope = subScope;
}
public String getaSendAddr() {
	return aSendAddr;
}
public void setaSendAddr(String aSendAddr) {
	this.aSendAddr = aSendAddr;
}
public String getaPostcode() {
	return aPostcode;
}
public void setaPostcode(String aPostcode) {
	this.aPostcode = aPostcode;
}
public String getaReceiver() {
	return aReceiver;
}
public void setaReceiver(String aReceiver) {
	this.aReceiver = aReceiver;
}
public String getaPhone() {
	return aPhone;
}
public void setaPhone(String aPhone) {
	this.aPhone = aPhone;
}
public String getaEmail() {
	return aEmail;
}
public void setaEmail(String aEmail) {
	this.aEmail = aEmail;
}
public String getaOther() {
	return aOther;
}
public void setaOther(String aOther) {
	this.aOther = aOther;
}
public String getbSendAddr() {
	return bSendAddr;
}
public void setbSendAddr(String bSendAddr) {
	this.bSendAddr = bSendAddr;
}
public String getbPostcode() {
	return bPostcode;
}
public void setbPostcode(String bPostcode) {
	this.bPostcode = bPostcode;
}
public String getbReceiver() {
	return bReceiver;
}
public void setbReceiver(String bReceiver) {
	this.bReceiver = bReceiver;
}
public String getbPhone() {
	return bPhone;
}
public void setbPhone(String bPhone) {
	this.bPhone = bPhone;
}
public String getbEmail() {
	return bEmail;
}
public void setbEmail(String bEmail) {
	this.bEmail = bEmail;
}
public String getcSendAddr() {
	return cSendAddr;
}
public void setcSendAddr(String cSendAddr) {
	this.cSendAddr = cSendAddr;
}
public String getcPostcode() {
	return cPostcode;
}
public void setcPostcode(String cPostcode) {
	this.cPostcode = cPostcode;
}
public String getcReceiver() {
	return cReceiver;
}
public void setcReceiver(String cReceiver) {
	this.cReceiver = cReceiver;
}
public String getcPhone() {
	return cPhone;
}
public void setcPhone(String cPhone) {
	this.cPhone = cPhone;
}
public String getcEmail() {
	return cEmail;
}
public void setcEmail(String cEmail) {
	this.cEmail = cEmail;
}
public String getdSendAddr() {
	return dSendAddr;
}
public void setdSendAddr(String dSendAddr) {
	this.dSendAddr = dSendAddr;
}
public String getdPostcode() {
	return dPostcode;
}
public void setdPostcode(String dPostcode) {
	this.dPostcode = dPostcode;
}
public String getdReceiver() {
	return dReceiver;
}
public void setdReceiver(String dReceiver) {
	this.dReceiver = dReceiver;
}
public String getdPhone() {
	return dPhone;
}
public void setdPhone(String dPhone) {
	this.dPhone = dPhone;
}
public String getdEmail() {
	return dEmail;
}
public void setdEmail(String dEmail) {
	this.dEmail = dEmail;
}
public String getArbitrateType() {
	return arbitrateType;
}
public void setArbitrateType(String arbitrateType) {
	this.arbitrateType = arbitrateType;
}
public String getArbitrateName() {
	return arbitrateName;
}
public void setArbitrateName(String arbitrateName) {
	this.arbitrateName = arbitrateName;
}
public String getArbitrateAddress() {
	return arbitrateAddress;
}
public void setArbitrateAddress(String arbitrateAddress) {
	this.arbitrateAddress = arbitrateAddress;
}
public String getLegalCourt() {
	return legalCourt;
}
public void setLegalCourt(String legalCourt) {
	this.legalCourt = legalCourt;
}
public BigDecimal getaHoldCount() {
	return aHoldCount;
}
public void setaHoldCount(BigDecimal aHoldCount) {
	this.aHoldCount = aHoldCount;
}
public BigDecimal getbHoldCount() {
	return bHoldCount;
}
public void setbHoldCount(BigDecimal bHoldCount) {
	this.bHoldCount = bHoldCount;
}
public BigDecimal getdHoldCount() {
	return dHoldCount;
}
public void setdHoldCount(BigDecimal dHoldCount) {
	this.dHoldCount = dHoldCount;
}
public BigDecimal geteHoldCount() {
	return eHoldCount;
}
public void seteHoldCount(BigDecimal eHoldCount) {
	this.eHoldCount = eHoldCount;
}
public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName = cName;
}
public BigDecimal getcHoldCount() {
	return cHoldCount;
}
public void setcHoldCount(BigDecimal cHoldCount) {
	this.cHoldCount = cHoldCount;
}
public BigDecimal getTotalCount() {
	return totalCount;
}
public void setTotalCount(BigDecimal totalCount) {
	this.totalCount = totalCount;
}
public String getAddClause() {
	return addClause;
}
public void setAddClause(String addClause) {
	this.addClause = addClause;
}
@Override
public String toString() {
	return "ContractBean [contractId=" + contractId + ", subcontractId=" + subcontractId + ", conSubconId="
			+ conSubconId + ", uuid=" + uuid + ", attached=" + attached + ", subcontractNum=" + subcontractNum
			+ ", partyName=" + partyName + ", paperConNum=" + paperConNum + ", ifTopSubcon=" + ifTopSubcon + ", bz="
			+ bz + ", subcontractAmt=" + subcontractAmt + ", zgbjxe=" + zgbjxe + ", beginDate=" + beginDate
			+ ", endDate=" + endDate + ", signDate=" + signDate + ", jggzrbldj=" + jggzrbldj + ", subScope=" + subScope
			+ ", aSendAddr=" + aSendAddr + ", aPostcode=" + aPostcode + ", aReceiver=" + aReceiver + ", aPhone="
			+ aPhone + ", aEmail=" + aEmail + ", aOther=" + aOther + ", bSendAddr=" + bSendAddr + ", bPostcode="
			+ bPostcode + ", bReceiver=" + bReceiver + ", bPhone=" + bPhone + ", bEmail=" + bEmail + ", cSendAddr="
			+ cSendAddr + ", cPostcode=" + cPostcode + ", cReceiver=" + cReceiver + ", cPhone=" + cPhone + ", cEmail="
			+ cEmail + ", dSendAddr=" + dSendAddr + ", dPostcode=" + dPostcode + ", dReceiver=" + dReceiver
			+ ", dPhone=" + dPhone + ", dEmail=" + dEmail + ", arbitrateType=" + arbitrateType + ", arbitrateName="
			+ arbitrateName + ", arbitrateAddress=" + arbitrateAddress + ", legalCourt=" + legalCourt + ", aHoldCount="
			+ aHoldCount + ", bHoldCount=" + bHoldCount + ", dHoldCount=" + dHoldCount + ", eHoldCount=" + eHoldCount
			+ ", cName=" + cName + ", cHoldCount=" + cHoldCount + ", totalCount=" + totalCount + ", addClause="
			+ addClause + "]";
}
   
   
}
