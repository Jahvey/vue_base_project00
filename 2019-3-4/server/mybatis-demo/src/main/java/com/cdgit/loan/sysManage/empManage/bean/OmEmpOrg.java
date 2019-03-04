package com.cdgit.loan.sysManage.empManage.bean;

public class OmEmpOrg {
	
	private Long orgid;
	
	private Long empid;
	
	private String ismain; //是否主机构：1:是  2:否

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getIsmain() {
		return ismain;
	}

	public void setIsmain(String ismain) {
		this.ismain = ismain;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empid == null) ? 0 : empid.hashCode());
		result = prime * result + ((ismain == null) ? 0 : ismain.hashCode());
		result = prime * result + ((orgid == null) ? 0 : orgid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OmEmpOrg other = (OmEmpOrg) obj;
		if (empid == null) {
			if (other.empid != null)
				return false;
		} else if (!empid.equals(other.empid))
			return false;
		if (ismain == null) {
			if (other.ismain != null)
				return false;
		} else if (!ismain.equals(other.ismain))
			return false;
		if (orgid == null) {
			if (other.orgid != null)
				return false;
		} else if (!orgid.equals(other.orgid))
			return false;
		return true;
	}
	
	
}
