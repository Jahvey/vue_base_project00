package com.cdgit.loan.sysManage.acMenu.bean;

import java.util.List;

import com.google.common.collect.Lists;

public class AcMenu {
    private String menuid;

    private String menuname;

    private String menulabel;

    private String menucode;

    private String isleaf;

    private String menuaction;

    private String parameter;

    private String uientry;

    private String menulevel;

    private String rootid;

    private String parentsid;

    private String displayorder;

    private String imagepath;

    private String expandpath;

    private String menuseq;

    private String openmode;

    private Long subcount;

    private Long appid;

    private String funccode;
    
    private String parentname;
    
    private String type;
    
    private List<AcMenu> children = Lists.newArrayList();

    public List<AcMenu> getChildren() {
		return children;
	}

	public void setChildren(List<AcMenu> children) {
		this.children = children;
	}

	public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getMenulabel() {
        return menulabel;
    }

    public void setMenulabel(String menulabel) {
        this.menulabel = menulabel == null ? null : menulabel.trim();
    }

    public String getMenucode() {
        return menucode;
    }

    public void setMenucode(String menucode) {
        this.menucode = menucode == null ? null : menucode.trim();
    }

    public String getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(String isleaf) {
        this.isleaf = isleaf == null ? null : isleaf.trim();
    }

    public String getMenuaction() {
        return menuaction;
    }

    public void setMenuaction(String menuaction) {
        this.menuaction = menuaction == null ? null : menuaction.trim();
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    public String getUientry() {
        return uientry;
    }

    public void setUientry(String uientry) {
        this.uientry = uientry == null ? null : uientry.trim();
    }

    public String getMenulevel() {
        return menulevel;
    }

    public void setMenulevel(String menulevel) {
        this.menulevel = menulevel;
    }

    public String getRootid() {
        return rootid;
    }

    public void setRootid(String rootid) {
        this.rootid = rootid == null ? null : rootid.trim();
    }

    public String getParentsid() {
        return parentsid;
    }

    public void setParentsid(String parentsid) {
        this.parentsid = parentsid == null ? null : parentsid.trim();
    }

    public String getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(String displayorder) {
        this.displayorder = displayorder;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath == null ? null : imagepath.trim();
    }

    public String getExpandpath() {
        return expandpath;
    }

    public void setExpandpath(String expandpath) {
        this.expandpath = expandpath == null ? null : expandpath.trim();
    }

    public String getMenuseq() {
        return menuseq;
    }

    public void setMenuseq(String menuseq) {
        this.menuseq = menuseq == null ? null : menuseq.trim();
    }

    public String getOpenmode() {
        return openmode;
    }

    public void setOpenmode(String openmode) {
        this.openmode = openmode == null ? null : openmode.trim();
    }

    public Long getSubcount() {
        return subcount;
    }

    public void setSubcount(Long subcount) {
        this.subcount = subcount;
    }

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public String getFunccode() {
        return funccode;
    }

    public void setFunccode(String funccode) {
        this.funccode = funccode == null ? null : funccode.trim();
    }

    
    public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
        AcMenu other = (AcMenu) that;
        return (this.getMenuid() == null ? other.getMenuid() == null : this.getMenuid().equals(other.getMenuid()))
            && (this.getMenuname() == null ? other.getMenuname() == null : this.getMenuname().equals(other.getMenuname()))
            && (this.getMenulabel() == null ? other.getMenulabel() == null : this.getMenulabel().equals(other.getMenulabel()))
            && (this.getMenucode() == null ? other.getMenucode() == null : this.getMenucode().equals(other.getMenucode()))
            && (this.getIsleaf() == null ? other.getIsleaf() == null : this.getIsleaf().equals(other.getIsleaf()))
            && (this.getMenuaction() == null ? other.getMenuaction() == null : this.getMenuaction().equals(other.getMenuaction()))
            && (this.getParameter() == null ? other.getParameter() == null : this.getParameter().equals(other.getParameter()))
            && (this.getUientry() == null ? other.getUientry() == null : this.getUientry().equals(other.getUientry()))
            && (this.getMenulevel() == null ? other.getMenulevel() == null : this.getMenulevel().equals(other.getMenulevel()))
            && (this.getRootid() == null ? other.getRootid() == null : this.getRootid().equals(other.getRootid()))
            && (this.getParentsid() == null ? other.getParentsid() == null : this.getParentsid().equals(other.getParentsid()))
            && (this.getDisplayorder() == null ? other.getDisplayorder() == null : this.getDisplayorder().equals(other.getDisplayorder()))
            && (this.getImagepath() == null ? other.getImagepath() == null : this.getImagepath().equals(other.getImagepath()))
            && (this.getExpandpath() == null ? other.getExpandpath() == null : this.getExpandpath().equals(other.getExpandpath()))
            && (this.getMenuseq() == null ? other.getMenuseq() == null : this.getMenuseq().equals(other.getMenuseq()))
            && (this.getOpenmode() == null ? other.getOpenmode() == null : this.getOpenmode().equals(other.getOpenmode()))
            && (this.getSubcount() == null ? other.getSubcount() == null : this.getSubcount().equals(other.getSubcount()))
            && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
            && (this.getFunccode() == null ? other.getFunccode() == null : this.getFunccode().equals(other.getFunccode()))
            && (this.getParentname() == null ? other.getParentname() == null : this.getParentname().equals(other.getParentname()))
        	&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMenuid() == null) ? 0 : getMenuid().hashCode());
        result = prime * result + ((getMenuname() == null) ? 0 : getMenuname().hashCode());
        result = prime * result + ((getMenulabel() == null) ? 0 : getMenulabel().hashCode());
        result = prime * result + ((getMenucode() == null) ? 0 : getMenucode().hashCode());
        result = prime * result + ((getIsleaf() == null) ? 0 : getIsleaf().hashCode());
        result = prime * result + ((getMenuaction() == null) ? 0 : getMenuaction().hashCode());
        result = prime * result + ((getParameter() == null) ? 0 : getParameter().hashCode());
        result = prime * result + ((getUientry() == null) ? 0 : getUientry().hashCode());
        result = prime * result + ((getMenulevel() == null) ? 0 : getMenulevel().hashCode());
        result = prime * result + ((getRootid() == null) ? 0 : getRootid().hashCode());
        result = prime * result + ((getParentsid() == null) ? 0 : getParentsid().hashCode());
        result = prime * result + ((getDisplayorder() == null) ? 0 : getDisplayorder().hashCode());
        result = prime * result + ((getImagepath() == null) ? 0 : getImagepath().hashCode());
        result = prime * result + ((getExpandpath() == null) ? 0 : getExpandpath().hashCode());
        result = prime * result + ((getMenuseq() == null) ? 0 : getMenuseq().hashCode());
        result = prime * result + ((getOpenmode() == null) ? 0 : getOpenmode().hashCode());
        result = prime * result + ((getSubcount() == null) ? 0 : getSubcount().hashCode());
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        result = prime * result + ((getFunccode() == null) ? 0 : getFunccode().hashCode());
        result = prime * result + ((getParentname() == null) ? 0 : getParentname().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }
}