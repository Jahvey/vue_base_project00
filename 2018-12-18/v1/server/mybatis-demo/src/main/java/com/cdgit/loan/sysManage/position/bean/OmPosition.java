package com.cdgit.loan.sysManage.position.bean;

import java.util.Date;

public class OmPosition {
    private Long positionid;

    private String posicode;

    private String posiname;

    private Short posilevel;

    private Long manaposi;

    private Long dutyid;

    private Long orgid;

    private String positionseq;

    private String positype;

    private Date createtime;

    private Date lastupdate;

    private Long updator;

    private Date startdate;

    private Date enddate;

    private String status;

    private String isleaf;

    private Long subcount;
    
    private String legOrg;
   
    private String posistate;

    public String getLegOrg() {
		return legOrg;
	}

	public void setLegOrg(String legOrg) {
		this.legOrg = legOrg;
	}

	public String getPosistate() {
		return posistate;
	}

	public void setPosistate(String posistate) {
		this.posistate = posistate;
	}

	public Long getPositionid() {
        return positionid;
    }

    public void setPositionid(Long positionid) {
        this.positionid = positionid;
    }

    public String getPosicode() {
        return posicode;
    }

    public void setPosicode(String posicode) {
        this.posicode = posicode == null ? null : posicode.trim();
    }

    public String getPosiname() {
        return posiname;
    }

    public void setPosiname(String posiname) {
        this.posiname = posiname == null ? null : posiname.trim();
    }

    public Short getPosilevel() {
        return posilevel;
    }

    public void setPosilevel(Short posilevel) {
        this.posilevel = posilevel;
    }

    public Long getManaposi() {
        return manaposi;
    }

    public void setManaposi(Long manaposi) {
        this.manaposi = manaposi;
    }

    public Long getDutyid() {
        return dutyid;
    }

    public void setDutyid(Long dutyid) {
        this.dutyid = dutyid;
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public String getPositionseq() {
        return positionseq;
    }

    public void setPositionseq(String positionseq) {
        this.positionseq = positionseq == null ? null : positionseq.trim();
    }

    public String getPositype() {
        return positype;
    }

    public void setPositype(String positype) {
        this.positype = positype == null ? null : positype.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public Long getUpdator() {
        return updator;
    }

    public void setUpdator(Long updator) {
        this.updator = updator;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(String isleaf) {
        this.isleaf = isleaf == null ? null : isleaf.trim();
    }

    public Long getSubcount() {
        return subcount;
    }

    public void setSubcount(Long subcount) {
        this.subcount = subcount;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OmPosition other = (OmPosition) obj;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (dutyid == null) {
			if (other.dutyid != null)
				return false;
		} else if (!dutyid.equals(other.dutyid))
			return false;
		if (enddate == null) {
			if (other.enddate != null)
				return false;
		} else if (!enddate.equals(other.enddate))
			return false;
		if (isleaf == null) {
			if (other.isleaf != null)
				return false;
		} else if (!isleaf.equals(other.isleaf))
			return false;
		if (lastupdate == null) {
			if (other.lastupdate != null)
				return false;
		} else if (!lastupdate.equals(other.lastupdate))
			return false;
		if (legOrg == null) {
			if (other.legOrg != null)
				return false;
		} else if (!legOrg.equals(other.legOrg))
			return false;
		if (manaposi == null) {
			if (other.manaposi != null)
				return false;
		} else if (!manaposi.equals(other.manaposi))
			return false;
		if (orgid == null) {
			if (other.orgid != null)
				return false;
		} else if (!orgid.equals(other.orgid))
			return false;
		if (posicode == null) {
			if (other.posicode != null)
				return false;
		} else if (!posicode.equals(other.posicode))
			return false;
		if (posilevel == null) {
			if (other.posilevel != null)
				return false;
		} else if (!posilevel.equals(other.posilevel))
			return false;
		if (posiname == null) {
			if (other.posiname != null)
				return false;
		} else if (!posiname.equals(other.posiname))
			return false;
		if (posistate == null) {
			if (other.posistate != null)
				return false;
		} else if (!posistate.equals(other.posistate))
			return false;
		if (positionid == null) {
			if (other.positionid != null)
				return false;
		} else if (!positionid.equals(other.positionid))
			return false;
		if (positionseq == null) {
			if (other.positionseq != null)
				return false;
		} else if (!positionseq.equals(other.positionseq))
			return false;
		if (positype == null) {
			if (other.positype != null)
				return false;
		} else if (!positype.equals(other.positype))
			return false;
		if (startdate == null) {
			if (other.startdate != null)
				return false;
		} else if (!startdate.equals(other.startdate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subcount == null) {
			if (other.subcount != null)
				return false;
		} else if (!subcount.equals(other.subcount))
			return false;
		if (updator == null) {
			if (other.updator != null)
				return false;
		} else if (!updator.equals(other.updator))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + ((dutyid == null) ? 0 : dutyid.hashCode());
		result = prime * result + ((enddate == null) ? 0 : enddate.hashCode());
		result = prime * result + ((isleaf == null) ? 0 : isleaf.hashCode());
		result = prime * result + ((lastupdate == null) ? 0 : lastupdate.hashCode());
		result = prime * result + ((legOrg == null) ? 0 : legOrg.hashCode());
		result = prime * result + ((manaposi == null) ? 0 : manaposi.hashCode());
		result = prime * result + ((orgid == null) ? 0 : orgid.hashCode());
		result = prime * result + ((posicode == null) ? 0 : posicode.hashCode());
		result = prime * result + ((posilevel == null) ? 0 : posilevel.hashCode());
		result = prime * result + ((posiname == null) ? 0 : posiname.hashCode());
		result = prime * result + ((posistate == null) ? 0 : posistate.hashCode());
		result = prime * result + ((positionid == null) ? 0 : positionid.hashCode());
		result = prime * result + ((positionseq == null) ? 0 : positionseq.hashCode());
		result = prime * result + ((positype == null) ? 0 : positype.hashCode());
		result = prime * result + ((startdate == null) ? 0 : startdate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subcount == null) ? 0 : subcount.hashCode());
		result = prime * result + ((updator == null) ? 0 : updator.hashCode());
		return result;
	}
}