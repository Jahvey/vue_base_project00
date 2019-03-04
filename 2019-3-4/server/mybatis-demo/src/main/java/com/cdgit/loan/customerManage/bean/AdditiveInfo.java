package com.cdgit.loan.customerManage.bean;

public class AdditiveInfo {
    private String id;

    private String partyId;

    private String title;

    private String detailInfo;
    
    //查询字段
    private String partyNum;

    private String partyName;

    
    public String getPartyNum() {
		return partyNum;
	}

	public void setPartyNum(String partyNum) {
		this.partyNum = partyNum;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo == null ? null : detailInfo.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AdditiveInfo other = (AdditiveInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDetailInfo() == null ? other.getDetailInfo() == null : this.getDetailInfo().equals(other.getDetailInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDetailInfo() == null) ? 0 : getDetailInfo().hashCode());
        return result;
    }
}