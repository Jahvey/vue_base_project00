package com.cdgit.loan.ledger.naturalperson.bean;
/**封装同业客户查询结果集*/
public class InterbankCustResult {
	private String orgNum;//机构名称
	private String areaType;//区域类型
	private String financeEnterpriseType;//金融机构类型
	private String unifySocietyCreditNum;//统一社会信用代码
	private String registerCode;//营业执照
	private String orgRegisterCd;//组织机构代码
	private String swiftBicNum;//swift码
	private String partyName;//客户名称
	private String userNum;//管户经理
	private String englishCustomerName;
	private String partyId;
	public String getEnglishCustomerName() {
		return englishCustomerName;
	}
	public void setEnglishCustomerName(String englishCustomerName) {
		this.englishCustomerName = englishCustomerName;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getAreaType() {
		return areaType;
	}
	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}
	public String getFinanceEnterpriseType() {
		return financeEnterpriseType;
	}
	public void setFinanceEnterpriseType(String financeEnterpriseType) {
		this.financeEnterpriseType = financeEnterpriseType;
	}
	public String getUnifySocietyCreditNum() {
		return unifySocietyCreditNum;
	}
	public void setUnifySocietyCreditNum(String unifySocietyCreditNum) {
		this.unifySocietyCreditNum = unifySocietyCreditNum;
	}
	public String getRegisterCode() {
		return registerCode;
	}
	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}
	public String getOrgRegisterCd() {
		return orgRegisterCd;
	}
	public void setOrgRegisterCd(String orgRegisterCd) {
		this.orgRegisterCd = orgRegisterCd;
	}
	public String getSwiftBicNum() {
		return swiftBicNum;
	}
	public void setSwiftBicNum(String swiftBicNum) {
		this.swiftBicNum = swiftBicNum;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
}
