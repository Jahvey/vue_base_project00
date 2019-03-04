/**
 * 
 */
package com.cdgit.loan.csm.po;

/**
 * @author Administrator
 *
 */
public class TbConAttachedInfoPo {//TB_CON_ATTACHED_INFO
	
	  private String attached;

	    private String contractId;

	    private String arbitrateType;

	    private String arbitrateName;

	    private String arbitrateAddress;

	    private String other;

	    private Integer aHoldCount;

	    private Integer bHoldCount;

	    private String cType;

	    private Integer cHoldCount;

	    private Integer totalCount;

	    private String addClause;

	    private String constraintIndex;

	    private Integer dHoldCount;

	    private Integer eHoldCount;

	    private String tkCondition;

	    private String cName;

	    private String legalCourt;

	    public String getAttached() {
	        return attached;
	    }

	    public void setAttached(String attached) {
	        this.attached = attached == null ? null : attached.trim();
	    }

	    public String getContractId() {
	        return contractId;
	    }

	    public void setContractId(String contractId) {
	        this.contractId = contractId == null ? null : contractId.trim();
	    }

	    public String getArbitrateType() {
	        return arbitrateType;
	    }

	    public void setArbitrateType(String arbitrateType) {
	        this.arbitrateType = arbitrateType == null ? null : arbitrateType.trim();
	    }

	    public String getArbitrateName() {
	        return arbitrateName;
	    }

	    public void setArbitrateName(String arbitrateName) {
	        this.arbitrateName = arbitrateName == null ? null : arbitrateName.trim();
	    }

	    public String getArbitrateAddress() {
	        return arbitrateAddress;
	    }

	    public void setArbitrateAddress(String arbitrateAddress) {
	        this.arbitrateAddress = arbitrateAddress == null ? null : arbitrateAddress.trim();
	    }

	    public String getOther() {
	        return other;
	    }

	    public void setOther(String other) {
	        this.other = other == null ? null : other.trim();
	    }

	    public Integer getaHoldCount() {
	        return aHoldCount;
	    }

	    public void setaHoldCount(Integer aHoldCount) {
	        this.aHoldCount = aHoldCount;
	    }

	    public Integer getbHoldCount() {
	        return bHoldCount;
	    }

	    public void setbHoldCount(Integer bHoldCount) {
	        this.bHoldCount = bHoldCount;
	    }

	    public String getcType() {
	        return cType;
	    }

	    public void setcType(String cType) {
	        this.cType = cType == null ? null : cType.trim();
	    }

	    public Integer getcHoldCount() {
	        return cHoldCount;
	    }

	    public void setcHoldCount(Integer cHoldCount) {
	        this.cHoldCount = cHoldCount;
	    }

	    public Integer getTotalCount() {
	        return totalCount;
	    }

	    public void setTotalCount(Integer totalCount) {
	        this.totalCount = totalCount;
	    }

	    public String getAddClause() {
	        return addClause;
	    }

	    public void setAddClause(String addClause) {
	        this.addClause = addClause == null ? null : addClause.trim();
	    }

	    public String getConstraintIndex() {
	        return constraintIndex;
	    }

	    public void setConstraintIndex(String constraintIndex) {
	        this.constraintIndex = constraintIndex == null ? null : constraintIndex.trim();
	    }

	    public Integer getdHoldCount() {
	        return dHoldCount;
	    }

	    public void setdHoldCount(Integer dHoldCount) {
	        this.dHoldCount = dHoldCount;
	    }

	    public Integer geteHoldCount() {
	        return eHoldCount;
	    }

	    public void seteHoldCount(Integer eHoldCount) {
	        this.eHoldCount = eHoldCount;
	    }

	    public String getTkCondition() {
	        return tkCondition;
	    }

	    public void setTkCondition(String tkCondition) {
	        this.tkCondition = tkCondition == null ? null : tkCondition.trim();
	    }

	    public String getcName() {
	        return cName;
	    }

	    public void setcName(String cName) {
	        this.cName = cName == null ? null : cName.trim();
	    }

	    public String getLegalCourt() {
	        return legalCourt;
	    }

	    public void setLegalCourt(String legalCourt) {
	        this.legalCourt = legalCourt == null ? null : legalCourt.trim();
	    }

		@Override
		public String toString() {
			return "TbConAttachedInfoPo [attached=" + attached + ", contractId=" + contractId + ", arbitrateType="
					+ arbitrateType + ", arbitrateName=" + arbitrateName + ", arbitrateAddress=" + arbitrateAddress
					+ ", other=" + other + ", aHoldCount=" + aHoldCount + ", bHoldCount=" + bHoldCount + ", cType="
					+ cType + ", cHoldCount=" + cHoldCount + ", totalCount=" + totalCount + ", addClause=" + addClause
					+ ", constraintIndex=" + constraintIndex + ", dHoldCount=" + dHoldCount + ", eHoldCount="
					+ eHoldCount + ", tkCondition=" + tkCondition + ", cName=" + cName + ", legalCourt=" + legalCourt
					+ "]";
		}
	    
	    

}
